package com.Robothead4.colinsstuff.container;

import com.Robothead4.colinsstuff.init.ModContainerTypes;
import com.Robothead4.colinsstuff.tileentity.ColinChestTileEntity;
import com.Robothead4.colinsstuff.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.SoundEvents;

import java.util.Objects;

public class ColinChestContainer extends Container {
    public final ColinChestTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public ColinChestContainer(final int windowId, final PlayerInventory playerInventory, final ColinChestTileEntity tileEntity){
        super(ModContainerTypes.COLIN_CHEST.get(),windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

        //slots:
        //main inventory
        int startX = 48; // coordinates of where the first slot starts in gui
        int startY = 47;
        int slotSizePlus2 = 18; // plus2 accounts for borders between slots
        for(int row = 0; row < 4; row++){
            for(int column = 0; column < 9; column++){
                this.addSlot(new Slot(tileEntity,(row * 9) + column, startX + (column * slotSizePlus2),startY + (row * slotSizePlus2)));
            }
        }

        // main player inventory
        int startPlayerInvY = startY + (slotSizePlus2 * 4) + 12;
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 9; column++){
                // index starts at 9 because hotbar has the first 9 index values
                this.addSlot(new Slot(playerInventory,9 + (row * 9) + column, startX + (column * slotSizePlus2), startPlayerInvY + (row * slotSizePlus2)));
            }
        }

        // hotbar
        int hotbarY = startPlayerInvY + (slotSizePlus2 * 3) + 4;
        for(int column = 0; column < 9; column++){
            this.addSlot(new Slot(playerInventory,column, startX + (column * slotSizePlus2), hotbarY));
        }
    }

    private static ColinChestTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data){
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if(tileAtPos instanceof ColinChestTileEntity){
            return (ColinChestTileEntity)tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    public ColinChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data){
        this(windowId,playerInventory,getTileEntity(playerInventory,data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, RegistryHandler.COLIN_CHEST_BLOCK.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack()){
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if(index < 36){
                if(!this.mergeItemStack(itemStack1,36,this.inventorySlots.size(),true)){
                    return ItemStack.EMPTY;
                }
            }
            else if(!this.mergeItemStack(itemStack1,0,36,false)){
                return ItemStack.EMPTY;
            }

            if(itemStack1.isEmpty()){
                slot.putStack(ItemStack.EMPTY);
            }
            else{
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }

    @Override
    public void onContainerClosed(PlayerEntity playerIn) {
        this.canInteractWithCallable.consume((world,pos) -> {
            TileEntity tile = world.getTileEntity(pos);
            ColinChestTileEntity colinChestTileEntity = (ColinChestTileEntity)tile;
            if(!playerIn.isSpectator()){
                colinChestTileEntity.numPlayersUsing--;
            }
            if(colinChestTileEntity.numPlayersUsing <= 0){
                colinChestTileEntity.playSound(SoundEvents.BLOCK_CHEST_CLOSE);
            }
        });
    }
}

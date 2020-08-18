package com.Robothead4.colinsstuff.blocks;

import com.Robothead4.colinsstuff.tileentity.ColinChestTileEntity;
import com.Robothead4.colinsstuff.tileentity.ModTileEntityTypes;
import com.Robothead4.colinsstuff.util.RegistryHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.rmi.registry.Registry;

public class ColinChestBlock extends Block {

    public ColinChestBlock() {
        super(AbstractBlock.Properties.from(RegistryHandler.COLIN_BLOCK.get()));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.COLIN_CHEST.get().create();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult result) {
        if(!worldIn.isRemote){
            TileEntity tile = worldIn.getTileEntity(pos);
            if(tile instanceof ColinChestTileEntity){
                NetworkHooks.openGui((ServerPlayerEntity)player, (ColinChestTileEntity)tile,pos);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.FAIL;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if(state.getBlock() != newState.getBlock()){
            TileEntity te = worldIn.getTileEntity(pos);
            if(te instanceof ColinChestTileEntity){
                InventoryHelper.dropItems(worldIn,pos,((ColinChestTileEntity)te).getItems());
            }
        }
    }
}

package com.Robothead4.colinsstuff.items;

import com.Robothead4.colinsstuff.ColinsStuff;
import com.Robothead4.colinsstuff.util.RegistryHandler;
import com.Robothead4.colinsstuff.util.helpers.KeyboardHelper;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.rmi.registry.Registry;
import java.util.List;

public class ColinGem extends Item
{
    public static boolean grounded = true;
    public ColinGem()
    {
        super(new Item.Properties().group(ColinsStuff.COLIN_TAB));
    }

    //gives item that enchanted look in inventory
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    // adds info if user holding shift over item
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyboardHelper.isHoldingShift())
        {
            tooltip.add(new StringTextComponent("What a cool looking gem"));
        }
        else
        {
            tooltip.add(new StringTextComponent("\u00A76" + "Hold shift for more info"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    //activates when item is right clicked
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //worldIn.setBlockState(new BlockPos(playerIn.getPosX(),playerIn.getPosY() - 1,playerIn.getPosZ()), Blocks.BEDROCK.getDefaultState());
        //playerIn.addPotionEffect(new EffectInstance(Effects.LEVITATION, 300,0));
        if(worldIn.getRainStrength(1.0F) != 0.0F)
        {
            worldIn.setRainStrength(0.0F);
        }
        else
        {
            worldIn.setRainStrength(1.0F);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    //changes behavior when item hits ground (grounded implementation makes it so
    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if(entity.getEntityWorld().getBlockState(new BlockPos(entity.getPosX(),entity.getPosY() - 1,entity.getPosZ())) != Blocks.AIR.getDefaultState() && grounded == false)
        {
            entity.getEntityWorld().setBlockState(new BlockPos(entity.getPosX(),entity.getPosY() - 1,entity.getPosZ()), RegistryHandler.COLIN_BLOCK.get().getDefaultState());
            grounded = true;

        };

        if(entity.getEntityWorld().getBlockState(new BlockPos(entity.getPosX(),entity.getPosY() - 1,entity.getPosZ())) == Blocks.AIR.getDefaultState())
        {
            grounded = false;
        }
        return false;
    }

}

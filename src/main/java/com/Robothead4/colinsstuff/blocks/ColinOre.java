package com.Robothead4.colinsstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class ColinOre extends OreBlock
{
    public ColinOre()
    {
        // hardnessAndResistance is time it takes to mine and explosion resistance respectively
        // sound sets sound of walking and breaking block
        // harvestLevel is what pickaxe it takes to break it
        // 0 = wooden pickaxe
        // 1 = stone pickaxe
        // 2 = iron pickaxe
        // 3 = diamond pickaxe
        // 4 = ??? (try changing the harvest level of a pickaxe class)
        // -1 = unbreakable like bedrock
        // harvestTool sets what kind of tool needed to break
        // see Properties for more
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.0F,6.0F)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        if(silktouch ==0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}

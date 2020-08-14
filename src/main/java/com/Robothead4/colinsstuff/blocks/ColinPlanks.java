package com.Robothead4.colinsstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ColinPlanks extends Block
{
    public ColinPlanks()
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
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(4.0F,1.5F)
                .sound(SoundType.WOOD)
                .harvestTool(ToolType.AXE)
                .harvestLevel(0)
                .setRequiresTool()
        );
    }
}

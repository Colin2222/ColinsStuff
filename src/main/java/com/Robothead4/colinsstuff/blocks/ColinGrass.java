package com.Robothead4.colinsstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;

public class ColinGrass extends GrassBlock {
    public ColinGrass() {
        super(Block.Properties.create(Material.EARTH)
                        .hardnessAndResistance(1.0F,1.0F)
                        .sound(SoundType.GROUND)
                        .harvestTool(ToolType.SHOVEL)
                        .harvestLevel(1)
                        .setRequiresTool()
                //.speedFactor(2.0F)
        );
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }
}

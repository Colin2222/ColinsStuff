package com.Robothead4.colinsstuff.blocks;

import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class ColinLeaves extends LeavesBlock {
    public ColinLeaves() {
        super(AbstractBlock.Properties.from(Blocks.OAK_LEAVES));
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 30;
    }
}

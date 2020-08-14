package com.Robothead4.colinsstuff.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;

import net.minecraft.item.BlockItemUseContext;

import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class ColinLog extends RotatedPillarBlock {

    //public static final DirectionProperty FACING =  HorizontalBlock.HORIZONTAL_FACING;
    public ColinLog() {


        super(AbstractBlock.Properties.from(Blocks.OAK_LOG));
        //this.setDefaultState(this.stateContainer.getBaseState().with(FACING,Direction.NORTH));


    }
    /*@Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder){
        builder.add(FACING);

    }
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }*/

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 5;
    }
}

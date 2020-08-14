package com.Robothead4.colinsstuff.blocks;


import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class ColinCube extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Block.makeCuboidShape(3, 0, 6, 13, 7, 10);
    private static final VoxelShape SHAPE_E = Block.makeCuboidShape(6, 0, 3, 10, 7, 13);
    private static final VoxelShape SHAPE_S = Block.makeCuboidShape(3, 0, 6, 13, 7, 10);
    private static final VoxelShape SHAPE_W = Block.makeCuboidShape(6, 0, 3, 10, 7, 13);

    public ColinCube() {
        super(Block.Properties.create(Material.IRON)
                        .hardnessAndResistance(5.0F,6.0F)
                        .sound(SoundType.GLASS)
                        .harvestTool(ToolType.PICKAXE)
                        .harvestLevel(3)
                        .setRequiresTool()
                //.speedFactor(2.0F)
        );
    }



    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    //places block in opposite direction that the player is facing
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    //this and mirror are basically only for compatability with other mods if they want to rotate block
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    // tells what property block has
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    //remote = client
    //not remote = server
    /*@Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote)
        {
            ServerWorld serverWorld = (ServerWorld)worldIn;
            LightningBoltEntity entity = new LightningBoltEntity()
            serverWorld.addEntity(entity);
        }
    }*/
}

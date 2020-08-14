package com.Robothead4.colinsstuff.blocks;

import com.Robothead4.colinsstuff.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class ColinQuarryBlock extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public ColinQuarryBlock() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(4.0F,1.5F)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.AXE)
                .harvestLevel(0)
                .setRequiresTool()
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder){
        builder.add(FACING);

    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RegistryHandler.COLIN_QUARRY.get().create();
    }

}

package com.Robothead4.colinsstuff.blocks;

import com.Robothead4.colinsstuff.ColinsStuff;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.gen.surfacebuilders.GiantTreeTaigaSurfaceBuilder;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ColinBlock extends Block
{
    public ColinBlock()
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
                .hardnessAndResistance(5.0F,6.0F)
                .sound(SoundType.GLASS)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(3)
                .setRequiresTool()
                //.speedFactor(2.0F)
        );
    }
    @Override
    public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, EntitySpawnPlacementRegistry.PlacementType type, EntityType<?> entityType) {
        return true;
    }

    @Override
    public boolean canSpawnInBlock() {
        return true;
    }
}

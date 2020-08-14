package com.Robothead4.colinsstuff.blocks.trees;

import com.Robothead4.colinsstuff.util.RegistryHandler;
import com.Robothead4.colinsstuff.world.feature.ColinTreeFeature;
import com.mojang.serialization.Codec;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

import java.util.Random;

public class ColinTree extends Tree {

    public static final BaseTreeFeatureConfig COLIN_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.COLIN_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RegistryHandler.COLIN_LEAVES.get().getDefaultState()),
            // blobfoliageplacer:
            // 1: direct correlation with height of stump (ish??)
            // 2: ??
            // 3:
            // 4:
            // 5:
            new BlobFoliagePlacer(8, 4,4,2,3),null,null))
            .build();

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean beehiveIn) {
        return RegistryHandler.COLIN_TREE.withConfiguration(COLIN_TREE_CONFIG);
    }
}

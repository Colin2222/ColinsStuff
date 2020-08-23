package com.Robothead4.colinsstuff.world.biome;

import com.Robothead4.colinsstuff.blocks.trees.ColinTree;
import com.Robothead4.colinsstuff.util.RegistryHandler;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.DefaultSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.awt.*;


public class ColinFieldsBiome extends ColinBiome{

    public ColinFieldsBiome() {
        super(new DefaultSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_),
                new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState()),
                Category.FOREST,
                0.1F,
                0.2F,
                0.8F,
                new Color(0, 0, 0).getRGB(),
                SoundEvents.AMBIENT_WARPED_FOREST_LOOP,
                new ParticleEffectAmbience(ParticleTypes.FALLING_LAVA, 0.025F)
        );

    }

    @Override
    public void addFeatures() {
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, RegistryHandler.COLIN_TREE.withConfiguration(ColinTree.COLIN_TREE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3000))));
        DefaultBiomeFeatures.addCarvers(this);
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.COLIN_ORE.get().getDefaultState(), 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(double posX, double posZ) {
        return new Color(255, 102, 0).getRGB();
    }

    @Override
    public int getSkyColor() {
        return new Color(0,0,0).getRGB();
    }
}

package com.Robothead4.colinsstuff.world.biome;

import com.Robothead4.colinsstuff.blocks.trees.ColinTree;
import com.Robothead4.colinsstuff.util.RegistryHandler;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.awt.*;

public abstract class ColinBiome extends Biome {
    public ColinBiome(SurfaceBuilder<SurfaceBuilderConfig> surface, SurfaceBuilderConfig config, Biome.Category category, float depth, float scale, float temp, int skyColor, SoundEvent ambiance, ParticleEffectAmbience ambientParticle) {
        super((new Biome.Builder())
                .surfaceBuilder(surface, config)
                .precipitation(Biome.RainType.NONE)
                .category(category)
                .depth(depth)
                .scale(scale)
                .temperature(temp)
                .downfall(0)
                .func_235097_a_((new BiomeAmbience.Builder())
                        .func_235240_a_(new BackgroundMusicSelector(SoundEvents.MUSIC_DISC_STAL, 12000, 24000, true))//bgm
                        .func_235246_b_(new Color(255, 102, 0).getRGB())//water
                        .func_235248_c_(new Color(255, 102, 0).getRGB())//water fog
                        .func_235239_a_(skyColor)//sky fog
                        .func_235241_a_(ambiance)//ambiance
                        .func_235244_a_(ambientParticle)//ambient particle
                        .func_235238_a_())//probably .build()
                .func_235098_a_(ImmutableList.of(new Biome.Attributes(0.0F, 0.0F, 0.0F, 0.0F, 0.0F)))
                .parent((null))
        );

        addFeatures();
    }

    public abstract void addFeatures();

}

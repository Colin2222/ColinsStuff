package com.Robothead4.colinsstuff.world.biome;

import com.Robothead4.colinsstuff.blocks.trees.ColinTree;
import com.Robothead4.colinsstuff.util.RegistryHandler;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ColinBiome extends Biome {
    public ColinBiome() {
        super((new Biome.Builder())
        //surfaceBuilderConfig:
                // 1: top block (ex: grass)
                // 2: below top block (ex: dirt)
                // 3: under water
        // category = what biomes the custom one will try to be spawned next to
        // precipitation = what comes down when it rains
        // downfall = how often it rains
        // scale = craziness/sharpness of biome altitude (0.0 = plains basically, 1 = mountains)
        // temperature = will ice melt? (basically)
        // depth = block height of biome
        // func_235097_a_ =
        //      1: water color (decimal
             // 2: underwater fog color
             // 3: fog color
             // 4:
        // parent: parent of biome (bamboo forest has parent of jungle) (can be null to be standalone)
                .surfaceBuilder(new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
                RegistryHandler.COLIN_GRASS_BLOCK.get().getDefaultState(), RegistryHandler.COLIN_ORE.get().getDefaultState(), Blocks.BLACKSTONE.getDefaultState())))
        .category(Category.PLAINS)
        .precipitation(RainType.SNOW)
        .downfall(0.8F)
        .scale(0.12F)
        .temperature(0.5F)
        .depth(0.115F)
                .func_235097_a_((new BiomeAmbience.Builder())
                        .func_235246_b_(16744192)
                        .func_235248_c_(16744192)
                        .func_235239_a_(16744192)
                        .func_235243_a_(MoodSoundAmbience.field_235027_b_)
                        .func_235238_a_())
                .parent((String)null));


        // SpawnListEntry
        // EntityType is what entity is spawned naturally
        // weight is how often they spawn (7-15 recommended for animals)
        // next two are min and max group sizes for each spawn
        // make sure canCreatureSpawn is overridden on top block of surfacebuilder

        //DefaultBiomeFeatures.addForestTrees(this);
        //this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(DefaultBiomeFeatures.field_230129_h_).withChance(0.2F), Feature.field_236291_c_.withConfiguration(DefaultBiomeFeatures.field_230131_m_).withChance(0.1F)), Feature.field_236291_c_.withConfiguration(DefaultBiomeFeatures.field_230132_o_))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
        //this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 19,2,4));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, RegistryHandler.COLIN_TREE.withConfiguration(ColinTree.COLIN_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(4,0.1F,1))));

        //DefaultBiomeFeatures
        // carver = caves
        // feature = grass,flowers,trees, (structures??)
        // spawn = entities
    }

}

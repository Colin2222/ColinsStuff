package com.Robothead4.colinsstuff.world.gen;

import com.Robothead4.colinsstuff.ColinsStuff;
import com.Robothead4.colinsstuff.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ColinsStuff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGenHandler
{
    //adds end stone as an option as a filler block/ block that ore can generate in
    public static OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("END_STONE","end_stone", new BlockMatcher(Blocks.END_STONE));

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event)
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {

            // nether gen
            if(biome.getCategory() == Biome.Category.NETHER)
            {
                genOre(biome,15, 5,5,90, OreFeatureConfig.FillerBlockType.NETHERRACK, RegistryHandler.COLIN_ORE.get().getDefaultState(), 10);

            }
            // end gen
            if(biome.getCategory() == Biome.Category.THEEND)
            {
                genOre(biome,15, 20,5,65, END_STONE, RegistryHandler.COLIN_ORE.get().getDefaultState(), 10);

            }
            //overworld gen
            else
            {
                //if(biome == Biomes.DESERT{}
                //insert genOre into brackets to make the ore gen biome specific
                // 20 to 60
                genOre(biome,15, 20,5,65, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.COLIN_ORE.get().getDefaultState(), 10);
            }

        }
    }
    // biome = biome of ore (none specified = overworld)
    // count = how common the ore is
    // bottomOffset = minimum y level of ore gen
    // topOffset = maximum y level of ore gen subtracted from max
    // max = max y level
    // filler = what kind of block the ore can replace
    // defaultBlockState = (.getDefaultState()) of ore block to gen
    // size = max size of vein
    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size)
    {
        CountRangeConfig range = new CountRangeConfig(count,bottomOffset,topOffset,max);
        OreFeatureConfig feature = new OreFeatureConfig(filler,defaultBlockState,size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}

package com.Robothead4.colinsstuff.world.biome;

import com.Robothead4.colinsstuff.ColinsStuff;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ColinsStuff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,ColinsStuff.MOD_ID);

    public static final RegistryObject<Biome> COLIN_FIELDS_BIOME = BIOMES.register("colin_fields_biome",() -> new ColinFieldsBiome());

    public static void registerBiomesToDictionary(){
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(COLIN_FIELDS_BIOME.get(),9));
    }

    public static void addBiomeTypes(){
        BiomeDictionary.addTypes(COLIN_FIELDS_BIOME.get(),BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    }
}



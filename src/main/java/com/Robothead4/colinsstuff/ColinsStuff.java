package com.Robothead4.colinsstuff;

import com.Robothead4.colinsstuff.util.RegistryHandler;
import com.Robothead4.colinsstuff.world.biome.ModBiomes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("cs")
public class ColinsStuff
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "cs";

    public ColinsStuff() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        DeferredWorkQueue.runLater(() ->{
            ModBiomes.addBiomeTypes();
            ModBiomes.registerBiomesToDictionary();
        });
    }


    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    //could make a custom class that extends ItemGroup, but
    // not totally necessary since ill probs only make one tab
    public static final ItemGroup COLIN_TAB = new ItemGroup("colinTab")
    {
        //overrides the method that sets the icon that represents the tab in game
        //use Items or Blocks to use icons from the base minecraft game
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(RegistryHandler.COLIN_INGOT.get());
        }
    };
}

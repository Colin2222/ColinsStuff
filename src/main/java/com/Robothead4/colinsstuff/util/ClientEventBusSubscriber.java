package com.Robothead4.colinsstuff.util;

import com.Robothead4.colinsstuff.ColinsStuff;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ColinsStuff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber
{
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        RenderTypeLookup.setRenderLayer(RegistryHandler.COLIN_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.COLIN_SAPLING.get(), RenderType.getCutout());
    }
}

package com.Robothead4.colinsstuff.events;

import com.Robothead4.colinsstuff.ColinsStuff;
import com.Robothead4.colinsstuff.util.TimeKeeper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.SleepFinishedTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = ColinsStuff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BedSleepEvent extends SleepFinishedTimeEvent{
    public BedSleepEvent(ServerWorld worldIn) {
        super(worldIn, 1,0);
    }
}
package com.Robothead4.colinsstuff.events;

import com.Robothead4.colinsstuff.ColinsStuff;
import com.Robothead4.colinsstuff.util.TimeKeeper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = ColinsStuff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TimeKeeperEvents {
    private static boolean gtg = true;
    @SubscribeEvent
    public static void OnTickEvent(TickEvent.WorldTickEvent tickEvent){
        if(tickEvent.world.getDayTime() == 100L && gtg){
            TimeKeeper.increaseDay(1);
            List<? extends PlayerEntity> playerList = new ArrayList<>(tickEvent.world.getPlayers());
            for(int i = 0; i < playerList.size(); i++){
                playerList.get(i).sendMessage(ITextComponent.func_241827_a_("Day " + TimeKeeper.daysPassed),playerList.get(i).getUniqueID());
            }
            gtg = false;
        }
        if(tickEvent.world.getDayTime() == 20L){
            gtg = true;
        }
    }
}

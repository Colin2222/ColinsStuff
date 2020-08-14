package com.Robothead4.colinsstuff.events;

import com.Robothead4.colinsstuff.ColinsStuff;
import com.Robothead4.colinsstuff.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//Mod.EventBusSubscriber(modid = ColinsStuff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TestJumpEvent
{
    @SubscribeEvent
    public static void testJumpEvent(LivingEvent.LivingJumpEvent event)
    {
        //ColinsStuff.LOGGER.info("testJumpEvent fired");

        LivingEntity livingEntity = event.getEntityLiving();
        World world = livingEntity.getEntityWorld();
        //sets block to be colin block 5 blocks above jumping entity
        world.setBlockState(new BlockPos(livingEntity.getPosX(),livingEntity.getPosY() + 5,livingEntity.getPosZ()), RegistryHandler.COLIN_BLOCK.get().getDefaultState());
        //gives jumping entity potion effect
        livingEntity.addPotionEffect(new EffectInstance(Effects.SPEED,300,0));

        // see what else you can change with the entity/try other events
    }
}

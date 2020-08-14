package com.Robothead4.colinsstuff.items;

import com.Robothead4.colinsstuff.ColinsStuff;
import javafx.scene.effect.Effect;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

public class ColinSoup extends Item {
    public ColinSoup() {
        super(new Item.Properties()
            .group(ColinsStuff.COLIN_TAB)
            .food(new Food.Builder()
                    .hunger(3)
                    .saturation(2.0F)
                    //effect constructor: effect, ticks lasted, level of potion (amplifier), (outside parenthese) probability for effect
                    .effect(() ->new EffectInstance(Effects.SPEED,300,1), 1F)
                    .setAlwaysEdible()
                    .build())


        );
    }

    @Override
    public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.DRINK;
    }
}

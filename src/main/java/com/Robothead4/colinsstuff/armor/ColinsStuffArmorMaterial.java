package com.Robothead4.colinsstuff.armor;

import com.Robothead4.colinsstuff.ColinsStuff;
import com.Robothead4.colinsstuff.util.RegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ColinsStuffArmorMaterial implements IArmorMaterial {
    //can copy and past below to make more armor materials
    //string tag, durability, damage absorbing for boots, pants, chest, helm,
    //enchantability, equip sound, toughness, repair material
    COLIN(ColinsStuff.MOD_ID + ":colin", 25, new int[] {2,4,5,3}, 15,
            SoundEvents.BLOCK_NOTE_BLOCK_XYLOPHONE, 0.0F, () -> {return Ingredient.fromItems(RegistryHandler.COLIN_INGOT.get()); }, 0);

    private static final int[] MAX_DAMAGE_ARRAY = new int[] {11,16,15,13};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReduction;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResistance;

    ColinsStuffArmorMaterial(String name, int maxDamageFactor, int[] damageReduction
            , int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance)
    {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReduction = damageReduction;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResistance = knockbackResistance;
    }
    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return 25;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReduction[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    // use.get() since i dont want the supplier, i want the actual ingredient
    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    //knockback resistance (unmapped so far)
    @Override
    public float func_230304_f_() {
        return this.knockbackResistance;
    }
}

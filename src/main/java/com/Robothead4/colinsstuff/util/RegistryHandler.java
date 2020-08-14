package com.Robothead4.colinsstuff.util;

import com.Robothead4.colinsstuff.ColinsStuff;
import com.Robothead4.colinsstuff.armor.ColinsStuffArmorMaterial;
import com.Robothead4.colinsstuff.blockitems.BlockItemBase;
import com.Robothead4.colinsstuff.blocks.*;
import com.Robothead4.colinsstuff.blocks.trees.ColinTree;
import com.Robothead4.colinsstuff.items.ColinFuel;
import com.Robothead4.colinsstuff.items.ColinGem;
import com.Robothead4.colinsstuff.items.ColinSoup;
import com.Robothead4.colinsstuff.items.ItemBase;
import com.Robothead4.colinsstuff.tileentity.ColinQuarryTileEntity;
import com.Robothead4.colinsstuff.tools.ColinsStuffItemTier;
import com.Robothead4.colinsstuff.world.biome.ColinBiome;
import com.Robothead4.colinsstuff.world.biome.ColinFieldsBiome;
import com.Robothead4.colinsstuff.world.feature.ColinTreeFeature;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.Tree;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class RegistryHandler
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ColinsStuff.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ColinsStuff.MOD_ID);
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, ColinsStuff.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ColinsStuff.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,ColinsStuff.MOD_ID);

    //will fill up with blocks,entities,other stuff
    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    // can make separate classes to initialize different groups to do:
    //   make public static final List<Item> ITEMS ArrayList, add all the items into it
    // Items
    public static final RegistryObject<Item> COLIN_INGOT = ITEMS.register("colin_ingot", ItemBase::new);
    public static final RegistryObject<Item> COLIN_DUST = ITEMS.register("colin_dust", ItemBase::new);
    public static final RegistryObject<Item> COLIN_NUGGET = ITEMS.register("colin_nugget", ItemBase::new);
    public static final RegistryObject<Item> COLIN_COAL = ITEMS.register("colin_coal", ColinFuel::new);
    public static final RegistryObject<Item> COLIN_GEM = ITEMS.register("colin_gem", ColinGem::new);

    //Food
    public static final RegistryObject<ColinSoup> COLIN_SOUP = ITEMS.register("colin_soup", ColinSoup::new);



    // Blocks
    public static final RegistryObject<Block> COLIN_BLOCK = BLOCKS.register("colin_block", ColinBlock::new);
    public static final RegistryObject<Block> COLIN_ORE = BLOCKS.register("colin_ore", ColinOre::new);
    public static final RegistryObject<Block> COLIN_PLANKS = BLOCKS.register("colin_planks", ColinPlanks::new);
    public static final RegistryObject<Block> COLIN_LOG = BLOCKS.register("colin_log", ColinLog::new);
    public static final RegistryObject<Block> COLIN_LEAVES = BLOCKS.register("colin_leaves", ColinLeaves::new);
    public static final RegistryObject<Block> COLIN_SAPLING = BLOCKS.register("colin_sapling",() -> new ModSaplingBlock(ColinTree::new,AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.ORANGE_TERRACOTTA).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT)));
    public static final RegistryObject<Block> COLIN_CUBE = BLOCKS.register("colin_cube", ColinCube::new);
    public static final RegistryObject<Block> COLIN_QUARRY_BLOCK = BLOCKS.register("colin_quarry", ColinQuarryBlock::new);
    public static final RegistryObject<Block> COLIN_GRASS_BLOCK = BLOCKS.register("colin_grass_block", ColinGrass::new);

    // Trees
    public static final Feature<BaseTreeFeatureConfig> COLIN_TREE = new ColinTreeFeature(BaseTreeFeatureConfig.field_236676_a_);

    // Biomes
    public static final RegistryObject<Biome> COLIN_BIOME = BIOMES.register("colin_fields_biome",() -> new ColinFieldsBiome());

    // Tile Entity types
    //public static final RegistryObject<TileEntityType<ColinQuarry>> COLIN_QUARRY = TILE_ENTITY_TYPES.register("colin_quarry", () -> TileEntityType.Builder.build(ColinQuarry::new, RegistryHandler.COLIN_QUARRY_BLOCK).build(null));
    public static final RegistryObject<TileEntityType<ColinQuarryTileEntity>> COLIN_QUARRY = TILE_ENTITY_TYPES.register("colin_quarry",
            () -> TileEntityType.Builder.create(ColinQuarryTileEntity::new, RegistryHandler.COLIN_QUARRY_BLOCK.get()).build(null));

    //BlockItems
    public static final RegistryObject<Item> COLIN_BLOCK_ITEM = ITEMS.register("colin_block", () -> new BlockItemBase(COLIN_BLOCK.get()));
    public static final RegistryObject<Item> COLIN_ORE_ITEM = ITEMS.register("colin_ore", () -> new BlockItemBase(COLIN_ORE.get()));
    public static final RegistryObject<Item> COLIN_PLANKS_ITEM = ITEMS.register("colin_planks", () -> new BlockItemBase(COLIN_PLANKS.get()));
    public static final RegistryObject<Item> COLIN_LOG_ITEM = ITEMS.register("colin_log", () -> new BlockItemBase(COLIN_LOG.get()));
    public static final RegistryObject<Item> COLIN_LEAVES_ITEM = ITEMS.register("colin_leaves", () -> new BlockItemBase(COLIN_LEAVES.get()));
    public static final RegistryObject<Item> COLIN_SAPLING_ITEM = ITEMS.register("colin_sapling", () -> new BlockItemBase(COLIN_SAPLING.get()));
    public static final RegistryObject<Item> COLIN_CUBE_ITEM = ITEMS.register("colin_cube", ()-> new BlockItemBase(COLIN_CUBE.get()));
    public static final RegistryObject<Item> COLIN_QUARRY_ITEM = ITEMS.register("colin_quarry", ()-> new BlockItemBase(COLIN_QUARRY_BLOCK.get()));
    public static final RegistryObject<Item> COLIN_GRASS_BLOCK_ITEM = ITEMS.register("colin_grass_block", () -> new BlockItemBase(COLIN_GRASS_BLOCK.get()));

    //Tools
    // material, base attack damage, attack speed change from 4, item group (creative tab)
    public static final RegistryObject<SwordItem> COLIN_SWORD = ITEMS.register("colin_sword", () ->
            new SwordItem(ColinsStuffItemTier.COLIN, 6,-2.5F, new Item.Properties().group(ColinsStuff.COLIN_TAB)));
    public static final RegistryObject<PickaxeItem> COLIN_PICKAXE = ITEMS.register("colin_pickaxe", () ->
            new PickaxeItem(ColinsStuffItemTier.COLIN, 2, -2.5F, new Item.Properties().group(ColinsStuff.COLIN_TAB)));
    public static final RegistryObject<AxeItem> COLIN_AXE = ITEMS.register("colin_axe", () ->
            new AxeItem(ColinsStuffItemTier.COLIN,5, -3.0F, new Item.Properties().group(ColinsStuff.COLIN_TAB)));
    public static final RegistryObject<HoeItem> COLIN_HOE = ITEMS.register("colin_hoe", () ->
            new HoeItem(ColinsStuffItemTier.COLIN, 2, -2.5F, new Item.Properties().group(ColinsStuff.COLIN_TAB)));
    public static final RegistryObject<ShovelItem> COLIN_SHOVEL = ITEMS.register("colin_shovel", () ->
            new ShovelItem(ColinsStuffItemTier.COLIN, 2, -2.5F, new Item.Properties().group(ColinsStuff.COLIN_TAB)));

    // Armor
    // material type, body slot
    public static final RegistryObject<ArmorItem> COLIN_HELMET = ITEMS.register("colin_helmet", () ->
            new ArmorItem(ColinsStuffArmorMaterial.COLIN, EquipmentSlotType.HEAD, new Item.Properties().group(ColinsStuff.COLIN_TAB)));
    public static final RegistryObject<ArmorItem> COLIN_CHESTPLATE = ITEMS.register("colin_chestplate", () ->
            new ArmorItem(ColinsStuffArmorMaterial.COLIN, EquipmentSlotType.CHEST, new Item.Properties().group(ColinsStuff.COLIN_TAB)));
    public static final RegistryObject<ArmorItem> COLIN_LEGGINGS = ITEMS.register("colin_leggings", () ->
            new ArmorItem(ColinsStuffArmorMaterial.COLIN, EquipmentSlotType.LEGS, new Item.Properties().group(ColinsStuff.COLIN_TAB)));
    public static final RegistryObject<ArmorItem> COLIN_BOOTS = ITEMS.register("colin_boots", () ->
            new ArmorItem(ColinsStuffArmorMaterial.COLIN, EquipmentSlotType.FEET, new Item.Properties().group(ColinsStuff.COLIN_TAB)));

    //Container Types
    //public static final
}

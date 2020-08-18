package com.Robothead4.colinsstuff.tileentity;

import com.Robothead4.colinsstuff.ColinsStuff;
import com.Robothead4.colinsstuff.util.RegistryHandler;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ColinsStuff.MOD_ID);

    public static final RegistryObject<TileEntityType<ColinQuarryTileEntity>> COLIN_QUARRY = TILE_ENTITY_TYPES.register("colin_quarry",
            () -> TileEntityType.Builder.create(ColinQuarryTileEntity::new, RegistryHandler.COLIN_QUARRY_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<ColinChestTileEntity>> COLIN_CHEST = TILE_ENTITY_TYPES.register("colin_chest", () -> TileEntityType.Builder.create(ColinChestTileEntity::new, RegistryHandler.COLIN_CHEST_BLOCK.get()).build(null));
}

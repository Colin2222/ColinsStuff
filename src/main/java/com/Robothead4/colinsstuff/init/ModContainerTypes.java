package com.Robothead4.colinsstuff.init;

import com.Robothead4.colinsstuff.ColinsStuff;
import com.Robothead4.colinsstuff.container.ColinChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, ColinsStuff.MOD_ID);

    public static final RegistryObject<ContainerType<ColinChestContainer>> COLIN_CHEST = CONTAINER_TYPES.register("colin_chest",() -> IForgeContainerType.create(ColinChestContainer::new));
}

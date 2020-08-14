package com.Robothead4.colinsstuff.items;

import com.Robothead4.colinsstuff.ColinsStuff;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ColinFuel extends Item {
    public ColinFuel()
    {
        super(new Item.Properties().group(ColinsStuff.COLIN_TAB));
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        return 500;
    }
}

package com.Robothead4.colinsstuff.blockitems;

import com.Robothead4.colinsstuff.ColinsStuff;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem
{
    public BlockItemBase(Block blockIn) {
        super(blockIn, new Item.Properties().group(ColinsStuff.COLIN_TAB));
    }
}

package com.Robothead4.colinsstuff.util;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.storage.WorldSavedData;

public class TimeSaver extends WorldSavedData {
    public static final String IDENTIFIER = "days";

    public TimeSaver(){
        this(IDENTIFIER);
    }

    public TimeSaver(String identifier) {
        super(identifier);
    }

    @Override
    public void read(CompoundNBT nbt) {
        TimeKeeper.daysPassed = nbt.getInt("DaysPassed");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("DaysPassed",TimeKeeper.daysPassed);
        return compound;
    }
}

package com.Robothead4.colinsstuff.util.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyboardHelper
{
    private static final long WINDOW = Minecraft.getInstance().getMainWindow().getHandle();
    //checks if player is holding shift
    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingShift()
    {
        return InputMappings.isKeyDown(WINDOW,GLFW.GLFW_KEY_LEFT_SHIFT) || InputMappings.isKeyDown(WINDOW,GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingCtrl()
    {
        return InputMappings.isKeyDown(WINDOW,GLFW.GLFW_KEY_LEFT_CONTROL) || InputMappings.isKeyDown(WINDOW,GLFW.GLFW_KEY_RIGHT_CONTROL);
    }
}

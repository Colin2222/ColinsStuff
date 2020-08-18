package com.Robothead4.colinsstuff.gui;

import com.Robothead4.colinsstuff.ColinsStuff;
import com.Robothead4.colinsstuff.container.ColinChestContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ColinChestScreen extends ContainerScreen<ColinChestContainer> {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ColinsStuff.MOD_ID,"textures/gui/colin_chest.png");

    public ColinChestScreen(ColinChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn){
        super(screenContainer,inv,titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        // texture size
        this.xSize = 256;
        this.ySize = 256;
    }

    @Override
    public void render(MatrixStack p_230430_1_, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(p_230430_1_);
        super.render(p_230430_1_,mouseX,mouseY,partialTicks);
        this.func_230459_a_(p_230430_1_, mouseX,mouseY);
    }

    @Override
    protected void func_230451_b_(MatrixStack matrixStack, int mouseX, int mouseY) {
        //super.func_230451_b_(matrixStack, mouseX, mouseY);
        this.font.drawString(matrixStack,this.title.getString(),48.0F,36.0F,4210752);
        this.font.drawString(matrixStack,this.playerInventory.getDisplayName().getString(),48.0F,120.0F,4210752);
    }

    @Override
    protected void func_230450_a_(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        blit(p_230450_1_, x, y, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
    }
}

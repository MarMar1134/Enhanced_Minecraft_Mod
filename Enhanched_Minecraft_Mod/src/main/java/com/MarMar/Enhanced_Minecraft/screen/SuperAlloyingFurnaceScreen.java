package com.MarMar.Enhanced_Minecraft.screen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SuperAlloyingFurnaceScreen extends AbstractContainerScreen<SuperAlloyingFurnaceMenu> {
    private static final ResourceLocation Texture =
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "textures/gui/super_alloying_furnace_gui.png");
    public SuperAlloyingFurnaceScreen(SuperAlloyingFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 74;

        this.titleLabelX = 32;
        this.titleLabelY = 5;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, Texture);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(Texture, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
        renderFire(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(Texture, x + 80, y + 35, 176, 14, menu.getScaledProgress(), 16);
        }
    }

    private void renderFire(GuiGraphics guiGraphics, int x, int y){
        if(menu.isBurning()){
            guiGraphics.blit(Texture, x + 57, y + 37, 176, 0, 13, menu.getFireDecrease());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}

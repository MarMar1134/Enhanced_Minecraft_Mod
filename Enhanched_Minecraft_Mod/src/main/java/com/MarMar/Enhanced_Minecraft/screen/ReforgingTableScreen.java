package com.MarMar.Enhanced_Minecraft.screen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.CraftingScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.Slot;

public class ReforgingTableScreen extends CraftingScreen {
    private static final ResourceLocation Reforging_gui = new ResourceLocation(
            Enhanced_Minecraft.MOD_ID, "textures/gui/reforging_table_gui.png");
    public ReforgingTableScreen(CraftingMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 74;

        this.titleLabelX = 40;
        this.titleLabelY = 5;
    }
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, Reforging_gui);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(Reforging_gui, x, y, 0, 0, imageWidth, imageHeight);

    }
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        if (this.getRecipeBookComponent().mouseClicked(pMouseX, pMouseY, pButton)) {
            this.setFocused(this.getRecipeBookComponent());
            return true;
        } else {
            return this.getRecipeBookComponent().isVisible() ? true : super.mouseClicked(pMouseX, pMouseY, pButton);
        }
    }
    protected void slotClicked(Slot pSlot, int pSlotId, int pMouseButton, ClickType pType) {
        super.slotClicked(pSlot, pSlotId, pMouseButton, pType);
    }

    public void recipesUpdated() {
        this.getRecipeBookComponent().recipesUpdated();
    }

    public RecipeBookComponent getRecipeBookComponent() {
        return this.getRecipeBookComponent();
    }
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}

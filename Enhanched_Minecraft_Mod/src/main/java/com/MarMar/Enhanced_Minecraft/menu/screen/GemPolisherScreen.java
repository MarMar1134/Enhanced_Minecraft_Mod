package com.MarMar.Enhanced_Minecraft.menu.screen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.menu.GemPolisherMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GemPolisherScreen extends AbstractContainerScreen<GemPolisherMenu> {
    private static final ResourceLocation Texture =
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "textures/gui/gem_polisher_gui.png");
    private final Component Uses = Component.translatable("gui.enhanced_minecraft.gem_polisher_screen.text");
    public GemPolisherScreen(GemPolisherMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 74;

        this.titleLabelX = 45;
        this.titleLabelY = 5;
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, Texture);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(Texture, x, y, 0, 0, imageWidth, imageHeight);
        guiGraphics.drawString(this.font, Uses,160, 117, 0x404040, false);
        guiGraphics.drawString(this.font,String.valueOf(menu.getUses()),235, 117, 0x404040, false);
    }
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);


    }
}

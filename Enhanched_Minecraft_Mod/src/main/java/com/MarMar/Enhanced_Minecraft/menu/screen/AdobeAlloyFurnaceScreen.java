package com.MarMar.Enhanced_Minecraft.menu.screen;

import com.MarMar.Enhanced_Minecraft.menu.AdobeAlloyFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdobeAlloyFurnaceScreen extends AbstractAlloyScreen<AdobeAlloyFurnaceMenu> {

    public AdobeAlloyFurnaceScreen(AdobeAlloyFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}

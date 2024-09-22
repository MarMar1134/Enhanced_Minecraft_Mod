package com.MarMar.Enhanced_Minecraft.menu.screen;

import com.MarMar.Enhanced_Minecraft.menu.AdobeAlloyingFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdobeAlloyingFurnaceScreen extends AbstractAlloyScreen<AdobeAlloyingFurnaceMenu> {

    public AdobeAlloyingFurnaceScreen(AdobeAlloyingFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}

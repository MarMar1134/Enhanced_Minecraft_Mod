package com.marmar.enhanced_playthrough.menu.screen;

import com.marmar.enhanced_playthrough.menu.AdobeFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdobeFurnaceScreen extends AbstractBasicFurnaceScreen<AdobeFurnaceMenu> {

    public AdobeFurnaceScreen(AdobeFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}

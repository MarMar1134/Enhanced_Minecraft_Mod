package com.marmar.enhanced_playthrough.menu.screen;

import com.marmar.enhanced_playthrough.menu.AdobeAlloyFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdobeAlloyFurnaceScreen extends AbstractAlloyScreen<AdobeAlloyFurnaceMenu> {

    public AdobeAlloyFurnaceScreen(AdobeAlloyFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}

package com.marmar.enhanced_playthrough.menu.screen;

import com.marmar.enhanced_playthrough.menu.SoulFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SoulFurnaceScreen extends AbstractBasicFurnaceScreen<SoulFurnaceMenu>{
    public SoulFurnaceScreen(SoulFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}

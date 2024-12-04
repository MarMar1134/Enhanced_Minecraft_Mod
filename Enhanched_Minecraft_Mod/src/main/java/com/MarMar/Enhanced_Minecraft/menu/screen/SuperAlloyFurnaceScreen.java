package com.MarMar.Enhanced_Minecraft.menu.screen;

import com.MarMar.Enhanced_Minecraft.menu.SuperAlloyFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SuperAlloyFurnaceScreen extends AbstractAlloyScreen<SuperAlloyFurnaceMenu> {

    public SuperAlloyFurnaceScreen(SuperAlloyFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}

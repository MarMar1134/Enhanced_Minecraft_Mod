package com.MarMar.Enhanced_Minecraft.menu.screen;

import com.MarMar.Enhanced_Minecraft.menu.SuperAlloyingFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SuperAlloyingFurnaceScreen extends AbstractAlloyScreen<SuperAlloyingFurnaceMenu> {

    public SuperAlloyingFurnaceScreen(SuperAlloyingFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}

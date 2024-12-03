package com.MarMar.Enhanced_Minecraft.menu.screen;

import com.MarMar.Enhanced_Minecraft.menu.AbstractAlloyMenu;
import com.MarMar.Enhanced_Minecraft.menu.SoulAlloyFurnaceMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SoulAlloyScreen extends AbstractAlloyScreen<SoulAlloyFurnaceMenu>{
    public SoulAlloyScreen(SoulAlloyFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}

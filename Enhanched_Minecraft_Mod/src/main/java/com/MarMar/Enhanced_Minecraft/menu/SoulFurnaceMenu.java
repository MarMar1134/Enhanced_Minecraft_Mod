package com.MarMar.Enhanced_Minecraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;

public class SoulFurnaceMenu extends AbstractBasicFurnaceMenu{
    public SoulFurnaceMenu(int containerID, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.SOUL_FURNACE_MENU.get(), containerID, inv, extraData);
    }

    public SoulFurnaceMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.SOUL_FURNACE_MENU.get(), containerID, inv, entity, data);
    }
}

package com.marmar.enhanced_playthrough.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;

public class SoulAlloyFurnaceMenu extends AbstractAlloyFurnaceMenu {
    public SoulAlloyFurnaceMenu(int containerID, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.SOUL_ALLOY_FURNACE_MENU.get(), containerID, inv, extraData);
    }

    public SoulAlloyFurnaceMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.SOUL_ALLOY_FURNACE_MENU.get(), containerID, inv, entity, data);
    }
}

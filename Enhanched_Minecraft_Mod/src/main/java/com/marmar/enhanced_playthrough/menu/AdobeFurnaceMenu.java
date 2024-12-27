package com.marmar.enhanced_playthrough.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.entity.BlockEntity;

public class AdobeFurnaceMenu extends AbstractBasicFurnaceMenu {

    public AdobeFurnaceMenu(int containerID, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.ADOBE_FURNACE_MENU.get(), containerID, inv, extraData);
    }

    public AdobeFurnaceMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.ADOBE_FURNACE_MENU.get(), containerID, inv, entity, data);
    }
}

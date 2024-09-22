package com.MarMar.Enhanced_Minecraft.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.entity.BlockEntity;

public class SuperAlloyingFurnaceMenu extends AbstractAlloyMenu {

    public SuperAlloyingFurnaceMenu(int containerID, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.SUPER_ALLOYING_FURNACE_MENU.get(), containerID, inv, extraData);
    }

    public SuperAlloyingFurnaceMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.SUPER_ALLOYING_FURNACE_MENU.get(), containerID, inv, entity, data);
    }
}

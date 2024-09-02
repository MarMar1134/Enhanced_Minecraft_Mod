package com.MarMar.Enhanced_Minecraft.menu;

import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.block.custom.entity.SuperAlloyingFurnaceBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class SuperAlloyingFurnaceMenu extends AbstractAlloyMenu {

    public SuperAlloyingFurnaceMenu(int containerID, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.super_alloying_furnace_menu.get(), containerID, inv, extraData);
    }

    public SuperAlloyingFurnaceMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.super_alloying_furnace_menu.get(), containerID, inv, entity, data);
    }
}

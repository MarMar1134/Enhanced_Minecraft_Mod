package com.marmar.enhanced_playthrough.block.custom.entity;

import com.marmar.enhanced_playthrough.menu.SoulFurnaceMenu;
import com.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SoulFurnaceBlockEntity extends AbstractBasicFurnaceBlockEntity implements MenuProvider {
    public SoulFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SOUL_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, ModRecipes.SOUL_BASIC_SMELTING_TYPE.get());
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_playthrough.soul_furnace");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SoulFurnaceMenu(i, inventory, this, this.data);
    }
}

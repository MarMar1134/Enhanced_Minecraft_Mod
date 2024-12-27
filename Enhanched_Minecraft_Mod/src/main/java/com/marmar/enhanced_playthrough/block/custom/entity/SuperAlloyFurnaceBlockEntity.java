package com.marmar.enhanced_playthrough.block.custom.entity;

import com.marmar.enhanced_playthrough.recipe.ModRecipes;
import com.marmar.enhanced_playthrough.menu.SuperAlloyFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SuperAlloyFurnaceBlockEntity extends AbstractAlloyFurnaceBlockEntity implements MenuProvider {

    public SuperAlloyFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SUPER_ALLOYING_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, ModRecipes.SUPER_ALLOYING_TYPE.get());
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_playthrough.super_alloying_furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SuperAlloyFurnaceMenu(i, inventory, this, this.Data);
    }
}

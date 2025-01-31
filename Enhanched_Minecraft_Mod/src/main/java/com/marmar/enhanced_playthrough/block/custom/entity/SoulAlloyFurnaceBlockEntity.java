package com.marmar.enhanced_playthrough.block.custom.entity;

import com.marmar.enhanced_playthrough.menu.SoulAlloyFurnaceMenu;
import com.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SoulAlloyFurnaceBlockEntity extends AbstractAlloyFurnaceBlockEntity implements MenuProvider {
    public SoulAlloyFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SOUL_ALLOY_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, ModRecipes.SUPER_ALLOYING_TYPE.get());
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_playthrough.soul_alloy_furnace");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SoulAlloyFurnaceMenu(i, inventory, this, this.Data);
    }
}

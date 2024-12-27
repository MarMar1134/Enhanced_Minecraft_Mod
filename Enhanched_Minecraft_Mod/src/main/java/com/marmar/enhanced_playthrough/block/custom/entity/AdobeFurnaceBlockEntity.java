package com.marmar.enhanced_playthrough.block.custom.entity;

import com.marmar.enhanced_playthrough.menu.AdobeFurnaceMenu;
import com.marmar.enhanced_playthrough.recipe.ModRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class AdobeFurnaceBlockEntity extends AbstractBasicFurnaceBlockEntity implements MenuProvider {

    public AdobeFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ADOBE_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, ModRecipes.BASIC_SMELTING_TYPE.get());
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_playthrough.adobe_furnace");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AdobeFurnaceMenu(i, inventory, this, this.data);
    }
}

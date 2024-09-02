package com.MarMar.Enhanced_Minecraft.block.custom.entity;

import com.MarMar.Enhanced_Minecraft.block.custom.AdobeAlloyingFurnaceBlock;
import com.MarMar.Enhanced_Minecraft.recipe.AbstractAlloyRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.AlloyingFurnaceRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.ModRecipes;
import com.MarMar.Enhanced_Minecraft.menu.AdobeAlloyingFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AdobeAlloyingFurnaceBlockEntity extends AbstractAlloyFurnaceBlockEntity implements MenuProvider {

    public AdobeAlloyingFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.Adobe_alloying_furnace.get(), pPos, pBlockState, ModRecipes.Alloying_type.get());
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_minecraft.adobe_alloying_furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AdobeAlloyingFurnaceMenu(i, inventory, this, this.Data);
    }
}



package com.MarMar.Enhanced_Minecraft.blocks.entity;

import com.MarMar.Enhanced_Minecraft.recipe.ReforgingTableRecipe;
import com.MarMar.Enhanced_Minecraft.screen.ReforgingTableMenu;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ReforgingTableBlockEntity extends BlockEntity implements MenuProvider {
        private final ItemStackHandler itemHandler = new ItemStackHandler(4);
        private static final int INPUT_SLOT1 = 0;
        private static final int INPUT_SLOT2 = 1;
        private static final int OUTPUT_SLOT = 2;
        private int progress = 0;
        private int maxProgress = 1;
        private LazyOptional<ItemStackHandler> lazyItemHandler= LazyOptional.empty();
        protected final ContainerData Data;

        public ReforgingTableBlockEntity(BlockPos pPos, BlockState pBlockState) {
            super(ModBlockEntities.Reforging_table.get(), pPos, pBlockState);
            this.Data = new ContainerData() {
                @Override
                public int get(int i) {
                    return switch (i){
                        case 0, 1 -> ReforgingTableBlockEntity.this.progress;
                        case 2 -> ReforgingTableBlockEntity.this.maxProgress;
                        default -> 0;
                    };
                }

                @Override
                public void set(int i, int i1) {
                    switch (i){
                        case 0 -> i1 = ReforgingTableBlockEntity.this.progress;
                        case 1 -> i1 = ReforgingTableBlockEntity.this.progress;
                        case 2 -> i1 = ReforgingTableBlockEntity.this.maxProgress;
                    };
                }

                @Override
                public int getCount() {
                    return 4;
                }
            };
        }

        @Override
        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            if (cap == ForgeCapabilities.ITEM_HANDLER){
                return lazyItemHandler.cast();
            }
            return super.getCapability(cap, side);
        }



        public void drops() {
            SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
            for(int i = 0; i < itemHandler.getSlots(); i++) {
                inventory.setItem(i, itemHandler.getStackInSlot(i));
            }
            Containers.dropContents(this.level, this.worldPosition, inventory);
        }

        @Override
        public void onLoad() {
            super.onLoad();
            lazyItemHandler=LazyOptional.of(() -> itemHandler);
        }

        @Override
        public void invalidateCaps() {
            super.invalidateCaps();
            lazyItemHandler.invalidate();
        }

        @Override
        public Component getDisplayName() {
            return Component.translatable("block.enhanced_minecraft.reforging_table");
        }

        @Nullable
        @Override
        public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
            return new ReforgingTableMenu(i, inventory, this, this.Data);
        }

//        @Override
//        protected void saveAdditional(CompoundTag pTag) {
//            pTag.put("inventory", itemHandler.serializeNBT());
//            pTag.putInt("reforging_table.progress", progress);
//            super.saveAdditional(pTag);
//        }
//
//        @Override
//        public void load(CompoundTag pTag) {
//            super.load(pTag);
//            itemHandler.deserializeNBT(pTag.getCompound("inventory"));
//            progress = pTag.getInt("reforging_table.progress");
//        }

        private void sendUpdate() {
            setChanged();

            if(this.level != null)
                this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
        }
        public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
            if (hasRecipe()) {
                sendUpdate();
                setChanged(pLevel, pPos, pState);
                craftItem();
            }
        }

        private boolean hasRecipe (){
            Optional<ReforgingTableRecipe> recipe = getCurrentRecipe();

            if (recipe.isEmpty()){
                return false;
            }

            ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

            return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
        }

        private Optional<ReforgingTableRecipe> getCurrentRecipe() {
            SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());

            for(int i = 0; i < itemHandler.getSlots(); i++){
                inventory.setItem(i, this.itemHandler.getStackInSlot(i));
            }
            return this.level.getRecipeManager().getRecipeFor(ReforgingTableRecipe.Type.Instance, inventory, level);
        }

        private boolean canInsertItemIntoOutputSlot(Item item) {
            return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
        }

        private boolean canInsertAmountIntoOutputSlot(int count) {
            return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        }


        private void craftItem() {
            Optional<ReforgingTableRecipe> recipe = getCurrentRecipe();

            ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

            this.itemHandler.extractItem(INPUT_SLOT1, 1, false);
            this.itemHandler.extractItem(INPUT_SLOT2, 1, false);

            this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                    this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
        }

}
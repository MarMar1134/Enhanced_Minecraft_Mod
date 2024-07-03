package com.MarMar.Enhanced_Minecraft.blocks.entity;

import com.MarMar.Enhanced_Minecraft.Util.ModTiers;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import com.MarMar.Enhanced_Minecraft.items.custom.PolisherItem;
import com.MarMar.Enhanced_Minecraft.recipe.GemPolisherRecipe;
import com.MarMar.Enhanced_Minecraft.screen.GemPolisherMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

import java.util.Objects;
import java.util.Optional;

public class GemPolisherBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(3);
    private static final int TOOL_SLOT = 0;
    private static final int INPUT_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;
    private LazyOptional<ItemStackHandler> lazyItemHandler= LazyOptional.empty();
    protected final ContainerData Data;
    private int tool = 0;
    private int progress = 0;
    private int maxProgress = 1;

    public GemPolisherBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.Gem_polisher.get(), pPos, pBlockState);
        this.Data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0 -> GemPolisherBlockEntity.this.tool;
                    case 1 -> GemPolisherBlockEntity.this.progress;
                    case 2 -> GemPolisherBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0-> GemPolisherBlockEntity.this.tool = i1;
                    case 1 -> GemPolisherBlockEntity.this.progress = i1;
                    case 2 -> GemPolisherBlockEntity.this.maxProgress = i1;
                };
            }

            @Override
            public int getCount() {
                return 3;
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
        return Component.translatable("block.enhanced_minecraft.gem_polisher");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new GemPolisherMenu(i, inventory, this, this.Data);
    }
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
            if (isAccurateTool(this.itemHandler.getStackInSlot(TOOL_SLOT))){
                double Durability = hasDurability(this.itemHandler.getStackInSlot(TOOL_SLOT));
                if (hasRecipe()){
                    if(Durability >= 10){
                        craftItem();
                        restDurability(this.itemHandler.getStackInSlot(TOOL_SLOT));
                        sendUpdate();
                        setChanged(pLevel,pPos,pState);
                    } else {
                        craftItem();
                        this.itemHandler.extractItem(TOOL_SLOT,1,false);
                        sendUpdate();
                        setChanged(pLevel,pPos,pState);
                    }
                }
            }
    }
    private void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }
    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }
   private boolean isAccurateTool(ItemStack stack){
        if (stack.isEmpty()){
            return false;
        } else return stack.is(ModItems.Bronze_polisher.get()) || stack.is(ModItems.Iron_polisher.get())
                || stack.is(ModItems.Stone_polisher.get()) || stack.is(ModItems.Steel_polisher.get()) ||
                stack.is(ModItems.Silver_polisher.get()) || stack.is(ModItems.Netherite_polisher.get()) ||
                stack.is(ModItems.Diamond_polisher.get()) || stack.is(ModItems.Gold_polisher.get());
   }
   private double hasDurability(ItemStack stack){
        PolisherItem item = (PolisherItem) stack.getItem();
       return item.getDurability();
   }
   private void restDurability(ItemStack stack){
        PolisherItem item = (PolisherItem) stack.getItem();
       item.restDurability();
   }
    private boolean hasRecipe(){
        Optional<GemPolisherRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<GemPolisherRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());

        for(int i = 0; i < itemHandler.getSlots(); i++){
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        return this.level.getRecipeManager().getRecipeFor(GemPolisherRecipe.Type.Instance, inventory, level);
    }
    private void craftItem() {
        Optional<GemPolisherRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        this.itemHandler.extractItem(INPUT_SLOT, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }
}

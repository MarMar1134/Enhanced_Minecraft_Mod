package com.MarMar.Enhanced_Minecraft.blocks.entity;

import com.MarMar.Enhanced_Minecraft.items.ModItems;
import com.MarMar.Enhanced_Minecraft.screen.AdobeAlloyingFurnaceMenu;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//Credits to TurtyWurty for the getBurnTime, canBurn and all energy related methods

public class AdobeAlloyingFurnaceBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4);
    private final EnergyStorage energyStorage = new EnergyStorage(10000, 10000, 200);
    private static final int INPUT_SLOT1 = 0;
    private static final int INPUT_SLOT2 = 1;
    private static final int INPUT_FUEL = 2;
    private static final int OUTPUT_SLOT = 3;
    private LazyOptional<ItemStackHandler> lazyItemHandler= LazyOptional.empty();
    protected final ContainerData Data;
    private int progress = 0;
    private int burnTime = 0, maxBurnTime = 0;
    private int maxProgress = 100;

    public AdobeAlloyingFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.Adobe_alloying_furnace.get(), pPos, pBlockState);
        this.Data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0 -> AdobeAlloyingFurnaceBlockEntity.this.progress;
                    case 1 -> AdobeAlloyingFurnaceBlockEntity.this.progress;
                    case 2 -> AdobeAlloyingFurnaceBlockEntity.this.burnTime;
                    case 3 -> AdobeAlloyingFurnaceBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0 -> AdobeAlloyingFurnaceBlockEntity.this.progress = i1;
                    case 1 -> AdobeAlloyingFurnaceBlockEntity.this.progress = i1;
                    case 2 -> AdobeAlloyingFurnaceBlockEntity.this.burnTime = i1;
                    case 3 -> AdobeAlloyingFurnaceBlockEntity.this.maxProgress = i1;
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


    public int getBurnTime(ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING);
    }
    public boolean canBurn(ItemStack stack) {
        return getBurnTime(stack) > 0;
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
        return Component.translatable("block.enhanced_minecraft.adobe_alloying_furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AdobeAlloyingFurnaceMenu(i, inventory, this, this.Data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("adobe_alloying_furnace.progress", progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("adobe_alloying_furnace.progress");
    }

    private void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(burnTime <= 0){
            if (hasRecipe()) {
                if(canBurn(this.itemHandler.getStackInSlot(2))){
                    maxBurnTime = getBurnTime(this.itemHandler.getStackInSlot(2));
                    this.burnTime = this.maxBurnTime;
                    this.itemHandler.getStackInSlot(2).shrink(1);
                    sendUpdate();
                }
            } else {
                resetProgress();
            }
        } else if (hasRecipe()){
            this.burnTime = burnTime - 2;
            increaseCraftingProgress();
            sendUpdate();
            setChanged(pLevel, pPos, pState);
            if (hasProcessFinished()) {
                craftItem();
                resetProgress();
            }
        }
    }

    private boolean hasRecipe (){
        boolean hasRecipeItem1 = this.itemHandler.getStackInSlot(INPUT_SLOT1).getItem() == ModItems.Raw_tin.get();
        boolean hasRecipeItem2 = this.itemHandler.getStackInSlot(INPUT_SLOT2).getItem() == Items.RAW_COPPER;

        ItemStack result = new ItemStack(ModItems.Raw_bronze.get());
        return hasRecipeItem1 && hasRecipeItem2 && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private void resetProgress() {
    progress = 0;
    }

    private void craftItem() {
        ItemStack output = new ItemStack(ModItems.Raw_bronze.get(), 1);

        this.itemHandler.extractItem(INPUT_SLOT1, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT2, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(),
        this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private void increaseCraftingProgress() {
        progress++;
    }
    private boolean hasProcessFinished (){

        return progress >= maxProgress;
    }
}


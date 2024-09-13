package com.MarMar.Enhanced_Minecraft.block.custom.entity;

import com.MarMar.Enhanced_Minecraft.block.custom.AdobeAlloyingFurnaceBlock;
import com.MarMar.Enhanced_Minecraft.recipe.AbstractAlloyRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
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

public abstract class AbstractAlloyFurnaceBlockEntity extends BlockEntity {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4);
    private static final int INPUT_SLOT1 = 0;
    private static final int INPUT_SLOT2 = 1;
    private static final int FUEL_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;
    private LazyOptional<ItemStackHandler> lazyItemHandler= LazyOptional.empty();
    protected final ContainerData Data;
    private int progress = 0;
    private int burnTime = 0, maxBurnTime = 0;
    private int maxProgress = 200;
    private final RecipeType<? extends AbstractAlloyRecipe> recipeType;

    public AbstractAlloyFurnaceBlockEntity(@NotNull BlockEntityType<? extends  AbstractAlloyFurnaceBlockEntity> blockEntityType, BlockPos pPos, BlockState pBlockState, RecipeType<? extends AbstractAlloyRecipe> recipeType) {
        super(blockEntityType, pPos, pBlockState);
        this.recipeType = recipeType;
        this.Data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0, 1 -> AbstractAlloyFurnaceBlockEntity.this.progress;
                    case 2 -> AbstractAlloyFurnaceBlockEntity.this.burnTime;
                    case 3 -> AbstractAlloyFurnaceBlockEntity.this.maxBurnTime;
                    case 4 -> AbstractAlloyFurnaceBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0, 1 -> AbstractAlloyFurnaceBlockEntity.this.progress = i1;
                    case 2 -> AbstractAlloyFurnaceBlockEntity.this.burnTime = i1;
                    case 3 -> AbstractAlloyFurnaceBlockEntity.this.maxBurnTime = i1;
                    case 4 -> AbstractAlloyFurnaceBlockEntity.this.maxProgress = i1;
                };
            }

            @Override
            public int getCount() {
                return 5;
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
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public int getBurnTime(ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, this.recipeType);
    }
    public boolean canBurn(ItemStack stack) {
        return getBurnTime(stack) > 0;
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(4);

        for(int i = 0; i < this.itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public void onLoad() {
        super.onLoad();
       this.lazyItemHandler=LazyOptional.of(() -> itemHandler);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("alloy_furnace.progress", progress);
        pTag.putInt("alloy_furnace.burnTime", burnTime);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("alloy_furnace.progress");
        burnTime = pTag.getInt("alloy_furnace.burnTime");
    }
    private void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }
    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, AbstractAlloyFurnaceBlockEntity entity) {
        if(!entity.isBurning()){
            if (entity.hasRecipe()) {
                if(entity.canBurn(entity.itemHandler.getStackInSlot(FUEL_SLOT))){
                    entity.burn();

                   entity.sendUpdate();
                }
            } else {
                entity.resetProgress();
            }
        } else if (entity.hasRecipe()){
            entity.decreaseBurnTime();
            entity.increaseCraftingProgress();

            entity.sendUpdate();
            setChanged(pLevel, pPos, pState);
            if (entity.hasProcessFinished()) {
                entity.craftItem();
                entity.resetProgress();
            }
        } else {
            do{
                entity.decreaseBurnTime();
            } while (entity.isBurning());

            entity.resetProgress();
        }
        if (entity.isBurning()){
            pState = pState.setValue(AdobeAlloyingFurnaceBlock.BURNING, true);
        } else {
            pState = pState.setValue(AdobeAlloyingFurnaceBlock.BURNING, false);
        }
        pLevel.setBlock(pPos, pState, 1);
        setChanged(pLevel, pPos, pState);
    }
    private boolean isBurning(){
        return burnTime > 0;
    }
    private void burn(){
        this.maxBurnTime = getBurnTime(this.itemHandler.getStackInSlot(FUEL_SLOT));
        this.burnTime = this.maxBurnTime;
        this.itemHandler.getStackInSlot(FUEL_SLOT).shrink(1);
    }
    private void decreaseBurnTime(){
        burnTime -= 1;
    }
    protected boolean hasRecipe(){
        Optional<? extends AbstractAlloyRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    protected Optional<? extends AbstractAlloyRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());

        for (int i = 0; i < this.itemHandler.getSlots(); i++){
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(this.recipeType, inventory, level);
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

    protected void craftItem() {
        Optional<? extends AbstractAlloyRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        this.itemHandler.extractItem(INPUT_SLOT1, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT2, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private void increaseCraftingProgress() {
        progress++;
    }
    private boolean hasProcessFinished (){

        return progress >= maxProgress;
    }
}

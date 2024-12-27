package com.marmar.enhanced_playthrough.block.custom.entity;

import com.marmar.enhanced_playthrough.block.custom.AbstractBasicFurnaceBlock;
import com.marmar.enhanced_playthrough.recipe.basic.AbstractBasicSmeltingRecipe;
import com.marmar.enhanced_playthrough.recipe.basic.BasicSmeltingRecipe;
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

public abstract class AbstractBasicFurnaceBlockEntity extends BlockEntity {
    private final ItemStackHandler inputHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };
    private final ItemStackHandler fuelHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };
    private final ItemStackHandler outputHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> inputLazyHandler = LazyOptional.of(() -> this.inputHandler);
    private final LazyOptional<ItemStackHandler> fuelLazyHandler = LazyOptional.of(() -> this.fuelHandler);
    private final LazyOptional<ItemStackHandler> outputLazyHandler = LazyOptional.of(() -> this.outputHandler);

    protected final ContainerData data;
    private final RecipeType<? extends AbstractBasicSmeltingRecipe> recipeType;
    private int progress = 0;
    private int burnTime = 0, maxBurnTime = 0;
    private int maxProgress;

    public AbstractBasicFurnaceBlockEntity(@NotNull BlockEntityType<? extends AbstractBasicFurnaceBlockEntity> pType, BlockPos pPos, BlockState pBlockState, RecipeType<? extends AbstractBasicSmeltingRecipe> recipe) {
        super(pType, pPos, pBlockState);
        this.recipeType = recipe;
        this.data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0 -> AbstractBasicFurnaceBlockEntity.this.progress;
                    case 1 -> AbstractBasicFurnaceBlockEntity.this.maxProgress;
                    case 2 -> AbstractBasicFurnaceBlockEntity.this.burnTime;
                    case 3 -> AbstractBasicFurnaceBlockEntity.this.maxBurnTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0 -> AbstractBasicFurnaceBlockEntity.this.progress = i1;
                    case 1 -> AbstractBasicFurnaceBlockEntity.this.maxProgress = i1;
                    case 2 -> AbstractBasicFurnaceBlockEntity.this.burnTime = i1;
                    case 3 -> AbstractBasicFurnaceBlockEntity.this.maxBurnTime = i1;

                };
            }

            @Override
            public int getCount() {
                return 4;
            }
        };

        this.maxProgress = setMaxProgress();
    }

    public LazyOptional<ItemStackHandler> getInputLazyHandler(){
        return this.inputLazyHandler;
    }

    public LazyOptional<ItemStackHandler> getFuelLazyHandler(){
        return this.fuelLazyHandler;
    }

    public LazyOptional<ItemStackHandler> getOutputLazyHandler(){
        return this.outputLazyHandler;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER){
            if (side == Direction.UP){
                return fuelLazyHandler.cast();
            } else if (side == Direction.DOWN){
                return outputLazyHandler.cast();
            } else {
                return inputLazyHandler.cast();
            }
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        inputLazyHandler.invalidate();
        fuelLazyHandler.invalidate();
        outputLazyHandler.invalidate();
    }

    private int setMaxProgress(){
        if (this.recipeType instanceof BasicSmeltingRecipe){
            return 300;
        } else {
            return 200;
        }
    }

    public void Drops(){
        SimpleContainer inventory = new SimpleContainer(3);

        inventory.setItem(0, inputHandler.getStackInSlot(0));
        inventory.setItem(1, fuelHandler.getStackInSlot(0));
        inventory.setItem(2, outputHandler.getStackInSlot(0));

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("basic_furnace.input", inputHandler.serializeNBT());
        pTag.put("basic_furnace.fuel", fuelHandler.serializeNBT());
        pTag.put("basic_furnace.output", outputHandler.serializeNBT());

        pTag.putInt("basic_furnace.progress", this.progress);
        pTag.putInt("basic_furnace.burnTime", this.burnTime);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        inputHandler.deserializeNBT(pTag.getCompound("basic_furnace.input"));
        fuelHandler.deserializeNBT(pTag.getCompound("basic_furnace.fuel"));
        outputHandler.deserializeNBT(pTag.getCompound("basic_furnace.output"));

        this.progress = pTag.getInt("basic_furnace.progress");
        this.burnTime = pTag.getInt("basic_furnace.burnTime");

        super.load(pTag);
    }

    private void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    public static void Tick(Level pLevel, BlockPos pPos, BlockState pState, AbstractBasicFurnaceBlockEntity entity){
        if (entity.isBurning()){
            if (entity.hasRecipe()){
                entity.increaseSmeltProgress();

                entity.sendUpdate();
            } else {
                entity.resetProgress();
            }
            pState = pState.setValue(AbstractBasicFurnaceBlock.BURNING, true);

            entity.decreaseBurnTime();

            entity.sendUpdate();
        } else if (entity.hasRecipe()){
            if (entity.canBurn(entity.fuelHandler.getStackInSlot(0))){
                entity.burn();

                entity.sendUpdate();
            }
        } else {
            pState = pState.setValue(AbstractBasicFurnaceBlock.BURNING, false);

            entity.resetProgress();

            entity.sendUpdate();
        }

        if (entity.hasProcessFinished()){
            entity.smeltItem();

            entity.resetProgress();

            entity.sendUpdate();
        }

        pLevel.setBlock(pPos, pState, 1);
        setChanged(pLevel, pPos, pState);
    }

    //checks if the passed item has a "burntime" parameter on his metadata
    public boolean canBurn(ItemStack stack) {
        return getBurnTime(stack) > 0;
    }

    //returns the required burning time of the current recipe
    public int getBurnTime(ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, this.recipeType);
    }

    //checks if the burn time is mayor than 0
    private boolean isBurning(){
        return burnTime > 0;
    }

    //takes an item from the Fuel Slot, then copies his "burntime" metadata and gives it to burntime
    private void burn(){
        this.maxBurnTime = getBurnTime(this.fuelHandler.getStackInSlot(0));
        this.burnTime = this.maxBurnTime;
        this.fuelHandler.getStackInSlot(0).shrink(1);
    }

    //simply decreases the burn time
    private void decreaseBurnTime(){
        burnTime -= 1;
    }

    //resets the smelting progress
    private void resetProgress() {
        progress = 0;
    }

    //increases the smelting progress
    private void increaseSmeltProgress() {
        progress++;
    }

    //checks if the current smelt has finished
    private boolean hasProcessFinished (){

        return progress >= maxProgress;
    }

    //Checks if it has an available recipe
    protected Optional<? extends AbstractBasicSmeltingRecipe> getCurrentRecipe(){
        SimpleContainer inv = new SimpleContainer(1);

        inv.setItem(0, inputHandler.getStackInSlot(0));

        return this.level.getRecipeManager().getRecipeFor(this.recipeType, inv, level);
    }

    protected boolean hasRecipe(){
        Optional<? extends AbstractBasicSmeltingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        } else {
            ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

            return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
        }
    }

    protected void smeltItem(){
        Optional<? extends AbstractBasicSmeltingRecipe> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().getResultItem(getLevel().registryAccess());

        inputHandler.extractItem(0, 1, false);

        this.outputHandler.setStackInSlot(0, new ItemStack(output.getItem(),
                this.outputHandler.getStackInSlot(0).getCount() + output.getCount()));
    }

    //checks if the result of the selected recipe matches the item in the Result Slot
    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.outputHandler.getStackInSlot(0).isEmpty() || this.outputHandler.getStackInSlot(0).is(item);
    }

    //checks if the item in the Result Slot is not in his maximum capacity
    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.outputHandler.getStackInSlot(0).getCount() + count <= this.outputHandler.getStackInSlot(0).getMaxStackSize();
    }
}

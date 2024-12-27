package com.marmar.enhanced_playthrough.block.custom.entity;

import com.marmar.enhanced_playthrough.block.custom.AbstractAlloyFurnaceBlock;
import com.marmar.enhanced_playthrough.recipe.alloy.AbstractAlloyRecipe;
import com.marmar.enhanced_playthrough.recipe.alloy.SuperAlloyingRecipe;
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
    private final ItemStackHandler firstInputHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };
    private final ItemStackHandler secondInputHandler = new ItemStackHandler(1){
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

    private final LazyOptional<ItemStackHandler> firstInputLazyHandler = LazyOptional.of(() -> firstInputHandler);
    private final LazyOptional<ItemStackHandler> secondInputLazyHandler = LazyOptional.of(() -> secondInputHandler);
    private final LazyOptional<ItemStackHandler> fuelLazyHandler = LazyOptional.of(() ->fuelHandler);
    private final LazyOptional<ItemStackHandler> outputLazyHandler = LazyOptional.of(() -> outputHandler);

    protected final ContainerData Data;
    private final RecipeType<? extends AbstractAlloyRecipe> recipeType;
    private int progress = 0;
    private int burnTime = 0, maxBurnTime = 0;
    private int maxProgress;

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

        this.maxProgress = setMaxProgress();
    }

    public LazyOptional<ItemStackHandler> getFirstInputLazyHandler(){
        return this.firstInputLazyHandler;
    }
    public LazyOptional<ItemStackHandler> getSecondInputLazyHandler(){
        return this.secondInputLazyHandler;
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
            if (side == Direction.DOWN){
                return outputLazyHandler.cast();
            } else if (side == Direction.UP){
                return fuelLazyHandler.cast();
            } else if (side == Direction.EAST || side == Direction.SOUTH){
                return firstInputLazyHandler.cast();
            } else {
                return secondInputLazyHandler.cast();
            }
        }
        return super.getCapability(cap, side);
    }
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        firstInputLazyHandler.invalidate();
        secondInputLazyHandler.invalidate();
        fuelLazyHandler.invalidate();
        outputLazyHandler.invalidate();
    }

    private int setMaxProgress() {
        if (this.recipeType instanceof SuperAlloyingRecipe){
            return 100;
        } else {
            return 200;
        }
    }


    public void drops() {
        SimpleContainer inventory = new SimpleContainer(4);

        inventory.setItem(0, firstInputHandler.getStackInSlot(0));
        inventory.setItem(1, secondInputHandler.getStackInSlot(0));
        inventory.setItem(2, fuelHandler.getStackInSlot(0));
        inventory.setItem(3, outputHandler.getStackInSlot(0));

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    //saves the metadata of the remaining burn time, the alloy progress and the inventory
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("first_input", firstInputHandler.serializeNBT());
        pTag.put("second_input", secondInputHandler.serializeNBT());
        pTag.put("fuel", fuelHandler.serializeNBT());
        pTag.put("output", outputHandler.serializeNBT());

        pTag.putInt("alloy_furnace.progress", progress);
        pTag.putInt("alloy_furnace.burnTime", burnTime);
        super.saveAdditional(pTag);
    }

    //loads the metadata saved on memory
    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        firstInputHandler.deserializeNBT(pTag.getCompound("first_input"));
        secondInputHandler.deserializeNBT(pTag.getCompound("second_input"));
        fuelHandler.deserializeNBT(pTag.getCompound("fuel"));
        outputHandler.deserializeNBT(pTag.getCompound("output"));

        progress = pTag.getInt("alloy_furnace.progress");
        burnTime = pTag.getInt("alloy_furnace.burnTime");
    }

    //sends and update to the block entity
    private void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, AbstractAlloyFurnaceBlockEntity entity) {
        // checks if the entity is burning. If true, changes the blockstate parameter "BURNING" value to true and checks if it has a recipe on the input slots.
        // Then starts to decrease the burning time.
        if (entity.isBurning()){

            //if is burning, checks if it has a recipe available. if true, starts to increase the crafting progress.
            if (entity.hasRecipe()){
                entity.increaseAlloyProgress();

                entity.sendUpdate();
            } else {
                entity.resetProgress();
            }
            pState = pState.setValue(AbstractAlloyFurnaceBlock.BURNING, true);

            entity.decreaseBurnTime();

            entity.sendUpdate();

        //if not is burning, still checks if it has a recipe. If true, checks if there´s an item in the Fuel Slot that can be burned.
        } else if (entity.hasRecipe()){
            if (entity.canBurn(entity.fuelHandler.getStackInSlot(0))){
                entity.burn();

                entity.sendUpdate();
            }

        //if not is burning nor have an item that can be burned, changes the blockstate parameter "BURNING" value to false.
        } else {
            pState = pState.setValue(AbstractAlloyFurnaceBlock.BURNING, false);

            entity.resetProgress();

            entity.sendUpdate();
        }

        //checks if the crafting progress finished. If true, crafts the item
        if (entity.hasProcessFinished()){
            entity.alloyItem();

            entity.resetProgress();

            entity.sendUpdate();
        }

        //sets the blockstate
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

    //takes the items from the Input Slots, puts them on a Container and then calls the selected recipe to check if the ingredients match
    protected Optional<? extends AbstractAlloyRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(2);

        inventory.setItem(0, firstInputHandler.getStackInSlot(0));
        inventory.setItem(1, secondInputHandler.getStackInSlot(0));

        return this.level.getRecipeManager().getRecipeFor(this.recipeType, inventory, level);
    }

    //checks if there is any recipe available to start working
    protected boolean hasRecipe(){
        Optional<? extends AbstractAlloyRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    //resets the alloy progress
    private void resetProgress() {
        progress = 0;
    }

    //increases the alloy progress
    private void increaseAlloyProgress() {
        progress++;
    }

    //checks if the current alloy has finished
    private boolean hasProcessFinished (){

        return progress >= maxProgress;
    }

    //takes the selected recipe, then extracts the items from his Input Slots and generates the pertinent item in the Result Slot
    protected void alloyItem() {
        Optional<? extends AbstractAlloyRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        this.firstInputHandler.extractItem(0, 1, false);
        this.secondInputHandler.extractItem(0, 1, false);

        this.outputHandler.setStackInSlot(0, new ItemStack(result.getItem(),
                this.outputHandler.getStackInSlot(0).getCount() + result.getCount()));
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
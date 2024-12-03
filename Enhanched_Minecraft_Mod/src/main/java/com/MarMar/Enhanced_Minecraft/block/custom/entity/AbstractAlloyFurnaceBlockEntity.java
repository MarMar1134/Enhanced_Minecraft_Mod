package com.MarMar.Enhanced_Minecraft.block.custom.entity;

import com.MarMar.Enhanced_Minecraft.block.custom.AbstractAlloyFurnaceBlock;
import com.MarMar.Enhanced_Minecraft.recipe.AbstractAlloyRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.SuperAlloyingRecipe;
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

    private int setMaxProgress() {
        if (this.recipeType instanceof SuperAlloyingRecipe){
            return 100;
        } else {
            return 200;
        }
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

    //saves the metadata of the remaining burn time, the alloy progress and the inventory
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("alloy_furnace.progress", progress);
        pTag.putInt("alloy_furnace.burnTime", burnTime);
        super.saveAdditional(pTag);
    }

    //loads the metadata saved on memory
    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
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
            if (entity.canBurn(entity.itemHandler.getStackInSlot(FUEL_SLOT))){
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
        this.maxBurnTime = getBurnTime(this.itemHandler.getStackInSlot(FUEL_SLOT));
        this.burnTime = this.maxBurnTime;
        this.itemHandler.getStackInSlot(FUEL_SLOT).shrink(1);
    }

    //simply decreases the burn time
    private void decreaseBurnTime(){
        burnTime -= 1;
    }

    //takes the items from the Input Slots, puts them on a Container and then calls the selected recipe to check if the ingredients match
    protected Optional<? extends AbstractAlloyRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());



        for (int i = 0; i < this.itemHandler.getSlots(); i++){
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

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

        this.itemHandler.extractItem(INPUT_SLOT1, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT2, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    //checks if the result of the selected recipe matches the item in the Result Slot
    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    //checks if the item in the Result Slot is not in his maximum capacity
    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }
}
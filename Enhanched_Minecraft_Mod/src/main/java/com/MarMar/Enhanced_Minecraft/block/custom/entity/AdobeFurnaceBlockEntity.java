package com.MarMar.Enhanced_Minecraft.block.custom.entity;

import com.MarMar.Enhanced_Minecraft.block.custom.AdobeFurnaceBlock;
import com.MarMar.Enhanced_Minecraft.menu.AdobeFurnaceMenu;
import com.MarMar.Enhanced_Minecraft.recipe.BasicSmeltingRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.ModRecipes;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AdobeFurnaceBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(3);
    private static final int FUEL_SLOT = 0;
    private static final int INPUT_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;
    private LazyOptional<ItemStackHandler> lazyItemHandler= LazyOptional.empty();
    protected final ContainerData Data;
    private int burnTime = 0, maxBurnTime = 0;
    private int progress = 0;
    private int maxProgress = 300;

    public AdobeFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ADOBE_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.Data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0, 1 -> AdobeFurnaceBlockEntity.this.progress;
                    case 2 -> AdobeFurnaceBlockEntity.this.maxProgress;
                    case 3 -> AdobeFurnaceBlockEntity.this.burnTime;
                    case 4 -> AdobeFurnaceBlockEntity.this.maxBurnTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0, 1 -> AdobeFurnaceBlockEntity.this.progress = i1;
                    case 2 -> AdobeFurnaceBlockEntity.this.maxProgress = i1;
                    case 3 -> AdobeFurnaceBlockEntity.this.burnTime = i1;
                    case 4 -> AdobeFurnaceBlockEntity.this.maxBurnTime = i1;
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
        return Component.translatable("block.enhanced_minecraft.adobe_furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AdobeFurnaceMenu(i, inventory, this, this.Data);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (isBurning()){
            if (hasRecipe()){
                increaseCraftingProgress();

                sendUpdate();
            } else {
                resetProgress();
            }
            pState = pState.setValue(AdobeFurnaceBlock.BURNING, true);

            decreaseBurnTime();

            sendUpdate();
        } else if (hasRecipe()){
            if (canBurn(this.itemHandler.getStackInSlot(FUEL_SLOT))){
                burn();

                sendUpdate();
            }
        } else {
            pState = pState.setValue(AdobeFurnaceBlock.BURNING, false);

            resetProgress();

            sendUpdate();
        }

        if (hasProcessFinished()){
            craftItem();

            resetProgress();

            sendUpdate();
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
        return ForgeHooks.getBurnTime(stack, ModRecipes.BASIC_SMELTING_TYPE.get());
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

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasProcessFinished (){

        return progress >= maxProgress;
    }

    private void resetProgress() {
        progress = 0;
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("adobe_furnace.progress", progress);
        pTag.putInt("adobe_furnace.burnTime", burnTime);
        pTag.putInt("adobe_furnace.maxBurnTime", maxBurnTime);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("adobe_furnace.progress");
        burnTime = pTag.getInt("adobe_furnace.burnTime");
        maxBurnTime = pTag.getInt("adobe_furnace.maxBurnTime");
    }

    private boolean hasRecipe(){
        Optional<BasicSmeltingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<BasicSmeltingRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());


        inventory.setItem(0, this.itemHandler.getStackInSlot(1));

        return this.level.getRecipeManager().getRecipeFor(ModRecipes.BASIC_SMELTING_TYPE.get(), inventory, level);
    }

    private void craftItem() {
        Optional<BasicSmeltingRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        this.itemHandler.extractItem(INPUT_SLOT, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }
}

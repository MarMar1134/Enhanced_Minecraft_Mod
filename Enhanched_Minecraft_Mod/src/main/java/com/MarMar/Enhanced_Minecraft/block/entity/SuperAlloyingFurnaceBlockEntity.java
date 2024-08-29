package com.MarMar.Enhanced_Minecraft.block.entity;

import com.MarMar.Enhanced_Minecraft.block.custom.AdobeAlloyingFurnaceBlock;
import com.MarMar.Enhanced_Minecraft.recipe.ModRecipes;
import com.MarMar.Enhanced_Minecraft.recipe.SuperAlloyingRecipe;
import com.MarMar.Enhanced_Minecraft.screen.SuperAlloyingFurnaceMenu;
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
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SuperAlloyingFurnaceBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4);
    private static final int INPUT_SLOT1 = 0;
    private static final int INPUT_SLOT2 = 1;
    private static final int FUEL_SLOT = 2;
    private static final int OUTPUT_SLOT = 3;
    private LazyOptional<ItemStackHandler> lazyItemHandler= LazyOptional.empty();
    protected final ContainerData Data;
    private int progress = 0;
    private int burnTime = 0, maxBurnTime = 0;
    private int maxProgress = 100;

    public SuperAlloyingFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.Super_alloying_furnace.get(), pPos, pBlockState);
        this.Data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0, 1 -> SuperAlloyingFurnaceBlockEntity.this.progress;
                    case 2 -> SuperAlloyingFurnaceBlockEntity.this.burnTime;
                    case 3 -> SuperAlloyingFurnaceBlockEntity.this.maxBurnTime;
                    case 4 -> SuperAlloyingFurnaceBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0, 1 -> SuperAlloyingFurnaceBlockEntity.this.progress = i1;
                    case 2 -> SuperAlloyingFurnaceBlockEntity.this.burnTime = i1;
                    case 3 -> SuperAlloyingFurnaceBlockEntity.this.maxBurnTime = i1;
                    case 4 -> SuperAlloyingFurnaceBlockEntity.this.maxProgress = i1;
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


    public int getBurnTime(ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, ModRecipes.Super_alloying_type.get());
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
        return Component.translatable("block.enhanced_minecraft.super_alloying_furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SuperAlloyingFurnaceMenu(i, inventory, this, this.Data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("super_alloying_furnace.progress", progress);
        pTag.putInt("super_alloying_furnace.burnTime", burnTime);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("super_alloying_furnace.progress");
        burnTime = pTag.getInt("super_alloying_furnace.burnTime");
    }
    private void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(!isBurning()){
            if (hasRecipe()) {
                if(canBurn(this.itemHandler.getStackInSlot(FUEL_SLOT))){
                    maxBurnTime = getBurnTime(this.itemHandler.getStackInSlot(FUEL_SLOT));
                    this.burnTime = this.maxBurnTime;
                    this.itemHandler.getStackInSlot(FUEL_SLOT).shrink(1);
                    sendUpdate();
                }
            } else {
                resetProgress();
            }
        } else if (hasRecipe()){
            decreaseBurnTime();
            increaseCraftingProgress();

            sendUpdate();
            setChanged(pLevel, pPos, pState);
            if (hasProcessFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            do{
                decreaseBurnTime();
            } while (burnTime < 0);

            resetProgress();
        }
        if (isBurning()){
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
    private void decreaseBurnTime(){
        burnTime -= 1;
    }
    private boolean hasRecipe(){
        Optional<SuperAlloyingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private Optional<SuperAlloyingRecipe> getCurrentRecipe(){
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());

        for(int i = 0; i < itemHandler.getSlots(); i++){
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        return this.level.getRecipeManager().getRecipeFor(SuperAlloyingRecipe.Type.Instance, inventory, level);
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
        Optional<SuperAlloyingRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        this.itemHandler.extractItem(INPUT_SLOT1, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT2, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private void increaseCraftingProgress() {
        progress += 2;
    }
    private boolean hasProcessFinished (){

        return progress >= maxProgress;
    }
}

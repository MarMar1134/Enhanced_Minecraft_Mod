package com.marmar.enhanced_playthrough.block.custom.entity;

import com.marmar.enhanced_playthrough.item.custom.PolisherItem;
import com.marmar.enhanced_playthrough.recipe.GemPolishingRecipe;
import com.marmar.enhanced_playthrough.menu.GemPolisherMenu;
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

public class GemPolisherBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler inputHandler = new ItemStackHandler(1) {
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
    private final ItemStackHandler toolHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> inputLazyHandler = LazyOptional.of(() -> this.inputHandler);
    private final LazyOptional<ItemStackHandler> outputLazyHandler = LazyOptional.of(() -> this.outputHandler);
    private final LazyOptional<ItemStackHandler> toolLazyHandler = LazyOptional.of(() -> this.toolHandler);

    protected final ContainerData Data;
    private int tool = 0;
    private int uses = 0, maxUses = 0;
    private int progress = 0;
    private int maxProgress = 50;

    public GemPolisherBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.GEM_POLISHER_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.Data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0 -> GemPolisherBlockEntity.this.tool;
                    case 1 -> GemPolisherBlockEntity.this.progress;
                    case 2 -> GemPolisherBlockEntity.this.maxProgress;
                    case 3 -> GemPolisherBlockEntity.this.uses;
                    case 4 -> GemPolisherBlockEntity.this.maxUses;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0-> GemPolisherBlockEntity.this.tool = i1;
                    case 1 -> GemPolisherBlockEntity.this.progress = i1;
                    case 2 -> GemPolisherBlockEntity.this.maxProgress = i1;
                    case 3 -> GemPolisherBlockEntity.this.uses = i1;
                    case 4 -> GemPolisherBlockEntity.this.maxUses = i1;
                };
            }

            @Override
            public int getCount() {
                return 5;
            }
        };

    }

    public LazyOptional<ItemStackHandler> getInputLazyHandler(){
        return this.inputLazyHandler;
    }
    public LazyOptional<ItemStackHandler> getOutputLazyHandler(){
        return this.outputLazyHandler;
    }
    public LazyOptional<ItemStackHandler> getToolLazyHandler(){
        return this.toolLazyHandler;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER){
            if (side == Direction.UP){
                return inputLazyHandler.cast();
            }
            if (side == Direction.DOWN){
                return outputLazyHandler.cast();
            }


            return toolLazyHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(3);

        inventory.setItem(0, toolHandler.getStackInSlot(0));
        inventory.setItem(1, inputHandler.getStackInSlot(0));
        inventory.setItem(2, outputHandler.getStackInSlot(0));

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        inputLazyHandler.invalidate();
        outputLazyHandler.invalidate();
        toolLazyHandler.invalidate();
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.enhanced_playthrough.gem_polisher");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new GemPolisherMenu(i, inventory, this, this.Data);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (hasRecipe()){
            if (hasUses()){
                increasePolishProgress();

                sendUpdate();
                if (hasProcessFinished()) {
                    this.uses -= 1;

                    polishItem();

                    resetProgress();

                    sendUpdate();
                }
            } else if (isAccurateTool(this.toolHandler.getStackInSlot(0))){
                maxUses = getPolisherUses(this.toolHandler.getStackInSlot(0));
                setUses(maxUses);
                this.toolHandler.extractItem(0, 1, false);

                sendUpdate();
            }
        }

        setChanged(pLevel, pPos, pState);
    }

    private void sendUpdate() {
        setChanged();

        if(this.level != null)
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.outputHandler.getStackInSlot(0).isEmpty() || this.outputHandler.getStackInSlot(0).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.outputHandler.getStackInSlot(0).getCount() + count <= this.outputHandler.getStackInSlot(0).getMaxStackSize();
    }

    private void increasePolishProgress() {
        progress++;
    }

    private boolean hasProcessFinished (){
        return progress >= maxProgress;
    }

    private void resetProgress() {
        progress = 0;
    }

   private boolean isAccurateTool(ItemStack stack){
        return stack.getItem() instanceof PolisherItem;
   }

   private int getPolisherUses(ItemStack stack){
       return stack.getMaxDamage() / 2;
   }

   private void setUses(int quantity){
        this.uses = quantity;
   }

   private boolean hasUses(){
        return this.uses > 0;
   }

    private boolean hasRecipe(){
        Optional<GemPolishingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        }

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("input", inputHandler.serializeNBT());
        pTag.put("tool", toolHandler.serializeNBT());
        pTag.put("output", outputHandler.serializeNBT());

        pTag.putInt("gem_polisher.progress", progress);
        pTag.putInt("gem_polisher.uses", uses);
        pTag.putInt("gem_polisher.maxUses", maxUses);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        inputHandler.deserializeNBT(pTag.getCompound("input"));
        toolHandler.deserializeNBT(pTag.getCompound("tool"));
        outputHandler.deserializeNBT(pTag.getCompound("output"));

        progress = pTag.getInt("gem_polisher.progress");
        uses = pTag.getInt("gem_polisher.uses");
        maxUses = pTag.getInt("gem_polisher.maxUses");
    }
    private Optional<GemPolishingRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.inputHandler.getSlots());


            inventory.setItem(0, this.inputHandler.getStackInSlot(0));

        return this.level.getRecipeManager().getRecipeFor(GemPolishingRecipe.Type.INSTANCE, inventory, level);
    }
    private void polishItem() {
        Optional<GemPolishingRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        this.inputHandler.extractItem(0, 1, false);

        this.outputHandler.setStackInSlot(0, new ItemStack(result.getItem(),
                this.outputHandler.getStackInSlot(0).getCount() + result.getCount()));
    }

}

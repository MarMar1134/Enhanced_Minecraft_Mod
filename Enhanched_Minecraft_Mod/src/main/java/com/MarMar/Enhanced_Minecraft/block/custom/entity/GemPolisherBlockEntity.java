package com.MarMar.Enhanced_Minecraft.block.custom.entity;

import com.MarMar.Enhanced_Minecraft.item.custom.PolisherItem;
import com.MarMar.Enhanced_Minecraft.recipe.GemPolishingRecipe;
import com.MarMar.Enhanced_Minecraft.menu.GemPolisherMenu;
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
    private final ItemStackHandler itemHandler = new ItemStackHandler(3);
    private static final int TOOL_SLOT = 0;
    private static final int INPUT_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;
    private LazyOptional<ItemStackHandler> lazyItemHandler= LazyOptional.empty();
    protected final ContainerData Data;
    private int tool = 0;
    private int uses = 0, maxUses = 0;
    private int progress = 0;
    private int maxProgress = 50;

    public GemPolisherBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.Gem_polisher_block.get(), pPos, pBlockState);
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
            maxUses = getUses(this.itemHandler.getStackInSlot(TOOL_SLOT));
            this.uses = maxUses;
            this.itemHandler.extractItem(TOOL_SLOT,1,false);
        }

        if (uses > 0){
            if (hasRecipe()){
                increaseCraftingProgress();
                sendUpdate();
                setChanged(pLevel, pPos, pState);
                if (hasProcessFinished()) {
                    this.uses -= 1;
                    craftItem();
                    resetProgress();
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
    private void increaseCraftingProgress() {
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
   private int getUses(ItemStack stack){
       return stack.getMaxDamage() / 2;
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
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("gem_polisher.progress", progress);
        pTag.putInt("gem_polisher.uses", uses);
        pTag.putInt("gem_polisher.maxUses", maxUses);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("gem_polisher.progress");
        uses = pTag.getInt("gem_polisher.uses");
        maxUses = pTag.getInt("gem_polisher.maxUses");
    }
    private Optional<GemPolishingRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());


            inventory.setItem(0, this.itemHandler.getStackInSlot(1));

        return this.level.getRecipeManager().getRecipeFor(GemPolishingRecipe.Type.Instance, inventory, level);
    }
    private void craftItem() {
        Optional<GemPolishingRecipe> recipe = getCurrentRecipe();

        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        this.itemHandler.extractItem(INPUT_SLOT, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
    }

}

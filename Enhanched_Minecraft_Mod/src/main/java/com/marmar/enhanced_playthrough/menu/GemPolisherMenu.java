package com.marmar.enhanced_playthrough.menu;

import com.marmar.enhanced_playthrough.Util.ModTags;
import com.marmar.enhanced_playthrough.block.ModBlocks;
import com.marmar.enhanced_playthrough.block.custom.entity.GemPolisherBlockEntity;
import com.marmar.enhanced_playthrough.item.custom.PolisherItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class GemPolisherMenu extends AbstractContainerMenu {
    public final GemPolisherBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public GemPolisherMenu(int containerID, Inventory inv, FriendlyByteBuf extraData){
        this(containerID, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(5));
    }
    public GemPolisherMenu(int containerID, Inventory inv, BlockEntity entity, ContainerData data){
        super(ModMenuTypes.GEM_POLISHER_MENU.get(), containerID);
        blockEntity = ((GemPolisherBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        createSlots((GemPolisherBlockEntity) entity);

        addDataSlots(data);
    }

    private void createSlots(GemPolisherBlockEntity entity){
        //Tool
        entity.getToolLazyHandler().ifPresent(itemStackHandler ->
                addSlot(new SlotItemHandler(itemStackHandler, 0, 8, 9){
                    @Override
                    public boolean mayPlace(@NotNull ItemStack stack) {
                        return stack.getItem() instanceof PolisherItem;
                    }

                    @Override
                    public int getMaxStackSize() {
                        return 1;
                    }
                }));

        //Input
        entity.getInputLazyHandler().ifPresent(itemStackHandler ->
                addSlot(new SlotItemHandler(itemStackHandler, 0, 55, 34){
                    @Override
                    public boolean mayPlace(@NotNull ItemStack stack) {
                        return stack.is(ModTags.Items.RAW_GEM);
                    }
                }));

        //Output
        entity.getOutputLazyHandler().ifPresent(itemStackHandler ->
                addSlot(new SlotItemHandler(itemStackHandler, 0, 130, 33){
                    @Override
                    public boolean mayPlace(@NotNull ItemStack stack) {
                        return false;
                    }
                }));
    }

    public boolean hasUses(){
        return this.data.get(3) > 0;
    }

    public int usesCalculator(){
        int uses = this.data.get(3);
        int maxUses = this.data.get(4);
        int barSize = 59;

        return maxUses != 0 && uses != 0 ? uses * barSize / maxUses : 0;
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 3;  // must be the number of slots you have!
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.GEM_POLISHER.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}

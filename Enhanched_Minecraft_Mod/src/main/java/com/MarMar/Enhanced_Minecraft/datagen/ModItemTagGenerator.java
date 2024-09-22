package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import com.MarMar.Enhanced_Minecraft.Util.ModTags;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Enhanced_Playthrough.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(Tags.Items.RAW_MATERIALS).add(
                ModItems.RAW_TIN.get(),
                ModItems.RAW_BRONZE.get(),
                ModItems.RAW_STEEL.get(),
                ModItems.RAW_SILVER.get(),
                ModItems.RAW_EMERALD.get(),
                ModItems.RAW_SAPPHIRE.get(),
                ModItems.RAW_RUBI.get(),
                ModItems.RAW_DIAMOND.get()
        );

        this.tag(Tags.Items.INGOTS).add(
                ModItems.TIN_INGOT.get(),
                ModItems.BRONZE_INGOT.get(),
                ModItems.SILVER_INGOT.get(),
                ModItems.STEEL_INGOT.get(),
                ModItems.ROSE_GOLD_INGOT.get(),
                ModItems.GREEN_GOLD_INGOT.get()
        );

        this.tag(Tags.Items.NUGGETS).add(
                ModItems.TIN_NUGGET.get(),
                ModItems.COPPER_NUGGET.get(),
                ModItems.BRONZE_NUGGET.get(),
                ModItems.SILVER_NUGGET.get(),
                ModItems.ROSE_GOLD_NUGGET.get(),
                ModItems.GREEN_GOLD_NUGGET.get()
        );

        this.tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
                ModBlocks.COBBLED_LIMESTONE.get().asItem()
        );

        this.tag(ItemTags.LOGS_THAT_BURN).add(
                ModBlocks.WALNUT_LOG.get().asItem(),
                ModBlocks.STRIPPED_WALNUT_LOG.get().asItem(),
                ModBlocks.WALNUT_WOOD.get().asItem(),
                ModBlocks.STRIPPED_WALNUT_WOOD.get().asItem(),
                ModBlocks.APPLE_LOG.get().asItem(),
                ModBlocks.STRIPPED_APPLE_LOG.get().asItem(),
                ModBlocks.APPLE_WOOD.get().asItem(),
                ModBlocks.STRIPPED_APPLE_WOOD.get().asItem()
        );

        this.tag(ItemTags.PLANKS).add(
                ModBlocks.WALNUT_PLANKS.get().asItem(),
                ModBlocks.APPLE_PLANKS.get().asItem()
        );

        this.tag(ModTags.Items.WALNUT_LOGS).add(
                ModBlocks.WALNUT_LOG.get().asItem(),
                ModBlocks.STRIPPED_WALNUT_LOG.get().asItem()
        );

        this.tag(ModTags.Items.APPLE_LOGS).add(
                ModBlocks.APPLE_LOG.get().asItem(),
                ModBlocks.STRIPPED_APPLE_LOG.get().asItem()
        );

        this.tag(ModTags.Items.BRONZE).add(
                ModItems.BRONZE_INGOT.get(),
                ModItems.BRONZE_SWORD.get(),
                ModItems.BRONZE_PICKAXE.get(),
                ModItems.BRONZE_AXE.get(),
                ModItems.BRONZE_SHOVEL.get(),
                ModItems.BRONZE_HOE.get(),
                ModItems.BRONZE_HELMET.get(),
                ModItems.BRONZE_CHESTPLATE.get(),
                ModItems.BRONZE_LEGGINGS.get(),
                ModItems.BRONZE_BOOTS.get()
        );

        this.tag(ModTags.Items.STEEL).add(ModItems.STEEL_INGOT.get())
                .add(ModItems.STEEL_SWORD.get()).add(ModItems.STEEL_PICKAXE.get())
                .add(ModItems.STEEL_AXE.get()).add(ModItems.STEEL_SHOVEL.get())
                .add(ModItems.STEEL_HOE.get()).add(ModItems.STEEL_HELMET.get()).add(ModItems.STEEL_CHESTPLATE.get())
                .add(ModItems.STEEL_LEGGINGS.get()).add(ModItems.STEEL_BOOTS.get());

        this.tag(ModTags.Items.SILVER).add(ModItems.SILVER_INGOT.get())
                .add(ModItems.SILVER_SWORD.get()).add(ModItems.SILVER_PICKAXE.get())
                .add(ModItems.SILVER_AXE.get()).add(ModItems.SILVER_SHOVEL.get())
                .add(ModItems.SILVER_HOE.get()).add(ModItems.SILVER_HELMET.get()).add(ModItems.SILVER_CHESTPLATE.get())
                .add(ModItems.SILVER_LEGGINGS.get()).add(ModItems.SILVER_BOOTS.get());

        this.tag(ModTags.Items.ROSE_GOLD)
                .add(ModItems.ROSE_GOLD_INGOT.get())
                .add(ModItems.ROSE_GOLDEN_SWORD.get())
                .add(ModItems.ROSE_GOLDEN_PICKAXE.get())
                .add(ModItems.ROSE_GOLDEN_AXE.get())
                .add(ModItems.ROSE_GOLDEN_SHOVEL.get())
                .add(ModItems.ROSE_GOLDEN_HOE.get())
                .add(ModItems.ROSE_GOLDEN_HELMET.get())
                .add(ModItems.ROSE_GOLDEN_CHESTPLATE.get())
                .add(ModItems.ROSE_GOLDEN_LEGGINGS.get())
                .add(ModItems.ROSE_GOLDEN_BOOTS.get());


        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BRONZE_HELMET.get())
                .add(ModItems.BRONZE_CHESTPLATE.get())
                .add(ModItems.BRONZE_LEGGINGS.get())
                .add(ModItems.BRONZE_BOOTS.get())
                .add(ModItems.STEEL_HELMET.get())
                .add(ModItems.STEEL_CHESTPLATE.get())
                .add(ModItems.STEEL_LEGGINGS.get())
                .add(ModItems.STEEL_BOOTS.get())
                .add(ModItems.SILVER_HELMET.get())
                .add(ModItems.SILVER_CHESTPLATE.get())
                .add(ModItems.SILVER_LEGGINGS.get())
                .add(ModItems.SILVER_BOOTS.get())
                .add(ModItems.ROSE_GOLDEN_HELMET.get())
                .add(ModItems.ROSE_GOLDEN_CHESTPLATE.get())
                .add(ModItems.ROSE_GOLDEN_LEGGINGS.get())
                .add(ModItems.ROSE_GOLDEN_BOOTS.get())
                .add(ModItems.BRONZE_LEGGINGS.get());

        this.tag(ModTags.Items.RAW_GEM)
                .add(ModItems.RAW_RUBI.get())
                .add(ModItems.RAW_SAPPHIRE.get())
                .add(ModItems.RAW_EMERALD.get())
                .add(ModItems.RAW_DIAMOND.get());

        this.tag(ModTags.Items.POLISHER_TOOL).add(ModItems.BRONZE_POLISHER.get())
                .add(ModItems.GOLD_POLISHER.get())
                .add(ModItems.STEEL_POLISHER.get())
                .add(ModItems.IRON_POLISHER.get())
                .add(ModItems.DIAMOND_POLISHER.get())
                .add(ModItems.SILVER_POLISHER.get())
                .add(ModItems.NETHERITE_POLISHER.get());
    }
}

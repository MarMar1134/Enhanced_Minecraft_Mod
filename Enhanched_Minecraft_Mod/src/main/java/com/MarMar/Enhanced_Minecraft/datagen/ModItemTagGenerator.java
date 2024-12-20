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
                ModItems.RAW_ZINC.get(),
                ModItems.RAW_SILVER.get(),
                ModItems.RAW_EMERALD.get(),
                ModItems.RAW_SAPPHIRE.get(),
                ModItems.RAW_RUBI.get(),
                ModItems.RAW_DIAMOND.get()
        );

        this.tag(Tags.Items.INGOTS).add(
                ModItems.SILVER_INGOT.get(),
                ModItems.TIN_INGOT.get(),
                ModItems.ZINC_INGOT.get(),
                ModItems.BRONZE_INGOT.get(),
                ModItems.BRASS_INGOT.get(),
                ModItems.ROSE_GOLD_INGOT.get(),
                ModItems.BRONZIUM_INGOT.get(),
                ModItems.STEEL_INGOT.get(),
                ModItems.GREEN_GOLD_INGOT.get()
        );

        this.tag(Tags.Items.NUGGETS).add(
                ModItems.SILVER_NUGGET.get(),
                ModItems.COPPER_NUGGET.get(),
                ModItems.TIN_NUGGET.get(),
                ModItems.ZINC_NUGGET.get(),
                ModItems.BRONZE_NUGGET.get(),
                ModItems.BRASS_NUGGET.get(),
                ModItems.ROSE_GOLD_NUGGET.get(),
                ModItems.BRONZIUM_NUGGET.get(),
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
                ModItems.BRONZE_INGOT.get(), ModItems.BRONZE_NUGGET.get(), ModBlocks.BRONZE_BLOCK.get().asItem(),
                ModItems.BRONZE_SWORD.get(),
                ModItems.BRONZE_PICKAXE.get(), ModItems.BRONZE_AXE.get(), ModItems.BRONZE_SHOVEL.get(), ModItems.BRONZE_HOE.get(),
                ModItems.BRONZE_POLISHER.get(),
                ModItems.BRONZE_HELMET.get(), ModItems.BRONZE_CHESTPLATE.get(), ModItems.BRONZE_LEGGINGS.get(), ModItems.BRONZE_BOOTS.get()
        );

        this.tag(ModTags.Items.BRASS).add(
                ModItems.BRASS_INGOT.get(), ModItems.BRASS_NUGGET.get(), ModBlocks.BRASS_BLOCK.get().asItem(),
                ModItems.BRASS_SWORD.get(),
                ModItems.BRASS_PICKAXE.get(), ModItems.BRASS_AXE.get(), ModItems.BRASS_SHOVEL.get(), ModItems.BRASS_HOE.get(),
                ModItems.BRASS_POLISHER.get(),
                ModItems.BRASS_HELMET.get(), ModItems.BRASS_CHESTPLATE.get(), ModItems.BRASS_LEGGINGS.get(), ModItems.BRASS_BOOTS.get()
        );

        this.tag(ModTags.Items.ROSE_GOLD).add(
                ModItems.ROSE_GOLD_INGOT.get(), ModItems.ROSE_GOLD_NUGGET.get(), ModBlocks.ROSE_GOLD_BLOCK.get().asItem(),
                ModItems.ROSE_GOLDEN_SWORD.get(),
                ModItems.ROSE_GOLDEN_PICKAXE.get(), ModItems.ROSE_GOLDEN_AXE.get(), ModItems.ROSE_GOLDEN_SHOVEL.get(), ModItems.ROSE_GOLDEN_HOE.get(),
                ModItems.ROSE_GOLDEN_POLISHER.get(),
                ModItems.ROSE_GOLDEN_HELMET.get(), ModItems.ROSE_GOLDEN_CHESTPLATE.get(), ModItems.ROSE_GOLDEN_LEGGINGS.get(), ModItems.ROSE_GOLDEN_BOOTS.get()
        );

        this.tag(ModTags.Items.BRONZIUM).add(
                ModItems.BRONZIUM_INGOT.get(), ModItems.BRONZIUM_NUGGET.get(), ModBlocks.BRONZIUM_BLOCK.get().asItem(),
                ModItems.BRONZIUM_SWORD.get(),
                ModItems.BRONZIUM_PICKAXE.get(), ModItems.BRONZIUM_AXE.get(), ModItems.BRONZIUM_SHOVEL.get(), ModItems.BRONZIUM_HOE.get(),
                ModItems.BRONZIUM_POLISHER.get(),
                ModItems.BRONZIUM_HELMET.get(), ModItems.BRONZIUM_CHESTPLATE.get(), ModItems.BRONZIUM_LEGGINGS.get(), ModItems.BRONZIUM_BOOTS.get()
        );

        this.tag(ModTags.Items.STEEL).add(
                ModItems.STEEL_INGOT.get(), ModBlocks.STEEL_BLOCK.get().asItem(),
                ModItems.STEEL_SWORD.get(),
                ModItems.STEEL_PICKAXE.get(), ModItems.STEEL_AXE.get(), ModItems.STEEL_SHOVEL.get(), ModItems.STEEL_HOE.get(),
                ModItems.STEEL_POLISHER.get(),
                ModItems.STEEL_HELMET.get(), ModItems.STEEL_CHESTPLATE.get(), ModItems.STEEL_LEGGINGS.get(), ModItems.STEEL_BOOTS.get()
                );

        this.tag(ModTags.Items.SILVER).add(
                ModItems.SILVER_INGOT.get(), ModItems.SILVER_NUGGET.get(), ModBlocks.SILVER_BLOCK.get().asItem(),
                ModItems.SILVER_SWORD.get(),
                ModItems.SILVER_PICKAXE.get(), ModItems.SILVER_AXE.get(), ModItems.SILVER_SHOVEL.get(), ModItems.SILVER_HOE.get(),
                ModItems.SILVER_POLISHER.get(),
                ModItems.SILVER_HELMET.get(), ModItems.SILVER_CHESTPLATE.get(), ModItems.SILVER_LEGGINGS.get(), ModItems.SILVER_BOOTS.get()
                );

        this.tag(ItemTags.TRIMMABLE_ARMOR).add(
                ModItems.SILVER_HELMET.get(), ModItems.SILVER_CHESTPLATE.get(), ModItems.SILVER_LEGGINGS.get(), ModItems.SILVER_BOOTS.get(),
                ModItems.BRONZE_HELMET.get(), ModItems.BRONZE_CHESTPLATE.get(), ModItems.BRONZE_LEGGINGS.get(), ModItems.BRONZE_BOOTS.get(),
                ModItems.BRASS_HELMET.get(), ModItems.BRASS_CHESTPLATE.get(), ModItems.BRASS_LEGGINGS.get(), ModItems.BRASS_BOOTS.get(),
                ModItems.ROSE_GOLDEN_HELMET.get(), ModItems.ROSE_GOLDEN_CHESTPLATE.get(), ModItems.ROSE_GOLDEN_LEGGINGS.get(), ModItems.ROSE_GOLDEN_BOOTS.get(),
                ModItems.BRONZIUM_HELMET.get(), ModItems.BRONZIUM_CHESTPLATE.get(), ModItems.BRONZIUM_LEGGINGS.get(), ModItems.BRONZIUM_BOOTS.get(),
                ModItems.GREEN_GOLDEN_HELMET.get(), ModItems.GREEN_GOLDEN_CHESTPLATE.get(), ModItems.GREEN_GOLDEN_LEGGINGS.get(), ModItems.GREEN_GOLDEN_BOOTS.get(),
                ModItems.STEEL_HELMET.get(), ModItems.STEEL_CHESTPLATE.get(), ModItems.STEEL_LEGGINGS.get(), ModItems.STEEL_BOOTS.get()
                );

        this.tag(ModTags.Items.RAW_GEM).add(
                ModItems.RAW_RUBI.get(),
                ModItems.RAW_SAPPHIRE.get(),
                ModItems.RAW_GARNET.get(),
                ModItems.RAW_EMERALD.get(),
                ModItems.RAW_DIAMOND.get()
                );

        this.tag(ModTags.Items.POLISHER_TOOL).add(
                ModItems.SILVER_POLISHER.get(),
                ModItems.GOLD_POLISHER.get(),
                ModItems.STONE_POLISHER.get(),
                ModItems.BRASS_POLISHER.get(),
                ModItems.BRONZE_POLISHER.get(),
                ModItems.ROSE_GOLDEN_POLISHER.get(),
                ModItems.BRONZIUM_POLISHER.get(),
                ModItems.GREEN_GOLDEN_POLISHER.get(),
                ModItems.IRON_POLISHER.get(),
                ModItems.STEEL_POLISHER.get(),
                ModItems.DIAMOND_POLISHER.get(),
                ModItems.NETHERITE_POLISHER.get()
        );

        this.tag(ItemTags.BEACON_PAYMENT_ITEMS).add(
                ModItems.RUBI.get(),
                ModItems.SAPPHIRE.get(),
                ModItems.GARNET.get(),
                ModItems.SILVER_INGOT.get(),
                ModItems.TIN_INGOT.get(),
                ModItems.ZINC_INGOT.get(),
                ModItems.BRASS_INGOT.get(),
                ModItems.BRONZE_INGOT.get(),
                ModItems.ROSE_GOLD_INGOT.get(),
                ModItems.BRONZIUM_INGOT.get(),
                ModItems.STEEL_INGOT.get(),
                ModItems.GREEN_GOLD_INGOT.get()
        );

        this.tag(ItemTags.PIGLIN_LOVED).add(
                ModItems.ROSE_GOLD_INGOT.get(),
                ModItems.GREEN_GOLD_INGOT.get()
        );
    }

}

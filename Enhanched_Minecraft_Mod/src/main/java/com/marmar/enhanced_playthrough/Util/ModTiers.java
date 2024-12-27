package com.marmar.enhanced_playthrough.Util;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import com.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModTiers {
    public static final Tier SILVER = TierSortingRegistry.registerTier(
            new ForgeTier(0, 64, 13F, 2f, 21,
                    ModTags.Blocks.NEEDS_SILVER_TOOL, () -> Ingredient.of(ModItems.SILVER_INGOT.get())),
            new ResourceLocation(EnhancedPlaythrough.MOD_ID, "silver_ingot"), List.of(Tiers.GOLD),
            List.of(Tiers.IRON)
    );
    public static final Tier BRASS = TierSortingRegistry.registerTier(
            new ForgeTier(1, 120, 3F, 1F, 7,
                    ModTags.Blocks.NEEDS_BRASS_TOOL, () -> Ingredient.of(ModItems.BRASS_INGOT.get())),
            new ResourceLocation(EnhancedPlaythrough.MOD_ID, "brass_ingot"), List.of(Tiers.STONE),
            List.of(Tiers.IRON)
    );
    public static final Tier BRONZE = TierSortingRegistry.registerTier(
            new ForgeTier(1, 200, 5F, 2F, 12,
                    ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModItems.BRONZE_INGOT.get())),
            new ResourceLocation(EnhancedPlaythrough.MOD_ID, "bronze_ingot"), List.of(Tiers.STONE),
            List.of(Tiers.IRON)
    );
    public static final Tier ROSE_GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(1, 200, 8F, 2f, 16,
                    ModTags.Blocks.NEEDS_ROSE_GOLD_TOOL, () -> Ingredient.of(ModItems.ROSE_GOLD_INGOT.get())),
            new ResourceLocation(EnhancedPlaythrough.MOD_ID, "rose_gold_ingot"), List.of(Tiers.STONE),
            List.of(Tiers.IRON)
    );
    public static final Tier BRONZIUM = TierSortingRegistry.registerTier(
            new ForgeTier(1, 300, 6F, 2F, 14,
                    ModTags.Blocks.NEEDS_BRONZIUM_TOOL, () -> Ingredient.of(ModItems.BRONZIUM_INGOT.get())),
            new ResourceLocation(EnhancedPlaythrough.MOD_ID, "bronzium_ingot"), List.of(Tiers.IRON),
            List.of(Tiers.DIAMOND)
    );
    public static final Tier STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(2, 908, 7F, 3.5F, 16,
                    ModTags.Blocks.NEEDS_STEEL_TOOL,() -> Ingredient.of(ModItems.STEEL_INGOT.get())),
            new ResourceLocation(EnhancedPlaythrough.MOD_ID, "steel_ingot"), List.of(Tiers.IRON),
                    List.of(Tiers.DIAMOND)
    );
    public static final Tier GREEN_GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(2, 500, 13F, 2f, 21,
                    ModTags.Blocks.NEEDS_GREEN_GOLD_TOOL, () -> Ingredient.of(ModItems.GREEN_GOLD_INGOT.get())),
            new ResourceLocation(EnhancedPlaythrough.MOD_ID, "green_gold_ingot"), List.of(Tiers.IRON),
            List.of(Tiers.DIAMOND)
    );
}

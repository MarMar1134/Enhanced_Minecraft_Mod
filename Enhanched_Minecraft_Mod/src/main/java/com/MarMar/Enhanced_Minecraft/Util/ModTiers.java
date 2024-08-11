package com.MarMar.Enhanced_Minecraft.Util;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModTiers {
    public static final Tier Silver = TierSortingRegistry.registerTier(
            new ForgeTier(1, 64, 13F, 2f, 21,
                    Tags.Blocks.NEEDS_GOLD_TOOL, () -> Ingredient.of(ModItems.Silver_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "silver_ingot"), List.of(Tiers.GOLD),
            List.of(Tiers.IRON)
    );
    public static final Tier Bronze = TierSortingRegistry.registerTier(
            new ForgeTier(2, 200, 5F, 2F, 12,
                    ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModItems.Bronze_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "bronze_ingot"), List.of(Tiers.STONE),
            List.of(Tiers.IRON)
    );
    public static final Tier Rose_gold = TierSortingRegistry.registerTier(
            new ForgeTier(2, 200, 8F, 2f, 16,
                    ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModItems.Rose_gold_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "rose_gold_ingot"), List.of(Tiers.STONE),
            List.of(Tiers.IRON)
    );
    public static final Tier Steel = TierSortingRegistry.registerTier(
            new ForgeTier(3, 908, 7F, 3.5F, 16,
                    ModTags.Blocks.NEEDS_STEEL_TOOL,() -> Ingredient.of(ModItems.Steel_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "steel_ingot"), List.of(Tiers.IRON),
                    List.of(Tiers.DIAMOND)
    );
    public static final Tier Green_gold = TierSortingRegistry.registerTier(
            new ForgeTier(3, 500, 13F, 2f, 21,
                    BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.Green_gold_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "green_gold_ingot"), List.of(Tiers.IRON),
            List.of(Tiers.DIAMOND)
    );

//    public static final Tier Rusty = TierSortingRegistry.registerTier(
//            new ForgeTier(0,100, 0.0F, 1.0F, 1,
//                    () -> Ingredient.of(ModItems.) )
//    )
}

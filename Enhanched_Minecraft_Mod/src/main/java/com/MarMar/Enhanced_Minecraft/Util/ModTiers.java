package com.MarMar.Enhanced_Minecraft.Util;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModTiers {
    public static final Tier Bronze = TierSortingRegistry.registerTier(
            new ForgeTier(2, 200, 5F, 2F, 12,
                    ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModItems.Bronze_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "bronze_ingot"), List.of(Tiers.STONE),
            List.of(Tiers.IRON)
    );
    public static final Tier Steel = TierSortingRegistry.registerTier(
            new ForgeTier(4, 567, 7F, 3.5F, 16,
                    ModTags.Blocks.NEEDS_STEEL_TOOL,() -> Ingredient.of(ModItems.Steel_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "steel_ingot"), List.of(Tiers.IRON),
                    List.of(Tiers.DIAMOND)
    );
    public static final Tier Silver = TierSortingRegistry.registerTier(
            new ForgeTier(1, 64, 13F, 2f, 21,
                    ModTags.Blocks.NEEDS_SILVER_TOOL, () -> Ingredient.of(ModItems.Silver_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "silver_ingot"), List.of(Tiers.GOLD),
            List.of(Tiers.IRON)
    );
//    public static final Tier Rusty = TierSortingRegistry.registerTier(
//            new ForgeTier(0,100, 0.0F, 1.0F, 1,
//                    () -> Ingredient.of(ModItems.) )
//    )
}

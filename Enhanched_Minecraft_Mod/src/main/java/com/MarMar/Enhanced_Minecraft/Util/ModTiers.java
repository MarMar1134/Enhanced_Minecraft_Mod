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
            new ForgeTier(2, 200, 1.5F, 1.5F, 12,
                    ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModItems.Bronze_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "bronze_ingot"), List.of(Tiers.IRON),
            List.of(Tiers.DIAMOND)
    );
    public static final Tier Steel = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1134, 3F, 3.5F, 16,
                    ModTags.Blocks.NEEDS_STEEL_TOOL,() -> Ingredient.of(ModItems.Steel_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "steel_ingot"), List.of(Tiers.DIAMOND),
                    List.of(Tiers.NETHERITE)
    );
//    public static final Tier Rusty = TierSortingRegistry.registerTier(
//            new ForgeTier(0,100, 0.0F, 1.0F, 1,
//                    () -> Ingredient.of(ModItems.) )
//    )
}

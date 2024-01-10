package com.MarMar.Enhanced_Minecraft.Util;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModTiers {
    public static final Tier Bronze = TierSortingRegistry.registerTier(
            new ForgeTier(2, 200, 5.0F, 1.5F, 16,
                    ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModItems.Bronze_ingot.get())),
            new ResourceLocation(Enhanced_Minecraft.MOD_ID, "bronze_ingot"), List.of(net.minecraft.world.item.Tiers.STONE),
            List.of(net.minecraft.world.item.Tiers.IRON)
    );
}

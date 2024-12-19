package com.MarMar.Enhanced_Minecraft.worldgen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    //Trees
    public static final ResourceKey<PlacedFeature> WALNUT_PLACED_KEY = registerKey("walnut_placed");
    public static final ResourceKey<PlacedFeature> APPLE_PLACED_KEY = registerKey("apple_placed");

    //Nature
    public static final ResourceKey<PlacedFeature> LIMESTONE_PLACED_KEY = registerKey("limestone_placed");
    public static final ResourceKey<PlacedFeature> GRAVEL_MUD_PLACED_KEY = registerKey("gravel_mud_placed");
    public static final ResourceKey<PlacedFeature> SAND_MUD_PLACED_KEY = registerKey("sand_mud_placed");

    //Ores
    public static final ResourceKey<PlacedFeature> NETHER_COPPER_ORE_PLACED_KEY = registerKey("nether_copper_ore_placed");

    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_TIN_ORE_PLACED_KEY = registerKey("extra_tin_ore_placed");

    public static final ResourceKey<PlacedFeature> ZINC_ORE_PLACED_KEY = registerKey("zinc_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ZINC_ORE_PLACED_KEY = registerKey("nether_zinc_ore_placed");

    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_SILVER_ORE_PLACED_KEY = registerKey("extra_silver_ore_placed");

    public static final ResourceKey<PlacedFeature> SULPHUR_ORE_PLACED_KEY = registerKey("sulphur_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_SULPHUR_ORE_PLACED_KEY = registerKey("nether_sulphur_ore_placed");

    public static final ResourceKey<PlacedFeature> SAPHIRE_ORE_PLACED_KEY = registerKey("saphire_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBI_ORE_PLACED_KEY = registerKey("rubi_ore_placed");
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //Trees
            //Walnut
            register(context, WALNUT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WALNUT_KEY),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 3),
                            ModBlocks.WALNUT_SAPLING.get()));

            //Apple
            register(context, APPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.APPLE_KEY),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1f, 1),
                            ModBlocks.APPLE_SAPLING.get()));

        //Mud
        register(context, GRAVEL_MUD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GRAVEL_MUD_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-6), VerticalAnchor.absolute(66))));

        register(context, SAND_MUD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SAND_MUD_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-6), VerticalAnchor.absolute(60))));

        //Limestone
        register(context, LIMESTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIMESTONE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(200))));

        //Copper
        register(context, NETHER_COPPER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_COPPER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256))));

        //Tin
        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(80))));

        register(context, EXTRA_TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EXTRA_TIN_ORE_KEY),
                ModOrePlacement.commonOrePlacement(15,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(90), VerticalAnchor.absolute(200))));

        //Zinc
        register(context, ZINC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ZINC_ORE_KEY),
                ModOrePlacement.commonOrePlacement(13,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(15))));

        register(context, NETHER_ZINC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_ZINC_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        //Silver
        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(40))));
        register(context, EXTRA_SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EXTRA_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(41), VerticalAnchor.absolute(110))));

        //Sulphur
        register(context, SULPHUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SULFUR_ORE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(80))));
        register(context, NETHER_SULPHUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_SULFUR_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(80))));

        //Sapphire
        register(context, SAPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SAPHIRE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(480))));

        //Rubi
        register(context, RUBI_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBI_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(480))));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Enhanced_Playthrough.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

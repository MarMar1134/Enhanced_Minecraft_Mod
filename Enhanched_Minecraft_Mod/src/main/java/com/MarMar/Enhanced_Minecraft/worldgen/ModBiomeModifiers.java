package com.MarMar.Enhanced_Minecraft.worldgen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    //Trees
    public static final ResourceKey<BiomeModifier> ADD_WALNUT = registerKey("add_walnut");
    public static final ResourceKey<BiomeModifier> ADD_APPLE = registerKey("add_apple");


    //Nature
    public static final ResourceKey<BiomeModifier> ADD_LIMESTONE = registerKey("add_limestone");
    public static final ResourceKey<BiomeModifier> ADD_GRAVEL_MUD = registerKey("add_gravel_mud");
    public static final ResourceKey<BiomeModifier> ADD_SAND_MUD = registerKey("add_sand_mud");

    //Ores
    public static final ResourceKey<BiomeModifier> ADD_NETHER_COPPER_ORE = registerKey("add_nether_copper_ore");

    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE = registerKey("add_tin_ore");
    public static final ResourceKey<BiomeModifier> ADD_EXTRA_TIN_ORE = registerKey("add_extra_tin_ore");

    public static final ResourceKey<BiomeModifier> ADD_ZINC_ORE = registerKey("add_zinc_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_ZINC_ORE = registerKey("add_nether_zinc_ore");

    public static final ResourceKey<BiomeModifier> ADD_SILVER_ORE = registerKey("add_silver_ore");
    public static final ResourceKey<BiomeModifier> ADD_EXTRA_SILVER_ORE = registerKey("add_extra_silver_ore");

    public static final ResourceKey<BiomeModifier> ADD_SULPHUR_ORE = registerKey("add_sulphur_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_SULPHUR_ORE = registerKey("add_nether_sulphur_ore");

    public static final ResourceKey<BiomeModifier> ADD_SAPHIRE_ORE = registerKey("add_saphire_ore");
    public static final ResourceKey<BiomeModifier> ADD_RUBI_ORE = registerKey("add_rubi_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        //Trees
            //Walnut
            context.register(ADD_WALNUT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                    biomes.getOrThrow(BiomeTags.IS_TAIGA),
                    HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.WALNUT_PLACED_KEY)),
                    GenerationStep.Decoration.VEGETAL_DECORATION));

            //Apple
            context.register(ADD_APPLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                    biomes.getOrThrow(BiomeTags.IS_FOREST),
                    HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.APPLE_PLACED_KEY)),
                    GenerationStep.Decoration.VEGETAL_DECORATION));

        //Mud
        context.register(ADD_GRAVEL_MUD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_RIVER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.GRAVEL_MUD_PLACED_KEY)),
                GenerationStep.Decoration.LAKES));

        context.register(ADD_SAND_MUD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_RIVER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SAND_MUD_PLACED_KEY)),
                GenerationStep.Decoration.LAKES));

        //Limestone
        context.register(ADD_LIMESTONE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LIMESTONE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));

        //Copper
        context.register(ADD_NETHER_COPPER_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_COPPER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Tin
        context.register(ADD_TIN_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TIN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_EXTRA_TIN_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.EXTRA_TIN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Zinc
        context.register(ADD_ZINC_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ZINC_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_ZINC_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_ZINC_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Silver
        context.register(ADD_SILVER_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SILVER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_EXTRA_SILVER_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.EXTRA_SILVER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Sulphur
        context.register(ADD_SULPHUR_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SULPHUR_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_SULPHUR_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_SULPHUR_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Sapphire
        context.register(ADD_SAPHIRE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SAPHIRE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Rubi
        context.register(ADD_RUBI_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RUBI_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Enhanced_Playthrough.MOD_ID, name));
    }
}

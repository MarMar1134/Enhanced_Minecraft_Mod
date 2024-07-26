package com.MarMar.Enhanced_Minecraft.worldgen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registerKey("sulfur_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SULFUR_ORE_KEY = registerKey("nether_sulfur_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBI_ORE_KEY = registerKey("rubi_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPHIRE_ORE_KEY = registerKey("saphire_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest ironReplaceable = new TagMatchTest(BlockTags.IRON_ORES);

        List<OreConfiguration.TargetBlockState> tinOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.Tin_ore.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.Deepslate_tin_ore.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> silverOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.Silver_ore.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.Deepslate_silver_ore.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> saphireOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.Saphire_ore.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.Deepslate_saphire_ore.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> rubiOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.Rubi_ore.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.Deepslate_rubi_ore.get().defaultBlockState()));

        register(context, TIN_ORE_KEY, Feature.ORE, new OreConfiguration(tinOres, 5));
        register(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(silverOres, 6));
        register(context, SAPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(saphireOres, 4));
        register(context, RUBI_ORE_KEY, Feature.ORE, new OreConfiguration(rubiOres, 3));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Enhanced_Minecraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
    {context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

package com.marmar.enhanced_playthrough.worldgen;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import com.marmar.enhanced_playthrough.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    //Trees
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_KEY = registerKey("walnut");
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("apple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_APPLE_KEY = registerKey("green_apple");

    //Nature
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIMESTONE_KEY = registerKey("limestone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRAVEL_MUD_KEY = registerKey("gravel_mud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAND_MUD_KEY = registerKey("sand_mud");

    //Ores
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE_KEY = registerKey("nether_copper_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_TIN_ORE_KEY = registerKey("extra_tin_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ZINC_ORE_KEY = registerKey("zinc_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ZINC_ORE_KEY = registerKey("nether_zinc_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_SILVER_ORE_KEY = registerKey("extra_silver_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registerKey("sulfur_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SULFUR_ORE_KEY = registerKey("nether_sulfur_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBI_ORE_KEY = registerKey("rubi_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_RUBI_ORE_KEY = registerKey("extra_rubi_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXTRA_SAPPHIRE_ORE_KEY = registerKey("extra_sapphire_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_GARNET_ORE_KEY = registerKey("nether_garnet_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest gravelReplaceable = new BlockMatchTest(Blocks.GRAVEL);
        RuleTest sandReplaceable = new BlockMatchTest(Blocks.SAND);
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);

        RuleTest ironReplaceable = new TagMatchTest(BlockTags.IRON_ORES);

        register(context, WALNUT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.WALNUT_LOG.get()),
                new StraightTrunkPlacer(4, 2, 1),

                BlockStateProvider.simple(ModBlocks.WALNUT_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3),ConstantInt.of(2),3),

                new TwoLayersFeatureSize(2, 1, 3)).build());

        register(context, APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.APPLE_LOG.get()),
                new StraightTrunkPlacer(3, 2, 1),

                BlockStateProvider.simple(ModBlocks.APPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3),ConstantInt.of(2),2),

                new TwoLayersFeatureSize(2, 1, 3)).build());

        register(context, GREEN_APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.APPLE_LOG.get()),
                new StraightTrunkPlacer(3, 2, 1),

                BlockStateProvider.simple(ModBlocks.GREEN_APPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2),ConstantInt.of(1),3),

                new TwoLayersFeatureSize(2, 1, 3)).build());

        //Mud
        List<OreConfiguration.TargetBlockState> gravelMud = List.of(OreConfiguration.target(gravelReplaceable, Blocks.MUD.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> sandMud = List.of(OreConfiguration.target(sandReplaceable, Blocks.MUD.defaultBlockState()));

        register(context, GRAVEL_MUD_KEY, Feature.ORE, new OreConfiguration(gravelMud, 48));
        register(context, SAND_MUD_KEY, Feature.ORE, new OreConfiguration(sandMud, 32));

        //Limestone
        List<OreConfiguration.TargetBlockState> limestone = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.LIMESTONE.get().defaultBlockState()));

        register(context, LIMESTONE_KEY, Feature.ORE, new OreConfiguration(limestone, 32));

        //Nether copper ore
        List<OreConfiguration.TargetBlockState> netherCopperOres = List.of(OreConfiguration.target(netherrackReplaceable,
                ModBlocks.NETHER_COPPER_ORE.get().defaultBlockState()));

        register(context, NETHER_COPPER_ORE_KEY, Feature.ORE, new OreConfiguration(netherCopperOres, 8));

        //Tin ore
        List<OreConfiguration.TargetBlockState> tinOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));

        register(context, TIN_ORE_KEY, Feature.ORE, new OreConfiguration(tinOres, 7));
        register(context, EXTRA_TIN_ORE_KEY, Feature.ORE, new OreConfiguration(tinOres, 7));

        //Zinc ore
        List<OreConfiguration.TargetBlockState> zincOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherZincOres = List.of(OreConfiguration.target(netherrackReplaceable,
                        ModBlocks.NETHER_ZINC_ORE.get().defaultBlockState()));

        register(context, ZINC_ORE_KEY, Feature.ORE, new OreConfiguration(zincOres, 6));
        register(context, NETHER_ZINC_ORE_KEY, Feature.ORE, new OreConfiguration(netherZincOres, 10));

        //Silver ore
        List<OreConfiguration.TargetBlockState> silverOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));

        register(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(silverOres, 7));
        register(context, EXTRA_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(silverOres, 3));

        //Sulphur ore
        List<OreConfiguration.TargetBlockState> sulphurOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.SULFUR_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_SULFUR_ORE.get().defaultBlockState()));

        register(context, SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(sulphurOres, 6));

        List<OreConfiguration.TargetBlockState> netherSulphurOres = List.of(OreConfiguration.target(netherrackReplaceable,
                ModBlocks.NETHER_SULFUR_ORE.get().defaultBlockState()));

        register(context, NETHER_SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(netherSulphurOres, 10));

        //Sapphire ore
        List<OreConfiguration.TargetBlockState> saphireOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));

        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(saphireOres, 8));
        register(context, EXTRA_SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(saphireOres, 6));

        //Rubi ore
        List<OreConfiguration.TargetBlockState> rubiOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.RUBI_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_RUBI_ORE.get().defaultBlockState()));

        register(context, RUBI_ORE_KEY, Feature.ORE, new OreConfiguration(rubiOres, 6));
        register(context, EXTRA_RUBI_ORE_KEY, Feature.ORE, new OreConfiguration(rubiOres, 4));

        //Nether garnet ore
        List<OreConfiguration.TargetBlockState> garnetOres = List.of(OreConfiguration.target(netherrackReplaceable,
                ModBlocks.NETHER_GARNET_ORE.get().defaultBlockState()));

        register(context, NETHER_GARNET_ORE_KEY, Feature.ORE, new OreConfiguration(garnetOres, 5));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(EnhancedPlaythrough.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

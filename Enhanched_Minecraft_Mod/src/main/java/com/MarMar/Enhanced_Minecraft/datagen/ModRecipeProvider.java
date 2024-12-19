package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import com.MarMar.Enhanced_Minecraft.Util.ModTags;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import com.MarMar.Enhanced_Minecraft.recipe.*;
import com.MarMar.Enhanced_Minecraft.recipe.alloy.AlloyingFurnaceRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.alloy.SuperAlloyingRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.basic.BasicSmeltingRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.basic.SoulBasicSmeltingRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.builder.ModAlloyingRecipeBuilder;
import com.MarMar.Enhanced_Minecraft.recipe.builder.ModBasicRecipeBuilder;
import com.MarMar.Enhanced_Minecraft.recipe.builder.ModSmithingTransformRecipeBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    //food
    public static final List<ItemLike> ZAPALLO_COOKABLES = List.of(ModItems.ZAPALLO.get());
    public static final List<ItemLike> EGGPLANT_COOKABLES = List.of(ModItems.EGGPLANT.get());
    public static final List<ItemLike> CORN_COOKABLES = List.of(ModItems.CORN.get());

    //ores
        //tin
        public static final List<ItemLike> BASIC_TIN_SMELTABLES = List.of(ModItems.RAW_TIN.get(),
                ModBlocks.TIN_ORE.get());
        public static final List<ItemLike> TIN_SMELTABLES = List.of(ModItems.RAW_TIN.get(),
                ModBlocks.TIN_ORE.get(), ModBlocks.DEEPSLATE_TIN_ORE.get());
        public static final List<ItemLike> TIN_NUGGET_SMELTABLES = List.of(ModItems.RAW_TIN.get());

        //zinc
        public static final List<ItemLike> BASIC_ZINC_SMELTABLES = List.of(ModItems.RAW_ZINC.get(), ModBlocks.ZINC_ORE.get(),
                ModBlocks.NETHER_ZINC_ORE.get());
        public static final List<ItemLike> ZINC_SMELTABLES = List.of(ModItems.RAW_ZINC.get(), ModBlocks.ZINC_ORE.get(),
                ModBlocks.NETHER_ZINC_ORE.get(), ModBlocks.DEEPSLATE_ZINC_ORE.get());
        public static final List<ItemLike> ZINC_NUGGET_SMELTABLES = List.of(ModBlocks.ZINC_ORE.get(), ModBlocks.NETHER_ZINC_ORE.get());

        //copper
        public static final List<ItemLike> COPPER_SMELTABLES = List.of(Items.RAW_COPPER, Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE, ModBlocks.NETHER_COPPER_ORE.get());
        public static final List<ItemLike> NETHER_COPPER_SMELTABLES = List.of(ModBlocks.NETHER_COPPER_ORE.get());
        public static final List<ItemLike> COPPER_NUGGET_SMELTABLES = List.of(Items.RAW_COPPER);

        //brass
        public static final List<ItemLike> BRASS_NUGGETS_SMELTABLES = List.of(ModItems.BRASS_AXE.get(), ModItems.BRASS_HOE.get(), ModItems.BRASS_PICKAXE.get(), ModItems.BRASS_POLISHER.get(),
                    ModItems.BRASS_SHOVEL.get(), ModItems.BRASS_SWORD.get(), ModItems.BRASS_HELMET.get(), ModItems.BRASS_CHESTPLATE.get(), ModItems.BRASS_LEGGINGS.get(), ModItems.BRASS_BOOTS.get());

        //bronze
        public static final List<ItemLike> BRONZE_NUGGETS_SMELTABLES = List.of(ModItems.BRONZE_AXE.get(),
                ModItems.BRONZE_HOE.get(), ModItems.BRONZE_PICKAXE.get(), ModItems.BRONZE_SHOVEL.get(),
                ModItems.BRONZE_SWORD.get());

        //silver
        public static final List<ItemLike> SILVER_SMELTABLES = List.of(ModItems.RAW_SILVER.get(), ModBlocks.SILVER_ORE.get(),
                ModBlocks.DEEPSLATE_SILVER_ORE.get());
        public static final List<ItemLike> SILVER_NUGGETS_SMELTABLES = List.of(ModItems.SILVER_AXE.get(),
                ModItems.SILVER_HOE.get(), ModItems.SILVER_PICKAXE.get(), ModItems.SILVER_SHOVEL.get(),
                ModItems.SILVER_SWORD.get());

        //rose gold
        public static final List<ItemLike> ROSE_GOLD_NUGGETS_SMELTABLES = List.of(ModItems.ROSE_GOLDEN_AXE.get(),
                ModItems.ROSE_GOLDEN_HOE.get(), ModItems.ROSE_GOLDEN_PICKAXE.get(), ModItems.ROSE_GOLDEN_SHOVEL.get(),
                ModItems.ROSE_GOLDEN_SWORD.get());

    public static final List<ItemLike> COBALT_SMELTABLES = List.of(ModBlocks.DEEPSLATE_COBALT_ORE.get());

    public static final List<ItemLike> LIMESTONE_SMELTABLES = List.of(ModBlocks.COBBLED_LIMESTONE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //Basic smelting recipes
        basicSmelting(consumer, Items.BEEF, Items.COOKED_BEEF, "beef");
        soulBasicSmelting(consumer, Items.BEEF, Items.COOKED_BEEF, "beef");

        basicSmelting(consumer, Items.CHICKEN, Items.COOKED_CHICKEN, "chicken");
        soulBasicSmelting(consumer, Items.CHICKEN, Items.COOKED_CHICKEN, "chicken");

        basicSmelting(consumer, Items.PORKCHOP, Items.COOKED_PORKCHOP, "porkchop");
        soulBasicSmelting(consumer, Items.PORKCHOP, Items.COOKED_PORKCHOP, "porkchop");

        basicSmelting(consumer, Items.MUTTON, Items.COOKED_MUTTON, "mutton");
        soulBasicSmelting(consumer, Items.MUTTON, Items.COOKED_MUTTON, "mutton");

        basicSmelting(consumer, Items.SALMON, Items.COOKED_SALMON, "salmon");
        soulBasicSmelting(consumer, Items.SALMON, Items.COOKED_SALMON, "salmon");

        basicSmelting(consumer, Items.COD, Items.COOKED_COD, "cod");
        soulBasicSmelting(consumer, Items.COD, Items.COOKED_COD, "cod");

        basicSmelting(consumer, Items.RABBIT, Items.COOKED_RABBIT, "rabbit");
        soulBasicSmelting(consumer, Items.RABBIT, Items.COOKED_RABBIT, "rabbit");

        basicSmelting(consumer, Items.POTATO, Items.BAKED_POTATO, "potato");
        soulBasicSmelting(consumer, Items.POTATO, Items.BAKED_POTATO, "potato");

        basicSmelting(consumer, Items.CACTUS, Items.GREEN_DYE, "cactus");
        soulBasicSmelting(consumer, Items.CACTUS, Items.GREEN_DYE, "cactus");

        //Smelting Recipes
            //food
            basicSmelting(consumer, ZAPALLO_COOKABLES, ModItems.COOKED_ZAPALLO.get(), "zapallo");
            basicSmelting(consumer, EGGPLANT_COOKABLES, ModItems.COOKED_EGGPLANT.get(), "eggplant");
            basicSmelting(consumer, CORN_COOKABLES, ModItems.COOKED_CORN.get(), "corn");

            soulBasicSmelting(consumer, ZAPALLO_COOKABLES, ModItems.COOKED_ZAPALLO.get(), "zapallo");
            soulBasicSmelting(consumer, EGGPLANT_COOKABLES, ModItems.COOKED_EGGPLANT.get(), "eggplant");
            soulBasicSmelting(consumer, CORN_COOKABLES, ModItems.COOKED_CORN.get(), "corn");

            oreSmelting(consumer, ZAPALLO_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_ZAPALLO.get(),
                    2f, 100, "zapallo");
            oreSmelting(consumer, EGGPLANT_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_EGGPLANT.get(),
                    2f, 100, "eggplant");
            oreSmelting(consumer, CORN_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_CORN.get(),
                    2f, 100, "corn");

            smoking(consumer, ZAPALLO_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_ZAPALLO.get(),
                    2f, 100, "zapallo");
            smoking(consumer, EGGPLANT_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_EGGPLANT.get(),
                    2f, 100, "eggplant");
            smoking(consumer, CORN_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_CORN.get(),
                    2f, 100, "corn");

            byCampfire(consumer, ZAPALLO_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_ZAPALLO.get(),
                    2f, 100, "zapallo");
            byCampfire(consumer, EGGPLANT_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_EGGPLANT.get(),
                    2f, 100, "eggplant");
            byCampfire(consumer, CORN_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_CORN.get(),
                    2f, 100, "corn");

            //copper
            basicSmelting(consumer, COPPER_SMELTABLES, Items.COPPER_INGOT, "copper_ingot");
            soulBasicSmelting(consumer, COPPER_SMELTABLES, Items.COPPER_INGOT, "copper_ingot");

            oreSmelting(consumer, NETHER_COPPER_SMELTABLES, RecipeCategory.MISC, Items.COPPER_INGOT,
                    2f, 100, "copper_ingot");
            oreBlasting(consumer, NETHER_COPPER_SMELTABLES, RecipeCategory.MISC, Items.COPPER_INGOT,
                    2f, 200, "copper_ingot");

            byCampfire(consumer, COPPER_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(),
                1.0f, 300, "copper_nugget");

            //tin
            basicSmelting(consumer, BASIC_TIN_SMELTABLES, ModItems.TIN_INGOT.get(), "tin_ingot");
            soulBasicSmelting(consumer, BASIC_TIN_SMELTABLES, ModItems.TIN_INGOT.get(), "tin_ingot");
            oreSmelting(consumer, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(),
                2f, 100, "tin_ingot");
            oreBlasting(consumer, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(),
                    2f, 200, "tin_ingot");
            byCampfire(consumer, TIN_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_NUGGET.get(),
                    1.0f, 300, "tin_nugget");

            //Zinc
            basicSmelting(consumer, BASIC_ZINC_SMELTABLES, ModItems.ZINC_INGOT.get(), "zinc_ingot");
            soulBasicSmelting(consumer, BASIC_ZINC_SMELTABLES, ModItems.ZINC_INGOT.get(), "zinc_ingot");
            oreSmelting(consumer, ZINC_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_INGOT.get(),
                    1.5F, 100, "zinc_ingot");
            oreBlasting(consumer, ZINC_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_INGOT.get(),
                    1.5F, 200, "zinc_ingot");
            byCampfire(consumer, ZINC_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_NUGGET.get(),
                    1.0F, 300, "zinc_nugget");

            //brass
            oreSmelting(consumer, BRASS_NUGGETS_SMELTABLES, RecipeCategory.MISC, ModItems.BRASS_NUGGET.get(),
                    0.5f, 100, "brass_nugget");
            oreBlasting(consumer, BRASS_NUGGETS_SMELTABLES, RecipeCategory.MISC, ModItems.BRASS_NUGGET.get(),
                    0.5f, 200, "brass_nugget");

            //bronze
            oreSmelting(consumer, BRONZE_NUGGETS_SMELTABLES, RecipeCategory.MISC, ModItems.BRONZE_NUGGET.get(),
                    0.5f, 100, "bronze_nugget");
            oreBlasting(consumer, BRONZE_NUGGETS_SMELTABLES, RecipeCategory.MISC, ModItems.BRONZE_NUGGET.get(),
                    0.5f, 200, "bronze_nugget");

            //silver
            oreSmelting(consumer, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(),
                2f, 100, "silver_ingot");
            oreBlasting(consumer, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(),
                    2f, 200, "silver_ingot");
            oreSmelting(consumer, SILVER_NUGGETS_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_NUGGET.get(),
                    0.5f, 100, "silver_nugget");
            oreBlasting(consumer, SILVER_NUGGETS_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_NUGGET.get(),
                    0.5f, 200, "silver_nugget");

            //rose gold
            oreSmelting(consumer, ROSE_GOLD_NUGGETS_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_GOLD_NUGGET.get(),
                    0.5f, 100, "rose_gold_nugget");
            oreBlasting(consumer, ROSE_GOLD_NUGGETS_SMELTABLES, RecipeCategory.MISC, ModItems.ROSE_GOLD_NUGGET.get(),
                    0.5f, 200, "rose_gold_nugget");

            //limestone
            oreSmelting(consumer, LIMESTONE_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE.get(),
                    0.3f, 100, "limestone");
            oreBlasting(consumer, LIMESTONE_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE.get(),
                    0.3f, 200, "limestone");

        //Ore alloy recipes
            //Brass
            oreAlloying(consumer, ModItems.RAW_ZINC.get(), Items.RAW_COPPER, ModItems.BRASS_INGOT.get(), "brass_ingot");
            oreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_ZINC.get(), ModItems.BRASS_INGOT.get(), "brass_ingot");

            superOreAlloying(consumer, ModItems.RAW_ZINC.get(), Items.RAW_COPPER, ModItems.BRASS_INGOT.get(), "brass_ingot");
            superOreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_ZINC.get(), ModItems.BRASS_INGOT.get(),"brass_ingot");
            superOreAlloying(consumer, ModItems.ZINC_INGOT.get(), Items.COPPER_INGOT, ModItems.BRASS_INGOT.get(), 2, "brass_ingot");
            superOreAlloying(consumer, Items.COPPER_INGOT, ModItems.ZINC_INGOT.get(), ModItems.BRASS_INGOT.get(), 2, "brass_ingot");

            //Bronze
            oreAlloying(consumer, ModItems.RAW_TIN.get(), Items.RAW_COPPER, ModItems.BRONZE_INGOT.get(), "bronze_ingot");
            oreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_TIN.get(), ModItems.BRONZE_INGOT.get(), "bronze_ingot");

            superOreAlloying(consumer, ModItems.RAW_TIN.get(), Items.RAW_COPPER, ModItems.BRONZE_INGOT.get(), "bronze_ingot");
            superOreAlloying(consumer, Items.RAW_COPPER, ModItems.RAW_TIN.get(), ModItems.BRONZE_INGOT.get(), "bronze_ingot");
            superOreAlloying(consumer, ModItems.TIN_INGOT.get(), Items.COPPER_INGOT, ModItems.BRONZE_INGOT.get(), 2, "bronze_ingot");
            superOreAlloying(consumer, Items.COPPER_INGOT, ModItems.TIN_INGOT.get(), ModItems.BRONZE_INGOT.get(), 2, "bronze_ingot");

            //Rose gold
            superOreAlloying(consumer, Items.RAW_GOLD, Items.RAW_COPPER, ModItems.ROSE_GOLD_INGOT.get(), "rose_gold_ingot");
            superOreAlloying(consumer, Items.RAW_COPPER, Items.RAW_GOLD, ModItems.ROSE_GOLD_INGOT.get(), "rose_gold_ingot");
            superOreAlloying(consumer, Items.GOLD_INGOT, Items.COPPER_INGOT, ModItems.ROSE_GOLD_INGOT.get(), 2, "rose_gold_ingot");
            superOreAlloying(consumer, Items.COPPER_INGOT, Items.GOLD_INGOT, ModItems.ROSE_GOLD_INGOT.get(), 2, "rose_gold_ingot");

            //Bronzium
            superOreAlloying(consumer, ModItems.BRASS_INGOT.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_INGOT.get(), "bronzium_ingot");
            superOreAlloying(consumer, ModItems.BRONZE_INGOT.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_INGOT.get(), "bronzium_ingot");

            //Steel
            oreAlloying(consumer, Items.COAL, Items.RAW_IRON, ModItems.STEEL_INGOT.get(), "steel_ingot");
            oreAlloying(consumer, Items.RAW_IRON, Items.COAL, ModItems.STEEL_INGOT.get(), "steel_ingot");

            superOreAlloying(consumer, Items.COAL, Items.RAW_IRON, ModItems.STEEL_INGOT.get(), "steel_ingot");
            superOreAlloying(consumer, Items.RAW_IRON, Items.COAL, ModItems.STEEL_INGOT.get(), "steel_ingot");
            superOreAlloying(consumer, Items.COAL, Items.IRON_INGOT, ModItems.STEEL_INGOT.get(), 2, "steel_ingot");
            superOreAlloying(consumer, Items.IRON_INGOT, Items.COAL, ModItems.STEEL_INGOT.get(), 2, "steel_ingot");

            //Green gold
            superOreAlloying(consumer, Items.RAW_GOLD, ModItems.RAW_SILVER.get(), ModItems.GREEN_GOLD_INGOT.get(), "green_gold_ingot");
            superOreAlloying(consumer, ModItems.RAW_SILVER.get(), Items.RAW_GOLD, ModItems.GREEN_GOLD_INGOT.get(), "green_gold_ingot");
            superOreAlloying(consumer, Items.GOLD_INGOT, ModItems.SILVER_INGOT.get(), ModItems.GREEN_GOLD_INGOT.get(), 2, "green_gold_ingot");
            superOreAlloying(consumer, ModItems.SILVER_INGOT.get(), Items.GOLD_INGOT, ModItems.GREEN_GOLD_INGOT.get(), 2, "green_gold_ingot");

        //Polishing recipes
        gemPolishing(consumer, ModItems.RAW_EMERALD.get(), "gems", Items.EMERALD);
        gemPolishing(consumer, ModItems.RAW_SAPPHIRE.get(), "gems", ModItems.SAPPHIRE.get());
        gemPolishing(consumer, ModItems.RAW_RUBI.get(), "gems", ModItems.RUBI.get());
        gemPolishing(consumer, ModItems.RAW_DIAMOND.get(), "gems", Items.DIAMOND);

        //Grinding recipes
        itemGrinding(consumer, ModItems.YERBA_MATE.get(), "food", ModItems.GROUNDED_YERBA_MATE.get(), 2);
        itemGrinding(consumer, Items.WHEAT, "food", ModItems.WHEAT_FLOUR.get(), 2);
        itemGrinding(consumer, Items.PUMPKIN, "food", ModItems.PUMPKIN_FLOUR.get(), 2);
        itemGrinding(consumer, Items.SUGAR_CANE, "food", Items.SUGAR, 3);
        itemGrinding(consumer, Items.BONE, "misc", Items.BONE_MEAL, 3);
        itemGrinding(consumer, ModItems.COBALT.get(), "misc", ModItems.COBALT_DUST.get(), 1);
        itemGrinding(consumer, ItemTags.WOOL, "misc", Items.STRING, 4);
        itemGrinding(consumer, ModItems.WALNUT.get(), "food", ModItems.PEELED_WALNUT.get(), 2);

            //Dyes
            itemGrinding(consumer, Items.BONE_MEAL, "dyes", Items.WHITE_DYE, 3);
            itemGrinding(consumer, Items.LILY_OF_THE_VALLEY, "dyes", Items.WHITE_DYE, 3);

            itemGrinding(consumer, Items.AZURE_BLUET, "dyes", Items.LIGHT_GRAY_DYE, 3);
            itemGrinding(consumer, Items.OXEYE_DAISY, "dyes", Items.LIGHT_GRAY_DYE, 3);
            itemGrinding(consumer, Items.WHITE_TULIP, "dyes", Items.LIGHT_GRAY_DYE, 3);

            itemGrinding(consumer, Items.WITHER_ROSE, "dyes", Items.BLACK_DYE, 3);

            itemGrinding(consumer, Items.COCOA_BEANS, "dyes", Items.BROWN_DYE, 3);

            itemGrinding(consumer, Items.POPPY, "dyes", Items.RED_DYE, 3);
            itemGrinding(consumer, Items.RED_TULIP, "dyes", Items.RED_DYE, 3);
            itemGrinding(consumer, Items.ROSE_BUSH, "dyes", Items.RED_DYE, 6);
            itemGrinding(consumer, Items.BEETROOT, "dyes", Items.RED_DYE, 2);

            itemGrinding(consumer, Items.ORANGE_TULIP, "dyes", Items.ORANGE_DYE, 3);
            itemGrinding(consumer, Items.TORCHFLOWER, "dyes", Items.ORANGE_DYE, 3);

            itemGrinding(consumer, Items.DANDELION, "dyes", Items.YELLOW_DYE, 3);
            itemGrinding(consumer, Items.SUNFLOWER, "dyes", Items.YELLOW_DYE, 6);

            itemGrinding(consumer, Items.PITCHER_PLANT, "dyes", Items.CYAN_DYE, 6);

            itemGrinding(consumer, Items.BLUE_ORCHID, "dyes", Items.LIGHT_BLUE_DYE, 3);

            itemGrinding(consumer, Items.LAPIS_LAZULI, "dyes", Items.BLUE_DYE, 3);
            itemGrinding(consumer, Items.CORNFLOWER, "dyes", Items.BLUE_DYE, 3);

            itemGrinding(consumer, Items.ALLIUM, "dyes", Items.MAGENTA_DYE, 3);
            itemGrinding(consumer, Items.LILAC, "dyes", Items.MAGENTA_DYE, 6);

            itemGrinding(consumer, Items.PINK_TULIP, "dyes", Items.PINK_DYE, 3);
            itemGrinding(consumer, Items.PEONY, "dyes", Items.PINK_DYE, 6);
            itemGrinding(consumer, Items.PINK_PETALS, "dyes", Items.PINK_DYE, 3);

        //Stone cutting recipes
            //Stone
            stoneCutting(consumer, Items.STONE, ModBlocks.POLISHED_STONE.get(), 1);
            stoneCutting(consumer, Items.STONE, ModBlocks.POLISHED_STONE_SLAB.get(), 2);
            stoneCutting(consumer, Items.STONE, ModBlocks.POLISHED_STONE_STAIRS.get(), 1);
            stoneCutting(consumer, Items.STONE, ModBlocks.POLISHED_STONE_WALL.get(), 1);

            //Polished stone
            stoneCutting(consumer, ModBlocks.POLISHED_STONE.get(), ModBlocks.POLISHED_STONE_SLAB.get(), 2);
            stoneCutting(consumer, ModBlocks.POLISHED_STONE.get(), ModBlocks.POLISHED_STONE_STAIRS.get(), 1);
            stoneCutting(consumer, ModBlocks.POLISHED_STONE.get(), ModBlocks.POLISHED_STONE_WALL.get(), 1);

            //Cobbled limestone
            stoneCutting(consumer, ModBlocks.COBBLED_LIMESTONE.get(), ModBlocks.COBBLED_LIMESTONE_SLAB.get(), 2);
            stoneCutting(consumer, ModBlocks.COBBLED_LIMESTONE.get(), ModBlocks.COBBLED_LIMESTONE_STAIRS.get(), 1);
            stoneCutting(consumer, ModBlocks.COBBLED_LIMESTONE.get(), ModBlocks.COBBLED_LIMESTONE_WALL.get(), 1);

            //Limestone
            stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_SLAB.get(), 2);
            stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_STAIRS.get(), 1);

            stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE.get(), 1);
            stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_SLAB.get(), 2);
            stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_STAIRS.get(), 1);
            stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_WALL.get(), 1);

            stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_BRICKS.get(), 1);
            stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_BRICK_SLAB.get(), 2);
            stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_BRICK_STAIRS.get(), 1);
            stoneCutting(consumer, ModBlocks.LIMESTONE.get(), ModBlocks.LIMESTONE_BRICK_WALL.get(), 1);

            //Polished limestone
            stoneCutting(consumer, ModBlocks.POLISHED_LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_SLAB.get(), 2);
            stoneCutting(consumer, ModBlocks.POLISHED_LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_STAIRS.get(), 1);
            stoneCutting(consumer, ModBlocks.POLISHED_LIMESTONE.get(), ModBlocks.POLISHED_LIMESTONE_WALL.get(), 1);

            //Limestone bricks
            stoneCutting(consumer, ModBlocks.LIMESTONE_BRICKS.get(), ModBlocks.LIMESTONE_BRICK_SLAB.get(), 2);
            stoneCutting(consumer, ModBlocks.LIMESTONE_BRICKS.get(), ModBlocks.LIMESTONE_BRICK_STAIRS.get(), 1);
            stoneCutting(consumer, ModBlocks.LIMESTONE_BRICKS.get(), ModBlocks.LIMESTONE_BRICK_WALL.get(), 1);

            //Soul
            stoneCutting(consumer, ModBlocks.SOUL_MUD_BRICKS.get(), ModBlocks.SOUL_MUD_BRICK_SLAB.get(), 2);
            stoneCutting(consumer, ModBlocks.SOUL_MUD_BRICKS.get(), ModBlocks.SOUL_MUD_BRICK_STAIRS.get(), 1);
            stoneCutting(consumer, ModBlocks.SOUL_MUD_BRICKS.get(), ModBlocks.SOUL_MUD_BRICK_WALL.get(), 1);

        //Smithing
            //Bronzium
                //Brass to bronzium
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRASS_AXE.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_AXE.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRASS_PICKAXE.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_PICKAXE.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRASS_SHOVEL.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_SHOVEL.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRASS_HOE.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_HOE.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRASS_POLISHER.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_POLISHER.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRASS_SWORD.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_SWORD.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRASS_HELMET.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_HELMET.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRASS_CHESTPLATE.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_CHESTPLATE.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRASS_LEGGINGS.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_LEGGINGS.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRASS_BOOTS.get(), ModItems.BRONZE_INGOT.get(), ModItems.BRONZIUM_BOOTS.get());

                //Bronze to bronzium
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRONZE_AXE.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_AXE.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRONZE_PICKAXE.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_PICKAXE.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRONZE_SHOVEL.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_SHOVEL.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRONZE_HOE.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_HOE.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRONZE_POLISHER.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_POLISHER.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRONZE_SWORD.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_SWORD.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRONZE_HELMET.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_HELMET.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRONZE_CHESTPLATE.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_CHESTPLATE.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRONZE_LEGGINGS.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_LEGGINGS.get());
                smithingUpgrade(consumer, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), ModItems.BRONZE_BOOTS.get(), ModItems.BRASS_INGOT.get(), ModItems.BRONZIUM_BOOTS.get());


        //Shaped and shapeless recipes
            //Foods
            ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.EMPTY_MATE.get())
                    .pattern("#")
                    .pattern("I")
                    .define('#', Items.IRON_INGOT)
                    .define('I', ModItems.COOKED_ZAPALLO.get())
                    .unlockedBy(getHasName(ModItems.COOKED_ZAPALLO.get()), has(ModItems.COOKED_ZAPALLO.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GROUNDED_YERBA_MATE.get())
                    .pattern(" I ")
                    .pattern("I I")
                    .pattern(" I ")
                    .define('I', ModItems.YERBA_MATE.get())
                    .unlockedBy(getHasName(ModItems.YERBA_MATE.get()), has(ModItems.YERBA_MATE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.MATE.get())
                    .pattern("I")
                    .pattern("A")
                    .define('I', ModItems.GROUNDED_YERBA_MATE.get())
                    .define('A', ModItems.EMPTY_MATE.get())
                    .unlockedBy(getHasName(ModItems.YERBA_MATE.get()), has(ModItems.YERBA_MATE.get()))
                    .save(consumer);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.YEAST.get(), 4)
                    .requires(Items.BROWN_MUSHROOM, 2)
                    .requires(Items.SUGAR)
                    .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                    .unlockedBy(getHasName(Items.BROWN_MUSHROOM), has(Items.BROWN_MUSHROOM))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.WHEAT_FLOUR.get(), 3)
                    .pattern("AAA")
                    .define('A', Items.WHEAT)
                    .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                    .unlockedBy(getHasName(ModItems.WHEAT_FLOUR.get()), has(ModItems.WHEAT_FLOUR.get()))
                    .save(consumer);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.PEELED_WALNUT.get())
                    .requires(ModItems.WALNUT.get())
                    .unlockedBy(getHasName(ModItems.WALNUT.get()), has(ModItems.WALNUT.get()))
                    .save(consumer);

            //Ores
                //Copper
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 9)
                        .requires(Items.COPPER_INGOT)
                        .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                        .save(consumer);

                //Silver
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 9)
                        .requires(ModBlocks.SILVER_BLOCK.get())
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                        .save(consumer);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_NUGGET.get(), 9)
                        .requires(ModItems.SILVER_INGOT.get())
                        .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                        .save(consumer);

                //Tin
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 9)
                        .requires(ModBlocks.TIN_BLOCK.get())
                        .unlockedBy(getHasName(ModItems.TIN_INGOT.get()), has(ModItems.TIN_INGOT.get()))
                        .save(consumer);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN_NUGGET.get(), 9)
                        .requires(ModItems.TIN_INGOT.get())
                        .unlockedBy(getHasName(ModItems.TIN_INGOT.get()), has(ModItems.TIN_INGOT.get()))
                        .save(consumer);

                //Zinc
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZINC_INGOT.get(), 9)
                        .requires(ModBlocks.ZINC_BLOCK.get())
                        .unlockedBy(getHasName(ModItems.ZINC_INGOT.get()), has(ModItems.ZINC_INGOT.get()))
                        .save(consumer);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZINC_NUGGET.get(), 9)
                        .requires(ModItems.ZINC_INGOT.get())
                        .unlockedBy(getHasName(ModItems.ZINC_INGOT.get()), has(ModItems.ZINC_INGOT.get()))
                        .save(consumer);

                //Brass
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRASS_INGOT.get(), 9)
                        .requires(ModBlocks.BRASS_BLOCK.get())
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRASS_NUGGET.get(), 9)
                        .requires(ModItems.BRASS_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);

                //Bronze
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 9)
                        .requires(ModBlocks.BRONZE_BLOCK.get())
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZE_NUGGET.get(), 9)
                        .requires(ModItems.BRONZE_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);

                //Rose gold
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT.get(), 9)
                        .requires(ModBlocks.ROSE_GOLD_BLOCK.get())
                        .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                        .save(consumer);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROSE_GOLD_NUGGET.get(), 9)
                        .requires(ModItems.ROSE_GOLD_INGOT.get())
                        .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                        .save(consumer);

                //Bronzium
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZIUM_INGOT.get(), 9)
                        .requires(ModBlocks.BRONZIUM_BLOCK.get())
                        .unlockedBy(getHasName(ModItems.BRONZIUM_INGOT.get()), has(ModItems.BRONZIUM_INGOT.get()))
                        .save(consumer);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZIUM_NUGGET.get(), 9)
                        .requires(ModItems.BRONZIUM_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRONZIUM_INGOT.get()), has(ModItems.BRONZIUM_INGOT.get()))
                        .save(consumer);

                //Steel
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
                        .requires(ModBlocks.STEEL_BLOCK.get())
                        .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                        .save(consumer);

                //Green gold
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GREEN_GOLD_INGOT.get(), 9)
                        .requires(ModBlocks.GREEN_GOLD_BLOCK.get())
                        .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                        .save(consumer);
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GREEN_GOLD_NUGGET.get(), 9)
                        .requires(ModItems.GREEN_GOLD_INGOT.get())
                        .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                        .save(consumer);

                //Smithing templates
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get(), 2)
                        .pattern("DAD")
                        .pattern("DVD")
                        .pattern("CCC")
                        .define('A', ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get())
                        .define('V', ModItems.BRONZIUM_INGOT.get())
                        .define('D', ModItems.ZINC_INGOT.get())
                        .define('C', ModItems.TIN_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get()), has(ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get()))
                        .save(consumer);

        //Block recipes
            //Ore blocks
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SILVER_BLOCK.get(), 1)
                    .pattern("TTT")
                    .pattern("TTT")
                    .pattern("TTT")
                    .define('T', ModItems.SILVER_INGOT.get())
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get(), 1)
                    .pattern("TTT")
                    .pattern("TTT")
                    .pattern("TTT")
                    .define('T', ModItems.TIN_INGOT.get())
                    .unlockedBy(getHasName(ModItems.TIN_INGOT.get()), has(ModItems.TIN_INGOT.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZINC_BLOCK.get(), 1)
                    .pattern("TTT")
                    .pattern("TTT")
                    .pattern("TTT")
                    .define('T', ModItems.ZINC_INGOT.get())
                    .unlockedBy(getHasName(ModItems.ZINC_INGOT.get()), has(ModItems.ZINC_INGOT.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BRASS_BLOCK.get(), 1)
                    .pattern("TTT")
                    .pattern("TTT")
                    .pattern("TTT")
                    .define('T', ModItems.BRASS_INGOT.get())
                    .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BRONZE_BLOCK.get(), 1)
                    .pattern("TTT")
                    .pattern("TTT")
                    .pattern("TTT")
                    .define('T', ModItems.BRONZE_INGOT.get())
                    .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_GOLD_BLOCK.get(), 1)
                    .pattern("TTT")
                    .pattern("TTT")
                    .pattern("TTT")
                    .define('T', ModItems.ROSE_GOLD_INGOT.get())
                    .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BRONZIUM_BLOCK.get(), 1)
                    .pattern("TTT")
                    .pattern("TTT")
                    .pattern("TTT")
                    .define('T', ModItems.BRONZIUM_INGOT.get())
                    .unlockedBy(getHasName(ModItems.BRONZIUM_INGOT.get()), has(ModItems.BRONZIUM_INGOT.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get(), 1)
                    .pattern("TTT")
                    .pattern("TTT")
                    .pattern("TTT")
                    .define('T', ModItems.STEEL_INGOT.get())
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_GOLD_BLOCK.get(), 1)
                    .pattern("TTT")
                    .pattern("TTT")
                    .pattern("TTT")
                    .define('T', ModItems.GREEN_GOLD_INGOT.get())
                    .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                    .save(consumer);

        //Polished stone
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE.get(), 6)
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', Items.STONE)
                    .unlockedBy(getHasName(Items.STONE), has(Items.STONE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_SLAB.get(), 6)
                    .pattern("AAA")
                    .define('A', ModBlocks.POLISHED_STONE.get())
                    .unlockedBy(getHasName(ModBlocks.POLISHED_STONE.get()), has(ModBlocks.POLISHED_STONE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_STAIRS.get(), 4)
                    .pattern("A  ")
                    .pattern("AA ")
                    .pattern("AAA")
                    .define('A', ModBlocks.POLISHED_STONE.get())
                    .unlockedBy(getHasName(ModBlocks.POLISHED_STONE.get()), has(ModBlocks.POLISHED_STONE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STONE_WALL.get(), 6)
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', ModBlocks.POLISHED_STONE.get())
                    .unlockedBy(getHasName(ModBlocks.POLISHED_STONE.get()), has(ModBlocks.POLISHED_STONE.get()))
                    .save(consumer);

            //Cobbled limestone
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_LIMESTONE_SLAB.get(), 6)
                    .pattern("AAA")
                    .define('A', ModBlocks.COBBLED_LIMESTONE.get())
                    .unlockedBy(getHasName(ModBlocks.COBBLED_LIMESTONE.get()), has(ModBlocks.COBBLED_LIMESTONE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_LIMESTONE_STAIRS.get(), 4)
                    .pattern("A  ")
                    .pattern("AA ")
                    .pattern("AAA")
                    .define('A', ModBlocks.COBBLED_LIMESTONE.get())
                    .unlockedBy(getHasName(ModBlocks.COBBLED_LIMESTONE.get()), has(ModBlocks.COBBLED_LIMESTONE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_LIMESTONE_WALL.get(), 6)
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', ModBlocks.COBBLED_LIMESTONE.get())
                    .unlockedBy(getHasName(ModBlocks.COBBLED_LIMESTONE.get()), has(ModBlocks.COBBLED_LIMESTONE.get()))
                    .save(consumer);

            //Limestone
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_SLAB.get(), 6)
                    .pattern("AAA")
                    .define('A', ModBlocks.LIMESTONE.get())
                    .unlockedBy(getHasName(ModBlocks.LIMESTONE.get()), has(ModBlocks.LIMESTONE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_STAIRS.get(), 4)
                    .pattern("A  ")
                    .pattern("AA ")
                    .pattern("AAA")
                    .define('A', ModBlocks.LIMESTONE.get())
                    .unlockedBy(getHasName(ModBlocks.LIMESTONE.get()), has(ModBlocks.LIMESTONE.get()))
                    .save(consumer);

            //Polished limestone
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE.get(), 6)
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', ModBlocks.LIMESTONE.get())
                    .unlockedBy(getHasName(ModBlocks.LIMESTONE.get()), has(ModBlocks.LIMESTONE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_SLAB.get(), 6)
                    .pattern("AAA")
                    .define('A', ModBlocks.POLISHED_LIMESTONE.get())
                    .unlockedBy(getHasName(ModBlocks.POLISHED_LIMESTONE.get()), has(ModBlocks.POLISHED_LIMESTONE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_STAIRS.get(), 4)
                    .pattern("A  ")
                    .pattern("AA ")
                    .pattern("AAA")
                    .define('A', ModBlocks.POLISHED_LIMESTONE.get())
                    .unlockedBy(getHasName(ModBlocks.POLISHED_LIMESTONE.get()), has(ModBlocks.POLISHED_LIMESTONE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_LIMESTONE_WALL.get(), 6)
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', ModBlocks.POLISHED_LIMESTONE.get())
                    .unlockedBy(getHasName(ModBlocks.POLISHED_LIMESTONE.get()), has(ModBlocks.POLISHED_LIMESTONE.get()))
                    .save(consumer);

            //Limestone bricks
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICKS.get(), 4)
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', ModBlocks.LIMESTONE.get())
                    .unlockedBy(getHasName(ModBlocks.LIMESTONE.get()), has(ModBlocks.LIMESTONE.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_SLAB.get(), 6)
                    .pattern("AAA")
                    .define('A', ModBlocks.LIMESTONE_BRICKS.get())
                    .unlockedBy(getHasName(ModBlocks.LIMESTONE_BRICKS.get()), has(ModBlocks.LIMESTONE_BRICKS.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_STAIRS.get(), 4)
                    .pattern("A  ")
                    .pattern("AA ")
                    .pattern("AAA")
                    .define('A', ModBlocks.LIMESTONE_BRICKS.get())
                    .unlockedBy(getHasName(ModBlocks.LIMESTONE_BRICKS.get()), has(ModBlocks.LIMESTONE_BRICKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMESTONE_BRICK_WALL.get(), 6)
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', ModBlocks.LIMESTONE_BRICKS.get())
                    .unlockedBy(getHasName(ModBlocks.LIMESTONE_BRICKS.get()), has(ModBlocks.LIMESTONE_BRICKS.get()))
                    .save(consumer);

            //Soul
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_MUD.get(), 4)
                    .pattern("MG")
                    .pattern("GM")
                    .define('M', Items.GRAVEL)
                    .define('G', Items.SOUL_SOIL)
                    .unlockedBy(getHasName(Items.SOUL_SOIL), has(Items.SOUL_SOIL))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_MUD_BRICKS.get(), 4)
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', ModBlocks.SOUL_MUD.get())
                    .unlockedBy(getHasName(ModBlocks.SOUL_MUD.get()), has(ModBlocks.SOUL_MUD.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_MUD_BRICK_SLAB.get(), 6)
                    .pattern("AAA")
                    .define('A', ModBlocks.SOUL_MUD_BRICKS.get())
                    .unlockedBy(getHasName(ModBlocks.SOUL_MUD_BRICKS.get()), has(ModBlocks.SOUL_MUD_BRICKS.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_MUD_BRICK_STAIRS.get(), 4)
                    .pattern("A  ")
                    .pattern("AA ")
                    .pattern("AAA")
                    .define('A', ModBlocks.SOUL_MUD_BRICKS.get())
                    .unlockedBy(getHasName(ModBlocks.SOUL_MUD_BRICKS.get()), has(ModBlocks.SOUL_MUD_BRICKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_MUD_BRICK_WALL.get(), 6)
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', ModBlocks.SOUL_MUD_BRICKS.get())
                    .unlockedBy(getHasName(ModBlocks.SOUL_MUD_BRICKS.get()), has(ModBlocks.SOUL_MUD_BRICKS.get()))
                    .save(consumer);

            //walnut wood
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUT_WOOD.get(), 3)
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', ModBlocks.WALNUT_LOG.get())
                    .unlockedBy(getHasName(ModBlocks.WALNUT_LOG.get()), has(ModBlocks.WALNUT_LOG.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_WALNUT_WOOD.get(), 3)
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', ModBlocks.STRIPPED_WALNUT_LOG.get())
                    .unlockedBy(getHasName(ModBlocks.STRIPPED_WALNUT_LOG.get()), has(ModBlocks.STRIPPED_WALNUT_LOG.get()))
                    .save(consumer);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUT_PLANKS.get(), 4)
                    .requires(ModTags.Items.WALNUT_LOGS)
                    .unlockedBy(getHasName(ModBlocks.WALNUT_LOG.get()), has(ModBlocks.WALNUT_LOG.get()))
                    .unlockedBy(getHasName(ModBlocks.WALNUT_WOOD.get()), has(ModBlocks.WALNUT_WOOD.get()))
                    .unlockedBy(getHasName(ModBlocks.STRIPPED_WALNUT_LOG.get()), has(ModBlocks.STRIPPED_WALNUT_LOG.get()))
                    .unlockedBy(getHasName(ModBlocks.STRIPPED_WALNUT_WOOD.get()), has(ModBlocks.STRIPPED_WALNUT_WOOD.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUT_DOOR.get(), 3)
                    .pattern("AA")
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', ModBlocks.WALNUT_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUT_TRAPDOOR.get(), 2)
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', ModBlocks.WALNUT_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get()))
                    .save(consumer);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.WALNUT_BUTTON.get())
                    .requires(ModBlocks.WALNUT_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WALNUT_PRESSURE_PLATE.get())
                    .pattern("AA")
                    .define('A', ModBlocks.WALNUT_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUT_SLAB.get(), 6)
                    .pattern("AAA")
                    .define('A', ModBlocks.WALNUT_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUT_STAIRS.get(), 4)
                    .pattern("A  ")
                    .pattern("AA ")
                    .pattern("AAA")
                    .define('A', ModBlocks.WALNUT_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUT_FENCE.get(), 3)
                    .pattern("ABA")
                    .pattern("ABA")
                    .define('A', ModBlocks.WALNUT_PLANKS.get())
                    .define('B', Items.STICK)
                    .unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUT_FENCEGATE.get())
                    .pattern("BAB")
                    .pattern("BAB")
                    .define('A', ModBlocks.WALNUT_PLANKS.get())
                    .define('B', Items.STICK)
                    .unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.WALNUT_PLANKS.get()))
                    .save(consumer);

            //Apple wood
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLE_WOOD.get(), 3)
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', ModBlocks.APPLE_LOG.get())
                    .unlockedBy(getHasName(ModBlocks.APPLE_LOG.get()), has(ModBlocks.APPLE_LOG.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_APPLE_WOOD.get(), 3)
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', ModBlocks.STRIPPED_APPLE_LOG.get())
                    .unlockedBy(getHasName(ModBlocks.STRIPPED_APPLE_LOG.get()), has(ModBlocks.STRIPPED_APPLE_LOG.get()))
                    .save(consumer);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLE_PLANKS.get(), 4)
                    .requires(ModTags.Items.APPLE_LOGS)
                    .unlockedBy(getHasName(ModBlocks.APPLE_LOG.get()), has(ModBlocks.APPLE_LOG.get()))
                    .unlockedBy(getHasName(ModBlocks.APPLE_WOOD.get()), has(ModBlocks.APPLE_WOOD.get()))
                    .unlockedBy(getHasName(ModBlocks.STRIPPED_APPLE_LOG.get()), has(ModBlocks.STRIPPED_APPLE_LOG.get()))
                    .unlockedBy(getHasName(ModBlocks.STRIPPED_APPLE_WOOD.get()), has(ModBlocks.STRIPPED_APPLE_WOOD.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLE_DOOR.get(), 3)
                    .pattern("AA")
                    .pattern("AA")
                    .pattern("AA")
                    .define('A', ModBlocks.APPLE_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.APPLE_PLANKS.get()), has(ModBlocks.APPLE_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLE_TRAPDOOR.get(), 2)
                    .pattern("AAA")
                    .pattern("AAA")
                    .define('A', ModBlocks.APPLE_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.APPLE_PLANKS.get()), has(ModBlocks.APPLE_PLANKS.get()))
                    .save(consumer);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.APPLE_BUTTON.get())
                    .requires(ModBlocks.APPLE_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.WALNUT_PLANKS.get()), has(ModBlocks.APPLE_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.APPLE_PRESSURE_PLATE.get())
                    .pattern("AA")
                    .define('A', ModBlocks.APPLE_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.APPLE_PLANKS.get()), has(ModBlocks.APPLE_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLE_SLAB.get(), 6)
                    .pattern("AAA")
                    .define('A', ModBlocks.APPLE_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.APPLE_PLANKS.get()), has(ModBlocks.APPLE_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLE_STAIRS.get(), 4)
                    .pattern("A  ")
                    .pattern("AA ")
                    .pattern("AAA")
                    .define('A', ModBlocks.APPLE_PLANKS.get())
                    .unlockedBy(getHasName(ModBlocks.APPLE_PLANKS.get()), has(ModBlocks.APPLE_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLE_FENCE.get(), 3)
                    .pattern("ABA")
                    .pattern("ABA")
                    .define('A', ModBlocks.APPLE_PLANKS.get())
                    .define('B', Items.STICK)
                    .unlockedBy(getHasName(ModBlocks.APPLE_PLANKS.get()), has(ModBlocks.APPLE_PLANKS.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APPLE_FENCEGATE.get())
                    .pattern("BAB")
                    .pattern("BAB")
                    .define('A', ModBlocks.APPLE_PLANKS.get())
                    .define('B', Tags.Items.RODS_WOODEN)
                    .unlockedBy(getHasName(ModBlocks.APPLE_PLANKS.get()), has(ModBlocks.APPLE_PLANKS.get()))
                    .save(consumer);

            //Entities
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ADOBE_FURNACE.get())
                    .pattern("###")
                    .pattern("# #")
                    .pattern("III")
                    .define('#', Blocks.MUD_BRICKS)
                    .define('I', ItemTags.STONE_CRAFTING_MATERIALS)
                    .unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE))
                    .unlockedBy(getHasName(Blocks.MUD_BRICKS), has(Blocks.MUD_BRICKS))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUL_FURNACE.get())
                    .pattern("###")
                    .pattern("# #")
                    .pattern("###")
                    .define('#', ModBlocks.SOUL_MUD.get())
                    .unlockedBy(getHasName(ModBlocks.SOUL_MUD.get()), has(ModBlocks.SOUL_MUD.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ADOBE_ALLOYING_FURNACE.get())
                    .pattern("###")
                    .pattern("#A#")
                    .pattern("III")
                    .define('#', Blocks.BRICKS)
                    .define('A', ModBlocks.ADOBE_FURNACE.get())
                    .define('I', Blocks.COBBLESTONE)
                    .unlockedBy(getHasName(ModBlocks.ADOBE_FURNACE.get()), has(ModBlocks.ADOBE_FURNACE.get()))
                    .unlockedBy(getHasName(ModItems.RAW_TIN.get()), has(ModItems.RAW_TIN.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SUPER_ALLOYING_FURNACE.get())
                    .pattern("###")
                    .pattern("#A#")
                    .pattern("III")
                    .define('#', ModItems.STEEL_INGOT.get())
                    .define('A', ModBlocks.ADOBE_ALLOYING_FURNACE.get())
                    .define('I', Blocks.COBBLED_DEEPSLATE)
                    .unlockedBy(getHasName(Blocks.COBBLED_DEEPSLATE), has(Blocks.COBBLED_DEEPSLATE))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUL_ALLOY_FURNACE.get())
                    .pattern("###")
                    .pattern("#A#")
                    .pattern("III")
                    .define('#', ModBlocks.SOUL_MUD_BRICKS.get())
                    .define('A', ModBlocks.SOUL_FURNACE.get())
                    .define('I', Blocks.BLACKSTONE)
                    .unlockedBy(getHasName(ModBlocks.SOUL_FURNACE.get()), has(ModBlocks.SOUL_FURNACE.get()))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GEM_POLISHER.get())
                    .pattern("###")
                    .pattern("AIA")
                    .pattern("AIA")
                    .define('#', ItemTags.PLANKS)
                    .define('A', ItemTags.LOGS_THAT_BURN)
                    .define('I', Blocks.STONE)
                    .unlockedBy(getHasName(Blocks.STONE), has(Blocks.STONE))
                    .save(consumer);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRINDER.get())
                    .pattern("#I#")
                    .pattern("#I#")
                    .pattern("###")
                    .define('#', ItemTags.STONE_CRAFTING_MATERIALS)
                    .define('I', Items.IRON_INGOT)
                    .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                    .save(consumer);

            //Gold recipes
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', Items.GOLD_INGOT)
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                    .save(consumer);

        //Silver recipes
            //Silver tools
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SILVER_SWORD.get())
                    .pattern("I")
                    .pattern("I")
                    .pattern("#")
                    .define('I', ModItems.SILVER_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SILVER_PICKAXE.get())
                    .pattern("III")
                    .pattern(" # ")
                    .pattern(" # ")
                    .define('I', ModItems.SILVER_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SILVER_AXE.get())
                    .pattern("II")
                    .pattern("I#")
                    .pattern(" #")
                    .define('I', ModItems.SILVER_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SILVER_SHOVEL.get())
                    .pattern("I")
                    .pattern("#")
                    .pattern("#")
                    .define('I', ModItems.SILVER_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SILVER_HOE.get())
                    .pattern("II")
                    .pattern(" #")
                    .pattern(" #")
                    .define('I', ModItems.SILVER_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SILVER_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', ModItems.SILVER_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);

            //Silver armor
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SILVER_HELMET.get())
                    .pattern("###")
                    .pattern("# #")
                    .define('#', ModItems.SILVER_INGOT.get())
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SILVER_CHESTPLATE.get())
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .define('#', ModItems.SILVER_INGOT.get())
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SILVER_LEGGINGS.get())
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ModItems.SILVER_INGOT.get())
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SILVER_BOOTS.get())
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ModItems.SILVER_INGOT.get())
                    .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                    .save(consumer);

            //Stone recipes
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', Items.STONE)
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(Items.STONE), has(Items.STONE))
                    .save(consumer);

            //Brass recipes
                //Brass tools
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRASS_SWORD.get())
                        .pattern("I")
                        .pattern("I")
                        .pattern("#")
                        .define('I', ModItems.BRASS_INGOT.get())
                        .define('#', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BRASS_PICKAXE.get())
                        .pattern("III")
                        .pattern(" # ")
                        .pattern(" # ")
                        .define('I', ModItems.BRASS_INGOT.get())
                        .define('#', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BRASS_AXE.get())
                        .pattern("II")
                        .pattern("I#")
                        .pattern(" #")
                        .define('I', ModItems.BRASS_INGOT.get())
                        .define('#', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BRASS_SHOVEL.get())
                        .pattern("I")
                        .pattern("#")
                        .pattern("#")
                        .define('I', ModItems.BRASS_INGOT.get())
                        .define('#', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BRASS_HOE.get())
                        .pattern("II")
                        .pattern(" #")
                        .pattern(" #")
                        .define('I', ModItems.BRASS_INGOT.get())
                        .define('#', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BRASS_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', ModItems.BRASS_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                    .save(consumer);

                //Brass armor
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRASS_HELMET.get())
                        .pattern("###")
                        .pattern("# #")
                        .define('#', ModItems.BRASS_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRASS_CHESTPLATE.get())
                        .pattern("# #")
                        .pattern("###")
                        .pattern("###")
                        .define('#', ModItems.BRASS_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRASS_LEGGINGS.get())
                        .pattern("###")
                        .pattern("# #")
                        .pattern("# #")
                        .define('#', ModItems.BRASS_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRASS_BOOTS.get())
                        .pattern("# #")
                        .pattern("# #")
                        .define('#', ModItems.BRASS_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRASS_INGOT.get()), has(ModItems.BRASS_INGOT.get()))
                        .save(consumer);

            //Bronze recipes
                //Bronze tools
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_SWORD.get())
                        .pattern("I")
                        .pattern("I")
                        .pattern("#")
                        .define('I', ModItems.BRONZE_INGOT.get())
                        .define('#', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE.get())
                        .pattern("III")
                        .pattern(" # ")
                        .pattern(" # ")
                        .define('I', ModItems.BRONZE_INGOT.get())
                        .define('#', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BRONZE_AXE.get())
                        .pattern("II")
                        .pattern("I#")
                        .pattern(" #")
                        .define('I', ModItems.BRONZE_INGOT.get())
                        .define('#', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL.get())
                        .pattern("I")
                        .pattern("#")
                        .pattern("#")
                        .define('I', ModItems.BRONZE_INGOT.get())
                        .define('#', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BRONZE_HOE.get())
                        .pattern("II")
                        .pattern(" #")
                        .pattern(" #")
                        .define('I', ModItems.BRONZE_INGOT.get())
                        .define('#', Items.STICK)
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BRONZE_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', ModItems.BRONZE_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                    .save(consumer);

                //Bronze armor
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_HELMET.get())
                        .pattern("###")
                        .pattern("# #")
                        .define('#', ModItems.BRONZE_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_CHESTPLATE.get())
                        .pattern("# #")
                        .pattern("###")
                        .pattern("###")
                        .define('#', ModItems.BRONZE_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_LEGGINGS.get())
                        .pattern("###")
                        .pattern("# #")
                        .pattern("# #")
                        .define('#', ModItems.BRONZE_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);
                ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_BOOTS.get())
                        .pattern("# #")
                        .pattern("# #")
                        .define('#', ModItems.BRONZE_INGOT.get())
                        .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                        .save(consumer);

        //Iron recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_POLISHER.get())
                .pattern(" I")
                .pattern("# ")
                .define('I', Items.IRON_INGOT)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);

        //Rose gold recipes
            //Rose gold tools
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLDEN_SWORD.get())
                    .pattern("I")
                    .pattern("I")
                    .pattern("#")
                    .define('I', ModItems.ROSE_GOLD_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLDEN_PICKAXE.get())
                    .pattern("III")
                    .pattern(" # ")
                    .pattern(" # ")
                    .define('I', ModItems.ROSE_GOLD_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLDEN_AXE.get())
                    .pattern("II")
                    .pattern("I#")
                    .pattern(" #")
                    .define('I', ModItems.ROSE_GOLD_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLDEN_SHOVEL.get())
                    .pattern("I")
                    .pattern("#")
                    .pattern("#")
                    .define('I', ModItems.ROSE_GOLD_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLDEN_HOE.get())
                    .pattern("II")
                    .pattern(" #")
                    .pattern(" #")
                    .define('I', ModItems.ROSE_GOLD_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                    .save(consumer);

            //Rose gold armor
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLDEN_HELMET.get())
                    .pattern("###")
                    .pattern("# #")
                    .define('#', ModItems.ROSE_GOLD_INGOT.get())
                    .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLDEN_CHESTPLATE.get())
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .define('#', ModItems.ROSE_GOLD_INGOT.get())
                    .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLDEN_LEGGINGS.get())
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ModItems.ROSE_GOLD_INGOT.get())
                    .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLDEN_BOOTS.get())
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ModItems.ROSE_GOLD_INGOT.get())
                    .unlockedBy(getHasName(ModItems.ROSE_GOLD_INGOT.get()), has(ModItems.ROSE_GOLD_INGOT.get()))
                    .save(consumer);

        //Steel recipes
            //Steel tools
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STEEL_SWORD.get())
                    .pattern("I")
                    .pattern("I")
                    .pattern("#")
                    .define('I', ModItems.STEEL_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STEEL_PICKAXE.get())
                    .pattern("III")
                    .pattern(" # ")
                    .pattern(" # ")
                    .define('I', ModItems.STEEL_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STEEL_AXE.get())
                    .pattern("II")
                    .pattern("I#")
                    .pattern(" #")
                    .define('I', ModItems.STEEL_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STEEL_SHOVEL.get())
                    .pattern("I")
                    .pattern("#")
                    .pattern("#")
                    .define('I', ModItems.STEEL_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STEEL_HOE.get())
                    .pattern("II")
                    .pattern(" #")
                    .pattern(" #")
                    .define('I', ModItems.STEEL_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STEEL_POLISHER.get())
                    .pattern(" I")
                    .pattern("# ")
                    .define('I', ModItems.STEEL_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);

            //Steel armor
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEEL_HELMET.get())
                    .pattern("###")
                    .pattern("# #")
                    .define('#', ModItems.STEEL_INGOT.get())
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEEL_CHESTPLATE.get())
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .define('#', ModItems.STEEL_INGOT.get())
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEEL_LEGGINGS.get())
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ModItems.STEEL_INGOT.get())
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STEEL_BOOTS.get())
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ModItems.STEEL_INGOT.get())
                    .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                    .save(consumer);

        //Green gold recipes
            //Green gold tools
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GREEN_GOLDEN_SWORD.get())
                    .pattern("I")
                    .pattern("I")
                    .pattern("#")
                    .define('I', ModItems.GREEN_GOLD_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GREEN_GOLDEN_PICKAXE.get())
                    .pattern("III")
                    .pattern(" # ")
                    .pattern(" # ")
                    .define('I', ModItems.GREEN_GOLD_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GREEN_GOLDEN_AXE.get())
                    .pattern("II")
                    .pattern("I#")
                    .pattern(" #")
                    .define('I', ModItems.GREEN_GOLD_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GREEN_GOLDEN_SHOVEL.get())
                    .pattern("I")
                    .pattern("#")
                    .pattern("#")
                    .define('I', ModItems.GREEN_GOLD_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GREEN_GOLDEN_HOE.get())
                    .pattern("II")
                    .pattern(" #")
                    .pattern(" #")
                    .define('I', ModItems.GREEN_GOLD_INGOT.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                    .save(consumer);

            //Green gold armor
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GREEN_GOLDEN_HELMET.get())
                    .pattern("###")
                    .pattern("# #")
                    .define('#', ModItems.GREEN_GOLD_INGOT.get())
                    .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GREEN_GOLDEN_CHESTPLATE.get())
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .define('#', ModItems.GREEN_GOLD_INGOT.get())
                    .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GREEN_GOLDEN_LEGGINGS.get())
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ModItems.GREEN_GOLD_INGOT.get())
                    .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GREEN_GOLDEN_BOOTS.get())
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ModItems.GREEN_GOLD_INGOT.get())
                    .unlockedBy(getHasName(ModItems.GREEN_GOLD_INGOT.get()), has(ModItems.GREEN_GOLD_INGOT.get()))
                    .save(consumer);

        //Diamond recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_POLISHER.get())
                .pattern(" I")
                .pattern("# ")
                .define('I', Items.DIAMOND)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(consumer);

        //Food recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.RICE_BOWL.get())
                .pattern("#I")
                .define('I', Items.BOWL)
                .define('#', ModItems.RICE_GRAINS.get())
                .unlockedBy(getHasName(ModItems.RICE_GRAINS.get()), has(ModItems.RICE_GRAINS.get()))
                .save(consumer);

        //New vanilla recipes
            //Food
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.BREAD)
                    .requires(ModItems.WHEAT_FLOUR.get(), 2)
                    .requires(Items.MILK_BUCKET)
                    .requires(ModItems.YEAST.get())
                    .unlockedBy(getHasName(ModItems.WHEAT_FLOUR.get()), has(ModItems.WHEAT_FLOUR.get()))
                    .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                    .save(consumer);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.COOKIE, 8)
                    .requires(ModItems.WHEAT_FLOUR.get(), 2)
                    .requires(Items.COCOA_BEANS, 2)
                    .requires(ModItems.YEAST.get())
                    .unlockedBy(getHasName(ModItems.WHEAT_FLOUR.get()), has(ModItems.WHEAT_FLOUR.get()))
                    .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                    .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                    .save(consumer);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.PUMPKIN_PIE)
                    .requires(ModItems.PUMPKIN_FLOUR.get(), 2)
                    .requires(ModItems.YEAST.get())
                    .unlockedBy(getHasName(ModItems.PUMPKIN_FLOUR.get()), has(ModItems.PUMPKIN_FLOUR.get()))
                    .unlockedBy(getHasName(Items.PUMPKIN), has(Items.PUMPKIN))
                    .save(consumer);

            //Redstone
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Items.REPEATER)
                    .pattern("W#W")
                    .pattern("III")
                    .define('W', Items.REDSTONE_TORCH)
                    .define('#', ModItems.TIN_INGOT.get())
                    .define('I', Blocks.STONE)
                    .unlockedBy(getHasName(ModItems.TIN_INGOT.get()), has(ModItems.TIN_INGOT.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Items.COMPARATOR)
                    .pattern("WWW")
                    .pattern("AFA")
                    .pattern("III")
                    .define('W', Items.REDSTONE_TORCH)
                    .define('F', ModItems.TIN_INGOT.get())
                    .define('A', Items.REDSTONE)
                    .define('I', Blocks.STONE)
                    .unlockedBy(getHasName(ModItems.TIN_INGOT.get()), has(ModItems.TIN_INGOT.get()))
                    .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                    .save(consumer);

            //Items
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BREWING, Items.GUNPOWDER)
                    .requires(ModItems.SULFUR.get())
                    .requires(Items.CHARCOAL)
                    .unlockedBy(getHasName(ModItems.SULFUR.get()), has(ModItems.SULFUR.get()))
                    .unlockedBy(getHasName(Items.CHARCOAL), has(Items.CHARCOAL))
                    .save(consumer);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BREWING, Items.BONE_MEAL, 3)
                    .requires(Items.BONE, 3)
                    .unlockedBy(getHasName(Items.BONE), has(Items.BONE))
                    .unlockedBy(getHasName(Items.BONE_MEAL), has(Items.BONE_MEAL))
                    .unlockedBy(getHasName(Items.BONE_BLOCK), has(Items.BONE_BLOCK))
                    .save(consumer);

            //Blocks
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD, 2)
                    .pattern("#A")
                    .pattern("A#")
                    .define('#', Blocks.DIRT)
                    .define('A', Items.CLAY_BALL)
                    .unlockedBy(getHasName(Blocks.DIRT), has(Blocks.DIRT))
                    .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.BLAST_FURNACE)
                    .pattern("III")
                    .pattern("IFI")
                    .pattern("###")
                    .define('I', ModItems.STEEL_INGOT.get())
                    .define('F', Blocks.FURNACE)
                    .define('#', Blocks.SMOOTH_STONE)
                    .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.FURNACE)
                    .pattern("III")
                    .pattern("#F#")
                    .pattern("###")
                    .define('I', ModItems.BRONZE_INGOT.get())
                    .define('F', ModBlocks.ADOBE_FURNACE.get())
                    .define('#', Blocks.COBBLESTONE)
                    .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
                    .save(consumer);
    }

    //Specific recipe builders
        //Vanilla
        protected static void byCampfire(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup){
            oreCooking(pFinishedRecipeConsumer, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_campfire");
        }
        protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
            oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
        }
        protected static void smoking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
            oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMOKING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smoking");
        }
        protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
            oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        //Polish
        protected static void gemPolishing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, String group, ItemLike result){
            gemPolishingSerialize(pFinishedRecipeConsumer, ingredient, result, group, ModRecipes.POLISHING_SERIALIZER.get(), "from_gem_polishing");
        }

        //Grind
        protected static void itemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, String group, ItemLike result, int count){
            oreGrindingSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, ModRecipes.GRINDING_SERIALIZER.get(), "from_grinding");
        }
        protected static void itemGrinding(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> ingredient, String group, ItemLike result, int count){
            oreGrindingTagSerialize(pFinishedRecipeConsumer, ingredient, result, group, count, ModRecipes.GRINDING_SERIALIZER.get(), "from_grinding");
        }

        //Basic smelt
        protected static void basicSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, ItemLike result, String group){
            basicSmeltSerialize(pFinishedRecipeConsumer, ingredient, result, group, ModRecipes.BASIC_SMELTING_SERIALIZER.get(), "from_basic_smelting");
        }
        protected static void basicSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> ingredients, ItemLike result, String group){
            basicSmeltingSerializeWithList(pFinishedRecipeConsumer, ingredients, result, group, ModRecipes.BASIC_SMELTING_SERIALIZER.get(), "from_basic_smelting");
        }
        protected static void soulBasicSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike ingredient, ItemLike result, String group){
            soulBasicSmeltSerialize(pFinishedRecipeConsumer, ingredient, result, group, ModRecipes.SOUL_BASIC_SMELTING_SERIALIZER.get(), "from_soul_basic_smelting");
        }
        protected static void soulBasicSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> ingredients, ItemLike result, String group){
            soulBasicSmeltingSerializeWithList(pFinishedRecipeConsumer, ingredients, result, group, ModRecipes.SOUL_BASIC_SMELTING_SERIALIZER.get(), "from_soul_basic_smelting");
        }

        //Alloy
        protected static void oreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, String group){
            oreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, group, ModRecipes.ALLOYING_SERIALIZER.get(), "from_alloying");
        }
        protected static void superOreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, int count, String group){
            superOreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, group, count, ModRecipes.SUPER_ALLOYING_SERIALIZER.get(), "from_super_alloying");
        }
        protected static void superOreAlloying(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike result, String group){
            superOreAlloySerialize(pFinishedRecipeConsumer, firstIngredient, secondIngredient, result, group, 1, ModRecipes.SUPER_ALLOYING_SERIALIZER.get(), "from_super_alloying");
        }
        protected static void stoneCutting(Consumer<FinishedRecipe> consumer, ItemLike input, ItemLike output, int count){
            stoneCuttingBuilder(consumer, input, RecipeCategory.BUILDING_BLOCKS, output, count, "from_stone_cutting");
        }
        protected static void smithingUpgrade(Consumer<FinishedRecipe> consumer, ItemLike template, ItemLike base, ItemLike addition, ItemLike result){
            smithingTransformSerialize(consumer, template, base, addition, result, RecipeSerializer.SMITHING_TRANSFORM, "from_smithing");
        }

    //Recipe builders
    protected static void stoneCuttingBuilder(Consumer<FinishedRecipe> consumer, ItemLike input, RecipeCategory category, ItemLike result, int count, String recipeName){
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, result, count)
                .unlockedBy(getHasName(input), has(input))
                .save(consumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(result) + "_" + recipeName + "_" + getItemName(input));
    }
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike),
                    pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(pResult) + "_" + pRecipeName + "_" + getItemName(itemlike));
        }
    }
    protected static void gemPolishingSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group, RecipeSerializer<GemPolishingRecipe> recipeSerializer, String recipeName){
        ModBasicRecipeBuilder.gemPolishing(Ingredient.of(input), output, group, recipeSerializer)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(output) + "_" + recipeName + "_" + getItemName(input));
    }
    protected static void oreGrindingSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group, int quantity, RecipeSerializer<GrindingRecipe> recipeSerializer, String recipeName){
        ModBasicRecipeBuilder.itemGrinding(Ingredient.of(input), output, group, quantity, recipeSerializer)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(input));
    }
    protected static void oreGrindingTagSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, TagKey<Item> input, ItemLike output, String group, int quantity, RecipeSerializer<GrindingRecipe> recipeSerializer, String recipeName){
        ModBasicRecipeBuilder.itemGrinding(Ingredient.of(input), output, group, quantity, recipeSerializer)
                .unlockedBy(input.toString(), has(input))
                .save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName);
    }

    protected static void basicSmeltSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group, RecipeSerializer<BasicSmeltingRecipe> recipeSerializer, String recipeName){
        ModAlloyingRecipeBuilder.basicSmelting(Ingredient.of(input), output, group, recipeSerializer)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(input));
    }

    protected static void basicSmeltingSerializeWithList(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> inputs, ItemLike output, String group, RecipeSerializer<BasicSmeltingRecipe> recipeSerializer, String recipeName){
        Iterator var9 = inputs.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            ModAlloyingRecipeBuilder.basicSmelting(Ingredient.of(itemlike),
                     output, group, recipeSerializer).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(output) + "_" + recipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void soulBasicSmeltSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike input, ItemLike output, String group, RecipeSerializer<SoulBasicSmeltingRecipe> recipeSerializer, String recipeName){
        ModAlloyingRecipeBuilder.soulBasicSmelting(Ingredient.of(input), output, group, recipeSerializer)
                .unlockedBy(getHasName(input), has(input))
                .save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(input));
    }

    protected static void soulBasicSmeltingSerializeWithList(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> inputs, ItemLike output, String group, RecipeSerializer<SoulBasicSmeltingRecipe> recipeSerializer, String recipeName){
        Iterator var9 = inputs.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            ModAlloyingRecipeBuilder.soulBasicSmelting(Ingredient.of(itemlike),
                    output, group, recipeSerializer).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(output) + "_" + recipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void oreAlloySerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike output, String group, RecipeSerializer<AlloyingFurnaceRecipe> recipeSerializer, String recipeName){
        ModAlloyingRecipeBuilder.oreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), output, group, recipeSerializer)
                .unlockedBy(getHasName(firstIngredient), has(firstIngredient))
                .unlockedBy(getHasName(secondIngredient), has(secondIngredient))
                .save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
    }

    protected static void superOreAlloySerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike firstIngredient, ItemLike secondIngredient, ItemLike output, String group, int count, RecipeSerializer<SuperAlloyingRecipe> recipeSerializer, String recipeName){
        ModAlloyingRecipeBuilder.superOreAlloying(Ingredient.of(firstIngredient), Ingredient.of(secondIngredient), output, group, count, recipeSerializer)
                .unlockedBy(getHasName(firstIngredient), has(firstIngredient))
                .unlockedBy(getHasName(secondIngredient), has(secondIngredient))
                .save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(output) +  "_" + recipeName + "_" + getItemName(firstIngredient) + "_and_" + getItemName(secondIngredient));
    }

    protected static void smithingTransformSerialize(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike template, ItemLike base, ItemLike addition, ItemLike result, RecipeSerializer<SmithingTransformRecipe> serializer, String recipeName){
        ModSmithingTransformRecipeBuilder.SmithingReipeBuilder(template, base, addition, result, serializer)
                .unlockedBy(getHasName(base), has(base))
                .save(pFinishedRecipeConsumer, Enhanced_Playthrough.MOD_ID + ":" + getItemName(result) + "_" + recipeName + "_" + getItemName(base) + "_with_" + getItemName(addition));
    }
}

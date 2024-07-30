package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.Util.ModTags;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<ItemLike> Zapallo_cookables = List.of(ModItems.Zapallo.get());
    public static final List<ItemLike> Eggplant_cookables = List.of(ModItems.Eggplant.get());
    public static final List<ItemLike> Corn_cookables = List.of(ModItems.Corn.get());
    public static final List<ItemLike> Tin_smeltables = List.of(ModItems.Raw_tin.get(),
            ModBlocks.Tin_ore.get(), ModBlocks.Deepslate_tin_ore.get());
    public static final List<ItemLike> Tin_nugget_smeltables = List.of(ModItems.Raw_tin.get());
    public static final List<ItemLike> Copper_nugget_smeltables = List.of(Items.RAW_COPPER);
    public static final List<ItemLike> Bronze_smeltables= List.of(ModItems.Raw_bronze.get());
    public static final List<ItemLike> Bronze_nuggets_smeltables= List.of(ModItems.Bronze_axe.get(),
            ModItems.Bronze_hoe.get(), ModItems.Bronze_pickaxe.get(), ModItems.Bronze_shovel.get(),
            ModItems.Bronze_sword.get());
    public static final List<ItemLike> Steel_smeltables= List.of(ModItems.Raw_steel.get());
    public static final List<ItemLike> Silver_smeltables= List.of(ModItems.Raw_silver.get(), ModBlocks.Silver_ore.get(),
            ModBlocks.Deepslate_silver_ore.get());
    public static final List<ItemLike> Silver_nuggets_smeltables= List.of(ModItems.Silver_axe.get(),
            ModItems.Silver_hoe.get(), ModItems.Silver_pickaxe.get(), ModItems.Silver_shovel.get(),
            ModItems.Silver_sword.get());
    public static final List<ItemLike> Rose_gold_nuggets_smeltables= List.of(ModItems.Rose_golden_axe.get(),
            ModItems.Rose_golden_hoe.get(), ModItems.Rose_golden_pickaxe.get(), ModItems.Rose_golden_shovel.get(),
            ModItems.Rose_golden_sword.get());
    public static final List<ItemLike> Cobalt_smeltables= List.of(ModBlocks.Deepslate_cobalt_ore.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //Smelting Recipes
        oreSmelting(consumer, Zapallo_cookables, RecipeCategory.FOOD, ModItems.Cooked_zapallo.get(),
                2f, 100, "zapallo");
        oreSmelting(consumer, Eggplant_cookables, RecipeCategory.FOOD, ModItems.Cooked_eggplant.get(),
                2f, 100, "eggplant");
        oreSmelting(consumer, Corn_cookables, RecipeCategory.FOOD, ModItems.Cooked_corn.get(),
                2f, 100, "corn");

        smoking(consumer, Zapallo_cookables, RecipeCategory.FOOD, ModItems.Cooked_zapallo.get(),
                2f, 100, "zapallo");
        smoking(consumer, Eggplant_cookables, RecipeCategory.FOOD, ModItems.Cooked_eggplant.get(),
                2f, 100, "eggplant");
        smoking(consumer, Corn_cookables, RecipeCategory.FOOD, ModItems.Cooked_corn.get(),
                2f, 100, "corn");

        byCampfire(consumer, Zapallo_cookables, RecipeCategory.FOOD, ModItems.Cooked_zapallo.get(),
                2f, 100, "zapallo");
        byCampfire(consumer, Eggplant_cookables, RecipeCategory.FOOD, ModItems.Cooked_eggplant.get(),
                2f, 100, "eggplant");
        byCampfire(consumer, Corn_cookables, RecipeCategory.FOOD, ModItems.Cooked_corn.get(),
                2f, 100, "corn");

        byCampfire(consumer, Copper_nugget_smeltables, RecipeCategory.MISC, ModItems.Copper_nugget.get(),
                1.0f, 300, "copper_nugget");

        oreSmelting(consumer, Tin_smeltables, RecipeCategory.MISC, ModItems.Tin_ingot.get(),
                2f, 100, "tin_ingot" );
        oreBlasting(consumer, Tin_smeltables, RecipeCategory.MISC, ModItems.Tin_ingot.get(),
                2f, 200, "tin_ingot" );
        byCampfire(consumer, Tin_nugget_smeltables, RecipeCategory.MISC, ModItems.Tin_nugget.get(),
                1.0f, 300, "tin_nugget");


        oreSmelting(consumer, Bronze_smeltables, RecipeCategory.MISC, ModItems.Bronze_ingot.get(),
                2f, 100, "bronze_ingot" );
        oreBlasting(consumer, Bronze_smeltables, RecipeCategory.MISC, ModItems.Bronze_ingot.get(),
                2f, 200, "bronze_ingot" );
        oreSmelting(consumer, Bronze_nuggets_smeltables, RecipeCategory.MISC, ModItems.Bronze_nugget.get(),
                0.5f, 100, "bronze_nugget");
        oreBlasting(consumer, Bronze_nuggets_smeltables, RecipeCategory.MISC, ModItems.Bronze_nugget.get(),
                0.5f, 200, "bronze_nugget");

        oreSmelting(consumer, Steel_smeltables, RecipeCategory.MISC, ModItems.Steel_ingot.get(),
                2f, 100, "silver_ingot");
        oreBlasting(consumer, Steel_smeltables, RecipeCategory.MISC, ModItems.Steel_ingot.get(),
                2f, 200, "silver_ingot");

        oreSmelting(consumer, Silver_smeltables, RecipeCategory.MISC, ModItems.Silver_ingot.get(),
                2f, 100, "silver_ingot");
        oreBlasting(consumer, Silver_smeltables, RecipeCategory.MISC, ModItems.Silver_ingot.get(),
                2f, 200, "silver_ingot");
        oreSmelting(consumer, Silver_nuggets_smeltables, RecipeCategory.MISC, ModItems.Silver_nugget.get(),
                0.5f, 100, "silver_nugget");
        oreBlasting(consumer, Silver_nuggets_smeltables, RecipeCategory.MISC, ModItems.Silver_nugget.get(),
                0.5f, 200, "silver_nugget");

        oreSmelting(consumer, Rose_gold_nuggets_smeltables, RecipeCategory.MISC, ModItems.Rose_gold_nugget.get(),
                0.5f, 100, "rose_gold_nugget");
        oreBlasting(consumer, Rose_gold_nuggets_smeltables, RecipeCategory.MISC, ModItems.Rose_gold_nugget.get(),
                0.5f, 200, "rose_gold_nugget");

        //Foods
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.Empty_mate.get())
                .pattern("#")
                .pattern("I")
                .define('#', Items.IRON_INGOT)
                .define('I', ModItems.Cooked_zapallo.get())
                .unlockedBy(getHasName(ModItems.Cooked_zapallo.get()), has(ModItems.Cooked_zapallo.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.Grounded_yerba_mate.get())
                .pattern(" I ")
                .pattern("I I")
                .pattern(" I ")
                .define('I', ModItems.Yerba_mate.get())
                .unlockedBy(getHasName(ModItems.Yerba_mate.get()), has(ModItems.Yerba_mate.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.Mate.get())
                .pattern("I")
                .pattern("A")
                .define('I', ModItems.Grounded_yerba_mate.get())
                .define('A', ModItems.Empty_mate.get())
                .unlockedBy(getHasName(ModItems.Yerba_mate.get()), has(ModItems.Yerba_mate.get()))
                .save(consumer);

        //Block recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.Adobe_furnace.get())
                .pattern("###")
                .pattern("# #")
                .pattern("III")
                .define('#', Blocks.MUD_BRICKS)
                .define('I', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE))
                .unlockedBy(getHasName(Blocks.MUD_BRICKS), has(Blocks.MUD_BRICKS))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.Adobe_alloying_furnace.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("III")
                .define('#', Blocks.BRICKS)
                .define('A', ModBlocks.Adobe_furnace.get())
                .define('I', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(ModBlocks.Adobe_furnace.get()), has(ModBlocks.Adobe_furnace.get()))
                .unlockedBy(getHasName(ModItems.Raw_tin.get()), has(ModItems.Raw_tin.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.Super_alloying_furnace.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("III")
                .define('#', ModItems.Steel_ingot.get())
                .define('A', ModBlocks.Adobe_alloying_furnace.get())
                .define('I', Blocks.COBBLED_DEEPSLATE)
                .unlockedBy(getHasName(Blocks.COBBLED_DEEPSLATE), has(Blocks.COBBLED_DEEPSLATE))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.Gem_polisher_block.get())
                .pattern("###")
                .pattern("#I#")
                .pattern("#I#")
                .define('#', Blocks.DARK_OAK_PLANKS)
                .define('I', Blocks.STONE)
                .unlockedBy(getHasName(Blocks.DARK_OAK_PLANKS), has(Blocks.DARK_OAK_PLANKS))
                .save(consumer);

        //Copper recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Copper_nugget.get(), 9)
                .requires(Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(consumer);

        //Tin recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Tin_nugget.get(), 9)
                .requires(ModItems.Tin_ingot.get())
                .unlockedBy(getHasName(ModItems.Tin_ingot.get()), has(ModItems.Tin_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Tin_ingot.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.Tin_nugget.get())
                .unlockedBy(getHasName(ModItems.Tin_nugget.get()), has(ModItems.Tin_nugget.get()))
                .save(consumer);

        //Bronze recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Bronze_nugget.get(), 9)
                .requires(ModItems.Bronze_ingot.get()).unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                        .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Bronze_ingot.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.Bronze_nugget.get())
                .unlockedBy(getHasName(ModItems.Bronze_nugget.get()), has(ModItems.Bronze_nugget.get()))
                .save(consumer);
            //Bronze tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Bronze_sword.get())
                .pattern("I")
                .pattern("I")
                .pattern("#")
                .define('I', ModItems.Bronze_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Bronze_pickaxe.get())
                .pattern("III")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', ModItems.Bronze_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Bronze_axe.get())
                .pattern("II")
                .pattern("I#")
                .pattern(" #")
                .define('I', ModItems.Bronze_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Bronze_shovel.get())
                .pattern("I")
                .pattern("#")
                .pattern("#")
                .define('I', ModItems.Bronze_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Bronze_hoe.get())
                .pattern("II")
                .pattern(" #")
                .pattern(" #")
                .define('I', ModItems.Bronze_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
            //Bronze armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Bronze_helmet.get())
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.Bronze_ingot.get())
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Bronze_chestplate.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.Bronze_ingot.get())
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Bronze_leggings.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.Bronze_ingot.get())
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Bronze_boots.get())
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.Bronze_ingot.get())
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);

        //Steel recipes
            //Steel tools
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Steel_sword.get())
                .pattern("I")
                .pattern("I")
                .pattern("#")
                .define('I', ModItems.Steel_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Steel_pickaxe.get())
                .pattern("III")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', ModItems.Steel_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Steel_axe.get())
                .pattern("II")
                .pattern("I#")
                .pattern(" #")
                .define('I', ModItems.Steel_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Steel_shovel.get())
                .pattern("I")
                .pattern("#")
                .pattern("#")
                .define('I', ModItems.Steel_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Steel_hoe.get())
                .pattern("II")
                .pattern(" #")
                .pattern(" #")
                .define('I', ModItems.Steel_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
            //Steel armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Steel_helmet.get())
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.Steel_ingot.get())
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Steel_chestplate.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.Steel_ingot.get())
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Steel_leggings.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.Steel_ingot.get())
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Steel_boots.get())
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.Steel_ingot.get())
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);

        //Silver recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Silver_nugget.get(), 9)
                .requires(ModItems.Silver_ingot.get()).unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Silver_ingot.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.Silver_nugget.get())
                .unlockedBy(getHasName(ModItems.Silver_nugget.get()), has(ModItems.Silver_nugget.get()))
                .save(consumer);
            //Silver tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Silver_sword.get())
                .pattern("I")
                .pattern("I")
                .pattern("#")
                .define('I', ModItems.Silver_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Silver_pickaxe.get())
                .pattern("III")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', ModItems.Silver_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Silver_axe.get())
                .pattern("II")
                .pattern("I#")
                .pattern(" #")
                .define('I', ModItems.Silver_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Silver_shovel.get())
                .pattern("I")
                .pattern("#")
                .pattern("#")
                .define('I', ModItems.Silver_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Silver_hoe.get())
                .pattern("II")
                .pattern(" #")
                .pattern(" #")
                .define('I', ModItems.Silver_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
            //Silver armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Silver_helmet.get())
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.Silver_ingot.get())
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Silver_chestplate.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.Silver_ingot.get())
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Silver_leggings.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.Silver_ingot.get())
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Silver_boots.get())
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.Silver_ingot.get())
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);

        //Rose gold recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Rose_gold_nugget.get(), 9)
                .requires(ModItems.Rose_gold_ingot.get()).unlockedBy(getHasName(ModItems.Rose_gold_ingot.get()), has(ModItems.Rose_gold_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Rose_gold_ingot.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.Rose_gold_nugget.get())
                .unlockedBy(getHasName(ModItems.Rose_gold_nugget.get()), has(ModItems.Rose_gold_nugget.get()))
                .save(consumer);
            //Rose gold tools
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Rose_golden_sword.get())
                    .pattern("I")
                    .pattern("I")
                    .pattern("#")
                    .define('I', ModItems.Rose_gold_ingot.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.Rose_gold_ingot.get()), has(ModItems.Rose_gold_ingot.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Rose_golden_pickaxe.get())
                    .pattern("III")
                    .pattern(" # ")
                    .pattern(" # ")
                    .define('I', ModItems.Rose_gold_ingot.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.Rose_gold_ingot.get()), has(ModItems.Rose_gold_ingot.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Rose_golden_axe.get())
                    .pattern("II")
                    .pattern("I#")
                    .pattern(" #")
                    .define('I', ModItems.Rose_gold_ingot.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.Rose_gold_ingot.get()), has(ModItems.Rose_gold_ingot.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Rose_golden_shovel.get())
                    .pattern("I")
                    .pattern("#")
                    .pattern("#")
                    .define('I', ModItems.Rose_gold_ingot.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.Rose_gold_ingot.get()), has(ModItems.Rose_gold_ingot.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Rose_golden_hoe.get())
                    .pattern("II")
                    .pattern(" #")
                    .pattern(" #")
                    .define('I', ModItems.Rose_gold_ingot.get())
                    .define('#', Items.STICK)
                    .unlockedBy(getHasName(ModItems.Rose_gold_ingot.get()), has(ModItems.Rose_gold_ingot.get()))
                    .save(consumer);
            //Rose gold armor
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Rose_golden_helmet.get())
                    .pattern("###")
                    .pattern("# #")
                    .define('#', ModItems.Rose_gold_ingot.get())
                    .unlockedBy(getHasName(ModItems.Rose_gold_ingot.get()), has(ModItems.Rose_gold_ingot.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Rose_golden_chestplate.get())
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .define('#', ModItems.Rose_gold_ingot.get())
                    .unlockedBy(getHasName(ModItems.Rose_gold_ingot.get()), has(ModItems.Rose_gold_ingot.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Rose_golden_leggings.get())
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ModItems.Rose_gold_ingot.get())
                    .unlockedBy(getHasName(ModItems.Rose_gold_ingot.get()), has(ModItems.Rose_gold_ingot.get()))
                    .save(consumer);
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Rose_golden_boots.get())
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ModItems.Rose_gold_ingot.get())
                    .unlockedBy(getHasName(ModItems.Rose_gold_ingot.get()), has(ModItems.Rose_gold_ingot.get()))
                    .save(consumer);

        //Food recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.Rice_bowl.get())
                .pattern("#I")
                .define('I', Items.BOWL)
                .define('#', ModItems.Rice.get())
                .unlockedBy(getHasName(ModItems.Rice.get()), has(ModItems.Rice.get()))
                .save(consumer);

        //Polishers
        //Stone
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Stone_polisher.get())
                .pattern(" I")
                .pattern("# ")
                .define('I', Items.STONE)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.STONE), has(Items.STONE))
                .save(consumer);
        //Bronze
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Bronze_polisher.get())
                .pattern(" I")
                .pattern("# ")
                .define('I', ModItems.Bronze_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        //Iron
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Iron_polisher.get())
                .pattern(" I")
                .pattern("# ")
                .define('I', Items.IRON_INGOT)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);
        //Steel
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Steel_polisher.get())
                .pattern(" I")
                .pattern("# ")
                .define('I', ModItems.Steel_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
        //Gold
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Gold_polisher.get())
                .pattern(" I")
                .pattern("# ")
                .define('I', Items.GOLD_INGOT)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(consumer);
        //Silver
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Silver_polisher.get())
                .pattern(" I")
                .pattern("# ")
                .define('I', ModItems.Silver_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        //Diamond
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Diamond_polisher.get())
                .pattern(" I")
                .pattern("# ")
                .define('I', Items.DIAMOND)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(consumer);

        //New vanilla recipes
            //Redstone
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Items.REPEATER)
                .pattern("W#W")
                .pattern("III")
                .define('W', Items.REDSTONE_TORCH)
                .define('#', ModItems.Tin_ingot.get())
                .define('I', Blocks.STONE)
                .unlockedBy(getHasName(ModItems.Tin_ingot.get()), has(ModItems.Tin_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Items.COMPARATOR)
                .pattern("WWW")
                .pattern("AFA")
                .pattern("III")
                .define('W', Items.REDSTONE_TORCH)
                .define('F', ModItems.Tin_ingot.get())
                .define('A', Items.REDSTONE)
                .define('I', Blocks.STONE)
                .unlockedBy(getHasName(ModItems.Tin_ingot.get()), has(ModItems.Tin_ingot.get()))
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(consumer);
            //Items

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
                .define('I', ModItems.Steel_ingot.get())
                .define('F', Blocks.FURNACE)
                .define('#', Blocks.SMOOTH_STONE)
                .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.FURNACE)
                .pattern("III")
                .pattern("#F#")
                .pattern("###")
                .define('I', ModItems.Bronze_ingot.get())
                .define('F', ModBlocks.Adobe_furnace.get())
                .define('#', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
                .save(consumer);
    }
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

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}),
                    pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer, Enhanced_Minecraft.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}

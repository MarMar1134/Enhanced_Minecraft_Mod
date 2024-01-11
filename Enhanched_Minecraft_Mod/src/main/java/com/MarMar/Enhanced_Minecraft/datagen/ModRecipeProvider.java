package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.blocks.ModBlocks;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<ItemLike> Tin_smeltables = List.of(ModItems.Raw_tin.get(),
            ModBlocks.Tin_ore.get(), ModBlocks.Deepslate_tin_ore.get());
    public static final List<ItemLike> Bronze_smeltables= List.of(ModItems.Raw_bronze.get());
    public static final List<ItemLike> Bronze_nuggets_smeltables= List.of(ModItems.Bronze_axe.get(),
            ModItems.Bronze_hoe.get(), ModItems.Bronze_pickaxe.get(), ModItems.Bronze_shovel.get(),
            ModItems.Bronze_sword.get());
    public static final List<ItemLike> Steel_smeltables= List.of(ModItems.Raw_steel.get(), ModItems.Steel_axe.get(),
            ModItems.Steel_hoe.get(), ModItems.Steel_pickaxe.get(), ModItems.Steel_shovel.get(),
            ModItems.Steel_sword.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //Smelting Recipes
        oreSmelting(consumer, Tin_smeltables, RecipeCategory.MISC, ModItems.Tin_ingot.get(),
                5f, 100, "tin_ingot" );
        oreBlasting(consumer, Tin_smeltables, RecipeCategory.MISC, ModItems.Tin_ingot.get(),
                5f, 200, "tin_ingot" );
        oreSmelting(consumer, Steel_smeltables, RecipeCategory.MISC, ModItems.Steel_ingot.get(),
                7f, 100, "steel_ingot" );
        oreBlasting(consumer, Steel_smeltables, RecipeCategory.MISC, ModItems.Steel_ingot.get(),
                7f, 200, "steel_ingot" );
        oreSmelting(consumer, Bronze_smeltables, RecipeCategory.MISC, ModItems.Bronze_ingot.get(),
                6f, 100, "bronze_ingot" );
        oreBlasting(consumer, Bronze_smeltables, RecipeCategory.MISC, ModItems.Bronze_ingot.get(),
                6f, 200, "bronze_ingot" );
        oreSmelting(consumer, Bronze_nuggets_smeltables, RecipeCategory.MISC, ModItems.Bronze_nuggets.get(),
                3f, 100, "bronze_nuggets");
        oreBlasting(consumer, Bronze_nuggets_smeltables, RecipeCategory.MISC, ModItems.Bronze_nuggets.get(),
                3f, 200, "bronze_nuggets");


        //Bronze recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Bronze_nuggets.get())
                .pattern("#")
                .define('#', ModItems.Bronze_ingot.get())
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Bronze_ingot.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.Bronze_nuggets.get())
                .unlockedBy(getHasName(ModItems.Bronze_nuggets.get()), has(ModItems.Bronze_nuggets.get()))
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
        //Steel recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Raw_steel.get())
                .pattern("#I")
                .define('I', Items.IRON_INGOT)
                .define('#', Items.COAL)
                .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Raw_steel.get())
                .pattern("#I")
                .pattern("##")
                .define('I', Items.IRON_INGOT)
                .define('#', Items.CHARCOAL)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);
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
        //Food recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.Rice_bowl.get())
                .pattern("#I")
                .define('I', Items.BOWL)
                .define('#', ModItems.Rice.get())
                .unlockedBy(getHasName(ModItems.Rice.get()), has(ModItems.Rice.get()))
                .save(consumer);


    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
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

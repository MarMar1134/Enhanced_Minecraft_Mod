package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.blocks.ModBlocks;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.data.BlockTagsProvider;

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
    public static final List<ItemLike> Steel_smeltables= List.of(ModItems.Raw_steel.get());
    public static final List<ItemLike> Silver_smeltables= List.of(ModItems.Raw_silver.get(), ModBlocks.Silver_ore.get(),
            ModBlocks.Deepslate_silver_ore.get());
    public static final List<ItemLike> Cobalt_smeltables= List.of(ModBlocks.Deepslate_cobalt_ore.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //Smelting Recipes
        oreSmelting(consumer, Tin_smeltables, RecipeCategory.MISC, ModItems.Tin_ingot.get(),
                2f, 100, "tin_ingot" );
        oreBlasting(consumer, Tin_smeltables, RecipeCategory.MISC, ModItems.Tin_ingot.get(),
                2f, 200, "tin_ingot" );
        oreSmelting(consumer, Bronze_smeltables, RecipeCategory.MISC, ModItems.Bronze_ingot.get(),
                2f, 100, "bronze_ingot" );
        oreBlasting(consumer, Bronze_smeltables, RecipeCategory.MISC, ModItems.Bronze_ingot.get(),
                2f, 200, "bronze_ingot" );
        oreSmelting(consumer, Bronze_nuggets_smeltables, RecipeCategory.MISC, ModItems.Bronze_nuggets.get(),
                0.5f, 100, "bronze_nuggets");
        oreBlasting(consumer, Bronze_nuggets_smeltables, RecipeCategory.MISC, ModItems.Bronze_nuggets.get(),
                0.5f, 200, "bronze_nuggets");
        oreSmelting(consumer, Steel_smeltables, RecipeCategory.MISC, ModItems.Steel_ingot.get(),
                2f, 100, "silver_ingot");
        oreBlasting(consumer, Steel_smeltables, RecipeCategory.MISC, ModItems.Steel_ingot.get(),
                2f, 200, "silver_ingot");
        oreSmelting(consumer, Silver_smeltables, RecipeCategory.MISC, ModItems.Silver_ingot.get(),
                2f, 100, "silver_ingot");
        oreBlasting(consumer, Silver_smeltables, RecipeCategory.MISC, ModItems.Silver_ingot.get(),
                2f, 200, "silver_ingot");
        oreSmelting(consumer, Cobalt_smeltables, RecipeCategory.MISC, ModItems.Cobalt.get(),
                2f, 100, "silver_ingot");
        oreBlasting(consumer, Cobalt_smeltables, RecipeCategory.MISC, ModItems.Cobalt.get(),
                2f, 200, "silver_ingot");


        //Block recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.Adobe_alloying_furnace.get())
                .pattern("###")
                .pattern("# #")
                .pattern("III")
                .define('#', Blocks.PACKED_MUD)
                .define('I', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE))
                .save(consumer);

        //Bronze recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Bronze_nuggets.get(), 9)
                .requires(ModItems.Bronze_ingot.get()).unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
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
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" # ")
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
                .pattern("II ")
                .pattern("I# ")
                .pattern(" # ")
                .define('I', ModItems.Bronze_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Bronze_shovel.get())
                .pattern(" I ")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', ModItems.Bronze_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Bronze_hoe.get())
                .pattern("II ")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', ModItems.Bronze_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);
            //Bronze armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Bronze_helmet.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
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
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.Bronze_ingot.get())
                .unlockedBy(getHasName(ModItems.Bronze_ingot.get()), has(ModItems.Bronze_ingot.get()))
                .save(consumer);

        //Steel recipes
            //Steel tools
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Steel_sword.get())
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" # ")
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
                .pattern("II ")
                .pattern("I# ")
                .pattern(" # ")
                .define('I', ModItems.Steel_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Steel_shovel.get())
                .pattern(" I ")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', ModItems.Steel_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Steel_hoe.get())
                .pattern("II ")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', ModItems.Steel_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);
            //Steel armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Steel_helmet.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
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
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.Steel_ingot.get())
                .unlockedBy(getHasName(ModItems.Steel_ingot.get()), has(ModItems.Steel_ingot.get()))
                .save(consumer);

        //Silver recipes
            //Silver tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Silver_sword.get())
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" # ")
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
                .pattern("II ")
                .pattern("I# ")
                .pattern(" # ")
                .define('I', ModItems.Silver_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Silver_shovel.get())
                .pattern(" I ")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', ModItems.Silver_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Silver_hoe.get())
                .pattern("II ")
                .pattern(" # ")
                .pattern(" # ")
                .define('I', ModItems.Silver_ingot.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);
            //Silver armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.Silver_helmet.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
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
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.Silver_ingot.get())
                .unlockedBy(getHasName(ModItems.Silver_ingot.get()), has(ModItems.Silver_ingot.get()))
                .save(consumer);

        //Food recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.Rice_bowl.get())
                .pattern(" #I")
                .define('I', Items.BOWL)
                .define('#', ModItems.Rice.get())
                .unlockedBy(getHasName(ModItems.Rice.get()), has(ModItems.Rice.get()))
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
            //Items
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.NETHERITE_INGOT)
                .pattern("###")
                .pattern("#II")
                .pattern("II ")
                .define('#', Items.ANCIENT_DEBRIS)
                .define('I', ModItems.Reinforced_diamond.get())
                .unlockedBy(getHasName(Items.ANCIENT_DEBRIS), has(Items.ANCIENT_DEBRIS))
                .save(consumer);

            //Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.BLAST_FURNACE)
                .pattern("III")
                .pattern("IFI")
                .pattern("###")
                .define('I', ModItems.Steel_ingot.get())
                .define('F', Blocks.FURNACE)
                .define('#', Blocks.SMOOTH_STONE)
                .unlockedBy(getHasName(Blocks.FURNACE), has(Blocks.FURNACE))
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
            //Netherite
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.Netherite_polisher.get())
                .pattern(" I")
                .pattern("# ")
                .define('I', Items.NETHERITE_INGOT)
                .define('#', Items.STICK)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
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

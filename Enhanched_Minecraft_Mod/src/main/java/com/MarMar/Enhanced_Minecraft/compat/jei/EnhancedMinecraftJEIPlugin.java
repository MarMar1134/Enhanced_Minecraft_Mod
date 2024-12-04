package com.MarMar.Enhanced_Minecraft.compat.jei;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import com.MarMar.Enhanced_Minecraft.menu.screen.*;
import com.MarMar.Enhanced_Minecraft.recipe.*;
import com.MarMar.Enhanced_Minecraft.recipe.alloy.AlloyingFurnaceRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.alloy.SuperAlloyingRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.basic.BasicSmeltingRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.basic.SoulBasicSmeltingRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class EnhancedMinecraftJEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Enhanced_Playthrough.MOD_ID, "jei_plugin");
    }
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        //Basic furnaces
        registration.addRecipeCategories(new BasicSmeltingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SoulBasicSmeltingCategory(registration.getJeiHelpers().getGuiHelper()));

        //Alloy furnaces
        registration.addRecipeCategories(new OreAlloyingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SuperAlloyingCategory(registration.getJeiHelpers().getGuiHelper()));

        //Others
        registration.addRecipeCategories(new GemPolishingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new GrindingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<BasicSmeltingRecipe> basicSmeltingRecipes = recipeManager.getAllRecipesFor(ModRecipes.BASIC_SMELTING_TYPE.get());
        registration.addRecipes(BasicSmeltingCategory.BASIC_SMELTING_TYPE, basicSmeltingRecipes);

        List<SoulBasicSmeltingRecipe> soulBasicSmeltingRecipes = recipeManager.getAllRecipesFor(ModRecipes.SOUL_BASIC_SMELTING_TYPE.get());
        registration.addRecipes(SoulBasicSmeltingCategory.SOUL_BASIC_SMELTING_TYPE, soulBasicSmeltingRecipes);

        List<AlloyingFurnaceRecipe> alloyingRecipes = recipeManager.getAllRecipesFor(ModRecipes.ALLOYING_TYPE.get());
        registration.addRecipes(OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE, alloyingRecipes);

        List<GemPolishingRecipe> gemPolishingRecipes = recipeManager.getAllRecipesFor(ModRecipes.POLISHING_TYPE.get());
        registration.addRecipes(GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE, gemPolishingRecipes);

        List<SuperAlloyingRecipe> superAlloyingRecipes = recipeManager.getAllRecipesFor(ModRecipes.SUPER_ALLOYING_TYPE.get());
        registration.addRecipes(SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE, superAlloyingRecipes);

        List<GrindingRecipe> grindingRecipes = recipeManager.getAllRecipesFor(ModRecipes.GRINDING_TYPE.get());
        registration.addRecipes(GrindingCategory.GRINDING_RECIPE_RECIPE_TYPE, grindingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AdobeFurnaceScreen.class, 80, 38, 14, 9,
                BasicSmeltingCategory.BASIC_SMELTING_TYPE);

        registration.addRecipeClickArea(SoulFurnaceScreen.class, 80, 38, 14, 9,
                SoulBasicSmeltingCategory.SOUL_BASIC_SMELTING_TYPE);

        registration.addRecipeClickArea(AdobeAlloyFurnaceScreen.class, 59, 19, 13, 11,
                OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE);


        registration.addRecipeClickArea(GemPolisherScreen.class, 80, 33, 20, 30,
                GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE);

        registration.addRecipeClickArea(SuperAlloyFurnaceScreen.class, 59, 19, 13, 11,
                SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE);

        registration.addRecipeClickArea(GrinderScreen.class, 82, 24, 20, 30,
                GrindingCategory.GRINDING_RECIPE_RECIPE_TYPE);
    }
}

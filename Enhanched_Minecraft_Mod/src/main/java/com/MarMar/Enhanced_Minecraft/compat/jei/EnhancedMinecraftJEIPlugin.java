package com.MarMar.Enhanced_Minecraft.compat.jei;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.recipe.*;
import com.MarMar.Enhanced_Minecraft.screen.AdobeAlloyingFurnaceScreen;
import com.MarMar.Enhanced_Minecraft.screen.GemPolisherScreen;
import com.MarMar.Enhanced_Minecraft.screen.GrinderScreen;
import com.MarMar.Enhanced_Minecraft.screen.SuperAlloyingFurnaceScreen;
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
        return new ResourceLocation(Enhanced_Minecraft.MOD_ID, "jei_plugin");
    }
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new OreAlloyingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new GemPolishingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SuperAlloyingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new GrindingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<AlloyingFurnaceRecipe> alloyingRecipes = recipeManager.getAllRecipesFor(ModRecipes.Alloying_type.get());
        registration.addRecipes(OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE, alloyingRecipes);

        List<GemPolishingRecipe> gemPolishingRecipes = recipeManager.getAllRecipesFor(ModRecipes.Polishing_type.get());
        registration.addRecipes(GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE, gemPolishingRecipes);

        List<SuperAlloyingRecipe> superAlloyingRecipes = recipeManager.getAllRecipesFor(ModRecipes.Super_alloying_type.get());
        registration.addRecipes(SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE, superAlloyingRecipes);

        List<GrindingRecipe> grindingRecipes = recipeManager.getAllRecipesFor(ModRecipes.Grinding_type.get());
        registration.addRecipes(GrindingCategory.GRINDING_RECIPE_RECIPE_TYPE, grindingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AdobeAlloyingFurnaceScreen.class, 59, 19, 13, 11,
                OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE);

        registration.addRecipeClickArea(GemPolisherScreen.class, 80, 33, 20, 30,
                GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE);

        registration.addRecipeClickArea(SuperAlloyingFurnaceScreen.class, 59, 19, 13, 11,
                SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE);

        registration.addRecipeClickArea(GrinderScreen.class, 82, 24, 20, 30,
                GrindingCategory.GRINDING_RECIPE_RECIPE_TYPE);
    }
}

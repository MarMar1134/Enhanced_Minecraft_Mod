package com.MarMar.Enhanced_Minecraft.compat.jei;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.recipe.AlloyingFurnaceRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.GemPolisherRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.SuperAlloyingRecipe;
import com.MarMar.Enhanced_Minecraft.screen.AdobeAlloyingFurnaceScreen;
import com.MarMar.Enhanced_Minecraft.screen.GemPolisherScreen;
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
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<AlloyingFurnaceRecipe> alloyingRecipes = recipeManager.getAllRecipesFor(AlloyingFurnaceRecipe.Type.Instance);
        registration.addRecipes(OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE, alloyingRecipes);

        List<GemPolisherRecipe> gemPolisherRecipes = recipeManager.getAllRecipesFor(GemPolisherRecipe.Type.Instance);
        registration.addRecipes(GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE, gemPolisherRecipes);

        List<SuperAlloyingRecipe> superAlloyingRecipes = recipeManager.getAllRecipesFor(SuperAlloyingRecipe.Type.Instance);
        registration.addRecipes(SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE, superAlloyingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AdobeAlloyingFurnaceScreen.class, 60, 10, 20, 30,
                OreAlloyingCategory.ALLOYING_FURNACE_RECIPE_RECIPE_TYPE);

        registration.addRecipeClickArea(GemPolisherScreen.class, 60, 20, 20, 30,
                GemPolishingCategory.GEM_POLISHER_RECIPE_TYPE);

        registration.addRecipeClickArea(SuperAlloyingFurnaceScreen.class, 60, 10, 20, 30,
                SuperAlloyingCategory.SUPER_ALLOYING_RECIPE_TYPE);
    }
}

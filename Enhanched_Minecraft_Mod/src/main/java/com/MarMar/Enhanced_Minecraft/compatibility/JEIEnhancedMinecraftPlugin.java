package com.MarMar.Enhanced_Minecraft.compatibility;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.recipe.AlloyingFurnaceRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.GemPolisherRecipe;
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
public class JEIEnhancedMinecraftPlugin  implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Enhanced_Minecraft.MOD_ID,"jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AdobeAlloyingCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new GemPolishingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<AlloyingFurnaceRecipe> adobeRecipes = recipeManager.getAllRecipesFor(AlloyingFurnaceRecipe.Type.Instance);
        List<GemPolisherRecipe> polisherRecipes = recipeManager.getAllRecipesFor(GemPolisherRecipe.Type.Instance);

        registration.addRecipes(AdobeAlloyingCategory.ADOBE_ALLOYING_TYPE, adobeRecipes);
        registration.addRecipes(GemPolishingCategory.GEM_POLISHING_TYPE, polisherRecipes);
    }
}

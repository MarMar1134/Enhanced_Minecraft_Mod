package com.marmar.enhanced_playthrough.compat.jei;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import com.marmar.enhanced_playthrough.block.ModBlocks;
import com.marmar.enhanced_playthrough.recipe.GemPolishingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class GemPolishingCategory implements IRecipeCategory<GemPolishingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "gem_polishing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(EnhancedPlaythrough.MOD_ID,
            "textures/gui/gem_polisher_gui.png");

    public static final RecipeType<GemPolishingRecipe> GEM_POLISHER_RECIPE_TYPE =
            new RecipeType<>(UID, GemPolishingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public GemPolishingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 82);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.GEM_POLISHER.get()));
    }

    @Override
    public RecipeType<GemPolishingRecipe> getRecipeType() {
        return GEM_POLISHER_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.enhanced_playthrough.gem_polisher");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, GemPolishingRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 55, 34).addIngredients(recipe.getIngredient());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 130,33).addItemStack(recipe.getResultItem(null));
    }
}

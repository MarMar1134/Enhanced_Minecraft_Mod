package com.MarMar.Enhanced_Minecraft.compat.jei;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.recipe.GemPolisherRecipe;
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

public class GemPolishingCategory implements IRecipeCategory<GemPolisherRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Enhanced_Minecraft.MOD_ID, "gem_polishing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Enhanced_Minecraft.MOD_ID,
            "textures/gui/gem_polisher_gui.png");

    public static final RecipeType<GemPolisherRecipe> GEM_POLISHER_RECIPE_TYPE =
            new RecipeType<>(UID, GemPolisherRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public GemPolishingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.Gem_polisher_block.get()));
    }

    @Override
    public RecipeType<GemPolisherRecipe> getRecipeType() {
        return GEM_POLISHER_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.enhanced_minecraft.gem_polisher");
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
    public void setRecipe(IRecipeLayoutBuilder builder, GemPolisherRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 55, 34).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 130,33).addItemStack(recipe.getResultItem(null));
    }
}

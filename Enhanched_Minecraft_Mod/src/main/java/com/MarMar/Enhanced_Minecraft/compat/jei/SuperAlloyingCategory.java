package com.MarMar.Enhanced_Minecraft.compat.jei;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.recipe.SuperAlloyingRecipe;
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

public class SuperAlloyingCategory implements IRecipeCategory<SuperAlloyingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Enhanced_Playthrough.MOD_ID, "super_ore_alloying");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Enhanced_Playthrough.MOD_ID,
            "textures/gui/super_alloying_furnace_gui.png");

    public static final RecipeType<SuperAlloyingRecipe> SUPER_ALLOYING_RECIPE_TYPE =
            new RecipeType<>(UID, SuperAlloyingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SuperAlloyingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 82);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SUPER_ALLOYING_FURNACE.get()));
    }

    @Override
    public RecipeType<SuperAlloyingRecipe> getRecipeType() {
        return SUPER_ALLOYING_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.enhanced_minecraft.super_alloying_furnace");
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
    public void setRecipe(IRecipeLayoutBuilder builder, SuperAlloyingRecipe recipe, IFocusGroup iFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 17).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 74,17).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 35).addItemStack(recipe.getResultItem(null));
    }
}

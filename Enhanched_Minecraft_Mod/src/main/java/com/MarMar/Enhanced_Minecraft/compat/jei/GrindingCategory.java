package com.MarMar.Enhanced_Minecraft.compat.jei;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.recipe.AlloyingFurnaceRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.GrindingRecipe;
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
import org.jetbrains.annotations.Nullable;

public class GrindingCategory implements IRecipeCategory<GrindingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Enhanced_Minecraft.MOD_ID, "grinding");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Enhanced_Minecraft.MOD_ID,
            "textures/gui/grinder_gui.png");

    public static final RecipeType<GrindingRecipe> GRINDING_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, GrindingRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public GrindingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.Item_grinder_block.get()));
    }
    @Override
    public RecipeType<GrindingRecipe> getRecipeType() {
        return GRINDING_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.enhanced_minecraft.grinder");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder recipeLayoutBuilder, GrindingRecipe grindingRecipe, IFocusGroup iFocusGroup) {
        recipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 53, 19).addIngredients(grindingRecipe.getIngredient());

        recipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 124, 24).addItemStack(grindingRecipe.getResultItem(null));
    }
}

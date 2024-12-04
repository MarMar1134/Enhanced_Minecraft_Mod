package com.MarMar.Enhanced_Minecraft.compat.jei;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.recipe.basic.BasicSmeltingRecipe;
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

public class BasicSmeltingCategory implements IRecipeCategory<BasicSmeltingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Enhanced_Playthrough.MOD_ID, "basic_smelting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Enhanced_Playthrough.MOD_ID,
            "textures/gui/basic_furnace_gui.png");

    public static final RecipeType<BasicSmeltingRecipe> BASIC_SMELTING_TYPE =
            new RecipeType<>(UID, BasicSmeltingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public BasicSmeltingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 78);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ADOBE_FURNACE.get()));
    }

    @Override
    public RecipeType<BasicSmeltingRecipe> getRecipeType() {
        return BASIC_SMELTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.enhanced_minecraft.adobe_furnace");
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
    public void setRecipe(IRecipeLayoutBuilder builder, BasicSmeltingRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 56, 17).addIngredients(recipe.getIngredient());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116,35).addItemStack(recipe.getResultItem(null));
    }
}

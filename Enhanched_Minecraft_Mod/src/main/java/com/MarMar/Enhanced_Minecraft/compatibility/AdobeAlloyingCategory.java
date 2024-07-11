package com.MarMar.Enhanced_Minecraft.compatibility;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.blocks.ModBlocks;
import com.MarMar.Enhanced_Minecraft.recipe.AlloyingFurnaceRecipe;
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

public class AdobeAlloyingCategory implements IRecipeCategory<AlloyingFurnaceRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Enhanced_Minecraft.MOD_ID, "ore_alloying");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Enhanced_Minecraft.MOD_ID,
            "textures/gui/adobe_alloying_furnace_gui.png");
    public static final RecipeType<AlloyingFurnaceRecipe> ADOBE_ALLOYING_TYPE = new RecipeType<>(UID, AlloyingFurnaceRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public AdobeAlloyingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,0,0,176,85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.Adobe_alloying_furnace.get()));
    }

    @Override
    public RecipeType<AlloyingFurnaceRecipe> getRecipeType() {
        return ADOBE_ALLOYING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.enhanced_minecraft.adobe_alloying_furnace");
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
    public void setRecipe(IRecipeLayoutBuilder builder, AlloyingFurnaceRecipe alloyingFurnaceRecipe, IFocusGroup iFocusGroup) {
    builder.addSlot(RecipeIngredientRole.INPUT,37,17).addIngredients(alloyingFurnaceRecipe.getIngredients().get(0));
    builder.addSlot(RecipeIngredientRole.INPUT,74,17).addIngredients(alloyingFurnaceRecipe.getIngredients().get(1));

    builder.addSlot(RecipeIngredientRole.OUTPUT,116,35).addItemStack(alloyingFurnaceRecipe.getResultItem(null));
    }
}

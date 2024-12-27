package com.marmar.enhanced_playthrough.recipe.alloy;

import com.marmar.enhanced_playthrough.recipe.ModRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public abstract class AbstractAlloyRecipe implements Recipe<SimpleContainer> {
    protected final RecipeType<?> recipeType;
    protected final NonNullList<Ingredient> inputs;
    protected final ItemStack output;
    protected final int alloyTime;
    protected final ResourceLocation id;
    private final ModRecipeCategory category;
    private final String group;

    public AbstractAlloyRecipe(NonNullList<Ingredient> inputs, ItemStack output, int alloyingTime, ResourceLocation id, RecipeType<?> recipeType, ModRecipeCategory category, String group) {
        this.inputs = inputs;
        this.output = output;
        this.alloyTime = alloyingTime;
        this.id = id;
        this.recipeType = recipeType;
        this.category = category;
        this.group = group;
    }
    public int getAlloyTime(){
        return this.alloyTime;
    }
    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return inputs.get(0).test(simpleContainer.getItem(0)) && inputs.get(1).test(simpleContainer.getItem(1));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputs;
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }
}

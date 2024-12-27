package com.marmar.enhanced_playthrough.recipe.basic;

import com.marmar.enhanced_playthrough.recipe.ModRecipeCategory;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

public abstract class AbstractBasicSmeltingRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input;
    private final ItemStack output;
    private final ResourceLocation id;
    private final int CoockingTime;
    private final ModRecipeCategory category;
    private final String group;

    public AbstractBasicSmeltingRecipe(Ingredient input, ItemStack output, ResourceLocation id, int coockingTime, ModRecipeCategory category, String group) {
        this.input = input;
        this.output = output;
        this.id = id;
        CoockingTime = coockingTime;
        this.category = category;
        this.group = group;
    }

    public Ingredient getIngredient() {
        return this.input;
    }
    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return input.test(simpleContainer.getItem(0));
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

    public int getCoockingTime(){
        return CoockingTime;
    }
}

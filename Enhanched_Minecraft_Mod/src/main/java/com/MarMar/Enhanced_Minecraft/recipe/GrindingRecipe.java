package com.MarMar.Enhanced_Minecraft.recipe;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class GrindingRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input;
    private final ItemStack output;
    private final ResourceLocation id;

    public GrindingRecipe(Ingredient input, ItemStack output, ResourceLocation id) {
        this.input = input;
        this.output = output;
        this.id = id;
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

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.Instance;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.Instance;
    }
    public static class Type implements RecipeType<GrindingRecipe>{
        public static final GrindingRecipe.Type Instance = new GrindingRecipe.Type();
        private static String ID = "grinding";
    }
    public static class Serializer implements RecipeSerializer<GrindingRecipe>{
        public static final Serializer Instance = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Enhanced_Minecraft.MOD_ID, "grinding");

        @Override
        public GrindingRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(ingredientElement, false);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            return new GrindingRecipe(ingredient, output, resourceLocation);
        }

        @Override
        public @Nullable GrindingRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);

            ItemStack output = friendlyByteBuf.readItem();

            return new GrindingRecipe(ingredient, output, resourceLocation);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, GrindingRecipe grindingRecipe) {
            grindingRecipe.input.toNetwork(friendlyByteBuf);

            friendlyByteBuf.writeItemStack(grindingRecipe.getResultItem(null), false);
        }
    }
}

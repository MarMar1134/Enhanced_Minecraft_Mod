package com.MarMar.Enhanced_Minecraft.recipe;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BasicSmeltingRecipe extends AbstractCookingRecipe{
    protected final ResourceLocation id;
    protected final String group;
    protected final Ingredient  ingredient;
    protected final ItemStack result;
    protected final float experience;
    protected final int cookingTime;

    public BasicSmeltingRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
        super(Type.Instance, pId, pGroup, null, pIngredient, pResult, pExperience, pCookingTime);
        this.id = pId;
        this.group = pGroup;
        this.ingredient = pIngredient;
        this.result = pResult;
        this.experience = pExperience;
        this.cookingTime = pCookingTime;
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.Adobe_furnace.get());
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(this.ingredient);
        return ingredients;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return result.copy();
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
    public static class Type implements RecipeType<BasicSmeltingRecipe>{
        public static final Type Instance = new Type();
        private static String ID = "basic_smelting";
    }

    public static class Serializer implements RecipeSerializer<BasicSmeltingRecipe>{
        public static final Serializer Instance = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Enhanced_Minecraft.MOD_ID, "basic_smelting");
        @Override
        public BasicSmeltingRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            String s = GsonHelper.getAsString(jsonObject, "group", "");

            JsonElement jsonelement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(jsonelement, false);
            if (!jsonObject.has("result")) {
                throw new JsonSyntaxException("Missing result, expected to find a string or object");
            } else {
                ItemStack itemstack;
                if (jsonObject.get("result").isJsonObject()) {
                    itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result"));
                } else {
                    String s1 = GsonHelper.getAsString(jsonObject, "result");
                    ResourceLocation resourcelocation = new ResourceLocation(s1);
                    itemstack = new ItemStack((ItemLike) BuiltInRegistries.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
                        return new IllegalStateException("Item: " + s1 + " does not exist");
                    }));
                }

                float f = GsonHelper.getAsFloat(jsonObject, "experience", 0.0F);
                int i = GsonHelper.getAsInt(jsonObject, "cookingtime", 250);

            return new BasicSmeltingRecipe(ID, s, ingredient, itemstack, f, i);
            }
        }
        @Override
        public @Nullable BasicSmeltingRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            String s = friendlyByteBuf.readUtf();
            Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);
            ItemStack itemstack = friendlyByteBuf.readItem();
            float f = friendlyByteBuf.readFloat();
            int i = friendlyByteBuf.readVarInt();

            return new BasicSmeltingRecipe(ID, s, ingredient, itemstack, f, i);
        }
        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, BasicSmeltingRecipe recipe) {
            pBuffer.writeUtf(recipe.group);
            recipe.ingredient.toNetwork(pBuffer);
            pBuffer.writeItem(recipe.result);
            pBuffer.writeFloat(recipe.experience);
            pBuffer.writeVarInt(recipe.cookingTime);
        }
    }
}


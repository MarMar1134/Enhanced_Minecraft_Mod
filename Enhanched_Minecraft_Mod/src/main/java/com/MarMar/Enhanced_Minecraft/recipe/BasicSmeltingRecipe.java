package com.MarMar.Enhanced_Minecraft.recipe;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BasicSmeltingRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input;
    private final ItemStack output;
    private final ResourceLocation id;
    private final int CoockingTime;
    private final ModRecipeCategory category;
    private final String group;

    public BasicSmeltingRecipe(Ingredient input, ItemStack output, ResourceLocation id, int cookingTime, ModRecipeCategory category, String group) {
        this.input = input;
        this.output = output;
        this.id = id;
        CoockingTime = cookingTime;
        this.category = category;
        this.group = group;
    } public Ingredient getIngredient() {
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

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<BasicSmeltingRecipe>{
        public static final Type INSTANCE = new Type();
        private static String ID = "basic_smelting";
    }
    public static class Serializer implements RecipeSerializer<BasicSmeltingRecipe>{
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Enhanced_Playthrough.MOD_ID, "basic_smelting");

        public final int defaultCookTime = 0;
        @Override
        public BasicSmeltingRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ModRecipeCategory recipeCategory = ModRecipeCategory.CODEC.byName(GsonHelper.getAsString(jsonObject, "category"));

            String group = GsonHelper.getAsString(jsonObject, "group");

            int cookTime = GsonHelper.getAsInt(jsonObject, "cooktime", defaultCookTime);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient input = Ingredient.fromJson(ingredientElement, false);



            return new BasicSmeltingRecipe(input, output, resourceLocation, cookTime, recipeCategory, group);
        }

        @Override
        public @Nullable BasicSmeltingRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            ModRecipeCategory recipeCategory = friendlyByteBuf.readEnum(ModRecipeCategory.class);

            String group = friendlyByteBuf.readUtf();


            int alloyTime = friendlyByteBuf.readVarInt();

            Ingredient input = Ingredient.fromNetwork(friendlyByteBuf);

            ItemStack output = friendlyByteBuf.readItem();

            return new BasicSmeltingRecipe(input, output, resourceLocation, alloyTime, recipeCategory, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, BasicSmeltingRecipe recipe) {
            friendlyByteBuf.writeEnum(recipe.category);

            friendlyByteBuf.writeUtf(recipe.group);

            friendlyByteBuf.writeVarInt(recipe.CoockingTime);

            recipe.input.toNetwork(friendlyByteBuf);

            friendlyByteBuf.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}

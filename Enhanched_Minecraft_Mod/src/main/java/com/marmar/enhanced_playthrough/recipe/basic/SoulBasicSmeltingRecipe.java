package com.marmar.enhanced_playthrough.recipe.basic;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import com.marmar.enhanced_playthrough.recipe.ModRecipeCategory;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SoulBasicSmeltingRecipe extends AbstractBasicSmeltingRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input;
    private final int CoockingTime;
    private final ModRecipeCategory category;
    private final String group;

    public SoulBasicSmeltingRecipe(Ingredient input, ItemStack output, ResourceLocation id, int cookingTime, ModRecipeCategory category, String group) {
        super(input, output, id, cookingTime, category, group);
        this.input = input;
        CoockingTime = cookingTime;
        this.category = category;
        this.group = group;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return input.test(simpleContainer.getItem(0));
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<SoulBasicSmeltingRecipe>{
        public static final Type INSTANCE = new Type();
        private static String ID = "soul_basic_smelting";
    }
    public static class Serializer implements RecipeSerializer<SoulBasicSmeltingRecipe>{
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "soul_basic_smelting");

        public final int defaultCookTime = 0;
        @Override
        public SoulBasicSmeltingRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ModRecipeCategory recipeCategory = ModRecipeCategory.CODEC.byName(GsonHelper.getAsString(jsonObject, "category"));

            String group = GsonHelper.getAsString(jsonObject, "group");

            int cookTime = GsonHelper.getAsInt(jsonObject, "cooktime", defaultCookTime);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonElement ingredientElement = GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient");
            Ingredient input = Ingredient.fromJson(ingredientElement, false);



            return new SoulBasicSmeltingRecipe(input, output, resourceLocation, cookTime, recipeCategory, group);
        }

        @Override
        public @Nullable SoulBasicSmeltingRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            ModRecipeCategory recipeCategory = friendlyByteBuf.readEnum(ModRecipeCategory.class);

            String group = friendlyByteBuf.readUtf();


            int alloyTime = friendlyByteBuf.readVarInt();

            Ingredient input = Ingredient.fromNetwork(friendlyByteBuf);

            ItemStack output = friendlyByteBuf.readItem();

            return new SoulBasicSmeltingRecipe(input, output, resourceLocation, alloyTime, recipeCategory, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, SoulBasicSmeltingRecipe recipe) {
            friendlyByteBuf.writeEnum(recipe.category);

            friendlyByteBuf.writeUtf(recipe.group);

            friendlyByteBuf.writeVarInt(recipe.CoockingTime);

            recipe.input.toNetwork(friendlyByteBuf);

            friendlyByteBuf.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}

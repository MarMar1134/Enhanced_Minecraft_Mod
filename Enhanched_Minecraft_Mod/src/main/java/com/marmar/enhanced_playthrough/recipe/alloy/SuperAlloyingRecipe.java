package com.marmar.enhanced_playthrough.recipe.alloy;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import com.marmar.enhanced_playthrough.recipe.ModRecipeCategory;
import com.marmar.enhanced_playthrough.recipe.ModRecipes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.Nullable;

public class SuperAlloyingRecipe extends AbstractAlloyRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputs;
    private final int alloyTime;
    private final ModRecipeCategory category;
    private final String group;

    public SuperAlloyingRecipe(NonNullList<Ingredient> inputs, ItemStack output, int alloyingTime, ResourceLocation id, ModRecipeCategory category, String group) {
        super(inputs, output, alloyingTime, id, ModRecipes.SUPER_ALLOYING_TYPE.get(), category, group);
        this.inputs = inputs;
        this.alloyTime = alloyingTime;
        this.category = category;
        this.group = group;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SuperAlloyingRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return SuperAlloyingRecipe.Type.INSTANCE;
    }
    public static class Type implements RecipeType<SuperAlloyingRecipe>{
        public static final SuperAlloyingRecipe.Type INSTANCE = new SuperAlloyingRecipe.Type();
        private static String ID = "super_ore_alloying";
    }
    public static class Serializer implements RecipeSerializer<SuperAlloyingRecipe>{
        public static final SuperAlloyingRecipe.Serializer INSTANCE = new SuperAlloyingRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(EnhancedPlaythrough.MOD_ID, "super_ore_alloying");

        public final int defaultAlloyTime = 0;
        @Override
        public SuperAlloyingRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ModRecipeCategory recipeCategory = ModRecipeCategory.CODEC.byName(GsonHelper.getAsString(jsonObject, "category"));

            String group = GsonHelper.getAsString(jsonObject, "group");

            int alloyTime = GsonHelper.getAsInt(jsonObject, "alloytime", defaultAlloyTime);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new SuperAlloyingRecipe(inputs, output, alloyTime, resourceLocation, recipeCategory, group);
        }

        @Override
        public @Nullable SuperAlloyingRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            ModRecipeCategory recipeCategory = friendlyByteBuf.readEnum(ModRecipeCategory.class);

            String group = friendlyByteBuf.readUtf();

            int alloyTime = friendlyByteBuf.readVarInt();

            NonNullList<Ingredient> inputs = NonNullList.withSize(friendlyByteBuf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromNetwork(friendlyByteBuf));
            }
            ItemStack output = friendlyByteBuf.readItem();
            return new SuperAlloyingRecipe(inputs, output, alloyTime, resourceLocation, recipeCategory, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, SuperAlloyingRecipe recipes) {
            friendlyByteBuf.writeEnum(recipes.category);

            friendlyByteBuf.writeUtf(recipes.group);

            friendlyByteBuf.writeVarInt(recipes.alloyTime);

            friendlyByteBuf.writeInt(recipes.inputs.size());

            for (Ingredient ingredient : recipes.getIngredients()) {
                ingredient.toNetwork(friendlyByteBuf);
            }
            friendlyByteBuf.writeItemStack(recipes.getResultItem(null), false);
        }
    }
}

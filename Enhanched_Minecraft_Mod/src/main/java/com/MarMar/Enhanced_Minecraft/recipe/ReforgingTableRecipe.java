package com.MarMar.Enhanced_Minecraft.recipe;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.google.gson.JsonArray;
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

public class ReforgingTableRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputs;
    private final ItemStack output;
    private final ResourceLocation id;

    public ReforgingTableRecipe(NonNullList<Ingredient> inputs, ItemStack output, ResourceLocation id) {
        this.inputs = inputs;
        this.output = output;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer simpleContainer, Level level) {
        if (level.isClientSide){
            return false;
        }
        return inputs.get(0).test(simpleContainer.getItem(0)) && inputs.get(1).test(simpleContainer.getItem(1));
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
    public static class Type implements RecipeType<ReforgingTableRecipe>{
        public static final ReforgingTableRecipe.Type Instance = new ReforgingTableRecipe.Type();
        private static String ID = "reforging";
    }
    public static class Serializer implements RecipeSerializer<ReforgingTableRecipe>{
        public static final ReforgingTableRecipe.Serializer Instance = new ReforgingTableRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Enhanced_Minecraft.MOD_ID, "ore_alloying");

        @Override
        public ReforgingTableRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new ReforgingTableRecipe(inputs, output, resourceLocation);
        }

        @Override
        public @Nullable ReforgingTableRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(friendlyByteBuf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromNetwork(friendlyByteBuf));
            }
            ItemStack output = friendlyByteBuf.readItem();
            return new ReforgingTableRecipe(inputs, output, resourceLocation);
        }


        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, ReforgingTableRecipe reforgingTableRecipes) {
            friendlyByteBuf.writeInt(reforgingTableRecipes.inputs.size());

            for (Ingredient ingredient : reforgingTableRecipes.getIngredients()) {
                ingredient.toNetwork(friendlyByteBuf);
            }
            friendlyByteBuf.writeItemStack(reforgingTableRecipes.getResultItem(null), false);
        }
    }
}

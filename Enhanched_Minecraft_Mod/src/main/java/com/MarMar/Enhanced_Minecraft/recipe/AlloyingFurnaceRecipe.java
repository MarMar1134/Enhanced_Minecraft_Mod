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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class AlloyingFurnaceRecipe implements Recipe<SimpleContainer> {
private final NonNullList<Ingredient> inputs;
private final ItemStack output;
private final int alloyTime;
private final ResourceLocation id;

    public AlloyingFurnaceRecipe(NonNullList<Ingredient> inputs, ItemStack output, int alloyingTime, ResourceLocation id) {
        this.inputs = inputs;
        this.output = output;
        this.alloyTime = alloyingTime;
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

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.Instance;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.Instance;
    }
    public static class Type implements RecipeType<AlloyingFurnaceRecipe>{
        public static final Type Instance = new Type();
        private static String ID = "ore_alloying";
    }
    public static class Serializer implements RecipeSerializer<AlloyingFurnaceRecipe>{
        public static final Serializer Instance = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Enhanced_Minecraft.MOD_ID, "ore_alloying");

        public final int defaultAlloyTime = 0;
        @Override
        public AlloyingFurnaceRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            int alloyTime = GsonHelper.getAsInt(jsonObject, "alloytime", defaultAlloyTime);

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new AlloyingFurnaceRecipe(inputs, output, alloyTime, resourceLocation);
        }

        @Override
        public @Nullable AlloyingFurnaceRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            int alloyTime = friendlyByteBuf.readVarInt();

            NonNullList<Ingredient> inputs = NonNullList.withSize(friendlyByteBuf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromNetwork(friendlyByteBuf));
            }

            ItemStack output = friendlyByteBuf.readItem();
            return new AlloyingFurnaceRecipe(inputs, output, alloyTime, resourceLocation);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, AlloyingFurnaceRecipe alloyingFurnaceRecipes) {
            friendlyByteBuf.writeVarInt(alloyingFurnaceRecipes.alloyTime);

            friendlyByteBuf.writeInt(alloyingFurnaceRecipes.inputs.size());

            for (Ingredient ingredient : alloyingFurnaceRecipes.getIngredients()) {
                ingredient.toNetwork(friendlyByteBuf);
            }
            friendlyByteBuf.writeItemStack(alloyingFurnaceRecipes.getResultItem(null), false);
        }
    }
}

package com.MarMar.Enhanced_Minecraft.recipe.builder;

import com.MarMar.Enhanced_Minecraft.recipe.GemPolishingRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.GrindingRecipe;
import com.MarMar.Enhanced_Minecraft.recipe.ModRecipeCategory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.stringtemplate.v4.ST;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ModBasicRecipeBuilder implements RecipeBuilder {

    private final Item result;
    private final ModRecipeCategory category;
    private String group;
    private final Ingredient ingredient;
    private final int count;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<?> serializer;

    private ModBasicRecipeBuilder(ItemLike pResult, int count, Ingredient pIngredient, ModRecipeCategory category, String group, RecipeSerializer<?> pSerializer) {
        this.result = pResult.asItem();
        this.category = category;
        this.group = group;
        this.count = count;
        this.ingredient = pIngredient;
        this.serializer = pSerializer;
    }
    public static ModBasicRecipeBuilder gemPolishing(Ingredient pIngredient, ItemLike pResult, String group, RecipeSerializer<? extends GemPolishingRecipe> pCookingSerializer) {
        return new ModBasicRecipeBuilder(pResult, 1, pIngredient, ModRecipeCategory.GEM_POLISH, group, pCookingSerializer);
    }
    public static ModBasicRecipeBuilder itemGrinding(Ingredient pIngredient, ItemLike pResult, String group, int quantity, RecipeSerializer<? extends GrindingRecipe> pCookingSerializer) {
        return new ModBasicRecipeBuilder(pResult, quantity, pIngredient, ModRecipeCategory.GRIND, group, pCookingSerializer);
    }
    @Override
    public ModBasicRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public ModBasicRecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        this.ensureValid(resourceLocation);
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(resourceLocation)).requirements(RequirementsStrategy.OR);
        consumer.accept(new Result(resourceLocation, this.ingredient, this.result, this.category, this.group, this.count, this.advancement, resourceLocation.withPrefix("recipes/"), this.serializer));
    }
    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }
    static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Ingredient ingredient;
        private final Item result;
        private final ModRecipeCategory category;
        private String group;
        private final int count;
        private final Advancement.Builder advancement;
        private final ResourceLocation resourceLocation;
        private final RecipeSerializer<?> serializer;

        public Result(ResourceLocation pId, Ingredient pIngredient, Item pResult, ModRecipeCategory category, String group, int quantity, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, RecipeSerializer<?> pSerializer) {
            this.id = pId;
            this.ingredient = pIngredient;
            this.result = pResult;
            this.category = category;
            this.group = group;
            this.count = quantity;
            this.advancement = pAdvancement;
            this.resourceLocation = pAdvancementId;
            this.serializer = pSerializer;
        }
        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()){
                pJson.addProperty("group", this.group);
            }

            pJson.addProperty("category", this.category.getSerializedName());

            //Input
            pJson.add("ingredient", this.ingredient.toJson());

            //Output
            JsonObject outputObject = new JsonObject();

            outputObject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());

            if (this.count != 1){
                outputObject.addProperty("count", this.count);
            }

            pJson.add("output", outputObject);
        }

        public RecipeSerializer<?> getType() {
            return this.serializer;
        }

        public ResourceLocation getId() {
            return this.id;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.resourceLocation;
        }
    }
}

package com.MarMar.Enhanced_Minecraft.recipe;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    //Registers
    public static final DeferredRegister<RecipeSerializer<?>> Serializers =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Enhanced_Minecraft.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> Types =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Enhanced_Minecraft.MOD_ID);

    //Recipes
        //Ore alloying
        public static final RegistryObject<RecipeSerializer<AlloyingFurnaceRecipe>> Alloying_serializer =
                Serializers.register("ore_alloying", () -> AlloyingFurnaceRecipe.Serializer.Instance);
        public static final RegistryObject<RecipeType<AlloyingFurnaceRecipe>> Alloying_type =
                Types.register("ore_alloying", () -> AlloyingFurnaceRecipe.Type.Instance);

        //Super ore alloying
        public static final RegistryObject<RecipeSerializer<SuperAlloyingRecipe>> Super_alloying_serializer =
                Serializers.register("super_ore_alloying", () -> SuperAlloyingRecipe.Serializer.Instance);
        public static final RegistryObject<RecipeType<SuperAlloyingRecipe>> Super_alloying_type =
                Types.register("super_ore_alloying", () -> SuperAlloyingRecipe.Type.Instance);

        //Gem polishing
        public static final RegistryObject<RecipeSerializer<GemPolishingRecipe>> Polishing_serializer =
                Serializers.register("gem_polishing", () -> GemPolishingRecipe.Serializer.Instance);
        public static final RegistryObject<RecipeType<GemPolishingRecipe>> Polishing_type =
                Types.register("gem_polishing", () -> GemPolishingRecipe.Type.Instance);

        //Grinding
        public static final RegistryObject<RecipeSerializer<GrindingRecipe>> Grinding_serializer =
                Serializers.register("grinding", () -> GrindingRecipe.Serializer.Instance);
        public static final RegistryObject<RecipeType<GrindingRecipe>> Grinding_type =
                Types.register("grinding", () -> GrindingRecipe.Type.Instance);
    public static void Register(IEventBus eventBus){
        Serializers.register(eventBus);
        Types.register(eventBus);
    }
}

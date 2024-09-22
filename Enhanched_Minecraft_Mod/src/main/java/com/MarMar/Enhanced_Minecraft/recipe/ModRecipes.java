package com.MarMar.Enhanced_Minecraft.recipe;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    //Registers
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Enhanced_Playthrough.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Enhanced_Playthrough.MOD_ID);

    //Recipes
        //Ore alloying
        public static final RegistryObject<RecipeSerializer<AlloyingFurnaceRecipe>> ALLOYING_SERIALIZER =
                RECIPE_SERIALIZER.register("ore_alloying", () -> AlloyingFurnaceRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<AlloyingFurnaceRecipe>> ALLOYING_TYPE =
                RECIPE_TYPE.register("ore_alloying", () -> AlloyingFurnaceRecipe.Type.INSTANCE);

        //Super ore alloying
        public static final RegistryObject<RecipeSerializer<SuperAlloyingRecipe>> SUPER_ALLOYING_SERIALIZER =
                RECIPE_SERIALIZER.register("super_ore_alloying", () -> SuperAlloyingRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<SuperAlloyingRecipe>> SUPER_ALLOYING_TYPE =
                RECIPE_TYPE.register("super_ore_alloying", () -> SuperAlloyingRecipe.Type.INSTANCE);

        //Gem polishing
        public static final RegistryObject<RecipeSerializer<GemPolishingRecipe>> POLISHING_SERIALIZER =
                RECIPE_SERIALIZER.register("gem_polishing", () -> GemPolishingRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<GemPolishingRecipe>> POLISHING_TYPE =
                RECIPE_TYPE.register("gem_polishing", () -> GemPolishingRecipe.Type.INSTANCE);

        //Grinding
        public static final RegistryObject<RecipeSerializer<GrindingRecipe>> GRINDING_SERIALIZER =
                RECIPE_SERIALIZER.register("grinding", () -> GrindingRecipe.Serializer.INSTANCE);
        public static final RegistryObject<RecipeType<GrindingRecipe>> GRINDING_TYPE =
                RECIPE_TYPE.register("grinding", () -> GrindingRecipe.Type.INSTANCE);
    public static void Register(IEventBus eventBus){
        RECIPE_SERIALIZER.register(eventBus);
        RECIPE_TYPE.register(eventBus);
    }
}

package com.MarMar.Enhanced_Minecraft.recipe;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> Serializers =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Enhanced_Minecraft.MOD_ID);

    public static final RegistryObject<RecipeSerializer<AlloyingFurnaceRecipe>> Alloying_serializer =
            Serializers.register("ore_alloying", () -> AlloyingFurnaceRecipe.Serializer.Instance);
    public static final RegistryObject<RecipeSerializer<SuperAlloyingRecipe>> Super_alloying_serializer =
            Serializers.register("super_ore_alloying", () -> SuperAlloyingRecipe.Serializer.Instance);
    public static final RegistryObject<RecipeSerializer<GemPolisherRecipe>> Polishing_serializer =
            Serializers.register("gem_polishing", () -> GemPolisherRecipe.Serializer.Instance);
    public static void Register (IEventBus eventBus){
        Serializers.register(eventBus);
    }
}

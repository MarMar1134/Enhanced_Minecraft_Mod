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
    public static final RegistryObject<RecipeSerializer<ReforgingTableRecipe>> Reforging_serializer =
            Serializers.register("reforging", () -> ReforgingTableRecipe.Serializer.Instance);

    public static void Register (IEventBus eventBus){
        Serializers.register(eventBus);
    }
}

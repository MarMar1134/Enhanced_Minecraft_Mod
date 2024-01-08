package com.MarMar.Enhanced_Minecraft.init;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitItems {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(
            ForgeRegistries.ITEMS, Enhanced_Minecraft.MOD_ID
    );
    //Saplings
        //Fruits
    public static final RegistryObject<Item> Orange_sapling = Items.register(
          "orange_sapling",() -> new Item(new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<Item> Lemon_sapling = Items.register(
            "lemon_sapling", () -> new Item(new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<Item> Apple_sapling = Items.register(
            "apple_sapling",() -> new Item(new Item.Properties().stacksTo(64))
    );
        //Nuts
    public static final RegistryObject<Item> Hazelnut_sapling = Items.register(
            "hazelnut_sapling",() -> new Item(new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<Item> Walnut_sapling = Items.register(
            "walnut_sapling",() -> new Item(new Item.Properties().stacksTo(64))
    );
    public static final RegistryObject<Item> Almond_sapling = Items.register(
            "almond_sapling",() -> new Item(new Item.Properties().stacksTo(64))
    );
    //Seeds
    public static final RegistryObject<Item> Banana_seed = Items.register(
            "banana_seed",() -> new Item(new Item.Properties().stacksTo(64))
    );
    //Blocks

    //Food
    public static final RegistryObject<Item> Orange = Items.register(
            "orange",() -> new Item(new Item.Properties().stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(6).saturationMod(3).build()))
    );
    public static final RegistryObject<Item> Lemon = Items.register(
            "lemon",() -> new Item(new Item.Properties().stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(2).build()))
    );
    public static final RegistryObject<Item> Green_apple = Items.register(
            "green_apple",() -> new Item(new Item.Properties().stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(2).build()))
    );
    public static final RegistryObject<Item> Banana = Items.register(
            "banana",() -> new Item(new Item.Properties().stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(2).build()))
    );
}

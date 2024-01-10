package com.MarMar.Enhanced_Minecraft.items;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.Util.ModTiers;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(
            ForgeRegistries.ITEMS, Enhanced_Minecraft.MOD_ID
    );
    //Saplings
        //Fruits
            //    public static final RegistryObject<Item> Orange_sapling = Items.register(
            //          "orange_sapling",() -> new Item(new Item.Properties().stacksTo(64))
            //    );
            //    public static final RegistryObject<Item> Lemon_sapling = Items.register(
            //            "lemon_sapling", () -> new Item(new Item.Properties().stacksTo(64))
            //    );
            //    public static final RegistryObject<Item> Apple_sapling = Items.register(
            //            "apple_sapling",() -> new Item(new Item.Properties())
            //    );
            //        //Nuts
            //    public static final RegistryObject<Item> Hazelnut_sapling = Items.register(
            //            "hazelnut_sapling",() -> new Item(new Item.Properties().stacksTo(64))
            //    );
            //    public static final RegistryObject<Item> Walnut_sapling = Items.register(
            //            "walnut_sapling",() -> new Item(new Item.Properties().stacksTo(64))
            //    );
            //    public static final RegistryObject<Item> Almond_sapling = Items.register(
            //            "almond_sapling",() -> new Item(new Item.Properties().stacksTo(64))
            //    );
            //    //Seeds
            //    public static final RegistryObject<Item> Banana_seed = Items.register(
            //            "banana_seed",() -> new Item(new Item.Properties().stacksTo(64))
            //    );

    //Ores (raw and melted)
    public static final RegistryObject<Item> Sulfur = Items.register(
            "sulfur",() -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> Raw_tin = Items.register(
            "raw_tin",() -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> Tin_ingot = Items.register(
            "tin_ingot",() -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> Bronze_ingot = Items.register(
            "bronze_ingot",() -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> Raw_steel = Items.register(
            "raw_steel", () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> Steel_ingot = Items.register(
            "steel_ingot", () -> new Item(new Item.Properties())
    );
    //Weapons and tools
        //Bronze
        public static final RegistryObject<SwordItem> Bronze_sword = Items.register(
                            "bronze_sword",() -> new SwordItem(
                        ModTiers.Bronze, 4, 0, new Item.Properties())
                    );
        public static final RegistryObject<PickaxeItem> Bronze_picaxe = Items.register(
                            "bronze_picaxe",() -> new PickaxeItem(
                                    ModTiers.Bronze, 1, 2,  new Item.Properties())
                    );
        public static final RegistryObject<AxeItem> Bronze_axe = Items.register(
                "bronze_axe",() -> new AxeItem(
                        ModTiers.Bronze, 2, 1,  new Item.Properties())
        );
        public static final RegistryObject<ShovelItem> Bronze_shovel = Items.register(
                "bronze_shovel",() -> new ShovelItem(
                        ModTiers.Bronze, 1, 2,  new Item.Properties())
        );
        public static final RegistryObject<HoeItem> Bronze_hoe = Items.register(
                "bronze_hoe",() -> new HoeItem(
                        ModTiers.Bronze, 1, 2,  new Item.Properties())
        );
    //Food
    public static final RegistryObject<Item> Orange = Items.register(
            "orange",() -> new Item(new Item.Properties().stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(2).build()))
    );
    public static final RegistryObject<Item> Lemon = Items.register(
            "lemon",() -> new Item(new Item.Properties().stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(1).build()))
    );
    public static final RegistryObject<Item> Green_apple = Items.register(
            "green_apple",() -> new Item(new Item.Properties().stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(2).build()))
    );
    public static final RegistryObject<Item> Banana = Items.register(
            "banana",() -> new Item(new Item.Properties().stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(2).build()))
    );

    //Final register
    public static void Register(IEventBus eventBus){
        Items.register(eventBus);
    }
}

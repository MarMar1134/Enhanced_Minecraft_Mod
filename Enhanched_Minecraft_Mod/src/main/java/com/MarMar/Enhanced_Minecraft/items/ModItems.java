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
    //Ores
        //raw
        public static final RegistryObject<Item> Sulfur = Items.register(
                "sulfur",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Raw_tin = Items.register(
                "raw_tin",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Raw_bronze = Items.register(
                "raw_bronze", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Raw_steel = Items.register(
                "raw_steel", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Raw_silver = Items.register(
                "raw_silver", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Cobalt = Items.register(
                "cobalt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Raw_rubi = Items.register(
            "raw_rubi", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Raw_saphire = Items.register(
            "raw_saphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Raw_emerald = Items.register(
            "raw_emerald", () -> new Item(new Item.Properties()));
        //melted
        public static final RegistryObject<Item> Tin_ingot = Items.register(
                "tin_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Bronze_ingot = Items.register(
                "bronze_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Bronze_nuggets = Items.register(
                "bronze_nuggets", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Steel_ingot = Items.register(
                "steel_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Silver_ingot = Items.register(
                "silver_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Rubi = Items.register(
            "rubi", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Saphire = Items.register(
            "saphire", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Reinforced_diamond = Items.register(
                "reinforced_diamond", () -> new Item(new Item.Properties()));

    //Smithing tables
    public static final RegistryObject<Item> reinforcing_upgrade_smithing_template = Items.register(
            "reinforcing_upgrade_smithing_template", () -> new Item(new Item.Properties()));

    //Weapons, tools and armors
        //Bronze
        public static final RegistryObject<Item> Bronze_sword = Items.register(
                "bronze_sword",() -> new SwordItem(ModTiers.Bronze, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Bronze_pickaxe = Items.register(
                "bronze_pickaxe",() -> new PickaxeItem(ModTiers.Bronze, 1, -2.8F,  new Item.Properties()));
        public static final RegistryObject<Item> Bronze_axe = Items.register(
                "bronze_axe",() -> new AxeItem(ModTiers.Bronze, 6, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> Bronze_shovel = Items.register(
                "bronze_shovel",() -> new ShovelItem(ModTiers.Bronze, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> Bronze_hoe = Items.register(
                "bronze_hoe",() -> new HoeItem(ModTiers.Bronze, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> Bronze_helmet= Items.register(
                "bronze_helmet", () -> new ArmorItem(ModArmorMaterials.Bronze, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> Bronze_chestplate= Items.register(
                "bronze_chestplate", () -> new ArmorItem(ModArmorMaterials.Bronze, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> Bronze_leggings= Items.register(
                "bronze_leggings", () -> new ArmorItem(ModArmorMaterials.Bronze, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> Bronze_boots= Items.register(
                "bronze_boots", () -> new ArmorItem(ModArmorMaterials.Bronze, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Steel
        public static final RegistryObject<Item> Steel_sword = Items.register(
                "steel_sword",() -> new SwordItem(ModTiers.Steel, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Steel_pickaxe = Items.register(
                "steel_pickaxe",() -> new PickaxeItem(ModTiers.Steel, 0, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> Steel_axe = Items.register(
                "steel_axe",() -> new AxeItem(ModTiers.Steel, 4, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> Steel_shovel = Items.register(
                "steel_shovel",() -> new ShovelItem(ModTiers.Steel, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> Steel_hoe = Items.register(
                "steel_hoe",() -> new HoeItem(ModTiers.Steel, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> Steel_helmet= Items.register(
            "steel_helmet", () -> new ArmorItem(ModArmorMaterials.Steel, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> Steel_chestplate= Items.register(
            "steel_chestplate", () -> new ArmorItem(ModArmorMaterials.Steel, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> Steel_leggings= Items.register(
            "steel_leggings", () -> new ArmorItem(ModArmorMaterials.Steel, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> Steel_boots= Items.register(
            "steel_boots", () -> new ArmorItem(ModArmorMaterials.Steel, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Silver
        public static final RegistryObject<Item> Silver_sword = Items.register(
                "silver_sword",() -> new SwordItem(ModTiers.Silver, 3, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Silver_pickaxe = Items.register(
            "silver_pickaxe",() -> new PickaxeItem(ModTiers.Silver, -2, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> Silver_axe = Items.register(
            "silver_axe",() -> new SwordItem(ModTiers.Silver, 6, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Silver_shovel = Items.register(
            "silver_shovel",() -> new ShovelItem(ModTiers.Silver, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Silver_hoe = Items.register(
            "silver_hoe",() -> new HoeItem(ModTiers.Silver, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Silver_helmet= Items.register(
            "silver_helmet", () -> new ModArmorEffects(ModArmorMaterials.Silver, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> Silver_chestplate= Items.register(
            "silver_chestplate", () -> new ArmorItem(ModArmorMaterials.Silver, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> Silver_leggings= Items.register(
            "silver_leggings", () -> new ArmorItem(ModArmorMaterials.Silver, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> Silver_boots= Items.register(
            "silver_boots", () -> new ArmorItem(ModArmorMaterials.Silver, ArmorItem.Type.BOOTS, new Item.Properties()));

         //Reinforced Diamond
        public static final RegistryObject<Item> Reinforced_diamond_sword = Items.register(
            "reinforced_diamond_sword",() -> new SwordItem(ModTiers.Reinforced_diamond, 3, -2.4F, new Item.Properties()));
         public static final RegistryObject<Item> Reinforced_diamond_pickaxe = Items.register(
            "reinforced_diamond_pickaxe",() -> new PickaxeItem(ModTiers.Reinforced_diamond, -2, -2.8F, new Item.Properties()));
         public static final RegistryObject<Item> Reinforced_diamond_axe = Items.register(
            "reinforced_diamond_axe",() -> new SwordItem(ModTiers.Reinforced_diamond, 6, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Reinforced_diamond_shovel = Items.register(
            "reinforced_diamond_shovel",() -> new ShovelItem(ModTiers.Reinforced_diamond, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Reinforced_diamond_hoe = Items.register(
            "reinforced_diamond_hoe",() -> new HoeItem(ModTiers.Reinforced_diamond, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Reinforced_diamond_helmet= Items.register(
            "reinforced_diamond_helmet", () -> new ModArmorEffects(ModArmorMaterials.Reinforced_diamond, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> Reinforced_diamond_chestplate= Items.register(
            "reinforced_diamond_chestplate", () -> new ArmorItem(ModArmorMaterials.Reinforced_diamond, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> Reinforced_diamond_leggings= Items.register(
            "reinforced_diamond_leggings", () -> new ArmorItem(ModArmorMaterials.Reinforced_diamond, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> Reinforced_diamond_boots= Items.register(
            "reinforced_diamond_boots", () -> new ArmorItem(ModArmorMaterials.Reinforced_diamond, ArmorItem.Type.BOOTS, new Item.Properties()));
    //Food
        //Fruit
    public static final RegistryObject<Item> Orange = Items.register(
            "orange",() -> new Item(new Item.Properties().food(ModFoods.Orange)));
    public static final RegistryObject<Item> Lemon = Items.register(
            "lemon",() -> new Item(new Item.Properties().food(ModFoods.Lemon)));
    public static final RegistryObject<Item> Green_apple = Items.register(
            "green_apple",() -> new Item(new Item.Properties().food(ModFoods.Green_apple)));
//    public static final RegistryObject<Item> Banana = Items.register(
//            "banana",() -> new Item(new Item.Properties().stacksTo(64)
//                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(2).build()))
//    );
        //Vegetables
    public static final RegistryObject<Item> Rice = Items.register(
            "rice_grains", () -> new Item((new Item.Properties().food(ModFoods.Rice))));
        //Cooked recipes
    public static final RegistryObject<Item> Rice_bowl = Items.register(
            "rice_bowl",() -> new Item(new Item.Properties().food(ModFoods.Rice_bawl)));

    //Final register
    public static void Register(IEventBus eventBus){
        Items.register(eventBus);
    }
}

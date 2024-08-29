package com.MarMar.Enhanced_Minecraft.item;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.Util.ModTiers;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.item.custom.MateItem;
import com.MarMar.Enhanced_Minecraft.item.custom.PolisherItem;
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
        public static final RegistryObject<Item> Raw_diamond = Items.register(
                "raw_diamond", () -> new Item(new Item.Properties()));
        //melted
        public static final RegistryObject<Item> Copper_nugget = Items.register(
                "copper_nugget", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Tin_ingot = Items.register(
                "tin_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Tin_nugget = Items.register(
                "tin_nugget", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Bronze_ingot = Items.register(
                "bronze_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Bronze_nugget = Items.register(
                "bronze_nugget", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Steel_ingot = Items.register(
                "steel_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Silver_ingot = Items.register(
                "silver_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Silver_nugget = Items.register(
                "silver_nugget", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Rose_gold_ingot = Items.register(
                "rose_gold_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Rose_gold_nugget = Items.register(
                "rose_gold_nugget", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Green_gold_ingot = Items.register(
                "green_gold_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Green_gold_nugget = Items.register(
                "green_gold_nugget", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Rubi = Items.register(
                "rubi", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Saphire = Items.register(
                "saphire", () -> new Item(new Item.Properties()));

    //Dust
    public static final RegistryObject<Item> Cobalt_dust = Items.register(
            "cobalt_dust", () -> new Item(new Item.Properties()));

    //Smithing template
    public static final RegistryObject<Item> reinforcing_upgrade_smithing_template = Items.register(
            "reinforcing_upgrade_smithing_template", () -> new Item(new Item.Properties()));

    //Weapons, tools and armors
        //Stone
        public static final RegistryObject<Item> Stone_polisher = Items.register(
                "stone_polisher",() -> new PolisherItem(Tiers.STONE,0, new Item.Properties()));

        //Gold
        public static final RegistryObject<Item> Gold_polisher = Items.register(
                "gold_polisher",() -> new PolisherItem(Tiers.GOLD,0, new Item.Properties()));

        //Silver
        public static final RegistryObject<Item> Silver_sword = Items.register(
                "silver_sword",() -> new SwordItem(ModTiers.Silver, 1, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Silver_pickaxe = Items.register(
                "silver_pickaxe",() -> new PickaxeItem(ModTiers.Silver, -2, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> Silver_axe = Items.register(
                "silver_axe",() -> new SwordItem(ModTiers.Silver, 6, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Silver_shovel = Items.register(
                "silver_shovel",() -> new ShovelItem(ModTiers.Silver, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Silver_hoe = Items.register(
                "silver_hoe",() -> new HoeItem(ModTiers.Silver, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Silver_polisher = Items.register(
                "silver_polisher",() -> new PolisherItem(ModTiers.Silver,0, new Item.Properties()));
        public static final RegistryObject<Item> Silver_helmet= Items.register(
                "silver_helmet", () -> new ModArmorEffects(ModArmorMaterials.Silver, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> Silver_chestplate= Items.register(
                "silver_chestplate", () -> new ArmorItem(ModArmorMaterials.Silver, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> Silver_leggings= Items.register(
                "silver_leggings", () -> new ArmorItem(ModArmorMaterials.Silver, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> Silver_boots= Items.register(
                "silver_boots", () -> new ArmorItem(ModArmorMaterials.Silver, ArmorItem.Type.BOOTS, new Item.Properties()));

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
        public static final RegistryObject<Item> Bronze_polisher = Items.register(
                "bronze_polisher",() -> new PolisherItem(ModTiers.Bronze,0, new Item.Properties()));
         public static final RegistryObject<Item> Bronze_helmet= Items.register(
                "bronze_helmet", () -> new ArmorItem(ModArmorMaterials.Bronze, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> Bronze_chestplate= Items.register(
                "bronze_chestplate", () -> new ArmorItem(ModArmorMaterials.Bronze, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> Bronze_leggings= Items.register(
                "bronze_leggings", () -> new ArmorItem(ModArmorMaterials.Bronze, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> Bronze_boots= Items.register(
                "bronze_boots", () -> new ArmorItem(ModArmorMaterials.Bronze, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Rose Gold
        public static final RegistryObject<Item> Rose_golden_sword = Items.register(
                "rose_golden_sword",() -> new SwordItem(ModTiers.Rose_gold, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Rose_golden_pickaxe = Items.register(
                "rose_golden_pickaxe",() -> new PickaxeItem(ModTiers.Rose_gold, -2, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> Rose_golden_axe = Items.register(
                "rose_golden_axe",() -> new AxeItem(ModTiers.Rose_gold, 6, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Rose_golden_shovel = Items.register(
                "rose_golden_shovel",() -> new ShovelItem(ModTiers.Rose_gold, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Rose_golden_hoe = Items.register(
                "rose_golden_hoe",() -> new HoeItem(ModTiers.Rose_gold, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Rose_golden_polisher = Items.register(
                "rose_golden_polisher", () -> new PolisherItem(ModTiers.Rose_gold, 0, new Item.Properties()));
        public static final RegistryObject<Item> Rose_golden_helmet= Items.register(
                "rose_golden_helmet", () -> new ModArmorEffects(ModArmorMaterials.Rose_gold, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> Rose_golden_chestplate= Items.register(
                "rose_golden_chestplate", () -> new ArmorItem(ModArmorMaterials.Rose_gold, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> Rose_golden_leggings= Items.register(
                "rose_golden_leggings", () -> new ArmorItem(ModArmorMaterials.Rose_gold, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> Rose_golden_boots= Items.register(
                "rose_golden_boots", () -> new ArmorItem(ModArmorMaterials.Rose_gold, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Iron
        public static final RegistryObject<Item> Iron_polisher = Items.register(
                "iron_polisher",() -> new PolisherItem(Tiers.IRON,0, new Item.Properties()));

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
        public static final RegistryObject<Item> Steel_polisher = Items.register(
            "steel_polisher",() -> new PolisherItem(ModTiers.Steel,0, new Item.Properties()));
        public static final RegistryObject<Item> Steel_helmet= Items.register(
            "steel_helmet", () -> new ArmorItem(ModArmorMaterials.Steel, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> Steel_chestplate= Items.register(
            "steel_chestplate", () -> new ArmorItem(ModArmorMaterials.Steel, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> Steel_leggings= Items.register(
            "steel_leggings", () -> new ArmorItem(ModArmorMaterials.Steel, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> Steel_boots= Items.register(
            "steel_boots", () -> new ArmorItem(ModArmorMaterials.Steel, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Green Gold
        public static final RegistryObject<Item> Green_golden_sword = Items.register(
                "green_golden_sword",() -> new SwordItem(ModTiers.Green_gold, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Green_golden_pickaxe = Items.register(
                "green_golden_pickaxe",() -> new PickaxeItem(ModTiers.Green_gold, -2, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> Green_golden_axe = Items.register(
                "green_golden_axe",() -> new AxeItem(ModTiers.Green_gold, 6, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Green_golden_shovel = Items.register(
                "green_golden_shovel",() -> new ShovelItem(ModTiers.Green_gold, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Green_golden_hoe = Items.register(
                "green_golden_hoe",() -> new HoeItem(ModTiers.Green_gold, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> Green_golden_polisher = Items.register(
                "green_golden_polisher", () -> new PolisherItem(ModTiers.Green_gold, 0, new Item.Properties()));
        public static final RegistryObject<Item> Green_golden_helmet= Items.register(
                "green_golden_helmet", () -> new ModArmorEffects(ModArmorMaterials.Green_gold, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> Green_golden_chestplate= Items.register(
                "green_golden_chestplate", () -> new ArmorItem(ModArmorMaterials.Green_gold, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> Green_golden_leggings= Items.register(
                "green_golden_leggings", () -> new ArmorItem(ModArmorMaterials.Green_gold, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> Green_golden_boots= Items.register(
                "green_golden_boots", () -> new ArmorItem(ModArmorMaterials.Green_gold, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Diamond
        public static final RegistryObject<Item> Diamond_polisher = Items.register(
                "diamond_polisher",() -> new PolisherItem(Tiers.DIAMOND,0, new Item.Properties()));

        //Netherite
        public static final RegistryObject<Item> Netherite_polisher = Items.register(
                "netherite_polisher",() -> new PolisherItem(Tiers.NETHERITE,0, new Item.Properties()));

    //Plants
    public static final RegistryObject<Item> Yerba_mate = Items.register(
            "yerba_mate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Grounded_yerba_mate = Items.register(
            "grounded_yerba_mate", () -> new Item(new Item.Properties()));

    //Food
        //Flour
        public static final RegistryObject<Item> Wheat_flour = Items.register(
                "wheat_flour",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> Pumpkin_flour = Items.register(
                "pumpkin_flour",() -> new Item(new Item.Properties()));

        //Seeds
        public static final RegistryObject<Item> Yerba_mate_seeds = Items.register(
                "yerba_mate_seeds",() -> new ItemNameBlockItem(ModBlocks.Yerba_mate_crop.get(), new Item.Properties()));
        public static final RegistryObject<Item> Zapallo_seeds = Items.register(
                "zapallo_seeds",() -> new ItemNameBlockItem(ModBlocks.Zapallo_crop.get(), new Item.Properties()));
        public static final RegistryObject<Item> Eggplant_seeds = Items.register(
                "eggplant_seeds",() -> new ItemNameBlockItem(ModBlocks.Eggplant_crop.get(), new Item.Properties()));
        public static final RegistryObject<Item> Tomato_seeds = Items.register(
                "tomato_seeds", () -> new ItemNameBlockItem(ModBlocks.Tomato_crop.get(), new Item.Properties()));
        public static final RegistryObject<Item> Corn_seeds = Items.register(
                "corn_seeds", () -> new ItemNameBlockItem(ModBlocks.Corn_crop.get(), new Item.Properties()));

        //Fruit
        public static final RegistryObject<Item> Orange = Items.register(
                "orange",() -> new Item(new Item.Properties().food(ModFoodPropieties.Orange)));
        public static final RegistryObject<Item> Lemon = Items.register(
                "lemon",() -> new Item(new Item.Properties().food(ModFoodPropieties.Lemon)));
        public static final RegistryObject<Item> Green_apple = Items.register(
                "green_apple",() -> new Item(new Item.Properties().food(ModFoodPropieties.Green_apple)));
        public static final RegistryObject<Item> Tomato = Items.register(
                "tomato",() -> new Item(new Item.Properties().food(ModFoodPropieties.Tomato)));

        //Vegetables
        public static final RegistryObject<Item> Rice = Items.register(
                "rice_grains", () -> new Item((new Item.Properties().food(ModFoodPropieties.Rice))));
        public static final RegistryObject<Item> Zapallo = Items.register(
                "zapallo", () -> new Item((new Item.Properties().food(ModFoodPropieties.Zapallo))));
        public static final RegistryObject<Item> Eggplant = Items.register(
                "eggplant", () -> new Item((new Item.Properties().food(ModFoodPropieties.Eggplant))));
        public static final RegistryObject<Item> Corn = Items.register(
                "corn", () -> new Item((new Item.Properties().food(ModFoodPropieties.Corn))));

        //Fungi
        public static final RegistryObject<Item> Yeast = Items.register(
                "yeast",() -> new Item(new Item.Properties()));

        //Cooked food
        public static final RegistryObject<Item> Rice_bowl = Items.register(
                "rice_bowl",() -> new Item(new Item.Properties().food(ModFoodPropieties.Rice_bowl)));
        public static final RegistryObject<Item> Cooked_zapallo = Items.register(
                "cooked_zapallo", () -> new Item((new Item.Properties().food(ModFoodPropieties.Cooked_zapallo))));
        public static final RegistryObject<Item> Cooked_eggplant = Items.register(
                "cooked_eggplant", () -> new Item((new Item.Properties().food(ModFoodPropieties.Cooked_eggplant))));
        public static final RegistryObject<Item> Cooked_corn = Items.register(
                "cooked_corn", () -> new Item((new Item.Properties().food(ModFoodPropieties.Cooked_corn))));
        public static final RegistryObject<Item> Empty_mate = Items.register(
                "empty_mate",() -> new Item(new Item.Properties().stacksTo(1)));
        public static final RegistryObject<Item> Mate = Items.register(
                "mate",() -> new MateItem(new Item.Properties().stacksTo(1).food(ModFoodPropieties.Mate)));

    //Final register
    public static void Register(IEventBus eventBus){
        Items.register(eventBus);
    }
}

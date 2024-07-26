package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import com.MarMar.Enhanced_Minecraft.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Enhanced_Minecraft.MOD_ID);
    }

    @Override
    protected void start() {
        //Ancient cities
        add("steel_sword_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build() }, ModItems.Steel_sword.get()));
        add("steel_helmet_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()}, ModItems.Steel_helmet.get()));
        add("steel_chestplate_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, ModItems.Steel_chestplate.get()));
        add("steel_leggings_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()}, ModItems.Steel_leggings.get()));
        add("steel_boots_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()}, ModItems.Steel_boots.get()));

        //Mineshafts
            //Bronze
            add("bronze_pickaxe_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()}, ModItems.Bronze_pickaxe.get()));
            add("bronze_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.Bronze_ingot.get()));
            add("bronze_nugget_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.70f).build()}, ModItems.Bronze_nugget.get()));

            //Tin
            add("tin_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.30f).build()}, ModItems.Tin_ingot.get()));

            //Rose gold
            add("rose_gold_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, ModItems.Rose_gold_ingot.get()));

        //Villages
        add("zapallo_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.40f).build()}, ModItems.Zapallo_seeds.get()));
        add("eggplant_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.40f).build()}, ModItems.Eggplant_seeds.get()));
        add("corn_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.40f).build()}, ModItems.Corn_seeds.get()));
        add("tomato_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.40f).build()}, ModItems.Tomato_seeds.get()));
        add("yerba_mate_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.40f).build()}, ModItems.Yerba_mate_seeds.get()));

        add("bronze_pickaxe_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, ModItems.Bronze_pickaxe.get()));
        add("bronze_ingot_from_village_toolsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.20f).build()}, ModItems.Bronze_ingot.get()));
        add("bronze_ingot_from_village_weaponsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.30f).build()}, ModItems.Bronze_ingot.get()));

        add("steel_ingot_from_village_toolsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, ModItems.Steel_ingot.get()));
        add("steel_ingot_from_village_weaponsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()}, ModItems.Steel_ingot.get()));

        //Spawners
        add("bronze_ingot_from_spawner", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.30f).build()}, ModItems.Bronze_ingot.get()));
        add("steel_ingot_from_spawner", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()}, ModItems.Steel_ingot.get()));
    }
}

package com.marmar.enhanced_playthrough.datagen;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import com.marmar.enhanced_playthrough.item.ModItems;
import com.marmar.enhanced_playthrough.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, EnhancedPlaythrough.MOD_ID);
    }

    @Override
    protected void start() {
        //Ancient cities
        add("steel_sword_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build() }, ModItems.STEEL_SWORD.get()));
        add("steel_helmet_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, ModItems.STEEL_HELMET.get()));
        add("steel_chestplate_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()}, ModItems.STEEL_CHESTPLATE.get()));
        add("steel_leggings_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, ModItems.STEEL_LEGGINGS.get()));
        add("steel_boots_from_ancient_city", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()}, ModItems.STEEL_BOOTS.get()));

        //Entities
        add("sulphur_from_blazes", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/blaze")).build(),
                LootItemRandomChanceCondition.randomChance(0.7f).build() }, ModItems.SULFUR.get()));
        add("sulphur_from_witches", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/witch")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build() }, ModItems.SULFUR.get()));

        //Mineshafts
            //Bronze
            add("bronze_pickaxe_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, ModItems.BRONZE_PICKAXE.get()));
            add("bronze_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.45f).build()}, ModItems.BRONZE_INGOT.get()));
            add("bronze_nugget_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.6f).build()}, ModItems.BRONZE_NUGGET.get()));

            //Tin
            add("tin_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.6f).build()}, ModItems.TIN_INGOT.get()));

            //Zinc
            add("zinc_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                    new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                    LootItemRandomChanceCondition.randomChance(0.6f).build()}, ModItems.ZINC_INGOT.get()));

            //Rose gold
            add("rose_gold_ingot_from_mineshaft", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, ModItems.ROSE_GOLD_INGOT.get()));

        //Villages
        add("zapallo_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build()}, ModItems.ZAPALLO_SEEDS.get()));
        add("eggplant_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build()}, ModItems.EGGPLANT_SEEDS.get()));
        add("corn_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build()}, ModItems.CORN_SEEDS.get()));
        add("tomato_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build()}, ModItems.TOMATO_SEEDS.get()));
        add("yerba_mate_seeds_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build()}, ModItems.YERBA_MATE_SEEDS.get()));

        add("bronze_pickaxe_from_villages", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, ModItems.BRONZE_PICKAXE.get()));
        add("bronze_ingot_from_village_toolsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, ModItems.BRONZE_INGOT.get()));
        add("bronze_ingot_from_village_weaponsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()}, ModItems.BRONZE_INGOT.get()));

        add("steel_ingot_from_village_toolsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, ModItems.STEEL_INGOT.get()));
        add("steel_ingot_from_village_weaponsmith", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, ModItems.STEEL_INGOT.get()));

        //Spawners
        add("bronze_ingot_from_spawner", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()}, ModItems.BRONZE_INGOT.get()));
        add("brass_ingot_from_spawner", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.45f).build()}, ModItems.BRASS_INGOT.get()));
        add("steel_ingot_from_spawner", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, ModItems.STEEL_INGOT.get()));

        //Nether fortress
        add("brass_ingot_from_nether_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.6f).build()}, ModItems.BRASS_INGOT.get()));
        add("bronzium_ingot_from_nether_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()}, ModItems.BRONZIUM_INGOT.get()));
        add("bronzium_smithing_upgrade_template_from_nether_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE.get()));
        add("bronzium_sword_from_nether_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build()}, ModItems.BRONZIUM_SWORD.get()));
    }
}

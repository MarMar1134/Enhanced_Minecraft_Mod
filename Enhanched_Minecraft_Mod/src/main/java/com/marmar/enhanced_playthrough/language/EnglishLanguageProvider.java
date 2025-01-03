package com.marmar.enhanced_playthrough.language;

import com.marmar.enhanced_playthrough.block.ModBlocks;
import com.marmar.enhanced_playthrough.enchantment.ModEnchantments;
import com.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.data.PackOutput;

public class EnglishLanguageProvider extends AbstractModLanguageProvider {
    public EnglishLanguageProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        //Creative tabs
        addCreativeTab("weapons", "Combat");
        addCreativeTab("tools", "Tools");
        addCreativeTab("minerals", "Ores and minerals");
        addCreativeTab("jewelery", "Jewelery");
        addCreativeTab("utility", "Utility");
        addCreativeTab("fruits", "Fruits and vegetables");
        addCreativeTab("saplings", "Seeds and saplings");
        addCreativeTab("woodtypes", "Wood");
        addCreativeTab("blocks", "Blocks");

        //JEI
        addJeiCategory("adobe_furnace", "Basic smelting");
        addJeiCategory("soul_furnace", "Soul basic smelting");
        addJeiCategory("adobe_alloying_furnace", "Alloying");
        addJeiCategory("super_alloying_furnace", "Blast alloying");
        addJeiCategory("gem_polisher", "Gem polishing");
        addJeiCategory("grinder", "Grinding");

        //GUI elements
        addGuiElements("gem_polisher_screen", "Uses");

        //Descriptions
        addDescription("polisher_item","Used on the Gem polisher as fuel");
        addDescription("silver_armor", "When full equipped: gives Haste to the player");
        addDescription("rose_gold_armor", "When full equipped: gives Haste to the player");
        addDescription("bronzium_armor", "When full equipped: gives Fire Resistance to the player");
        addDescription("green_gold_armor", "When full equipped: gives Haste II to the player");

        //Advancements
            //Survival
            addAdvancementTitle("survival", "root", "Enhanced Playthrough");
            addAdvancementTitle("survival", "unity_makes_strength", "Unity makes strength");
            addAdvancementTitle("survival", "mighty_bronze", "Mighty bronze");
            addAdvancementTitle("survival", "steel_isnt_enough", "Steel isn´t enough");

            addAdvancementDesc("survival", "root", "You started a new journey on this fantastic world, welcome!");
            addAdvancementDesc("survival", "unity_makes_strength", "Craft an alloy furnace");
            addAdvancementDesc("survival", "mighty_bronze", "Get a bronze pickaxe");
            addAdvancementDesc("survival", "steel_isnt_enough", "Use your alloy furnace to get some steel");

            //Gems
            addAdvancementTitle("gems", "root", "The colors of the world");
            addAdvancementTitle("gems", "polish_emerald", "Greedy green");
            addAdvancementTitle("gems", "polish_sapphire", "Blue storm");
            addAdvancementTitle("gems", "polish_rubi", "Angry, but not a bird");
            addAdvancementTitle("gems", "polish_garnet", "The color of my heart");
            addAdvancementTitle("gems", "polish_diamond", "Are you here, Lucy?");
            addAdvancementTitle("gems", "get_all_gems", "Chaos everywhere");

            addAdvancementDesc("gems", "root", "The world is full of colors, and the gems are a great representation of that");
            addAdvancementDesc("gems", "polish_emerald", "Get some emeralds and take care of hers");
            addAdvancementDesc("gems", "polish_sapphire", "Get some sapphires, you should look close to the sea");
            addAdvancementDesc("gems", "polish_rubi", "Get some rubies, be careful with the pigs");
            addAdvancementDesc("gems", "polish_garnet", "Get some garnets and show your passion");
            addAdvancementDesc("gems", "polish_diamond", "Get some diamonds and look to the sky");
            addAdvancementDesc("gems", "get_all_gems", "Collect all the gems and become the lord of chaos");

        //Blocks
            //Polished stone
            addBlock(ModBlocks.POLISHED_STONE, "Polished stone");
            addBlock(ModBlocks.POLISHED_STONE_SLAB, "Polished stone slab");
            addBlock(ModBlocks.POLISHED_STONE_STAIRS, "Polished stone stairs");
            addBlock(ModBlocks.POLISHED_STONE_WALL, "Polished stone wall");

            //Cobbled limestone
            addBlock(ModBlocks.COBBLED_LIMESTONE, "Cobbled limestone");
            addBlock(ModBlocks.COBBLED_LIMESTONE_SLAB, "Cobbled limestone slab");
            addBlock(ModBlocks.COBBLED_LIMESTONE_STAIRS, "Cobbled limestone stairs");
            addBlock(ModBlocks.COBBLED_LIMESTONE_WALL, "Cobbled limestone wall");

            //Limestone
            addBlock(ModBlocks.LIMESTONE, "Limestone");
            addBlock(ModBlocks.LIMESTONE_SLAB, "Limestone slab");
            addBlock(ModBlocks.LIMESTONE_STAIRS, "Limestone stairs");

            //Polished limestone
            addBlock(ModBlocks.POLISHED_LIMESTONE, "Polished limestone");
            addBlock(ModBlocks.POLISHED_LIMESTONE_SLAB, "Polished limestone slab");
            addBlock(ModBlocks.POLISHED_LIMESTONE_STAIRS, "Polished limestone stairs");
            addBlock(ModBlocks.POLISHED_LIMESTONE_WALL, "Polished limestone wall");

            //Limestone bricks
            addBlock(ModBlocks.LIMESTONE_BRICKS, "Limestone bricks");
            addBlock(ModBlocks.LIMESTONE_BRICK_SLAB, "Limestone bricks slab");
            addBlock(ModBlocks.LIMESTONE_BRICK_STAIRS, "Limestone bricks stairs");
            addBlock(ModBlocks.LIMESTONE_BRICK_WALL, "Limestone bricks wall");

            //Soul
            addBlock(ModBlocks.SOUL_MUD, "Soul mud");
            addBlock(ModBlocks.SOUL_MUD_BRICKS, "Soul mud bricks");
            addBlock(ModBlocks.SOUL_MUD_BRICK_SLAB, "Soul mud brick slab");
            addBlock(ModBlocks.SOUL_MUD_BRICK_STAIRS, "Soul mud brick stairs");
            addBlock(ModBlocks.SOUL_MUD_BRICK_WALL, "Soul mud brick wall");

            //Ores
            addBlock(ModBlocks.TIN_ORE, "Tin ore");
            addBlock(ModBlocks.DEEPSLATE_TIN_ORE, "Deepslate tin ore");
            addBlock(ModBlocks.ZINC_ORE, "Zinc ore");
            addBlock(ModBlocks.DEEPSLATE_ZINC_ORE, "Deepslate zinc ore");
            addBlock(ModBlocks.NETHER_ZINC_ORE, "Nether zinc ore");
            addBlock(ModBlocks.NETHER_COPPER_ORE, "Nether copper ore");
            addBlock(ModBlocks.SULFUR_ORE, "Sulfur ore");
            addBlock(ModBlocks.DEEPSLATE_SULFUR_ORE, "Deepslate sulfur ore");
            addBlock(ModBlocks.NETHER_SULFUR_ORE, "Nether sulfur ore");
            addBlock(ModBlocks.SILVER_ORE, "Silver ore");
            addBlock(ModBlocks.DEEPSLATE_SILVER_ORE, "Deepslate silver ore");
            addBlock(ModBlocks.SAPPHIRE_ORE, "Sapphire ore");
            addBlock(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, "Deepslate sapphire ore");
            addBlock(ModBlocks.RUBI_ORE, "Rubi ore");
            addBlock(ModBlocks.DEEPSLATE_RUBI_ORE, "Deepslate rubi ore");
            addBlock(ModBlocks.NETHER_GARNET_ORE, "Nether garnet ore");

            //Ore blocks
            addBlock(ModBlocks.TIN_BLOCK, "Block of tin");
            addBlock(ModBlocks.ZINC_BLOCK, "Block of zinc");
            addBlock(ModBlocks.SILVER_BLOCK, "Block of silver");
            addBlock(ModBlocks.BRASS_BLOCK, "Block of brass");
            addBlock(ModBlocks.BRONZE_BLOCK, "Block of bronze");
            addBlock(ModBlocks.ROSE_GOLD_BLOCK, "Block of rose gold");
            addBlock(ModBlocks.BRONZIUM_BLOCK, "Block of bronzium");
            addBlock(ModBlocks.GREEN_GOLD_BLOCK, "Block of green gold");
            addBlock(ModBlocks.STEEL_BLOCK, "Block of steel");

            //Wood
                //Apple
                addBlock(ModBlocks.APPLE_SAPLING, "Apple sapling");
                addBlock(ModBlocks.APPLE_LEAVES, "Apple leaves");
                addBlock(ModBlocks.APPLE_LOG, "Apple log");
                addBlock(ModBlocks.STRIPPED_APPLE_LOG, "Stripped apple log");
                addBlock(ModBlocks.APPLE_WOOD, "Apple wood");
                addBlock(ModBlocks.STRIPPED_APPLE_WOOD, "Stripped apple wood");
                addBlock(ModBlocks.APPLE_PLANKS, "Apple planks");
                addBlock(ModBlocks.APPLE_SLAB, "Apple slab");
                addBlock(ModBlocks.APPLE_STAIRS, "Apple stairs");
                addBlock(ModBlocks.APPLE_FENCE, "Apple fence");
                addBlock(ModBlocks.APPLE_FENCEGATE, "Apple fence gate");
                addBlock(ModBlocks.APPLE_DOOR, "Apple door");
                addBlock(ModBlocks.APPLE_TRAPDOOR, "Apple trapdoor");
                addBlock(ModBlocks.APPLE_BUTTON, "Apple button");
                addBlock(ModBlocks.APPLE_PRESSURE_PLATE, "Apple pressure plate");

                //Green apple
                addBlock(ModBlocks.GREEN_APPLE_SAPLING, "Green apple sapling");
                addBlock(ModBlocks.GREEN_APPLE_LEAVES, "Green apple leaves");

                //Walnut
                addBlock(ModBlocks.WALNUT_SAPLING, "Walnut sapling");
                addBlock(ModBlocks.WALNUT_LEAVES, "Walnut leaves");
                addBlock(ModBlocks.WALNUT_LOG, "Walnut log");
                addBlock(ModBlocks.STRIPPED_WALNUT_LOG, "Stripped walnut log");
                addBlock(ModBlocks.WALNUT_WOOD, "Walnut wood");
                addBlock(ModBlocks.STRIPPED_WALNUT_WOOD, "Stripped walnut wood");
                addBlock(ModBlocks.WALNUT_PLANKS, "Walnut planks");
                addBlock(ModBlocks.WALNUT_SLAB, "Walnut slab");
                addBlock(ModBlocks.WALNUT_STAIRS, "Walnut stairs");
                addBlock(ModBlocks.WALNUT_FENCE, "Walnut fence");
                addBlock(ModBlocks.WALNUT_FENCEGATE, "Walnut fence gate");
                addBlock(ModBlocks.WALNUT_DOOR, "Walnut door");
                addBlock(ModBlocks.WALNUT_TRAPDOOR, "Walnut trapdoor");
                addBlock(ModBlocks.WALNUT_BUTTON, "Walnut button");
                addBlock(ModBlocks.WALNUT_PRESSURE_PLATE, "Walnut pressure plate");

            //Block entities
            addBlock(ModBlocks.ADOBE_FURNACE, "Mud furnace");
            addBlock(ModBlocks.SOUL_FURNACE, "Soul mud furnace");
            addBlock(ModBlocks.ADOBE_ALLOYING_FURNACE, "Bricks alloy furnace");
            addBlock(ModBlocks.SOUL_ALLOY_FURNACE, "Soul bricks alloy furnace");
            addBlock(ModBlocks.SUPER_ALLOYING_FURNACE, "Blast alloy furnace");
            addBlock(ModBlocks.GEM_POLISHER, "Gem polisher");
            addBlock(ModBlocks.GRINDER, "Grinder");

        //Items
            //Raw ores
            addItem(ModItems.RAW_TIN, "Raw tin");
            addItem(ModItems.RAW_ZINC, "Raw zinc");
            addItem(ModItems.RAW_SILVER, "Raw silver");
            addItem(ModItems.RAW_EMERALD, "Unpolished emerald");
            addItem(ModItems.RAW_SAPPHIRE, "Unpolished sapphire");
            addItem(ModItems.RAW_RUBI, "Unpolished rubi");
            addItem(ModItems.RAW_GARNET, "Unpolished garnet");
            addItem(ModItems.RAW_DIAMOND, "Unpolished diamond");

            //Materials and melted ores
            addItem(ModItems.TIN_INGOT, "Tin ingot");
            addItem(ModItems.TIN_NUGGET, "Tin nugget");
            addItem(ModItems.ZINC_INGOT, "Zinc ingot");
            addItem(ModItems.ZINC_NUGGET, "Zinc nugget");
            addItem(ModItems.SULFUR, "Sulfur");
            addItem(ModItems.SILVER_INGOT, "Silver ingot");
            addItem(ModItems.SILVER_NUGGET, "Silver nugget");
            addItem(ModItems.BRASS_INGOT, "Brass ingot");
            addItem(ModItems.BRASS_NUGGET, "Brass nugget");
            addItem(ModItems.BRONZE_INGOT, "Bronze ingot");
            addItem(ModItems.BRONZE_NUGGET, "Bronze nugget");
            addItem(ModItems.ROSE_GOLD_INGOT, "Rose gold ingot");
            addItem(ModItems.ROSE_GOLD_NUGGET, "Rose gold nugget");
            addItem(ModItems.BRONZIUM_INGOT, "Bronzium ingot");
            addItem(ModItems.BRONZIUM_NUGGET, "Bronzium nugget");
            addItem(ModItems.GREEN_GOLD_INGOT, "Green gold ingot");
            addItem(ModItems.GREEN_GOLD_NUGGET, "Green gold nugget");
            addItem(ModItems.STEEL_INGOT, "Steel ingot");
            addItem(ModItems.MUD_BRICK, "Mud brick");

            //Silver equipment
            addItem(ModItems.SILVER_SWORD, "Silver sword");
            addItem(ModItems.SILVER_PICKAXE, "Silver pickaxe");
            addItem(ModItems.SILVER_AXE, "Silver axe");
            addItem(ModItems.SILVER_SHOVEL, "Silver shovel");
            addItem(ModItems.SILVER_HOE, "Silver hoe");
            addItem(ModItems.SILVER_POLISHER, "Silver polisher");
            addItem(ModItems.SILVER_HELMET, "Silver helmet");
            addItem(ModItems.SILVER_CHESTPLATE, "Silver chestplate");
            addItem(ModItems.SILVER_LEGGINGS, "Silver leggings");
            addItem(ModItems.SILVER_BOOTS, "Silver boots");

            //Gold equipment
            addItem(ModItems.GOLD_POLISHER, "Golden polisher");

            //Stone equipment
            addItem(ModItems.STONE_POLISHER, "Stone polisher");

            //Brass equipment
            addItem(ModItems.BRASS_SWORD, "Brass sword");
            addItem(ModItems.BRASS_PICKAXE, "Brass pickaxe");
            addItem(ModItems.BRASS_AXE, "Brass axe");
            addItem(ModItems.BRASS_SHOVEL, "Brass shovel");
            addItem(ModItems.BRASS_HOE, "Brass hoe");
            addItem(ModItems.BRASS_POLISHER, "Brass polisher");
            addItem(ModItems.BRASS_HELMET, "Brass helmet");
            addItem(ModItems.BRASS_CHESTPLATE, "Brass chestplate");
            addItem(ModItems.BRASS_LEGGINGS, "Brass leggings");
            addItem(ModItems.BRASS_BOOTS, "Brass boots");

            //Bronze equipment
            addItem(ModItems.BRONZE_SWORD, "Bronze sword");
            addItem(ModItems.BRONZE_PICKAXE, "Bronze pickaxe");
            addItem(ModItems.BRONZE_AXE, "Bronze axe");
            addItem(ModItems.BRONZE_SHOVEL, "Bronze shovel");
            addItem(ModItems.BRONZE_HOE, "Bronze hoe");
            addItem(ModItems.BRONZE_POLISHER, "Bronze polisher");
            addItem(ModItems.BRONZE_HELMET, "Bronze helmet");
            addItem(ModItems.BRONZE_CHESTPLATE, "Bronze chestplate");
            addItem(ModItems.BRONZE_LEGGINGS, "Bronze leggings");
            addItem(ModItems.BRONZE_BOOTS, "Bronze boots");

            //Rose golden equipment
            addItem(ModItems.ROSE_GOLDEN_SWORD, "Rose golden sword");
            addItem(ModItems.ROSE_GOLDEN_PICKAXE, "Rose golden pickaxe");
            addItem(ModItems.ROSE_GOLDEN_AXE, "Rose golden axe");
            addItem(ModItems.ROSE_GOLDEN_SHOVEL, "Rose golden shovel");
            addItem(ModItems.ROSE_GOLDEN_HOE, "Rose golden hoe");
            addItem(ModItems.ROSE_GOLDEN_POLISHER, "Rose golden polisher");
            addItem(ModItems.ROSE_GOLDEN_HELMET, "Rose golden helmet");
            addItem(ModItems.ROSE_GOLDEN_CHESTPLATE, "Rose golden chestplate");
            addItem(ModItems.ROSE_GOLDEN_LEGGINGS, "Rose golden leggings");
            addItem(ModItems.ROSE_GOLDEN_BOOTS, "Rose golden boots");

            //Bronzium equipment
            addItem(ModItems.BRONZIUM_SWORD, "Bronzium sword");
            addItem(ModItems.BRONZIUM_PICKAXE, "Bronzium pickaxe");
            addItem(ModItems.BRONZIUM_AXE, "Bronzium axe");
            addItem(ModItems.BRONZIUM_SHOVEL, "Bronzium shovel");
            addItem(ModItems.BRONZIUM_HOE, "Bronzium hoe");
            addItem(ModItems.BRONZIUM_POLISHER, "Bronzium polisher");
            addItem(ModItems.BRONZIUM_HELMET, "Bronzium helmet");
            addItem(ModItems.BRONZIUM_CHESTPLATE, "Bronzium chestplate");
            addItem(ModItems.BRONZIUM_LEGGINGS, "Bronzium leggings");
            addItem(ModItems.BRONZIUM_BOOTS, "Bronzium boots");

            //Iron equipment
            addItem(ModItems.IRON_POLISHER, "Iron polisher");

            //Green golden equipment
            addItem(ModItems.GREEN_GOLDEN_SWORD, "Green golden sword");
            addItem(ModItems.GREEN_GOLDEN_PICKAXE, "Green golden pickaxe");
            addItem(ModItems.GREEN_GOLDEN_AXE, "Green golden axe");
            addItem(ModItems.GREEN_GOLDEN_SHOVEL, "Green golden shovel");
            addItem(ModItems.GREEN_GOLDEN_HOE, "Green golden hoe");
            addItem(ModItems.GREEN_GOLDEN_POLISHER, "Green golden polisher");
            addItem(ModItems.GREEN_GOLDEN_HELMET, "Green golden helmet");
            addItem(ModItems.GREEN_GOLDEN_CHESTPLATE, "Green golden chestplate");
            addItem(ModItems.GREEN_GOLDEN_LEGGINGS, "Green golden leggings");
            addItem(ModItems.GREEN_GOLDEN_BOOTS, "Green golden boots");

            //Steel equipment
            addItem(ModItems.STEEL_SWORD, "Steel sword");
            addItem(ModItems.STEEL_PICKAXE, "Steel pickaxe");
            addItem(ModItems.STEEL_AXE, "Steel axe");
            addItem(ModItems.STEEL_SHOVEL, "Steel shovel");
            addItem(ModItems.STEEL_HOE, "Steel hoe");
            addItem(ModItems.STEEL_POLISHER, "Steel polisher");
            addItem(ModItems.STEEL_HELMET, "Steel helmet");
            addItem(ModItems.STEEL_CHESTPLATE, "Steel chestplate");
            addItem(ModItems.STEEL_LEGGINGS, "Steel leggings");
            addItem(ModItems.STEEL_BOOTS, "Steel boots");

            //Diamond equipment
            addItem(ModItems.DIAMOND_POLISHER, "Diamond polisher");

            //Netherite equipment
            addItem(ModItems.NETHERITE_POLISHER, "Netherite polisher");

            //Plants
            addItem(ModItems.YERBA_MATE, "Yerba mate");
            addItem(ModItems.GROUNDED_YERBA_MATE, "Ground yerba mate");

            //Food
                //Flour
                addItem(ModItems.WHEAT_FLOUR, "Wheat flour");
                addItem(ModItems.PUMPKIN_FLOUR, "Pumpkin flour");

                //Seeds
                addItem(ModItems.YERBA_MATE_SEEDS, "Yerba mate seeds");
                addItem(ModItems.ZAPALLO_SEEDS, "Anco pumpkin seeds");
                addItem(ModItems.TOMATO_SEEDS, "Tomato seeds");
                addItem(ModItems.CORN_SEEDS, "Corn seeds");
                addItem(ModItems.EGGPLANT_SEEDS, "Eggplant seeds");

                //Fruits
                addItem(ModItems.TOMATO, "Tomato");
                addItem(ModItems.LEMON, "Lemon");
                addItem(ModItems.ORANGE, "Orange");
                addItem(ModItems.WALNUT, "Walnut");
                addItem(ModItems.PEELED_WALNUT, "Peeled walnut");
                addItem(ModItems.GREEN_APPLE, "Green apple");

                //Vegetables
                addItem(ModItems.CORN, "Corn");
                addItem(ModItems.ZAPALLO, "Anco pumpkin");
                addItem(ModItems.EGGPLANT, "Eggplant");
                addItem(ModItems.RICE_GRAINS, "Rice grains");

                //Cooked
                addItem(ModItems.COOKED_CORN, "Cooked corn");
                addItem(ModItems.COOKED_ZAPALLO, "Cooked anco pumpkin");
                addItem(ModItems.COOKED_EGGPLANT, "Cooked eggplant");

                //Others
                addItem(ModItems.EMPTY_MATE, "Empty mate");
                addItem(ModItems.MATE, "Mate");
                addItem(ModItems.YEAST, "Yeast");
                addItem(ModItems.RICE_BOWL, "Rice bowl");

            //Smithing templates
            addItem(ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE, "Bronzium smithing upgrade template");
            addSmithingTranslations("bronzium", "Bronzium upgrade", "Bronze equipment, Brass equipment", "Brass ingot, Bronze ingot",
                    "Add a bronze or brass armor, weapon or tool", "Add a bronze ingot for brass items or a brass ingot for bronze items");

            //Enchantments
            addEnchantment(ModEnchantments.FINE_MINING, "Fine mining");
            addEnchantmentDesc("fine_mining", "Polishes gems automatically when is applied on a pickaxe");
            addEnchantment(ModEnchantments.POISON_TOUCH, "Poison touch");
            addEnchantmentDesc("poison_touch", "Gives poison to the target");
            addEnchantment(ModEnchantments.LIVING_TOUCH, "Living touch");
            addEnchantmentDesc("living_touch", "Gives Healing to the target");

        //Entities
            //Villagers
            addVillagerProfession("jeweler");
    }
}

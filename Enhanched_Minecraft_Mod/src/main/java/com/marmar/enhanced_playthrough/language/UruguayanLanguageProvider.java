package com.marmar.enhanced_playthrough.language;

import com.marmar.enhanced_playthrough.block.ModBlocks;
import com.marmar.enhanced_playthrough.enchantment.ModEnchantments;
import com.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.data.PackOutput;

public class UruguayanLanguageProvider extends AbstractModLanguageProvider{
    public UruguayanLanguageProvider(PackOutput output) {
        super(output, "es_uy");
    }

    @Override
    protected void addTranslations() {
        //Creative tabs
        addCreativeTab("weapons", "Armas y armaduras");
        addCreativeTab("tools", "Herramientas");
        addCreativeTab("minerals", "Minerales");
        addCreativeTab("jewelery", "Joyeria");
        addCreativeTab("utility", "Utiles");
        addCreativeTab("fruits", "Frutas y vegetales");
        addCreativeTab("saplings", "Semillas");
        addCreativeTab("woodtypes", "Madera");
        addCreativeTab("blocks", "Bloques varios");

        //JEI
        addJeiCategory("adobe_furnace", "Fundición básica");
        addJeiCategory("soul_furnace", "Fundición básica de almas");
        addJeiCategory("adobe_alloying_furnace", "Aleación");
        addJeiCategory("super_alloying_furnace", "Alta aleación");
        addJeiCategory("gem_polisher", "Pulido de gemas");
        addJeiCategory("grinder", "Molienda");

        //GUI elements
        addGuiElements("gem_polisher_screen", "Usos");

        //Descriptions
        addDescription("polisher_item","Utilizado en el pulidor de gemas como combustible");
        addDescription("silver_armor", "Con toda la equipación: otorga Apuro al jugador");
        addDescription("rose_gold_armor", "Con toda la equipación: otorga Apuro al jugador");
        addDescription("bronzium_armor", "Con toda la equipación: otorga Resistencia al fuego al jugador");
        addDescription("green_gold_armor", "Con toda la equipación: otorga Apuro II al jugador");

        //Advancements
        //Survival
        addAdvancementTitle("survival", "root", "Enhanced Playthrough");
        addAdvancementTitle("survival", "unity_makes_strength", "La unión hace la fuerza");
        addAdvancementTitle("survival", "mighty_bronze", "Bronceado divino");
        addAdvancementTitle("survival", "steel_isnt_enough", "No tiende a-cero");

        addAdvancementDesc("survival", "root", "Iniciaste una nueva aventura en este mundo fantástico, ¡bienvenido!");
        addAdvancementDesc("survival", "unity_makes_strength", "Crafteá un horno de aleación");
        addAdvancementDesc("survival", "mighty_bronze", "Obtené un pico de bronce");
        addAdvancementDesc("survival", "steel_isnt_enough", "Utilizá tu horno de aleación para fundir algo de acero");

        //Gems
        addAdvancementTitle("gems", "root", "Los colores del mundo");
        addAdvancementTitle("gems", "polish_emerald", "Intento de grinch");
        addAdvancementTitle("gems", "polish_sapphire", "Horizonte azulado");
        addAdvancementTitle("gems", "polish_rubi", "Pajarito enojón");
        addAdvancementTitle("gems", "polish_garnet", "El color de mi corazón");
        addAdvancementTitle("gems", "polish_diamond", "Estás acá, Lucy?");
        addAdvancementTitle("gems", "get_all_gems", "Caos por doquier");

        addAdvancementDesc("gems", "root", "Nuestro mundo reluce en colores, y las gemas representan bien eso");
        addAdvancementDesc("gems", "polish_emerald", "Consegui algunas esmeraldas y cuidalas de los, ¿quienes?");
        addAdvancementDesc("gems", "polish_sapphire", "Consegui algunos safiros y visitá un rato el mar");
        addAdvancementDesc("gems", "polish_rubi", "Consegui algunos rubies y mostrale a los cerdos quién manda");
        addAdvancementDesc("gems", "polish_garnet", "Consegui algunos granates y demostrá tu pasión");
        addAdvancementDesc("gems", "polish_diamond", "Consegui algunos diamantes para poder ver mejor el cielo");
        addAdvancementDesc("gems", "get_all_gems", "Consegui todas las gemas y convertite en el señor del caos");

        //Blocks
        //Polished stone
        addBlock(ModBlocks.POLISHED_STONE, "Piedra pulida");
        addBlock(ModBlocks.POLISHED_STONE_SLAB, "Baldosa de piedra pulida");
        addBlock(ModBlocks.POLISHED_STONE_STAIRS, "Escaleras de piedra pulida");
        addBlock(ModBlocks.POLISHED_STONE_WALL, "Pared de piedra pulida");

        //Cobbled limestone
        addBlock(ModBlocks.COBBLED_LIMESTONE, "Adoquin de piedra caliza");
        addBlock(ModBlocks.COBBLED_LIMESTONE_SLAB, "Baldosa de adoquines de piedra caliza");
        addBlock(ModBlocks.COBBLED_LIMESTONE_STAIRS, "Escaleras de adoquines de piedra caliza");
        addBlock(ModBlocks.COBBLED_LIMESTONE_WALL, "Pared de adoquines de piedra caliza");

        //Limestone
        addBlock(ModBlocks.LIMESTONE, "Piedra caliza");
        addBlock(ModBlocks.LIMESTONE_SLAB, "Baldosa de piedra caliza");
        addBlock(ModBlocks.LIMESTONE_STAIRS, "Escaleras de piedra caliza");

        //Polished limestone
        addBlock(ModBlocks.POLISHED_LIMESTONE, "Piedra caliza pulida");
        addBlock(ModBlocks.POLISHED_LIMESTONE_SLAB, "Baldosa de piedra caliza pulida");
        addBlock(ModBlocks.POLISHED_LIMESTONE_STAIRS, "Escaleras de piedra caliza pulida");
        addBlock(ModBlocks.POLISHED_LIMESTONE_WALL, "Pared de piedra caliza pulida");

        //Limestone bricks
        addBlock(ModBlocks.LIMESTONE_BRICKS, "Ladrillos de piedra caliza");
        addBlock(ModBlocks.LIMESTONE_BRICK_SLAB, "Baldosa de ladrillos de piedra caliza");
        addBlock(ModBlocks.LIMESTONE_BRICK_STAIRS, "Escaleras de ladrillos de piedra caliza");
        addBlock(ModBlocks.LIMESTONE_BRICK_WALL, "Pared de ladrillos de piedra caliza");

        //Soul
        addBlock(ModBlocks.SOUL_MUD, "Barro de almas");
        addBlock(ModBlocks.SOUL_MUD_BRICKS, "Ladrillos de adobe de almas");
        addBlock(ModBlocks.SOUL_MUD_BRICK_SLAB, "Baldosa de ladrillos de adobe de almas");
        addBlock(ModBlocks.SOUL_MUD_BRICK_STAIRS, "Escaleras de ladrillos de adobe de almas");
        addBlock(ModBlocks.SOUL_MUD_BRICK_WALL, "Pared de ladrillos de adobe de almas");

        //Ores
        addBlock(ModBlocks.TIN_ORE, "Mineral de estaño");
        addBlock(ModBlocks.DEEPSLATE_TIN_ORE, "Mineral de estaño profundo");
        addBlock(ModBlocks.ZINC_ORE, "Mineral de zinc");
        addBlock(ModBlocks.DEEPSLATE_ZINC_ORE, "Mineral de zinc profundo");
        addBlock(ModBlocks.NETHER_ZINC_ORE, "Mineral de zinc del nether");
        addBlock(ModBlocks.NETHER_COPPER_ORE, "Mineral de cobre del nether");
        addBlock(ModBlocks.SULFUR_ORE, "Mineral de azufre");
        addBlock(ModBlocks.DEEPSLATE_SULFUR_ORE, "Mineral de azufre profundo");
        addBlock(ModBlocks.NETHER_SULFUR_ORE, "Mineral de azufre del nether");
        addBlock(ModBlocks.SILVER_ORE, "Mineral de plata");
        addBlock(ModBlocks.DEEPSLATE_SILVER_ORE, "Mineral de plata profundo");
        addBlock(ModBlocks.SAPPHIRE_ORE, "Mineral de zafiro");
        addBlock(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, "Mineral de zaphiro profundo");
        addBlock(ModBlocks.RUBI_ORE, "Mineral de rubi");
        addBlock(ModBlocks.DEEPSLATE_RUBI_ORE, "Mineral de rubi profundo");
        addBlock(ModBlocks.NETHER_GARNET_ORE, "Mineral de granate del nether");

        //Ore blocks
        addBlock(ModBlocks.TIN_BLOCK, "Bloque de estaño");
        addBlock(ModBlocks.ZINC_BLOCK, "Bloque de zinc");
        addBlock(ModBlocks.SILVER_BLOCK, "Bloque de plata");
        addBlock(ModBlocks.BRASS_BLOCK, "Bloque de latón");
        addBlock(ModBlocks.BRONZE_BLOCK, "Bloque de bronce");
        addBlock(ModBlocks.ROSE_GOLD_BLOCK, "Bloque de oro rosado");
        addBlock(ModBlocks.BRONZIUM_BLOCK, "Bloque de broncio");
        addBlock(ModBlocks.GREEN_GOLD_BLOCK, "Bloque de oro verde");
        addBlock(ModBlocks.STEEL_BLOCK, "Bloque de acero");

        //Wood
        //Apple
        addBlock(ModBlocks.APPLE_SAPLING, "Brote de manzano");
        addBlock(ModBlocks.APPLE_LEAVES, "Hojas de manzano");
        addBlock(ModBlocks.APPLE_LOG, "Tronco de manzano");
        addBlock(ModBlocks.STRIPPED_APPLE_LOG, "Tronco de manzano pelado");
        addBlock(ModBlocks.APPLE_WOOD, "Leño de manzana");
        addBlock(ModBlocks.STRIPPED_APPLE_WOOD, "Leño de manzano pelado");
        addBlock(ModBlocks.APPLE_PLANKS, "Tablones de manzano");
        addBlock(ModBlocks.APPLE_SLAB, "Baldosa de manzano");
        addBlock(ModBlocks.APPLE_STAIRS, "Escaleras de manzano");
        addBlock(ModBlocks.APPLE_FENCE, "Varandilla de manzano");
        addBlock(ModBlocks.APPLE_FENCEGATE, "Puerta de varandilla de manzano");
        addBlock(ModBlocks.APPLE_DOOR, "Puerta de manzano");
        addBlock(ModBlocks.APPLE_TRAPDOOR, "Trampilla de manzano");
        addBlock(ModBlocks.APPLE_BUTTON, "Botón de manzano");
        addBlock(ModBlocks.APPLE_PRESSURE_PLATE, "Placa de presión de manzano");

        //Green apple
        addBlock(ModBlocks.GREEN_APPLE_SAPLING, "Brote de manzano verde");
        addBlock(ModBlocks.GREEN_APPLE_LEAVES, "Hojas de manzano verde");

        //Walnut
        addBlock(ModBlocks.WALNUT_SAPLING, "Brote de nogal");
        addBlock(ModBlocks.WALNUT_LEAVES, "Hojas de nogal");
        addBlock(ModBlocks.WALNUT_LOG, "Tronco de nogal");
        addBlock(ModBlocks.STRIPPED_WALNUT_LOG, "Tronco de nogal pelado");
        addBlock(ModBlocks.WALNUT_WOOD, "Leño de nogal");
        addBlock(ModBlocks.STRIPPED_WALNUT_WOOD, "Leño de nogal pelado");
        addBlock(ModBlocks.WALNUT_PLANKS, "Tablones de nogal");
        addBlock(ModBlocks.WALNUT_SLAB, "Baldosa de nogal");
        addBlock(ModBlocks.WALNUT_STAIRS, "Escaleras de nogal");
        addBlock(ModBlocks.WALNUT_FENCE, "Varandilla de nogal");
        addBlock(ModBlocks.WALNUT_FENCEGATE, "Puerta de varandilla de nogal");
        addBlock(ModBlocks.WALNUT_DOOR, "Puerta de nogal");
        addBlock(ModBlocks.WALNUT_TRAPDOOR, "Trampilla de nogal");
        addBlock(ModBlocks.WALNUT_BUTTON, "Botón de nogal");
        addBlock(ModBlocks.WALNUT_PRESSURE_PLATE, "Placa de presión de nogal");

        //Block entities
        addBlock(ModBlocks.ADOBE_FURNACE, "Horno de barro");
        addBlock(ModBlocks.SOUL_FURNACE, "Horno de barro de almas");
        addBlock(ModBlocks.ADOBE_ALLOYING_FURNACE, "Horno de aleación de larillos");
        addBlock(ModBlocks.SOUL_ALLOY_FURNACE, "Horno de aleación de ladrillos de almas");
        addBlock(ModBlocks.SUPER_ALLOYING_FURNACE, "Alto horno de aleación");
        addBlock(ModBlocks.GEM_POLISHER, "Mesa de pulido");
        addBlock(ModBlocks.GRINDER, "Moledora");

        //Items
        //Raw ores
        addItem(ModItems.RAW_TIN, "Estaño crudo");
        addItem(ModItems.RAW_ZINC, "Zinc crudo");
        addItem(ModItems.RAW_SILVER, "Plata cruda");
        addItem(ModItems.RAW_EMERALD, "Esmeralda impura");
        addItem(ModItems.RAW_SAPPHIRE, "Zafiro impuro");
        addItem(ModItems.RAW_RUBI, "Rubi impuro");
        addItem(ModItems.RAW_GARNET, "Granate impuro");
        addItem(ModItems.RAW_DIAMOND, "Diamante impuro");

        //Materials and melted ores
        addItem(ModItems.TIN_INGOT, "Lingote de estaño");
        addItem(ModItems.TIN_NUGGET, "Pepita de estaño");
        addItem(ModItems.ZINC_INGOT, "Lingote de zinc");
        addItem(ModItems.ZINC_NUGGET, "Pepita de zinc");
        addItem(ModItems.SULFUR, "Azufre");
        addItem(ModItems.SILVER_INGOT, "Lingote de plata");
        addItem(ModItems.SILVER_NUGGET, "Pepita de plata");
        addItem(ModItems.BRASS_INGOT, "Lingote de latón");
        addItem(ModItems.BRASS_NUGGET, "Pepita de latón");
        addItem(ModItems.BRONZE_INGOT, "Lingote de bronce");
        addItem(ModItems.BRONZE_NUGGET, "Pepita de bronce");
        addItem(ModItems.ROSE_GOLD_INGOT, "Lingote de oro rosado");
        addItem(ModItems.ROSE_GOLD_NUGGET, "Pepita de oro rosado");
        addItem(ModItems.BRONZIUM_INGOT, "Lingote de broncio");
        addItem(ModItems.BRONZIUM_NUGGET, "Pepita de broncio");
        addItem(ModItems.GREEN_GOLD_INGOT, "Lingote de oro verde");
        addItem(ModItems.GREEN_GOLD_NUGGET, "Pepita de oro verde");
        addItem(ModItems.STEEL_INGOT, "Lingote de acero");
        addItem(ModItems.MUD_BRICK, "Ladrillo de adobe");

        //Silver equipment
        addItem(ModItems.SILVER_SWORD, "Espada de plata");
        addItem(ModItems.SILVER_PICKAXE, "Pico de plata");
        addItem(ModItems.SILVER_AXE, "Hacha de plata");
        addItem(ModItems.SILVER_SHOVEL, "Pala de plata");
        addItem(ModItems.SILVER_HOE, "Azada de plata");
        addItem(ModItems.SILVER_POLISHER, "Pulidora de plata");
        addItem(ModItems.SILVER_HELMET, "Casco de plata");
        addItem(ModItems.SILVER_CHESTPLATE, "Pechera de plata");
        addItem(ModItems.SILVER_LEGGINGS, "Pantalones de plata");
        addItem(ModItems.SILVER_BOOTS, "Botas de plata");

        //Gold equipment
        addItem(ModItems.GOLD_POLISHER, "Pulidora de plata");

        //Stone equipment
        addItem(ModItems.STONE_POLISHER, "Pulidora de piedra");

        //Brass equipment
        addItem(ModItems.BRASS_SWORD, "Espada de latón");
        addItem(ModItems.BRASS_PICKAXE, "Pico de latón");
        addItem(ModItems.BRASS_AXE, "Hacha de latón");
        addItem(ModItems.BRASS_SHOVEL, "Pala de latón");
        addItem(ModItems.BRASS_HOE, "Azada de latón");
        addItem(ModItems.BRASS_POLISHER, "Pulidora de latón");
        addItem(ModItems.BRASS_HELMET, "Casco de latón");
        addItem(ModItems.BRASS_CHESTPLATE, "Pechera de latón");
        addItem(ModItems.BRASS_LEGGINGS, "Pantalones de latón");
        addItem(ModItems.BRASS_BOOTS, "Botas de latón");

        //Bronze equipment
        addItem(ModItems.BRONZE_SWORD, "Espada de bronce");
        addItem(ModItems.BRONZE_PICKAXE, "Pico de bronce");
        addItem(ModItems.BRONZE_AXE, "Hacha de bronce");
        addItem(ModItems.BRONZE_SHOVEL, "Pala de bronce");
        addItem(ModItems.BRONZE_HOE, "Azada de bronce");
        addItem(ModItems.BRONZE_POLISHER, "Pulidora de bronce");
        addItem(ModItems.BRONZE_HELMET, "Casco de bronce");
        addItem(ModItems.BRONZE_CHESTPLATE, "Pechera de bronce");
        addItem(ModItems.BRONZE_LEGGINGS, "Pantalones de bronce");
        addItem(ModItems.BRONZE_BOOTS, "Botas de bronce");

        //Rose golden equipment
        addItem(ModItems.ROSE_GOLDEN_SWORD, "Espada de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_PICKAXE, "Pico de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_AXE, "Hacha de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_SHOVEL, "Pala de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_HOE, "Azada de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_POLISHER, "Pulidora de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_HELMET, "Casco de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_CHESTPLATE, "Pechera de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_LEGGINGS, "Pantalones de oro rosado");
        addItem(ModItems.ROSE_GOLDEN_BOOTS, "Botas de oro rosado");

        //Bronzium equipment
        addItem(ModItems.BRONZIUM_SWORD, "Espada de broncio");
        addItem(ModItems.BRONZIUM_PICKAXE, "Pico de broncio");
        addItem(ModItems.BRONZIUM_AXE, "Hacha de broncio");
        addItem(ModItems.BRONZIUM_SHOVEL, "Pala de broncio");
        addItem(ModItems.BRONZIUM_HOE, "Azada de broncio");
        addItem(ModItems.BRONZIUM_POLISHER, "Pulidora de broncio");
        addItem(ModItems.BRONZIUM_HELMET, "Casco de broncio");
        addItem(ModItems.BRONZIUM_CHESTPLATE, "Pechera de broncio");
        addItem(ModItems.BRONZIUM_LEGGINGS, "Pantalones de broncio");
        addItem(ModItems.BRONZIUM_BOOTS, "Botas de broncio");

        //Iron equipment
        addItem(ModItems.IRON_POLISHER, "Pulidora de hierro");

        //Green golden equipment
        addItem(ModItems.GREEN_GOLDEN_SWORD, "Espada de oro verde");
        addItem(ModItems.GREEN_GOLDEN_PICKAXE, "Pico de oro verde");
        addItem(ModItems.GREEN_GOLDEN_AXE, "Hacha de oro verde");
        addItem(ModItems.GREEN_GOLDEN_SHOVEL, "Pala de oro verde");
        addItem(ModItems.GREEN_GOLDEN_HOE, "Azada de oro verde");
        addItem(ModItems.GREEN_GOLDEN_POLISHER, "Pulidora de oro verde");
        addItem(ModItems.GREEN_GOLDEN_HELMET, "Casco de oro verde");
        addItem(ModItems.GREEN_GOLDEN_CHESTPLATE, "Pechera de oro verde");
        addItem(ModItems.GREEN_GOLDEN_LEGGINGS, "Pantalones de oro verde");
        addItem(ModItems.GREEN_GOLDEN_BOOTS, "Botas de oro verde");

        //Steel equipment
        addItem(ModItems.STEEL_SWORD, "Espada de acero");
        addItem(ModItems.STEEL_PICKAXE, "Pico de acero");
        addItem(ModItems.STEEL_AXE, "Hacha de acero");
        addItem(ModItems.STEEL_SHOVEL, "Pala de acero");
        addItem(ModItems.STEEL_HOE, "Azada de acero");
        addItem(ModItems.STEEL_POLISHER, "Pulidora de acero");
        addItem(ModItems.STEEL_HELMET, "Casco de acero");
        addItem(ModItems.STEEL_CHESTPLATE, "Pechera de acero");
        addItem(ModItems.STEEL_LEGGINGS, "Pantalones de acero");
        addItem(ModItems.STEEL_BOOTS, "Botas de acero");

        //Diamond equipment
        addItem(ModItems.DIAMOND_POLISHER, "Pulidora de diamante");

        //Netherite equipment
        addItem(ModItems.NETHERITE_POLISHER, "Pulidora de netherita");

        //Plants
        addItem(ModItems.YERBA_MATE, "Yerba mate");
        addItem(ModItems.GROUNDED_YERBA_MATE, "Yerba mate molida");

        //Food
        //Flour
        addItem(ModItems.WHEAT_FLOUR, "Harina de trigo");
        addItem(ModItems.PUMPKIN_FLOUR, "Harina de calabaza");

        //Seeds
        addItem(ModItems.YERBA_MATE_SEEDS, "Semillas de yerba mate");
        addItem(ModItems.ZAPALLO_SEEDS, "Semillas de calabaza");
        addItem(ModItems.TOMATO_SEEDS, "Semillas de tomate");
        addItem(ModItems.CORN_SEEDS, "Semillas de choclo");
        addItem(ModItems.EGGPLANT_SEEDS, "Semillas de berenjena");

        //Fruits
        addItem(ModItems.TOMATO, "Tomate");
        addItem(ModItems.LEMON, "Limón");
        addItem(ModItems.ORANGE, "Naranja");
        addItem(ModItems.WALNUT, "Nuez");
        addItem(ModItems.PEELED_WALNUT, "Nuez pelada");
        addItem(ModItems.GREEN_APPLE, "Manzana verde");

        //Vegetables
        addItem(ModItems.CORN, "Choclo");
        addItem(ModItems.ZAPALLO, "Calabaza");
        addItem(ModItems.EGGPLANT, "Berenjena");
        addItem(ModItems.RICE_GRAINS, "Granos de arroz");

        //Cooked
        addItem(ModItems.COOKED_CORN, "Choclo cocido");
        addItem(ModItems.COOKED_ZAPALLO, "Calabaza cocida");
        addItem(ModItems.COOKED_EGGPLANT, "Berejena cocida");

        //Others
        addItem(ModItems.EMPTY_MATE, "Mate vacio");
        addItem(ModItems.MATE, "Mate");
        addItem(ModItems.YEAST, "Levadura");
        addItem(ModItems.RICE_BOWL, "Bowl de arroz");

        //Smithing templates
        addItem(ModItems.BRONZIUM_SMITHING_UPGRADE_TEMPLATE, "Plantilla de mejora de broncio");
        addSmithingTranslations("bronzium", " Mejora de broncio", "Equipo de bronze, equipo de latón", "Lingote de latón, Lingote de bronce",
                "Colocá un arma, herramienta o armadora de bronce o de latón", "Colocá un Lingote de bronze para equipo de latón o un Lingote de latón para equipo de bronce");

        //Enchantments
        addEnchantment(ModEnchantments.FINE_MINING, "Minado fino");
        addEnchantmentDesc("fine_mining", "Al ser aplicado en un pico, las algunas gemas recolectadas salen purificadas");
        addEnchantment(ModEnchantments.POISON_TOUCH, "Corte venenoso");
        addEnchantmentDesc("poison_touch", "Aplica veneno al objetivo");
        addEnchantment(ModEnchantments.LIVING_TOUCH, "Corte regenerativo");
        addEnchantmentDesc("living_touch", "Aplica curación al objetivo");

        //Entities
        //Villagers
        addVillagerProfession("jeweler", "Joyero");
    }
}

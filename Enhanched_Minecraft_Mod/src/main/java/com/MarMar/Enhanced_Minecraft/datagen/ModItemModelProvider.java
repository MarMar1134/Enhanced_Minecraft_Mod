package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = Enhanced_Playthrough.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0f);
        trimMaterials.put(TrimMaterials.COPPER, 0.5f);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8f);
        trimMaterials.put(TrimMaterials.GOLD, 0.6f);
        trimMaterials.put(TrimMaterials.IRON, 0.2f);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7f);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9f);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3f);
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1f);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4f);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Enhanced_Playthrough.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Blocks with item
            //Polished stone
            blockWithItem(ModBlocks.POLISHED_STONE_SLAB);
            blockWithItem(ModBlocks.POLISHED_STONE_STAIRS);
            wallItem(ModBlocks.POLISHED_STONE_WALL, ModBlocks.POLISHED_STONE);

            //Cobbled limestone
            blockWithItem(ModBlocks.COBBLED_LIMESTONE_SLAB);
            blockWithItem(ModBlocks.COBBLED_LIMESTONE_STAIRS);
            wallItem(ModBlocks.COBBLED_LIMESTONE_WALL, ModBlocks.COBBLED_LIMESTONE);

            //Limestone
            blockWithItem(ModBlocks.LIMESTONE_SLAB);
            blockWithItem(ModBlocks.LIMESTONE_STAIRS);

            //Polished limestone
            blockWithItem(ModBlocks.POLISHED_LIMESTONE_SLAB);
            blockWithItem(ModBlocks.POLISHED_LIMESTONE_STAIRS);
            wallItem(ModBlocks.POLISHED_LIMESTONE_WALL, ModBlocks.POLISHED_LIMESTONE);

            //Limestone bricks
            blockWithItem(ModBlocks.LIMESTONE_BRICK_SLAB);
            blockWithItem(ModBlocks.LIMESTONE_BRICK_STAIRS);
            wallItem(ModBlocks.LIMESTONE_BRICK_WALL, ModBlocks.LIMESTONE_BRICKS);

        //wood
            //walnut
            saplingItem(ModBlocks.WALNUT_SAPLING);

            simpleBlockItem(ModBlocks.WALNUT_DOOR);
            trapdoorItem(ModBlocks.WALNUT_TRAPDOOR);

            buttonItem(ModBlocks.WALNUT_BUTTON, ModBlocks.WALNUT_PLANKS);

            blockWithItem(ModBlocks.WALNUT_PRESSURE_PLATE);

            blockWithItem(ModBlocks.WALNUT_SLAB);
            blockWithItem(ModBlocks.WALNUT_STAIRS);
            fenceItem(ModBlocks.WALNUT_FENCE, ModBlocks.WALNUT_PLANKS);
            blockWithItem(ModBlocks.WALNUT_FENCEGATE);

            simpleItem(ModItems.WALNUT);
            simpleItem(ModItems.PEELED_WALNUT);

            //Apple
            saplingItem(ModBlocks.APPLE_SAPLING);
            saplingItem(ModBlocks.GREEN_APPLE_SAPLING);

            simpleBlockItem(ModBlocks.APPLE_DOOR);
            trapdoorItem(ModBlocks.APPLE_TRAPDOOR);

            buttonItem(ModBlocks.APPLE_BUTTON, ModBlocks.APPLE_PLANKS);

            blockWithItem(ModBlocks.APPLE_PRESSURE_PLATE);

            blockWithItem(ModBlocks.APPLE_SLAB);
            blockWithItem(ModBlocks.APPLE_STAIRS);
            fenceItem(ModBlocks.APPLE_FENCE, ModBlocks.APPLE_PLANKS);
            blockWithItem(ModBlocks.APPLE_FENCEGATE);

            simpleItem(ModItems.GREEN_APPLE);

        //Food
        simpleItem(ModItems.LEMON);

        simpleItem(ModItems.ORANGE);

        simpleItem(ModItems.RICE_GRAINS);
        simpleItem(ModItems.RICE_BOWL);
        simpleItem(ModItems.YERBA_MATE);

        simpleItem(ModItems.GROUNDED_YERBA_MATE);
        simpleItem(ModItems.MATE);
        simpleItem(ModItems.EMPTY_MATE);

        simpleItem(ModItems.ZAPALLO);
        simpleItem(ModItems.COOKED_ZAPALLO);

        simpleItem(ModItems.EGGPLANT);
        simpleItem(ModItems.COOKED_EGGPLANT);

        simpleItem(ModItems.TOMATO);

        simpleItem(ModItems.CORN);
        simpleItem(ModItems.COOKED_CORN);

        simpleItem(ModItems.WHEAT_FLOUR);

        simpleItem(ModItems.PUMPKIN_FLOUR);

        simpleItem(ModItems.YEAST);

        //Seeds
        simpleItem(ModItems.YERBA_MATE_SEEDS);

        simpleItem(ModItems.ZAPALLO_SEEDS);

        simpleItem(ModItems.EGGPLANT_SEEDS);

        simpleItem(ModItems.TOMATO_SEEDS);

        simpleItem(ModItems.CORN_SEEDS);

        //Ores
        simpleItem(ModItems.SULFUR);

        simpleItem(ModItems.COPPER_NUGGET);

        simpleItem(ModItems.RAW_TIN);
        simpleItem(ModItems.TIN_INGOT);
        simpleItem(ModItems.TIN_NUGGET);

        simpleItem(ModItems.RAW_BRONZE);
        simpleItem(ModItems.BRONZE_INGOT);
        simpleItem(ModItems.BRONZE_NUGGET);

        simpleItem(ModItems.RAW_STEEL);
        simpleItem(ModItems.STEEL_INGOT);

        simpleItem(ModItems.RAW_SILVER);
        simpleItem(ModItems.SILVER_INGOT);
        simpleItem(ModItems.SILVER_NUGGET);

        simpleItem(ModItems.ROSE_GOLD_INGOT);
        simpleItem(ModItems.ROSE_GOLD_NUGGET);

        simpleItem(ModItems.GREEN_GOLD_INGOT);
        simpleItem(ModItems.GREEN_GOLD_NUGGET);

        simpleItem(ModItems.COBALT);

        simpleItem(ModItems.RAW_RUBI);
        simpleItem(ModItems.RAW_SAPPHIRE);
        simpleItem(ModItems.RAW_EMERALD);
        simpleItem(ModItems.RAW_DIAMOND);

        simpleItem(ModItems.RUBI);
        simpleItem(ModItems.SAPPHIRE);

        //Dust
        simpleItem(ModItems.COBALT_DUST);


        //Armors and tools
            //Gold
            HandheldItem(ModItems.GOLD_POLISHER);

            //Silver
            HandheldItem(ModItems.SILVER_SWORD);
            HandheldItem(ModItems.SILVER_PICKAXE);
            HandheldItem(ModItems.SILVER_AXE);
            HandheldItem(ModItems.SILVER_SHOVEL);
            HandheldItem(ModItems.SILVER_HOE);
            HandheldItem(ModItems.SILVER_POLISHER);

            simpleItem(ModItems.SILVER_HELMET);
            simpleItem(ModItems.SILVER_CHESTPLATE);
            simpleItem(ModItems.SILVER_LEGGINGS);
            simpleItem(ModItems.SILVER_BOOTS);

            //Stone
            HandheldItem(ModItems.STONE_POLISHER);

            //Bronze
            HandheldItem(ModItems.BRONZE_SWORD);
            HandheldItem(ModItems.BRONZE_PICKAXE);
            HandheldItem(ModItems.BRONZE_AXE);
            HandheldItem(ModItems.BRONZE_SHOVEL);
            HandheldItem(ModItems.BRONZE_HOE);
            HandheldItem(ModItems.BRONZE_POLISHER);

            simpleItem(ModItems.BRONZE_HELMET);
            simpleItem(ModItems.BRONZE_CHESTPLATE);
            simpleItem(ModItems.BRONZE_LEGGINGS);
            simpleItem(ModItems.BRONZE_BOOTS);

            //Rose Gold
            HandheldItem(ModItems.ROSE_GOLDEN_SWORD);
            HandheldItem(ModItems.ROSE_GOLDEN_PICKAXE);
            HandheldItem(ModItems.ROSE_GOLDEN_AXE);
            HandheldItem(ModItems.ROSE_GOLDEN_SHOVEL);
            HandheldItem(ModItems.ROSE_GOLDEN_HOE);
            HandheldItem(ModItems.ROSE_GOLDEN_POLISHER);

            simpleItem(ModItems.ROSE_GOLDEN_HELMET);
            simpleItem(ModItems.ROSE_GOLDEN_CHESTPLATE);
            simpleItem(ModItems.ROSE_GOLDEN_LEGGINGS);
            simpleItem(ModItems.ROSE_GOLDEN_BOOTS);

            //Iron
            HandheldItem(ModItems.IRON_POLISHER);

            //Steel
            HandheldItem(ModItems.STEEL_SWORD);
            HandheldItem(ModItems.STEEL_PICKAXE);
            HandheldItem(ModItems.STEEL_AXE);
            HandheldItem(ModItems.STEEL_SHOVEL);
            HandheldItem(ModItems.STEEL_HOE);
            HandheldItem(ModItems.STEEL_POLISHER);

            simpleItem(ModItems.STEEL_HELMET);
            simpleItem(ModItems.STEEL_CHESTPLATE);
            simpleItem(ModItems.STEEL_LEGGINGS);
            simpleItem(ModItems.STEEL_BOOTS);

            //Green Gold
            HandheldItem(ModItems.GREEN_GOLDEN_SWORD);
            HandheldItem(ModItems.GREEN_GOLDEN_PICKAXE);
            HandheldItem(ModItems.GREEN_GOLDEN_AXE);
            HandheldItem(ModItems.GREEN_GOLDEN_SHOVEL);
            HandheldItem(ModItems.GREEN_GOLDEN_HOE);
            HandheldItem(ModItems.GREEN_GOLDEN_POLISHER);

            simpleItem(ModItems.GREEN_GOLDEN_HELMET);
            simpleItem(ModItems.GREEN_GOLDEN_CHESTPLATE);
            simpleItem(ModItems.GREEN_GOLDEN_LEGGINGS);
            simpleItem(ModItems.GREEN_GOLDEN_BOOTS);

            //Diamond
            HandheldItem(ModItems.DIAMOND_POLISHER);

            //Netherite
            HandheldItem(ModItems.NETHERITE_POLISHER);
        }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture ("layer0",
                new ResourceLocation(Enhanced_Playthrough.MOD_ID,
                        "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder HandheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Enhanced_Playthrough.MOD_ID, "item/" + item.getId().getPath()));
    }
    public void blockWithItem(RegistryObject<Block> block) {
        this.withExistingParent(Enhanced_Playthrough.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Enhanced_Playthrough.MOD_ID,"block/" + item.getId().getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Enhanced_Playthrough.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Enhanced_Playthrough.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Enhanced_Playthrough.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Enhanced_Playthrough.MOD_ID,"item/" + item.getId().getPath()));
    }
}
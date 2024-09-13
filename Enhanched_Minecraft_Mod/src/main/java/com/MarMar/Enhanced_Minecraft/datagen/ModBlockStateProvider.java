package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.block.custom.crops.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Enhanced_Minecraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Stone
        blockWithItem(ModBlocks.Polished_stone);
        slabBlockWithoutItem(ModBlocks.Polished_stone_slab, "polished_stone");
        stairBlockWithoutItem(ModBlocks.Polished_stone_stair, "polished_stone");
        wallBlockWithoutItem(ModBlocks.Polished_stone_wall, "polished_stone");

        //Limestone
        blockWithItem(ModBlocks.Cobbeled_limestone);
        slabBlockWithoutItem(ModBlocks.Cobbeled_limestone_slab, "cobbeled_limestone");
        stairBlockWithoutItem(ModBlocks.Cobbeled_limestone_stair, "cobbeled_limestone");
        wallBlockWithoutItem(ModBlocks.Cobbeled_limestone_wall, "cobbeled_limestone");

        blockWithItem(ModBlocks.Limestone);
        slabBlockWithoutItem(ModBlocks.Limestone_slab, "limestone");
        stairBlockWithoutItem(ModBlocks.Limestone_stair, "limestone");

        blockWithItem(ModBlocks.Polished_limestone);
        slabBlockWithoutItem(ModBlocks.Polished_limestone_slab, "polished_limestone");
        stairBlockWithoutItem(ModBlocks.Polished_limestone_stair, "polished_limestone");
        wallBlockWithoutItem(ModBlocks.Polished_limestone_wall, "polished_limestone");

        blockWithItem(ModBlocks.Limestone_bricks);
        slabBlockWithoutItem(ModBlocks.Limestone_brick_slab, "limestone_brick");
        stairBlockWithoutItem(ModBlocks.Limestone_brick_stair, "limestone_brick");
        wallBlockWithoutItem(ModBlocks.Limestone_brick_wall, "limestone_brick");

        //ores
        blockWithItem(ModBlocks.Deepslate_tin_ore);
        blockWithItem(ModBlocks.Tin_ore);
        blockWithItem(ModBlocks.Deepslate_sulfur_ore);
        blockWithItem(ModBlocks.Sulfur_ore);
        blockWithItem(ModBlocks.Nether_sulfur_ore);
        blockWithItem(ModBlocks.Silver_ore);
        blockWithItem(ModBlocks.Deepslate_silver_ore);
        blockWithItem(ModBlocks.Deepslate_cobalt_ore);
        blockWithItem(ModBlocks.Rubi_ore);
        blockWithItem(ModBlocks.Saphire_ore);
        blockWithItem(ModBlocks.Deepslate_rubi_ore);
        blockWithItem(ModBlocks.Deepslate_saphire_ore);

        //Crops
        makeYerbaMateCrop((CropBlock) ModBlocks.Yerba_mate_crop.get(), "yerba_mate_stage","yerba_mate_stage");
        makeZapalloCrop((CropBlock) ModBlocks.Zapallo_crop.get(), "zapallo_stage","zapallo_stage");
        makeEggplantCrop((CropBlock) ModBlocks.Eggplant_crop.get(), "eggplant_stage","eggplant_stage");
        makeTomatoCrop((CropBlock) ModBlocks.Tomato_crop.get(), "tomato_stage","tomato_stage");
        makeCornCrop((CropBlock) ModBlocks.Corn_crop.get(), "corn_stage","corn_stage");
    }
    //Crops
        //Yerba mate
        public void makeYerbaMateCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> yerbaMateStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }
        private ConfiguredModel[] yerbaMateStates(BlockState state, CropBlock block, String modelName, String textureName) {
            ConfiguredModel[] models = new ConfiguredModel[1];
            models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((YerbaMateCropBlock) block).getAgeProperty()),
                    new ResourceLocation(Enhanced_Minecraft.MOD_ID, "block/" + textureName + state.getValue(((YerbaMateCropBlock) block).getAgeProperty()))).renderType("cutout"));

            return models;
        }
        //Zapallo
        public void makeZapalloCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> zapalloStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }
        private ConfiguredModel[] zapalloStates(BlockState state, CropBlock block, String modelName, String textureName) {
            ConfiguredModel[] models = new ConfiguredModel[1];
            models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ZapalloCropBlock) block).getAgeProperty()),
                    new ResourceLocation(Enhanced_Minecraft.MOD_ID, "block/" + textureName + state.getValue(((ZapalloCropBlock) block).getAgeProperty()))).renderType("cutout"));

            return models;
        }
        //Eggplant
        public void makeEggplantCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> eggplantStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }
    private ConfiguredModel[] eggplantStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((EggplantCropBlock) block).getAgeProperty()),
                new ResourceLocation(Enhanced_Minecraft.MOD_ID, "block/" + textureName + state.getValue(((EggplantCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
        //Tomato
        public void makeTomatoCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> tomatoStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }
    private ConfiguredModel[] tomatoStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()),
                new ResourceLocation(Enhanced_Minecraft.MOD_ID, "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
        //Corn
        public void makeCornCrop(CropBlock block, String modelName, String textureName) {
            Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

            getVariantBuilder(block).forAllStates(function);
        }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                new ResourceLocation(Enhanced_Minecraft.MOD_ID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void slabBlockWithoutItem(RegistryObject<Block> blockRegistryObject, String baseBlock){
        slabBlock((SlabBlock) blockRegistryObject.get(), new ResourceLocation(Enhanced_Minecraft.MOD_ID, "block/" + baseBlock), new ResourceLocation(Enhanced_Minecraft.MOD_ID, "block/" + baseBlock));
    }

    private void stairBlockWithoutItem(RegistryObject<Block> blockRegistryObject, String baseBlock){
        stairsBlock((StairBlock) blockRegistryObject.get(), new ResourceLocation(Enhanced_Minecraft.MOD_ID, "block/" + baseBlock));
    }

    private void wallBlockWithoutItem(RegistryObject<Block> blockRegistryObject, String baseBlock){
        wallBlock((WallBlock) blockRegistryObject.get(), new ResourceLocation(Enhanced_Minecraft.MOD_ID, "block/" + baseBlock));
    }
}

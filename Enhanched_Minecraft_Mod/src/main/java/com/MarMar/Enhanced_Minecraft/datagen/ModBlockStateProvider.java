package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Enhanced_Minecraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.Deepslate_tin_ore);
        blockWithItem(ModBlocks.Tin_ore);
        blockWithItem(ModBlocks.Deepslate_sulfur_ore);
        blockWithItem(ModBlocks.Sulfur_ore);
        blockWithItem(ModBlocks.Nether_sulfur_ore);

        simpleBlockWithItem(ModBlocks.Adobe_alloying_furnace.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/adobe_alloying_furnace_texture")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.Util.ModTags;
import com.MarMar.Enhanced_Minecraft.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Enhanced_Minecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag((BlockTags.MINEABLE_WITH_PICKAXE))
                .add(ModBlocks.Deepslate_sulfur_ore.get(),
                    ModBlocks.Nether_sulfur_ore.get(),
                    ModBlocks.Sulfur_ore.get(),
                    ModBlocks.Deepslate_tin_ore.get(),
                    ModBlocks.Tin_ore.get());

        this.tag(ModTags.Blocks.NEEDS_BRONZE_TOOL)
                .add(Blocks.IRON_ORE,
                        Blocks.IRON_BLOCK,
                        Blocks.IRON_BARS,
                        Blocks.IRON_DOOR,
                        Blocks.IRON_TRAPDOOR,
                        Blocks.RAW_IRON_BLOCK,
                        Blocks.HOPPER
                );

        this.tag(ModTags.Blocks.NEEDS_STEEL_TOOL)
                .add(Blocks.DEEPSLATE,
                        Blocks.DEEPSLATE_IRON_ORE,
                        Blocks.DEEPSLATE_COPPER_ORE,
                        Blocks.DEEPSLATE_GOLD_ORE,
                        Blocks.DEEPSLATE_DIAMOND_ORE,
                        Blocks.DEEPSLATE_EMERALD_ORE,
                        Blocks.DEEPSLATE_LAPIS_ORE,
                        Blocks.DEEPSLATE_REDSTONE_ORE,
                        Blocks.DEEPSLATE_BRICK_SLAB,
                        Blocks.DEEPSLATE_BRICK_STAIRS,
                        Blocks.DEEPSLATE_BRICKS,
                        Blocks.DEEPSLATE_BRICK_WALL,
                        Blocks.DEEPSLATE_TILE_SLAB,
                        Blocks.DEEPSLATE_TILE_STAIRS,
                        Blocks.DEEPSLATE_TILES,
                        Blocks.DEEPSLATE_TILE_WALL,
                        Blocks.CHISELED_DEEPSLATE,
                        Blocks.COBBLED_DEEPSLATE,
                        Blocks.POLISHED_DEEPSLATE,
                        Blocks.COBBLED_DEEPSLATE_SLAB,
                        Blocks.COBBLED_DEEPSLATE_STAIRS,
                        Blocks.COBBLED_DEEPSLATE_WALL,
                        Blocks.CRACKED_DEEPSLATE_BRICKS,
                        Blocks.CRACKED_DEEPSLATE_TILES,
                        Blocks.POLISHED_DEEPSLATE_SLAB,
                        Blocks.POLISHED_DEEPSLATE_STAIRS,
                        Blocks.POLISHED_DEEPSLATE_WALL
                );
    }
}
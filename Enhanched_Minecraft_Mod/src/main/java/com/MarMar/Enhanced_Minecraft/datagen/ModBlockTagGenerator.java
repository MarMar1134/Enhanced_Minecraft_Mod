package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.Util.ModTags;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
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
        this.tag(BlockTags.SLABS).add(
                ModBlocks.Polished_stone_slab.get(),
                ModBlocks.Cobbeled_limestone_slab.get(),
                ModBlocks.Limestone_slab.get(),
                ModBlocks.Polished_limestone_slab.get(),
                ModBlocks.Limestone_brick_slab.get()
        );

        this.tag(BlockTags.STAIRS).add(
                ModBlocks.Polished_stone_stair.get(),
                ModBlocks.Cobbeled_limestone_stair.get(),
                ModBlocks.Limestone_stair.get(),
                ModBlocks.Polished_limestone_stair.get(),
                ModBlocks.Limestone_brick_stair.get()
        );

        this.tag(Tags.Blocks.STONE).add(
                ModBlocks.Cobbeled_limestone.get()
        );

        this.tag((BlockTags.MINEABLE_WITH_PICKAXE)).add(
                //Stone
                ModBlocks.Polished_stone.get(),
                ModBlocks.Polished_stone_slab.get(),
                ModBlocks.Polished_stone_stair.get(),
                ModBlocks.Polished_stone_wall.get(),

                //Limestone
                ModBlocks.Limestone.get(),
                ModBlocks.Limestone_slab.get(),
                ModBlocks.Limestone_stair.get(),

                ModBlocks.Cobbeled_limestone.get(),
                ModBlocks.Cobbeled_limestone_slab.get(),
                ModBlocks.Cobbeled_limestone_stair.get(),
                ModBlocks.Cobbeled_limestone_wall.get(),

                ModBlocks.Polished_limestone.get(),
                ModBlocks.Polished_limestone_slab.get(),
                ModBlocks.Polished_limestone_stair.get(),
                ModBlocks.Polished_limestone_wall.get(),

                ModBlocks.Limestone_bricks.get(),
                ModBlocks.Limestone_brick_slab.get(),
                ModBlocks.Limestone_brick_stair.get(),
                ModBlocks.Limestone_brick_wall.get(),

                //Entities
                ModBlocks.Adobe_furnace.get(),
                ModBlocks.Adobe_alloying_furnace.get(),
                ModBlocks.Super_alloying_furnace.get(),
                ModBlocks.Gem_polisher_block.get(),

                //Ores
                ModBlocks.Sulfur_ore.get(),
                ModBlocks.Tin_ore.get(),
                ModBlocks.Silver_ore.get(),
                ModBlocks.Rubi_ore.get(),
                ModBlocks.Saphire_ore.get(),
                ModBlocks.Deepslate_tin_ore.get(),
                ModBlocks.Deepslate_silver_ore.get(),
                ModBlocks.Deepslate_rubi_ore.get(),
                ModBlocks.Deepslate_saphire_ore.get(),
                ModBlocks.Deepslate_sulfur_ore.get(),
                ModBlocks.Nether_sulfur_ore.get(),
                ModBlocks.Deepslate_cobalt_ore.get()
        );

        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL).add(
                ModBlocks.Polished_stone.get(),
                ModBlocks.Polished_stone_slab.get(),
                ModBlocks.Polished_stone_stair.get(),
                ModBlocks.Polished_stone_wall.get()
        );

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.Limestone.get(),
                ModBlocks.Limestone_slab.get(),
                ModBlocks.Limestone_stair.get(),
                ModBlocks.Cobbeled_limestone.get(),
                ModBlocks.Cobbeled_limestone_slab.get(),
                ModBlocks.Cobbeled_limestone_stair.get(),
                ModBlocks.Cobbeled_limestone_wall.get(),
                ModBlocks.Polished_limestone.get(),
                ModBlocks.Polished_limestone_slab.get(),
                ModBlocks.Polished_limestone_stair.get(),
                ModBlocks.Polished_limestone_wall.get(),
                ModBlocks.Limestone_bricks.get(),
                ModBlocks.Limestone_brick_slab.get(),
                ModBlocks.Limestone_brick_stair.get(),
                ModBlocks.Limestone_brick_wall.get()
        );

        this.tag(ModTags.Blocks.NEEDS_BRONZE_TOOL).add(
                Blocks.IRON_ORE,
                Blocks.IRON_BLOCK,
                Blocks.IRON_BARS,
                Blocks.IRON_DOOR,
                Blocks.IRON_TRAPDOOR,
                Blocks.RAW_IRON_BLOCK,
                Blocks.HOPPER
        );

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.Silver_ore.get(),
                ModBlocks.Saphire_ore.get(),
                ModBlocks.Rubi_ore.get()
        );

        this.tag(ModTags.Blocks.NEEDS_STEEL_TOOL).add(
                Blocks.DIAMOND_ORE,
                Blocks.DIAMOND_BLOCK,
                Blocks.DEEPSLATE,
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
                Blocks.POLISHED_DEEPSLATE_WALL,
                ModBlocks.Deepslate_tin_ore.get(),
                ModBlocks.Deepslate_sulfur_ore.get(),
                ModBlocks.Deepslate_silver_ore.get(),
                ModBlocks.Deepslate_rubi_ore.get(),
                ModBlocks.Deepslate_saphire_ore.get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.Deepslate_cobalt_ore.get()
        );
    }
}

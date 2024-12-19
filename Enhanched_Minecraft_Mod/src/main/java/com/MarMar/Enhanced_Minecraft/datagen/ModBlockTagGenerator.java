package com.MarMar.Enhanced_Minecraft.datagen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
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
        super(output, lookupProvider, Enhanced_Playthrough.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.BASIC_FURNACE).add(
                ModBlocks.ADOBE_FURNACE.get(),
                ModBlocks.SOUL_FURNACE.get()
        );

        this.tag(ModTags.Blocks.ALLOY_FURNACE).add(
                ModBlocks.ADOBE_ALLOYING_FURNACE.get()
        );

        this.tag(BlockTags.SLABS).add(
                ModBlocks.POLISHED_STONE_SLAB.get(),
                ModBlocks.COBBLED_LIMESTONE_SLAB.get(),
                ModBlocks.LIMESTONE_SLAB.get(),
                ModBlocks.POLISHED_LIMESTONE_SLAB.get(),
                ModBlocks.LIMESTONE_BRICK_SLAB.get(),
                ModBlocks.SOUL_MUD_BRICK_SLAB.get(),
                ModBlocks.WALNUT_SLAB.get(),
                ModBlocks.APPLE_SLAB.get()
        );

        this.tag(BlockTags.STAIRS).add(
                ModBlocks.POLISHED_STONE_STAIRS.get(),
                ModBlocks.COBBLED_LIMESTONE_STAIRS.get(),
                ModBlocks.LIMESTONE_STAIRS.get(),
                ModBlocks.POLISHED_LIMESTONE_STAIRS.get(),
                ModBlocks.LIMESTONE_BRICK_STAIRS.get(),
                ModBlocks.SOUL_MUD_BRICK_STAIRS.get(),
                ModBlocks.WALNUT_STAIRS.get(),
                ModBlocks.APPLE_STAIRS.get()
        );

        this.tag(BlockTags.WALLS).add(
                ModBlocks.POLISHED_STONE_WALL.get(),
                ModBlocks.COBBLED_LIMESTONE_WALL.get(),
                ModBlocks.POLISHED_LIMESTONE_WALL.get(),
                ModBlocks.LIMESTONE_BRICK_WALL.get(),
                ModBlocks.SOUL_MUD_BRICK_WALL.get()
        );

        this.tag(BlockTags.FENCES).add(
                ModBlocks.WALNUT_FENCE.get(),
                ModBlocks.APPLE_FENCE.get()
        );

        this.tag(BlockTags.FENCE_GATES).add(
                ModBlocks.WALNUT_FENCEGATE.get(),
                ModBlocks.APPLE_FENCEGATE.get()
        );

        this.tag(BlockTags.BUTTONS).add(
                ModBlocks.WALNUT_BUTTON.get(),
                ModBlocks.APPLE_BUTTON.get()
        );

        this.tag(BlockTags.PRESSURE_PLATES).add(
                ModBlocks.WALNUT_PRESSURE_PLATE.get(),
                ModBlocks.APPLE_PRESSURE_PLATE.get()
        );

        this.tag(BlockTags.LOGS_THAT_BURN).add(
                ModBlocks.WALNUT_LOG.get(),
                ModBlocks.STRIPPED_WALNUT_LOG.get(),
                ModBlocks.WALNUT_WOOD.get(),
                ModBlocks.STRIPPED_WALNUT_WOOD.get(),
                ModBlocks.APPLE_LOG.get(),
                ModBlocks.STRIPPED_APPLE_LOG.get(),
                ModBlocks.APPLE_WOOD.get(),
                ModBlocks.STRIPPED_APPLE_WOOD.get()
        );

        this.tag(BlockTags.LEAVES).add(
                ModBlocks.WALNUT_LEAVES.get(),
                ModBlocks.APPLE_LEAVES.get(),
                ModBlocks.GREEN_APPLE_LEAVES.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(
                Blocks.OAK_LEAVES,
                Blocks.BIRCH_LEAVES,
                Blocks.SPRUCE_LEAVES,
                Blocks.DARK_OAK_LEAVES,
                Blocks.ACACIA_LEAVES,
                Blocks.JUNGLE_LEAVES,
                ModBlocks.WALNUT_LEAVES.get(),
                ModBlocks.APPLE_LEAVES.get(),
                ModBlocks.GREEN_APPLE_LEAVES.get()
        );

        this.tag(BlockTags.PLANKS).add(
                ModBlocks.WALNUT_PLANKS.get(),
                ModBlocks.APPLE_PLANKS.get()
        );

        this.tag(Tags.Blocks.STONE).add(
                ModBlocks.COBBLED_LIMESTONE.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                //Stone
                ModBlocks.POLISHED_STONE.get(),
                ModBlocks.POLISHED_STONE_SLAB.get(),
                ModBlocks.POLISHED_STONE_STAIRS.get(),
                ModBlocks.POLISHED_STONE_WALL.get(),

                //Limestone
                ModBlocks.LIMESTONE.get(),
                ModBlocks.LIMESTONE_SLAB.get(),
                ModBlocks.LIMESTONE_STAIRS.get(),

                ModBlocks.COBBLED_LIMESTONE.get(),
                ModBlocks.COBBLED_LIMESTONE_SLAB.get(),
                ModBlocks.COBBLED_LIMESTONE_STAIRS.get(),
                ModBlocks.COBBLED_LIMESTONE_WALL.get(),

                ModBlocks.POLISHED_LIMESTONE.get(),
                ModBlocks.POLISHED_LIMESTONE_SLAB.get(),
                ModBlocks.POLISHED_LIMESTONE_STAIRS.get(),
                ModBlocks.POLISHED_LIMESTONE_WALL.get(),

                ModBlocks.LIMESTONE_BRICKS.get(),
                ModBlocks.LIMESTONE_BRICK_SLAB.get(),
                ModBlocks.LIMESTONE_BRICK_STAIRS.get(),
                ModBlocks.LIMESTONE_BRICK_WALL.get(),

                //soul
                ModBlocks.SOUL_MUD.get(),
                ModBlocks.SOUL_MUD_BRICKS.get(),
                ModBlocks.SOUL_MUD_BRICK_SLAB.get(),
                ModBlocks.SOUL_MUD_BRICK_STAIRS.get(),
                ModBlocks.SOUL_MUD_BRICK_WALL.get(),

                //Entities
                ModBlocks.ADOBE_FURNACE.get(),
                ModBlocks.ADOBE_ALLOYING_FURNACE.get(),
                ModBlocks.SUPER_ALLOYING_FURNACE.get(),
                ModBlocks.GEM_POLISHER.get(),

                //Ores
                ModBlocks.NETHER_COPPER_ORE.get(),
                ModBlocks.SULFUR_ORE.get(),
                ModBlocks.TIN_ORE.get(),
                ModBlocks.ZINC_ORE.get(),
                ModBlocks.SILVER_ORE.get(),
                ModBlocks.RUBI_ORE.get(),
                ModBlocks.SAPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_TIN_ORE.get(),
                ModBlocks.DEEPSLATE_ZINC_ORE.get(),
                ModBlocks.NETHER_ZINC_ORE.get(),
                ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                ModBlocks.DEEPSLATE_RUBI_ORE.get(),
                ModBlocks.DEEPSLATE_SAPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_SULFUR_ORE.get(),
                ModBlocks.NETHER_SULFUR_ORE.get(),
                ModBlocks.DEEPSLATE_COBALT_ORE.get(),

                //ore blocks
                ModBlocks.SILVER_BLOCK.get(),
                ModBlocks.TIN_BLOCK.get(),
                ModBlocks.ZINC_BLOCK.get(),
                ModBlocks.BRASS_BLOCK.get(),
                ModBlocks.BRONZE_BLOCK.get(),
                ModBlocks.BRONZIUM_BLOCK.get(),
                ModBlocks.ROSE_GOLD_BLOCK.get(),
                ModBlocks.STEEL_BLOCK.get(),
                ModBlocks.GREEN_GOLD_BLOCK.get()
        );

        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL).add(
                ModBlocks.POLISHED_STONE.get(),
                ModBlocks.POLISHED_STONE_SLAB.get(),
                ModBlocks.POLISHED_STONE_STAIRS.get(),
                ModBlocks.POLISHED_STONE_WALL.get()
        );

        this.tag(ModTags.Blocks.NEEDS_SILVER_TOOL).add(
                ModBlocks.SILVER_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.LIMESTONE.get(),
                ModBlocks.LIMESTONE_SLAB.get(),
                ModBlocks.LIMESTONE_STAIRS.get(),
                ModBlocks.COBBLED_LIMESTONE.get(),
                ModBlocks.COBBLED_LIMESTONE_SLAB.get(),
                ModBlocks.COBBLED_LIMESTONE_STAIRS.get(),
                ModBlocks.COBBLED_LIMESTONE_WALL.get(),
                ModBlocks.POLISHED_LIMESTONE.get(),
                ModBlocks.POLISHED_LIMESTONE_SLAB.get(),
                ModBlocks.POLISHED_LIMESTONE_STAIRS.get(),
                ModBlocks.POLISHED_LIMESTONE_WALL.get(),
                ModBlocks.LIMESTONE_BRICKS.get(),
                ModBlocks.LIMESTONE_BRICK_SLAB.get(),
                ModBlocks.LIMESTONE_BRICK_STAIRS.get(),
                ModBlocks.LIMESTONE_BRICK_WALL.get(),
                ModBlocks.NETHER_COPPER_ORE.get(),
                ModBlocks.TIN_BLOCK.get(),
                ModBlocks.ZINC_BLOCK.get(),
                ModBlocks.ZINC_ORE.get(),
                ModBlocks.NETHER_ZINC_ORE.get()
        );

        this.tag(ModTags.Blocks.NEEDS_BRASS_TOOL).add(
                ModBlocks.BRASS_BLOCK.get()
        );

        this.tag(ModTags.Blocks.NEEDS_BRONZE_TOOL).add(
                Blocks.IRON_ORE,
                Blocks.IRON_BLOCK,
                Blocks.IRON_BARS,
                Blocks.IRON_DOOR,
                Blocks.IRON_TRAPDOOR,
                Blocks.RAW_IRON_BLOCK,
                Blocks.HOPPER,
                ModBlocks.BRONZE_BLOCK.get()
        );

        this.tag(ModTags.Blocks.NEEDS_ROSE_GOLD_TOOL).add(
                ModBlocks.ROSE_GOLD_BLOCK.get()
        );

        this.tag(ModTags.Blocks.NEEDS_BRONZIUM_TOOL).add(
                ModBlocks.BRONZIUM_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.SILVER_ORE.get(),
                ModBlocks.SAPHIRE_ORE.get(),
                ModBlocks.RUBI_ORE.get()
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
                ModBlocks.DEEPSLATE_TIN_ORE.get(),
                ModBlocks.DEEPSLATE_ZINC_ORE.get(),
                ModBlocks.DEEPSLATE_SULFUR_ORE.get(),
                ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                ModBlocks.DEEPSLATE_RUBI_ORE.get(),
                ModBlocks.DEEPSLATE_SAPHIRE_ORE.get(),
                ModBlocks.STEEL_BLOCK.get()
        );

        this.tag(ModTags.Blocks.NEEDS_GREEN_GOLD_TOOL).add(
                ModBlocks.GREEN_GOLD_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.DEEPSLATE_COBALT_ORE.get()
        );

        this.tag(Tags.Blocks.ORES).add(
                ModBlocks.NETHER_COPPER_ORE.get(),
                ModBlocks.SULFUR_ORE.get(),
                ModBlocks.TIN_ORE.get(),
                ModBlocks.ZINC_ORE.get(),
                ModBlocks.SILVER_ORE.get(),
                ModBlocks.RUBI_ORE.get(),
                ModBlocks.SAPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_TIN_ORE.get(),
                ModBlocks.DEEPSLATE_ZINC_ORE.get(),
                ModBlocks.NETHER_ZINC_ORE.get(),
                ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                ModBlocks.DEEPSLATE_RUBI_ORE.get(),
                ModBlocks.DEEPSLATE_SAPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_SULFUR_ORE.get(),
                ModBlocks.NETHER_SULFUR_ORE.get(),
                ModBlocks.DEEPSLATE_COBALT_ORE.get()
        );

        this.tag(BlockTags.BEACON_BASE_BLOCKS).add(
                ModBlocks.SILVER_BLOCK.get(),
                ModBlocks.TIN_BLOCK.get(),
                ModBlocks.ZINC_BLOCK.get(),
                ModBlocks.BRASS_BLOCK.get(),
                ModBlocks.BRONZE_BLOCK.get(),
                ModBlocks.ROSE_GOLD_BLOCK.get(),
                ModBlocks.BRONZIUM_BLOCK.get(),
                ModBlocks.STEEL_BLOCK.get(),
                ModBlocks.GREEN_GOLD_BLOCK.get()
        );
    }
}

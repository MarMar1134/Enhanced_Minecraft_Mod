package com.MarMar.Enhanced_Minecraft.Util;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks{
        public static final TagKey<Block> NEEDS_SILVER_TOOL = blockTag("needs_silver_tool");
        public static final TagKey<Block> NEEDS_BRASS_TOOL = blockTag("needs_brass_tool");
        public static final TagKey<Block> NEEDS_BRONZE_TOOL= blockTag("needs_bronze_tool");
        public static final TagKey<Block> NEEDS_ROSE_GOLD_TOOL = blockTag("needs_rose_gold_tool");
        public static final TagKey<Block> NEEDS_BRONZIUM_TOOL = blockTag("needs_bronzium_tool");
        public static final TagKey<Block> NEEDS_GREEN_GOLD_TOOL = blockTag("needs_green_gold_tool");
        public static final TagKey<Block> NEEDS_STEEL_TOOL= blockTag("needs_steel_tool");
        public static final TagKey<Block> BASIC_FURNACE = blockTag("basic_furnace");
        public static final TagKey<Block> ALLOY_FURNACE = blockTag("alloy_furnace");
        public static final TagKey<Block> FURNACE = blockTag("furnace");


        private static TagKey<Block> blockTag(String name){
            return BlockTags.create(new ResourceLocation(Enhanced_Playthrough.MOD_ID, name));
        }
    }
    public static class Items{
        public static final TagKey<Item> BRASS = itemTag("brass");
        public static final TagKey<Item> BRONZE = itemTag("bronze");
        public static final TagKey<Item> BRONZIUM = itemTag("bronzium");
        public static final TagKey<Item> STEEL = itemTag("steel");
        public static final TagKey<Item> SILVER = itemTag("silver");
        public static final TagKey<Item> ROSE_GOLD = itemTag("rose_gold");
        public static final TagKey<Item> RAW_GEM = itemTag("raw_gem");
        public static final TagKey<Item> POLISHER_TOOL = itemTag("polisher_tool");
        public static final TagKey<Item> WALNUT_LOGS = itemTag("walnut_logs");
        public static final TagKey<Item> APPLE_LOGS = itemTag("apple_logs");
        private static TagKey<Item> itemTag(String name){
            return ItemTags.create(new ResourceLocation(Enhanced_Playthrough.MOD_ID, name));
        }
    }
}

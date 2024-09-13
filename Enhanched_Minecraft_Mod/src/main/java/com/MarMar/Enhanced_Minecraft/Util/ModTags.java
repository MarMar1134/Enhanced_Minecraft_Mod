package com.MarMar.Enhanced_Minecraft.Util;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks{
        public static final TagKey<Block> NEEDS_SILVER_TOOL = blockTag("needs_silver_tool");
        public static final TagKey<Block> NEEDS_BRONZE_TOOL= blockTag("needs_bronze_tool");
        public static final TagKey<Block> NEEDS_ROSE_GOLD_TOOL = blockTag("needs_rose_gold_tool");
        public static final TagKey<Block> NEEDS_GREEN_GOLD_TOOL = blockTag("needs_green_gold_tool");
        public static final TagKey<Block> NEEDS_STEEL_TOOL= blockTag("needs_steel_tool");


        private static TagKey<Block> blockTag(String name){
            return BlockTags.create(new ResourceLocation(Enhanced_Minecraft.MOD_ID, name));
        }
    }
    public static class Items{
        public static final TagKey<Item> Bronze_tag = itemTag("bronze");
        public static final TagKey<Item> Steel_tag = itemTag("steel");
        public static final TagKey<Item> Silver_tag = itemTag("silver");
        public static final TagKey<Item> Rose_gold_tag = itemTag("rose_gold");
        public static final TagKey<Item> raw_gems = itemTag("raw_gem");
        public static final TagKey<Item> Polisher_tag = itemTag("polisher_tool");
        private static TagKey<Item> itemTag(String name){
            return ItemTags.create(new ResourceLocation(Enhanced_Minecraft.MOD_ID, name));
        }
    }
}

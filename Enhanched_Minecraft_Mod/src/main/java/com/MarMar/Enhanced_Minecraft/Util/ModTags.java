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
        public static final TagKey<Block> NEEDS_BRONZE_TOOL= tag("needs_bronze_tool");
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Enhanced_Minecraft.MOD_ID, name));
        }
    }
    public static class Items{
        public static final TagKey<Item> Bronze_tag = tag("bronze");
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(Enhanced_Minecraft.MOD_ID, name));
        }
    }
}

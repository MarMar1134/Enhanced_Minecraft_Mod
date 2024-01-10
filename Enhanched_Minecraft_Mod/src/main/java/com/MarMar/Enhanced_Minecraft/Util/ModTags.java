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
        public static final TagKey<Block> NEEDS_BRONZE_TOOL= TagB("needs_bronze_tool");
        public static final TagKey<Block> NEEDS_STEEL_TOOL= TagB("needs_steel_tool");
        private static TagKey<Block> TagB(String name){
            return BlockTags.create(new ResourceLocation(Enhanced_Minecraft.MOD_ID, name));
        }
    }
    public static class Items{
        public static final TagKey<Item> Bronze_tag = TagI("bronze");
        public static final TagKey<Item> Steel_tag = TagI("steel");
        private static TagKey<Item> TagI(String name){
            return ItemTags.create(new ResourceLocation(Enhanced_Minecraft.MOD_ID, name));
        }
    }
}

package com.MarMar.Enhanced_Minecraft.item.templates;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class BronziumSmithingUpgradeTemplate extends SmithingTemplateItem {
    public BronziumSmithingUpgradeTemplate() {
        super(BRONZIUM_APPLIES_TO, BRONZIUM_INGREDIENTS, BRONZIUM_UPGRADE, BRONZIUM_BASE_SLOT_DESCRIPTION, BRONZIUM_ADDITIONS_SLOT_DESCRIPTION, CreateBronziumIconList(), CreateBronziumMaterialList());
    }

    //Vanilla features
    private static final ResourceLocation EMPTY_SLOT_HELMET;
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE;
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS;
    private static final ResourceLocation EMPTY_SLOT_BOOTS;
    private static final ResourceLocation EMPTY_SLOT_HOE;
    private static final ResourceLocation EMPTY_SLOT_AXE;
    private static final ResourceLocation EMPTY_SLOT_SWORD;
    private static final ResourceLocation EMPTY_SLOT_SHOVEL;
    private static final ResourceLocation EMPTY_SLOT_PICKAXE;
    private static final ResourceLocation EMPTY_SLOT_INGOT;

    private static final Component BRONZIUM_UPGRADE;
    private static final Component BRONZIUM_APPLIES_TO;
    private static final Component BRONZIUM_INGREDIENTS;
    private static final Component BRONZIUM_BASE_SLOT_DESCRIPTION;
    private static final Component BRONZIUM_ADDITIONS_SLOT_DESCRIPTION;

    private static List<ResourceLocation> CreateBronziumIconList(){
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }
    private static List<ResourceLocation> CreateBronziumMaterialList(){
        return List.of(EMPTY_SLOT_INGOT);
    }

    static {
        ChatFormatting TITLES = ChatFormatting.GRAY;
        ChatFormatting DESCS = ChatFormatting.BLUE;

        //Bronzium
        BRONZIUM_UPGRADE = Component.translatable("smithing.bronzium.title").withStyle(TITLES);
        BRONZIUM_APPLIES_TO = Component.translatable("smithing.bronzium.applies_to").withStyle(DESCS);
        BRONZIUM_INGREDIENTS = Component.translatable("smithing.bronzium.ingredients").withStyle(DESCS);
        BRONZIUM_BASE_SLOT_DESCRIPTION = Component.translatable("smithing.bronzium.base_slot_description");
        BRONZIUM_ADDITIONS_SLOT_DESCRIPTION = Component.translatable("smithing.bronzium.additions_slot_description");

        //Vanilla features
        EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
        EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
        EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
        EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
        EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
        EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
        EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");
    };
}

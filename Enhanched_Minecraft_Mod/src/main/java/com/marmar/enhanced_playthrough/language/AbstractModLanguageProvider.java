package com.marmar.enhanced_playthrough.language;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public abstract class AbstractModLanguageProvider extends LanguageProvider {
    public AbstractModLanguageProvider(PackOutput output, String locale) {
        super(output, EnhancedPlaythrough.MOD_ID, locale);
    }

    protected void addAdvancementTitle(String advancementCategory, String advancementName, String translation){
        this.add("advancements.title." + advancementCategory + "." + advancementName, translation);
    }

    protected void addAdvancementDesc(String advancementCategory, String advancementName, String translation){
        this.add("advancements.desc." + advancementCategory + "." + advancementName, translation);
    }

    protected void addDescription(String descriptionName, String translation){
        this.add("desc." + EnhancedPlaythrough.MOD_ID + "." + descriptionName, translation);
    }

    protected void addJeiCategory(String category, String translation){
        this.add("jei." + EnhancedPlaythrough.MOD_ID + "." + category, translation);
    }

    protected void addCreativeTab(String tabName, String translation){
        this.add("creativetab." + tabName, translation);
    }

    protected void addSmithingTranslations(String smithingMaterial, String title, String appliesTo, String ingredients, String baseSlotDesc, String addSlotDesc){
        this.add("smithing." + smithingMaterial + ".title", title);
        this.add("smithing." + smithingMaterial + ".applies_to", appliesTo);
        this.add("smithing." + smithingMaterial + ".ingredients", ingredients);
        this.add("smithing." + smithingMaterial + ".base_slot_description", baseSlotDesc);
        this.add("smithing." + smithingMaterial + ".additions_slot_description", addSlotDesc);
    }

    protected void addGuiElements(String blockGui, String translation){
        this.add("gui." + EnhancedPlaythrough.MOD_ID + "." + blockGui + ".text", translation);
    }

    protected void addEnchantmentDesc(String enchantmentName, String description){
        this.add("enchantment." + EnhancedPlaythrough.MOD_ID + "." + enchantmentName + ".desc", description);
    }

    protected void addVillagerProfession(String profession, String translation){
        this.add("entity.minecraft.villager." + EnhancedPlaythrough.MOD_ID + "." + profession, translation);
    }

    protected void addVillagerProfession(String profession){
        this.add("entity.minecraft.villager." + EnhancedPlaythrough.MOD_ID + "." + profession, profession);
    }
}

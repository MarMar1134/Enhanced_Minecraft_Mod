package com.MarMar.Enhanced_Minecraft.item;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    Bronze("bronze", 13, new int[]{1,4,3,2}, 12, SoundEvents.ARMOR_EQUIP_IRON, 0f, 0f, () -> Ingredient.of(
            ModItems.Bronze_ingot.get())),

    Steel("steel", 18, new int[]{2,7,5,3}, 16, SoundEvents.ARMOR_EQUIP_IRON, 1f, 0.05f, () -> Ingredient.of(
            ModItems.Steel_ingot.get())),
    Silver("silver", 9, new int[]{2,6,3,2}, 21, SoundEvents.ARMOR_EQUIP_GOLD, 0, 0, () -> Ingredient.of(
            ModItems.Silver_ingot.get())),
    Rose_gold("rose_gold", 10, new int[]{2,6,5,2}, 21, SoundEvents.ARMOR_EQUIP_GOLD, 0, 0, () -> Ingredient.of(
            ModItems.Rose_gold_ingot.get())),
    Reinforced_diamond("reinforced_diamond", 35, new int[]{3,6,8,3}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5f, 0.05f, () -> Ingredient.of(
            ModItems.Reinforced_diamond.get()));


    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmenValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    private static final int[] BASE_DURABILITY = {11,16,16,13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmenValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmenValue = enchantmenValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmenValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Enhanced_Minecraft.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

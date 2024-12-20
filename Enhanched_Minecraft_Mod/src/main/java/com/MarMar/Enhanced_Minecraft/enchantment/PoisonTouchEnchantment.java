package com.MarMar.Enhanced_Minecraft.enchantment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class PoisonTouchEnchantment extends Enchantment {
    protected PoisonTouchEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean isTreasureOnly() {
        return false;
    }

    @Override
    public boolean isTradeable() {
        return true;
    }


    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }
    @Override
    public int getMaxLevel() {
        return 2;
    }
    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if(pTarget instanceof LivingEntity){
            if(pLevel == 1){
                ((LivingEntity) pTarget).addEffect(new MobEffectInstance(MobEffects.POISON, 300, 0, true, true));
            } else if(pLevel == 2){
                ((LivingEntity) pTarget).addEffect(new MobEffectInstance(MobEffects.POISON, 300, 1, true, true));
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != Enchantments.FIRE_ASPECT && pOther != ModEnchantments.LIVING_TOUCH.get();
    }
}

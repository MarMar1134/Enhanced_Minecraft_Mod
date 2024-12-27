package com.marmar.enhanced_playthrough.item.custom;

import com.marmar.enhanced_playthrough.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MateItem extends BowlFoodItem {
    public MateItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        ItemStack $$3 = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pEntityLiving instanceof Player && ((Player)pEntityLiving).getAbilities().instabuild ? $$3 : new ItemStack(ModItems.EMPTY_MATE.get());
    }
}

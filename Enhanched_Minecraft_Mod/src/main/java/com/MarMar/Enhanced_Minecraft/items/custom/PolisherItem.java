package com.MarMar.Enhanced_Minecraft.items.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public class PolisherItem extends TieredItem implements Vanishable {
    private final int Durability;
    private final Tier tier;


    public PolisherItem(Tier pTier, Properties pProperties) {
        super(pTier,pProperties);

        this.tier = pTier;
        this.Durability = this.tier.getUses();
    }

    @Override
    public @NotNull Item asItem() {
        return super.asItem();
    }
    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public int getDamage(ItemStack stack) {
        return this.Durability;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return super.getMaxDamage(stack);
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return super.isDamaged(stack);
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, damage);
    }
    public Tier getTier(){
        return this.tier;
    }
}

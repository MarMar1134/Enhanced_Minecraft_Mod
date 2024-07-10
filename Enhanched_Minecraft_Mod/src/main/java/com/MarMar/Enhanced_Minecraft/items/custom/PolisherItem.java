package com.MarMar.Enhanced_Minecraft.items.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.extensions.IForgeItem;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class PolisherItem extends TieredItem implements IForgeItem {
   private final int maxDamage;
    private int damage;
    private final Tier tier;
    private final int useModifier;

    public PolisherItem(Tier pTier, int useModifier, Properties pProperties) {
        super(pTier,pProperties);

        this.tier = pTier;
        this.maxDamage = this.getTier().getUses()*useModifier;
        this.damage = this.maxDamage;
        this.useModifier = useModifier;
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
        return this.damage;
    }

    public void makeDamage(int damage){
        this.damage = this.damage + damage;
    }

    public void resetDamage(){
        this.damage = this.maxDamage;
    }
    @Override
    public int getMaxDamage(ItemStack stack) {
        return super.getMaxDamage(stack);
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return super.isDamaged(stack);
    }

    public Tier getTier(){
        return this.tier;
    }
    public int getTierUses(){
        return this.getTier().getUses();
    }
    public int getUseModifier(){
        return this.useModifier;
    }
}
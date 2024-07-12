package com.MarMar.Enhanced_Minecraft.items.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.extensions.IForgeItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class PolisherItem extends TieredItem implements IForgeItem {
    private final int damage;
    private final Tier tier;
    private final int useModifier;

    public PolisherItem(Tier pTier, int useModifier, Properties pProperties) {
        super(pTier,pProperties);

        this.tier = pTier;
        this.damage = this.getTier().getUses() * useModifier;
        this.useModifier = useModifier;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("descriptions.enhanced_minecraft.polisher_item"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
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
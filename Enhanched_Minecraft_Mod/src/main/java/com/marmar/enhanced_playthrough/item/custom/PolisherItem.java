package com.marmar.enhanced_playthrough.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PolisherItem extends TieredItem implements IForgeItem {
    private final int damage;
    private final Tier tier;

    public PolisherItem(Tier pTier, int useModifier, Properties pProperties) {
        super(pTier,pProperties);

        this.tier = pTier;
        this.damage = this.getTier().getUses() * useModifier;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.polisher_item").withStyle(ChatFormatting.BLUE));
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
}
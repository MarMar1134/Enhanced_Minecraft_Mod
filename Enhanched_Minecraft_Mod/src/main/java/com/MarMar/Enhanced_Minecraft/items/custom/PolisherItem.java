package com.MarMar.Enhanced_Minecraft.items.custom;

import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PolisherItem extends TieredItem implements Vanishable {
    private double Durability;
    private final Tier tier;
    private final String itemType;
    public PolisherItem(Tier pTier, float UseModifier, Properties pProperties) {
        super(pTier,pProperties);

        this.tier = pTier;
        this.Durability = this.getTierUses() /UseModifier;
        this.itemType = "polisher";
    }

    @Override
    public @NotNull Item asItem() {
        return super.asItem();
    }
    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    public double getDurability(){
        return this.Durability;
    }
    public void restDurability(){
        this.Durability -= 20;
    }
    public double getTierUses(){
        return this.getTier().getUses();
    }
    public Tier getTier(){
        return this.tier;
    }
    public String getItemType(){
        return this.itemType;
    }

    public boolean isPolisherItem(){
        return true;
    }
}

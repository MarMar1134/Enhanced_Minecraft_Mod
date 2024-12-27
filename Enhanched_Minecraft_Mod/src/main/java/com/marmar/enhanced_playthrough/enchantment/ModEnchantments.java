package com.marmar.enhanced_playthrough.enchantment;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EnhancedPlaythrough.MOD_ID);

    public static RegistryObject<Enchantment> FINE_MINING =
            ENCHANTMENTS.register("fine_mining", ()-> new FineMiningEnchantment(Enchantment.Rarity.RARE, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> POISON_TOUCH =
            ENCHANTMENTS.register("poison_touch", ()-> new PoisonTouchEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> LIVING_TOUCH =
            ENCHANTMENTS.register("living_touch", ()-> new LivingTouchEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static void Register(IEventBus eventBus){
        ENCHANTMENTS.register(eventBus);
    }
}

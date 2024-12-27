package com.marmar.enhanced_playthrough.item;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import com.marmar.enhanced_playthrough.Util.ModTiers;
import com.marmar.enhanced_playthrough.block.ModBlocks;
import com.marmar.enhanced_playthrough.item.armor.ModArmorItem;
import com.marmar.enhanced_playthrough.item.armor.ModArmorMaterials;
import com.marmar.enhanced_playthrough.item.templates.BronziumSmithingUpgradeTemplate;
import com.marmar.enhanced_playthrough.item.custom.MateItem;
import com.marmar.enhanced_playthrough.item.custom.PolisherItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
            ForgeRegistries.ITEMS, EnhancedPlaythrough.MOD_ID
    );
    //Ores
        //raw
        public static final RegistryObject<Item> SULFUR = ITEMS.register(
                "sulfur",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_TIN = ITEMS.register(
                "raw_tin",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_ZINC = ITEMS.register(
                "raw_zinc",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_SILVER = ITEMS.register(
                "raw_silver", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> COBALT = ITEMS.register(
                "cobalt", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_RUBI = ITEMS.register(
                "raw_rubi", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register(
                "raw_sapphire", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_GARNET = ITEMS.register(
                "raw_garnet", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_EMERALD = ITEMS.register(
                "raw_emerald", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_DIAMOND = ITEMS.register(
                "raw_diamond", () -> new Item(new Item.Properties()));

        //melted
        public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register(
                "copper_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> TIN_INGOT = ITEMS.register(
                "tin_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register(
                "tin_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register(
                "zinc_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ZINC_NUGGET = ITEMS.register(
                "zinc_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register(
                "bronze_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register(
                "bronze_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register(
                "brass_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRASS_NUGGET = ITEMS.register(
                "brass_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> BRONZIUM_INGOT = ITEMS.register(
                "bronzium_ingot",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_NUGGET = ITEMS.register(
                "bronzium_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register(
                "steel_ingot", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register(
                "silver_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register(
                "silver_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> ROSE_GOLD_INGOT = ITEMS.register(
                "rose_gold_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLD_NUGGET = ITEMS.register(
                "rose_gold_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> GREEN_GOLD_INGOT = ITEMS.register(
                "green_gold_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLD_NUGGET = ITEMS.register(
                "green_gold_nugget", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> RUBI = ITEMS.register(
                "rubi", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> SAPPHIRE = ITEMS.register(
                "sapphire", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> GARNET = ITEMS.register(
                "garnet", () -> new Item(new Item.Properties()));

    //Dust
    public static final RegistryObject<Item> COBALT_DUST = ITEMS.register(
            "cobalt_dust", () -> new Item(new Item.Properties()));

    //Templates
    public static final RegistryObject<Item> BRONZIUM_SMITHING_UPGRADE_TEMPLATE = ITEMS.register(
            "bronzium_upgrade_smithing_template", BronziumSmithingUpgradeTemplate::new);

    //Weapons, tools and armors
        //Stone
        public static final RegistryObject<Item> STONE_POLISHER = ITEMS.register(
                "stone_polisher",() -> new PolisherItem(Tiers.STONE,0, new Item.Properties()));

        //Gold
        public static final RegistryObject<Item> GOLD_POLISHER = ITEMS.register(
                "gold_polisher",() -> new PolisherItem(Tiers.GOLD,0, new Item.Properties()));

        //Silver
        public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register(
                "silver_sword",() -> new SwordItem(ModTiers.SILVER, 1, -2.4F, new Item.Properties()){

                });
        public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register(
                "silver_pickaxe",() -> new PickaxeItem(ModTiers.SILVER, -2, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_AXE = ITEMS.register(
                "silver_axe",() -> new SwordItem(ModTiers.SILVER, 6, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register(
                "silver_shovel",() -> new ShovelItem(ModTiers.SILVER, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_HOE = ITEMS.register(
                "silver_hoe",() -> new HoeItem(ModTiers.SILVER, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> SILVER_POLISHER = ITEMS.register(
                "silver_polisher",() -> new PolisherItem(ModTiers.SILVER,0, new Item.Properties()));

        public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register(
                "silver_helmet", () -> new ModArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.HELMET, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.silver_armor").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }
                });
        public static final RegistryObject<Item> SILVER_CHESTPLATE = ITEMS.register(
                "silver_chestplate", () -> new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.CHESTPLATE, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.silver_armor").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }
                });
        public static final RegistryObject<Item> SILVER_LEGGINGS = ITEMS.register(
                "silver_leggings", () -> new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.LEGGINGS, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.silver_armor").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }
                });
        public static final RegistryObject<Item> SILVER_BOOTS = ITEMS.register(
                "silver_boots", () -> new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.BOOTS, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.silver_armor").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }
                });

        //Bronze
        public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register(
                "bronze_sword",() -> new SwordItem(ModTiers.BRONZE, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register(
                "bronze_pickaxe",() -> new PickaxeItem(ModTiers.BRONZE, 1, -2.8F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register(
                "bronze_axe",() -> new AxeItem(ModTiers.BRONZE, 6, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register(
                "bronze_shovel",() -> new ShovelItem(ModTiers.BRONZE, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register(
                "bronze_hoe",() -> new HoeItem(ModTiers.BRONZE, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_POLISHER = ITEMS.register(
                "bronze_polisher",() -> new PolisherItem(ModTiers.BRONZE,0, new Item.Properties()));

         public static final RegistryObject<Item> BRONZE_HELMET = ITEMS.register(
                "bronze_helmet", () -> new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_CHESTPLATE = ITEMS.register(
                "bronze_chestplate", () -> new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_LEGGINGS = ITEMS.register(
                "bronze_leggings", () -> new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_BOOTS = ITEMS.register(
                "bronze_boots", () -> new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Brass
        public static final RegistryObject<Item> BRASS_SWORD = ITEMS.register(
                "brass_sword",() -> new SwordItem(ModTiers.BRASS, 1, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> BRASS_PICKAXE = ITEMS.register(
                "brass_pickaxe",() -> new PickaxeItem(ModTiers.BRASS, 1, -2.8F,  new Item.Properties()));
        public static final RegistryObject<Item> BRASS_AXE = ITEMS.register(
                "brass_axe",() -> new AxeItem(ModTiers.BRASS, 4, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRASS_SHOVEL = ITEMS.register(
                "brass_shovel",() -> new ShovelItem(ModTiers.BRASS, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRASS_HOE = ITEMS.register(
                "brass_hoe",() -> new HoeItem(ModTiers.BRASS, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRASS_POLISHER = ITEMS.register(
                "brass_polisher",() -> new PolisherItem(ModTiers.BRASS,0, new Item.Properties()));

        public static final RegistryObject<Item> BRASS_HELMET = ITEMS.register(
                "brass_helmet", () -> new ArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> BRASS_CHESTPLATE = ITEMS.register(
                "brass_chestplate", () -> new ArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> BRASS_LEGGINGS = ITEMS.register(
                "brass_leggings", () -> new ArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> BRASS_BOOTS = ITEMS.register(
                "brass_boots", () -> new ArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Rose Gold
        public static final RegistryObject<Item> ROSE_GOLDEN_SWORD = ITEMS.register(
                "rose_golden_sword",() -> new SwordItem(ModTiers.ROSE_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_PICKAXE = ITEMS.register(
                "rose_golden_pickaxe",() -> new PickaxeItem(ModTiers.ROSE_GOLD, -2, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_AXE = ITEMS.register(
                "rose_golden_axe",() -> new AxeItem(ModTiers.ROSE_GOLD, 6, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_SHOVEL = ITEMS.register(
                "rose_golden_shovel",() -> new ShovelItem(ModTiers.ROSE_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_HOE = ITEMS.register(
                "rose_golden_hoe",() -> new HoeItem(ModTiers.ROSE_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> ROSE_GOLDEN_POLISHER = ITEMS.register(
                "rose_golden_polisher", () -> new PolisherItem(ModTiers.ROSE_GOLD, 0, new Item.Properties()));

        public static final RegistryObject<Item> ROSE_GOLDEN_HELMET = ITEMS.register(
                "rose_golden_helmet", () -> new ModArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.HELMET, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.rose_gold_armor").withStyle(ChatFormatting.LIGHT_PURPLE).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }

                    @Override
                    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                        return true;
                    }
                });
        public static final RegistryObject<Item> ROSE_GOLDEN_CHESTPLATE = ITEMS.register(
                "rose_golden_chestplate", () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.rose_gold_armor").withStyle(ChatFormatting.LIGHT_PURPLE).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }

                    @Override
                    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                        return true;
                    }
                });
        public static final RegistryObject<Item> ROSE_GOLDEN_LEGGINGS = ITEMS.register(
                "rose_golden_leggings", () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.LEGGINGS, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.rose_gold_armor").withStyle(ChatFormatting.LIGHT_PURPLE).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }

                    @Override
                    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                        return true;
                    }
                });
        public static final RegistryObject<Item> ROSE_GOLDEN_BOOTS = ITEMS.register(
                "rose_golden_boots", () -> new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.BOOTS, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.rose_gold_armor").withStyle(ChatFormatting.LIGHT_PURPLE).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }

                    @Override
                    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                        return true;
                    }
                });

        //Bronzium
        public static final RegistryObject<Item> BRONZIUM_SWORD = ITEMS.register(
                "bronzium_sword",() -> new SwordItem(ModTiers.BRONZIUM, 3, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_PICKAXE = ITEMS.register(
                "bronzium_pickaxe",() -> new PickaxeItem(ModTiers.BRONZIUM, 1, -2.8F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_AXE = ITEMS.register(
                "bronzium_axe",() -> new AxeItem(ModTiers.BRONZIUM, 7, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_SHOVEL = ITEMS.register(
                "bronzium_shovel",() -> new ShovelItem(ModTiers.BRONZIUM, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_HOE = ITEMS.register(
                "bronzium_hoe",() -> new HoeItem(ModTiers.BRONZIUM, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> BRONZIUM_POLISHER = ITEMS.register(
                "bronzium_polisher",() -> new PolisherItem(ModTiers.BRONZIUM,0, new Item.Properties()));

        public static final RegistryObject<Item> BRONZIUM_HELMET = ITEMS.register(
                "bronzium_helmet", () -> new ModArmorItem(ModArmorMaterials.BRONZIUM, ArmorItem.Type.HELMET, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.bronzium_armor").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }
                });
        public static final RegistryObject<Item> BRONZIUM_CHESTPLATE = ITEMS.register(
                "bronzium_chestplate", () -> new ArmorItem(ModArmorMaterials.BRONZIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.bronzium_armor").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }
                });
        public static final RegistryObject<Item> BRONZIUM_LEGGINGS = ITEMS.register(
                "bronzium_leggings", () -> new ArmorItem(ModArmorMaterials.BRONZIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.bronzium_armor").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }
                });
        public static final RegistryObject<Item> BRONZIUM_BOOTS = ITEMS.register(
                "bronzium_boots", () -> new ArmorItem(ModArmorMaterials.BRONZIUM, ArmorItem.Type.BOOTS, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.bronzium_armor").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }
                });

        //Iron
        public static final RegistryObject<Item> IRON_POLISHER = ITEMS.register(
                "iron_polisher",() -> new PolisherItem(Tiers.IRON,0, new Item.Properties()));

        //Steel
        public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register(
                "steel_sword",() -> new SwordItem(ModTiers.STEEL, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register(
                "steel_pickaxe",() -> new PickaxeItem(ModTiers.STEEL, 0, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_AXE = ITEMS.register(
                "steel_axe",() -> new AxeItem(ModTiers.STEEL, 4, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register(
                "steel_shovel",() -> new ShovelItem(ModTiers.STEEL, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> STEEL_HOE = ITEMS.register(
                "steel_hoe",() -> new HoeItem(ModTiers.STEEL, 1, -2F,  new Item.Properties()));
        public static final RegistryObject<Item> STEEL_POLISHER = ITEMS.register(
            "steel_polisher",() -> new PolisherItem(ModTiers.STEEL,0, new Item.Properties()));

        public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register(
            "steel_helmet", () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register(
            "steel_chestplate", () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register(
            "steel_leggings", () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register(
            "steel_boots", () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

        //Green Gold
        public static final RegistryObject<Item> GREEN_GOLDEN_SWORD = ITEMS.register(
                "green_golden_sword",() -> new SwordItem(ModTiers.GREEN_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_PICKAXE = ITEMS.register(
                "green_golden_pickaxe",() -> new PickaxeItem(ModTiers.GREEN_GOLD, -2, -2.8F, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_AXE = ITEMS.register(
                "green_golden_axe",() -> new AxeItem(ModTiers.GREEN_GOLD, 6, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_SHOVEL = ITEMS.register(
                "green_golden_shovel",() -> new ShovelItem(ModTiers.GREEN_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_HOE = ITEMS.register(
                "green_golden_hoe",() -> new HoeItem(ModTiers.GREEN_GOLD, 2, -2.4F, new Item.Properties()));
        public static final RegistryObject<Item> GREEN_GOLDEN_POLISHER = ITEMS.register(
                "green_golden_polisher", () -> new PolisherItem(ModTiers.GREEN_GOLD, 0, new Item.Properties()));

        public static final RegistryObject<Item> GREEN_GOLDEN_HELMET = ITEMS.register(
                "green_golden_helmet", () -> new ModArmorItem(ModArmorMaterials.GREEN_GOLD, ArmorItem.Type.HELMET, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.green_gold_armor").withStyle(ChatFormatting.DARK_GREEN).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }

                    @Override
                    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                        return true;
                    }
                });
        public static final RegistryObject<Item> GREEN_GOLDEN_CHESTPLATE = ITEMS.register(
                "green_golden_chestplate", () -> new ArmorItem(ModArmorMaterials.GREEN_GOLD, ArmorItem.Type.CHESTPLATE, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.green_gold_armor").withStyle(ChatFormatting.DARK_GREEN).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }

                    @Override
                    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                        return true;
                    }
                });
        public static final RegistryObject<Item> GREEN_GOLDEN_LEGGINGS = ITEMS.register(
                "green_golden_leggings", () -> new ArmorItem(ModArmorMaterials.GREEN_GOLD, ArmorItem.Type.LEGGINGS, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.green_gold_armor").withStyle(ChatFormatting.DARK_GREEN).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }

                    @Override
                    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                        return true;
                    }
                });
        public static final RegistryObject<Item> GREEN_GOLDEN_BOOTS = ITEMS.register(
                "green_golden_boots", () -> new ArmorItem(ModArmorMaterials.GREEN_GOLD, ArmorItem.Type.BOOTS, new Item.Properties()){
                    @Override
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                        pTooltipComponents.add(Component.translatable("desc.enhanced_minecraft.green_gold_armor").withStyle(ChatFormatting.DARK_GREEN).withStyle(ChatFormatting.ITALIC));
                        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
                    }

                    @Override
                    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
                        return true;
                    }
                });

        //Diamond
        public static final RegistryObject<Item> DIAMOND_POLISHER = ITEMS.register(
                "diamond_polisher",() -> new PolisherItem(Tiers.DIAMOND,0, new Item.Properties()));

        //Netherite
        public static final RegistryObject<Item> NETHERITE_POLISHER = ITEMS.register(
                "netherite_polisher",() -> new PolisherItem(Tiers.NETHERITE,0, new Item.Properties()));

    //Plants
    public static final RegistryObject<Item> YERBA_MATE = ITEMS.register(
            "yerba_mate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GROUNDED_YERBA_MATE = ITEMS.register(
            "grounded_yerba_mate", () -> new Item(new Item.Properties()));

    //Food
        //Flour
        public static final RegistryObject<Item> WHEAT_FLOUR = ITEMS.register(
                "wheat_flour",() -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> PUMPKIN_FLOUR = ITEMS.register(
                "pumpkin_flour",() -> new Item(new Item.Properties()));

        //Seeds
        public static final RegistryObject<Item> YERBA_MATE_SEEDS = ITEMS.register(
                "yerba_mate_seeds",() -> new ItemNameBlockItem(ModBlocks.YERBA_MATE_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> ZAPALLO_SEEDS = ITEMS.register(
                "zapallo_seeds",() -> new ItemNameBlockItem(ModBlocks.ZAPALLO_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> EGGPLANT_SEEDS = ITEMS.register(
                "eggplant_seeds",() -> new ItemNameBlockItem(ModBlocks.EGGPLANT_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register(
                "tomato_seeds", () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));
        public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register(
                "corn_seeds", () -> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new Item.Properties()));

        //Fruit
        public static final RegistryObject<Item> ORANGE = ITEMS.register(
                "orange",() -> new Item(new Item.Properties().food(ModFoodPropieties.ORANGE)));
        public static final RegistryObject<Item> LEMON = ITEMS.register(
                "lemon",() -> new Item(new Item.Properties().food(ModFoodPropieties.LEMON)));
        public static final RegistryObject<Item> GREEN_APPLE = ITEMS.register(
                "green_apple",() -> new Item(new Item.Properties().food(ModFoodPropieties.GREEN_APPLE)));
        public static final RegistryObject<Item> TOMATO = ITEMS.register(
                "tomato",() -> new Item(new Item.Properties().food(ModFoodPropieties.TOMATO)));
        public static final RegistryObject<Item> WALNUT = ITEMS.register(
                "walnut",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PEELED_WALNUT = ITEMS.register(
            "peeled_walnut",() -> new Item(new Item.Properties().food(ModFoodPropieties.PEELED_WALNUT)));

        //Vegetables
        public static final RegistryObject<Item> RICE_GRAINS = ITEMS.register(
                "rice_grains", () -> new Item((new Item.Properties().food(ModFoodPropieties.RICE))));
        public static final RegistryObject<Item> ZAPALLO = ITEMS.register(
                "zapallo", () -> new Item((new Item.Properties().food(ModFoodPropieties.ZAPALLO))));
        public static final RegistryObject<Item> EGGPLANT = ITEMS.register(
                "eggplant", () -> new Item((new Item.Properties().food(ModFoodPropieties.EGGPLANT))));
        public static final RegistryObject<Item> CORN = ITEMS.register(
                "corn", () -> new Item((new Item.Properties().food(ModFoodPropieties.CORN))));

        //Fungi
        public static final RegistryObject<Item> YEAST = ITEMS.register(
                "yeast",() -> new Item(new Item.Properties()));

        //Cooked food
        public static final RegistryObject<Item> RICE_BOWL = ITEMS.register(
                "rice_bowl",() -> new Item(new Item.Properties().food(ModFoodPropieties.RICE_BOWL)));
        public static final RegistryObject<Item> COOKED_ZAPALLO = ITEMS.register(
                "cooked_zapallo", () -> new Item((new Item.Properties().food(ModFoodPropieties.COOKED_ZAPALLO))));
        public static final RegistryObject<Item> COOKED_EGGPLANT = ITEMS.register(
                "cooked_eggplant", () -> new Item((new Item.Properties().food(ModFoodPropieties.COOKED_EGGPLANT))));
        public static final RegistryObject<Item> COOKED_CORN = ITEMS.register(
                "cooked_corn", () -> new Item((new Item.Properties().food(ModFoodPropieties.COOKED_CORN))));
        public static final RegistryObject<Item> EMPTY_MATE = ITEMS.register(
                "empty_mate",() -> new Item(new Item.Properties().stacksTo(1)));
        public static final RegistryObject<Item> MATE = ITEMS.register(
                "mate",() -> new MateItem(new Item.Properties().stacksTo(1).food(ModFoodPropieties.MATE)));

    //Final register
    public static void Register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

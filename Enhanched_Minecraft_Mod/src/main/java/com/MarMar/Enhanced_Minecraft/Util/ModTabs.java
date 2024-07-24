package com.MarMar.Enhanced_Minecraft.Util;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.blocks.ModBlocks;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> Tabs=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Enhanced_Minecraft.MOD_ID);
    //Tabs
//    public static final RegistryObject<CreativeModeTab> Saplings= Tabs.register(
//            "saplings", () -> CreativeModeTab.builder()
//                    .icon(() -> new ItemStack(ModItems.Apple_sapling.get()))
//                    .title(Component.translatable("creativetab.saplings"))
//                    .displayItems((itemDisplayParameters, output) -> {
//                        output.accept(ModItems.Almond_sapling.get());
//                        output.accept(ModItems.Apple_sapling.get());
//                        output.accept(ModItems.Hazelnut_sapling.get());
//                        output.accept(ModItems.Lemon_sapling.get());
//                        output.accept(ModItems.Orange_sapling.get());
//                        output.accept(ModItems.Walnut_sapling.get());
//                        output.accept(ModItems.Banana_seed.get());
//                    })
//                    .build());
    public static final RegistryObject<CreativeModeTab> Minerals = Tabs.register(
            "minerals", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.Tin_ore.get()))
                    .title(Component.translatable("creativetab.minerals"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.Sulfur_ore.get());
                        output.accept(ModBlocks.Deepslate_sulfur_ore.get());
                        output.accept(ModBlocks.Nether_sulfur_ore.get());
                        output.accept(ModBlocks.Tin_ore.get());
                        output.accept(ModBlocks.Deepslate_tin_ore.get());
                        output.accept(ModBlocks.Silver_ore.get());
                        output.accept(ModBlocks.Deepslate_silver_ore.get());
                        output.accept(ModBlocks.Deepslate_cobalt_ore.get());
                        output.accept(ModBlocks.Rubi_ore.get());
                        output.accept(ModBlocks.Deepslate_rubi_ore.get());
                        output.accept(ModBlocks.Saphire_ore.get());
                        output.accept(ModBlocks.Deepslate_saphire_ore.get());
                        output.accept(ModItems.Sulfur.get());
                        output.accept((ModItems.Raw_tin.get()));
                        output.accept(ModItems.Raw_bronze.get());
                        output.accept(ModItems.Raw_steel.get());
                        output.accept(ModItems.Raw_silver.get());
                        output.accept(ModItems.Cobalt.get());
                        output.accept(ModItems.Raw_rubi.get());
                        output.accept(ModItems.Raw_saphire.get());
                        output.accept(ModItems.Raw_emerald.get());
                        output.accept(ModItems.Raw_diamond.get());
                        output.accept(ModItems.Rubi.get());
                        output.accept(ModItems.Saphire.get());
                        output.accept(Items.EMERALD);
                        output.accept(Items.DIAMOND);
                    }).build()
    );
    public static final RegistryObject<CreativeModeTab> utility = Tabs.register(
            "utility", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Bronze_ingot.get()))
                    .title(Component.translatable("creativetab.utility"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.Adobe_alloying_furnace.get());
                        output.accept(ModBlocks.Super_alloying_furnace.get());
                        output.accept(ModBlocks.Gem_polisher_block.get());
                        output.accept((ModItems.Tin_ingot.get()));
                        output.accept((ModItems.Bronze_ingot.get()));
                        output.accept(ModItems.Bronze_nugget.get());
                        output.accept(ModItems.Steel_ingot.get());
                        output.accept(ModItems.Silver_ingot.get());
                        output.accept(ModItems.Rose_gold_ingot.get());
                        output.accept(ModItems.Reinforced_diamond.get());
                    }).build()
    );
    public static final RegistryObject<CreativeModeTab> Tools = Tabs.register(
            "tools", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Steel_pickaxe.get()))
                    .title((Component.translatable("creativetab.tools")))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Bronze
                        output.accept(ModItems.Bronze_pickaxe.get());
                        output.accept(ModItems.Bronze_axe.get());
                        output.accept(ModItems.Bronze_shovel.get());
                        output.accept(ModItems.Bronze_hoe.get());
                        output.accept(ModItems.Bronze_polisher.get());

                        //Steel
                        output.accept(ModItems.Steel_pickaxe.get());
                        output.accept(ModItems.Steel_axe.get());
                        output.accept(ModItems.Steel_shovel.get());
                        output.accept(ModItems.Steel_hoe.get());
                        output.accept(ModItems.Steel_polisher.get());

                        //Silver
                        output.accept(ModItems.Silver_pickaxe.get());
                        output.accept(ModItems.Silver_axe.get());
                        output.accept(ModItems.Silver_shovel.get());
                        output.accept(ModItems.Silver_hoe.get());
                        output.accept(ModItems.Silver_polisher.get());

                        //Rose Gold
                        output.accept(ModItems.Rose_golden_pickaxe.get());
                        output.accept(ModItems.Rose_golden_axe.get());
                        output.accept(ModItems.Rose_golden_shovel.get());
                        output.accept(ModItems.Rose_golden_hoe.get());

                        //Reinforced diamond
                        output.accept(ModItems.Reinforced_diamond_pickaxe.get());
                        output.accept(ModItems.Reinforced_diamond_axe.get());
                        output.accept(ModItems.Reinforced_diamond_shovel.get());
                        output.accept(ModItems.Reinforced_diamond_hoe.get());
                    }).build()
    );
    public static final RegistryObject<CreativeModeTab> weapons = Tabs.register(
            "weapons",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Steel_sword.get()))
                    .title(Component.translatable("creativetab.weapons"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Bronze
                        output.accept(ModItems.Bronze_sword.get());
                        output.accept(ModItems.Bronze_helmet.get());
                        output.accept(ModItems.Bronze_chestplate.get());
                        output.accept(ModItems.Bronze_leggings.get());
                        output.accept(ModItems.Bronze_boots.get());

                        //Steel
                        output.accept(ModItems.Steel_sword.get());
                        output.accept(ModItems.Steel_helmet.get());
                        output.accept(ModItems.Steel_chestplate.get());
                        output.accept(ModItems.Steel_leggings.get());
                        output.accept(ModItems.Steel_boots.get());

                        //Silver
                        output.accept(ModItems.Silver_sword.get());
                        output.accept(ModItems.Silver_helmet.get());
                        output.accept(ModItems.Silver_chestplate.get());
                        output.accept(ModItems.Silver_leggings.get());
                        output.accept(ModItems.Silver_boots.get());

                        //Rose gold
                        output.accept(ModItems.Rose_golden_sword.get());
                        output.accept(ModItems.Rose_golden_helmet.get());
                        output.accept(ModItems.Rose_golden_chestplate.get());
                        output.accept(ModItems.Rose_golden_leggings.get());
                        output.accept(ModItems.Rose_golden_boots.get());

                        //Reinforced diamond
                        output.accept(ModItems.Reinforced_diamond_sword.get());
                        output.accept(ModItems.Reinforced_diamond_helmet.get());
                        output.accept(ModItems.Reinforced_diamond_chestplate.get());
                        output.accept(ModItems.Reinforced_diamond_leggings.get());
                        output.accept(ModItems.Reinforced_diamond_boots.get());
                    })
                    .build()
    );
    public static final RegistryObject<CreativeModeTab> jewelery = Tabs.register(
            "jewelery", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Rubi.get()))
                    .title(Component.translatable("creativetab.jewelery"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.Rubi_ore.get());
                        output.accept(ModBlocks.Deepslate_rubi_ore.get());
                        output.accept(ModBlocks.Saphire_ore.get());
                        output.accept(ModBlocks.Deepslate_saphire_ore.get());
                        output.accept(Blocks.EMERALD_ORE);
                        output.accept(Blocks.DEEPSLATE_EMERALD_ORE);
                        output.accept(Blocks.DIAMOND_ORE);
                        output.accept(Blocks.DEEPSLATE_DIAMOND_ORE);
                        output.accept(ModBlocks.Gem_polisher_block.get());
                        output.accept((ModItems.Stone_polisher.get()));
                        output.accept((ModItems.Bronze_polisher.get()));
                        output.accept(ModItems.Iron_polisher.get());
                        output.accept(ModItems.Gold_polisher.get());
                        output.accept(ModItems.Silver_polisher.get());
                        output.accept(ModItems.Steel_polisher.get());
                        output.accept(ModItems.Diamond_polisher.get());
                        output.accept(ModItems.Netherite_polisher.get());
                        output.accept(ModItems.Raw_rubi.get());
                        output.accept(ModItems.Raw_saphire.get());
                        output.accept(ModItems.Raw_emerald.get());
                        output.accept(ModItems.Raw_diamond.get());
                        output.accept(ModItems.Rubi.get());
                        output.accept(ModItems.Saphire.get());
                        output.accept(Items.EMERALD);
                        output.accept(Items.DIAMOND);
                    }).build()
    );
    public static final RegistryObject<CreativeModeTab> Food= Tabs.register(
            "fruits", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Green_apple.get()))
                    .title(Component.translatable("creativetab.fruits"))
                    .displayItems((itemDisplayParameters, output) -> {
//                        output.accept(ModItems.Banana.get());
                        output.accept(ModItems.Green_apple.get());
                        output.accept(ModItems.Lemon.get());
                        output.accept(ModItems.Orange.get());
                        output.accept(ModItems.Yerba_mate.get());
                        output.accept(ModItems.Yerba_mate_seeds.get());
                        output.accept(ModItems.Zapallo.get());
                        output.accept(ModItems.Cooked_zapallo.get());
                        output.accept(ModItems.Zapallo_seeds.get());
                        output.accept(ModItems.Eggplant.get());
                        output.accept(ModItems.Cooked_eggplant.get());
                        output.accept(ModItems.Eggplant_seeds.get());
                        output.accept(ModItems.Tomato.get());
                        output.accept(ModItems.Tomato_seeds.get());
                        output.accept(ModItems.Corn.get());
                        output.accept(ModItems.Cooked_corn.get());
                        output.accept(ModItems.Corn_seeds.get());
                        output.accept(ModItems.Empty_mate.get());
                        output.accept(ModItems.Mate.get());
                    }).build()
    );
    public static void Register(IEventBus eventBus){
        Tabs.register(eventBus);
    }
}

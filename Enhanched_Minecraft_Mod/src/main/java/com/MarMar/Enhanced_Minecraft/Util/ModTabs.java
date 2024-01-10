package com.MarMar.Enhanced_Minecraft.Util;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.blocks.ModBlocks;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> Tabs=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Enhanced_Minecraft.MOD_ID);
    //Tabs
    public static final RegistryObject<CreativeModeTab> Saplings= Tabs.register(
            "saplings", () -> CreativeModeTab.builder()
//                    .icon(() -> new ItemStack(ModItems.Apple_sapling.get()))
                    .title(Component.translatable("creativetab.saplings"))
                    .displayItems((itemDisplayParameters, output) -> {
//                        output.accept(ModItems.Almond_sapling.get());
//                        output.accept(ModItems.Apple_sapling.get());
//                        output.accept(ModItems.Hazelnut_sapling.get());
//                        output.accept(ModItems.Lemon_sapling.get());
//                        output.accept(ModItems.Orange_sapling.get());
//                        output.accept(ModItems.Walnut_sapling.get());
//                        output.accept(ModItems.Banana_seed.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> Fruits= Tabs.register(
            "fruits", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Green_apple.get()))
                    .title(Component.translatable("creativetab.fruits"))
                    .displayItems((itemDisplayParameters, output) -> {
//                        output.accept(ModItems.Banana.get());
                        output.accept(ModItems.Green_apple.get());
                        output.accept(ModItems.Lemon.get());
                        output.accept(ModItems.Orange.get());
                    })
                    .build()
    );
    public static final RegistryObject<CreativeModeTab> Minerals = Tabs.register(
            "minerals", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Bronze_ingot.get()))
                    .title(Component.translatable("creativetab.minerals"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.Sulfur_ore.get());
                        output.accept(ModBlocks.Deepslate_sulfur_ore.get());
                        output.accept(ModBlocks.Nether_sulfur_ore.get());
                        output.accept(ModBlocks.Tin_ore.get());
                        output.accept(ModBlocks.Deepslate_tin_ore.get());
                        output.accept(ModItems.Sulfur.get());
                        output.accept((ModItems.Raw_tin.get()));
                        output.accept((ModItems.Tin_ingot.get()));
                        output.accept((ModItems.Bronze_ingot.get()));
                        output.accept(ModItems.Raw_steel.get());
                        output.accept(ModItems.Steel_ingot.get());
                    })
                    .build()
    );
    public static final RegistryObject<CreativeModeTab> Tools = Tabs.register(
            "tools", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Bronze_pickaxe.get()))
                    .title((Component.translatable("creativetab.tools")))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.Bronze_sword.get());
                        output.accept(ModItems.Bronze_pickaxe.get());
                        output.accept(ModItems.Bronze_axe.get());
                        output.accept(ModItems.Bronze_shovel.get());
                        output.accept(ModItems.Bronze_hoe.get());
                        output.accept(ModItems.Steel_sword.get());
                        output.accept(ModItems.Steel_pickaxe.get());
                        output.accept(ModItems.Steel_axe.get());
                        output.accept(ModItems.Steel_shovel.get());
                        output.accept(ModItems.Steel_hoe.get());
                    })
                    .build()
    );

    public static void Register(IEventBus eventBus){
        Tabs.register(eventBus);
    }
}

package com.MarMar.Enhanced_Minecraft.tabs;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.items.InitItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class InitTabs {
    public static final DeferredRegister<CreativeModeTab> Tabs=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Enhanced_Minecraft.MOD_ID);
    //Tabs
    public static final RegistryObject<CreativeModeTab> Saplings= Tabs.register(
            "saplings", () -> CreativeModeTab.builder().icon(() -> new ItemStack(InitItems.Apple_sapling.get()))
                    .title(Component.translatable("creativetab.saplings"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(InitItems.Almond_sapling.get());
                        output.accept(InitItems.Apple_sapling.get());
                        output.accept(InitItems.Hazelnut_sapling.get());
                        output.accept(InitItems.Lemon_sapling.get());
                        output.accept(InitItems.Orange_sapling.get());
                        output.accept(InitItems.Walnut_sapling.get());
                        output.accept(InitItems.Banana_seed.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> Fruits= Tabs.register(
            "fruits", () -> CreativeModeTab.builder().icon(() -> new ItemStack(InitItems.Green_apple.get()))
                    .title(Component.translatable("creativetab.fruits"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(InitItems.Banana.get());
                        output.accept(InitItems.Green_apple.get());
                        output.accept(InitItems.Orange.get());
                    })
                    .build()
    );

    public static void Register(IEventBus eventBus){
        Tabs.register(eventBus);
    }
}

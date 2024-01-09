package com.MarMar.Enhanced_Minecraft;

import com.MarMar.Enhanced_Minecraft.items.InitItems;
import com.MarMar.Enhanced_Minecraft.tabs.InitTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(Enhanced_Minecraft.MOD_ID)
public class Enhanced_Minecraft
{
    public static final String MOD_ID = "enhanced_minecraft";

    public Enhanced_Minecraft(){

        IEventBus ModEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitTabs.Register(ModEventBus);
        InitItems.Register(ModEventBus);

//        ModEventBus.addListener(this::commonSetup);
    //Register for creative tabs
        MinecraftForge.EVENT_BUS.register(this);
        ModEventBus.addListener(this::AddCreative);
    }

    private void AddCreative(BuildCreativeModeTabContentsEvent event){
    }
}

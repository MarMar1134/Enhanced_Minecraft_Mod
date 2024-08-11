package com.MarMar.Enhanced_Minecraft;

import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.block.entity.ModBlockEntities;
import com.MarMar.Enhanced_Minecraft.enchantment.ModEnchantments;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import com.MarMar.Enhanced_Minecraft.Util.ModTabs;
import com.MarMar.Enhanced_Minecraft.loot.ModLootModifiers;
import com.MarMar.Enhanced_Minecraft.recipe.ModRecipes;
import com.MarMar.Enhanced_Minecraft.screen.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(Enhanced_Minecraft.MOD_ID)
public class Enhanced_Minecraft
{
    public static final String MOD_ID = "enhanced_minecraft";

    public Enhanced_Minecraft(){

        IEventBus ModEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLootModifiers.register(ModEventBus);

        ModTabs.Register(ModEventBus);
        ModItems.Register(ModEventBus);
        ModEnchantments.Register(ModEventBus);

        ModBlocks.Register(ModEventBus);
        ModBlockEntities.register(ModEventBus);

        ModMenuTypes.Register(ModEventBus);
        ModRecipes.Register(ModEventBus);

    //Register for creative tabs
        MinecraftForge.EVENT_BUS.register(this);
        ModEventBus.addListener(this::AddCreative);
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value =  Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            MenuScreens.register(ModMenuTypes.adobe_alloying_furnace_menu.get(), AdobeAlloyingFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.super_alloying_furnace_menu.get(), SuperAlloyingFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.gem_polisher_menu.get(), GemPolisherScreen::new);
            MenuScreens.register(ModMenuTypes.grinder_menu.get(), GrinderScreen::new);
        }
    }

    private void AddCreative(BuildCreativeModeTabContentsEvent event){
    }
}

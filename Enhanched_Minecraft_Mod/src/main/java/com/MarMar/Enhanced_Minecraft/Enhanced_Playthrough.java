package com.MarMar.Enhanced_Minecraft;

import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import com.MarMar.Enhanced_Minecraft.block.custom.entity.ModBlockEntities;
import com.MarMar.Enhanced_Minecraft.enchantment.ModEnchantments;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import com.MarMar.Enhanced_Minecraft.Util.ModTabs;
import com.MarMar.Enhanced_Minecraft.loot.ModLootModifiers;
import com.MarMar.Enhanced_Minecraft.menu.screen.*;
import com.MarMar.Enhanced_Minecraft.recipe.ModRecipes;
import com.MarMar.Enhanced_Minecraft.menu.ModMenuTypes;
import com.MarMar.Enhanced_Minecraft.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Enhanced_Playthrough.MOD_ID)
public class Enhanced_Playthrough
{
    public static final String MOD_ID = "enhanced_minecraft";

    public Enhanced_Playthrough(){

        IEventBus ModEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLootModifiers.register(ModEventBus);

        ModTabs.Register(ModEventBus);
        ModItems.Register(ModEventBus);
        ModEnchantments.Register(ModEventBus);

        ModBlocks.Register(ModEventBus);
        ModBlockEntities.register(ModEventBus);

        ModMenuTypes.Register(ModEventBus);
        ModRecipes.Register(ModEventBus);

        ModVillagers.Register(ModEventBus);

    //Register for creative tabs
        MinecraftForge.EVENT_BUS.register(this);
        ModEventBus.addListener(this::AddCreative);
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value =  Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            MenuScreens.register(ModMenuTypes.ADOBE_FURNACE_MENU.get(), AdobeFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.SOUL_FURNACE_MENU.get(), SoulFurnaceScreen::new);

            MenuScreens.register(ModMenuTypes.ADOBE_ALLOYING_FURNACE_MENU.get(), AdobeAlloyFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.SUPER_ALLOYING_FURNACE_MENU.get(), SuperAlloyFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.SOUL_ALLOY_FURNACE_MENU.get(), SoulAlloyScreen::new);

            MenuScreens.register(ModMenuTypes.GEM_POLISHER_MENU.get(), GemPolisherScreen::new);

            MenuScreens.register(ModMenuTypes.GRINDER_MENU.get(), GrinderScreen::new);
        }
    }

    private void AddCreative(BuildCreativeModeTabContentsEvent event){
    }
}

package com.marmar.enhanced_playthrough;

import com.marmar.enhanced_playthrough.block.ModBlocks;
import com.marmar.enhanced_playthrough.block.custom.entity.ModBlockEntities;
import com.marmar.enhanced_playthrough.enchantment.ModEnchantments;
import com.marmar.enhanced_playthrough.item.ModItems;
import com.marmar.enhanced_playthrough.Util.ModTabs;
import com.marmar.enhanced_playthrough.loot.ModLootModifiers;
import com.marmar.enhanced_playthrough.menu.screen.*;
import com.marmar.enhanced_playthrough.recipe.ModRecipes;
import com.marmar.enhanced_playthrough.menu.ModMenuTypes;
import com.marmar.enhanced_playthrough.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EnhancedPlaythrough.MOD_ID)
public class EnhancedPlaythrough
{
    public static final String MOD_ID = "enhanced_playthrough";

    public EnhancedPlaythrough(){

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

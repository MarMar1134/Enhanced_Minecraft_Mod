package com.MarMar.Enhanced_Minecraft.menu;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Enhanced_Playthrough.MOD_ID);

    public static final RegistryObject<MenuType<AdobeFurnaceMenu>> ADOBE_FURNACE_MENU =
            registerMenuType("adobe_furnace_menu", AdobeFurnaceMenu::new);
    public static final RegistryObject<MenuType<SoulFurnaceMenu>> SOUL_FURNACE_MENU =
            registerMenuType("soul_furnace_menu", SoulFurnaceMenu::new);

    public static final RegistryObject<MenuType<AdobeAlloyFurnaceMenu>> ADOBE_ALLOYING_FURNACE_MENU =
            registerMenuType("adobe_alloying_furnace_menu", AdobeAlloyFurnaceMenu::new);
    public static final RegistryObject<MenuType<SuperAlloyFurnaceMenu>> SUPER_ALLOYING_FURNACE_MENU =
            registerMenuType("super_alloying_furnace_menu", SuperAlloyFurnaceMenu::new);
    public static final RegistryObject<MenuType<SoulAlloyFurnaceMenu>> SOUL_ALLOY_FURNACE_MENU =
            registerMenuType("soul_alloy_furnace_menu", SoulAlloyFurnaceMenu::new);

    public static final RegistryObject<MenuType<GemPolisherMenu>> GEM_POLISHER_MENU =
            registerMenuType("gem_polisher_menu", GemPolisherMenu::new);

    public static final RegistryObject<MenuType<GrinderMenu>> GRINDER_MENU =
            registerMenuType("grinder_menu", GrinderMenu::new);
    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }
    public static void Register(IEventBus eventBus){
        MENUS.register(eventBus);
    }
}

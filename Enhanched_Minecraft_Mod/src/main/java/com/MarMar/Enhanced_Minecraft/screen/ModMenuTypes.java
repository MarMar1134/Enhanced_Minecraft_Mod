package com.MarMar.Enhanced_Minecraft.screen;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> Menus =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES,Enhanced_Minecraft.MOD_ID);

    public static final RegistryObject<MenuType<AdobeAlloyingFurnaceMenu>> adobe_alloying_furnace_menu =
            registerMenuType("adobe_alloying_furnace_menu", AdobeAlloyingFurnaceMenu::new);
    public static final RegistryObject<MenuType<SuperAlloyingFurnaceMenu>> super_alloying_furnace_menu =
            registerMenuType("super_alloying_furnace_menu", SuperAlloyingFurnaceMenu::new);
    public static final RegistryObject<MenuType<GemPolisherMenu>> gem_polisher_menu =
            registerMenuType("gem_polisher_menu", GemPolisherMenu::new);
    public static final RegistryObject<MenuType<GrinderMenu>> grinder_menu =
            registerMenuType("grinder_menu", GrinderMenu::new);
    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return Menus.register(name, () -> IForgeMenuType.create(factory));
    }
    public static void Register(IEventBus eventBus){
        Menus.register(eventBus);
    }
}

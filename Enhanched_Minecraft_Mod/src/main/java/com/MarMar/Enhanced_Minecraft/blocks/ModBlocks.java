package com.MarMar.Enhanced_Minecraft.blocks;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Enhanced_Minecraft.MOD_ID);

    public static final RegistryObject<Block> Tin_ore = RegisterBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_ORE)));
    public static final RegistryObject<Block> Sulfur_ore = RegisterBlock("sulfur_ore",
            () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIAMOND_ORE)));
    //Block register
    private static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T> block){
        RegistryObject<T> ToReturn = Blocks.register(name, block);
        RegisterBlockItem(name, ToReturn);
        return ToReturn;
    }
    //BlockItem register
    private static <T extends Block> RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> block){
        return ModItems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    //Final register
    public static void Register(IEventBus eventBus){
        Blocks.register(eventBus);
    }
}

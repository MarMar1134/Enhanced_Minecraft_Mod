package com.MarMar.Enhanced_Minecraft.blocks;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Enhanced_Minecraft.MOD_ID);

    //Blocks
        //Saplings and seeds
//                public static final RegistryObject<Block> Orange_sapling = Blocks.register(
//                      "orange_sapling",() -> new SaplingBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks
//                    .OAK_SAPLING))
//                );
            //    public static final RegistryObject<Item> Lemon_sapling = Items.register(
            //            "lemon_sapling", () -> new Item(new Item.Properties().stacksTo(64))
            //    );
            //    public static final RegistryObject<Item> Apple_sapling = Items.register(
            //            "apple_sapling",() -> new Item(new Item.Properties())
            //    );
            //        //Nuts
            //    public static final RegistryObject<Item> Hazelnut_sapling = Items.register(
            //            "hazelnut_sapling",() -> new Item(new Item.Properties().stacksTo(64))
            //    );
            //    public static final RegistryObject<Item> Walnut_sapling = Items.register(
            //            "walnut_sapling",() -> new Item(new Item.Properties().stacksTo(64))
            //    );
            //    public static final RegistryObject<Item> Almond_sapling = Items.register(
            //            "almond_sapling",() -> new Item(new Item.Properties().stacksTo(64))
            //    );
            //    //Seeds
            //    public static final RegistryObject<Item> Banana_seed = Items.register(
            //            "banana_seed",() -> new Item(new Item.Properties().stacksTo(64))
            //    );
        //Ores
        public static final RegistryObject<Block> Tin_ore = RegisterBlock("tin_ore",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_ORE)
                        .requiresCorrectToolForDrops()));
         public static final RegistryObject<Block> Deepslate_tin_ore = RegisterBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_IRON_ORE)
                    .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> Sulfur_ore = RegisterBlock("sulfur_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIAMOND_ORE)
                        .requiresCorrectToolForDrops(), UniformInt.of(4,6)));
        public static final RegistryObject<Block> Deepslate_sulfur_ore = RegisterBlock("deepslate_sulfur_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(6,9)));
        public static final RegistryObject<Block> Nether_sulfur_ore = RegisterBlock("nether_sulfur_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_DIAMOND_ORE)
                    .sound(SoundType.NETHERRACK).requiresCorrectToolForDrops(), UniformInt.of(7,12)));

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

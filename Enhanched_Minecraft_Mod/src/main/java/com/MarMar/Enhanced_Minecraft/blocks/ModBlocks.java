package com.MarMar.Enhanced_Minecraft.blocks;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.blocks.custom.AdobeAlloyingFurnaceBlock;
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
        public static final RegistryObject<Block> Silver_ore = RegisterBlock("silver_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.GOLD_ORE)
                        .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> Deepslate_silver_ore = RegisterBlock("deepslate_silver_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_GOLD_ORE)
                    .requiresCorrectToolForDrops()));

        //Entity blocks
    public static final RegistryObject<Block> Adobe_alloying_furnace = RegisterBlock("adobe_alloying_furnace",
                () -> new AdobeAlloyingFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE).noOcclusion()));
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

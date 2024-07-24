package com.MarMar.Enhanced_Minecraft.blocks;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.blocks.crops.*;
import com.MarMar.Enhanced_Minecraft.blocks.custom.AdobeAlloyingFurnaceBlock;
import com.MarMar.Enhanced_Minecraft.blocks.custom.GemPolisherBlock;
import com.MarMar.Enhanced_Minecraft.blocks.custom.SuperAlloyingFurnaceBlock;
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
    public static final RegistryObject<Block> Deepslate_cobalt_ore = RegisterBlock("deepslate_cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.GOLD_ORE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> Rubi_ore = RegisterBlock("rubi_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.EMERALD_ORE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> Saphire_ore = RegisterBlock("saphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.EMERALD_ORE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> Deepslate_rubi_ore = RegisterBlock("deepslate_rubi_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> Deepslate_saphire_ore = RegisterBlock("deepslate_saphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE)
                    .requiresCorrectToolForDrops()));
        //Entity blocks
    public static final RegistryObject<Block> Adobe_alloying_furnace = RegisterBlock("adobe_alloying_furnace",
                () -> new AdobeAlloyingFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
    public static final RegistryObject<Block> Super_alloying_furnace = RegisterBlock("super_alloying_furnace",
            () -> new SuperAlloyingFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLED_DEEPSLATE).noOcclusion()));
    public static final RegistryObject<Block> Gem_polisher_block = RegisterBlock("gem_polisher",
            () -> new GemPolisherBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));

    //Crops
    public static final RegistryObject<Block> Yerba_mate_crop = Blocks.register("yerba_mate_crop",
            () -> new YerbaMateCropBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CARROTS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> Zapallo_crop = Blocks.register("zapallo_crop",
            () -> new ZapalloCropBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> Eggplant_crop = Blocks.register("eggplant_crop",
            () -> new EggplantCropBlock(BlockBehaviour.Properties.copy(ModBlocks.Yerba_mate_crop.get()).noOcclusion().noCollission()));
    public static final RegistryObject<Block> Tomato_crop = Blocks.register("tomato_crop",
            () -> new TomatoCropBlock(BlockBehaviour.Properties.copy(ModBlocks.Yerba_mate_crop.get()).noOcclusion().noCollission()));
    public static final RegistryObject<Block> Corn_crop = Blocks.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(ModBlocks.Yerba_mate_crop.get()).noOcclusion().noCollission()));
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

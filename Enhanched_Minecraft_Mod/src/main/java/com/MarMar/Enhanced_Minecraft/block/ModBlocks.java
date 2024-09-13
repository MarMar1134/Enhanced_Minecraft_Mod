package com.MarMar.Enhanced_Minecraft.block;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.block.custom.*;
import com.MarMar.Enhanced_Minecraft.block.custom.crops.*;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Enhanced_Minecraft.MOD_ID);

    //Blocks
        public static final RegistryObject<Block> Polished_stone = RegisterBlock("polished_stone",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> Polished_stone_slab = RegisterBlock("polished_stone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> Polished_stone_stair = RegisterBlock("polished_stone_stair",
                () -> new StairBlock(ModBlocks.Polished_stone.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> Polished_stone_wall = RegisterBlock("polished_stone_wall",
                () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL)
                        .requiresCorrectToolForDrops()));

        //Limestone
            //cobbled
            public static final RegistryObject<Block> Cobbeled_limestone = RegisterBlock("cobbeled_limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE)
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Cobbeled_limestone_slab = RegisterBlock("cobbeled_limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_SLAB)
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Cobbeled_limestone_stair = RegisterBlock("cobbeled_limestone_stair",
                    () -> new StairBlock(Cobbeled_limestone.get().defaultBlockState(), BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_STAIRS)
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Cobbeled_limestone_wall = RegisterBlock("cobbeled_limestone_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_WALL)
                            .requiresCorrectToolForDrops()));
            //natural
            public static final RegistryObject<Block> Limestone = RegisterBlock("limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE)
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Limestone_slab = RegisterBlock("limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB)
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Limestone_stair = RegisterBlock("limestone_stair",
                    () -> new StairBlock(Limestone.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS)
                            .requiresCorrectToolForDrops()));
            //polished
            public static final RegistryObject<Block> Polished_limestone = RegisterBlock("polished_limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.Polished_stone.get())
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Polished_limestone_slab = RegisterBlock("polished_limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB)
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Polished_limestone_stair = RegisterBlock("polished_limestone_stair",
                    () -> new StairBlock(ModBlocks.Polished_limestone.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS)
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Polished_limestone_wall = RegisterBlock("polished_limestone_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL)
                            .requiresCorrectToolForDrops()));
            //bricks
            public static final RegistryObject<Block> Limestone_bricks = RegisterBlock("limestone_brick",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICKS)
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Limestone_brick_slab = RegisterBlock("limestone_brick_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_SLAB)
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Limestone_brick_stair = RegisterBlock("limestone_brick_stair",
                    () -> new StairBlock(Limestone_bricks.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_STAIRS)
                            .requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> Limestone_brick_wall = RegisterBlock("limestone_brick_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL)
                            .requiresCorrectToolForDrops()));

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
        public static final RegistryObject<Block> Adobe_furnace = RegisterBlock("adobe_furnace",
                () -> new AdobeFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> Adobe_alloying_furnace = RegisterBlock("adobe_alloying_furnace",
                    () -> new AdobeAlloyingFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> Super_alloying_furnace = RegisterBlock("super_alloying_furnace",
                () -> new SuperAlloyingFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLED_DEEPSLATE).noOcclusion()));
        public static final RegistryObject<Block> Gem_polisher_block = RegisterBlock("gem_polisher",
                () -> new GemPolisherBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> Item_grinder_block = RegisterBlock("grinder",
                () -> new GrinderBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));

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

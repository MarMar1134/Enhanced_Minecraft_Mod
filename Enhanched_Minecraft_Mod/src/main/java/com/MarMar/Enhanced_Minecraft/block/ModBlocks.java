package com.MarMar.Enhanced_Minecraft.block;

import com.MarMar.Enhanced_Minecraft.Enhanced_Playthrough;
import com.MarMar.Enhanced_Minecraft.block.custom.*;
import com.MarMar.Enhanced_Minecraft.block.custom.crops.*;
import com.MarMar.Enhanced_Minecraft.block.custom.wood.ModLeavesBlock;
import com.MarMar.Enhanced_Minecraft.block.custom.wood.ModLogsBlock;
import com.MarMar.Enhanced_Minecraft.block.custom.wood.ModPlanksBlock;
import com.MarMar.Enhanced_Minecraft.item.ModItems;
import com.MarMar.Enhanced_Minecraft.worldgen.tree.grower.AppleTreeGrower;
import com.MarMar.Enhanced_Minecraft.worldgen.tree.grower.GreenAppleTreeGrower;
import com.MarMar.Enhanced_Minecraft.worldgen.tree.grower.WalnutTreeGrower;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Enhanced_Playthrough.MOD_ID);

    //Blocks
        //Polished stone
        public static final RegistryObject<Block> POLISHED_STONE = RegisterBlock("polished_stone",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> POLISHED_STONE_SLAB = RegisterBlock("polished_stone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> POLISHED_STONE_STAIRS = RegisterBlock("polished_stone_stair",
                () -> new StairBlock(() -> ModBlocks.POLISHED_STONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> POLISHED_STONE_WALL = RegisterBlock("polished_stone_wall",
                () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL)
                        .requiresCorrectToolForDrops()));

        //Limestone
            //cobbled
            public static final RegistryObject<Block> COBBLED_LIMESTONE = RegisterBlock("cobbeled_limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> COBBLED_LIMESTONE_SLAB = RegisterBlock("cobbeled_limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> COBBLED_LIMESTONE_STAIRS = RegisterBlock("cobbeled_limestone_stair",
                    () -> new StairBlock(() -> COBBLED_LIMESTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> COBBLED_LIMESTONE_WALL = RegisterBlock("cobbeled_limestone_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_WALL).requiresCorrectToolForDrops()));

            //natural
            public static final RegistryObject<Block> LIMESTONE = RegisterBlock("limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_SLAB = RegisterBlock("limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_STAIRS = RegisterBlock("limestone_stair",
                    () -> new StairBlock(() -> LIMESTONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS).requiresCorrectToolForDrops()));

            //polished
            public static final RegistryObject<Block> POLISHED_LIMESTONE = RegisterBlock("polished_limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.POLISHED_STONE.get()).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> POLISHED_LIMESTONE_SLAB = RegisterBlock("polished_limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> POLISHED_LIMESTONE_STAIRS = RegisterBlock("polished_limestone_stair",
                    () -> new StairBlock(() -> ModBlocks.POLISHED_LIMESTONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> POLISHED_LIMESTONE_WALL = RegisterBlock("polished_limestone_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));

            //bricks
            public static final RegistryObject<Block> LIMESTONE_BRICKS = RegisterBlock("limestone_brick",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICKS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_BRICK_SLAB = RegisterBlock("limestone_brick_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_BRICK_STAIRS = RegisterBlock("limestone_brick_stair",
                    () -> new StairBlock(() -> LIMESTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_BRICK_WALL = RegisterBlock("limestone_brick_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));


        //Soul
        public static final RegistryObject<Block> SOUL_MUD = RegisterBlock("soul_mud",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICKS = RegisterBlock("soul_mud_brick",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICKS).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICK_SLAB = RegisterBlock("soul_mud_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_SLAB).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICK_STAIRS = RegisterBlock("soul_mud_brick_stair",
                () -> new StairBlock(() -> SOUL_MUD_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_STAIRS).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICK_WALL = RegisterBlock("soul_mud_brick_wall",
                () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));

        //Ores
        public static final RegistryObject<Block> NETHER_COPPER_ORE = RegisterBlock("nether_copper_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).sound(SoundType.NETHERRACK).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> TIN_ORE = RegisterBlock("tin_ore",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_ORE).requiresCorrectToolForDrops()));
         public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = RegisterBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_IRON_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> ZINC_ORE = RegisterBlock("zinc_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = RegisterBlock("deepslate_zinc_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> NETHER_ZINC_ORE = RegisterBlock("nether_zinc_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.NETHERRACK).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> SULFUR_ORE = RegisterBlock("sulfur_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIAMOND_ORE)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> DEEPSLATE_SULFUR_ORE = RegisterBlock("deepslate_sulfur_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> NETHER_SULFUR_ORE = RegisterBlock("nether_sulfur_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_DIAMOND_ORE)
                    .sound(SoundType.NETHERRACK).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> SILVER_ORE = RegisterBlock("silver_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.GOLD_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = RegisterBlock("deepslate_silver_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_GOLD_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = RegisterBlock("deepslate_cobalt_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.GOLD_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> RUBI_ORE = RegisterBlock("rubi_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.EMERALD_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SAPHIRE_ORE = RegisterBlock("saphire_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.EMERALD_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> DEEPSLATE_RUBI_ORE = RegisterBlock("deepslate_rubi_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> DEEPSLATE_SAPHIRE_ORE = RegisterBlock("deepslate_saphire_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE).requiresCorrectToolForDrops()));

        //Ores blocks
        public static final RegistryObject<Block> SILVER_BLOCK = RegisterBlock("silver_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));
        public static final RegistryObject<Block> TIN_BLOCK = RegisterBlock("tin_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> ZINC_BLOCK = RegisterBlock("zinc_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> BRASS_BLOCK = RegisterBlock("brass_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> BRONZE_BLOCK = RegisterBlock("bronze_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> ROSE_GOLD_BLOCK = RegisterBlock("rose_gold_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> BRONZIUM_BLOCK = RegisterBlock("bronzium_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> STEEL_BLOCK = RegisterBlock("steel_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> GREEN_GOLD_BLOCK = RegisterBlock("green_gold_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

        //Wood
            //Walnut
            public static final RegistryObject<Block> WALNUT_SAPLING = RegisterBlock("walnut_sapling",
                    () -> new SaplingBlock(new WalnutTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_LOG = RegisterBlock("walnut_log",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> STRIPPED_WALNUT_LOG = RegisterBlock("stripped_walnut_log",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_WOOD = RegisterBlock("walnut_wood",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> STRIPPED_WALNUT_WOOD = RegisterBlock("stripped_walnut_wood",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_LEAVES = RegisterBlock("walnut_leaves",
                    () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_PLANKS = RegisterBlock("walnut_planks",
                    () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_DOOR = RegisterBlock("walnut_door",
                    () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> WALNUT_TRAPDOOR = RegisterBlock("walnut_trapdoor",
                    () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> WALNUT_BUTTON = RegisterBlock("walnut_button",
                    () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).requiresCorrectToolForDrops(), BlockSetType.OAK, 10, true));
            public static final RegistryObject<Block> WALNUT_PRESSURE_PLATE = RegisterBlock("walnut_pressure_plate",
                    () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> WALNUT_SLAB = RegisterBlock("walnut_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_STAIRS = RegisterBlock("walnut_stair",
                    () -> new StairBlock(() -> WALNUT_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_FENCE = RegisterBlock("walnut_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_FENCEGATE = RegisterBlock("walnut_fencegate",
                    () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops(), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

            //Apple
            public static final RegistryObject<Block> APPLE_SAPLING = RegisterBlock("apple_sapling",
                    () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> GREEN_APPLE_SAPLING = RegisterBlock("green_apple_sapling",
                    () -> new SaplingBlock(new GreenAppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_LOG = RegisterBlock("apple_log",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> STRIPPED_APPLE_LOG = RegisterBlock("stripped_apple_log",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_WOOD = RegisterBlock("apple_wood",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> STRIPPED_APPLE_WOOD = RegisterBlock("stripped_apple_wood",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_LEAVES = RegisterBlock("apple_leaves",
                    () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> GREEN_APPLE_LEAVES = RegisterBlock("green_apple_leaves",
                    () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_PLANKS = RegisterBlock("apple_planks",
                    () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_DOOR = RegisterBlock("apple_door",
                    () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> APPLE_TRAPDOOR = RegisterBlock("apple_trapdoor",
                    () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> APPLE_BUTTON = RegisterBlock("apple_button",
                    () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).requiresCorrectToolForDrops(), BlockSetType.OAK, 10, true));
            public static final RegistryObject<Block> APPLE_PRESSURE_PLATE = RegisterBlock("apple_pressure_plate",
                    () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> APPLE_SLAB = RegisterBlock("apple_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_STAIRS = RegisterBlock("apple_stair",
                    () -> new StairBlock(() -> APPLE_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_FENCE = RegisterBlock("apple_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_FENCEGATE = RegisterBlock("apple_fencegate",
                    () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops(), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    //Entity blocks
        //Basic furnaces
        public static final RegistryObject<Block> ADOBE_FURNACE = RegisterBlock("adobe_furnace",
                () -> new AdobeFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> SOUL_FURNACE = RegisterBlock("soul_furnace",
                () -> new SoulFurnaceBlock(BlockBehaviour.Properties.copy(ModBlocks.SOUL_MUD.get()).noOcclusion()));

        //Alloy furnaces
        public static final RegistryObject<Block> ADOBE_ALLOYING_FURNACE = RegisterBlock("adobe_alloying_furnace",
                () -> new AdobeAlloyFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> SUPER_ALLOYING_FURNACE = RegisterBlock("super_alloying_furnace",
                () -> new SuperAlloyFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLED_DEEPSLATE).noOcclusion()));
        public static final RegistryObject<Block> SOUL_ALLOY_FURNACE = RegisterBlock("soul_alloy_furnace",
                () -> new SoulAlloyFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).noOcclusion()));

        //Others
        public static final RegistryObject<Block> GEM_POLISHER = RegisterBlock("gem_polisher",
                () -> new GemPolisherBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> GRINDER = RegisterBlock("grinder",
                () -> new GrinderBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));

    //Crops
    public static final RegistryObject<Block> YERBA_MATE_CROP = BLOCKS.register("yerba_mate_crop",
            () -> new YerbaMateCropBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CARROTS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> ZAPALLO_CROP = BLOCKS.register("zapallo_crop",
            () -> new ZapalloCropBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> EGGPLANT_CROP = BLOCKS.register("eggplant_crop",
            () -> new EggplantCropBlock(BlockBehaviour.Properties.copy(ModBlocks.YERBA_MATE_CROP.get()).noOcclusion().noCollission()));
    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
            () -> new TomatoCropBlock(BlockBehaviour.Properties.copy(ModBlocks.YERBA_MATE_CROP.get()).noOcclusion().noCollission()));
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(ModBlocks.YERBA_MATE_CROP.get()).noOcclusion().noCollission()));

    //Block register
    private static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T> block){
        RegistryObject<T> ToReturn = BLOCKS.register(name, block);
        RegisterBlockItem(name, ToReturn);
        return ToReturn;
    }

    //BlockItem register
    private static <T extends Block> RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    //Final register
    public static void Register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

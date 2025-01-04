package com.marmar.enhanced_playthrough.block;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import com.marmar.enhanced_playthrough.block.custom.*;
import com.marmar.enhanced_playthrough.block.custom.crops.*;
import com.marmar.enhanced_playthrough.block.custom.wood.ModLeavesBlock;
import com.marmar.enhanced_playthrough.block.custom.wood.ModLogsBlock;
import com.marmar.enhanced_playthrough.block.custom.wood.ModPlanksBlock;
import com.marmar.enhanced_playthrough.item.ModItems;
import com.marmar.enhanced_playthrough.worldgen.tree.grower.AppleTreeGrower;
import com.marmar.enhanced_playthrough.worldgen.tree.grower.GreenAppleTreeGrower;
import com.marmar.enhanced_playthrough.worldgen.tree.grower.WalnutTreeGrower;
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
            DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedPlaythrough.MOD_ID);

    //Blocks
        //Polished stone
        public static final RegistryObject<Block> POLISHED_STONE = registerBlock("polished_stone",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> POLISHED_STONE_SLAB = registerBlock("polished_stone_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> POLISHED_STONE_STAIRS = registerBlock("polished_stone_stair",
                () -> new StairBlock(() -> ModBlocks.POLISHED_STONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> POLISHED_STONE_WALL = registerBlock("polished_stone_wall",
                () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL)
                        .requiresCorrectToolForDrops()));

        //Limestone
            //cobbled
            public static final RegistryObject<Block> COBBLED_LIMESTONE = registerBlock("cobbeled_limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> COBBLED_LIMESTONE_SLAB = registerBlock("cobbeled_limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> COBBLED_LIMESTONE_STAIRS = registerBlock("cobbeled_limestone_stair",
                    () -> new StairBlock(() -> COBBLED_LIMESTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> COBBLED_LIMESTONE_WALL = registerBlock("cobbeled_limestone_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE_WALL).requiresCorrectToolForDrops()));

            //natural
            public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_SLAB = registerBlock("limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_STAIRS = registerBlock("limestone_stair",
                    () -> new StairBlock(() -> LIMESTONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS).requiresCorrectToolForDrops()));

            //polished
            public static final RegistryObject<Block> POLISHED_LIMESTONE = registerBlock("polished_limestone",
                    () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.POLISHED_STONE.get()).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> POLISHED_LIMESTONE_SLAB = registerBlock("polished_limestone_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> POLISHED_LIMESTONE_STAIRS = registerBlock("polished_limestone_stair",
                    () -> new StairBlock(() -> ModBlocks.POLISHED_LIMESTONE.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> POLISHED_LIMESTONE_WALL = registerBlock("polished_limestone_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));

            //bricks
            public static final RegistryObject<Block> LIMESTONE_BRICKS = registerBlock("limestone_brick",
                    () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICKS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_BRICK_SLAB = registerBlock("limestone_brick_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_BRICK_STAIRS = registerBlock("limestone_brick_stair",
                    () -> new StairBlock(() -> LIMESTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> LIMESTONE_BRICK_WALL = registerBlock("limestone_brick_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));


        //Soul
        public static final RegistryObject<Block> SOUL_MUD = registerBlock("soul_mud",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICKS = registerBlock("soul_mud_brick",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICKS).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICK_SLAB = registerBlock("soul_mud_brick_slab",
                () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_SLAB).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICK_STAIRS = registerBlock("soul_mud_brick_stair",
                () -> new StairBlock(() -> SOUL_MUD_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_STAIRS).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SOUL_MUD_BRICK_WALL = registerBlock("soul_mud_brick_wall",
                () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops()));

        //Ores
        public static final RegistryObject<Block> NETHER_COPPER_ORE = registerBlock("nether_copper_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_ORE).requiresCorrectToolForDrops()));
         public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_IRON_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> NETHER_ZINC_ORE = registerBlock("nether_zinc_ore",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> SULFUR_ORE = registerBlock("sulfur_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIAMOND_ORE)
                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_DIAMOND_ORE)
                    .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> NETHER_SULFUR_ORE = registerBlock("nether_sulfur_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_DIAMOND_ORE)
                    .sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.GOLD_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_GOLD_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> RUBI_ORE = registerBlock("rubi_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.EMERALD_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.EMERALD_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> DEEPSLATE_RUBI_ORE = registerBlock("deepslate_rubi_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE).requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> NETHER_GARNET_ORE = registerBlock("nether_garnet_ore",
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DEEPSLATE_EMERALD_ORE).sound(SoundType.NETHER_ORE).requiresCorrectToolForDrops()));

        //Ores blocks
        public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));
        public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> ZINC_BLOCK = registerBlock("zinc_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> BRASS_BLOCK = registerBlock("brass_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> BRONZIUM_BLOCK = registerBlock("bronzium_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        public static final RegistryObject<Block> GREEN_GOLD_BLOCK = registerBlock("green_gold_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

        //Wood
            //Walnut
            public static final RegistryObject<Block> WALNUT_SAPLING = registerBlock("walnut_sapling",
                    () -> new SaplingBlock(new WalnutTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_LOG = registerBlock("walnut_log",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> STRIPPED_WALNUT_LOG = registerBlock("stripped_walnut_log",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_WOOD = registerBlock("walnut_wood",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> STRIPPED_WALNUT_WOOD = registerBlock("stripped_walnut_wood",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_LEAVES = registerBlock("walnut_leaves",
                    () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_PLANKS = registerBlock("walnut_planks",
                    () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_DOOR = registerBlock("walnut_door",
                    () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> WALNUT_TRAPDOOR = registerBlock("walnut_trapdoor",
                    () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> WALNUT_BUTTON = registerBlock("walnut_button",
                    () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).requiresCorrectToolForDrops(), BlockSetType.OAK, 10, true));
            public static final RegistryObject<Block> WALNUT_PRESSURE_PLATE = registerBlock("walnut_pressure_plate",
                    () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> WALNUT_SLAB = registerBlock("walnut_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_STAIRS = registerBlock("walnut_stair",
                    () -> new StairBlock(() -> WALNUT_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_FENCE = registerBlock("walnut_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> WALNUT_FENCEGATE = registerBlock("walnut_fencegate",
                    () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops(), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

            //Apple
            public static final RegistryObject<Block> APPLE_SAPLING = registerBlock("apple_sapling",
                    () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> GREEN_APPLE_SAPLING = registerBlock("green_apple_sapling",
                    () -> new SaplingBlock(new GreenAppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_LOG = registerBlock("apple_log",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_WOOD = registerBlock("apple_wood",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood",
                    () -> new ModLogsBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_LEAVES = registerBlock("apple_leaves",
                    () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> GREEN_APPLE_LEAVES = registerBlock("green_apple_leaves",
                    () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_PLANKS = registerBlock("apple_planks",
                    () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_DOOR = registerBlock("apple_door",
                    () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> APPLE_TRAPDOOR = registerBlock("apple_trapdoor",
                    () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> APPLE_BUTTON = registerBlock("apple_button",
                    () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).requiresCorrectToolForDrops(), BlockSetType.OAK, 10, true));
            public static final RegistryObject<Block> APPLE_PRESSURE_PLATE = registerBlock("apple_pressure_plate",
                    () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).requiresCorrectToolForDrops(), BlockSetType.OAK));
            public static final RegistryObject<Block> APPLE_SLAB = registerBlock("apple_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_STAIRS = registerBlock("apple_stair",
                    () -> new StairBlock(() -> APPLE_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_FENCE = registerBlock("apple_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops()));
            public static final RegistryObject<Block> APPLE_FENCEGATE = registerBlock("apple_fencegate",
                    () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).requiresCorrectToolForDrops(), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    //Entity blocks
        //Basic furnaces
        public static final RegistryObject<Block> ADOBE_FURNACE = registerBlock("adobe_furnace",
                () -> new AdobeFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> SOUL_FURNACE = registerBlock("soul_furnace",
                () -> new SoulFurnaceBlock(BlockBehaviour.Properties.copy(ModBlocks.SOUL_MUD.get()).noOcclusion()));

        //Alloy furnaces
        public static final RegistryObject<Block> ADOBE_ALLOYING_FURNACE = registerBlock("adobe_alloying_furnace",
                () -> new AdobeAlloyFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> SUPER_ALLOYING_FURNACE = registerBlock("super_alloying_furnace",
                () -> new SuperAlloyFurnaceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLED_DEEPSLATE).noOcclusion()));
        public static final RegistryObject<Block> SOUL_ALLOY_FURNACE = registerBlock("soul_alloy_furnace",
                () -> new SoulAlloyFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE).noOcclusion()));

        //Others
        public static final RegistryObject<Block> GEM_POLISHER = registerBlock("gem_polisher",
                () -> new GemPolisherBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.COBBLESTONE).noOcclusion()));
        public static final RegistryObject<Block> GRINDER = registerBlock("grinder",
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
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
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

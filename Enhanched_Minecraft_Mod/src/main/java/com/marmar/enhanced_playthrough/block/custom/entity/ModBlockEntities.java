package com.marmar.enhanced_playthrough.block.custom.entity;

import com.marmar.enhanced_playthrough.EnhancedPlaythrough;
import com.marmar.enhanced_playthrough.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EnhancedPlaythrough.MOD_ID);

    public static final RegistryObject<BlockEntityType<AdobeFurnaceBlockEntity>> ADOBE_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("adobe_furnace", () -> BlockEntityType
                    .Builder.of(AdobeFurnaceBlockEntity::new,ModBlocks.ADOBE_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<SoulFurnaceBlockEntity>> SOUL_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("soul_furnace", () -> BlockEntityType
                    .Builder.of(SoulFurnaceBlockEntity::new,ModBlocks.SOUL_FURNACE.get()).build(null));


    public static final RegistryObject<BlockEntityType<AdobeAlloyFurnaceBlockEntity>> ADOBE_ALLOYING_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("adobe_alloying_furnace", () -> BlockEntityType
                    .Builder.of(AdobeAlloyFurnaceBlockEntity::new,ModBlocks.ADOBE_ALLOYING_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<SuperAlloyFurnaceBlockEntity>> SUPER_ALLOYING_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("super_alloying_furnace", () -> BlockEntityType
                    .Builder.of(SuperAlloyFurnaceBlockEntity::new,ModBlocks.SUPER_ALLOYING_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<SoulAlloyFurnaceBlockEntity>> SOUL_ALLOY_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("soul_alloy_furnace", () -> BlockEntityType
                    .Builder.of(SoulAlloyFurnaceBlockEntity::new,ModBlocks.SOUL_ALLOY_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<GemPolisherBlockEntity>> GEM_POLISHER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("gem_polisher_block", () -> BlockEntityType
                    .Builder.of(GemPolisherBlockEntity::new,ModBlocks.GEM_POLISHER.get()).build(null));

    public static final RegistryObject<BlockEntityType<GrinderBlockEntity>> ITEM_GRINDER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("item_grinder_block", () -> BlockEntityType
                    .Builder.of(GrinderBlockEntity::new,ModBlocks.GRINDER.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}

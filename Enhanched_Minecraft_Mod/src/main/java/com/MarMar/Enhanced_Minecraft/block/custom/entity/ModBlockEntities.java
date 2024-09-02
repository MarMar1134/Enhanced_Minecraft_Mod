package com.MarMar.Enhanced_Minecraft.block.custom.entity;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> Block_entities =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Enhanced_Minecraft.MOD_ID);
    public static final RegistryObject<BlockEntityType<AdobeFurnaceBlockEntity>> Adobe_furnace =
            Block_entities.register("adobe_furnace", () -> BlockEntityType
                    .Builder.of(AdobeFurnaceBlockEntity::new,ModBlocks.Adobe_furnace.get()).build(null));
    public static final RegistryObject<BlockEntityType<AdobeAlloyingFurnaceBlockEntity>> Adobe_alloying_furnace =
            Block_entities.register("adobe_alloying_furnace", () -> BlockEntityType
                    .Builder.of(AdobeAlloyingFurnaceBlockEntity::new,ModBlocks.Adobe_alloying_furnace.get()).build(null));
    public static final RegistryObject<BlockEntityType<SuperAlloyingFurnaceBlockEntity>> Super_alloying_furnace =
            Block_entities.register("super_alloying_furnace", () -> BlockEntityType
                    .Builder.of(SuperAlloyingFurnaceBlockEntity::new,ModBlocks.Super_alloying_furnace.get()).build(null));
    public static final RegistryObject<BlockEntityType<GemPolisherBlockEntity>> Gem_polisher_block =
            Block_entities.register("gem_polisher_block", () -> BlockEntityType
                    .Builder.of(GemPolisherBlockEntity::new,ModBlocks.Gem_polisher_block.get()).build(null));
    public static final RegistryObject<BlockEntityType<GrinderBlockEntity>> Item_grinder_block =
            Block_entities.register("item_grinder_block", () -> BlockEntityType
                    .Builder.of(GrinderBlockEntity::new,ModBlocks.Item_grinder_block.get()).build(null));

    public static void register(IEventBus eventBus){
        Block_entities.register(eventBus);
    }
}

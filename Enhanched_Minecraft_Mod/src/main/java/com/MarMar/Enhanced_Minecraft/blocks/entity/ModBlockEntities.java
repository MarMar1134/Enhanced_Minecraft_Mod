package com.MarMar.Enhanced_Minecraft.blocks.entity;

import com.MarMar.Enhanced_Minecraft.Enhanced_Minecraft;
import com.MarMar.Enhanced_Minecraft.blocks.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> Block_entities =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Enhanced_Minecraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<AdobeAlloyingFurnaceBlockEntity>> Adobe_alloying_furnace =
            Block_entities.register("adobe_alloying_furnace", () -> BlockEntityType
                    .Builder.of(AdobeAlloyingFurnaceBlockEntity::new,
                    ModBlocks.Adobe_alloying_furnace.get()).build(null));

    public static void register(IEventBus eventBus){
        Block_entities.register(eventBus);
    }
}

package com.MarMar.Enhanced_Minecraft.block.custom;

import com.MarMar.Enhanced_Minecraft.block.custom.entity.ModBlockEntities;
import com.MarMar.Enhanced_Minecraft.block.custom.entity.SoulAlloyFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SoulAlloyFurnaceBlock extends AbstractAlloyFurnaceBlock{
    public SoulAlloyFurnaceBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SoulAlloyFurnaceBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createAlloyFurnaceTicker(pLevel, pBlockEntityType, ModBlockEntities.SOUL_ALLOY_FURNACE_BLOCK_ENTITY.get());
    }
}

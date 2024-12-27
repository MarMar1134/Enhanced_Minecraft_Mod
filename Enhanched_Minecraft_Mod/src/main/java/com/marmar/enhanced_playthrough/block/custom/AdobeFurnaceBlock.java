package com.marmar.enhanced_playthrough.block.custom;

import com.marmar.enhanced_playthrough.block.custom.entity.AdobeFurnaceBlockEntity;
import com.marmar.enhanced_playthrough.block.custom.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class AdobeFurnaceBlock extends AbstractBasicFurnaceBlock {

    public AdobeFurnaceBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new AdobeFurnaceBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return CreateBasicFurnaceTicker(pLevel, pBlockEntityType, ModBlockEntities.ADOBE_FURNACE_BLOCK_ENTITY.get());
    }
}

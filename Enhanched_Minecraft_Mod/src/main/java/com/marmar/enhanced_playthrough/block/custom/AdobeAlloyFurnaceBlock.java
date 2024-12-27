package com.marmar.enhanced_playthrough.block.custom;

import com.marmar.enhanced_playthrough.block.custom.entity.AdobeAlloyFurnaceBlockEntity;
import com.marmar.enhanced_playthrough.block.custom.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class AdobeAlloyFurnaceBlock extends AbstractAlloyFurnaceBlock{

    public AdobeAlloyFurnaceBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new AdobeAlloyFurnaceBlockEntity(blockPos,blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createAlloyFurnaceTicker(pLevel, pBlockEntityType, ModBlockEntities.ADOBE_ALLOYING_FURNACE_BLOCK_ENTITY.get());
    }
}

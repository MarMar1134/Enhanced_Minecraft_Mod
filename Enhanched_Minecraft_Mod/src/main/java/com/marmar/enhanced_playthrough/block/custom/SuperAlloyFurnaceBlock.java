package com.marmar.enhanced_playthrough.block.custom;

import com.marmar.enhanced_playthrough.block.custom.entity.ModBlockEntities;
import com.marmar.enhanced_playthrough.block.custom.entity.SuperAlloyFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SuperAlloyFurnaceBlock extends AbstractAlloyFurnaceBlock{

    public SuperAlloyFurnaceBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SuperAlloyFurnaceBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createAlloyFurnaceTicker(pLevel, pBlockEntityType, ModBlockEntities.SUPER_ALLOYING_FURNACE_BLOCK_ENTITY.get());
    }
}

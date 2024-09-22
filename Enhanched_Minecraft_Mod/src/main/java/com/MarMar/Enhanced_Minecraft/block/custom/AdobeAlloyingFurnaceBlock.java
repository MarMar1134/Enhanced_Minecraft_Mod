package com.MarMar.Enhanced_Minecraft.block.custom;

import com.MarMar.Enhanced_Minecraft.block.custom.entity.AdobeAlloyingFurnaceBlockEntity;
import com.MarMar.Enhanced_Minecraft.block.custom.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class AdobeAlloyingFurnaceBlock extends AbstractAlloyFurnaceBlock{

    public AdobeAlloyingFurnaceBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new AdobeAlloyingFurnaceBlockEntity(blockPos,blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createAlloyFurnaceTicker(pLevel, pBlockEntityType, ModBlockEntities.ADOBE_ALLOYING_FURNACE_BLOCK_ENTITY.get());
    }
}

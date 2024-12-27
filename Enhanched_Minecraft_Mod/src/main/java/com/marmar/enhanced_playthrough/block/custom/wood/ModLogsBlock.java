package com.marmar.enhanced_playthrough.block.custom.wood;

import com.marmar.enhanced_playthrough.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class ModLogsBlock extends RotatedPillarBlock {
    public ModLogsBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem){
            if (state.is(ModBlocks.WALNUT_LOG.get())){
                return ModBlocks.STRIPPED_WALNUT_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.WALNUT_WOOD.get())){
                return ModBlocks.STRIPPED_WALNUT_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.APPLE_LOG.get())){
                return ModBlocks.STRIPPED_APPLE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.APPLE_WOOD.get())){
                return ModBlocks.STRIPPED_APPLE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}

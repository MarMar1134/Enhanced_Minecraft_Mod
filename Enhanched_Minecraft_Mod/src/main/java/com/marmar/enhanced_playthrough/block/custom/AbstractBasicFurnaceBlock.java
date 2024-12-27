package com.marmar.enhanced_playthrough.block.custom;

import com.marmar.enhanced_playthrough.block.custom.entity.AbstractBasicFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;

public abstract class AbstractBasicFurnaceBlock extends BaseEntityBlock implements EntityBlock {
    public static final VoxelShape SHAPE = Block.box(0,0,0, 16,16, 16);
    public static final BooleanProperty BURNING;

    protected AbstractBasicFurnaceBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.SOUTH).setValue(BURNING, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING, BURNING);
    }
    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(BURNING)) {
            double X_position = (double)pPos.getX() + 0.5;
            double Y_position = (double)pPos.getY();
            double Z_position = (double)pPos.getZ() + 0.5;
            if (pRandom.nextDouble() < 0.1) {
                pLevel.playLocalSound(X_position, Y_position, Z_position, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction Face_direction = pState.getValue(FACING);
            Direction.Axis Face_axis = Face_direction.getAxis();
            double random_chance = pRandom.nextDouble() * 0.6 - 0.3;
            double random_X = Face_axis == Direction.Axis.X ? (double)Face_direction.getStepX() * 0.52 : random_chance;
            double random_Y = pRandom.nextDouble() * 6.0 / 16.0;
            double random_Z = Face_axis == Direction.Axis.Z ? (double)Face_direction.getStepZ() * 0.52 : random_chance;
            pLevel.addParticle(ParticleTypes.SMOKE, X_position + random_X, Y_position + random_Y, Z_position + random_Z, 0.0, 0.0, 0.0);
            pLevel.addParticle(ParticleTypes.FLAME, X_position + random_X, Y_position + random_Y, Z_position + random_Z, 0.0, 0.0, 0.0);
        }

    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()){
            BlockEntity entity = pLevel.getBlockEntity(pPos);

            if (entity instanceof AbstractBasicFurnaceBlockEntity){
                ((AbstractBasicFurnaceBlockEntity) entity).Drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()){
            BlockEntity entity = pLevel.getBlockEntity(pPos);

            if (entity instanceof AbstractBasicFurnaceBlockEntity){
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (MenuProvider) entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    public <T extends BlockEntity> BlockEntityTicker<T> CreateBasicFurnaceTicker(Level pLevel, BlockEntityType<T> pServerType, BlockEntityType<? extends AbstractBasicFurnaceBlockEntity> blockEntityType){
        return pLevel.isClientSide ? null : createTickerHelper(pServerType, blockEntityType, AbstractBasicFurnaceBlockEntity::Tick);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    static {
        BURNING = BooleanProperty.create("burning");
    }
}

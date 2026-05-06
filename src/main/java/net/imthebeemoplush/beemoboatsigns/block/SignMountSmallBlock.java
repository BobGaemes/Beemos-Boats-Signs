package net.imthebeemoplush.beemoboatsigns.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SignMountSmallBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public SignMountSmallBlock() {
		super(Properties.of().sound(SoundType.STONE).strength(1f, 10f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.FLOOR).setValue(WATERLOGGED, false));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACE)) {
				case FLOOR -> switch (state.getValue(FACING)) {
					default -> Shapes.or(box(2, 0, 14, 14, 14, 16), box(2, 0, 4, 14, 10, 14));
					case NORTH -> Shapes.or(box(2, 0, 0, 14, 14, 2), box(2, 0, 2, 14, 10, 12));
					case EAST -> Shapes.or(box(14, 0, 2, 16, 14, 14), box(4, 0, 2, 14, 10, 14));
					case WEST -> Shapes.or(box(0, 0, 2, 2, 14, 14), box(2, 0, 2, 12, 10, 14));
				};
				case CEILING -> switch (state.getValue(FACING)) {
					default -> Shapes.or(box(2, 2, 14, 14, 16, 16), box(2, 6, 4, 14, 16, 14));
					case NORTH -> Shapes.or(box(2, 2, 0, 14, 16, 2), box(2, 6, 2, 14, 16, 12));
					case EAST -> Shapes.or(box(14, 2, 2, 16, 16, 14), box(4, 6, 2, 14, 16, 14));
					case WEST -> Shapes.or(box(0, 2, 2, 2, 16, 14), box(2, 6, 2, 12, 16, 14));
				};
				default -> Shapes.block();
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return propagatesSkylightDown(state, worldIn, pos) ? 0 : 1;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, FACE, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		Direction clicked = context.getClickedFace();
		if (clicked == Direction.UP) {
			return super.getStateForPlacement(context)
					.setValue(FACE, AttachFace.FLOOR)
					.setValue(FACING, context.getHorizontalDirection())
					.setValue(WATERLOGGED, flag);
		}
		if (clicked == Direction.DOWN) {
			return super.getStateForPlacement(context)
					.setValue(FACE, AttachFace.CEILING)
					.setValue(FACING, context.getHorizontalDirection())
					.setValue(WATERLOGGED, flag);
		}
		return super.getStateForPlacement(context)
				.setValue(FACE, AttachFace.FLOOR)
				.setValue(FACING, context.getHorizontalDirection())
				.setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}
}
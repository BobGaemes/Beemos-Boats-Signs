package net.imthebeemoplush.beemoboatsigns.init;

import net.imthebeemoplush.beemoboatsigns.block.entity.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;

import net.imthebeemoplush.beemoboatsigns.BeemosBoatSignsMod;

public class BeemosBoatSignsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BeemosBoatSignsMod.MODID);

	public static final RegistryObject<BlockEntityType<MaxSpeedSeawayMarkSmallBlockEntity>> MAX_SPEED_SEAWAY_MARK_SMALL = register("max_speed_seaway_mark_small", BeemosBoatSignsModBlocks.MAX_SPEED_SEAWAY_MARK_SMALL,
			MaxSpeedSeawayMarkSmallBlockEntity::new);
	public static final RegistryObject<BlockEntityType<MaxSpeedSeawayMarkMediumBlockEntity>> MAX_SPEED_SEAWAY_MARK_MEDIUM = register("max_speed_seaway_mark_medium", BeemosBoatSignsModBlocks.MAX_SPEED_SEAWAY_MARK_MEDIUM,
			MaxSpeedSeawayMarkMediumBlockEntity::new);
	public static final RegistryObject<BlockEntityType<MaxSpeedSeawayMarkBigBlockEntity>> MAX_SPEED_SEAWAY_MARK_BIG = register("max_speed_seaway_mark_big", BeemosBoatSignsModBlocks.MAX_SPEED_SEAWAY_MARK_BIG,
			MaxSpeedSeawayMarkBigBlockEntity::new);

	public static final RegistryObject<BlockEntityType<DistanceFromMarkMSeawayMarkSmallBlockEntity>> DISTANCE_FROM_MARK_M_SEAWAY_MARK_SMALL = register("distance_from_mark_m_seaway_mark_small", BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_M_SEAWAY_MARK_SMALL,
			DistanceFromMarkMSeawayMarkSmallBlockEntity::new);
	public static final RegistryObject<BlockEntityType<DistanceFromMarkMSeawayMarkMediumBlockEntity>> DISTANCE_FROM_MARK_M_SEAWAY_MARK_MEDIUM = register("distance_from_mark_m_seaway_mark_medium", BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_M_SEAWAY_MARK_MEDIUM,
			DistanceFromMarkMSeawayMarkMediumBlockEntity::new);
	public static final RegistryObject<BlockEntityType<DistanceFromMarkMSeawayMarkBigBlockEntity>> DISTANCE_FROM_MARK_M_SEAWAY_MARK_BIG = register("distance_from_mark_m_seaway_mark_big", BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_M_SEAWAY_MARK_BIG,
			DistanceFromMarkMSeawayMarkBigBlockEntity::new);

	public static final RegistryObject<BlockEntityType<DistanceFromMarkNMSeawayMarkSmallBlockEntity>> DISTANCE_FROM_MARK_NM_SEAWAY_MARK_SMALL = register("distance_from_mark_nm_seaway_mark_small", BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_NM_SEAWAY_MARK_SMALL,
			DistanceFromMarkNMSeawayMarkSmallBlockEntity::new);
	public static final RegistryObject<BlockEntityType<DistanceFromMarkNMSeawayMarkMediumBlockEntity>> DISTANCE_FROM_MARK_NM_SEAWAY_MARK_MEDIUM = register("distance_from_mark_nm_seaway_mark_medium", BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_NM_SEAWAY_MARK_MEDIUM,
			DistanceFromMarkNMSeawayMarkMediumBlockEntity::new);
	public static final RegistryObject<BlockEntityType<DistanceFromMarkNMSeawayMarkBigBlockEntity>> DISTANCE_FROM_MARK_NM_SEAWAY_MARK_BIG = register("distance_from_mark_nm_seaway_mark_big", BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_NM_SEAWAY_MARK_BIG,
			DistanceFromMarkNMSeawayMarkBigBlockEntity::new);

	public static final RegistryObject<BlockEntityType<DistanceToSeawayMarkSmallBlockEntity>> DISTANCE_TO_SEAWAY_MARK_SMALL = register("distance_to_seaway_mark_small", BeemosBoatSignsModBlocks.DISTANCE_TO_SEAWAY_MARK_SMALL,
			DistanceToSeawayMarkSmallBlockEntity::new);
	public static final RegistryObject<BlockEntityType<DistanceToSeawayMarkMediumBlockEntity>> DISTANCE_TO_SEAWAY_MARK_MEDIUM = register("distance_to_seaway_mark_medium", BeemosBoatSignsModBlocks.DISTANCE_TO_SEAWAY_MARK_MEDIUM,
			DistanceToSeawayMarkMediumBlockEntity::new);
	public static final RegistryObject<BlockEntityType<DistanceToSeawayMarkBigBlockEntity>> DISTANCE_TO_SEAWAY_MARK_BIG = register("distance_to_seaway_mark_big", BeemosBoatSignsModBlocks.DISTANCE_TO_SEAWAY_MARK_BIG,
			DistanceToSeawayMarkBigBlockEntity::new);

	public static final RegistryObject<BlockEntityType<RestrictedHeightSeawayMarkSmallBlockEntity>> RESTRICTED_HEIGHT_SEAWAY_MARK_SMALL = register("restricted_height_seaway_mark_small", BeemosBoatSignsModBlocks.RESTRICTED_HEIGHT_SEAWAY_MARK_SMALL,
			RestrictedHeightSeawayMarkSmallBlockEntity::new);
	public static final RegistryObject<BlockEntityType<RestrictedHeightSeawayMarkMediumBlockEntity>> RESTRICTED_HEIGHT_SEAWAY_MARK_MEDIUM = register("restricted_height_seaway_mark_medium", BeemosBoatSignsModBlocks.RESTRICTED_HEIGHT_SEAWAY_MARK_MEDIUM,
			RestrictedHeightSeawayMarkMediumBlockEntity::new);
	public static final RegistryObject<BlockEntityType<RestrictedHeightSeawayMarkBigBlockEntity>> RESTRICTED_HEIGHT_SEAWAY_MARK_BIG = register("restricted_height_seaway_mark_big", BeemosBoatSignsModBlocks.RESTRICTED_HEIGHT_SEAWAY_MARK_BIG,
			RestrictedHeightSeawayMarkBigBlockEntity::new);

	public static final RegistryObject<BlockEntityType<RestrictedWidthSeawayMarkSmallBlockEntity>> RESTRICTED_WIDTH_SEAWAY_MARK_SMALL = register("restricted_width_seaway_mark_small", BeemosBoatSignsModBlocks.RESTRICTED_WIDTH_SEAWAY_MARK_SMALL,
			RestrictedWidthSeawayMarkSmallBlockEntity::new);
	public static final RegistryObject<BlockEntityType<RestrictedWidthSeawayMarkMediumBlockEntity>> RESTRICTED_WIDTH_SEAWAY_MARK_MEDIUM = register("restricted_width_seaway_mark_medium", BeemosBoatSignsModBlocks.RESTRICTED_WIDTH_SEAWAY_MARK_MEDIUM,
			RestrictedWidthSeawayMarkMediumBlockEntity::new);
	public static final RegistryObject<BlockEntityType<RestrictedWidthSeawayMarkBigBlockEntity>> RESTRICTED_WIDTH_SEAWAY_MARK_BIG = register("restricted_width_seaway_mark_big", BeemosBoatSignsModBlocks.RESTRICTED_WIDTH_SEAWAY_MARK_BIG,
			RestrictedWidthSeawayMarkBigBlockEntity::new);

	public static final RegistryObject<BlockEntityType<RestrictedDepthSeawayMarkSmallBlockEntity>> RESTRICTED_DEPTH_SEAWAY_MARK_SMALL = register("restricted_depth_seaway_mark_small", BeemosBoatSignsModBlocks.RESTRICTED_DEPTH_SEAWAY_MARK_SMALL,
			RestrictedDepthSeawayMarkSmallBlockEntity::new);
	public static final RegistryObject<BlockEntityType<RestrictedDepthSeawayMarkMediumBlockEntity>> RESTRICTED_DEPTH_SEAWAY_MARK_MEDIUM = register("restricted_depth_seaway_mark_medium", BeemosBoatSignsModBlocks.RESTRICTED_DEPTH_SEAWAY_MARK_MEDIUM,
			RestrictedDepthSeawayMarkMediumBlockEntity::new);
	public static final RegistryObject<BlockEntityType<RestrictedDepthSeawayMarkBigBlockEntity>> RESTRICTED_DEPTH_SEAWAY_MARK_BIG = register("restricted_depth_seaway_mark_big", BeemosBoatSignsModBlocks.RESTRICTED_DEPTH_SEAWAY_MARK_BIG,
			RestrictedDepthSeawayMarkBigBlockEntity::new);

	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
package net.imthebeemoplush.beemoboatsigns.init;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.imthebeemoplush.beemoboatsigns.BeemosBoatSignsMod;

public class BeemosBoatSignsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BeemosBoatSignsMod.MODID);

	public static final RegistryObject<CreativeModeTab> ALLOWED_SIGNS = REGISTRY.register("allowed_signs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.beemos_boat_signs.allowed_signs")).icon(() -> new ItemStack(BeemosBoatSignsModBlocks.ANCHORING_ALLOWED_SEAWAY_MARK_BIG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BeemosBoatSignsModBlocks.ANCHORING_ALLOWED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.ANCHORING_ALLOWED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.ANCHORING_ALLOWED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DIVING_ALLOWED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DIVING_ALLOWED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DIVING_ALLOWED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.JET_SKI_ALLOWED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.JET_SKI_ALLOWED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.JET_SKI_ALLOWED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOORING_ALLOWED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOORING_ALLOWED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOORING_ALLOWED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOTORBOAT_ALLOWED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOTORBOAT_ALLOWED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOTORBOAT_ALLOWED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PLEASURE_BOAT_ALLOWED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PLEASURE_BOAT_ALLOWED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PLEASURE_BOAT_ALLOWED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SAILBOATS_ALLOWED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SAILBOATS_ALLOWED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SAILBOATS_ALLOWED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WATER_SKI_ALLOWED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WATER_SKI_ALLOWED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WATER_SKI_ALLOWED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WINDSURFING_ALLOWED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WINDSURFING_ALLOWED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WINDSURFING_ALLOWED_SEAWAY_MARK_BIG.get().asItem());
			}).build());

	public static final RegistryObject<CreativeModeTab> PROHIBITED_SIGNS = REGISTRY.register("prohibited_signs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.beemos_boat_signs.prohibited_signs")).icon(() -> new ItemStack(BeemosBoatSignsModBlocks.ANCHORING_PROHIBITED_SEAWAY_MARK_BIG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BeemosBoatSignsModBlocks.ANCHORING_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.ANCHORING_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.ANCHORING_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DIVING_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DIVING_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DIVING_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.JET_SKI_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.JET_SKI_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.JET_SKI_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.GOING_ASHORE_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.GOING_ASHORE_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.GOING_ASHORE_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOORING_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOORING_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOORING_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOTORBOAT_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOTORBOAT_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOTORBOAT_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PARKING_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PARKING_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PARKING_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PLEASURE_CRAFT_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PLEASURE_CRAFT_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PLEASURE_CRAFT_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SAILBOATS_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SAILBOATS_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SAILBOATS_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SEA_TRAFFIC_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SEA_TRAFFIC_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SEA_TRAFFIC_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WATER_SKI_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WATER_SKI_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WATER_SKI_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WINDSURFING_PROHIBITED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WINDSURFING_PROHIBITED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WINDSURFING_PROHIBITED_SEAWAY_MARK_BIG.get().asItem());
			}).withTabsBefore(ALLOWED_SIGNS.getId()).build());

	public static final RegistryObject<CreativeModeTab> WARNING_SIGNS = REGISTRY.register("warning_signs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.beemos_boat_signs.warning_signs")).icon(() -> new ItemStack(BeemosBoatSignsModBlocks.MAX_SPEED_SEAWAY_MARK_BIG.get())).displayItems((parameters, tabData) -> {

				tabData.accept(BeemosBoatSignsModBlocks.CABLE_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.CABLE_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.CABLE_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PIPE_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PIPE_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.PIPE_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MAX_SPEED_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MAX_SPEED_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MAX_SPEED_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.RESTRICTED_HEIGHT_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.RESTRICTED_HEIGHT_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.RESTRICTED_HEIGHT_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.RESTRICTED_WIDTH_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.RESTRICTED_WIDTH_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.RESTRICTED_WIDTH_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.RESTRICTED_DEPTH_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.RESTRICTED_DEPTH_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.RESTRICTED_DEPTH_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.CABLE_FERRY_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.CABLE_FERRY_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.CABLE_FERRY_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.CONSTRUCTION_ZONE_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.CONSTRUCTION_ZONE_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.CONSTRUCTION_ZONE_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.FISHING_GEAR_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.FISHING_GEAR_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.FISHING_GEAR_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.GIVE_SOUND_SIGNAL_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.GIVE_SOUND_SIGNAL_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.GIVE_SOUND_SIGNAL_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.LIVE_WIRE_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.LIVE_WIRE_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.LIVE_WIRE_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOVEABLE_BRIDGE_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOVEABLE_BRIDGE_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.MOVEABLE_BRIDGE_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.ONE_WAY_TRAFFIC_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.ONE_WAY_TRAFFIC_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.ONE_WAY_TRAFFIC_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.OTHER_HAZARD_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.OTHER_HAZARD_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.OTHER_HAZARD_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.STOP_LINE_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.STOP_LINE_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.STOP_LINE_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SWIMMING_AREA_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SWIMMING_AREA_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SWIMMING_AREA_SEAWAY_MARK_BIG.get().asItem());
			}).withTabsBefore(PROHIBITED_SIGNS.getId()).build());

	public static final RegistryObject<CreativeModeTab> OTHER_SIGNS = REGISTRY.register("other_blocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.beemos_boat_signs.other_blocks")).icon(() -> new ItemStack(BeemosBoatSignsModBlocks.CABLE_SEAWAY_MARK_BIG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BeemosBoatSignsModBlocks.APPLIES_TO_SHIPS_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.APPLIES_TO_SHIPS_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.APPLIES_TO_SHIPS_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DOES_NOT_APPLY_TO_SHIPS_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DOES_NOT_APPLY_TO_SHIPS_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DOES_NOT_APPLY_TO_SHIPS_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.REFER_TO_CHART_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.REFER_TO_CHART_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.REFER_TO_CHART_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_M_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_M_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_M_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_NM_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_NM_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISTANCE_FROM_MARK_NM_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISTANCE_TO_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISTANCE_TO_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISTANCE_TO_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.LEADING_LINE_BOTTOM_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.LEADING_LINE_BOTTOM_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.LEADING_LINE_BOTTOM_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.LEADING_LINE_TOP_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.LEADING_LINE_TOP_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.LEADING_LINE_TOP_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISPOSAL_STATION_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISPOSAL_STATION_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.DISPOSAL_STATION_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SHORE_POWER_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SHORE_POWER_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SHORE_POWER_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WASHING_PLATFORM_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WASHING_PLATFORM_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.WASHING_PLATFORM_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.BOAT_WASHING_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.BOAT_WASHING_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.BOAT_WASHING_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.NO_WAKE_SEAWAY_MARK_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.NO_WAKE_SEAWAY_MARK_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.NO_WAKE_SEAWAY_MARK_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SIGN_MOUNT_BASE_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SIGN_MOUNT_BASE_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SIGN_MOUNT_BASE_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SIGN_MOUNT_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SIGN_MOUNT_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.SIGN_MOUNT_BIG.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.THIN_SIGN_MOUNT_SMALL.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.THIN_SIGN_MOUNT_MEDIUM.get().asItem());
				tabData.accept(BeemosBoatSignsModBlocks.THIN_SIGN_MOUNT_BIG.get().asItem());

			}).withTabsBefore(WARNING_SIGNS.getId()).build());
}
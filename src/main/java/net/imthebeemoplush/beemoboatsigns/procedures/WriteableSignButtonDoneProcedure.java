package net.imthebeemoplush.beemoboatsigns.procedures;

import net.imthebeemoplush.beemoboatsigns.block.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.imthebeemoplush.beemoboatsigns.init.BeemosBoatSignsModMenus;

public class WriteableSignButtonDoneProcedure {
	public static void execute(Entity entity, Level level, int x, int y, int z) {
		if (entity == null)
			return;

		if (entity instanceof Player _entity0) {
			String textVar = "";
			textVar = (_entity0.containerMenu instanceof BeemosBoatSignsModMenus.MenuAccessor _menu0)
					? _menu0.getMenuState(0, "writeablesigninput", "")
					: "";

			BlockPos pos = new BlockPos(x, y, z);
			BlockEntity be = level.getBlockEntity(pos);

			// MAX SPEED SIGN
			if (be instanceof MaxSpeedSeawayMarkSmallBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof MaxSpeedSeawayMarkMediumBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof MaxSpeedSeawayMarkBigBlockEntity signBE) {
				signBE.setCustomText(textVar);
			}

			// DISTANCE FROM MARK METER SIGN
			else if (be instanceof DistanceFromMarkMSeawayMarkSmallBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof DistanceFromMarkMSeawayMarkMediumBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof DistanceFromMarkMSeawayMarkBigBlockEntity signBE) {
				signBE.setCustomText(textVar);
			}

			// DISTANCE FROM MARK NAUTICAL METER SIGN
			else if (be instanceof DistanceFromMarkNMSeawayMarkSmallBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof DistanceFromMarkNMSeawayMarkMediumBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof DistanceFromMarkNMSeawayMarkBigBlockEntity signBE) {
				signBE.setCustomText(textVar);

			}

			// DISTANCE FROM MARK NAUTICAL METER SIGN
			else if (be instanceof DistanceToSeawayMarkSmallBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof DistanceToSeawayMarkMediumBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof DistanceToSeawayMarkBigBlockEntity signBE) {
				signBE.setCustomText(textVar);

			}

			// RESTRICTED HEIGHT SIGN
			else if (be instanceof RestrictedHeightSeawayMarkSmallBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof RestrictedHeightSeawayMarkMediumBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof RestrictedHeightSeawayMarkBigBlockEntity signBE) {
				signBE.setCustomText(textVar);

			}

			// RESTRICTED WIDTH SIGN
			else if (be instanceof RestrictedWidthSeawayMarkSmallBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof RestrictedWidthSeawayMarkMediumBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof RestrictedWidthSeawayMarkBigBlockEntity signBE) {
				signBE.setCustomText(textVar);

			}

			// RESTRICTED DEPTH SIGN
			else if (be instanceof RestrictedDepthSeawayMarkSmallBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof RestrictedDepthSeawayMarkMediumBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else if (be instanceof RestrictedDepthSeawayMarkBigBlockEntity signBE) {
				signBE.setCustomText(textVar);

			} else {
				return;
			}
			_entity0.closeContainer();
		}
	}
}
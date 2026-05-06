package net.imthebeemoplush.beemoboatsigns.client.gui;

import net.imthebeemoplush.beemoboatsigns.block.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.imthebeemoplush.beemoboatsigns.world.inventory.WritableSignMenu;
import net.imthebeemoplush.beemoboatsigns.network.WritableSignButtonMessage;
import net.imthebeemoplush.beemoboatsigns.init.BeemosBoatSignsModScreens;
import net.imthebeemoplush.beemoboatsigns.BeemosBoatSignsMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class WritableSignScreen extends AbstractContainerScreen<WritableSignMenu> implements BeemosBoatSignsModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox writeablesigninput;
	private Button button_done;

	public WritableSignScreen(WritableSignMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 128;
		this.imageHeight = 64;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("writeablesigninput"))
				writeablesigninput.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		writeablesigninput.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (writeablesigninput.isFocused())
			return writeablesigninput.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String writeablesigninputValue = writeablesigninput.getValue();
		super.resize(minecraft, width, height);
		writeablesigninput.setValue(writeablesigninputValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		writeablesigninput = new EditBox(this.font, this.leftPos + 5, this.topPos + 11, 118, 18, Component.translatable("gui.beemos_boat_signs.writable_sign.writeablesigninput"));

		writeablesigninput.setMaxLength(4);
		writeablesigninput.setFilter(s -> s.matches("[0-9,]*"));

		writeablesigninput.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "writeablesigninput", content, false);
		});
		writeablesigninput.setHint(Component.translatable("gui.beemos_boat_signs.writable_sign.writeablesigninput"));
		this.addWidget(this.writeablesigninput);
		button_done = Button.builder(Component.translatable("gui.beemos_boat_signs.writable_sign.button_done"), e -> {
			int x = WritableSignScreen.this.x;
			int y = WritableSignScreen.this.y;
			if (true) {
				BeemosBoatSignsMod.PACKET_HANDLER.sendToServer(new WritableSignButtonMessage(0, x, y, z));
				WritableSignButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 40, this.topPos + 37, 45, 20).build();
		this.addRenderableWidget(button_done);

		Level level = entity.level();
		BlockPos pos = new BlockPos(x, y, z);
		BlockEntity be = level.getBlockEntity(pos);

		// MAX SPEED SIGN
		if (be instanceof MaxSpeedSeawayMarkSmallBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof MaxSpeedSeawayMarkMediumBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof MaxSpeedSeawayMarkBigBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		}

		// DISTANCE FROM MARK METERS SIGN
		else if (be instanceof DistanceFromMarkMSeawayMarkSmallBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof DistanceFromMarkMSeawayMarkMediumBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof DistanceFromMarkMSeawayMarkBigBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		}

		// DISTANCE FROM MARK NAUTICAL MILES SIGN
		else if (be instanceof DistanceFromMarkNMSeawayMarkSmallBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof DistanceFromMarkNMSeawayMarkMediumBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof DistanceFromMarkNMSeawayMarkBigBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		}

		// DISTANCE TO SIGN
		else if (be instanceof DistanceToSeawayMarkSmallBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof DistanceToSeawayMarkMediumBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof DistanceToSeawayMarkBigBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		}

		// RESTRICTED HEIGHT SIGN
		else if (be instanceof RestrictedHeightSeawayMarkSmallBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof RestrictedHeightSeawayMarkMediumBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof RestrictedHeightSeawayMarkBigBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		}

		// RESTRICTED WIDTH SIGN
		else if (be instanceof RestrictedWidthSeawayMarkSmallBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof RestrictedWidthSeawayMarkMediumBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof RestrictedWidthSeawayMarkBigBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		}

		// RESTRICTED DEPTH SIGN
		else if (be instanceof RestrictedDepthSeawayMarkSmallBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof RestrictedDepthSeawayMarkMediumBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		} else if (be instanceof RestrictedDepthSeawayMarkBigBlockEntity signBE) {
			writeablesigninput.setValue(signBE.getCustomText());
		}
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		writeablesigninput.tick();
	}
}
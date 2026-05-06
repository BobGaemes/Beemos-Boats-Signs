package net.imthebeemoplush.beemoboatsigns.renders;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.imthebeemoplush.beemoboatsigns.block.DistanceFromMarkMSeawayMarkBigBlock;
import net.imthebeemoplush.beemoboatsigns.block.entity.DistanceFromMarkMSeawayMarkBigBlockEntity;
import net.imthebeemoplush.beemoboatsigns.client.gui.ClientFontHelper;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;

public class DistanceFromMarkMSeawayMarkBigRenderer implements BlockEntityRenderer<DistanceFromMarkMSeawayMarkBigBlockEntity> {

    private final Font font;

    private static final java.util.Map<Character, Float> CHAR_WIDTHS = new java.util.HashMap<>();

    static {
        CHAR_WIDTHS.put('0', 11.25f);
        CHAR_WIDTHS.put('1', 8f);
        CHAR_WIDTHS.put('2', 10.7f);
        CHAR_WIDTHS.put('3', 10.25f);
        CHAR_WIDTHS.put('4', 10.5f);
        CHAR_WIDTHS.put('5', 10f);
        CHAR_WIDTHS.put('6', 10.6f);
        CHAR_WIDTHS.put('7', 10.1f);
        CHAR_WIDTHS.put('8', 10.45f);
        CHAR_WIDTHS.put('9', 10.6f);
        CHAR_WIDTHS.put(',', 6.5f);
    }

    public DistanceFromMarkMSeawayMarkBigRenderer(BlockEntityRendererProvider.Context context) {
        this.font = context.getFont();
    }

    @Override
    public void render(DistanceFromMarkMSeawayMarkBigBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {

        BlockState state = blockEntity.getBlockState();
        AttachFace face = state.getValue(DistanceFromMarkMSeawayMarkBigBlock.FACE);
        Direction facing = state.getValue(DistanceFromMarkMSeawayMarkBigBlock.FACING);

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);

        float yRot = switch (facing) {
            case NORTH -> 0;
            case EAST -> 90;
            case SOUTH -> 180;
            case WEST -> 270;
            default -> 0;
        };
        poseStack.mulPose(Axis.YP.rotationDegrees(-yRot));

        switch (face) {
            case FLOOR -> poseStack.mulPose(Axis.XP.rotationDegrees(-90));
            case WALL -> poseStack.mulPose(Axis.YP.rotationDegrees(180));
            case CEILING -> poseStack.mulPose(Axis.XP.rotationDegrees(90));
        }

        poseStack.translate(0, 0, -0.421);
        poseStack.scale(0.048f, -0.048f, 0.048f);

        poseStack.translate(-19.5, 1.8, 0);
        font.drawInBatch(
                Component.literal("0")
                        .withStyle(Style.EMPTY.withFont(ClientFontHelper.TRATEX_FONT_ID))
                        .getVisualOrderText(),
                0, 0, 0x1A171B, false,
                poseStack.last().pose(), buffer, Font.DisplayMode.NORMAL, 0, combinedLight
        );

        poseStack.translate(10, 0, 0);
        font.drawInBatch(
                Component.literal("-")
                        .withStyle(Style.EMPTY.withFont(ClientFontHelper.TRATEX_FONT_ID))
                        .getVisualOrderText(),
                0, 0, 0x1A171B, false,
                poseStack.last().pose(), buffer, Font.DisplayMode.NORMAL, 0, combinedLight
        );

        poseStack.translate(-10, 9.75, 0);

        String text = blockEntity.getCustomText();
        if (!(text == null || text.isEmpty())) {
            if (text.length() == 4) text = text.substring(0, 3);
            text = text.replaceAll(",", "");

            font.drawInBatch(
                    Component.literal(text)
                            .withStyle(Style.EMPTY.withFont(ClientFontHelper.TRATEX_FONT_ID))
                            .getVisualOrderText(),
                    0, 0, 0x1A171B, false,
                    poseStack.last().pose(), buffer, Font.DisplayMode.NORMAL, 0, combinedLight
            );
        }

        font.drawInBatch(
                Component.literal(text)
                        .withStyle(Style.EMPTY.withFont(ClientFontHelper.TRATEX_FONT_ID))
                        .getVisualOrderText(),
                0, 0, 0x1A171B, false,
                poseStack.last().pose(), buffer, Font.DisplayMode.NORMAL, 0, combinedLight
        );

        poseStack.translate(26.75, 0, 0);
        font.drawInBatch(
                Component.literal("m")
                        .withStyle(Style.EMPTY.withFont(ClientFontHelper.TRATEX_FONT_ID))
                        .getVisualOrderText(),
                0, 0, 0x1A171B, false,
                poseStack.last().pose(), buffer, Font.DisplayMode.NORMAL, 0, combinedLight
        );

        poseStack.popPose();
    }
}
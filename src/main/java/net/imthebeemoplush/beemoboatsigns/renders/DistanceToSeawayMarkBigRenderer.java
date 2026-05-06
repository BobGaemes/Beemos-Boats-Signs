package net.imthebeemoplush.beemoboatsigns.renders;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.imthebeemoplush.beemoboatsigns.block.DistanceToSeawayMarkBigBlock;
import net.imthebeemoplush.beemoboatsigns.block.DistanceToSeawayMarkSmallBlock;
import net.imthebeemoplush.beemoboatsigns.block.entity.DistanceToSeawayMarkBigBlockEntity;
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

public class DistanceToSeawayMarkBigRenderer implements BlockEntityRenderer<DistanceToSeawayMarkBigBlockEntity> {

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

    public DistanceToSeawayMarkBigRenderer(BlockEntityRendererProvider.Context context) {
        this.font = context.getFont();
    }

    @Override
    public void render(DistanceToSeawayMarkBigBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        String text = blockEntity.getCustomText();
        if (text == null || text.isEmpty()) return;
        text = text.replaceAll(",", "");

        BlockState state = blockEntity.getBlockState();
        AttachFace face = state.getValue(DistanceToSeawayMarkSmallBlock.FACE);
        Direction facing = state.getValue(DistanceToSeawayMarkSmallBlock.FACING);

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);

        float yRot = switch (facing) {
            case NORTH -> 0;
            case EAST  -> 90;
            case SOUTH -> 180;
            case WEST  -> 270;
            default    -> 0;
        };
        poseStack.mulPose(Axis.YP.rotationDegrees(-yRot));

        switch (face) {
            case FLOOR -> poseStack.mulPose(Axis.XP.rotationDegrees(-90));
            case WALL -> poseStack.mulPose(Axis.YP.rotationDegrees(180));
            case CEILING -> poseStack.mulPose(Axis.XP.rotationDegrees(90));
        }

        float yOffset = switch (text.length()) {
            case 1 -> 6.3f;
            case 2 -> 7.8f;
            case 3 -> 10.25f;
            default -> 13f;
        };
        float yPosUnit = switch (text.length()) {
            case 1 -> 5.25f;
            case 2 -> 7.5f;
            case 3 -> 11f;
            default -> 14.75f;
        };
        float decimalOffset = switch (text.length()) {
            case 1 -> -1f;
            case 2 -> 0f;
            case 3 -> 1f;
            default -> 1.8f;
        };
        float decimalXOffset = switch (text.length()) {
            case 1 -> -4f;
            case 2 -> -7f;
            case 3 -> -9.5f;
            default -> -12f;
        };
        float scale = switch (text.length()) {
            case 1 -> 0.1f;
            case 2 -> 0.075f;
            case 3 -> 0.053f;
            default -> 0.04f;
        };

        poseStack.translate(0, 0, -0.421);

        float yCenter = -font.lineHeight / 2f;
        float decimalScale = 0.7f;
        float wholeWidth = 0f;
        for (char c : text.toCharArray()) wholeWidth += CHAR_WIDTHS.getOrDefault(c, 8f);
        float commaWidth = CHAR_WIDTHS.getOrDefault(',', 6.5f) * decimalScale;
        float totalWidth = wholeWidth + commaWidth;
        float startX = -totalWidth / 2f + decimalOffset;

        // Draw whole number at full scale
        poseStack.pushPose();
        poseStack.scale(scale, -scale, scale);
        poseStack.translate(startX, yCenter + yOffset, 0);
        font.drawInBatch(Component.literal(text)
                        .withStyle(Style.EMPTY.withFont(ClientFontHelper.TRATEX_FONT_ID))
                        .getVisualOrderText(), 0, 0, 0x1A171B, false,
                poseStack.last().pose(), buffer, Font.DisplayMode.SEE_THROUGH, 0, combinedLight);
        poseStack.popPose();

        // Draw comma + decimal at smaller scale
        poseStack.pushPose();
        float smallScale = scale * decimalScale;
        poseStack.scale(smallScale, -smallScale, smallScale);
        poseStack.translate((startX + wholeWidth) / decimalScale + decimalXOffset, yPosUnit, 0);
        font.drawInBatch(Component.literal("m")
                        .withStyle(Style.EMPTY.withFont(ClientFontHelper.TRATEX_FONT_ID))
                        .getVisualOrderText(), 0, 0, 0x1A171B, false,
                poseStack.last().pose(), buffer, Font.DisplayMode.SEE_THROUGH, 0, combinedLight);
        poseStack.popPose();

        poseStack.popPose();
    }
}
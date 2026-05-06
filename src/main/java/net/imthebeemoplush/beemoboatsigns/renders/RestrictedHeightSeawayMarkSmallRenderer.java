package net.imthebeemoplush.beemoboatsigns.renders;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.imthebeemoplush.beemoboatsigns.block.RestrictedHeightSeawayMarkSmallBlock;
import net.imthebeemoplush.beemoboatsigns.block.entity.RestrictedHeightSeawayMarkSmallBlockEntity;
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

public class RestrictedHeightSeawayMarkSmallRenderer implements BlockEntityRenderer<RestrictedHeightSeawayMarkSmallBlockEntity> {

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

    public RestrictedHeightSeawayMarkSmallRenderer(BlockEntityRendererProvider.Context context) {
        this.font = context.getFont();
    }

    @Override
    public void render(RestrictedHeightSeawayMarkSmallBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        String text = blockEntity.getCustomText();
        if (text == null || text.isEmpty()) return;

        BlockState state = blockEntity.getBlockState();
        AttachFace face = state.getValue(RestrictedHeightSeawayMarkSmallBlock.FACE);
        Direction facing = state.getValue(RestrictedHeightSeawayMarkSmallBlock.FACING);

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

        poseStack.translate(0, 0, -0.421);
        float yCenter = -font.lineHeight / 2f + 1.8f;

        if (text.contains(",")) {
            String[] parts = text.split(",");
            String whole = parts[0];
            String decimal = parts.length > 1 ? parts[1] : "";
            float decimalScale = 0.7f;

            float wholeWidth = 0f;
            for (char c : whole.toCharArray()) wholeWidth += CHAR_WIDTHS.getOrDefault(c, 8f);
            float commaWidth = CHAR_WIDTHS.getOrDefault(',', 6.5f) * decimalScale;
            float decimalWidth = 0f;
            for (char c : decimal.toCharArray()) decimalWidth += CHAR_WIDTHS.getOrDefault(c, 8f) * decimalScale;

            float decimalOffset = text.length() == 3 ? 2.1f : 3.8f;
            float decimalXOffset = text.length() == 3 ? -4f : -9f;
            float totalWidth = wholeWidth + commaWidth + decimalWidth;
            float startX = -totalWidth / 2f + decimalOffset;

            // Dynamic scale
            float targetWidth = 31.375f;
            float scale = Math.min(targetWidth / totalWidth * 0.035f, 0.08f);

            // Draw whole number at full scale
            poseStack.pushPose();
            poseStack.scale(scale, -scale, scale);
            poseStack.translate(startX, yCenter, 0);
            font.drawInBatch(Component.literal(whole)
                            .withStyle(Style.EMPTY.withFont(ClientFontHelper.TRATEX_FONT_ID))
                            .getVisualOrderText(), 0, 0, 0x1A171B, false,
                    poseStack.last().pose(), buffer, Font.DisplayMode.SEE_THROUGH, 0, combinedLight);
            poseStack.popPose();

            // Draw comma + decimal at smaller scale
            poseStack.pushPose();
            float smallScale = scale * decimalScale;
            poseStack.scale(smallScale, -smallScale, smallScale);
            poseStack.translate((startX + wholeWidth) / decimalScale + decimalXOffset, -1.2f, 0);
            font.drawInBatch(Component.literal("," + decimal)
                            .withStyle(Style.EMPTY.withFont(ClientFontHelper.TRATEX_FONT_ID))
                            .getVisualOrderText(), 0, 0, 0x1A171B, false,
                    poseStack.last().pose(), buffer, Font.DisplayMode.SEE_THROUGH, 0, combinedLight);
            poseStack.popPose();

        } else {

            float offset = switch (text.length()) {
                case 1 -> 0f;
                case 2 -> 1.4f;
                case 3 -> 2.75f;
                default -> 4.1f;
            };

            float measuredWidth = 0f;
            for (char c : text.toCharArray()) measuredWidth += CHAR_WIDTHS.getOrDefault(c, 8f);

            // Dynamic scale
            float targetWidth = 45f;
            float scale = Math.min(targetWidth / measuredWidth * 0.024f, 0.07f);

            // Non-decimal rendering
            poseStack.scale(scale, -scale, scale);

            poseStack.translate(-measuredWidth / 2f + offset, yCenter, 0);

            font.drawInBatch(
                    Component.literal(text)
                            .withStyle(Style.EMPTY.withFont(ClientFontHelper.TRATEX_FONT_ID))
                            .getVisualOrderText(),
                    0, 0, 0x1A171B, false,
                    poseStack.last().pose(), buffer, Font.DisplayMode.SEE_THROUGH, 0, combinedLight
            );
        }

        poseStack.popPose();
    }
}
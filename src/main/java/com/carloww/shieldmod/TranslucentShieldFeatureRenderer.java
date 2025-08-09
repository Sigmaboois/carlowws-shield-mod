package com.carloww.shieldmod;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.MinecraftClient;

public class TranslucentShieldFeatureRenderer
        extends net.minecraft.client.render.entity.feature.FeatureRenderer<PlayerEntity, net.minecraft.client.render.entity.model.PlayerEntityModel<PlayerEntity>> {

    public TranslucentShieldFeatureRenderer(net.minecraft.client.render.entity.feature.FeatureRendererContext<PlayerEntity, net.minecraft.client.render.entity.model.PlayerEntityModel<PlayerEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, PlayerEntity player,
                       float limbAngle, float limbDistance, float tickDelta, float customAngle, float headYaw, float headPitch) {

        ItemStack offHand = player.getOffHandStack();
        if (offHand.isOf(Items.SHIELD)) {
            int cooldown = player.getItemCooldownManager().getCooldown(Items.SHIELD, 0);
            float alpha = cooldown > 0 ? 0.4f : 1.0f;

            matrices.push();
            MinecraftClient.getInstance().getItemRenderer().renderItem(
                player,
                offHand,
                ModelTransformationMode.FIXED,
                false,
                matrices,
                vertexConsumers,
                player.getWorld(),
                light,
                0,
                player.getId()
            );
            matrices.pop();
        }
    }
}

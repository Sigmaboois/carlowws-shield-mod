package com.carloww.shieldmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.entity.PlayerEntityRenderer;

public class CarlowwsShieldMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, renderer, helper) -> {
            if (renderer instanceof PlayerEntityRenderer playerRenderer) {
                helper.register(new TranslucentShieldFeatureRenderer(playerRenderer));
            }
        });
    }
}

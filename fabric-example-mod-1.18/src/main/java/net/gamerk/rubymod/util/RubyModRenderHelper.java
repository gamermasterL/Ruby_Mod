package net.gamerk.rubymod.util;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.gamerk.rubymod.Blocks.init.ModBlock3;
import net.minecraft.client.render.RenderLayer;

public class RubyModRenderHelper {
    public static void setRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock3.CHERRY_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlock3.CHERRY_SAPLING, RenderLayer.getCutout());
    }
}

package fakezircon.classidyes;

import fakezircon.classidyes.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class ClassidyesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        setRenderLayerFlowers(ModBlocks.AQUAMARINE_HYDRANGEA);
        setRenderLayerFlowers(ModBlocks.POTTED_AQUAMARINE_HYDRANGEA);
        setRenderLayerFlowers(ModBlocks.BLUE_HEAD_GILLA);
        setRenderLayerFlowers(ModBlocks.POTTED_BLUE_HEAD_GILLA);
        setRenderLayerFlowers(ModBlocks.BLUE_ORCHID);
        setRenderLayerFlowers(ModBlocks.POTTED_BLUE_ORCHID);
        setRenderLayerFlowers(ModBlocks.BLUE_STAR);
        setRenderLayerFlowers(ModBlocks.POTTED_BLUE_STAR);
        setRenderLayerFlowers(ModBlocks.CORAL_CHARM);
        setRenderLayerFlowers(ModBlocks.POTTED_CORAL_CHARM);
        setRenderLayerFlowers(ModBlocks.COSMOS);
        setRenderLayerFlowers(ModBlocks.POTTED_COSMOS);
        setRenderLayerFlowers(ModBlocks.CREMON);
        setRenderLayerFlowers(ModBlocks.POTTED_CREMON);
        setRenderLayerFlowers(ModBlocks.CROCUS);
        setRenderLayerFlowers(ModBlocks.POTTED_CROCUS);
        setRenderLayerFlowers(ModBlocks.GREEN_ORCHID);
        setRenderLayerFlowers(ModBlocks.POTTED_GREEN_ORCHID);
        setRenderLayerFlowers(ModBlocks.HYDRANGEA);
        setRenderLayerFlowers(ModBlocks.POTTED_HYDRANGEA);
        setRenderLayerFlowers(ModBlocks.ROSE);
        setRenderLayerFlowers(ModBlocks.POTTED_ROSE);
        setRenderLayerFlowers(ModBlocks.SWEET_WILLIAM);
        setRenderLayerFlowers(ModBlocks.POTTED_SWEET_WILLIAM);
        setRenderLayerFlowers(ModBlocks.VIBURNUM);
        setRenderLayerFlowers(ModBlocks.POTTED_VIBURNUM);
        setRenderLayerFlowers(ModBlocks.WHITE_CALLA_LILY);
        setRenderLayerFlowers(ModBlocks.POTTED_WHITE_CALLA_LILY);
        setRenderLayerFlowers(ModBlocks.WHITE_CAMELLIA);
        setRenderLayerFlowers(ModBlocks.POTTED_WHITE_CAMELLIA);
        setRenderLayerFlowers(ModBlocks.YARROW);
        setRenderLayerFlowers(ModBlocks.POTTED_YARROW);
    }

    public void setRenderLayerFlowers(Block flower) {
        BlockRenderLayerMap.INSTANCE.putBlock(flower, RenderLayer.getCutout());
    }
}
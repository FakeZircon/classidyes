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
	}

	public void setRenderLayerFlowers(Block flower){
		BlockRenderLayerMap.INSTANCE.putBlock(flower, RenderLayer.getCutout());
	}
}
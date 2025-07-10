package fakezircon.classidyes;

import fakezircon.classidyes.block.ModBlocks;
import fakezircon.classidyes.item.ModItemGroup;
import fakezircon.classidyes.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Classidyes implements ModInitializer {
	public static final String MOD_ID = "classidyes";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.initialize();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello Fabric world!");
	}
}
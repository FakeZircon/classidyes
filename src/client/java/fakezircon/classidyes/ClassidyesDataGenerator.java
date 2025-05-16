package fakezircon.classidyes;

import fakezircon.classidyes.block.ModBlocks;
import fakezircon.classidyes.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ClassidyesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(BlockLootGen::new);
		pack.addProvider(ClassidyesCALangProvider::new);
		pack.addProvider(ClassidyesUSLangProvider::new);
	}

	public static class ModelGenerator extends FabricModelProvider {
		public ModelGenerator(FabricDataOutput output) {
			super(output);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.AQUAMARINE_HYDRANGEA, ModBlocks.POTTED_AQUAMARINE_HYDRANGEA, BlockStateModelGenerator.TintType.NOT_TINTED);
			blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BLUE_HEAD_GILLA, ModBlocks.POTTED_BLUE_HEAD_GILLA, BlockStateModelGenerator.TintType.NOT_TINTED);
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			itemModelGenerator.register(ModItems.TEST, Models.GENERATED);
		}
	}

	public static class BlockLootGen extends FabricBlockLootTableProvider {
		public BlockLootGen(FabricDataOutput dataOutput){
			super(dataOutput);
		}

		@Override
		public void generate(){
			addDrop(ModBlocks.AQUAMARINE_HYDRANGEA);
			addPottedPlantDrops(ModBlocks.POTTED_AQUAMARINE_HYDRANGEA);
			addDrop(ModBlocks.BLUE_HEAD_GILLA);
			addPottedPlantDrops(ModBlocks.POTTED_BLUE_HEAD_GILLA);
		}
	}

	public static class ClassidyesCALangProvider extends FabricLanguageProvider {
		private ClassidyesCALangProvider(FabricDataOutput dataGenerator){
			super(dataGenerator, "en_ca");
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder){
			translationHelper(translationBuilder);
		}
	}

	public static class ClassidyesUSLangProvider extends FabricLanguageProvider {
		private ClassidyesUSLangProvider(FabricDataOutput dataGenerator){
			super(dataGenerator, "en_us");
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder){
			translationHelper(translationBuilder);
		}
	}

	//translation for both en_ca and en_us
	public static void translationHelper(FabricLanguageProvider.TranslationBuilder transBuilder){
		transBuilder.add(ModItems.TEST, "Test Item");
		transBuilder.add(ModBlocks.AQUAMARINE_HYDRANGEA.getTranslationKey(), "Aquamarine Hydrangea");
		transBuilder.add(ModBlocks.POTTED_AQUAMARINE_HYDRANGEA.getTranslationKey(), "Potted Aquamarine Hydrangea");
		transBuilder.add(ModBlocks.BLUE_HEAD_GILLA.getTranslationKey(), "Blue Head Gilla");
		transBuilder.add(ModBlocks.POTTED_BLUE_HEAD_GILLA.getTranslationKey(), "Potted Blue Head Gilla");
	}
}

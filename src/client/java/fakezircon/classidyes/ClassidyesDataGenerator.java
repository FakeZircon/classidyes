package fakezircon.classidyes;

import fakezircon.classidyes.block.ModBlocks;
import fakezircon.classidyes.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
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
		pack.addProvider(ClassidyesCALangProvider::new);
		pack.addProvider(ClassidyesUSLangProvider::new);
	}

	public static class ModelGenerator extends FabricModelProvider {
		public ModelGenerator(FabricDataOutput output) {
			super(output);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.TEST_BLOCK, ModBlocks.POTTED_TEST_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED);
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			itemModelGenerator.register(ModItems.TEST, Models.GENERATED);
		}
	}

	public static class ClassidyesCALangProvider extends FabricLanguageProvider {
		private ClassidyesCALangProvider(FabricDataOutput dataGenerator){
			super(dataGenerator, "en_ca");
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder){
			translationBuilder.add("item."+Classidyes.MOD_ID + ".test", "Test Item");
			translationBuilder.add("block."+Classidyes.MOD_ID + ".test_block", "Test Block");
			translationBuilder.add("block."+Classidyes.MOD_ID + ".potted_test_block", "Potted Test Block");
		}
	}

	public static class ClassidyesUSLangProvider extends FabricLanguageProvider {
		private ClassidyesUSLangProvider(FabricDataOutput dataGenerator){
			super(dataGenerator, "en_us");
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder){
			translationBuilder.add("item."+Classidyes.MOD_ID + ".test", "Test Item");
			translationBuilder.add("block."+Classidyes.MOD_ID + ".test_block", "Test Block");
			translationBuilder.add("block."+Classidyes.MOD_ID + ".potted_test_block", "Potted Test Block");
		}
	}
}

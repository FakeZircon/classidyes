package fakezircon.classidyes;

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
			// ...
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
		}
	}

	public static class ClassidyesUSLangProvider extends FabricLanguageProvider {
		private ClassidyesUSLangProvider(FabricDataOutput dataGenerator){
			super(dataGenerator, "en_us");
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder){
			translationBuilder.add("item."+Classidyes.MOD_ID + ".test", "Test Item");
		}
	}
}

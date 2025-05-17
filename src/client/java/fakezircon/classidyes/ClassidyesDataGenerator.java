package fakezircon.classidyes;

import fakezircon.classidyes.block.ModBlocks;
import fakezircon.classidyes.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ClassidyesDataGenerator implements DataGeneratorEntrypoint {
    //list of flowers
    static Block[] flowerList = {ModBlocks.ROSE, ModBlocks.CREMON, ModBlocks.YARROW, ModBlocks.VIBURNUM, ModBlocks.GREEN_ORCHID,
            ModBlocks.AQUAMARINE_HYDRANGEA, ModBlocks.BLUE_STAR, ModBlocks.BLUE_ORCHID, ModBlocks.BLUE_HEAD_GILLA, ModBlocks.COSMOS, ModBlocks.CROCUS,
            ModBlocks.SWEET_WILLIAM, ModBlocks.CORAL_CHARM, ModBlocks.HYDRANGEA, ModBlocks.WHITE_CAMELLIA, ModBlocks.WHITE_CALLA_LILY};
    static Block[] pottedFlowerList = {ModBlocks.POTTED_ROSE, ModBlocks.POTTED_CREMON, ModBlocks.POTTED_YARROW, ModBlocks.POTTED_VIBURNUM, ModBlocks.POTTED_GREEN_ORCHID,
            ModBlocks.POTTED_AQUAMARINE_HYDRANGEA, ModBlocks.POTTED_BLUE_STAR, ModBlocks.POTTED_BLUE_ORCHID, ModBlocks.POTTED_BLUE_HEAD_GILLA, ModBlocks.POTTED_COSMOS, ModBlocks.POTTED_CROCUS,
            ModBlocks.POTTED_SWEET_WILLIAM, ModBlocks.POTTED_CORAL_CHARM, ModBlocks.POTTED_HYDRANGEA, ModBlocks.POTTED_WHITE_CAMELLIA, ModBlocks.POTTED_WHITE_CALLA_LILY};

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(ModelGenerator::new);
        pack.addProvider(BlockLootGen::new);
        pack.addProvider(FlowerTags::new);
        pack.addProvider(ClassidyesCALangProvider::new);
        pack.addProvider(ClassidyesUSLangProvider::new);
    }

    public static class ModelGenerator extends FabricModelProvider {
        public ModelGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            //flower model gen
            for (int i = 0; i < flowerList.length; i++){
                blockStateModelGenerator.registerFlowerPotPlant(flowerList[i], pottedFlowerList[i], BlockStateModelGenerator.TintType.NOT_TINTED);
            }
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(ModItems.TEST, Models.GENERATED);
        }
    }

    public static class BlockLootGen extends FabricBlockLootTableProvider {
        public BlockLootGen(FabricDataOutput dataOutput) {
            super(dataOutput);
        }

        @Override
        public void generate() {
            //flower and potted flower drop gen
            for (int i = 0; i < flowerList.length; i++){
                addDrop(flowerList[i]);
                addPottedPlantDrops(pottedFlowerList[i]);
            }
        }
    }

    public static class FlowerTags extends FabricTagProvider.ItemTagProvider {
        public FlowerTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            FabricTagBuilder tagBuilder = getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS);
            for (Block flower : flowerList) {
                tagBuilder.add(flower.asItem());
            }
            tagBuilder.setReplace(false);
        }
    }

    public static class ClassidyesCALangProvider extends FabricLanguageProvider {
        private ClassidyesCALangProvider(FabricDataOutput dataGenerator) {
            super(dataGenerator, "en_ca");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationHelper(translationBuilder);
        }
    }

    public static class ClassidyesUSLangProvider extends FabricLanguageProvider {
        private ClassidyesUSLangProvider(FabricDataOutput dataGenerator) {
            super(dataGenerator, "en_us");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            translationHelper(translationBuilder);
        }
    }

    //translation for both en_ca and en_us
    public static void translationHelper(FabricLanguageProvider.TranslationBuilder transBuilder) {
        transBuilder.add(ModItems.TEST, "Test Item");
        transBuilder.add(ModBlocks.AQUAMARINE_HYDRANGEA.getTranslationKey(), "Aquamarine Hydrangea");
        transBuilder.add(ModBlocks.POTTED_AQUAMARINE_HYDRANGEA.getTranslationKey(), "Potted Aquamarine Hydrangea");
        transBuilder.add(ModBlocks.BLUE_HEAD_GILLA.getTranslationKey(), "Blue Head Gilla");
        transBuilder.add(ModBlocks.POTTED_BLUE_HEAD_GILLA.getTranslationKey(), "Potted Blue Head Gilla");
        transBuilder.add(ModBlocks.BLUE_ORCHID.getTranslationKey(), "Blue Orchid");
        transBuilder.add(ModBlocks.POTTED_BLUE_ORCHID.getTranslationKey(), "Potted Blue Orchid");
        transBuilder.add(ModBlocks.BLUE_STAR.getTranslationKey(), "Blue Star");
        transBuilder.add(ModBlocks.POTTED_BLUE_STAR.getTranslationKey(), "Potted Blue Star");
        transBuilder.add(ModBlocks.CORAL_CHARM.getTranslationKey(), "Coral Charm");
        transBuilder.add(ModBlocks.POTTED_CORAL_CHARM.getTranslationKey(), "Potted Coral Charm");
        transBuilder.add(ModBlocks.COSMOS.getTranslationKey(), "Cosmos");
        transBuilder.add(ModBlocks.POTTED_COSMOS.getTranslationKey(), "Potted Cosmos");
        transBuilder.add(ModBlocks.CREMON.getTranslationKey(), "Cremon");
        transBuilder.add(ModBlocks.POTTED_CREMON.getTranslationKey(), "Potted Cremon");
        transBuilder.add(ModBlocks.CROCUS.getTranslationKey(), "Crocus");
        transBuilder.add(ModBlocks.POTTED_CROCUS.getTranslationKey(), "Potted Crocus");
        transBuilder.add(ModBlocks.GREEN_ORCHID.getTranslationKey(), "Green Orchid");
        transBuilder.add(ModBlocks.POTTED_GREEN_ORCHID.getTranslationKey(), "Potted Green Orchid");
        transBuilder.add(ModBlocks.HYDRANGEA.getTranslationKey(), "Hydrangea");
        transBuilder.add(ModBlocks.POTTED_HYDRANGEA.getTranslationKey(), "Potted Hydrangea");
        transBuilder.add(ModBlocks.ROSE.getTranslationKey(), "Rose");
        transBuilder.add(ModBlocks.POTTED_ROSE.getTranslationKey(), "Potted Rose");
        transBuilder.add(ModBlocks.SWEET_WILLIAM.getTranslationKey(), "Sweet William");
        transBuilder.add(ModBlocks.POTTED_SWEET_WILLIAM.getTranslationKey(), "Potted Sweet William");
        transBuilder.add(ModBlocks.VIBURNUM.getTranslationKey(), "Viburnum");
        transBuilder.add(ModBlocks.POTTED_VIBURNUM.getTranslationKey(), "Potted Viburnum");
        transBuilder.add(ModBlocks.WHITE_CALLA_LILY.getTranslationKey(), "White Calla Lily");
        transBuilder.add(ModBlocks.POTTED_WHITE_CALLA_LILY.getTranslationKey(), "Potted White Calla Lily");
        transBuilder.add(ModBlocks.WHITE_CAMELLIA.getTranslationKey(), "White Camellia");
        transBuilder.add(ModBlocks.POTTED_WHITE_CAMELLIA.getTranslationKey(), "Potted White Camellia");
        transBuilder.add(ModBlocks.YARROW.getTranslationKey(), "Yarrow");
        transBuilder.add(ModBlocks.POTTED_YARROW.getTranslationKey(), "Potted Yarrow");
    }
}

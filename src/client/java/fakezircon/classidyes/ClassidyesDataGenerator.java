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
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ClassidyesDataGenerator implements DataGeneratorEntrypoint {
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
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.AQUAMARINE_HYDRANGEA, ModBlocks.POTTED_AQUAMARINE_HYDRANGEA, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BLUE_HEAD_GILLA, ModBlocks.POTTED_BLUE_HEAD_GILLA, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BLUE_ORCHID, ModBlocks.POTTED_BLUE_ORCHID, BlockStateModelGenerator.TintType.NOT_TINTED);

            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BLUE_STAR, ModBlocks.POTTED_BLUE_STAR, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CORAL_CHARM, ModBlocks.POTTED_CORAL_CHARM, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.COSMOS, ModBlocks.POTTED_COSMOS, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CREMON, ModBlocks.POTTED_CREMON, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CROCUS, ModBlocks.POTTED_CROCUS, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.GREEN_ORCHID, ModBlocks.POTTED_GREEN_ORCHID, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.HYDRANGEA, ModBlocks.POTTED_HYDRANGEA, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ROSE, ModBlocks.POTTED_ROSE, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SWEET_WILLIAM, ModBlocks.POTTED_SWEET_WILLIAM, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.VIBURNUM, ModBlocks.POTTED_VIBURNUM, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.WHITE_CALLA_LILY, ModBlocks.POTTED_WHITE_CALLA_LILY, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.WHITE_CAMELLIA, ModBlocks.POTTED_WHITE_CAMELLIA, BlockStateModelGenerator.TintType.NOT_TINTED);
            blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.YARROW, ModBlocks.POTTED_YARROW, BlockStateModelGenerator.TintType.NOT_TINTED);
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
            addDrop(ModBlocks.AQUAMARINE_HYDRANGEA);
            addPottedPlantDrops(ModBlocks.POTTED_AQUAMARINE_HYDRANGEA);
            addDrop(ModBlocks.BLUE_HEAD_GILLA);
            addPottedPlantDrops(ModBlocks.POTTED_BLUE_HEAD_GILLA);
            addDrop(ModBlocks.BLUE_ORCHID);
            addPottedPlantDrops(ModBlocks.POTTED_BLUE_ORCHID);

            addDrop(ModBlocks.BLUE_STAR);
            addPottedPlantDrops(ModBlocks.POTTED_BLUE_STAR);
            addDrop(ModBlocks.CORAL_CHARM);
            addPottedPlantDrops(ModBlocks.POTTED_CORAL_CHARM);
            addDrop(ModBlocks.COSMOS);
            addPottedPlantDrops(ModBlocks.POTTED_COSMOS);
            addDrop(ModBlocks.CREMON);
            addPottedPlantDrops(ModBlocks.POTTED_CREMON);
            addDrop(ModBlocks.CROCUS);
            addPottedPlantDrops(ModBlocks.POTTED_CROCUS);
            addDrop(ModBlocks.GREEN_ORCHID);
            addPottedPlantDrops(ModBlocks.POTTED_GREEN_ORCHID);
            addDrop(ModBlocks.HYDRANGEA);
            addPottedPlantDrops(ModBlocks.POTTED_HYDRANGEA);
            addDrop(ModBlocks.ROSE);
            addPottedPlantDrops(ModBlocks.POTTED_ROSE);
            addDrop(ModBlocks.SWEET_WILLIAM);
            addPottedPlantDrops(ModBlocks.POTTED_SWEET_WILLIAM);
            addDrop(ModBlocks.VIBURNUM);
            addPottedPlantDrops(ModBlocks.POTTED_VIBURNUM);
            addDrop(ModBlocks.WHITE_CALLA_LILY);
            addPottedPlantDrops(ModBlocks.POTTED_WHITE_CALLA_LILY);
            addDrop(ModBlocks.WHITE_CAMELLIA);
            addPottedPlantDrops(ModBlocks.POTTED_WHITE_CAMELLIA);
            addDrop(ModBlocks.YARROW);
            addPottedPlantDrops(ModBlocks.POTTED_YARROW);
        }
    }

    public static class FlowerTags extends FabricTagProvider.ItemTagProvider {
        public FlowerTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                    .add(ModBlocks.AQUAMARINE_HYDRANGEA.asItem())
                    .add(ModBlocks.BLUE_HEAD_GILLA.asItem())
                    .add(ModBlocks.BLUE_ORCHID.asItem())

                    .add(ModBlocks.BLUE_STAR.asItem())
                    .add(ModBlocks.CORAL_CHARM.asItem())
                    .add(ModBlocks.COSMOS.asItem())
                    .add(ModBlocks.CREMON.asItem())
                    .add(ModBlocks.CROCUS.asItem())
                    .add(ModBlocks.GREEN_ORCHID.asItem())
                    .add(ModBlocks.HYDRANGEA.asItem())
                    .add(ModBlocks.ROSE.asItem())
                    .add(ModBlocks.SWEET_WILLIAM.asItem())
                    .add(ModBlocks.VIBURNUM.asItem())
                    .add(ModBlocks.WHITE_CALLA_LILY.asItem())
                    .add(ModBlocks.WHITE_CAMELLIA.asItem())
                    .add(ModBlocks.YARROW.asItem())
                    .setReplace(false);
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

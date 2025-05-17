package fakezircon.classidyes;

import fakezircon.classidyes.block.ModBlocks;
import fakezircon.classidyes.item.ModItemGroup;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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
            itemModelGenerator.register(ModItems.GREEN_RUBY_DYE, Models.GENERATED);
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
        transBuilder.add(ModItems.GREEN_RUBY_DYE, titleGen(ModItems.GREEN_RUBY_DYE));
        transBuilder.add(ModItemGroup.CLASSIDYEITEMS, "Classidye");
        //flower + potted flower name gen
        for (int i = 0; i < flowerList.length; i++) {
            transBuilder.add(flowerList[i], titleGen(flowerList[i].asItem()));
            transBuilder.add(pottedFlowerList[i], titleGen(pottedFlowerList[i].asItem()));
        }
    }

    public static String titleGen(Item item){
        String name = item.getTranslationKey().split("\\.")[2];
        return Arrays.stream(name.split("_")).map(word -> word.substring(0, 1).toUpperCase() + word.substring(1)).collect(Collectors.joining(" "));
    }
}

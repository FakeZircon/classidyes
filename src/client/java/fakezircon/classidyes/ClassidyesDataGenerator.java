package fakezircon.classidyes;

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
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static fakezircon.classidyes.util.BlockLists.*;
import static fakezircon.classidyes.util.ItemLists.dyeItems;

public class ClassidyesDataGenerator implements DataGeneratorEntrypoint {

    public static final TagKey<Item> DYE_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "dyes"));

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(ModelGenerator::new);
        pack.addProvider(BlockLootGen::new);
        pack.addProvider(ModItemTags::new);
        pack.addProvider(ModBlockTags::new);
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
            //wool + carpet gen
            for (int i = 0; i < woolBlocks.length; i++){
                blockStateModelGenerator.registerWoolAndCarpet(woolBlocks[i], carpetBlocks[i]);
            }
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(ModItems.TEST, Models.GENERATED);
            itemModelGenerator.register(ModItems.CHARTREUSE_DYE, Models.GENERATED);
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
            //wool block gen
            for (Block block : woolBlocks){
                addDrop(block);
            }
            //carpet block gen
            for (Block block : carpetBlocks){
                addDrop(block);
            }
        }
    }

    public static class ModItemTags extends FabricTagProvider.ItemTagProvider {
        public ModItemTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            //flower and flowerpot tags
            FabricTagBuilder sfTagBuilder = getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS);
            FabricTagBuilder fTagBuilder = getOrCreateTagBuilder(ItemTags.FLOWERS);
            for (Block flower : flowerList) {
                fTagBuilder.add(flower.asItem());
                sfTagBuilder.add(flower.asItem());
            }
            sfTagBuilder.setReplace(false);
            fTagBuilder.setReplace(false);

            //dye item tags
            FabricTagBuilder diTagBuilder = getOrCreateTagBuilder(DYE_ITEMS);
            for (Item item : dyeItems){
                diTagBuilder.add(item);
            }
            diTagBuilder.setReplace(false);
        }
    }

    public static class ModBlockTags extends FabricTagProvider.BlockTagProvider{
        public ModBlockTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture){
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg){
            //wool block tags
            FabricTagBuilder wTB = getOrCreateTagBuilder(BlockTags.WOOL);
            FabricTagBuilder dvTB = getOrCreateTagBuilder(BlockTags.DAMPENS_VIBRATIONS);
            FabricTagBuilder ovTB = getOrCreateTagBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS);
            for (Block block : woolBlocks){
                wTB.add(block);
                dvTB.add(block);
                ovTB.add(block);
            }
            wTB.setReplace(false);
            dvTB.setReplace(false);
            ovTB.setReplace(false);

            //carpet tags
            FabricTagBuilder cTB = getOrCreateTagBuilder(BlockTags.WOOL_CARPETS);
            FabricTagBuilder cssTB = getOrCreateTagBuilder(BlockTags.COMBINATION_STEP_SOUND_BLOCKS);
            for (Block block : carpetBlocks){
                dvTB.add(block);
                cTB.add(block);
                cssTB.add(block);
            }
            cTB.setReplace(false);
            cssTB.setReplace(false);
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
        transBuilder.add(ModItems.CHARTREUSE_DYE, titleGen(ModItems.CHARTREUSE_DYE));
        transBuilder.add(ModItemGroup.CLASSIDYEITEMS, "Classidye");
        //flower + potted flower name gen
        for (int i = 0; i < flowerList.length; i++) {
            transBuilder.add(flowerList[i], titleGen(flowerList[i].asItem()));
            transBuilder.add(pottedFlowerList[i], titleGen(pottedFlowerList[i].asItem()));
        }
        //wool blocks
        for (Block block : woolBlocks){
            transBuilder.add(block, titleGen(block.asItem()));
        }
        //carpet
        for (Block block : carpetBlocks){
            transBuilder.add(block, titleGen(block.asItem()));
        }
    }

    public static String titleGen(Item item){
        String name = item.getTranslationKey().split("\\.")[2];
        return Arrays.stream(name.split("_")).map(word -> word.substring(0, 1).toUpperCase() + word.substring(1)).collect(Collectors.joining(" "));
    }
}

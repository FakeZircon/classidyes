package fakezircon.classidyes.block;

import fakezircon.classidyes.Classidyes;
import fakezircon.classidyes.item.ModItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ROSE = registerFlower("rose", StatusEffects.ABSORPTION, 200);
    public static final Block CREMON = registerFlower("cremon", StatusEffects.ABSORPTION, 200);
    public static final Block YARROW = registerFlower("yarrow", StatusEffects.ABSORPTION, 200);
    public static final Block VIBURNUM = registerFlower("viburnum", StatusEffects.ABSORPTION, 200);
    public static final Block GREEN_ORCHID = registerFlower("green_orchid", StatusEffects.ABSORPTION, 200);
    public static final Block AQUAMARINE_HYDRANGEA = registerFlower("aquamarine_hydrangea", StatusEffects.ABSORPTION, 200);
    public static final Block BLUE_STAR = registerFlower("blue_star", StatusEffects.ABSORPTION, 200);
    public static final Block BLUE_ORCHID = registerFlower("blue_orchid", StatusEffects.ABSORPTION, 200);
    public static final Block BLUE_HEAD_GILLA = registerFlower("blue_head_gilla", StatusEffects.ABSORPTION, 200);
    public static final Block COSMOS = registerFlower("cosmos", StatusEffects.ABSORPTION, 200);
    public static final Block CROCUS = registerFlower("crocus", StatusEffects.ABSORPTION, 200);
    public static final Block SWEET_WILLIAM = registerFlower("sweet_william", StatusEffects.ABSORPTION, 200);
    public static final Block CORAL_CHARM = registerFlower("coral_charm", StatusEffects.ABSORPTION, 200);
    public static final Block HYDRANGEA = registerFlower("hydrangea", StatusEffects.ABSORPTION, 200);
    public static final Block WHITE_CAMELLIA = registerFlower("white_camellia", StatusEffects.ABSORPTION, 200);
    public static final Block WHITE_CALLA_LILY = registerFlower("white_calla_lily", StatusEffects.ABSORPTION, 200);
    public static final Block POTTED_ROSE = registerPottedFlower(ROSE);
    public static final Block POTTED_CREMON = registerPottedFlower(CREMON);
    public static final Block POTTED_YARROW = registerPottedFlower(YARROW);
    public static final Block POTTED_VIBURNUM = registerPottedFlower(VIBURNUM);
    public static final Block POTTED_GREEN_ORCHID = registerPottedFlower(GREEN_ORCHID);
    public static final Block POTTED_AQUAMARINE_HYDRANGEA = registerPottedFlower(AQUAMARINE_HYDRANGEA);
    public static final Block POTTED_BLUE_STAR = registerPottedFlower(BLUE_STAR);
    public static final Block POTTED_BLUE_ORCHID = registerPottedFlower(BLUE_ORCHID);
    public static final Block POTTED_BLUE_HEAD_GILLA = registerPottedFlower(BLUE_HEAD_GILLA);
    public static final Block POTTED_COSMOS = registerPottedFlower(COSMOS);
    public static final Block POTTED_CROCUS = registerPottedFlower(CROCUS);
    public static final Block POTTED_SWEET_WILLIAM = registerPottedFlower(SWEET_WILLIAM);
    public static final Block POTTED_CORAL_CHARM = registerPottedFlower(CORAL_CHARM);
    public static final Block POTTED_HYDRANGEA = registerPottedFlower(HYDRANGEA);
    public static final Block POTTED_WHITE_CAMELLIA = registerPottedFlower(WHITE_CAMELLIA);
    public static final Block POTTED_WHITE_CALLA_LILY = registerPottedFlower(WHITE_CALLA_LILY);

    public static Block registerBlock(Block block, String name, boolean shouldRegisterItem){
        Identifier id = new Identifier(Classidyes.MOD_ID, name);

        if(shouldRegisterItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    //quick register for flowers
    public static Block registerFlower(String name, StatusEffect effect, int duration){
        Block flower = registerBlock(
                new FlowerBlock(effect, duration, FabricBlockSettings.copyOf(Blocks.ALLIUM)),
                name,
                true
            );
        //compost value
        CompostingChanceRegistry.INSTANCE.add(flower, 0.65f);
        //item groups
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register( (itemGroup) -> itemGroup.addBefore(Items.TORCHFLOWER, flower.asItem()));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CLASSIDYEITEMS).register( (itemGroup) -> itemGroup.add(flower.asItem()) );
        return flower;
    }
    //quick register for potted flowers
    public static Block registerPottedFlower(Block flower){
        return registerBlock(
                new FlowerPotBlock(flower, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)),
                "potted_" + flower.getTranslationKey().split("\\.")[2],
                false
        );
    }

    public static void registerModBlocks(){
        Classidyes.LOGGER.info("Registering mod blocks for " + Classidyes.MOD_ID);


    }
}

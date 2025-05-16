package fakezircon.classidyes.block;

import fakezircon.classidyes.Classidyes;
import fakezircon.classidyes.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block AQUAMARINE_HYDRANGEA = registerFlower("aquamarine_hydrangea", StatusEffects.ABSORPTION, 200);
    public static final Block POTTED_AQUAMARINE_HYDRANGEA = registerPottedFlower(AQUAMARINE_HYDRANGEA);

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
        return registerBlock(
                new FlowerBlock(effect, duration, FabricBlockSettings.copyOf(Blocks.ALLIUM)),
                name,
                true
        );
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

package fakezircon.classidyes.block;

import fakezircon.classidyes.Classidyes;
import fakezircon.classidyes.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block AQUAMARINE_HYDRANGEA = registerBlock(
            new FlowerBlock(StatusEffects.ABSORPTION, 10, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()),
            "aquamarine_hydrangea",
            true
    );
    public static final Block POTTED_AQUAMARINE_HYDRANGEA = registerBlock(
            new FlowerPotBlock(AQUAMARINE_HYDRANGEA, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()),
            "potted_aquamarine_hydrangea",
            false
    );

    public static Block registerBlock(Block block, String name, boolean shouldRegisterItem){
        Identifier id = new Identifier(Classidyes.MOD_ID, name);

        if(shouldRegisterItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void registerModBlocks(){
        Classidyes.LOGGER.info("Registering mod blocks for " + Classidyes.MOD_ID);


    }
}

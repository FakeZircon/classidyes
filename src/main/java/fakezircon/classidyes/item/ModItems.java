package fakezircon.classidyes.item;

import fakezircon.classidyes.Classidyes;
import fakezircon.classidyes.ModDyeColor;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class ModItems {
    //public static final Item CHARTREUSE_DYE = registerDyeItem("chartreuse_dye", ModDyeColor.CANDY_APPLE);

//    private static void addItemToIngredients(FabricItemGroupEntries entries){
//        entries.add(TEST);
//    }

//    private static Item registerItem(String name, Item item){
//        return Registry.register(Registries.ITEM, new Identifier(Classidyes.MOD_ID, name), item);
//    }

    private static Item registerDyeItem(String name, ModDyeColor colour){
        //todo use dye-brary's RegisterNewDye func to create a new dyeColor for each dye item. For now this will just do nothing
        DyeItem dye = new DyeItem(colour.get(), new FabricItemSettings());
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register( (itemGroup) -> itemGroup.addBefore(Items.BOWL, dye));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CLASSIDYEITEMS).register( (itemGroup) -> itemGroup.add(dye));
        return Registry.register(Registries.ITEM, new Identifier(Classidyes.MOD_ID, name), dye);
    }

    public static void registerModItems(){
        Classidyes.LOGGER.info("Registering mod items for " + Classidyes.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredients);
    }
}

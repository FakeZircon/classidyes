package fakezircon.classidyes.item;

import fakezircon.classidyes.Classidyes;
import fakezircon.classidyes.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.minecraft.registry.RegistryKeys.ITEM_GROUP;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> CLASSIDYEITEMS = register("classidye_items");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Classidyes.MOD_ID + "." + id));
    }

    public static void initialize(){
        Registry.register(
                Registries.ITEM_GROUP,
                CLASSIDYEITEMS,
                ItemGroup.create(ItemGroup.Row.TOP, 1)
                        .displayName(Text.translatable("itemGroup.classidye_items"))
                        .icon(() -> new ItemStack(ModBlocks.BLUE_HEAD_GILLA))
                        .build()
                );
    }
}

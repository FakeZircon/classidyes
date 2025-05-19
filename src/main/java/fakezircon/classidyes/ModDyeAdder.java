package fakezircon.classidyes;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.block.MapColor;

public class ModDyeAdder implements Runnable {
    @Override
    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

        //get remapped class names for DyeColor and MapColor
        String dyeColor = remapper.mapClassName("intermediary", "net.minecraft.class_1767");
        String mapColor = 'L' + remapper.mapClassName("intermediary", "net.minecraft.class_3620") + ';';

        //DyeColor constructor: DyeColor(int id, String name, int color, MapColor mapColor, int fireworkColor, int signColor)
        //          ~~~~~ CALL .build() LAST ~~~~~
        ClassTinkerers.enumBuilder(dyeColor, int.class, String.class, int.class, mapColor, int.class, int.class)
                .addEnum("CHARTREUSE", () -> new Object[] {16, "chartreuse", 0x97f738, MapColor.EMERALD_GREEN, 0x97f738, 0x97f738}).build();
    }
}

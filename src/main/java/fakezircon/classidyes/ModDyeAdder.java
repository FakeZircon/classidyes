package fakezircon.classidyes;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.block.MapColor;

public class ModDyeAdder implements Runnable {
    @Override
    public void run() {
        // I think no enum extension, causing hard to trace crashes with other dye mods. Maybe I'll come back to this
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

        //get remapped class names for DyeColor and MapColor
        String dyeColor = remapper.mapClassName("intermediary", "net.minecraft.class_1767");
        String mapColor = 'L' + remapper.mapClassName("intermediary", "net.minecraft.class_3620") + ';';

        //DyeColor constructor: DyeColor(int id, String name, int color, MapColor mapColor, int fireworkColor, int signColor)
        //          ~~~~~ CALL .build() LAST ~~~~~
        // TODO fix indexing, currently causes race condition with other dye mods
        ClassTinkerers.enumBuilder(dyeColor, int.class, String.class, int.class, mapColor, int.class, int.class)
                .addEnum("CANDY_APPLE", () -> new Object[] {16, "candy_apple", 0xf73838, MapColor.EMERALD_GREEN, 0xf73838, 0xf73838}).build();
    }
}

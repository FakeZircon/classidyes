package fakezircon.classidyes.mixin;

import fakezircon.classidyes.ModDyeColor;
import net.minecraft.block.MapColor;
import net.minecraft.util.DyeColor;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(DyeColor.class)
@Unique
public abstract class DyeColorsMixin {
    @Shadow
    @Final
    @Mutable
    private static DyeColor[] $VALUES;

    private static final DyeColor CHARTREUSE = dyeColorAdd$AddColor("CHARTREUSE",ModDyeColor.CHARTREUSE);

    @Invoker("<init>")
    public static DyeColor dyeColorAdd$invokeInit(String internal_name, int internal_ordinal, int id, String name, int color, MapColor mapColor, int fireworkColor, int signColor){
        throw new AssertionError();
    }

    private static DyeColor dyeColorAdd$AddColor(String internal_name, ModDyeColor new_color) {
        ArrayList<DyeColor> colour_list = new ArrayList<DyeColor>(Arrays.asList(DyeColorsMixin.$VALUES));
        DyeColor colour = dyeColorAdd$invokeInit(internal_name, colour_list.get(colour_list.size() -1).ordinal() + 1,
                new_color.getId(), new_color.getName(), new_color.getColor(), new_color.getMapColor(), new_color.getFireworkColor(), new_color.getSignColor());
        colour_list.add(colour);
        $VALUES = colour_list.toArray(new DyeColor[0]);
        return colour;
    }
}

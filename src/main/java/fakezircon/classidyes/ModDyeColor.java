package fakezircon.classidyes;

import com.google.common.base.Preconditions;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.MapColor;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public enum ModDyeColor implements StringIdentifiable {
//    BLACK(15, "black", 1908001, MapColor.BLACK, 1973019, 0); //template
    CHARTREUSE(3, "chartreuse", 0x97f738, MapColor.EMERALD_GREEN, 0x97f738, 0x97f738);

    private static final IntFunction<ModDyeColor> BY_ID = ValueLists.createIdToValueFunction(ModDyeColor::getId, values(), ValueLists.OutOfBoundsHandling.ZERO);
    private static final Int2ObjectOpenHashMap<ModDyeColor> BY_FIREWORK_COLOR = new Int2ObjectOpenHashMap<>(
            (Map<? extends Integer, ? extends ModDyeColor>)Arrays.stream(values()).collect(Collectors.toMap(color -> color.fireworkColor, color -> color))
    );
    public static final StringIdentifiable.Codec<ModDyeColor> CODEC = StringIdentifiable.createCodec(ModDyeColor::values);
    private final int id;
    private final String name;
    private final MapColor mapColor;
    private final float[] colorComponents;
    private final int fireworkColor;
    private final int signColor;

    private ModDyeColor(int id, String name, int color, MapColor mapColor, int fireworkColor, int signColor) {
        this.id = id;
        this.name = name;
        this.mapColor = mapColor;
        this.signColor = signColor;
        int j = (color & 0xFF0000) >> 16;
        int k = (color & 0xFF00) >> 8;
        int l = (color & 0xFF) >> 0;
        this.colorComponents = new float[]{j / 255.0F, k / 255.0F, l / 255.0F};
        this.fireworkColor = fireworkColor;
    }

    /**
     * {@return the integer ID of the dye color}
     */
    public int getId() {
        return this.id;
    }

    /**
     * {@return the name of the dye color}
     */
    public String getName() {
        return this.name;
    }

    /**
     * {@return the float array containing the red, green and blue components of this dye color}
     *
     * <p>Each value of the array is between {@code 0.0} and {@code 255.0} (both inclusive).
     */
    public float[] getColorComponents() {
        return this.colorComponents;
    }

    /**
     * {@return the corresponding map color}
     */
    public MapColor getMapColor() {
        return this.mapColor;
    }

    /**
     * {@return the color used for colored fireworks as RGB integer}
     *
     * <p>The returned value is between {@code 0} and {@code 0xFFFFFF}.
     */
    public int getFireworkColor() {
        return this.fireworkColor;
    }

    /**
     * {@return the color used for dyed signs as RGB integer}
     *
     * <p>The returned value is between {@code 0} and {@code 0xFFFFFF}.
     */
    public int getSignColor() {
        return this.signColor;
    }

    /**
     * {@return the dye color whose ID is {@code id}}
     *
     * @apiNote If out-of-range IDs are passed, this returns {@link #WHITE}.
     */
    public static ModDyeColor byId(int id) {
        return (ModDyeColor)BY_ID.apply(id);
    }

    /**
     * {@return the dye color whose name is {@code name}, or {@code defaultColor} if
     * there is no such color}
     *
     * @apiNote This returns {@code null} only if {@code defaultColor} is {@code null}.
     */
    @Nullable
    @Contract("_,!null->!null;_,null->_")
    public static ModDyeColor byName(String name, @Nullable ModDyeColor defaultColor) {
        ModDyeColor dyeColor = (ModDyeColor)CODEC.byId(name);
        return dyeColor != null ? dyeColor : defaultColor;
    }

    /**
     * {@return the dye color whose firework color is {@code color}, or {@code null}
     * if there is no such color}
     */
    @Nullable
    public static ModDyeColor byFireworkColor(int color) {
        return BY_FIREWORK_COLOR.get(color);
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}

//I want to add custom map colours at some point but like, this is a lot... Also not here I guess
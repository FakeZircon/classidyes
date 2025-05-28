package fakezircon.classidyes;

import net.minecraft.block.MapColor;
import net.minecraft.util.DyeColor;
import net.minecraft.util.StringIdentifiable;

import static fakezircon.classidyes.util.MiscVals.dyeIndex;

public enum ModDyeColor implements StringIdentifiable {
//    BLACK(15, "black", 1908001, MapColor.BLACK, 1973019, 0); //template
    CANDY_APPLE(dyeIndex, "candy_apple", 0xf73838, MapColor.BRIGHT_RED, 0xf73838, 0xf73838),
    CLEMENTINE(dyeIndex + 1, "clementine", 0xf79738, MapColor.ORANGE, 0xf79738, 0xf79738),
    LEMON(dyeIndex + 2, "lemon", 0xf7f738, MapColor.YELLOW, 0xf7f738, 0xf7f738),
    CHARTREUSE(dyeIndex + 3, "chartreuse", 0x97f738, MapColor.EMERALD_GREEN, 0x97f738, 0x97f738),
    HARLEQUIN(dyeIndex + 4, "harlequin", 0x34e834, MapColor.PALE_GREEN, 0x34e834, 0x34e834),
    SEAFOAM(dyeIndex + 5, "seafoam", 0x38f797, MapColor.BRIGHT_TEAL, 0x38f797, 0x38f797),
    ROBINS_EGG(dyeIndex + 6, "robins_egg", 0x38f7f7, MapColor.DIAMOND_BLUE, 0x38f7f7, 0x38f7f7),
    DENIM(dyeIndex + 7, "denim", 0x74b6f7, MapColor.DARK_AQUA, 0x74b6f7, 0x74b6f7),
    PIGEON_BLUE(dyeIndex + 8, "pigeon_blue", 0x8686f7, MapColor.TERRACOTTA_BLUE, 0x8686f7, 0x8686f7),
    SEANCE(dyeIndex + 9, "seance", 0x9738f7, MapColor.PURPLE, 0x9738f7, 0x9738f7),
    BYZANTIUM(dyeIndex + 10, "byzantium", 0xc252f7, MapColor.MAGENTA, 0xc252f7, 0xc252f7),
    NULL_PINK(dyeIndex + 11, "null_pink", 0xf738f7, MapColor.MAGENTA, 0xf738f7, 0xf738f7),
    CERISE(dyeIndex + 12, "cerise", 0xf73897, MapColor.TERRACOTTA_PINK, 0xf73897, 0xf73897),
    GUNMETAL(dyeIndex + 13, "gunmetal", 0x5a5a5a, MapColor.TERRACOTTA_GRAY, 0x5a5a5a, 0x5a5a5a),
    APPARITION(dyeIndex + 14, "apparition", 0xa2a2a2, MapColor.TERRACOTTA_LIGHT_GRAY, 0xa2a2a2, 0xa2a2a2),
    NACRE(dyeIndex + 15, "nacre", 0xf7f7f7, MapColor.OFF_WHITE, 0xf7f7f7, 0xf7f7f7);

    private final int id;
    private final String name;
    private final MapColor mapColor;
    private final float[] colorComponents;
    private final int fireworkColor;
    private final int signColor;
    private final int color;

    private ModDyeColor(int id, String name, int color, MapColor mapColor, int fireworkColor, int signColor) {
        this.id = id;
        this.name = name;
        this.mapColor = mapColor;
        this.signColor = signColor;
        this.color = color;
        int j = (color & 0xFF0000) >> 16;
        int k = (color & 0xFF00) >> 8;
        int l = (color & 0xFF) >> 0;
        this.colorComponents = new float[]{j / 255.0F, k / 255.0F, l / 255.0F};
        this.fireworkColor = fireworkColor;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getColor() { return this.color; }

    public float[] getColorComponents() {
        return this.colorComponents;
    }

    public MapColor getMapColor() {
        return this.mapColor;
    }

    public int getFireworkColor() {
        return this.fireworkColor;
    }

    public int getSignColor() {
        return this.signColor;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String asString() {
        return this.name;
    }

    // get dye colour implemented via mixin, allows accessing in code for creating dye items
    public DyeColor get(){
        return DyeColor.valueOf(this.name());
    }
}
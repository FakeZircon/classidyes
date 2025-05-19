package fakezircon.classidyes;

import net.minecraft.block.MapColor;
import net.minecraft.util.DyeColor;
import net.minecraft.util.StringIdentifiable;

public enum ModDyeColor implements StringIdentifiable {
//    BLACK(15, "black", 1908001, MapColor.BLACK, 1973019, 0); //template
    CHARTREUSE(18, "chartreuse", 0x97f738, MapColor.EMERALD_GREEN, 0x97f738, 0x97f738);

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

//I want to add custom map colours at some point but like, this is a lot... Also not here I guess
package fakezircon.classidyes.mixin;

import net.minecraft.block.MapColor;
import net.minecraft.util.DyeColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DyeColor.class)
public class DyeColorsMixin {
    @Shadow
    @Mutable
    @Final
    private static DyeColor[] $VALUES;

    @Invoker("<init>")
    public static DyeColor newColor(int id, String name, int color, MapColor mapColor, int fireworkColor, int signColor){
        throw new AssertionError();
    }

    @Inject(method = "<init>", at = @At(value = "FIELD", target = ""))
    private void init(CallbackInfo info) {
        // This code is injected into the start of MinecraftServer.loadWorld()V
    }
}

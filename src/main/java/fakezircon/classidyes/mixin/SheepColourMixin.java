package fakezircon.classidyes.mixin;

import fakezircon.classidyes.Classidyes;
import fakezircon.classidyes.block.ModBlocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public abstract class SheepColourMixin extends AnimalEntity implements Shearable {
    @Shadow
    @Final
    private static TrackedData<Byte> COLOR;

    //test property
    private int classiDyed = 0;

    private SheepColourMixin() {
        super(EntityType.SHEEP, null);
        throw new AssertionError();
    }

    /**
     * @reason Allowing >16 unique dye colors (128)
     * @author ADudeCalledLeo
     */
    @Overwrite
    public DyeColor getColor() {
        byte b = dataTracker.get(COLOR);
        return DyeColor.byId(b & 0x7F);
    }

    /**
     * @reason Allowing >16 unique dye colors (128)
     * @author ADudeCalledLeo
     */
    @Overwrite
    public void setColor(DyeColor color) {
        byte b = dataTracker.get(COLOR);
        dataTracker.set(COLOR, (byte) ((b & 0x80) | color.getId() % 0x7F));
    }

    /**
     * @reason Allowing >16 unique dye colors (128)
     * @author ADudeCalledLeo
     */
    @Overwrite
    public boolean isSheared() {
        return (dataTracker.get(COLOR) & 0x80) != 0;
    }

    /**
     * @reason Allowing >16 unique dye colors (128)
     * @author ADudeCalledLeo
     */
    @Overwrite
    public void setSheared(boolean sheared) {
        byte b = dataTracker.get(COLOR);
        dataTracker.set(COLOR, (byte) ((b & 0x7F) | (sheared ? 0x80 : 0)));
    }

    //this is the method for changing how sheep render, something like an inject to check a custom tag would make this work no problem
    //TODO add a property to sheep for if they are "classidyed" and if so custom loot table and colour render
    @Inject(method = "getDyedColor", at = @At("HEAD"), cancellable = true)
    private static void onGetDyedColor(DyeColor color, CallbackInfoReturnable<float[]> cir){
        if (color == DyeColor.WHITE){
            cir.setReturnValue(new float[]{0.3137254F, 0.3725901F, 0.4705882F});
            cir.cancel();
        }
    }

    @ModifyVariable(method = "sheared", at = @At("STORE"), ordinal = 0)
    private ItemEntity onSheared(ItemEntity value){
        if (this.hasCustomName()){
            if (this.getCustomName().getString().equals("jeb_")) {
                //Classidyes.LOGGER.info("jeb_ Sheared!");
                value.setStack(new ItemStack(ModBlocks.JEB_WOOL));
            }
        }
        return value;
    }

    @Inject(method = "getLootTableId", at = @At("HEAD"), cancellable = true)
    public void onGetLootTableID(CallbackInfoReturnable<Identifier> cir){
        if(this.isSheared()) return;    //bail out of custom loot tables

        if (this.hasCustomName() && this.getCustomName().getString().equals("jeb_")){
            cir.setReturnValue(new Identifier(Classidyes.MOD_ID + ":entities/sheep/jeb"));
            cir.cancel();
        } else if (this.classiDyed != 0){
            Classidyes.LOGGER.info("If you see this, something has gone terribly wrong");
        }
    }
}

package fakezircon.classidyes.mixin;

import fakezircon.classidyes.Classidyes;
import fakezircon.classidyes.block.ModBlocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public abstract class SheepColourMixin extends AnimalEntity implements Shearable {
    @Shadow public abstract boolean isSheared();

    private SheepColourMixin() {
        super(EntityType.SHEEP, null);
        throw new AssertionError();
    }

    @ModifyVariable(method = "sheared", at = @At("STORE"), ordinal = 0)
    private ItemEntity onSheared(ItemEntity value){
        if (this.hasCustomName()){
            if (this.getCustomName().getString().equals("jeb_")) {
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
        }
    }
}

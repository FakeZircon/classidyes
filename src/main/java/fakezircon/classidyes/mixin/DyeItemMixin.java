package fakezircon.classidyes.mixin;

import net.minecraft.block.entity.BannerPattern;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignChangingItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DyeItem.class)
public abstract class DyeItemMixin extends Item implements SignChangingItem {

    public DyeItemMixin(Settings settings) {
        super(settings);
    }
}

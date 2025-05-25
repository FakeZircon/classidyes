package fakezircon.classidyes.util;

import com.google.common.collect.Maps;
import java.util.Map;

import fakezircon.classidyes.ModDyeColor;
import fakezircon.classidyes.util.sheepDyedInterface;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignChangingItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ModDyeItem extends Item implements SignChangingItem {
    private static final Map<ModDyeColor, ModDyeItem> DYES = Maps.newEnumMap(ModDyeColor.class);
    private final ModDyeColor color;

    public ModDyeItem(ModDyeColor color, Item.Settings settings) {
        super(settings);
        this.color = color;
        DYES.put(color, this);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity instanceof SheepEntity sheepEntity && sheepEntity.isAlive() && !sheepEntity.isSheared() && sheepEntity.getColor() != this.color) {
            sheepEntity.getWorld().playSoundFromEntity(user, sheepEntity, SoundEvents.ITEM_DYE_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
            ((sheepDyedInterface) sheepEntity).setClassiDyed(true);
            if (!user.getWorld().isClient) {
                ((sheepDyedInterface) sheepEntity).setColor(this.color);
                stack.decrement(1);
            }

            return ActionResult.success(user.getWorld().isClient);
        } else {
            return ActionResult.PASS;
        }
    }

    public ModDyeColor getColor() {
        return this.color;
    }

    public static ModDyeItem byColor(ModDyeColor color) {
        return DYES.get(color);
    }

    @Override
    public boolean useOnSign(World world, SignBlockEntity signBlockEntity, boolean front, PlayerEntity player) {
        if (signBlockEntity.changeText(text -> text.withColor(this.getColor()), front)) {
            world.playSound(null, signBlockEntity.getPos(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return true;
        } else {
            return false;
        }
    }
}

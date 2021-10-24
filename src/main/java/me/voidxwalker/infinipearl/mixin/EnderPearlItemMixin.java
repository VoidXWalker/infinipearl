package me.voidxwalker.infinipearl.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnderPearlItem.class)
public abstract class EnderPearlItemMixin {

    @Redirect(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V",ordinal = 0))
    public void doNotDecrement(ItemStack instance, int amount){
        if(EnchantmentHelper.getLevel(Enchantments.INFINITY, instance) > 0){
            return;
        }
        instance.decrement(1);
    }
}

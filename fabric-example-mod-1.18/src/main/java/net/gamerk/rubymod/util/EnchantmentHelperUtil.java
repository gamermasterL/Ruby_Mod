package net.gamerk.rubymod.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;

public class EnchantmentHelperUtil {
    public static boolean hasEnchantment(LivingEntity player, Enchantment enchantment) {
        return EnchantmentHelper.getLevel(enchantment, player.getMainHandStack()) >= 1 || EnchantmentHelper.getLevel(enchantment, player.getOffHandStack()) >= 1;
    }
}

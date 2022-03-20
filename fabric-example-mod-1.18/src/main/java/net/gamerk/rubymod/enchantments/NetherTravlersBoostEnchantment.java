package net.gamerk.rubymod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class NetherTravlersBoostEnchantment extends Enchantment {
    public NetherTravlersBoostEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    public int getMinPower(int level) { return 10 + 10 * (level - 1); }

    public int getMaxPower(int level) {
        return 50;
    }

    public int getMaxLevel() {
        return 3;
    }
}

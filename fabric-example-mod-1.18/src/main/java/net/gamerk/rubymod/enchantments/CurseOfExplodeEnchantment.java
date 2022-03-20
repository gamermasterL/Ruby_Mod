package net.gamerk.rubymod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class CurseOfExplodeEnchantment extends Enchantment {
    public CurseOfExplodeEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}

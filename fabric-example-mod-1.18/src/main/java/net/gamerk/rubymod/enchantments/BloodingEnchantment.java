package net.gamerk.rubymod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class BloodingEnchantment extends Enchantment {
    public BloodingEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        super.onTargetDamaged(user, target, level);
        PlayerEntity player = (PlayerEntity) user;
        float chance = user.getRandom().nextFloat();
        if (chance <= 0.1 + (level * 0.08)) {
            if (player.getHealth() < player.getMaxHealth()) {
                player.heal(1F);
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}

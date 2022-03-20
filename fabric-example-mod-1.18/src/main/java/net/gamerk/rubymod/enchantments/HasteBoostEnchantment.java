package net.gamerk.rubymod.enchantments;

import net.gamerk.rubymod.item.ModArmorMaterial;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.biome.Biome;

import static net.gamerk.rubymod.item.custom.ModArmorItem.hasCorrectArmorOn;
import static net.gamerk.rubymod.item.custom.ModArmorItem.hasFullSuitOfArmorOn;


public class HasteBoostEnchantment extends Enchantment {
    public HasteBoostEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        super.onUserDamaged(user, attacker, level);

        if (!user.world.isClient()) {
            PlayerEntity player = (PlayerEntity) user;
            if (hasFullSuitOfArmorOn(player)) {
                if (hasCorrectArmorOn(ModArmorMaterial.AMBER_NETHERITE, player)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 50, 4));
                }
            }
        }
    }
}

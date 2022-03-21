package net.gamerk.rubymod.enchantments;

import net.gamerk.rubymod.util.EnchantmentHelperUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;

public class TeleportAttackEnchantment extends Enchantment {
    public TeleportAttackEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinPower(int level) {
        return 15;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        DamageSource damageSource = ((LivingEntity) target).getRecentDamageSource();
            if ((damageSource != null && !damageSource.isProjectile()) || user.getMainHandStack().getItem() instanceof CrossbowItem)
                return;

            if (EnchantmentHelperUtil.hasEnchantment(user, ModEnchantment.TELEPORT_ATTACK)) {
                double d = target.getX();
                double e = target.getY();
                double f = target.getZ();

                for (int i = 0; i < 16; ++i) {
                    double g = target.getX() + (user.getRandom().nextDouble()) * (14.0D + level);
                    double h = MathHelper.clamp(user.getY() + (double) (user.getRandom().nextInt(16) - 8), (double) user.getEntityWorld().getBottomY(), (double) (user.getEntityWorld().getBottomY() + ((ServerWorld) user.getEntityWorld()).getLogicalHeight() - 1));
                    double j = target.getZ() + (user.getRandom().nextDouble()) * (14.0D + level);
                    if (user.hasVehicle()) {
                        user.stopRiding();
                    }

                    if (user.teleport(g, h, j, true)) {
                        SoundEvent soundEvent = user instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ENTITY_ENDERMAN_TELEPORT;
                        user.getEntityWorld().playSound((PlayerEntity) null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        user.playSound(soundEvent, 1.0F, 1.0F);
                        break;
                }
            }
        }
    }
}

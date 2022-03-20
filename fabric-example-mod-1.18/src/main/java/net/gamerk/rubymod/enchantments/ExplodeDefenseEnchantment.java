package net.gamerk.rubymod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.explosion.Explosion;

public class ExplodeDefenseEnchantment extends Enchantment {
    public ExplodeDefenseEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        super.onUserDamaged(user, attacker, level);
        Vec3d pos = user.getPos();
        ServerWorld world = ((ServerWorld) user.world);

        if(level > 0) {
            float chance = user.getRandom().nextFloat();
            if (chance <= 0.2 + (level * 0.1)) {
                world.createExplosion(user, pos.x - 5, pos.y, pos.z, level + 1,false, Explosion.DestructionType.NONE);
                world.createExplosion(user, pos.x , pos.y, pos.z - 5, level + 1,false, Explosion.DestructionType.NONE);
                world.createExplosion(user, pos.x + 5, pos.y, pos.z, level + 1,false, Explosion.DestructionType.NONE);
                world.createExplosion(user, pos.x, pos.y, pos.z + 5, level + 1,false, Explosion.DestructionType.NONE);
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}

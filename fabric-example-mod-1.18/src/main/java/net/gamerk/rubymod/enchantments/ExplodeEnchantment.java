package net.gamerk.rubymod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import static net.gamerk.rubymod.item.init.ModItems.RUBY_NETHERITE_SWORD;

public class ExplodeEnchantment extends Enchantment {


    public ExplodeEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity attacker, Entity target, int level) {
        super.onTargetDamaged(attacker, target, level);

        if (!attacker.world.isClient()) {
            ServerWorld world = ((ServerWorld) attacker.world);
            PlayerEntity player = ((PlayerEntity) attacker);
            Vec3d pos = target.getPos();
            if (level > 0) {
                float chance = attacker.getRandom().nextFloat();
                if (chance <= 0.2 + (level * 0.1)) {
                    world.createExplosion(target, pos.x, pos.y, pos.z, level + 1,false, Explosion.DestructionType.NONE);
                }
            }
        }
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isOf(RUBY_NETHERITE_SWORD);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}

package net.gamerk.rubymod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import static net.gamerk.rubymod.item.init.ModItems.RUBY_NETHERITE_SWORD;

public class ExplodeEnchantment extends Enchantment {


    public ExplodeEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        super.onTargetDamaged(user, target, level);

        if (!user.world.isClient()) {
            ServerWorld world = ((ServerWorld) user.world);
            PlayerEntity player = ((PlayerEntity) user);
            BlockPos position = target.getBlockPos();
            if (level == 1) {
                float chance = user.getRandom().nextFloat();
                if (chance <= 0.2 + (level * 0.1)) {
                    EntityType.TNT.spawn(world, null, null, player, position,
                            SpawnReason.TRIGGERED, true, true);
                }
            }
            if (level == 2) {
                float chance = user.getRandom().nextFloat();
                if (chance <= 0.2 + (level * 0.1)) {
                    EntityType.TNT.spawn(world, null, null, player, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.TNT.spawn(world, null, null, player, position,
                            SpawnReason.TRIGGERED, true, true);
                }
            }
            if (level == 3) {
                float chance = user.getRandom().nextFloat();
                if (chance <= 0.2 + (level * 0.1)) {

                    EntityType.TNT.spawn(world, null, null, player, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.TNT.spawn(world, null, null, player, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.TNT.spawn(world, null, null, player, position,
                            SpawnReason.TRIGGERED, true, true);

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

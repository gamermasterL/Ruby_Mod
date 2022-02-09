package net.gamerk.rubymod.enchantments;

import net.gamerk.rubymod.item.init.ModItems3;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class LightningEnchantment extends Enchantment {
    public LightningEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.world.isClient()) {
            ServerWorld world = ((ServerWorld) user.world);
            PlayerEntity player = ((PlayerEntity) user);
            BlockPos position = target.getBlockPos();
            if (level == 1) {
                float chance = user.getRandom().nextFloat();
                if (chance <= 0.1 + (level * 0.1)) {
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, position,
                            SpawnReason.TRIGGERED, true, true);
                }
            }
            if (level == 2) {
                float chance = user.getRandom().nextFloat();
                if (chance <= 0.1 + (level * 0.1)) {
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, position,
                            SpawnReason.TRIGGERED, true, true);

                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, position,
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
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isOf(ModItems3.TOPAZ_NETHERITE_SWORD);
    }
}

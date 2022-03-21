package net.gamerk.rubymod.mixin;

import net.gamerk.rubymod.enchantments.MagneticEnchantment;
import net.gamerk.rubymod.enchantments.ModEnchantment;
import net.gamerk.rubymod.item.ModArmorMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

import static net.gamerk.rubymod.item.custom.ModArmorItem.hasCorrectArmorOn;
import static net.gamerk.rubymod.item.custom.ModArmorItem.hasFullSuitOfArmorOn;

@Mixin(LivingEntity.class)
    public class LivingEntityMixin {

    LivingEntity livingEntity = ((LivingEntity) (Object) this);

    @Inject(method = "baseTick", at = @At("RETURN"), cancellable = true)
    public void injectBaseTick(CallbackInfo callbackInfo) {
        int netherTravelersLevel = EnchantmentHelper.getEquipmentLevel(ModEnchantment.NETHER_TRAVLERS_BOOST, livingEntity);
        int flameWalkLevel = EnchantmentHelper.getEquipmentLevel(ModEnchantment.FALME_WALK, livingEntity);
        int magneticLevel = EnchantmentHelper.getEquipmentLevel(ModEnchantment.MAGNETIC, livingEntity);
        World world = livingEntity.world;
        BlockPos pos = livingEntity.getBlockPos();

        if (magneticLevel > 0) {
            MagneticEnchantment.magnetize(livingEntity, livingEntity.getEntityWorld(), magneticLevel);
            callbackInfo.cancel();
        }
        if (flameWalkLevel > 0) {
            if (livingEntity.isOnGround()) {
                if (world.getBlockState(pos) == Blocks.AIR.getDefaultState()) {
                    BlockState fire = Blocks.FIRE.getDefaultState();
                    world.setBlockState(pos, fire);
                    livingEntity.setFireTicks(2);
                }
            }
        }

        if (netherTravelersLevel > 0) {
            Block floor = livingEntity.world.getBlockState(((EntityInvoker) livingEntity).invokeGetVelocityAffectingPos()).getBlock();
            PlayerEntity player = (PlayerEntity) livingEntity;
            Block[] netherBlocks = {
                    Blocks.NETHERRACK, Blocks.CRIMSON_NYLIUM, Blocks.WARPED_NYLIUM, Blocks.BLACKSTONE
            };
            if (Arrays.asList(netherBlocks).contains(floor)) {
                if (hasFullSuitOfArmorOn(player)) {
                    if (hasCorrectArmorOn(ModArmorMaterial.TOPAZ_NETHERITE, player)) {
                        ModEnchantment.applyEffectIfNotPresent(livingEntity, StatusEffects.SPEED, 200, netherTravelersLevel - 1);
                    }

                    if (hasCorrectArmorOn(ModArmorMaterial.AMBER_NETHERITE, player)) {
                        ModEnchantment.applyEffectIfNotPresent(livingEntity, StatusEffects.JUMP_BOOST, 200, netherTravelersLevel - 1);
                    }
                }
                callbackInfo.cancel();
            }
        }

    }
}

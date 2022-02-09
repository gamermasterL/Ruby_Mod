package net.gamerk.rubymod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.gamerk.rubymod.item.ModArmorMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Random;


public class ModArmorItem extends ArmorItem {
     private static final Map<ArmorMaterial, StatusEffect> MATERIAL_STATUS_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial,StatusEffect>())
                    .put(ModArmorMaterial.RUBY_NETHITERITE, StatusEffects.FIRE_RESISTANCE)
                    .put(ModArmorMaterial.RUBY, StatusEffects.STRENGTH)
                    .put(ModArmorMaterial.COBALT, StatusEffects.DOLPHINS_GRACE)
                    .put(ModArmorMaterial.COBALT_NETHITERITE, StatusEffects.CONDUIT_POWER)
                    .put(ModArmorMaterial.TOPAZ, StatusEffects.SPEED)
                    .put(ModArmorMaterial.TOPAZ_NETHERITE, StatusEffects.SPEED)
                    .put(ModArmorMaterial.AMBER, StatusEffects.HASTE)
                    .put(ModArmorMaterial.AMBER_NETHERITE, StatusEffects.HASTE).build();


    public ModArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;

                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffect> entry : MATERIAL_STATUS_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffect mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffect mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect);
        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect, 200,
                    mapArmorMaterial == ModArmorMaterial.AMBER || mapArmorMaterial == ModArmorMaterial.AMBER_NETHERITE ? 0 : 1));
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }

}

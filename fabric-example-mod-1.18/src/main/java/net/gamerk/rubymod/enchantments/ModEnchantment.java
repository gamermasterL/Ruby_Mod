package net.gamerk.rubymod.enchantments;

import net.gamerk.rubymod.RubyMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Random;

public class ModEnchantment {
    public static Enchantment EXPLODE = register("explode",
            new ExplodeEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment FREEZING = register("freezing",
            new FreezingEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment WEAKNESS = register("weakness",
            new WeaknessEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment Lightning = register("lightning",
            new LightningEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment SLOWNESS = register("slowness",
            new SlownessEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment SMELTING = register("smelting",
            new SmeltingEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.DIGGER, EquipmentSlot.MAINHAND));

    public static Enchantment MAGNETIC = register("magnetic",
            new MagneticEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.ARMOR_CHEST, EquipmentSlot.CHEST));

    public static Enchantment HASTE_BOOST = register("haste_boost",
            new HasteBoostEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.ARMOR_CHEST, EquipmentSlot.CHEST));

    public static Enchantment NETHER_TRAVLERS_BOOST = register("nether_travlers_boost",
            new NetherTravlersBoostEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.ARMOR_FEET, EquipmentSlot.FEET));

    public static Enchantment BLOODNIG = register("blooding",
            new BloodingEnchantment(Enchantment.Rarity.RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment FALME_WALK = register("flame_walk",
            new FlameWalkEnchantments(Enchantment.Rarity.RARE,
                    EnchantmentTarget.ARMOR_FEET, EquipmentSlot.FEET));

    public static Enchantment EXPLODE_DEFENSE = register("explode_defense",
            new ExplodeDefenseEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.ARMOR_CHEST, EquipmentSlot.CHEST));

    public static Enchantment CURSE_OF_EXPLODE = register("curse_of_explode",
            new CurseOfExplodeEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.ARMOR, EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET));

    public static void applyEffectIfNotPresent(LivingEntity livingEntity, StatusEffect statusEffect, int duration, int strength) {
        if(livingEntity.hasStatusEffect(statusEffect)) return;
        livingEntity.addStatusEffect(new StatusEffectInstance(statusEffect, duration*20, strength, true, false));
    }

    public static int neutralEffectRandomNumber(Random random, int min, int max) { return random.nextInt(max + 1 - min) + min; }

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(RubyMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering ModEnchantments for " + RubyMod.MOD_ID);
    }
}

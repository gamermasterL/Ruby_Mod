package net.gamerk.rubymod.enchantments;

import net.gamerk.rubymod.RubyMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
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

    public static int neutralEffectRandomNumber(Random random, int min, int max) { return random.nextInt(max + 1 - min) + min; }

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(RubyMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering ModEnchantments for " + RubyMod.MOD_ID);
    }
}

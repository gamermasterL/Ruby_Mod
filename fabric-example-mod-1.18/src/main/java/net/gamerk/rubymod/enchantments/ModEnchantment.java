package net.gamerk.rubymod.enchantments;

import net.gamerk.rubymod.RubyMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantment {
    public static Enchantment EXPLODE = register("explode",
            new ExplodeEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.BOW, EquipmentSlot.MAINHAND));


    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(RubyMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering ModEnchantments for " + RubyMod.MOD_ID);
    }
}

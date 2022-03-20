package net.gamerk.rubymod.item;

import net.fabricmc.api.ModInitializer;
import net.gamerk.rubymod.item.init.ModItems;
import net.gamerk.rubymod.item.init.ModItems2;
import net.gamerk.rubymod.item.init.ModItems3;
import net.gamerk.rubymod.item.init.ModItems4;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import wraith.enchant_giver.EnchantsList;

public class AppendEnchant {
    public static void appendEnchant(){
        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems.RUBY_NETHERITE_SWORD),
                new Identifier("rubymod:explode"), 1, true);
        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems.RUBY_BOW),
                new Identifier("minecraft:flame"),1, true);
        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems.RUBY_SWORD),
                new Identifier("minecraft:fire_aspect"),1, true);

        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems2.COBALT_NETHERITE_SWORD),
                new Identifier("rubymod:freezing"), 1, true);
        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems2.COBALT_BOW),
                new Identifier("minecraft:punch"),3, true);
        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems2.COBALT_SWORD),
                new Identifier("rubymod:weakness"),1, true);

        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems3.TOPAZ_NETHERITE_SWORD),
                new Identifier("rubymod:lightning"), 1, true);
        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems3.TOPAZ_SWORD),
                new Identifier("rubymod:slowness"),1, true);
        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems3.TOPAZ_NETHERITE_BOOTS),
                new Identifier("minecraft:soul_speed"),2,true);

        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems4.AMBER_CHESTPLATE),
                new Identifier("rubymod:haste_boost"), 1, true);
        EnchantsList.addEnchant(Registry.ITEM.getId(ModItems4.AMBER_NETHERITE_CHESTPLATE),
                new Identifier("rubymod:magnetic"), 1, true);
    }
}

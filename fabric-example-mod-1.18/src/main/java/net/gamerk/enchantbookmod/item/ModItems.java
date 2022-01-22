package net.gamerk.enchantbookmod.item;

import net.gamerk.enchantbookmod.EnchantBookMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(EnchantBookMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EnchantBookMod.LOGGER.info("Registring Mod Items for " + EnchantBookMod.MOD_ID);
    }
}

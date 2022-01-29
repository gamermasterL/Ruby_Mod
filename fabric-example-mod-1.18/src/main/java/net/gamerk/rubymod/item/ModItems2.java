package net.gamerk.rubymod.item;

import net.gamerk.rubymod.RubyMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems2 {




    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(RubyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RubyMod.LOGGER.info("Registring Mod Items for " + RubyMod.MOD_ID);
    }
}



package net.gamerk.rubymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gamerk.rubymod.RubyMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems2 {

    public static final Item COBALT = registerItem("cobalt",
            new Item(new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_FRAGMENT = registerItem("cobalt_fragment",
            new Item(new FabricItemSettings().group(ModItemGroup.COBALT)));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(RubyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RubyMod.LOGGER.info("Registring Mod Items for " + RubyMod.MOD_ID);
    }
}



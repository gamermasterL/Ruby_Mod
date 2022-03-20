package net.gamerk.rubymod.registeries;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.yarn.constants.MiningLevels;
import net.gamerk.rubymod.Blocks.init.ModBlock3;
import net.gamerk.rubymod.RubyMod;

public class ModRegisteries {

    public static void registerModFuels() {
        System.out.println("Registering Fuels for " + RubyMod.MOD_ID);
        FuelRegistry registery = FuelRegistry.INSTANCE;

        registery.add(ModBlock3.CHERRY_WOOD, 50);
        registery.add(ModBlock3.CHERRY_LOG, 200);
        registery.add(ModBlock3.CHERRY_WOOD, 200);
        registery.add(ModBlock3.STRIPPED_CHERRY_LOG,200);
        registery.add(ModBlock3.STRIPPED_CHERRY_WOOD, 200);
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlock3.CHERRY_LOG, ModBlock3.STRIPPED_CHERRY_LOG);
        StrippableBlockRegistry.register(ModBlock3.CHERRY_WOOD, ModBlock3.STRIPPED_CHERRY_WOOD);
    }
}

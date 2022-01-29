package net.gamerk.rubymod;

import net.fabricmc.api.ModInitializer;
import net.gamerk.rubymod.Blocks.ModBlocks;
import net.gamerk.rubymod.enchantments.ModEnchantment;
import net.gamerk.rubymod.item.ModItems;
import net.gamerk.rubymod.item.ModItems2;
import net.gamerk.rubymod.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RubyMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "rubymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGen.generateModWorldGen();

		ModEnchantment.registerModEnchantments();

	}
}

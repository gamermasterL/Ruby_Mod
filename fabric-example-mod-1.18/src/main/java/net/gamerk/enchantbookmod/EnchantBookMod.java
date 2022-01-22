package net.gamerk.enchantbookmod;

import net.fabricmc.api.ModInitializer;
import net.gamerk.enchantbookmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnchantBookMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "enchantbookmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {

		ModItems.registerModItems();
	}
}

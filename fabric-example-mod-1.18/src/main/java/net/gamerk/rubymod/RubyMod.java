package net.gamerk.rubymod;

import net.fabricmc.api.ModInitializer;
import net.gamerk.rubymod.Blocks.init.ModBlock2;
import net.gamerk.rubymod.Blocks.init.ModBlock3;
import net.gamerk.rubymod.Blocks.init.ModBlocks;
import net.gamerk.rubymod.Blocks.entity.ModBlockEntities;
import net.gamerk.rubymod.enchantments.ModEnchantment;
import net.gamerk.rubymod.item.init.ModItems;
import net.gamerk.rubymod.item.init.ModItems2;
import net.gamerk.rubymod.item.init.ModItems3;
import net.gamerk.rubymod.receipe.ModRecipes;
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
		ModItems2.registerModItems();
		ModItems3.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlock2.registerModBlocks();
		ModBlock3.registerModBlocks();

		ModRecipes.register();

		ModBlockEntities.registerBlockEntities();

		ModWorldGen.generateModWorldGen();

		ModEnchantment.registerModEnchantments();
		ModItems.appendEnchant();
		ModItems2.appendEnchant();
		ModItems3.appendEnchant(); //To Do. 호박 보석 & 채광용 세트 제작

	}
}

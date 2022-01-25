package net.gamerk.rubymod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.gamerk.rubymod.world.features.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.gamerk.rubymod.world.features.ModConfiguredFeatures;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.RUBY_ORE_KEY);
    }
}

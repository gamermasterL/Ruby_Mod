package net.gamerk.rubymod.world;

import net.fabricmc.fabric.api.biome.v1.*;
import net.gamerk.rubymod.RubyMod;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.Predicate;

public class WorldGen {
    public static void OreGeration(){
        RegistryKey<PlacedFeature> rubyOreOverworld = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RubyMod.MOD_ID, "ore_ruby_overworld"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, rubyOreOverworld.getValue(), PlacedFeatures.ORE_RUBY_OVERWORLD);

        RegistryKey<PlacedFeature> rubyOreDeepslateOverworld = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RubyMod.MOD_ID, "ore_ruby_deepslate_overworld"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, rubyOreDeepslateOverworld.getValue(), PlacedFeatures.ORE_RUBY_DEEPSLATE_OVERWORLD);

        RegistryKey<PlacedFeature> cobaltOreOverworld = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RubyMod.MOD_ID, "ore_cobalt_overworld"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, cobaltOreOverworld.getValue(), PlacedFeatures.ORE_COBALT_OVERWORLD);

        RegistryKey<PlacedFeature> cobaltOreDeepslateOverworld = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RubyMod.MOD_ID, "ore_cobalt_deepslate_overworld"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, cobaltOreDeepslateOverworld.getValue(), PlacedFeatures.ORE_COBALT_DEEPSLATE_OVERWORLD);

        RegistryKey<PlacedFeature> topazOreNether = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RubyMod.MOD_ID, "ore_topaz_nether"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, topazOreNether.getValue(), PlacedFeatures.ORE_TOPAZ_NETHER);

        RegistryKey<PlacedFeature> cherry_Wood_Placed = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RubyMod.MOD_ID, "cherry_wood_placed"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, cherry_Wood_Placed.getValue(), PlacedFeatures.CHERRY_WOOD_PLACED);

        BiomeModifications.addFeature(customSelectionTree(), GenerationStep.Feature.VEGETAL_DECORATION, cherry_Wood_Placed);

        BiomeModifications.addFeature(customSelectionOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, rubyOreOverworld);
        BiomeModifications.addFeature(customSelectionOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, rubyOreDeepslateOverworld);

        BiomeModifications.addFeature(customSelectionOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, cobaltOreOverworld);
        BiomeModifications.addFeature(customSelectionOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, cobaltOreDeepslateOverworld);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, topazOreNether);
    }
    public static Predicate<BiomeSelectionContext> customSelectionOverworld()
    {
        return context -> !NetherBiomes.canGenerateInNether(context.getBiomeKey()) &&
                !TheEndBiomes.canGenerateInTheEnd(context.getBiomeKey()) &&
                context.getBiome().getCategory() != Biome.Category.NONE;
    }

    public static Predicate<BiomeSelectionContext> customSelectionTree()
    {
        return context -> !NetherBiomes.canGenerateInNether(context.getBiomeKey()) &&
                !TheEndBiomes.canGenerateInTheEnd(context.getBiomeKey()) &&
                context.getBiome().getCategory() == Biome.Category.SAVANNA;
    }
}

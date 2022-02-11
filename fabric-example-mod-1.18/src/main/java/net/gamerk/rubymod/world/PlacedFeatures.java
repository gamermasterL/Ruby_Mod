package net.gamerk.rubymod.world;

import net.fabricmc.fabric.api.biome.v1.*;
import net.gamerk.rubymod.RubyMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.Predicate;

public class PlacedFeatures {
    public static final PlacedFeature ORE_RUBY_OVERWORLD = ConfiguredFeatures.ORE_RUBY_OVERWORLD.withPlacement(CountPlacementModifier.of(5),
            SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.aboveBottom(70), YOffset.aboveBottom(115)));

    public static final PlacedFeature ORE_RUBY_DEEPSLATE_OVERWORLD = ConfiguredFeatures.ORE_RUBY_DEEPSLATE_OVERWORLD.withPlacement(CountPlacementModifier.of(5),
            SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(62)));

    public static void init() {
        RegistryKey<PlacedFeature> rubyOreOverworld = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RubyMod.MOD_ID, "ore_ruby_overworld"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, rubyOreOverworld.getValue(), ORE_RUBY_OVERWORLD);

        RegistryKey<PlacedFeature> rubyOreDeepslateOverworld = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RubyMod.MOD_ID, "ore_ruby_deepslate_overworld"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, rubyOreDeepslateOverworld.getValue(), ORE_RUBY_DEEPSLATE_OVERWORLD);

        BiomeModifications.addFeature(customSelectionOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, rubyOreOverworld);
        BiomeModifications.addFeature(customSelectionOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, rubyOreDeepslateOverworld);
    }
    public static Predicate<BiomeSelectionContext> customSelectionOverworld()
    {
        return context -> !NetherBiomes.canGenerateInNether(context.getBiomeKey()) &&
                !TheEndBiomes.canGenerateInTheEnd(context.getBiomeKey()) &&
                context.getBiome().getCategory() != Biome.Category.NONE;
    }

}

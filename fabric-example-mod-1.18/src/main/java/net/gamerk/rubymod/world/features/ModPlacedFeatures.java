package net.gamerk.rubymod.world.features;

import net.gamerk.rubymod.RubyMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final RegistryKey<PlacedFeature> COBALT_ORE_KEY = registerKey("cobalt_ore");
    public static final RegistryKey<PlacedFeature> TOPAZ_ORE_KEY = registerKey("topaz_ore");

    public static final PlacedFeature RUBY_ORE_PLACED = registerPlacedFeature("ruby_ore",
            ModConfiguredFeatures.RUBY_ORE.withPlacement(modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-60), YOffset.aboveBottom(50)))));

    public static final PlacedFeature COBALT_ORE_PLACED = registerPlacedFeature("cobalt_ore",
            ModConfiguredFeatures.COBALT_ORE.withPlacement(modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-60), YOffset.aboveBottom(50)))));

    public static final PlacedFeature TOPAZ_ORE_PLACED = registerPlacedFeature("topaz_ore",
            ModConfiguredFeatures.TOPAZ_ORE.withPlacement(modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(20), YOffset.aboveBottom(120)))));


    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(RubyMod.MOD_ID, name), placedFeature);
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(RubyMod.MOD_ID, name));
    }

}

package net.gamerk.rubymod.world;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class PlacedFeatures {
    public static final PlacedFeature ORE_RUBY_OVERWORLD = ConfiguredFeatures.ORE_RUBY_OVERWORLD.withPlacement(CountPlacementModifier.of(5),
            SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.aboveBottom(70), YOffset.aboveBottom(115)));

    public static final PlacedFeature ORE_RUBY_DEEPSLATE_OVERWORLD = ConfiguredFeatures.ORE_RUBY_DEEPSLATE_OVERWORLD.withPlacement(CountPlacementModifier.of(5),
            SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(62)));

    public static final PlacedFeature ORE_COBALT_OVERWORLD = ConfiguredFeatures.ORE_COBALT_OVERWORLD.withPlacement(CountPlacementModifier.of(5),
            SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.aboveBottom(70), YOffset.aboveBottom(115)));

    public static final PlacedFeature ORE_COBALT_DEEPSLATE_OVERWORLD = ConfiguredFeatures.ORE_COBALT_DEEPSLATE_OVERWORLD.withPlacement(CountPlacementModifier.of(5),
            SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(62)));

    public static final PlacedFeature ORE_TOPAZ_NETHER = ConfiguredFeatures.ORE_TOPAZ_NETHER.withPlacement(CountPlacementModifier.of(7),
            SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.aboveBottom(120)));

    public static final PlacedFeature CHERRY_WOOD_PLACED =
            ConfiguredFeatures.CHERRY_WOOD_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                    net.minecraft.world.gen.feature.PlacedFeatures.createCountExtraModifier(0, 0.01f, 1)));
}

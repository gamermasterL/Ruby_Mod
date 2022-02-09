package net.gamerk.rubymod.world.features;

import net.gamerk.rubymod.Blocks.init.ModBlock2;
import net.gamerk.rubymod.Blocks.init.ModBlock3;
import net.gamerk.rubymod.Blocks.init.ModBlocks;
import net.gamerk.rubymod.RubyMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;


public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_RUBY_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> RUBY_ORE = register("ruby_ore",
            Feature.ORE.configure(new OreFeatureConfig(OVERWORLD_RUBY_ORES, 12,10f)));

    public static final List<OreFeatureConfig.Target> OVERWORLD_COBALT_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlock2.COBALT_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlock2.COBALT_ORE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> COBALT_ORE = register("cobalt_ore",
            Feature.ORE.configure(new OreFeatureConfig(OVERWORLD_COBALT_ORES, 10,10f)));

    public static final List<OreFeatureConfig.Target> NETHER_TOPAZ_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.NETHERRACK, ModBlock3.TOPAZ_ORE.getDefaultState()));

    public static final ConfiguredFeature<?, ?> TOPAZ_ORE = register("topaz_ore",
            Feature.ORE.configure(new OreFeatureConfig(NETHER_TOPAZ_ORES, 6,10f)));


    public static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(RubyMod.MOD_ID, name),
                configuredFeature);
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries,
                Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(block)).withInAirFilter());
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + RubyMod.MOD_ID);
    }
}

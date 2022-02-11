package net.gamerk.rubymod.world;

import net.gamerk.rubymod.Blocks.init.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> ORE_RUBY_OVERWORLD =
            Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD,
                    ModBlocks.RUBY_ORE.getDefaultState(), 4));

    public static final ConfiguredFeature<?, ?> ORE_RUBY_DEEPSLATE_OVERWORLD =
            Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD,
                    ModBlocks.RUBY_ORE_DEEPSLATE.getDefaultState(), 4));

    public static void init(){
        RegistryKey<ConfiguredFeature<?, ?>> rubyOreOverworld =
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("rubymod", "ore_ruby_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, rubyOreOverworld.getValue(), ORE_RUBY_OVERWORLD);

        RegistryKey<ConfiguredFeature<?, ?>> rubyOreDeepslateOverworld =
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("rubymod", "ore_ruby_deepslate_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, rubyOreDeepslateOverworld.getValue(), ORE_RUBY_DEEPSLATE_OVERWORLD);
    }
}

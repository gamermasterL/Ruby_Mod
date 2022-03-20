package net.gamerk.rubymod.world;

import net.gamerk.rubymod.Blocks.init.ModBlock2;
import net.gamerk.rubymod.Blocks.init.ModBlock3;
import net.gamerk.rubymod.Blocks.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> ORE_RUBY_OVERWORLD =
            Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD,
                    ModBlocks.RUBY_ORE.getDefaultState(), 4));

    public static final ConfiguredFeature<?, ?> ORE_RUBY_DEEPSLATE_OVERWORLD =
            Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD,
                    ModBlocks.RUBY_ORE_DEEPSLATE.getDefaultState(), 4));

    public static final ConfiguredFeature<?, ?> ORE_COBALT_OVERWORLD =
            Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD,
                    ModBlock2.COBALT_ORE.getDefaultState(), 4));

    public static final ConfiguredFeature<?, ?> ORE_COBALT_DEEPSLATE_OVERWORLD =
            Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD,
                    ModBlock2.DEEPSLATE_COBALT_ORE.getDefaultState(), 4));

    public static final ConfiguredFeature<?, ?> ORE_TOPAZ_NETHER =
            Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK,
                    ModBlock3.TOPAZ_ORE.getDefaultState(), 4));

    public static final ConfiguredFeature<TreeFeatureConfig, ?> CHERRY_WOOD =
            Feature.TREE.configure(new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlock3.CHERRY_LOG),
                    new StraightTrunkPlacer(5, 2, 1),
                    BlockStateProvider.of(ModBlock3.CHERRY_LEAVES.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)).build());

    public static final ConfiguredFeature<RandomFeatureConfig, ?> CHERRY_WOOD_RANDOM =
            Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                    CHERRY_WOOD.withWouldSurviveFilter(ModBlock3.CHERRY_SAPLING), 0.1f)),
                    CHERRY_WOOD.withWouldSurviveFilter(ModBlock3.CHERRY_SAPLING)));


    public static void init(){
        RegistryKey<ConfiguredFeature<?, ?>> cherry_Wood =
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("rubymod", "cherry_wood"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, cherry_Wood.getValue(), CHERRY_WOOD);

        RegistryKey<ConfiguredFeature<?, ?>> cherry_Wood_Random =
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("rubymod", "cherry_wood_random"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, cherry_Wood_Random.getValue(), CHERRY_WOOD_RANDOM);

        RegistryKey<ConfiguredFeature<?, ?>> rubyOreOverworld =
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("rubymod", "ore_ruby_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, rubyOreOverworld.getValue(), ORE_RUBY_OVERWORLD);

        RegistryKey<ConfiguredFeature<?, ?>> rubyOreDeepslateOverworld =
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("rubymod", "ore_ruby_deepslate_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, rubyOreDeepslateOverworld.getValue(), ORE_RUBY_DEEPSLATE_OVERWORLD);

        RegistryKey<ConfiguredFeature<?, ?>> cobaltOreOverworld =
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("rubymod", "ore_cobalt_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, cobaltOreOverworld.getValue(), ORE_COBALT_OVERWORLD);

        RegistryKey<ConfiguredFeature<?, ?>> cobaltOreDeepslateOverworld =
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("rubymod", "ore_cobalt_deepslate_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, cobaltOreDeepslateOverworld.getValue(), ORE_COBALT_DEEPSLATE_OVERWORLD);

        RegistryKey<ConfiguredFeature<?, ?>> topazOreNether =
                RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("rubymod", "ore_topaz_nether"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, topazOreNether.getValue(), ORE_TOPAZ_NETHER);
    }
}

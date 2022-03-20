package net.gamerk.rubymod.world.tree;

import net.gamerk.rubymod.world.ConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CherryWoodGenerate extends SaplingGenerator {

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return ConfiguredFeatures.CHERRY_WOOD;
    }
}

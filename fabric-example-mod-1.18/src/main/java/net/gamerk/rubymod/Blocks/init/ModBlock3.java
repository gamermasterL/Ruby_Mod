package net.gamerk.rubymod.Blocks.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.gamerk.rubymod.Blocks.custom.CherrySaplingBlock;
import net.gamerk.rubymod.RubyMod;
import net.gamerk.rubymod.item.ModItemGroup;
import net.gamerk.rubymod.world.ConfiguredFeatures;
import net.gamerk.rubymod.world.tree.CherryWoodGenerate;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlock3 {

    public static final Block TOPAZ_BLOCK = registerBlock("topaz_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.TOPAZ);
    public static final Block TOPAZ_ORE = registerBlock("topaz_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.8f).requiresTool()), ModItemGroup.TOPAZ);

    public static final Block AMBER = registerBlock("amber_block",
            new Block(FabricBlockSettings.of(Material.AMETHYST).strength(4f).requiresTool()), ModItemGroup.AMBER);

    public static final Block CHERRY_LOG = registerBlock("cherry_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)), ModItemGroup.AMBER);
    public static final Block CHERRY_WOOD = registerBlock("cherry_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)), ModItemGroup.AMBER);

    public static final Block STRIPPED_CHERRY_LOG = registerBlock("stripped_cherry_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.AMBER);
    public static final Block STRIPPED_CHERRY_WOOD = registerBlock("stripped_cherry_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.AMBER);

    public static final Block CHERRY_PLANKS = registerBlock("cherry_planks",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).requiresTool()), ModItemGroup.AMBER);

    public static final Block CHERRY_LEAVES = registerBlock("cherry_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)), ModItemGroup.AMBER);

    public static final Block CHERRY_SAPLING = registerBlock("cherry_sapling",
            new CherrySaplingBlock(new CherryWoodGenerate(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)), ModItemGroup.AMBER);

    public static final Block RESIN_BLOCK = registerBlock("resin_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool()), ModItemGroup.AMBER);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(RubyMod.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block, ItemGroup group) {
        Registry.register(Registry.ITEM, new Identifier(RubyMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBlocks() {
        RubyMod.LOGGER.info("Registering ModBlocks for " + RubyMod.MOD_ID);

    }
}

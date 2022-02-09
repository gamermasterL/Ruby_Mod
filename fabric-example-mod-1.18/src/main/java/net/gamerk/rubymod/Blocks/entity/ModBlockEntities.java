package net.gamerk.rubymod.Blocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.gamerk.rubymod.Blocks.init.ModBlocks;
import net.gamerk.rubymod.RubyMod;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {

public static BlockEntityType<PressureBlockEntity> PRESSURE_BLOCK_ENTITY;

public static void registerBlockEntities() {
    PRESSURE_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(RubyMod.MOD_ID, "pressure"),
                    FabricBlockEntityTypeBuilder.create(PressureBlockEntity::new,
                            ModBlocks.PRESSURE).build(null));
    }
}


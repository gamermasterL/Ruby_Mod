package net.gamerk.rubymod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.gamerk.rubymod.RubyMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup RUBY = FabricItemGroupBuilder.build(new Identifier(RubyMod.MOD_ID, "ruby" ),
    () -> new ItemStack(ModItems.RUBY));
}

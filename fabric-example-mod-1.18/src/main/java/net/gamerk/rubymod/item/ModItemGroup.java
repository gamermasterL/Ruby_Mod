package net.gamerk.rubymod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.gamerk.rubymod.RubyMod;
import net.gamerk.rubymod.item.init.ModItems;
import net.gamerk.rubymod.item.init.ModItems2;
import net.gamerk.rubymod.item.init.ModItems3;
import net.gamerk.rubymod.item.init.ModItems4;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup RUBY = FabricItemGroupBuilder.build(new Identifier(RubyMod.MOD_ID, "ruby" ),
    () -> new ItemStack(ModItems.RUBY));

    public static final ItemGroup COBALT = FabricItemGroupBuilder.build(new Identifier(RubyMod.MOD_ID, "cobalt"),
    () -> new ItemStack(ModItems2.COBALT));

    public static final ItemGroup TOPAZ = FabricItemGroupBuilder.build(new Identifier(RubyMod.MOD_ID, "topaz"),
    () -> new ItemStack(ModItems3.TOPAZ));

    public static final ItemGroup AMBER = FabricItemGroupBuilder.build(new Identifier(RubyMod.MOD_ID, "amber"),
            () -> new ItemStack(ModItems4.AMBER));

}

package net.gamerk.rubymod.item;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gamerk.rubymod.RubyMod;
import net.gamerk.rubymod.item.custom.ModArmorItem;
import net.gamerk.rubymod.item.custom.ModHoeItem;
import net.gamerk.rubymod.item.custom.ModPickaxeItem;
import net.gamerk.rubymod.item.custom.ModeAxeItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_FRAGMENTS = registerItem("ruby_fragments",
            new Item(new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item QUARTZ_DUST= registerItem("quartz_dust",
            new Item(new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item HEATED_QUARTZ = registerItem("heated_quartz",
            new Item(new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item NON_BAKED_INGREDIENT = registerItem("non_baked_ingredient",
            new Item(new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item RUBY_NETHERITE_INGOT = registerItem("ruby_netherite_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterial.RUBY, 2, 1f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new ModeAxeItem(ModToolMaterial.RUBY, 4, -1f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new ModPickaxeItem(ModToolMaterial.RUBY, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new ModHoeItem(ModToolMaterial.RUBY, 0, 0f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item RUBY_NETHERITE_SWORD = registerItem("ruby_netherite_sword",
            new SwordItem(ModToolMaterial.RUBY_NETHERITE, 4, 1.2f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_NETHERITE_SHOVEL = registerItem("ruby_netherite_shovel",
            new ShovelItem(ModToolMaterial.RUBY_NETHERITE, 0, 1.2f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_NETHERITE_AXE = registerItem("ruby_netherite_axe",
            new ModeAxeItem(ModToolMaterial.RUBY_NETHERITE, 6, -1.2f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_NETHERITE_PICKAXE = registerItem("ruby_netherite_pickaxe",
            new ModPickaxeItem(ModToolMaterial.RUBY_NETHERITE, 0, 1.2f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_NETHERITE_HOE = registerItem("ruby_netherite_hoe",
            new ModHoeItem(ModToolMaterial.RUBY_NETHERITE, 0, 0f,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));


    public static final Item RUBY_SHIELD = registerItem("ruby_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(2000).group(ModItemGroup.RUBY),
                    10,13, ModItems.RUBY));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterial.RUBY,  EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterial.RUBY,  EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterial.RUBY,  EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterial.RUBY,  EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));

    public static final Item RUBY_NETHERITE_HELMET = registerItem("ruby_netherite_helmet",
            new ModArmorItem(ModArmorMaterial.RUBY_NETHITERITE,  EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_NETHERITE_CHESTPLATE = registerItem("ruby_netherite_chestplate",
            new ArmorItem(ModArmorMaterial.RUBY_NETHITERITE,  EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_NETHERITE_LEGGINGS = registerItem("ruby_netherite_leggings",
            new ArmorItem(ModArmorMaterial.RUBY_NETHITERITE,  EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));
    public static final Item RUBY_NETHERITE_BOOTS = registerItem("ruby_netherite_boots",
            new ArmorItem(ModArmorMaterial.RUBY_NETHITERITE,  EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.RUBY)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(RubyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RubyMod.LOGGER.info("Registring Mod Items for " + RubyMod.MOD_ID);
    }
}

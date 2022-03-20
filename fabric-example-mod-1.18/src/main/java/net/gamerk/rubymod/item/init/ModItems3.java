package net.gamerk.rubymod.item.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gamerk.rubymod.RubyMod;
import net.gamerk.rubymod.item.ModArmorMaterial;
import net.gamerk.rubymod.item.ModItemGroup;
import net.gamerk.rubymod.item.ModToolMaterial;
import net.gamerk.rubymod.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import wraith.enchant_giver.EnchantsList;

public class ModItems3 {

    public static final Item TOPAZ = registerItem("topaz",
            new Item(new FabricItemSettings().group(ModItemGroup.TOPAZ)));
    public static final Item TOPAZ_FRAGMENT = registerItem("topaz_fragment",
            new Item(new FabricItemSettings().group(ModItemGroup.TOPAZ)));

    public static final Item NON_BAKED_TOPAZ_INGREDIENT = registerItem("non_baked_topaz_ingredient",
            new Item(new FabricItemSettings().group(ModItemGroup.TOPAZ)));

    public static final Item TOPAZ_NETHERITE_INGOT = registerItem("topaz_netherite_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.TOPAZ)));

    public static final Item TOPAZ_SWORD = registerItem("topaz_sword",
            new ModSwordItem(ModToolMaterial.TOPAZ, 1, 1.5f,
                    new FabricItemSettings().group(ModItemGroup.TOPAZ)));

    public static final Item TOPAZ_NETHERITE_SWORD = registerItem("topaz_netherite_sword",
            new ModSwordItem(ModToolMaterial.TOPAZ_NETHERITE, 3, 2f,
                    new FabricItemSettings().group(ModItemGroup.TOPAZ)));

    public static final Item TOPAZ_HELMET = registerItem("topaz_helmet",
            new ModArmorItem(ModArmorMaterial.TOPAZ,  EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.TOPAZ)));
    public static final Item TOPAZ_CHESTPLATE = registerItem("topaz_chestplate",
            new ArmorItem(ModArmorMaterial.TOPAZ,  EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.TOPAZ)));
    public static final Item TOPAZ_LEGGINGS = registerItem("topaz_leggings",
            new ArmorItem(ModArmorMaterial.TOPAZ,  EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.TOPAZ)));
    public static final Item TOPAZ_BOOTS = registerItem("topaz_boots",
            new ArmorItem(ModArmorMaterial.TOPAZ,  EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.TOPAZ)));

    public static final Item TOPAZ_NETHERITE_HELMET = registerItem("topaz_netherite_helmet",
            new ModArmorItem(ModArmorMaterial.TOPAZ_NETHERITE,  EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.TOPAZ)));
    public static final Item TOPAZ_NETHERITE_CHESTPLATE = registerItem("topaz_netherite_chestplate",
            new ArmorItem(ModArmorMaterial.TOPAZ_NETHERITE,  EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.TOPAZ)));
    public static final Item TOPAZ_NETHERITE_LEGGINGS = registerItem("topaz_netherite_leggings",
            new ArmorItem(ModArmorMaterial.TOPAZ_NETHERITE,  EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.TOPAZ)));
    public static final Item TOPAZ_NETHERITE_BOOTS = registerItem("topaz_netherite_boots",
            new ArmorItem(ModArmorMaterial.TOPAZ_NETHERITE,  EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.TOPAZ)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(RubyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RubyMod.LOGGER.info("Registring Mod Items for " + RubyMod.MOD_ID);
    }
}



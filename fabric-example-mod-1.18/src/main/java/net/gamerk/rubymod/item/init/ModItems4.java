package net.gamerk.rubymod.item.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gamerk.rubymod.RubyMod;
import net.gamerk.rubymod.item.ModArmorMaterial;
import net.gamerk.rubymod.item.ModItemGroup;
import net.gamerk.rubymod.item.custom.ModArmorItem;
import net.gamerk.rubymod.item.custom.ModSwordItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import wraith.enchant_giver.EnchantsList;

public class ModItems4 {

    public static final Item AMBER = registerItem("amber",
            new Item(new FabricItemSettings().group(ModItemGroup.AMBER)));
    public static final Item AMBER_FRAGMENT = registerItem("amber_fragment",
            new Item(new FabricItemSettings().group(ModItemGroup.AMBER)));

    public static final Item NON_BAKED_AMBER_INGREDIENT = registerItem("non_baked_amber_ingredient",
            new Item(new FabricItemSettings().group(ModItemGroup.AMBER)));

    public static final Item AMBER_NETHERITE_INGOT = registerItem("amber_netherite_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.AMBER)));


    public static final Item AMBER_HELMET = registerItem("amber_helmet",
            new ModArmorItem(ModArmorMaterial.AMBER,  EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.AMBER)));
    public static final Item AMBER_CHESTPLATE = registerItem("amber_chestplate",
            new ArmorItem(ModArmorMaterial.AMBER,  EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.AMBER)));
    public static final Item AMBER_LEGGINGS = registerItem("amber_leggings",
            new ArmorItem(ModArmorMaterial.AMBER,  EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.AMBER)));
    public static final Item AMBER_BOOTS = registerItem("amber_boots",
            new ArmorItem(ModArmorMaterial.AMBER,  EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.AMBER)));

    public static final Item AMBER_NETHERITE_HELMET = registerItem("amber_netherite_helmet",
            new ModArmorItem(ModArmorMaterial.AMBER_NETHERITE,  EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.AMBER)));
    public static final Item AMBER_NETHERITE_CHESTPLATE = registerItem("amber_netherite_chestplate",
            new ArmorItem(ModArmorMaterial.AMBER_NETHERITE,  EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.AMBER)));
    public static final Item AMBER_NETHERITE_LEGGINGS = registerItem("amber_netherite_leggings",
            new ArmorItem(ModArmorMaterial.AMBER_NETHERITE,  EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.AMBER)));
    public static final Item AMBER_NETHERITE_BOOTS = registerItem("amber_netherite_boots",
            new ArmorItem(ModArmorMaterial.AMBER_NETHERITE,  EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.AMBER)));

    public static void appendEnchant() {
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(RubyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RubyMod.LOGGER.info("Registring Mod Items for " + RubyMod.MOD_ID);
    }
}



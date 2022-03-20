package net.gamerk.rubymod.item.init;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
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

public class ModItems2 {

    public static final Item COBALT = registerItem("cobalt",
            new Item(new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_FRAGMENT = registerItem("cobalt_fragment",
            new Item(new FabricItemSettings().group(ModItemGroup.COBALT)));

    public static final Item NON_BAKED_COBALT_INGREDIENT = registerItem("non_baked_cobalt_ingredient",
            new Item(new FabricItemSettings().group(ModItemGroup.COBALT)));

    public static final Item COBALT_NETHERITE_INGOT = registerItem("cobalt_netherite_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.COBALT)));

    public static final Item COBALT_SWORD = registerItem("cobalt_sword",
            new ModSwordItem(ModToolMaterial.COBALT, 2, 1f,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_SHOVEL = registerItem("cobalt_shovel",
            new ShovelItem(ModToolMaterial.COBALT, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_AXE = registerItem("cobalt_axe",
            new ModeAxeItem(ModToolMaterial.COBALT, 4, -1f,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_PICKAXE = registerItem("cobalt_pickaxe",
            new ModPickaxeItem(ModToolMaterial.COBALT, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_HOE = registerItem("cobalt_hoe",
            new ModHoeItem(ModToolMaterial.COBALT, 0, 0f,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));

    public static final Item COBALT_NETHERITE_SWORD = registerItem("cobalt_netherite_sword",
            new ModSwordItem(ModToolMaterial.COBALT_NETHERITE, 4, 1.2f,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_NETHERITE_SHOVEL = registerItem("cobalt_netherite_shovel",
            new ShovelItem(ModToolMaterial.COBALT_NETHERITE, 0, 1.2f,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_NETHERITE_AXE = registerItem("cobalt_netherite_axe",
            new ModeAxeItem(ModToolMaterial.COBALT_NETHERITE, 6, -1.2f,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_NETHERITE_PICKAXE = registerItem("cobalt_netherite_pickaxe",
            new ModPickaxeItem(ModToolMaterial.COBALT_NETHERITE, 0, 1.2f,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_NETHERITE_HOE = registerItem("cobalt_netherite_hoe",
            new ModHoeItem(ModToolMaterial.COBALT_NETHERITE, 0, 0f,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));


    public static final Item COBALT_SHIELD = registerItem("cobalt_shield",
            new FabricShieldItem(new FabricItemSettings().maxDamage(2000).group(ModItemGroup.COBALT),
                    9,14, ModItems2.COBALT));

    public static final Item COBALT_HELMET = registerItem("cobalt_helmet",
            new ModArmorItem(ModArmorMaterial.COBALT,  EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_CHESTPLATE = registerItem("cobalt_chestplate",
            new ArmorItem(ModArmorMaterial.COBALT,  EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_LEGGINGS = registerItem("cobalt_leggings",
            new ArmorItem(ModArmorMaterial.COBALT,  EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_BOOTS = registerItem("cobalt_boots",
            new ArmorItem(ModArmorMaterial.COBALT,  EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));

    public static final Item COBALT_NETHERITE_HELMET = registerItem("cobalt_netherite_helmet",
            new ModArmorItem(ModArmorMaterial.COBALT_NETHITERITE,  EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_NETHERITE_CHESTPLATE = registerItem("cobalt_netherite_chestplate",
            new ArmorItem(ModArmorMaterial.COBALT_NETHITERITE,  EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_NETHERITE_LEGGINGS = registerItem("cobalt_netherite_leggings",
            new ArmorItem(ModArmorMaterial.COBALT_NETHITERITE,  EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));
    public static final Item COBALT_NETHERITE_BOOTS = registerItem("cobalt_netherite_boots",
            new ArmorItem(ModArmorMaterial.COBALT_NETHITERITE,  EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.COBALT)));

    public static final Item COBALT_BOW = registerItem("cobalt_bow",
            new CobaltBow(new FabricItemSettings().maxDamage(600).group(ModItemGroup.COBALT)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(RubyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RubyMod.LOGGER.info("Registring Mod Items for " + RubyMod.MOD_ID);
    }
}



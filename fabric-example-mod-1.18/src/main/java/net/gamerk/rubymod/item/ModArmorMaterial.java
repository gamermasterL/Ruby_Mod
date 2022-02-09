package net.gamerk.rubymod.item;

import net.gamerk.rubymod.item.init.ModItems;
import net.gamerk.rubymod.item.init.ModItems2;
import net.gamerk.rubymod.item.init.ModItems3;
import net.gamerk.rubymod.item.init.ModItems4;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    RUBY("ruby", 28, new int[]{3, 5, 7, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            0.0f, 0.0f, () -> {
        return Ingredient.ofItems(ModItems.RUBY);
    }),
    RUBY_NETHITERITE("ruby_netherite", 43, new int[]{4, 7, 9, 4}, 23, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            2.3f, 0.2f, () -> {
        return Ingredient.ofItems(ModItems.RUBY);
    }),
    COBALT("cobalt", 28, new int[]{3, 5, 7, 4}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f, 0.0f, () -> {
        return Ingredient.ofItems(ModItems2.COBALT);
    }),
    COBALT_NETHITERITE("cobalt_netherite", 45, new int[]{5, 7, 9, 5}, 24, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            2.4f, 0.2f, () -> {
        return Ingredient.ofItems(ModItems2.COBALT);
    }),
    TOPAZ("topaz",28, new int[]{2, 5, 6 ,4}, 13, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            0.0f, 0.0f, () ->{
        return Ingredient.ofItems(ModItems3.TOPAZ);
    }),
    TOPAZ_NETHERITE("topaz_netherite", 42, new int[]{5, 6, 5, 4}, 24, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            2.1f, 0.2f, () -> {
        return Ingredient.ofItems(ModItems3.TOPAZ);
    }),
    AMBER("amber", 29, new int[]{3, 5, 6, 3}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f, 0.0f,() -> {
        return Ingredient.ofItems(ModItems4.AMBER);
    }),
    AMBER_NETHERITE("amber_netherite", 42, new int[]{5, 6, 5, 4}, 24, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            2.1f, 0.2f, () -> {
        return Ingredient.ofItems(ModItems3.TOPAZ);
    });

    private static final int[] BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability,
                     SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
    }
}

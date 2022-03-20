package net.gamerk.rubymod.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.gamerk.rubymod.item.init.ModItems;
import net.gamerk.rubymod.item.init.ModItems2;
import net.gamerk.rubymod.item.init.ModItems3;
import net.gamerk.rubymod.item.init.ModItems4;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    RUBY(MiningLevels.DIAMOND, 900, 7.5f, 2.7f, 12, () -> Ingredient.ofItems(ModItems.RUBY)),
    RUBY_NETHERITE(MiningLevels.NETHERITE, 2100, 10f, 4.5f, 18, () -> Ingredient.ofItems(ModItems.RUBY_NETHERITE_INGOT)),
    COBALT(MiningLevels.DIAMOND,900, 7.7f, 2.8f, 13, () -> Ingredient.ofItems(ModItems2.COBALT)),
    COBALT_NETHERITE(MiningLevels.NETHERITE, 2150, 10f, 4.5f, 18, () -> Ingredient.ofItems(ModItems2.COBALT_NETHERITE_AXE)),
    TOPAZ(MiningLevels.DIAMOND, 900, 7.9f, 2.0f, 14, () -> Ingredient.ofItems(ModItems3.TOPAZ)),
    TOPAZ_NETHERITE(MiningLevels.NETHERITE, 2150, 10f, 3.8f, 19, () -> Ingredient.ofItems(ModItems3.TOPAZ_NETHERITE_INGOT)),
    AMBER(MiningLevels.DIAMOND, 950, 8.0f, 2.3f, 14, () -> Ingredient.ofItems(ModItems4.AMBER)),
    AMBER_NETHERITE(MiningLevels.NETHERITE,2250, 10.5f, 2.6f, 19, () -> Ingredient.ofItems(ModItems4.AMBER_NETHERITE_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed,
                            float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

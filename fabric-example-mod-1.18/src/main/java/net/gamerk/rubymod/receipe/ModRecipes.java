package net.gamerk.rubymod.receipe;

import net.gamerk.rubymod.RubyMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(RubyMod.MOD_ID, PressureRecipe.Serializer.ID),
                PressureRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(RubyMod.MOD_ID, PressureRecipe.Type.ID),
                PressureRecipe.Type.INSTANCE);
    }
}

package net.gamerk.rubymod.item.init;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.gamerk.rubymod.item.ModItems;
import net.minecraft.util.Identifier;

public class ModelProviderinit {
    public static void init() {
        FabricModelPredicateProviderRegistry.register(ModItems.RUBY_BOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            }
            return entity.getActiveItem() != stack ? 0.0F : (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0F;
        });

        FabricModelPredicateProviderRegistry.register(ModItems.RUBY_BOW, new Identifier("pulling"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            }
            return entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });

    }
}
package net.gamerk.rubymod.mixin;

import net.gamerk.rubymod.enchantments.ModEnchantment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static net.gamerk.rubymod.enchantments.ModEnchantment.neutralEffectRandomNumber;

@Mixin(Block.class)
public class SmeltingMixin {
    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;",
            at = @At("RETURN"),
            cancellable = true)
    private static void getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos,
                                         BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> items = new ArrayList<>();
        List<ItemStack> returnValue = cir.getReturnValue();
        int level = EnchantmentHelper.getLevel(ModEnchantment.SMELTING, stack);
        if (EnchantmentHelper.getLevel(ModEnchantment.SMELTING, stack) == 0) {
            cir.setReturnValue(returnValue);
            return;
        }
        for (ItemStack itemStack : returnValue) {
            Optional<SmeltingRecipe> recipe = world.getRecipeManager().listAllOfType(RecipeType.SMELTING).stream().filter((smeltingRecipe -> {
                return smeltingRecipe.getIngredients().get(0).test(itemStack);
            })).findFirst();

                if (recipe.isPresent() && neutralEffectRandomNumber(new Random(), 0 , 10) < (level * 1.5)) {
                    ItemStack smelted = recipe.get().getOutput();
                    smelted.setCount(itemStack.getCount());
                    items.add(smelted);
            } else {
                    items.add(itemStack);
            }
        }
        cir.setReturnValue(items);
    }
}

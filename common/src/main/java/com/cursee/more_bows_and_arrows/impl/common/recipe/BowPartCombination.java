package com.cursee.more_bows_and_arrows.impl.common.recipe;

import com.cursee.more_bows_and_arrows.impl.common.registry.ModItems;
import com.cursee.more_bows_and_arrows.impl.common.registry.ModRecipeSerializers;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class BowPartCombination extends CustomRecipe {

  public BowPartCombination(ResourceLocation id, CraftingBookCategory category) {
    super(id, category);
  }

  @Override
  public boolean matches(CraftingContainer craftingContainer, Level level) {
    return false;
  }

  @Override
  public ItemStack assemble(CraftingContainer craftingContainer, RegistryAccess registryAccess) {
    return new ItemStack(ModItems.BOW);
  }

  @Override
  public boolean canCraftInDimensions(int width, int height) {
    return (width * height) >= 4;
  }

  @Override
  public RecipeSerializer<?> getSerializer() {
    return ModRecipeSerializers.BOW_PART_COMBINATION;
  }
}

package com.cursee.more_bows_and_arrows.impl.common.registry;

import com.cursee.more_bows_and_arrows.MoreBowsAndArrows;
import com.cursee.more_bows_and_arrows.impl.common.recipe.ArrowPartCombination;
import com.cursee.more_bows_and_arrows.impl.common.recipe.BowPartCombination;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public class ModRecipeSerializers {

  public static RecipeSerializer<BowPartCombination> BOW_PART_COMBINATION;
  public static RecipeSerializer<ArrowPartCombination> ARROW_PART_COMBINATION;

  public static void register(BiConsumer<RecipeSerializer<?>, ResourceLocation> consumer) {
    BOW_PART_COMBINATION = new SimpleCraftingRecipeSerializer<>(BowPartCombination::new);
    ARROW_PART_COMBINATION = new SimpleCraftingRecipeSerializer<>(ArrowPartCombination::new);

    consumer.accept(BOW_PART_COMBINATION, MoreBowsAndArrows.identifier("bow_part_combination"));
    consumer.accept(ARROW_PART_COMBINATION, MoreBowsAndArrows.identifier("arrow_part_combination"));
  }
}

package com.cursee.more_bows_and_arrows.impl.common.registry.custom;

import com.cursee.more_bows_and_arrows.MoreBowsAndArrows;
import com.cursee.more_bows_and_arrows.api.bow.IBowModifierRegistry;
import com.cursee.more_bows_and_arrows.api.bow.IBowPart;
import com.cursee.more_bows_and_arrows.impl.common.item.bow.BowModifier;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BowModifierRegistry implements IBowModifierRegistry {

  // public static final IBowModifierRegistry REGISTRY = MoreBowsAndArrows.instance.getCustomRegistryManager().getRegistry(IBowModifierRegistry.class);

  @Override
  public BowModifier registerModifier(BowModifier modifier) {
    return null;
  }

  @Override
  public void overrideDefaultModifierPart(BowModifier modifier, @Nullable IBowPart broomPart) {

  }

  @Override
  public @Nullable IBowPart getModifierPart(BowModifier modifier) {
    return null;
  }

  @Override
  public void clearModifierItems() {

  }

  @Override
  public void registerModifiersItem(Map<BowModifier, Float> modifiers, ItemStack item) {

  }

  @Override
  public void registerModifiersItem(BowModifier modifier, float modifierValue, ItemStack item) {

  }

  @Override
  public Map<BowModifier, Float> getModifiersFromItem(ItemStack item) {
    return Map.of();
  }

  @Override
  public Map<ItemStack, Float> getItemsFromModifier(BowModifier modifier) {
    return Map.of();
  }

  @Override
  public Collection<BowModifier> getModifiers() {
    return List.of();
  }

  @Override
  public Map<BowModifier, Float> getModifiers(ItemStack broomStack) {
    return Map.of();
  }

  @Override
  public void setModifiers(ItemStack broomStack, Map<BowModifier, Float> modifiers) {

  }
}

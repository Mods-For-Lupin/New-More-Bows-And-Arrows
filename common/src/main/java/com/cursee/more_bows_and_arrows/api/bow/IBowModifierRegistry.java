package com.cursee.more_bows_and_arrows.api.bow;

import com.cursee.more_bows_and_arrows.impl.common.item.bow.BowModifier;
import com.cursee.more_bows_and_arrows.impl.common.registry.util.IRegistry;
import java.util.Collection;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface IBowModifierRegistry extends IRegistry {

  BowModifier registerModifier(BowModifier modifier);

  void overrideDefaultModifierPart(BowModifier modifier, @Nullable IBowPart broomPart);

  @Nullable IBowPart getModifierPart(BowModifier modifier);

  void clearModifierItems();

  void registerModifiersItem(Map<BowModifier, Float> modifiers, ItemStack item);

  void registerModifiersItem(BowModifier modifier, float modifierValue, ItemStack item);

  Map<BowModifier, Float> getModifiersFromItem(ItemStack item);

  Map<ItemStack, Float> getItemsFromModifier(BowModifier modifier);

  Collection<BowModifier> getModifiers();

  Map<BowModifier, Float> getModifiers(ItemStack broomStack);

  void setModifiers(ItemStack broomStack, Map<BowModifier, Float> modifiers);
}

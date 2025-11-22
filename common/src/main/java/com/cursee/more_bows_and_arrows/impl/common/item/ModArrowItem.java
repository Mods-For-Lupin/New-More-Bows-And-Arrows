package com.cursee.more_bows_and_arrows.impl.common.item;

import com.cursee.more_bows_and_arrows.api.common.arrow.IArrow;
import com.cursee.more_bows_and_arrows.api.common.arrow.IArrowPart;
import com.cursee.more_bows_and_arrows.impl.common.arrow.ArrowModifier;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModArrowItem extends Item implements IArrow {

  public ModArrowItem(Properties properties) {
    super(properties);
  }

  @Override
  public Collection<IArrowPart> getArrowParts(ItemStack itemStack) {
    return List.of(); // TODO get from registry helper method ArrowParts.REGISTRY.getArrowParts(ItemStack)
  }

  @Override
  public Map<ArrowModifier, Float> getArrowModifiers() {
    return Map.of(); // TODO same as getArrowParts
  }
}

package com.cursee.more_bows_and_arrows.impl.common.item;

import com.cursee.more_bows_and_arrows.api.common.bow.IBow;
import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart;
import com.cursee.more_bows_and_arrows.impl.common.bow.BowModifier;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModBowItem extends Item implements IBow {

  public ModBowItem(Properties properties) {
    super(properties);
  }

  @Override
  public Collection<IBowPart> getBowParts(ItemStack itemStack) {
    return List.of(); // TODO get from registry helper method BowParts.REGISTRY.getBowParts(ItemStack)
  }

  @Override
  public Map<BowModifier, Float> getBowModifiers(ItemStack itemStack) {
    return Map.of(); // TODO same as getBowParts
  }
}

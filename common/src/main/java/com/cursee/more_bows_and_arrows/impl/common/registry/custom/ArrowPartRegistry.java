package com.cursee.more_bows_and_arrows.impl.common.registry.custom;

import com.cursee.more_bows_and_arrows.api.common.arrow.IArrowPart;
import com.cursee.more_bows_and_arrows.api.common.registry.custom.IArrowPartRegistry;
import java.util.Collection;
import java.util.List;
import net.minecraft.world.item.ItemStack;

public class ArrowPartRegistry implements IArrowPartRegistry {

  @Override
  public Collection<IArrowPart> getArrowParts(ItemStack itemStack) {
    return List.of();
  }
}

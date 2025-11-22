package com.cursee.more_bows_and_arrows.api.common.arrow;

import com.cursee.more_bows_and_arrows.impl.common.arrow.ArrowModifier;
import java.util.Collection;
import java.util.Map;
import net.minecraft.world.item.ItemStack;

public interface IArrow {

  Collection<IArrowPart> getArrowParts(ItemStack itemStack);

  Map<ArrowModifier, Float> getArrowModifiers();
}

package com.cursee.more_bows_and_arrows.api.common.bow;

import com.cursee.more_bows_and_arrows.impl.common.bow.BowModifier;
import java.util.Collection;
import java.util.Map;
import net.minecraft.world.item.ItemStack;

public interface IBow {

  Collection<IBowPart> getBowParts(ItemStack itemStack);

  Map<BowModifier, Float> getBowModifiers(ItemStack itemStack);
}

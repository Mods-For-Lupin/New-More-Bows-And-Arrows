package com.cursee.more_bows_and_arrows.api.bow;

import java.util.Collection;
import net.minecraft.world.item.ItemStack;

public interface IBow {

  Collection<IBowPart> getBowParts(ItemStack itemStack);

  Collection<IBowModifier> getBowModifiers(ItemStack itemStack);
}

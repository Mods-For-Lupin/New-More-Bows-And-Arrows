package com.cursee.more_bows_and_arrows.api.common.bow;

import java.util.Collection;
import net.minecraft.world.item.ItemStack;

public interface IBow {

  String TAG_BOW_PARTS = "bow_parts";
  String TAG_BOW_MODIFIERS = "bow_modifiers";

  Collection<IBowPart> getBowParts(ItemStack itemStack);
}

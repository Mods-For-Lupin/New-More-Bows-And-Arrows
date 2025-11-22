package com.cursee.more_bows_and_arrows.api.common.registry.custom;

import com.cursee.more_bows_and_arrows.api.common.arrow.IArrowPart;
import com.cursee.more_bows_and_arrows.util.IRegistry;
import java.util.Collection;
import net.minecraft.world.item.ItemStack;

public interface IArrowPartRegistry extends IRegistry {

  Collection<IArrowPart> getArrowParts(ItemStack itemStack);
}

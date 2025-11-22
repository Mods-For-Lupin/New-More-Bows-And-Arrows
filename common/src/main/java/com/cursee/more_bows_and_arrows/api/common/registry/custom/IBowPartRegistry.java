package com.cursee.more_bows_and_arrows.api.common.registry.custom;

import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart;
import com.cursee.more_bows_and_arrows.util.IRegistry;
import java.util.Collection;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public interface IBowPartRegistry extends IRegistry {

  IBowPart getPart(ResourceLocation identifier);

  Collection<IBowPart> getBowParts();

  Collection<IBowPart> getBowParts(ItemStack itemStack);

  <P extends IBowPart> P registerPart(P part);

  <P extends IBowPart> Collection<ItemStack> getItemsFromPart(P part);
}

package com.cursee.more_bows_and_arrows.api.common.registry;

import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart;
import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart.BowPartType;
import com.cursee.more_bows_and_arrows.util.IRegistry;
import java.util.Collection;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface IBowPartRegistry extends IRegistry {

  Collection<IBowPart> getRegisteredBowParts();

  Collection<IBowPart> getRegisteredBowPartsOfType(BowPartType type);

  Collection<IBowPart> getBowParts(ItemStack itemStack);

  <P extends IBowPart> P registerBowPart(P part);

  <P extends IBowPart> Collection<ItemStack> getItemsFromPart(P part);

  void setBowParts(ItemStack itemStack, Collection<IBowPart> parts);

  <P extends IBowPart> void registerPartItem(@Nullable P part, ItemStack itemStack);
}

package com.cursee.more_bows_and_arrows.api.bow;

import com.cursee.more_bows_and_arrows.impl.common.item.bow.BowModifier;
import com.cursee.more_bows_and_arrows.impl.common.registry.util.IRegistry;
import java.util.Collection;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface IBowPartRegistry extends IRegistry {

  <P extends IBowPart> P registerPart(P part);

  <P extends IBowPart> void registerPartItem(@Nullable P part, ItemStack itemStack);

  <P extends IBowPart> void registerBaseModifiers(@Nullable P part, Map<BowModifier, Float> modifiers);

  <P extends IBowPart> void registerBaseModifiers(@Nullable P part, BowModifier modifier, float modifierValue);

  <P extends IBowPart> Map<BowModifier, Float> getBaseModifiersFromPart(P part);

  Map<BowModifier, Float> getBaseModifiersFromBow(ItemStack bowStack);

  <P extends IBowPart> Collection<ItemStack> getItemsFromPart(P part);

  <P extends IBowPart> P getPartFromItem(ItemStack item);

  Collection<IBowPart> getParts();

  IBowPart getPart(ResourceLocation partId);

  Collection<IBowPart> getParts(IBowPart.BowPartType type);

  void registerPartModel(IBowPart part, ResourceLocation modelLocation);

  ResourceLocation getPartModel(IBowPart part);

  Collection<ResourceLocation> getPartModels();

  Collection<IBowPart> getBowParts(ItemStack bowStack);

  void setBowParts(ItemStack bowStack, Collection<IBowPart> bowParts);
}

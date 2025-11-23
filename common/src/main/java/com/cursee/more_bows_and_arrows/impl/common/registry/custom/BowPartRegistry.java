package com.cursee.more_bows_and_arrows.impl.common.registry.custom;

import com.cursee.more_bows_and_arrows.api.common.bow.IBow;
import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart;
import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart.BowPartType;
import com.cursee.more_bows_and_arrows.api.common.registry.IBowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.registry.BowParts;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BowPartRegistry implements IBowPartRegistry {

  /// identifier -> part
  private final Map<ResourceLocation, IBowPart> PARTS = new LinkedHashMap<>();

  /// partType -> all parts of type partType
  private final Multimap<BowPartType, IBowPart> PARTS_BY_TYPE = MultimapBuilder.SetMultimapBuilder.hashKeys().hashSetValues().build();

  /// part -> all items that can be used for/identified as that part
  private final Multimap<IBowPart, ItemStack> partItems = MultimapBuilder.SetMultimapBuilder.hashKeys().hashSetValues().build();

  public BowPartRegistry() {}

  @Override
  public Collection<IBowPart> getRegisteredBowParts() {
    return Collections.unmodifiableCollection(PARTS.values());
  }

  @Override
  public Collection<IBowPart> getRegisteredBowPartsOfType(BowPartType type) {
    return Collections.unmodifiableCollection(PARTS_BY_TYPE.get(type));
  }

  @Override
  public <P extends IBowPart> P registerBowPart(P part) {
    Objects.requireNonNull(part);
    PARTS.put(part.getIdentifier(), part);
    PARTS_BY_TYPE.put(part.getPartType(), part);
    return part;
  }

  @Override
  public <P extends IBowPart> Collection<ItemStack> getItemsFromPart(P part) {
    return Collections.unmodifiableCollection(partItems.get(part));
  }

  @Override
  public Collection<IBowPart> getBowParts(ItemStack itemStack) {

    if (itemStack.isEmpty()) {
      return Collections.emptyList(); // nothing in stack, can't have parts
    }

    List<IBowPart> parts = new ArrayList<>();

    CompoundTag tag = itemStack.getTag();

    // if tag exists then attempt to deserialize, else return default
    if (itemStack.hasTag() && tag != null) {
      this.collectPartsFromTag(parts, tag);
    }

    if (!itemStack.hasTag() || parts.isEmpty()) {
      parts = Lists.newArrayList(BowParts.GRIP_SIMPLE, BowParts.LIMB_SIMPLE, BowParts.BOWSTRING_SIMPLE, BowParts.NOCK_TIPS_SIMPLE);
    }

    return parts;
  }

  public void collectPartsFromTag(List<IBowPart> parts, CompoundTag tag) {

    ListTag tags = tag.getList(IBow.TAG_BOW_PARTS, Tag.TAG_STRING);

    for (int i = 0; i < tags.size(); i++) {
      String identifier = tags.getString(i);
      IBowPart part = this.getPart(new ResourceLocation(identifier)); // namespaced values get decomposed("mc:cobble" -> "mc", "cobble")
      if (part != null) {
        parts.add(part);
      }
    }
  }

  public IBowPart getPart(ResourceLocation identifier) {
    return PARTS.get(identifier);
  }

  @Override
  public void setBowParts(ItemStack itemStack, Collection<IBowPart> parts) {
    ListTag list = new ListTag();
    for (IBowPart broomPart : parts) {
      list.add(StringTag.valueOf(broomPart.getIdentifier().toString()));
    }
    if(!itemStack.hasTag()) {
      itemStack.setTag(new CompoundTag());
    }
    itemStack.getTag().put(IBow.TAG_BOW_PARTS, list);
  }

  @Override
  public <P extends IBowPart> void registerPartItem(@Nullable P part, ItemStack itemStack) {
    if (part != null) {
      Objects.requireNonNull(itemStack.getItem());
      partItems.put(part, itemStack);
    }
  }
}

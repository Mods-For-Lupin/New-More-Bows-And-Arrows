package com.cursee.more_bows_and_arrows.impl.common.registry.custom;

import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart;
import com.cursee.more_bows_and_arrows.api.common.registry.custom.IBowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.registry.BowParts;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BowPartRegistry implements IBowPartRegistry {

  private static final String NBT_TAG_NAME = "bow_parts";

  private final Map<ResourceLocation, IBowPart> parts = Maps.newLinkedHashMap();
  private final Multimap<IBowPart, ItemStack> partItems = MultimapBuilder.SetMultimapBuilder.hashKeys().hashSetValues().build();
  private final Multimap<IBowPart.BowPartType, IBowPart> partsByType = MultimapBuilder.SetMultimapBuilder.hashKeys().hashSetValues().build();

  @Override
  public Collection<IBowPart> getBowParts() {
    return Collections.unmodifiableCollection(parts.values());
  }

  @Override
  public Collection<IBowPart> getBowParts(ItemStack itemStack) {

    if (itemStack.isEmpty()) {
      return Collections.emptyList();
    }

    List<IBowPart> parts = new ArrayList<>();

    @Nullable CompoundTag tag = itemStack.getTag();

    if (tag != null) {
      ListTag tags = tag.getList(NBT_TAG_NAME, Tag.TAG_STRING);
      for (int i = 0; i < tags.size(); i++) {
        String id = tags.getString(i);
        IBowPart part = getPart(new ResourceLocation(id));
        if (part != null) {
          parts.add(part);
        }
      }
    }

    if (parts.isEmpty()) {
      if (BowParts.GRIP_SIMPLE != null) {
        return Lists.newArrayList(BowParts.GRIP_SIMPLE, BowParts.LIMB_SIMPLE, BowParts.NOCK_TIPS_SIMPLE, BowParts.STRING_SIMPLE);
      }
    }

    return parts;
  }

  @Override
  public <P extends IBowPart> P registerPart(P part) {
    Objects.requireNonNull(part);
    parts.put(part.getId(), part);
    partsByType.put(part.getType(), part);
    return part;
  }

  @Override
  public IBowPart getPart(ResourceLocation identifier) {
    return parts.get(identifier);
  }

  @Override
  public <P extends IBowPart> Collection<ItemStack> getItemsFromPart(P part) {
    return Collections.unmodifiableCollection(partItems.get(part));
  }
}

package com.cursee.more_bows_and_arrows.impl.common.registry.custom;

import com.cursee.more_bows_and_arrows.api.bow.IBowPart;
import com.cursee.more_bows_and_arrows.api.bow.IBowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.item.bow.BowModifier;
import com.cursee.more_bows_and_arrows.impl.common.registry.BowParts;
import com.cursee.more_bows_and_arrows.platform.Services;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

public class BowPartRegistry implements IBowPartRegistry {

  private static final String NBT_TAG_NAME = "bow_parts_tag";

  private final Map<ResourceLocation, IBowPart> parts = Maps.newLinkedHashMap();
  private final Multimap<IBowPart, ItemStack> partItems = MultimapBuilder.SetMultimapBuilder.hashKeys().hashSetValues().build();
  private final Multimap<IBowPart.BowPartType, IBowPart> partsByType = MultimapBuilder.SetMultimapBuilder.hashKeys().hashSetValues().build();
  private final Map<IBowPart, Map<BowModifier, Float>> baseModifiers = Maps.newHashMap();

  // client-side!
  private Map<IBowPart, ResourceLocation> partModels;

  public BowPartRegistry() {
    if (Services.PLATFORM.isClientSide()) {
      partModels = Maps.newHashMap();
    }
  }

  @Override
  public <P extends IBowPart> P registerPart(P part) {
    Objects.requireNonNull(part);
    parts.put(part.getId(), part);
    partsByType.put(part.getType(), part);
    return part;
  }

  @Override
  public <P extends IBowPart> void registerPartItem(@javax.annotation.Nullable P part, ItemStack item) {
    if (part != null) {
      Objects.requireNonNull(item.getItem());
      partItems.put(part, item);
    }
  }

  @Override
  public <P extends IBowPart> void registerBaseModifiers(@Nullable P part, Map<BowModifier, Float> modifiers) {
    if (part != null) {
      baseModifiers.put(part, modifiers);
    }
  }

  @Override
  public <P extends IBowPart> void registerBaseModifiers(@Nullable P part, BowModifier modifier, float modifierValue) {
    Map<BowModifier, Float> map = Maps.newHashMap();
    map.put(modifier, modifierValue);
    registerBaseModifiers(part, map);
  }

  @Override
  public <P extends IBowPart> Map<BowModifier, Float> getBaseModifiersFromPart(P part) {
    if(baseModifiers.containsKey(part)) {
      return baseModifiers.get(part);
    }
    return Collections.emptyMap();
  }

  @Override
  public Map<BowModifier, Float> getBaseModifiersFromBow(ItemStack broomStack) {
    Map<BowModifier, Float> baseModifiers = Maps.newHashMap();
    for (IBowPart part : getBowParts(broomStack)) {
      for (Map.Entry<BowModifier, Float> entry : BowParts.REGISTRY.getBaseModifiersFromPart(part).entrySet()) {
        BowModifier modifier = entry.getKey();
        if(baseModifiers.containsKey(modifier)) {
          baseModifiers.put(modifier, entry.getValue() + baseModifiers.get(modifier));
        } else{
          baseModifiers.put(modifier, entry.getValue());
        }
      }
    }
    return baseModifiers;
  }

  @Override
  public <P extends IBowPart> Collection<ItemStack> getItemsFromPart(P part) {
    return Collections.unmodifiableCollection(partItems.get(part));
  }

  @Override
  public <P extends IBowPart> P getPartFromItem(ItemStack item) {
    for (Map.Entry<IBowPart, ItemStack> entry : partItems.entries()) {
      if (ItemStack.isSameItemSameTags(item, entry.getValue())) {
        return (P) entry.getKey();
      }
    }
    return null;
  }

  @Override
  public Collection<IBowPart> getParts() {
    return Collections.unmodifiableCollection(parts.values());
  }

  @Override
  public IBowPart getPart(ResourceLocation partId) {
    return parts.get(partId);
  }

  @Override
  public Collection<IBowPart> getParts(IBowPart.BowPartType type) {
    return Collections.unmodifiableCollection(partsByType.get(type));
  }

  @Override
  @OnlyIn(Dist.CLIENT)
  public void registerPartModel(IBowPart part, ResourceLocation modelLocation) {
    partModels.put(part, modelLocation);
  }

  @Override
  @OnlyIn(Dist.CLIENT)
  public ResourceLocation getPartModel(IBowPart part) {
    return partModels.get(part);
  }

  @Override
  @OnlyIn(Dist.CLIENT)
  public Collection<ResourceLocation> getPartModels() {
    return Collections.unmodifiableCollection(partModels.values());
  }

  @Override
  public Collection<IBowPart> getBowParts(ItemStack broomStack) {
    if(!broomStack.isEmpty()) {
      List<IBowPart> parts = Lists.newArrayList();
      if(broomStack.hasTag()) {
        ListTag tags = broomStack.getTag().getList(NBT_TAG_NAME, Tag.TAG_STRING);
        for (int i = 0; i < tags.size(); i++) {
          String id = tags.getString(i);
          IBowPart part = getPart(new ResourceLocation(id));
          if (part != null) {
            parts.add(part);
          }
        }
      }

      if(parts.isEmpty()) {
        // BroomParts.BRUSH_WHEAT can be null during mod loading
        if (BowParts.GRIP_SIMPLE != null) {
          return Lists.newArrayList(BowParts.GRIP_SIMPLE, BowParts.LIMB_SIMPLE, BowParts.BOWSTRING_SIMPLE);
        }
      }

      return parts;
    }
    return Collections.emptyList();
  }

  @Override
  public void setBowParts(ItemStack broomStack, Collection<IBowPart> broomParts) {
    ListTag list = new ListTag();
    for (IBowPart broomPart : broomParts) {
      list.add(StringTag.valueOf(broomPart.getId().toString()));
    }
    if(!broomStack.hasTag()) {
      broomStack.setTag(new CompoundTag());
    }
    broomStack.getTag().put(NBT_TAG_NAME, list);
  }
}

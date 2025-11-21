package com.cursee.more_bows_and_arrows.impl.common.item.bow;

import com.cursee.more_bows_and_arrows.api.bow.IBowModifier;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import oshi.util.tuples.Pair;

public class BowModifier implements IBowModifier {

  private final ResourceLocation id;
  private final BowModifierType type;
  private final float defaultValue;
  private final float tierValue;
  private final int maxTiers;
  private final boolean baseModifier;
  private final List<ChatFormatting> tooltipFormats;

  public BowModifier(ResourceLocation id, BowModifierType type, float defaultValue,
      float tierValue, int maxTiers, boolean baseModifier,
      List<ChatFormatting> tooltipFormats) {
    this.id = id;
    this.type = type;
    this.defaultValue = defaultValue;
    this.tierValue = tierValue;
    this.maxTiers = maxTiers;
    this.baseModifier = baseModifier;
    this.tooltipFormats = tooltipFormats;

    if (isBaseModifier()) {
      this.tooltipFormats.add(ChatFormatting.ITALIC);
    }
  }

  public BowModifier(ResourceLocation id, BowModifierType type, float defaultValue,
      float tierValue, int maxTiers, boolean baseModifier,
      ChatFormatting singleFormat) {
    this(id, type, defaultValue, tierValue, maxTiers, baseModifier, Lists.newArrayList(singleFormat));
  }

  @Override
  public ResourceLocation getId() {
    return id;
  }

  @Override
  public BowModifierType getType() {
    return type;
  }

  @Override
  public float getTierValue() {
    return this.tierValue;
  }

  @Override
  public int getMaxTiers() {
    return this.maxTiers;
  }

  @Override
  public boolean isBaseModifier() {
    return baseModifier;
  }

  @Override
  public float getDefaultValue() {
    return defaultValue;
  }

  public float apply(float baseValue, List<Float> values) {
    float value = baseValue;
    for (Float v : values) {
      value = getType().applier().apply(new Pair<>(value, v));
    }
    return value;
  }

  public static int getTier(BowModifier modifier, float value) {
    return (int) Math.ceil(value / modifier.getTierValue());
  }
}

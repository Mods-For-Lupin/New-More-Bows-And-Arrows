package com.cursee.more_bows_and_arrows.impl.common.item.bow;

import com.cursee.more_bows_and_arrows.api.bow.IBowModifier;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import oshi.util.tuples.Pair;

public class BowModifier implements IBowModifier {

  private final ResourceLocation id;
  private final BowModifierType type;
  private final float defaultValue;
  private final float tierValue;
  private final int maxTier;
  private final boolean baseModifier;
  private final List<ChatFormatting> tooltipFormats;

  public BowModifier(ResourceLocation id, BowModifierType type, float defaultValue, float tierValue, int maxTier,
      boolean baseModifier, List<ChatFormatting> tooltipFormats) {
    this.id = id;
    this.type = type;
    this.defaultValue = defaultValue;
    this.tierValue = tierValue;
    this.maxTier = maxTier;
    this.baseModifier = baseModifier;
    this.tooltipFormats = tooltipFormats;

    if (this.isBaseModifier()) {
      this.tooltipFormats.add(ChatFormatting.ITALIC);
    }
  }

  @Override
  public BowModifierType getType() {
    return this.type;
  }

  @Override
  public ResourceLocation getId() {
    return this.id;
  }

  @Override
  public float getDefaultValue() {
    return this.defaultValue;
  }

  @Override
  public float getTierValue() {
    return this.tierValue;
  }

  @Override
  public int getMaxTier() {
    return this.maxTier;
  }

  @Override
  public boolean isBaseModifier() {
    return this.baseModifier;
  }

  @Override
  public List<ChatFormatting> getTooltipFormats() {
    return this.tooltipFormats;
  }

  @Override
  public String getTranslationKey() {
    return "bow.modifiers." + getId().getNamespace() + ".type." + getId().getPath();
  }

  public float apply(float baseValue, List<Float> values) {
    float value = baseValue;
    for (Float v : values) {
      value = type.applier().apply(new Pair<Float, Float>(value, v));
    }
    return value;
  }
}

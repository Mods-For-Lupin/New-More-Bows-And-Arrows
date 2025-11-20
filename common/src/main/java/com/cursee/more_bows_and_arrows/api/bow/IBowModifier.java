package com.cursee.more_bows_and_arrows.api.bow;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import oshi.util.tuples.Pair;

public interface IBowModifier {

  BowModifierType getType();

  ResourceLocation getId();

  float getDefaultValue();

  float getTierValue();

  int getMaxTier();

  boolean isBaseModifier();

  List<ChatFormatting> getTooltipFormats();

  String getTranslationKey();

  class BowModifierType {

    public static final BowModifierType ADDITIVE = new BowModifierType("additive", (pair) -> pair.getA() + pair.getB());
    public static final BowModifierType MULTIPLICATIVE = new BowModifierType("multiplicative", (pair) -> pair.getA() * pair.getB());
    public static final BowModifierType[] BASE_TYPES = {ADDITIVE, MULTIPLICATIVE};
    private static final List<BowModifierType> ALL_TYPES = Lists.newArrayList();

    private final String name;
    private final Function<Pair<Float, Float>, Float> function;

    public BowModifierType(String name, Function<Pair<Float, Float>, Float> function) {
      this.name = name;
      this.function = function;
      ALL_TYPES.add(this);
    }

    public static List<BowModifierType> getAllTypes() {
      return Collections.unmodifiableList(ALL_TYPES);
    }

    public String getName() {
      return name;
    }

    public Function<Pair<Float, Float>, Float> applier() {
      return function;
    }

    @Override
    public String toString() {
      return getName();
    }
  }
}

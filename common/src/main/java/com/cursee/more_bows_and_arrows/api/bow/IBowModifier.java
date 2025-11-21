package com.cursee.more_bows_and_arrows.api.bow;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import net.minecraft.resources.ResourceLocation;
import oshi.util.tuples.Pair;

public interface IBowModifier {

  ResourceLocation getId();
  BowModifierType getType();
  boolean isBaseModifier();
  float getDefaultValue();

  float getTierValue();

  int getMaxTiers();

  class BowModifierType {

    public static final BowModifierType ADDITIVE = new BowModifierType("additive", (pair) -> pair.getA() + pair.getB());
    public static final BowModifierType SUBTRACTIVE = new BowModifierType("subtractive", (pair) -> pair.getA() - pair.getB());
    public static final BowModifierType MULTIPLICATIVE = new BowModifierType("multiplicative", (pair) -> pair.getA() * pair.getB());
    public static final BowModifierType DIVISIVE = new BowModifierType("divisive", (pair) -> pair.getA() / pair.getB());
    public static final BowModifierType[] BASE_TYPES = {ADDITIVE, SUBTRACTIVE, MULTIPLICATIVE, DIVISIVE};
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

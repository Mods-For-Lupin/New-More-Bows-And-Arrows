package com.cursee.more_bows_and_arrows.api.common.bow;

import net.minecraft.resources.ResourceLocation;

public interface IBowPart {

  ResourceLocation getId();

  BowPartType getType();

  boolean shouldAutoRegisterMissingItem();

  class BowPartType {

    public static final BowPartType GRIP = new BowPartType("grip");
    public static final BowPartType LIMB = new BowPartType("limb");
    public static final BowPartType MODIFIER = new BowPartType("modifier");
    public static final BowPartType NOCK_TIPS = new BowPartType("nock_tips");
    public static final BowPartType STRING = new BowPartType("string");

    public static final BowPartType[] BASE_TYPES = {GRIP, LIMB, NOCK_TIPS, STRING};

    private final String name;

    public BowPartType(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return getName();
    }
  }
}

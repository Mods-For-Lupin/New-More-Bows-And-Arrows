package com.cursee.more_bows_and_arrows.api.common.bow;

import net.minecraft.resources.ResourceLocation;

public interface IBowPart {

  ResourceLocation getIdentifier();

  BowPartType getPartType();

  record BowPartType(String name) {
    public static BowPartType GRIP = new BowPartType("grip");
    public static BowPartType LIMB = new BowPartType("limb");
    public static BowPartType BOWSTRING = new BowPartType("bowstring");
    public static BowPartType NOCK_TIPS = new BowPartType("nock_tips");
  }
}

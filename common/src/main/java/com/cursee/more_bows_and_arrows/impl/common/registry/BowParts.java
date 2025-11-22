package com.cursee.more_bows_and_arrows.impl.common.registry;

import com.cursee.more_bows_and_arrows.MoreBowsAndArrows;
import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart;
import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart.BowPartType;
import com.cursee.more_bows_and_arrows.api.common.registry.custom.IBowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.bow.BowPartBase;
import com.cursee.more_bows_and_arrows.impl.common.bow.BowPartGrip;

public class BowParts {

  public static final IBowPartRegistry REGISTRY = MoreBowsAndArrows.instance.getRegistryManager().getRegistry(IBowPartRegistry.class);

  public static void init() {
  }

  public static IBowPart GRIP_SIMPLE;
  public static IBowPart GRIP_WOOD;
  public static IBowPart GRIP_STONE;
  public static IBowPart GRIP_BONE;
  public static IBowPart GRIP_BLAZE;
  public static IBowPart GRIP_OBSIDIAN;

  public static IBowPart LIMB_SIMPLE;
  public static IBowPart LIMB_WOOD;
  public static IBowPart LIMB_STONE;
  public static IBowPart LIMB_BONE;
  public static IBowPart LIMB_BLAZE;
  public static IBowPart LIMB_OBSIDIAN;

  public static IBowPart NOCK_TIPS_SIMPLE;
  public static IBowPart NOCK_TIPS_WOOD;
  public static IBowPart NOCK_TIPS_STONE;
  public static IBowPart NOCK_TIPS_BONE;
  public static IBowPart NOCK_TIPS_BLAZE;
  public static IBowPart NOCK_TIPS_OBSIDIAN;

  public static IBowPart STRING_SIMPLE;

  public static void loadPre() {
    GRIP_SIMPLE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_simple"), BowPartType.GRIP));
    GRIP_WOOD = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_wood"), BowPartType.GRIP));
    GRIP_STONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_stone"), BowPartType.GRIP));
    GRIP_BONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_bone"), BowPartType.GRIP));
    GRIP_BLAZE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_blaze"), BowPartType.GRIP));
    GRIP_OBSIDIAN = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_obsidian"), BowPartType.GRIP));

    LIMB_SIMPLE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_simple"), BowPartType.LIMB));
    LIMB_WOOD = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_wood"), BowPartType.LIMB));
    LIMB_STONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_stone"), BowPartType.LIMB));
    LIMB_BONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_bone"), BowPartType.LIMB));
    LIMB_BLAZE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_blaze"), BowPartType.LIMB));
    LIMB_OBSIDIAN = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_obsidian"), BowPartType.LIMB));

    NOCK_TIPS_SIMPLE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_simple"), BowPartType.NOCK_TIPS));
    NOCK_TIPS_WOOD = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_wood"), BowPartType.NOCK_TIPS));
    NOCK_TIPS_STONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_stone"), BowPartType.NOCK_TIPS));
    NOCK_TIPS_BONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_bone"), BowPartType.NOCK_TIPS));
    NOCK_TIPS_BLAZE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_blaze"), BowPartType.NOCK_TIPS));
    NOCK_TIPS_OBSIDIAN = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_obsidian"), BowPartType.NOCK_TIPS));

    STRING_SIMPLE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("string_simple"), BowPartType.STRING));
  }

  public static void loadPost() {
    for (IBowPart part : REGISTRY.getBowParts()) {
      if (part.shouldAutoRegisterMissingItem() && REGISTRY.getItemsFromPart(part).isEmpty()) {}
    }
  }
}

package com.cursee.more_bows_and_arrows.impl.common.registry;

import com.cursee.more_bows_and_arrows.MoreBowsAndArrows;
import com.cursee.more_bows_and_arrows.api.bow.IBowPart;
import com.cursee.more_bows_and_arrows.api.bow.IBowPart.BowPartType;
import com.cursee.more_bows_and_arrows.api.bow.IBowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.item.bow.BowPartBase;

public class BowParts {

  public static final IBowPartRegistry REGISTRY = MoreBowsAndArrows.instance.getCustomRegistryManager().getRegistry(IBowPartRegistry.class);

  public static void init() {
  }

  public static IBowPart GRIP_SIMPLE;
  public static IBowPart GRIP_WOOD;
  public static IBowPart GRIP_STONE;
  public static IBowPart GRIP_BONE;
  public static IBowPart GRIP_BLAZE;
  public static IBowPart GRIP_REED;
  public static IBowPart GRIP_NETHERRACK;
  public static IBowPart GRIP_OBSIDIAN;
  public static IBowPart GRIP_UNDEAD;
  public static IBowPart GRIP_PRISMARINE;
  public static IBowPart GRIP_ICE;
  public static IBowPart GRIP_SPONGE;
  public static IBowPart GRIP_ENDSTONE;
  public static IBowPart GRIP_PURPUR;
  public static IBowPart GRIP_BAMBOO;

  public static IBowPart LIMB_SIMPLE;
  public static IBowPart LIMB_WOOD;
  public static IBowPart LIMB_HORN;
  public static IBowPart LIMB_FIBERGLASS;
  public static IBowPart LIMB_CARBON_FIBER;
//  public static IBowPart LIMB_ALUMINUM_ALLOY;
//  public static IBowPart LIMB_STEEL;

  public static IBowPart BOWSTRING_SIMPLE;
  public static IBowPart BOWSTRING_SILK;
  public static IBowPart BOWSTRING_HORSE_HAIR;
  public static IBowPart BOWSTRING_HEMP;
  public static IBowPart BOWSTRING_LINEN;
  public static IBowPart BOWSTRING_RAWHIDE;
  public static IBowPart BOWSTRING_SINEW;
//  public static IBowPart BOWSTRING_DACRON;
//  public static IBowPart BOWSTRING_KEVLAR;
//  public static IBowPart BOWSTRING_VECTRAN;
//  public static IBowPart BOWSTRING_SPECTRA;
//  public static IBowPart BOWSTRING_DYNEEMA;
//  public static IBowPart BOWSTRING_SD_COMPOSITE;

  public static IBowPart NOCK_TIPS_SIMPLE;
  public static IBowPart NOCK_TIPS_SLIME;
  public static IBowPart NOCK_TIPS_GEM_DIAMOND;
  public static IBowPart NOCK_TIPS_GEM_EMERALD;
  public static IBowPart NOCK_TIPS_GEM_QUARTZ;
  public static IBowPart NOCK_TIPS_GEM_LAPIS;
  public static IBowPart NOCK_TIPS_METAL_IRON;
  public static IBowPart NOCK_TIPS_METAL_GOLD;
  public static IBowPart NOCK_TIPS_METAL_COPPER;
//  public static IBowPart NOCK_TIPS_METAL_THAUMIUM;
//  public static IBowPart NOCK_TIPS_METAL_SILVER;
//  public static IBowPart NOCK_TIPS_METAL_BRASS;
//  public static IBowPart NOCK_TIPS_METAL_ARDITE;
//  public static IBowPart NOCK_TIPS_METAL_COBALT;
//  public static IBowPart NOCK_TIPS_METAL_MANYULLYN;

  public static void loadPre() {
    GRIP_SIMPLE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_simple"), BowPartType.GRIP, 1f));
    GRIP_WOOD = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_wood"), BowPartType.GRIP, 1f));
    GRIP_STONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_stone"), BowPartType.GRIP, 1f));
    GRIP_BONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_bone"), BowPartType.GRIP, 1f));
    GRIP_BLAZE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_blaze"), BowPartType.GRIP, 1f));
    GRIP_REED = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_reed"), BowPartType.GRIP, 1f));
    GRIP_NETHERRACK = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_netherrack"), BowPartType.GRIP, 1f));
    GRIP_OBSIDIAN = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_obsidian"), BowPartType.GRIP, 1f));
    GRIP_UNDEAD = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_undead"), BowPartType.GRIP, 1f));
    GRIP_PRISMARINE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_prismarine"), BowPartType.GRIP, 1f));
    GRIP_ICE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_ice"), BowPartType.GRIP, 1f));
    GRIP_SPONGE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_sponge"), BowPartType.GRIP, 1f));
    GRIP_ENDSTONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_endstone"), BowPartType.GRIP, 1f));
    GRIP_PURPUR = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_purpur"), BowPartType.GRIP, 1f));
    GRIP_BAMBOO = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_bamboo"), BowPartType.GRIP, 1f));




  }
}

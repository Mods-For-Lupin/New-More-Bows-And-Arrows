package com.cursee.more_bows_and_arrows.impl.common.registry;

import com.cursee.more_bows_and_arrows.MoreBowsAndArrows;
import com.cursee.more_bows_and_arrows.api.bow.IBowPart;
import com.cursee.more_bows_and_arrows.api.bow.IBowPart.BowPartType;
import com.cursee.more_bows_and_arrows.api.bow.IBowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.item.bow.BowPartBase;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class BowParts {

  public static final IBowPartRegistry REGISTRY = MoreBowsAndArrows.instance.getCustomRegistryManager().getRegistry(IBowPartRegistry.class);

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

  public static void init() {
  }

  public static void loadPre() {
    GRIP_SIMPLE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_simple"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_WOOD = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_wood"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_STONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_stone"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_BONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_bone"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_BLAZE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_blaze"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_REED = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_reed"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_NETHERRACK = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_netherrack"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_OBSIDIAN = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_obsidian"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_UNDEAD = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_undead"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_PRISMARINE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_prismarine"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_ICE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_ice"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_SPONGE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_sponge"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_ENDSTONE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_endstone"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_PURPUR = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_purpur"), BowPartType.GRIP, Rarity.COMMON, false));
    GRIP_BAMBOO = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("grip_bamboo"), BowPartType.GRIP, Rarity.COMMON, false));

    LIMB_SIMPLE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_simple"), BowPartType.LIMB, Rarity.COMMON, false));
    LIMB_WOOD = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_wood"), BowPartType.LIMB, Rarity.COMMON, false));
    LIMB_HORN = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_horn"), BowPartType.LIMB, Rarity.COMMON, false));
    LIMB_FIBERGLASS = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_fiberglass"), BowPartType.LIMB, Rarity.COMMON, false));
    LIMB_CARBON_FIBER = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("limb_carbon_fiber"), BowPartType.LIMB, Rarity.COMMON, false));
    
    BOWSTRING_SIMPLE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("bowstring_simple"), BowPartType.BOWSTRING, Rarity.COMMON, false));
    BOWSTRING_SILK = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("bowstring_silk"), BowPartType.BOWSTRING, Rarity.COMMON, false));
    BOWSTRING_HORSE_HAIR = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("bowstring_horse_hair"), BowPartType.BOWSTRING, Rarity.COMMON, false));
    BOWSTRING_HEMP = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("bowstring_hemp"), BowPartType.BOWSTRING, Rarity.COMMON, false));
    BOWSTRING_LINEN = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("bowstring_linen"), BowPartType.BOWSTRING, Rarity.COMMON, false));
    BOWSTRING_RAWHIDE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("bowstring_rawhide"), BowPartType.BOWSTRING, Rarity.COMMON, false));
    BOWSTRING_SINEW = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("bowstring_sinew"), BowPartType.BOWSTRING, Rarity.COMMON, false));
    
    NOCK_TIPS_SIMPLE = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_simple"), BowPartType.NOCK_TIPS, Rarity.COMMON, false));
    NOCK_TIPS_SLIME = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_slime"), BowPartType.NOCK_TIPS, Rarity.COMMON, false));
    NOCK_TIPS_GEM_DIAMOND = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_gem_diamond"), BowPartType.NOCK_TIPS, Rarity.COMMON, false));
    NOCK_TIPS_GEM_EMERALD = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_gem_emerald"), BowPartType.NOCK_TIPS, Rarity.COMMON, false));
    NOCK_TIPS_GEM_QUARTZ = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_gem_quartz"), BowPartType.NOCK_TIPS, Rarity.COMMON, false));
    NOCK_TIPS_GEM_LAPIS = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_gem_lapis"), BowPartType.NOCK_TIPS, Rarity.COMMON, false));
    NOCK_TIPS_METAL_IRON = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_metal_iron"), BowPartType.NOCK_TIPS, Rarity.COMMON, false));
    NOCK_TIPS_METAL_GOLD = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_metal_gold"), BowPartType.NOCK_TIPS, Rarity.COMMON, false));
    NOCK_TIPS_METAL_COPPER = REGISTRY.registerPart(new BowPartBase(MoreBowsAndArrows.identifier("nock_tips_metal_copper"), BowPartType.NOCK_TIPS, Rarity.COMMON, false));
  }
  
  public static void loadPost() {
    for (IBowPart part : REGISTRY.getParts()) {
      if (part.shouldAutoRegisterMissingItem() && REGISTRY.getItemsFromPart(part).isEmpty()) {
        ItemStack itemStack = new ItemStack(ModItems.BOW_PART);
        REGISTRY.setBowParts(itemStack, Collections.singleton(part));
        REGISTRY.registerPartItem(part, itemStack);
      }
    }

    REGISTRY.registerBaseModifiers(GRIP_WOOD, ImmutableMap.of());

    int combinations =
        REGISTRY.getParts(BowPartType.GRIP).size()
            * REGISTRY.getParts(BowPartType.LIMB).size()
            * REGISTRY.getParts(BowPartType.BOWSTRING).size()
            * REGISTRY.getParts(BowPartType.NOCK_TIPS).size();
    MoreBowsAndArrows.LOG.info("{} possible Bow base combinations are ready for usage!", combinations);
  }
}

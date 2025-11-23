package com.cursee.more_bows_and_arrows.impl.common.registry;

import com.cursee.more_bows_and_arrows.Constants;
import com.cursee.more_bows_and_arrows.MoreBowsAndArrows;
import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart;
import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart.BowPartType;
import com.cursee.more_bows_and_arrows.api.common.registry.IBowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.bow.BowPart;
import java.util.Collections;
import net.minecraft.world.item.ItemStack;

public class BowParts {

  public static final IBowPartRegistry REGISTRY = MoreBowsAndArrows.instance.getRegistryManager().getRegistry(IBowPartRegistry.class);

  public static IBowPart GRIP_SIMPLE;
  public static IBowPart LIMB_SIMPLE;
  public static IBowPart BOWSTRING_SIMPLE;
  public static IBowPart NOCK_TIPS_SIMPLE;

  public static void loadDuringItemRegistration() {
    GRIP_SIMPLE = REGISTRY.registerBowPart(new BowPart(MoreBowsAndArrows.identifier("grip_simple"), BowPartType.GRIP));
    LIMB_SIMPLE = REGISTRY.registerBowPart(new BowPart(MoreBowsAndArrows.identifier("limb_simple"), BowPartType.LIMB));
    BOWSTRING_SIMPLE = REGISTRY.registerBowPart(new BowPart(MoreBowsAndArrows.identifier("bowstring_simple"), BowPartType.BOWSTRING));
    NOCK_TIPS_SIMPLE = REGISTRY.registerBowPart(new BowPart(MoreBowsAndArrows.identifier("nock_tips_simple"), BowPartType.NOCK_TIPS));
  }

  public static void loadDuringPotionRegistration() {
    for (IBowPart part : REGISTRY.getRegisteredBowParts()) {
      if (REGISTRY.getItemsFromPart(part).isEmpty()) {
        ItemStack itemStack = new ItemStack(ModItems.BOW_PART);
        REGISTRY.setBowParts(itemStack, Collections.singleton(part));
        REGISTRY.registerPartItem(part, itemStack);
      }
    }

    int combinations =
        REGISTRY.getRegisteredBowPartsOfType(BowPartType.GRIP).size() *
            REGISTRY.getRegisteredBowPartsOfType(BowPartType.LIMB).size() *
            REGISTRY.getRegisteredBowPartsOfType(BowPartType.BOWSTRING).size() *
            REGISTRY.getRegisteredBowPartsOfType(BowPartType.NOCK_TIPS).size();

    MoreBowsAndArrows.LOG.info("{} bow combinations available via {}", combinations, Constants.MOD_ID);
  }
}

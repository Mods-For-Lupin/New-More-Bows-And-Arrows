package com.cursee.more_bows_and_arrows;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreBowsAndArrows {

  public static final Logger LOG = LoggerFactory.getLogger(Constants.MOD_NAME);

  public static void init() {
  }

  public static ResourceLocation identifier(String path) {
    return new ResourceLocation(Constants.MOD_ID, path);
  }
}
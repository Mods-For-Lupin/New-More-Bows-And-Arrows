package com.cursee.more_bows_and_arrows;

import com.cursee.more_bows_and_arrows.api.bow.IBowModifierRegistry;
import com.cursee.more_bows_and_arrows.api.bow.IBowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.registry.custom.BowModifierRegistry;
import com.cursee.more_bows_and_arrows.impl.common.registry.custom.BowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.registry.util.CustomRegistryManager;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreBowsAndArrows {

  public static MoreBowsAndArrows instance;
  public static final Logger LOG = LoggerFactory.getLogger(Constants.MOD_NAME);

  private final CustomRegistryManager customRegistryManager;

  public MoreBowsAndArrows() {
    this.customRegistryManager = this.constructCustomRegistryManager();

    getCustomRegistryManager().addRegistry(IBowPartRegistry.class, new BowPartRegistry());
    getCustomRegistryManager().addRegistry(IBowModifierRegistry.class, new BowModifierRegistry());

    MoreBowsAndArrows.instance = this;
  }

  public static void preInitialization() {
    if (MoreBowsAndArrows.instance == null) {
      new MoreBowsAndArrows();
    }
  }

  public static ResourceLocation identifier(String path) {
    return new ResourceLocation(Constants.MOD_ID, path);
  }

  protected CustomRegistryManager constructCustomRegistryManager() {
    return new CustomRegistryManager();
  }

  public CustomRegistryManager getCustomRegistryManager() {
    return customRegistryManager;
  }
}
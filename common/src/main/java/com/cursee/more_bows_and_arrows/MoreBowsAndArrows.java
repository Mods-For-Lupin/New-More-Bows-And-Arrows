package com.cursee.more_bows_and_arrows;

import com.cursee.more_bows_and_arrows.api.common.registry.custom.IArrowModifierRegistry;
import com.cursee.more_bows_and_arrows.api.common.registry.custom.IArrowPartRegistry;
import com.cursee.more_bows_and_arrows.api.common.registry.custom.IBowModifierRegistry;
import com.cursee.more_bows_and_arrows.api.common.registry.custom.IBowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.registry.custom.ArrowModifierRegistry;
import com.cursee.more_bows_and_arrows.impl.common.registry.custom.ArrowPartRegistry;
import com.cursee.more_bows_and_arrows.impl.common.registry.custom.BowModifierRegistry;
import com.cursee.more_bows_and_arrows.impl.common.registry.custom.BowPartRegistry;
import com.cursee.more_bows_and_arrows.util.CustomRegistryManager;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreBowsAndArrows {

  public static final Logger LOG = LoggerFactory.getLogger(Constants.MOD_NAME);
  public static MoreBowsAndArrows instance;

  private final CustomRegistryManager registryManager;

  private MoreBowsAndArrows() {

    this.registryManager = new CustomRegistryManager();

    // evilcraft's BroomPartRegistry and BroomModifierRegistry have side effects of registering events for
    // ItemTooltipEvent and RegisterEvent
    getRegistryManager().addRegistry(IArrowModifierRegistry.class, new ArrowModifierRegistry());
    getRegistryManager().addRegistry(IArrowPartRegistry.class, new ArrowPartRegistry());
    getRegistryManager().addRegistry(IBowModifierRegistry.class, new BowModifierRegistry());
    getRegistryManager().addRegistry(IBowPartRegistry.class, new BowPartRegistry());

    MoreBowsAndArrows.instance = this;
  }

  /// calls to the common constructor to create our singleton instance.
  public static void preInitialization() {
    if (MoreBowsAndArrows.instance == null) {
      new MoreBowsAndArrows();
    }
  }

  public static ResourceLocation identifier(String path) {
    return new ResourceLocation(Constants.MOD_ID, path);
  }

  public CustomRegistryManager getRegistryManager() {
    return registryManager;
  }
}
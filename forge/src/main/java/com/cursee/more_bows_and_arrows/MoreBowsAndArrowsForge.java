package com.cursee.more_bows_and_arrows;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLLoader;

@Mod(Constants.MOD_ID)
public class MoreBowsAndArrowsForge {

  public static IEventBus eventBus;

  public MoreBowsAndArrowsForge(final FMLJavaModLoadingContext context) {

    MoreBowsAndArrowsForge.eventBus = context.getModEventBus();

    MoreBowsAndArrows.init();

    if (FMLLoader.getDist() == Dist.CLIENT || FMLEnvironment.dist == Dist.CLIENT) {
      new MoreBowsAndArrowsClientForge();
    }
  }

  public MoreBowsAndArrowsForge() {
    this(FMLJavaModLoadingContext.get());
  }
}
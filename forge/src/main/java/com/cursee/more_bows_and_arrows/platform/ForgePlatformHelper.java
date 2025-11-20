package com.cursee.more_bows_and_arrows.platform;

import com.cursee.more_bows_and_arrows.platform.services.IPlatformHelper;
import java.nio.file.Path;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper implements IPlatformHelper {

  @Override
  public String getPlatformName() {

    return "Forge";
  }

  @Override
  public boolean isModLoaded(String modId) {

    return ModList.get().isLoaded(modId);
  }

  @Override
  public boolean isDevelopmentEnvironment() {

    return !FMLLoader.isProduction();
  }

  @Override
  public Path getGameDirectory() {

    return FMLLoader.getGamePath();
  }

  @Override
  public boolean isClientSide() {

    return FMLLoader.getDist() == Dist.CLIENT;
  }

  @Override
  public boolean isClientSideThread() {
    Level level = Minecraft.getInstance().level;
    return isClientSide() && level != null && Thread.currentThread() == level.thread;
  }
}
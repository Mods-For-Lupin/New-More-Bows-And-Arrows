package com.cursee.more_bows_and_arrows.mixin.client;

import com.cursee.more_bows_and_arrows.MoreBowsAndArrows;
import com.cursee.more_bows_and_arrows.platform.Services;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class FabricTitleScreenMixin {

  @Inject(at = @At("HEAD"), method = "init()V")
  private void init(CallbackInfo info) {

    if (Services.PLATFORM.isDevelopmentEnvironment()) {
      MoreBowsAndArrows.LOG.info("This line is printed by an example mixin from Fabric!");
      MoreBowsAndArrows.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
  }
}
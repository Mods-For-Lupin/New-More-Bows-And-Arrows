package com.cursee.more_bows_and_arrows.mixin;

import com.cursee.more_bows_and_arrows.MoreBowsAndArrowsFabric;
import com.cursee.more_bows_and_arrows.impl.common.registry.BowParts;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BuiltInRegistries.class)
public class FabricBuiltInRegistriesMixin {

//  @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/core/registries/BuiltInRegistries;registerDefaultedWithIntrusiveHolders(Lnet/minecraft/resources/ResourceKey;Ljava/lang/String;Lnet/minecraft/core/registries/BuiltInRegistries$RegistryBootstrap;)Lnet/minecraft/core/DefaultedRegistry;", ordinal = 4), method = "<clinit>")
//  private static void more_bows_and_arrows$postItemBootstrap(CallbackInfo ci) {
//    // BowParts.loadDuringItemRegistration();
//    MoreBowsAndArrowsFabric.duringItemRegistration.run();
//  }
//
//  @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/core/registries/BuiltInRegistries;registerDefaulted(Lnet/minecraft/resources/ResourceKey;Ljava/lang/String;Lnet/minecraft/core/registries/BuiltInRegistries$RegistryBootstrap;)Lnet/minecraft/core/DefaultedRegistry;", ordinal = 0), method = "<clinit>")
//  private static void more_bows_and_arrows$postPotionBootstrap(CallbackInfo ci) {
//    // BowParts.loadDuringPotionRegistration();
//    MoreBowsAndArrowsFabric.duringPotionRegistration.run();
//  }

  /// in actuality, we are constructing our bow parts before items are initialized... this might break some things
  @Inject(at = @At("HEAD"), method = "bootStrap")
  private static void injectedHEAD(CallbackInfo ci) {
    BowParts.loadDuringItemRegistration();
    // MoreBowsAndArrowsFabric.duringItemRegistration.run();
  }

  /// this seems safer, after initialization of registries we build our internal parts
  @Inject(at = @At("TAIL"), method = "bootStrap")
  private static void injectedTAIL(CallbackInfo ci) {
    BowParts.loadDuringPotionRegistration();
    // MoreBowsAndArrowsFabric.duringPotionRegistration.run();
  }
}

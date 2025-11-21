package com.cursee.more_bows_and_arrows;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class MoreBowsAndArrowsForge {

  public static IEventBus eventBus;

  public MoreBowsAndArrowsForge(final FMLJavaModLoadingContext context) {

    MoreBowsAndArrowsForge.eventBus = context.getModEventBus();

    // bind(Registries.ITEM, ModItems::register);
    // bind(Registries.RECIPE_SERIALIZER, ModRecipeSerializers::register);

    if (FMLLoader.getDist() == Dist.CLIENT || FMLEnvironment.dist == Dist.CLIENT) {
      new MoreBowsAndArrowsClientForge();
    }
  }

  public MoreBowsAndArrowsForge() {
    this(FMLJavaModLoadingContext.get());
  }

  public static <T> void bind(ResourceKey<Registry<T>> registryKey, Consumer<BiConsumer<T, ResourceLocation>> source) {
    eventBus.addListener((Consumer<RegisterEvent>) event -> {
      if (registryKey.equals(event.getRegistryKey())) {
        source.accept((t, rl) -> event.register(registryKey, rl, () -> t));
      }
    });
  }
}
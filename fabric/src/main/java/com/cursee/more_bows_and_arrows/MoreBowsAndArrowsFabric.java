package com.cursee.more_bows_and_arrows;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class MoreBowsAndArrowsFabric implements ModInitializer {

  public static <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
    source.accept((t, rl) -> Registry.register(registry, rl, t));
  }

  @Override
  public void onInitialize() {

    // no event bus

    // bind(BuiltInRegistries.ITEM, ModItems::register);
    // bind(BuiltInRegistries.RECIPE_SERIALIZER, ModRecipeSerializers::register);

    // no client init from common
  }
}

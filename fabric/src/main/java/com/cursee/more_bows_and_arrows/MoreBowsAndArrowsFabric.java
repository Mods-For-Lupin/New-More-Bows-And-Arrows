package com.cursee.more_bows_and_arrows;

import com.cursee.more_bows_and_arrows.impl.common.registry.ModItems;
import com.cursee.more_bows_and_arrows.impl.common.registry.ModRecipeSerializers;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class MoreBowsAndArrowsFabric implements ModInitializer {

  public static <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
    source.accept((t, rl) -> Registry.register(registry, rl, t));
  }

  @Override
  public void onInitialize() {

    bind(BuiltInRegistries.ITEM, ModItems::register);
    bind(BuiltInRegistries.RECIPE_SERIALIZER, ModRecipeSerializers::register);

    MoreBowsAndArrows.init();
  }
}

package com.cursee.more_bows_and_arrows;

import com.cursee.more_bows_and_arrows.impl.common.registry.BowParts;
import com.cursee.more_bows_and_arrows.impl.common.registry.ModItems;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

public class MoreBowsAndArrowsFabric implements ModInitializer {

  public static final Runnable duringItemRegistration = () -> BowParts.loadDuringItemRegistration();
  public static final Runnable duringPotionRegistration = () -> BowParts.loadDuringPotionRegistration();

  public static <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
    source.accept((t, rl) -> Registry.register(registry, rl, t));
  }

  @Override
  public void onInitialize() {

    MoreBowsAndArrows.preInitialization();

    // no event bus

    bind(BuiltInRegistries.ITEM, ModItems::register);
    // bind(BuiltInRegistries.RECIPE_SERIALIZER, ModRecipeSerializers::register);

    // no client init from common

//    DynamicRegistrySetupCallback.EVENT.register(view -> {
//      view.getOptional(Registries.ITEM).ifPresent(items -> {
//        System.out.println("called code during item registration?");
//        BowParts.loadDuringItemRegistration();
//      });
//      view.getOptional(Registries.POTION).ifPresent(items -> {
//        System.out.println("called code during potion registration?");
//        BowParts.loadDuringPotionRegistration();
//      });
//    });
  }
}

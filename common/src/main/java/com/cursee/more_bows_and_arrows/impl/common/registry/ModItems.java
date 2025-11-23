package com.cursee.more_bows_and_arrows.impl.common.registry;

import com.cursee.more_bows_and_arrows.MoreBowsAndArrows;
import com.cursee.more_bows_and_arrows.impl.common.item.BowPartItem;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class ModItems {

  public static Item BOW_PART;

  public static void register(BiConsumer<Item, ResourceLocation> consumer) {

    BOW_PART = new BowPartItem(new Properties());

    consumer.accept(BOW_PART, MoreBowsAndArrows.identifier("bow_part"));
  }
}

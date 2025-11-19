package com.cursee.more_bows_and_arrows.impl.common.registry;

import com.cursee.more_bows_and_arrows.MoreBowsAndArrows;
import com.cursee.more_bows_and_arrows.impl.common.item.ArrowPartItem;
import com.cursee.more_bows_and_arrows.impl.common.item.BowPartItem;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class ModItems {

  public static Item BOW;
  public static Item BOW_PART;

  public static Item ARROW;
  public static Item ARROW_PART;

  public static void register(BiConsumer<Item, ResourceLocation> consumer) {
    BOW = new BowItem(new Properties());
    BOW_PART = new BowPartItem(new Properties());

    ARROW = new ArrowItem(new Properties());
    ARROW_PART = new ArrowPartItem(new Properties());

    consumer.accept(BOW, MoreBowsAndArrows.identifier("bow"));
    consumer.accept(BOW_PART, MoreBowsAndArrows.identifier("bow_part"));
    
    consumer.accept(ARROW, MoreBowsAndArrows.identifier("arrow"));
    consumer.accept(ARROW_PART, MoreBowsAndArrows.identifier("arrow_part"));
  }
}

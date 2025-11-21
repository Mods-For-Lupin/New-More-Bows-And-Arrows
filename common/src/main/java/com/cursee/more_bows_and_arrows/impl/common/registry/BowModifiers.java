package com.cursee.more_bows_and_arrows.impl.common.registry;

import com.cursee.more_bows_and_arrows.MoreBowsAndArrows;
import com.cursee.more_bows_and_arrows.api.bow.IBowModifier.BowModifierType;
import com.cursee.more_bows_and_arrows.api.bow.IBowModifierRegistry;
import com.cursee.more_bows_and_arrows.impl.common.item.bow.BowModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class BowModifiers {

  public static final IBowModifierRegistry REGISTRY = MoreBowsAndArrows.instance.getCustomRegistryManager().getRegistry(IBowModifierRegistry.class);
  public static BowModifier MODIFIER_COUNT;
  public static BowModifier DAMAGE;
  public static BowModifier DRAW_SPEED;
  public static BowModifier MOVEMENT_PENALTY;
  public static BowModifier FLAME;

  public static void init() {
  }

  public static void loadPre() {
    MODIFIER_COUNT = REGISTRY.registerModifier(new BowModifier(MoreBowsAndArrows.identifier("modifier_count"), BowModifierType.ADDITIVE, 0f, 1f, 3, true, ChatFormatting.BOLD));
    REGISTRY.overrideDefaultModifierPart(MODIFIER_COUNT, null);

    DAMAGE = REGISTRY.registerModifier(new BowModifier(MoreBowsAndArrows.identifier("damage"), BowModifierType.ADDITIVE, 0F, 100F, 3, false, ChatFormatting.GRAY));
    DRAW_SPEED = REGISTRY.registerModifier(new BowModifier(MoreBowsAndArrows.identifier("draw_speed"), BowModifierType.ADDITIVE, 0F, 100F, 3, false, ChatFormatting.GRAY));
    MOVEMENT_PENALTY = REGISTRY.registerModifier(new BowModifier(MoreBowsAndArrows.identifier("movement_penalty"), BowModifierType.ADDITIVE, 0F, 100F, 3, false, ChatFormatting.GRAY));
    FLAME = REGISTRY.registerModifier(new BowModifier(MoreBowsAndArrows.identifier("flame"), BowModifierType.ADDITIVE, 0F, 100F, 3, false, ChatFormatting.GRAY));
  }

  public static void loadPost() {
    REGISTRY.clearModifierItems();

    REGISTRY.registerModifiersItem(MODIFIER_COUNT, 1F, new ItemStack(Items.NETHER_STAR));

    REGISTRY.registerModifiersItem(DAMAGE, 1F, new ItemStack(Items.IRON_SWORD));
    REGISTRY.registerModifiersItem(DAMAGE, 5F, new ItemStack(Items.DIAMOND_SWORD));

    REGISTRY.registerModifiersItem(DRAW_SPEED, 1F, new ItemStack(Items.REDSTONE));
    REGISTRY.registerModifiersItem(DRAW_SPEED, 9F, new ItemStack(Blocks.REDSTONE_BLOCK));

    REGISTRY.registerModifiersItem(MOVEMENT_PENALTY, 1F, new ItemStack(Items.FEATHER));
    REGISTRY.registerModifiersItem(MOVEMENT_PENALTY, 50F, new ItemStack(Items.PHANTOM_MEMBRANE));

    REGISTRY.registerModifiersItem(FLAME, 1F, new ItemStack(Items.BLAZE_POWDER));
  }
}

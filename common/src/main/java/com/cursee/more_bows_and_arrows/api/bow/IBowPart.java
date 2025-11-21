package com.cursee.more_bows_and_arrows.api.bow;

import com.cursee.more_bows_and_arrows.Constants;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.Nullable;

public interface IBowPart {

  BowPartType getType();

  ResourceLocation getId();

  @Nullable Component getTooltipLine(String prefix);

  Rarity getRarity();

  boolean isEffect();

  boolean shouldAutoRegisterMissingItem();

  String getTranslationKey();

  class BowPartType {

    public static final BowPartType GRIP = new BowPartType("grip");
    public static final BowPartType LIMB = new BowPartType("limb");
    public static final BowPartType BOWSTRING = new BowPartType("bowstring");
    public static final BowPartType NOCK_TIPS = new BowPartType("nock_tips");
    public static final BowPartType MODIFIER = new BowPartType("modifier");
    public static final BowPartType[] BASE_TYPES = {GRIP, LIMB, BOWSTRING, NOCK_TIPS};
    private static final List<BowPartType> ALL_TYPES = Lists.newArrayList();

    private final String name;

    public BowPartType(String name) {
      this.name = name;
      ALL_TYPES.add(this);
    }

    public static List<BowPartType> getAllTypes() {
      return Collections.unmodifiableList(ALL_TYPES);
    }

    public String getName() {
      return name;
    }

    public String getTranslationKey() {
      return "bow.parts." + Constants.MOD_ID + ".type." + getName() + ".name";
    }

    @Override
    public String toString() {
      return getName();
    }
  }
}

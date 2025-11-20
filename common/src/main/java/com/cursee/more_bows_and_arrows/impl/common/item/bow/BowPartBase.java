package com.cursee.more_bows_and_arrows.impl.common.item.bow;

import com.cursee.more_bows_and_arrows.api.bow.IBowPart;
import com.cursee.more_bows_and_arrows.api.bow.IBowPart.BowPartType;
import com.cursee.more_bows_and_arrows.platform.Services;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Rarity;

public class BowPartBase implements IBowPart {

  private final ResourceLocation id;
  private final BowPartType type;
  private final float length;
  private final Rarity rarity;
  private final boolean effect;

  public BowPartBase(ResourceLocation id, BowPartType type, float length) {
    this(id, type, length, Rarity.COMMON, false);
  }

  public BowPartBase(ResourceLocation id, BowPartType type, float length, Rarity rarity, boolean effect) {
    this.id = id;
    this.type = type;
    this.length = length;
    this.rarity = rarity;
    this.effect = effect;
    if(Services.PLATFORM.isClientSide()) {
      registerModelResourceLocation();
    }
  }

  @Override
  public BowPartType getType() {
    return this.type;
  }

  @Override
  public ResourceLocation getId() {
    return this.id;
  }

  @Override
  public String getTranslationKey() {
    return "bow.parts." + getId().getNamespace() + "." + getId().getPath();
  }

  @Override
  public Component getTooltipLine(String prefix) {
    return null;
  }

  @Override
  public float getLength() {
    return 0;
  }

  @Override
  public Rarity getRarity() {
    return null;
  }

  @Override
  public boolean isEffect() {
    return false;
  }

  @Override
  public int getModelColor() {
    return 0;
  }

  @Override
  public boolean shouldAutoRegisterMissingItem() {
    return false;
  }
}

package com.cursee.more_bows_and_arrows.impl.common.bow;

import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart;
import net.minecraft.resources.ResourceLocation;

public class BowPartBase implements IBowPart {

  private final ResourceLocation identifier;
  private final BowPartType type;

  public BowPartBase(ResourceLocation identifier, BowPartType type) {
    this.identifier = identifier;
    this.type = type;
  }

  @Override
  public ResourceLocation getId() {
    return this.identifier;
  }

  @Override
  public BowPartType getType() {
    return this.type;
  }

  @Override
  public boolean shouldAutoRegisterMissingItem() {
    return true;
  }
}

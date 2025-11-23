package com.cursee.more_bows_and_arrows.impl.common.bow;

import com.cursee.more_bows_and_arrows.api.common.bow.IBowPart;
import net.minecraft.resources.ResourceLocation;

public class BowPart implements IBowPart {

  private final ResourceLocation identifier;
  private final BowPartType partType;

  public BowPart(ResourceLocation identifier, BowPartType partType) {
    this.identifier = identifier;
    this.partType = partType;
  }

  @Override
  public ResourceLocation getIdentifier() {
    return this.identifier;
  }

  @Override
  public BowPartType getPartType() {
    return this.partType;
  }
}

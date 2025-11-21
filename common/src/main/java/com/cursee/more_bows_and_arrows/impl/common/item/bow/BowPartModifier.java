package com.cursee.more_bows_and_arrows.impl.common.item.bow;

import com.cursee.more_bows_and_arrows.impl.common.registry.BowParts;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Rarity;

public class BowPartModifier extends BowPartBase {

  private final BowModifier modifier;

  public BowPartModifier(BowModifier modifier) {
    super(modifier.getId(), BowPartType.MODIFIER);
    this.modifier = modifier;
  }

  @Override
  protected void registerModelResourceLocation() {
    BowParts.REGISTRY.registerPartModel(this,
        new ResourceLocation(getId().getNamespace(), "bow_part/ring"));
  }

  @Nullable
  @Override
  public Component getTooltipLine(String prefix) {
    return null;
  }

  @Override
  public boolean shouldAutoRegisterMissingItem() {
    return false;
  }

//  @Override
//  public int getModelColor() {
//    return modifier.getBakedQuadModelColor();
//  }
}

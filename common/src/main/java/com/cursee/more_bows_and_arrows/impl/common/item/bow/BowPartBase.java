package com.cursee.more_bows_and_arrows.impl.common.item.bow;

import com.cursee.more_bows_and_arrows.api.bow.IBowPart;
import com.cursee.more_bows_and_arrows.impl.common.registry.BowParts;
import com.cursee.more_bows_and_arrows.platform.Services;
import java.util.Locale;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.Nullable;

public class BowPartBase implements IBowPart {

  private final ResourceLocation id;
  private final BowPartType type;
  private final Rarity rarity;
  private final boolean effect;

  public BowPartBase(ResourceLocation id, BowPartType type) {
    this(id, type, Rarity.COMMON, false);
  }

  public BowPartBase(ResourceLocation id, BowPartType type, Rarity rarity, boolean effect) {
    this.id = id;
    this.type = type;
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

  public ResourceLocation getId() {
    return this.id;
  }

  protected void registerModelResourceLocation() {
    BowParts.REGISTRY.registerPartModel(this,
        new ResourceLocation(getId().getNamespace(), "bow_part/" + getId().getPath().toLowerCase(Locale.ROOT)));
  }

  @Override
  public String getTranslationKey() {
    return "bow.parts." + getId().getNamespace() + "." + getId().getPath();
  }

  @Override
  public @Nullable Component getTooltipLine(String prefix) {
    return Component.literal(prefix)
        .append(Component.translatable(getTranslationKey()));
  }

  @Override
  public Rarity getRarity() {
    return this.rarity;
  }

  @Override
  public boolean isEffect() {
    return this.effect;
  }

  @Override
  public boolean shouldAutoRegisterMissingItem() {
    return true;
  }

//  @Override
//  public int getModelColor() {
//    return Helpers.RGBAToInt(255, 255, 255, 255);
//  }
}

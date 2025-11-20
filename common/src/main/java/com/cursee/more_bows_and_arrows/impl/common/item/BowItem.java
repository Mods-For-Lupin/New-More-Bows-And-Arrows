package com.cursee.more_bows_and_arrows.impl.common.item;

import com.cursee.more_bows_and_arrows.api.bow.IBow;
import com.cursee.more_bows_and_arrows.api.bow.IBowModifier;
import com.cursee.more_bows_and_arrows.api.bow.IBowPart;
import java.util.Collection;
import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BowItem extends Item implements IBow {

  public BowItem(Properties properties) {
    super(properties);
  }

  @Override
  public Collection<IBowPart> getBowParts(ItemStack itemStack) {
    return List.of();
  }

  @Override
  public Collection<IBowModifier> getBowModifiers(ItemStack itemStack) {
    return List.of();
  }

  @Override
  public Boolean canConsumeBowEnergy(int amount, ItemStack itemStack, @Nullable LivingEntity livingEntity) {
    return false;
  }

  @Override
  public Integer tryConsumeBowEnergy(int amount, ItemStack itemStack, @Nullable LivingEntity livingEntity) {
    return 0;
  }
}

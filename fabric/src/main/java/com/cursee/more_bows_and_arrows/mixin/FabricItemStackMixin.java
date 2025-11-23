package com.cursee.more_bows_and_arrows.mixin;

import com.cursee.more_bows_and_arrows.api.fabric.access.ItemStackAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/// [nbt-recipes](https://github.com/benhengeveld/nbt-recipes)
@Mixin(ItemStack.class)
public class FabricItemStackMixin implements ItemStackAccessor {

  @Shadow @Nullable
  private CompoundTag tag;

  @Override
  public void more_bows_and_arrows$setTagRaw(CompoundTag data) {
    if (data == null || data.isEmpty()) {
      this.tag = null;
    } else {
      this.tag = data;
    }
  }
}

package com.cursee.more_bows_and_arrows.mixin;

//import ca.sync.nbtrecipes.utils.IItemStack;

import com.cursee.more_bows_and_arrows.api.fabric.access.ItemStackAccessor;
import com.google.gson.JsonObject;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.ShapedRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

/// [nbt-recipes](https://github.com/benhengeveld/nbt-recipes)
@Mixin(ShapedRecipe.class)
public class FabricShapedRecipeMixin {

  @Unique
  private static final String MORE_BOWS_AND_ARROWS$CUSTOM_DATA_TAG = "custom_more_bows_and_arrows_data";

  @Unique
  private static CompoundTag more_bows_and_arrows$currentNbtData;

  @Inject(method = "itemStackFromJson", at = @At(value = "INVOKE", target = "com/google/gson/JsonObject.has(Ljava/lang/String;)Z", remap = false))
  private static void getRecipesNbtData(JsonObject json, CallbackInfoReturnable<ItemStack> infoReturnable) {
    more_bows_and_arrows$currentNbtData = null;

    if (json.has(MORE_BOWS_AND_ARROWS$CUSTOM_DATA_TAG)) {
      String nbtString;

      if (GsonHelper.isStringValue(json, MORE_BOWS_AND_ARROWS$CUSTOM_DATA_TAG)) {
        nbtString = json.get(MORE_BOWS_AND_ARROWS$CUSTOM_DATA_TAG).getAsString();
      } else {
        nbtString = GsonHelper.getAsJsonObject(json, MORE_BOWS_AND_ARROWS$CUSTOM_DATA_TAG).toString();
      }

      try {
        more_bows_and_arrows$currentNbtData = new TagParser(new StringReader(nbtString)).readStruct();
      } catch (CommandSyntaxException e) {
        System.out.println(e.getMessage());
      }

      json.remove(MORE_BOWS_AND_ARROWS$CUSTOM_DATA_TAG);
    }
  }

  @Inject(method = "itemStackFromJson", at = @At("RETURN"), cancellable = true)
  private static void setRecipesNbtData(JsonObject json, CallbackInfoReturnable<ItemStack> infoReturnable, @Local Item item, @Local int amount) {
    ItemStack stack = new ItemStack(item, amount);

    if (more_bows_and_arrows$currentNbtData != null) {
      CompoundTag nbtData = more_bows_and_arrows$currentNbtData.copy();
      more_bows_and_arrows$currentNbtData = null;

      ((ItemStackAccessor) (Object) stack).more_bows_and_arrows$setTagRaw(nbtData);
    }

    infoReturnable.setReturnValue(stack);
  }
}

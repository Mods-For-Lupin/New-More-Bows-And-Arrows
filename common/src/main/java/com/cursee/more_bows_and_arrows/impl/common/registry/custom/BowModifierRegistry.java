package com.cursee.more_bows_and_arrows.impl.common.registry.custom;

import com.cursee.more_bows_and_arrows.api.bow.IBowModifierRegistry;
import com.cursee.more_bows_and_arrows.api.bow.IBowPart;
import com.cursee.more_bows_and_arrows.impl.common.item.bow.BowModifier;
import com.cursee.more_bows_and_arrows.impl.common.item.bow.BowPartModifier;
import com.cursee.more_bows_and_arrows.impl.common.registry.BowParts;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class BowModifierRegistry implements IBowModifierRegistry {

  private static final String NBT_TAG_NAME = "bow_modifiers_tag";
  private static final String NBT_TAG_KEY = "id";
  private static final String NBT_TAG_VALUE = "value";

  private final Map<ResourceLocation, BowModifier> bowModifiers = Maps.newLinkedHashMap();
  private final Map<BowModifier, IBowPart> bowModifierParts = Maps.newHashMap();
  private final Map<ItemStack, Map<BowModifier, Float>> bowItems = Maps.newHashMap();

  public BowModifierRegistry() {
    // MinecraftForge.EVENT_BUS.register(this);
  }

  @Override
  public BowModifier registerModifier(BowModifier modifier) {
    bowModifiers.put(modifier.getId(), modifier);
    BowPartModifier bowPart = new BowPartModifier(modifier);
    overrideDefaultModifierPart(modifier, bowPart);
    return modifier;
  }

  @Override
  public void overrideDefaultModifierPart(BowModifier modifier, @Nullable IBowPart bowPart) {
    bowModifierParts.put(modifier, bowPart);
    if (bowPart != null) {
      BowParts.REGISTRY.registerPart(bowPart);
    }
  }

  @Override
  public @Nullable IBowPart getModifierPart(BowModifier modifier) {
    return bowModifierParts.get(modifier);
  }

  @Override
  public void clearModifierItems() {
    bowItems.clear();
  }

  @Override
  public void registerModifiersItem(Map<BowModifier, Float> modifiers, ItemStack item) {
    Objects.requireNonNull(item.getItem());
    bowItems.put(item, modifiers);
  }

  @Override
  public void registerModifiersItem(BowModifier modifier, float modifierValue, ItemStack item) {
    Map<BowModifier, Float> map = Maps.newHashMap();
    map.put(modifier, modifierValue);
    registerModifiersItem(map, item);
  }

  @Override
  public Map<BowModifier, Float> getModifiersFromItem(ItemStack item) {
    for (Map.Entry<ItemStack, Map<BowModifier, Float>> entry : bowItems.entrySet()) {
      if (ItemStack.isSameItemSameTags(item, entry.getKey())) {
        return entry.getValue();
      }
    }
    return null;
  }

  @Override
  public Map<ItemStack, Float> getItemsFromModifier(BowModifier modifier) {
    Map<ItemStack, Float> modifiers = Maps.newHashMap();
    for (Map.Entry<ItemStack, Map<BowModifier, Float>> entry : bowItems.entrySet()) {
      for (Map.Entry<BowModifier, Float> itModifiers : entry.getValue().entrySet()) {
        if (itModifiers.getKey() == modifier) {
          modifiers.put(entry.getKey(), itModifiers.getValue());
        }
      }
    }
    return modifiers;
  }

  @Override
  public Collection<BowModifier> getModifiers() {
    return Collections.unmodifiableCollection(bowModifiers.values());
  }

  @Override
  public Map<BowModifier, Float> getModifiers(ItemStack bowStack) {
    if(bowStack != null) {
      Map<BowModifier, Float> modifiers = Maps.newHashMap();

      // Base values
      for (BowModifier modifier : getModifiers()) {
        if (modifier.isBaseModifier()) {
          modifiers.put(modifier, modifier.getDefaultValue());
        }
      }

      // Hardcoded values
      if(bowStack.hasTag()) {
        ListTag tags = bowStack.getTag().getList(NBT_TAG_NAME, Tag.TAG_COMPOUND);
        for (int i = 0; i < tags.size(); i++) {
          CompoundTag tag = tags.getCompound(i);
          String id = tag.getString(NBT_TAG_KEY);
          float value = tag.getFloat(NBT_TAG_VALUE);
          BowModifier modifier = bowModifiers.get(new ResourceLocation(id));
          if (modifier != null) {
            modifiers.put(modifier, value);
          }
        }
      }

      return modifiers;
    }
    return Collections.emptyMap();
  }

  @Override
  public void setModifiers(ItemStack bowStack, Map<BowModifier, Float> modifiers) {
    // Write modifiers
    ListTag list = new ListTag();
    for (Map.Entry<BowModifier, Float> entry : modifiers.entrySet()) {
      CompoundTag tag = new CompoundTag();
      tag.putString(NBT_TAG_KEY, entry.getKey().getId().toString());
      tag.putFloat(NBT_TAG_VALUE, entry.getValue());
      list.add(tag);
    }
    if(!bowStack.hasTag()) {
      bowStack.setTag(new CompoundTag());
    }
    bowStack.getTag().put(NBT_TAG_NAME, list);

    // Write corresponding modifier parts
    Collection<IBowPart> parts = BowParts.REGISTRY.getBowParts(bowStack);
    for (Map.Entry<BowModifier, Float> entry : modifiers.entrySet()) {
      if (entry.getValue() > 0) {
        IBowPart part = getModifierPart(entry.getKey());
        int tier = BowModifier.getTier(entry.getKey(), entry.getValue());
        if (part != null) {
          for (int i = 0; i < tier; i++) {
            parts.add(part);
          }
        }
      }
    }
    BowParts.REGISTRY.setBowParts(bowStack, parts);
  }

//  @SubscribeEvent
//  @OnlyIn(Dist.CLIENT)
//  public void onTooltipEvent(ItemTooltipEvent event) {
//    if (ItemBowConfig.bowModifierTooltips) {
//      Map<BowModifier, Float> modifiers = getModifiersFromItem(event.getItemStack());
//      if (modifiers != null) {
//        if (MinecraftHelpers.isShifted()) {
//          event.getToolTip().add(Component.translatable("bow.modifiers." + Reference.MOD_ID + ".types")
//              .withStyle(ChatFormatting.ITALIC));
//          for (Map.Entry<BowModifier, Float> entry : modifiers.entrySet()) {
//            event.getToolTip().add(entry.getKey().getTooltipLine("  ", entry.getValue(), 0, false));
//          }
//        } else {
//          event.getToolTip().add(Component.translatable("bow.modifiers." + Reference.MOD_ID + ".shiftinfo")
//              .withStyle(ChatFormatting.ITALIC));
//        }
//      }
//    }
//  }
//
//  @SubscribeEvent(priority = EventPriority.HIGHEST)
//  public void beforeItemsRegistered(RegisterEvent event) {
//    // The block registry even is called before the items event
//    if (event.getRegistryKey().equals(ForgeRegistries.Keys.BLOCKS)) {
//      bowModifiers.clear();
//      bowModifierParts.clear();
//      bowItems.clear();
//    }
//  }
}

package com.cursee.more_bows_and_arrows.impl.common.recipe;

import com.cursee.more_bows_and_arrows.api.bow.IBow;
import com.cursee.more_bows_and_arrows.api.bow.IBowPart;
import com.cursee.more_bows_and_arrows.impl.common.item.bow.BowModifier;
import com.cursee.more_bows_and_arrows.impl.common.registry.BowModifiers;
import com.cursee.more_bows_and_arrows.impl.common.registry.BowParts;
import com.cursee.more_bows_and_arrows.impl.common.registry.ModItems;
import com.cursee.more_bows_and_arrows.impl.common.registry.ModRecipeSerializers;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.tuple.Pair;

public class BowPartCombination extends CustomRecipe {

  public BowPartCombination(ResourceLocation id, CraftingBookCategory category) {
    super(id, category);
  }

  @Override
  public boolean matches(CraftingContainer craftingContainer, Level level) {
    return !assemble(craftingContainer, level.registryAccess()).isEmpty();
  }

  @Override
  public ItemStack getResultItem(RegistryAccess registryAccess) {
    return this.getResultItem();
  }

  public ItemStack getResultItem() {
    return new ItemStack(ModItems.BOW);
  }

  @Override
  public NonNullList<ItemStack> getRemainingItems(CraftingContainer container) {
    NonNullList<ItemStack> aitemstack = NonNullList.withSize(container.getContainerSize(), ItemStack.EMPTY);
    for (int i = 0; i < aitemstack.size(); ++i) {
      ItemStack itemstack = container.getItem(i);
      aitemstack.set(i, new ItemStack(itemstack.getItem().getCraftingRemainingItem()));
    }

    Pair<ItemStack, List<ItemStack>> result = getResult(container);
    if (result != null) {
      List<ItemStack> extraOutputs = result.getRight();
      for (ItemStack extraOutput : extraOutputs) {
        tryReAddToStack(Minecraft.getInstance().player, ItemStack.EMPTY, extraOutput, Minecraft.getInstance().player.getUsedItemHand());
      }
    }

    return aitemstack;
  }

  public static void tryReAddToStack(Player player, ItemStack originalStack, ItemStack newStackPart, InteractionHand hand) {
    if (!player.isCreative()) {
      if (!originalStack.isEmpty() && originalStack.getCount() == 1) {
        player.getInventory().setItem(hand == InteractionHand.MAIN_HAND ? player.getInventory().selected : 40, newStackPart);
      } else {
        if (!originalStack.isEmpty()) {
          originalStack.shrink(1);
        }

        if (!player.getInventory().add(newStackPart)) {
          player.drop(newStackPart, false);
        }
      }
    }

  }

  protected Pair<ItemStack, List<ItemStack>> getResult(CraftingContainer grid) {
    ItemStack output = getResultItem().copy();
    List<ItemStack> extraOutputs = Lists.newLinkedList();

    int existingBowSlot = -1;
    Map<IBowPart.BowPartType, IBowPart> existingBowParts = null;
    Map<IBowPart.BowPartType, IBowPart> parts = Maps.newHashMap();
    List<Map<BowModifier, Float>> rawModifiers = Lists.newLinkedList();

    // Loop over the grid and find an existing bow
    for (int j = 0; j < grid.getContainerSize(); j++) {
      ItemStack element = grid.getItem(j);
      if (!element.isEmpty() && element.getItem() instanceof IBow) {
        Map<IBowPart.BowPartType, IBowPart> currentExistingBowParts = indexifyParts(BowParts.REGISTRY.getBowParts(element));
        if (currentExistingBowParts != null && areValidBowParts(currentExistingBowParts.values()) && element.getCount() == 1) {
          if (existingBowParts == null) {
            existingBowParts = currentExistingBowParts;
            output = element.copy();
            existingBowSlot = j;
          } else {
            return null;
          }
        }
      }
    }

    // Loop over the grid and find parts and modifiers
    for (int j = 0; j < grid.getContainerSize(); j++) {
      ItemStack element = grid.getItem(j);
      if (!element.isEmpty()) {
        IBowPart part = BowParts.REGISTRY.getPartFromItem(element);
        Map<BowModifier, Float> modifier = BowModifiers.REGISTRY.getModifiersFromItem(element);
        if (part != null) {
          if (parts.containsKey(part.getType())) {
            return null;
          }
          parts.put(part.getType(), part);
        } else if (modifier != null) {
          rawModifiers.add(modifier);
        } else if (j != existingBowSlot) {
          return null;
        }
      }
    }

    // If we had a existing bow, check which parts are replaced
    if (existingBowParts != null) {
      for (Map.Entry<IBowPart.BowPartType, IBowPart> entry : existingBowParts.entrySet()) {
        if (parts.containsKey(entry.getKey())) {
          extraOutputs.add(Iterables.get(BowParts.REGISTRY.getItemsFromPart(entry.getValue()), 0).copy());
        } else {
          parts.put(entry.getKey(), entry.getValue());
        }
      }
    }

    // Validate parts
    if (!areValidBowParts(parts.values())) {
      return null;
    }

    // Write bow parts
    BowParts.REGISTRY.setBowParts(output, parts.values());

    // Validate modifiers
    Map<BowModifier, Float> bowModifiers = BowModifiers.REGISTRY.getModifiers(output);
    Map<BowModifier, Float> baseModifiers = BowParts.REGISTRY.getBaseModifiersFromBow(output);
    applyNewModifiers(bowModifiers, rawModifiers);
    if (!areValidBowModifiers(bowModifiers, baseModifiers)) {
      return null;
    }

    // Write bow modifiers
    BowModifiers.REGISTRY.setModifiers(output, bowModifiers);

    return Pair.of(output, extraOutputs);
  }

  private boolean areValidBowParts(Collection<IBowPart> parts) {
    Set<IBowPart.BowPartType> remainingRequiredTypes = Sets.newHashSet(IBowPart.BowPartType.BASE_TYPES);
    for (IBowPart part : parts) {
      remainingRequiredTypes.remove(part.getType());
    }
    return remainingRequiredTypes.isEmpty();
  }

  private boolean areValidBowModifiers(Map<BowModifier, Float> broomModifiers, Map<BowModifier, Float> baseModifiers) {
    int baseMaxModifiers = 0;
    if (baseModifiers.containsKey(BowModifiers.MODIFIER_COUNT)) {
      baseMaxModifiers = (int) (float) baseModifiers.get(BowModifiers.MODIFIER_COUNT);
    }
    int maxModifiers = baseMaxModifiers;
    int modifiers = 0;
    for (Map.Entry<BowModifier, Float> entry : broomModifiers.entrySet()) {
      int tier = (int) Math.ceil(entry.getValue() / entry.getKey().getTierValue());
      if (tier > entry.getKey().getMaxTiers()) {
        return false;
      }
      if (entry.getKey() == BowModifiers.MODIFIER_COUNT) {
        maxModifiers += (int) (float) entry.getValue();
      } else {
        modifiers += tier;
      }
    }
    broomModifiers.put(BowModifiers.MODIFIER_COUNT, (float) maxModifiers - baseMaxModifiers);
    return modifiers <= maxModifiers;
  }

  protected Map<IBowPart.BowPartType, IBowPart> indexifyParts(Collection<IBowPart> parts) {
    Map<IBowPart.BowPartType, IBowPart> map = Maps.newHashMap();
    for (IBowPart part : parts) {
      if (part.getType() != IBowPart.BowPartType.MODIFIER) {
        map.put(part.getType(), part);
      }
    }

    return map;
  }

  private void applyNewModifiers(Map<BowModifier, Float> baseModifiers, List<Map<BowModifier, Float>> rawModifiers) {
    for (Map<BowModifier, Float> modifierValue : rawModifiers) {
      for (Map.Entry<BowModifier, Float> entry : modifierValue.entrySet()) {
        BowModifier modifier = entry.getKey();
        Float value = baseModifiers.get(entry.getKey());
        if (value != null) {
          baseModifiers.put(modifier, modifier.apply(value, Lists.newArrayList(entry.getValue())));
        } else {
          baseModifiers.put(modifier, modifier.apply(modifier.getDefaultValue(), Lists.newArrayList(entry.getValue())));
        }
      }
    }
  }

  @Override
  public ItemStack assemble(CraftingContainer craftingContainer, RegistryAccess registryAccess) {
    return new ItemStack(ModItems.BOW);
  }

  @Override
  public boolean canCraftInDimensions(int width, int height) {
    return (width * height) >= 4;
  }

  @Override
  public RecipeSerializer<?> getSerializer() {
    return ModRecipeSerializers.BOW_PART_COMBINATION;
  }
}

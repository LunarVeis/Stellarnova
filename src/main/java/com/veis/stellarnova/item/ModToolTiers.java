package com.veis.stellarnova.item;

import com.veis.stellarnova.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier NOVA = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_NOVA_TOOL,
            1000, 4f, 3f, 15, () -> Ingredient.of(ModItems.NOVA_INGOT));

}

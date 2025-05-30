package com.veis.stellarnova.util;

import com.veis.stellarnova.Stellarnova;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Stellarnova.MODID, name));
        }
        public static final TagKey<Block> NEEDS_NOVA_TOOL = createTag("needs_nova_tool");
        public static final TagKey<Block> NEEDS_STELLAR_TOOL = createTag("needs_stellar_tool");
        public static final TagKey<Block> INCORRECT_FOR_NOVA_TOOL = createTag("incorrect_for_nova_tool");
        public static final TagKey<Block> INCORRECT_FOR_STELLAR_TOOL = createTag("incorrect_for_stellar_tool");
    }


    public static class Items {
        public static final TagKey<Item> LOW_REQUIREMENT_TRANSMUTE = createTag("low_requirement_transmute");
        public static final TagKey<Item> HIGH_REQUIREMENT_TRANSMUTE = createTag("high_requirement_transmute");
        public static final TagKey<Item> CHARGE_ITEMS_TRANSMUTE = createTag("charge_items_transmute");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Stellarnova.MODID, name));
        }
    }
}

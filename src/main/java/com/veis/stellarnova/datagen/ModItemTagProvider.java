package com.veis.stellarnova.datagen;

import com.veis.stellarnova.Stellarnova;
import com.veis.stellarnova.item.ModItems;
import com.veis.stellarnova.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                             CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Stellarnova.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.LOW_REQUIREMENT_TRANSMUTE)
                .add(Items.APPLE);
        tag(ModTags.Items.HIGH_REQUIREMENT_TRANSMUTE)
                .add(Items.SKELETON_SKULL);
        tag(ModTags.Items.CHARGE_ITEMS_TRANSMUTE)
                .add(Items.DIAMOND)
                .add(ModItems.NOVA_INGOT.get());

    }
}

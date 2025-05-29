package com.veis.stellarnova.datagen;

import com.veis.stellarnova.Stellarnova;
import com.veis.stellarnova.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Stellarnova.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NOVA_BLOCK.get())
                .add(ModBlocks.NOVA_ORE.get())
                .add(ModBlocks.STELLARNOVA_BLOCK.get())
                .add(ModBlocks.STELLARNOVA_CATALYST.get())
                .add(ModBlocks.STARSEER_ESSENCE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STARSEER_ESSENCE.get())
                .add(ModBlocks.NOVA_ORE.get())
                .add(ModBlocks.NOVA_BLOCK.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.STELLARNOVA_CATALYST.get())
                .add(ModBlocks.STELLARNOVA_BLOCK.get());
    }
}

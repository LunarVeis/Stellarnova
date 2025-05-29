package com.veis.stellarnova.datagen;

import com.veis.stellarnova.block.ModBlocks;
import com.veis.stellarnova.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {


    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //dropSelf
        dropSelf(ModBlocks.STELLARNOVA_BLOCK.get());
        dropSelf(ModBlocks.NOVA_BLOCK.get());
        dropSelf(ModBlocks.STELLARNOVA_CATALYST.get());
        dropSelf(ModBlocks.STARSEER_ESSENCE.get());

        //ores
        add(ModBlocks.NOVA_ORE.get(),
                block -> createOreDrop(ModBlocks.NOVA_ORE.get(), ModItems.NOVA_CLUSTER.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

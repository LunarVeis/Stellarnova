package com.veis.stellarnova.datagen;

import com.veis.stellarnova.Stellarnova;
import com.veis.stellarnova.block.ModBlocks;
import com.veis.stellarnova.block.custom.InfuserBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Stellarnova.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.STELLARNOVA_BLOCK);
        blockWithItem(ModBlocks.NOVA_BLOCK);

        blockWithItem(ModBlocks.STELLARNOVA_CATALYST);

        blockWithItem(ModBlocks.NOVA_ORE);

        infuserBlock();

    }

    private void infuserBlock() {
        getVariantBuilder(ModBlocks.STARSEER_ESSENCE.get()).forAllStates(state -> {
            if (state.getValue(InfuserBlock.CHARGED)) {
                return new ConfiguredModel[] {new ConfiguredModel(models().cubeAll("starseer_essence_charged",
                        ResourceLocation.fromNamespaceAndPath(Stellarnova.MODID, "block/"+"starseer_essence_charged")))};
            }
            else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("starseer_essence_uncharged",
                        ResourceLocation.fromNamespaceAndPath(Stellarnova.MODID, "block/"+"starseer_essence_uncharged")))};
            }
        });
        simpleBlockItem(ModBlocks.STARSEER_ESSENCE.get(), models().cubeAll("starseer_essence",
                ResourceLocation.fromNamespaceAndPath(Stellarnova.MODID, "block/"+"starseer_essence_charged")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

}


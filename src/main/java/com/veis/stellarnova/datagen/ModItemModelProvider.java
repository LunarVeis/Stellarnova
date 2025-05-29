package com.veis.stellarnova.datagen;

import com.veis.stellarnova.Stellarnova;
import com.veis.stellarnova.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Stellarnova.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    basicItem(ModItems.NOVA_CLUSTER.get());
    basicItem(ModItems.NOVA_INGOT.get());
    basicItem(ModItems.NOVA_APPLE.get());
    basicItem(ModItems.STELLARNOVA_INGOT.get());
    basicItem(ModItems.STARSEER_EYE.get());
    basicItem(ModItems.STARSEER_BREAKER.get());
    basicItem(ModItems.STELLAR_CHARCOAL.get());
    basicItem(ModItems.STELLAR_COAL.get());
    basicItem(ModItems.CHISEL.get());
    }
}

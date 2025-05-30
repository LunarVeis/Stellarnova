package com.veis.stellarnova.datagen;

import com.veis.stellarnova.Stellarnova;
import com.veis.stellarnova.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

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

    handheldItem(ModItems.NOVA_AXE);
    handheldItem(ModItems.NOVA_HOE);
    handheldItem(ModItems.NOVA_SWORD);
    handheldItem(ModItems.NOVA_SHOVEL);
    handheldItem(ModItems.NOVA_PICKAXE);

    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Stellarnova.MODID, "item/"+ item.getId().getPath()));
    }
}

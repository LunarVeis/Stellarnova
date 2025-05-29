package com.veis.stellarnova.item;

import com.veis.stellarnova.Stellarnova;
import com.veis.stellarnova.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Stellarnova.MODID);

    public static final Supplier<CreativeModeTab> STELLARNOVA_ITEMS_TAB = CREATIVE_MODE_TAB.register("stellarnova_items_tab",
            () -> CreativeModeTab.builder()
                    .icon( () -> new ItemStack(ModItems.STELLARNOVA_INGOT.get()))
                    .title(Component.translatable("creativetab.stellarnova.stellarnova_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.STELLARNOVA_INGOT);
                        output.accept(ModItems.NOVA_INGOT);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.STARSEER_EYE);
                        output.accept(ModItems.NOVA_APPLE);
                        output.accept(ModItems.STELLAR_CHARCOAL);
                        output.accept(ModItems.STELLAR_COAL);
                        output.accept(ModItems.STARSEER_BREAKER);
                    }).build());
    public static final Supplier<CreativeModeTab> STELLARNOVA_BLOCKS_TAB = CREATIVE_MODE_TAB.register("stellarnova_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Stellarnova.MODID, "stellarnova_items_tab"))
                    .icon( () -> new ItemStack(ModBlocks.STELLARNOVA_BLOCK.get()))
                    .title(Component.translatable("creativetab.stellarnova.stellarnova_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.STELLARNOVA_CATALYST);
                        output.accept(ModBlocks.STARSEER_ESSENCE);
                        output.accept(ModBlocks.STELLARNOVA_BLOCK);
                        output.accept(ModBlocks.NOVA_BLOCK);
                    }).build());






    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }



}

package com.veis.stellarnova.item;

import com.veis.stellarnova.Stellarnova;
import com.veis.stellarnova.item.custom.CrossPickItem;
import com.veis.stellarnova.item.custom.TransmuteItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Stellarnova.MODID);

    //Resources
    //Ores
    public static final DeferredItem<Item> NOVA_CLUSTER = ITEMS.register("nova_cluster",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    //Ingots
    public static final DeferredItem<Item> STELLARNOVA_INGOT = ITEMS.register("stellarnova_ingot",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> NOVA_INGOT = ITEMS.register("nova_ingot",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    //Food
    public static final DeferredItem<Item> NOVA_APPLE = ITEMS.register("nova_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.NOVA_APPLE)));
    //Fuels
    public static final DeferredItem<Item> STELLAR_COAL = ITEMS.register("stellar_coal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STELLAR_CHARCOAL = ITEMS.register("stellar_charcoal",
            () -> new Item(new Item.Properties()));




    //Tools
    //Transmute
    public static  final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new TransmuteItem(new Item.Properties().durability(64).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> STARSEER_EYE = ITEMS.register("starseer_eye",
            () -> new TransmuteItem(new Item.Properties().durability(300).fireResistant().setNoRepair().rarity(Rarity.RARE).craftRemainder(Items.ENDER_EYE)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if(!Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.stellarnova.transmute_object.hold_shift"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.stellarnova.transmute_object.shift_held_starseer"));
                        tooltipComponents.add(Component.translatable("tooltip.stellarnova.item_consume_repair"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    //AOEBreak
    public static final DeferredItem<Item> STARSEER_BREAKER = ITEMS.register("starseer_breaker",
            () -> new CrossPickItem(new Item.Properties().durability(40).fireResistant().setNoRepair().rarity(Rarity.RARE))
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (!Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.stellarnova.crosspick_object.hold_shift"));
                    }
                    else {
                        tooltipComponents.add(Component.translatable("tooltip.stellarnova.crosspick_object.shift_held_breaker"));
                        tooltipComponents.add(Component.translatable("tooltip.stellarnova.item_consume_repair"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}

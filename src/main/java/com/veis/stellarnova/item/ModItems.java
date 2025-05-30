package com.veis.stellarnova.item;

import com.veis.stellarnova.Stellarnova;
import com.veis.stellarnova.item.custom.BreakerItem;
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
    public static final DeferredItem<SwordItem> NOVA_SWORD = ITEMS.register("nova_sword",
            () -> new SwordItem(ModToolTiers.NOVA, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.NOVA, 3, -2.4f))));
    public static final DeferredItem<PickaxeItem> NOVA_PICKAXE = ITEMS.register("nova_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NOVA, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.NOVA, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> NOVA_SHOVEL = ITEMS.register("nova_shovel",
            () -> new ShovelItem(ModToolTiers.NOVA, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.NOVA, 1.0F, -3.0f))));
    public static final DeferredItem<AxeItem> NOVA_AXE = ITEMS.register("nova_axe",
            () -> new AxeItem(ModToolTiers.NOVA, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.NOVA, 4, -3.2f))));
    public static final DeferredItem<HoeItem> NOVA_HOE = ITEMS.register("nova_hoe",
            () -> new HoeItem(ModToolTiers.NOVA, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.NOVA, 0F, -3.0f))));

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
            () -> new BreakerItem(ModToolTiers.NOVA, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.NOVA, 1.0f, -2.8f)).setNoRepair().rarity(Rarity.RARE))
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    if (!Screen.hasShiftDown()){
                        tooltipComponents.add(Component.translatable("tooltip.stellarnova.hold_shift"));
                    }
                    else {
                        tooltipComponents.add(Component.translatable("tooltip.stellarnova.crosspick_item.shift_held_breaker"));
                        tooltipComponents.add(Component.translatable("tooltip.stellarnova.item_consume_repair"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
//
//    public static final DeferredItem<PickaxeItem> NOVA_PICKAXE = ITEMS.register("nova_pickaxe",
//            () -> new PickaxeItem(ModToolTiers.NOVA, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.NOVA, 1.0F, -2.8f))));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}

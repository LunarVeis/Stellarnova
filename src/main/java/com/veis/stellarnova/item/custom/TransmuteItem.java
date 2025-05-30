package com.veis.stellarnova.item.custom;

import com.mojang.logging.LogUtils;
import com.veis.stellarnova.block.ModBlocks;
import com.veis.stellarnova.component.ModDataComponents;
import com.veis.stellarnova.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;

import java.util.List;
import java.util.Map;

public class TransmuteItem extends Item {

    public static final Logger LOGGER = LogUtils.getLogger();




    public TransmuteItem(Properties properties) {
        super(properties);
    }
    //chisel
    private static final Map<Block, Block> TRANSMUTE_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.STONE_BRICKS, Blocks.ANDESITE,
                    Blocks.ANDESITE, Blocks.DIORITE,
                    Blocks.DIORITE, Blocks.GRANITE,
                    Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE,
                    Blocks.AIR, Blocks.ACACIA_LOG
            );


    private static final Map<Block, Block> STARSEER_MAP =
            Map.of(
                    Blocks.STONE, ModBlocks.NOVA_ORE.get(),
                    Blocks.ANDESITE, ModBlocks.NOVA_ORE.get(),
                    Blocks.DIORITE, ModBlocks.NOVA_ORE.get(),
                    Blocks.GRANITE, ModBlocks.NOVA_ORE.get(),
                    ModBlocks.STELLARNOVA_CATALYST.get(), ModBlocks.STELLARNOVA_BLOCK.get(),
                    ModBlocks.STELLARNOVA_BLOCK.get(), Blocks.OBSIDIAN
            );


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        Block belowBlock = level.getBlockState(context.getClickedPos().below()).getBlock();
        Block aboveBlock = level.getBlockState(context.getClickedPos().above()).getBlock();
        ItemStack mainHandItem = context.getPlayer().getMainHandItem();
        ItemStack offHandItem = context.getPlayer().getOffhandItem();



        if(TRANSMUTE_MAP.containsKey(clickedBlock) & !context.getItemInHand().is(ModItems.STARSEER_EYE.asItem())) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), TRANSMUTE_MAP.get(clickedBlock).defaultBlockState());
                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());


            }
        }


        if(mainHandItem.is(ModItems.STARSEER_EYE.get()) && offHandItem.is(ModItems.NOVA_INGOT.get())) {
            if (!level.isClientSide()) {
                LOGGER.info("Items match");
                if (context.getPlayer().isCrouching() && mainHandItem.isDamaged()) {
                    context.getItemInHand().hurtAndBreak(-1, ((ServerLevel) level), context.getPlayer(),
                            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                    offHandItem.setCount(offHandItem.getCount() - 1);
                    LOGGER.info("durability should have changed");
                }
            }
        }

        if(STARSEER_MAP.containsKey(clickedBlock) && !level.isClientSide()) {
            if(context.getItemInHand().is(ModItems.STARSEER_EYE.asItem())) {
                if(clickedBlock == ModBlocks.STELLARNOVA_CATALYST.get()) {
                    if(belowBlock == ModBlocks.STARSEER_ESSENCE.get() & aboveBlock == ModBlocks.STARSEER_ESSENCE.get()) {
                        level.setBlockAndUpdate(context.getClickedPos(), STARSEER_MAP.get(clickedBlock).defaultBlockState());
                        level.setBlockAndUpdate(context.getClickedPos().below(), STARSEER_MAP.get(belowBlock).defaultBlockState());
                        level.setBlockAndUpdate(context.getClickedPos().above(), STARSEER_MAP.get(aboveBlock).defaultBlockState());
                        level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
                        context.getItemInHand().setDamageValue(context.getItemInHand().getDamageValue() + 1);
                        if(mainHandItem.getDamageValue() == (mainHandItem.getMaxDamage()-1)){mainHandItem.setCount(0);
                            assert context.getPlayer() != null;
                            context.getPlayer().addItem(ModItems.SIGHTLESS_EYE.toStack(1));}
                    }
                } else {
                    level.setBlockAndUpdate(context.getClickedPos(), STARSEER_MAP.get(clickedBlock).defaultBlockState());
//                    context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
//                            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                    context.getItemInHand().setDamageValue(context.getItemInHand().getDamageValue() + 1);
                    LOGGER.info(String.valueOf(context.getItemInHand().getDamageValue()));
                    LOGGER.info("max: " + context.getItemInHand().getMaxDamage());
                    if(context.getItemInHand().getDamageValue()== mainHandItem.getMaxDamage()){mainHandItem.setCount(0);
                        assert context.getPlayer() != null;
                        context.getPlayer().addItem(ModItems.SIGHTLESS_EYE.toStack(1));}

                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        if(stack.get(ModDataComponents.COORDINATES) != null) {
            tooltipComponents.add(Component.literal("Last used at: "+ stack.get(ModDataComponents.COORDINATES)));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        }
}

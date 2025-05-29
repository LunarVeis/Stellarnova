package com.veis.stellarnova.block.custom;

import com.mojang.logging.LogUtils;
import com.veis.stellarnova.item.ModItems;
import com.veis.stellarnova.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public class InfuserBlock extends Block {

    public static final Logger LOGGER = LogUtils.getLogger();
    public static final BooleanProperty CHARGED = BooleanProperty.create("charged");


    public InfuserBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CHARGED, true));
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if(state.getValue(CHARGED) && !stack.is(ModItems.STARSEER_EYE.get()) && !stack.is(ModItems.STARSEER_BREAKER.get())) {
                int currentCount = stack.getCount();
                if (lowTransmute(stack)) {
                    stack.setCount(0);
                    player.addItem(ModItems.NOVA_APPLE.toStack(currentCount));
                } else if (highTransmute(stack)) {
                    stack.setCount(currentCount-1);
                    player.addItem(ModItems.NOVA_APPLE.toStack(currentCount));
                    level.setBlockAndUpdate(pos, state.setValue(CHARGED, false));
                    LOGGER.info("charged: " + state.getValue(CHARGED));
                }
            } else if (chargeItems(stack)) {
            stack.setCount(stack.getCount() - 1);
            level.setBlockAndUpdate(pos, state.setValue(CHARGED, true));
            }
        }
        //return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        return ItemInteractionResult.SUCCESS;
    }
    private boolean chargeItems(ItemStack item) {
        return item.is(ModTags.Items.CHARGE_ITEMS_TRANSMUTE);
    }
    private boolean lowTransmute(ItemStack item) {
        return item.is(ModTags.Items.LOW_REQUIREMENT_TRANSMUTE);
    }
    private boolean highTransmute(ItemStack item) {
        return item.is(ModTags.Items.HIGH_REQUIREMENT_TRANSMUTE);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CHARGED);
    }
}

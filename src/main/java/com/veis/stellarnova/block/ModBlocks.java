package com.veis.stellarnova.block;


import com.veis.stellarnova.Stellarnova;
import com.veis.stellarnova.block.custom.InfuserBlock;
import com.veis.stellarnova.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.veis.stellarnova.block.custom.InfuserBlock.CHARGED;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Stellarnova.MODID);

    public static final DeferredBlock<Block> STELLARNOVA_BLOCK = registerBlock("stellarnova_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final DeferredBlock<Block> NOVA_BLOCK = registerBlock("nova_block",
            () -> new InfuserBlock(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final DeferredBlock<Block> STELLARNOVA_CATALYST = registerBlock("stellarnova_catalyst",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
            BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)));

    public static final DeferredBlock<Block> STARSEER_ESSENCE = registerBlock("starseer_essence",
            () -> new InfuserBlock(BlockBehaviour.Properties.of().strength(1f).lightLevel(state -> state.getValue(CHARGED) ? 15 : 0)
                    .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> NOVA_ORE = registerBlock("nova_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,5),BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }





    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }



}

package com.niixlabs.ae2ores;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(AE2O.MODID)
public class AE2O {
    public static final String MODID = "ae2ores";

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.Blocks.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.Items.createItems(MODID);

    public static final DeferredBlock<Block> CERTUS_QUARTZ_ORE = BLOCKS.register("certus_quartz_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
                    .sound(SoundType.STONE)));

    public static final DeferredItem<BlockItem> CERTUS_QUARTZ_ORE_ITEM = ITEMS.register("certus_quartz_ore",
            () -> new BlockItem(CERTUS_QUARTZ_ORE.get(), new Item.Properties()));

    public static final DeferredBlock<Block> DEEPSLATE_CERTUS_QUARTZ_ORE = BLOCKS.register("deepslate_certus_quartz_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredItem<BlockItem> DEEPSLATE_CERTUS_QUARTZ_ORE_ITEM = ITEMS.register("deepslate_certus_quartz_ore",
            () -> new BlockItem(DEEPSLATE_CERTUS_QUARTZ_ORE.get(), new Item.Properties()));

    public AE2O(IEventBus modEventBus, ModContainer modContainer) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(CERTUS_QUARTZ_ORE_ITEM);
            event.accept(DEEPSLATE_CERTUS_QUARTZ_ORE_ITEM);
        }
    }
}
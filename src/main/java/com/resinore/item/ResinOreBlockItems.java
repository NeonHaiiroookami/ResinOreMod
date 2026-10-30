package com.resinore.item;

import com.resinore.ResinOre;
import com.resinore.block.ResinOreBlocks;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ResinOreBlockItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ResinOre.MODID);
    public static final Supplier<BlockItem> RESIN_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "resin_ore",
            ResinOreBlocks.RESIN_ORE
    );
    public static final Supplier<BlockItem> DEEPSLATE_RESIN_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "deepslate_resin_ore",
            ResinOreBlocks.DEEPSLATE_RESIN_ORE
    );
}
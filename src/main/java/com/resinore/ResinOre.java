package com.resinore;

import com.resinore.block.ResinOreBlocks;
import com.resinore.item.ResinOreBlockItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(ResinOre.MODID)
public class ResinOre {
    public static final String MODID = "resinoremod";

    public static final Logger LOGGER = LogUtils.getLogger();

    public ResinOre(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup); NeoForge.EVENT_BUS.register(this);
	modEventBus.addListener(ResinOre::buildContents); 
        ResinOreBlocks.BLOCKS.register(modEventBus);
        ResinOreBlockItems.ITEMS.register(modEventBus);
    }

    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ResinOreBlockItems.RESIN_BLOCK_ITEM.get());
            event.accept(ResinOreBlockItems.DEEPSLATE_RESIN_BLOCK_ITEM.get());
        }
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Woody's Resin Ores loaded!");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Woody's Resin Ores server starting!");
    }
}

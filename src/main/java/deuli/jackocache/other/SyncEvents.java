package deuli.jackocache.other;

import deuli.jackocache.JackOCache;
import deuli.jackocache.loot.AddPlayerPumpkinLootModifier;
import deuli.jackocache.loot.AddPumpkinLootModifier;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JackOCache.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SyncEvents {
    /**
     * Make sure that the drops are synced whenever the {@code reload} command is used.
     */
    @SubscribeEvent
    public static void onReload(OnDatapackSyncEvent event) {
        if (event.getPlayer() == null) {
            JackOCache.LOGGER.info("Reloading! Syncing pumpkin drops...");
            AddPumpkinLootModifier.syncDrops();
            AddPlayerPumpkinLootModifier.syncPlayerDrops();
        }
    }

    /**
     * Make sure that the drops are synced whenever the server is started.
     */
    @SubscribeEvent
    public static void onServerStart(ServerStartingEvent event) {
        JackOCache.LOGGER.info("Server starting! Syncing pumpkin drops...");
        AddPumpkinLootModifier.syncDrops();
        AddPlayerPumpkinLootModifier.syncPlayerDrops();
    }
}

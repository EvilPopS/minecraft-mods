package com.evilpopsmods.abilities_grand_master_mod.events_handlers;


import com.evilpopsmods.abilities_grand_master_mod.custom_exceptions.DBManagerNotInitializedProperlyException;
import com.evilpopsmods.abilities_grand_master_mod.services.implementations.DatabaseService;
import com.evilpopsmods.abilities_grand_master_mod.services.interfaces.IDatabaseService;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class SetupEvents {
    private static final IDatabaseService databaseService = DatabaseService.getInstance();

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        databaseService.setLoadedWorldName(event.getServer().getWorldData().getLevelName());
    }

    @SubscribeEvent
    public static void onPlayerJoined(PlayerEvent.PlayerLoggedInEvent event) throws DBManagerNotInitializedProperlyException {
        databaseService.setJoinedPlayerName(event.getEntity().getScoreboardName());
        databaseService.loadSkillDataset();
    }
}

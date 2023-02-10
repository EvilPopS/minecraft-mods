package com.evilpopsmods.abilitiesgrandmastermod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(AbilitiesGrandMasterMod.MODID)
public class AbilitiesGrandMasterMod {
    public static final String MODID = "abilities_grand_master_mod";
    public AbilitiesGrandMasterMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }
}

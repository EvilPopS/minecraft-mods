package com.evilpopsmods.abilities_grand_master_mod;

import com.evilpopsmods.abilities_grand_master_mod.events_handlers.SetupEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(AbilitiesGrandMasterMod.MODID)
public class AbilitiesGrandMasterMod {
    public static final String MODID = "abilities_grand_master_mod";

    public AbilitiesGrandMasterMod() {
        MinecraftForge.EVENT_BUS.register(SetupEvents.class);
    }

}

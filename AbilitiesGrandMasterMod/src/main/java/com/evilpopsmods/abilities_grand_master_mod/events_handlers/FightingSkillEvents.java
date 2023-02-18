package com.evilpopsmods.abilities_grand_master_mod.events_handlers;

import com.evilpopsmods.abilities_grand_master_mod.events_handlers.events_consts.EventsConstants;
import com.evilpopsmods.abilities_grand_master_mod.services.implementations.FightingSkillService;
import com.evilpopsmods.abilities_grand_master_mod.services.interfaces.IFightingSkillService;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FightingSkillEvents {
    private static final IFightingSkillService fightingSkillService = FightingSkillService.getSingletonInstance();


    @SubscribeEvent
    public static void onEntityHurt(LivingHurtEvent event) {
        if (event.getSource().getMsgId().equals(EventsConstants.PLAYER_MSG_ID)) {
            event.setAmount(event.getAmount()*fightingSkillService.getAttackDamageMultiplier());
            fightingSkillService.increaseExperienceOnHit(event.getEntity().getType().getCategory());
        }
    }

    @SubscribeEvent
    public static void onEntityKill(LivingDeathEvent event) {
        if (event.getSource().getMsgId().equals(EventsConstants.PLAYER_MSG_ID))
            fightingSkillService.increaseExperienceOnKill(event.getEntity().getType().getCategory());
    }
}

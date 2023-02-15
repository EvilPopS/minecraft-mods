package com.evilpopsmods.abilities_grand_master_mod.events_handlers;

import com.evilpopsmods.abilities_grand_master_mod.services.implementations.FightingSkillService;
import com.evilpopsmods.abilities_grand_master_mod.services.interfaces.IFightingSkillService;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FightingSkillEvents {
    private static final IFightingSkillService fightingSkillService = FightingSkillService.getSingletonInstance();

    private static Entity entityAttacked;
    private static Player playerToAttack;


    @SubscribeEvent
    public static void onEntityAttacked(AttackEntityEvent event) {
        entityAttacked = event.getTarget();
        playerToAttack = event.getEntity();
    }

    @SubscribeEvent
    public static void onEntityHurt(LivingHurtEvent event) {
        if (entityAttacked == null || playerToAttack == null)
            return;

        if (event.getSource().getMsgId().equals(DamageSource.playerAttack(playerToAttack).getMsgId())) {
            event.setAmount(event.getAmount()*fightingSkillService.getAttackDamageMultiplier());
            fightingSkillService.increaseExperience();
        }

        entityAttacked = null;
        playerToAttack = null;
    }
}

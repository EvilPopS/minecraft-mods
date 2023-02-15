package com.evilpopsmods.abilities_grand_master_mod.services.implementations;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillType;
import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillsManager;
import com.evilpopsmods.abilities_grand_master_mod.services.interfaces.IFightingSkillService;

public class FightingSkillService implements IFightingSkillService {
    private static FightingSkillService fightingSkillService = null;
    private final SkillsManager skillsManager;


    private FightingSkillService() {
        this.skillsManager = SkillsManager.getSingletonInstance();
    }

    public static IFightingSkillService getSingletonInstance() {
        if (fightingSkillService == null)
            fightingSkillService = new FightingSkillService();
        return fightingSkillService;
    }

    @Override
    public void increaseExperience() {
        skillsManager.increaseExperience(SkillType.FIGHTING, 1);
    }

    @Override
    public float getAttackDamageMultiplier() {
        return skillsManager.getFightingSkillAttackDamageMultiplier();
    }
}

package com.evilpopsmods.abilities_grand_master_mod.services.interfaces;

public interface IFightingSkillService {
    void increaseExperienceOnHit();
    void increaseExperienceOnKill();
    float getAttackDamageMultiplier();
}

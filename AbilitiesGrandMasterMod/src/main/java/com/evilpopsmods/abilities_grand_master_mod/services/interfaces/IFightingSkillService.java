package com.evilpopsmods.abilities_grand_master_mod.services.interfaces;

import net.minecraft.world.entity.MobCategory;

public interface IFightingSkillService {
    void increaseExperienceOnHit(final MobCategory mobCategory);
    void increaseExperienceOnKill(final MobCategory mobCategory);
    float getAttackDamageMultiplier();
}

package com.evilpopsmods.abilities_grand_master_mod.models.skills.skill_manager_interfaces;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillType;

public interface IBaseSkillManager {
    void increaseExperience(final SkillType skillType, final float experience);
}

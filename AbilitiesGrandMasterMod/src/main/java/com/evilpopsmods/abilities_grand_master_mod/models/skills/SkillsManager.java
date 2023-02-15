package com.evilpopsmods.abilities_grand_master_mod.models.skills;

import com.evilpopsmods.abilities_grand_master_mod.database.DBManager;
import com.evilpopsmods.abilities_grand_master_mod.models.skills.skill_manager_interfaces.IBaseSkillManager;
import com.evilpopsmods.abilities_grand_master_mod.models.skills.skill_manager_interfaces.IFightingSkillManager;
import com.evilpopsmods.abilities_grand_master_mod.models.skills.skills_classes.*;
import lombok.Getter;
import lombok.Setter;

public class SkillsManager implements IBaseSkillManager, IFightingSkillManager {
    private static SkillsManager singletonInstance = null;
    @Getter
    @Setter
    private AllSkills allSkills;

    private SkillsManager() {
        this.allSkills = DBManager.getSingletonInstance().getAllSkills();
    }

    public static SkillsManager getSingletonInstance() {
        if (singletonInstance == null)
            singletonInstance = new SkillsManager();
        return singletonInstance;
    }

    @Override
    public void increaseExperience(SkillType skillType, float experience) {
        getSkillByType(skillType).increaseExperience(experience);
    }

    @Override
    public float getFightingSkillAttackDamageMultiplier() {
        return this.allSkills.getFightingSkill().getDamageMultiplier();
    }

    private SkillBase getSkillByType(final SkillType skillType) {
        return switch (skillType) {
            case FIGHTING -> this.allSkills.getFightingSkill();
            case ARCHERY -> this.allSkills.getArcherySkill();
            case FALLING -> this.allSkills.getFallingSkill();
            case MINING -> this.allSkills.getMiningSkill();
            case DIGGING -> this.allSkills.getDiggingSkill();
            case CUTTING -> this.allSkills.getCuttingSkill();
            case FARMING -> this.allSkills.getFarmingSkill();
            case FISHING -> this.allSkills.getFishingSkill();
            case ENCHANTING -> this.allSkills.getEnchantingSkill();
            case ALCHEMY -> this.allSkills.getAlchemySkill();
        };
    }

}

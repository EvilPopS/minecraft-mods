package com.evilpopsmods.abilities_grand_master_mod.models.skills;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.skills_classes.*;

public class SkillsManager {
    private AllSkills allSkills;

    public void increaseExperience(final SkillType skillType, final float experience) {
        getSkillByType(skillType).increaseExperience(experience);
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

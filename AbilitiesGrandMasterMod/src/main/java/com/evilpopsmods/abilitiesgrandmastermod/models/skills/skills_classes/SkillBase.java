package com.evilpopsmods.abilitiesgrandmastermod.models.skills.skills_classes;

import com.evilpopsmods.abilitiesgrandmastermod.models.skills.SkillType;
import com.evilpopsmods.abilitiesgrandmastermod.models.skills.levels_consts.SkillsLevelsManager;

public abstract class SkillBase {
    protected int level;
    protected float experience;
    protected float levelCap;

    protected abstract void setNextLevelCap();

    public SkillBase(final int level, final float experience, final float levelCap) {
        this.level = level;
        this.experience = experience;
        this.levelCap = levelCap;
    }

    public void increaseExperience(final float exp) {
        this.experience += exp;
        if (canLevelUp()) {
            this.level += 1;
            setExperienceAfterLevelUp();
        }
    }
    private boolean canLevelUp() {
        return this.experience > levelCap;
    }

    private void setExperienceAfterLevelUp() {
        this.experience -= levelCap;
    }

}

package com.evilpopsmods.abilities_grand_master_mod.models.skills.skills_classes;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class SkillBase {
    protected int level;
    protected float experience;
    protected float levelCap;

    protected abstract void setLevelForSkill();

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

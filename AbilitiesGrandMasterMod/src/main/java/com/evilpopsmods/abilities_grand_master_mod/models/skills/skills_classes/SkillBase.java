package com.evilpopsmods.abilities_grand_master_mod.models.skills.skills_classes;


import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillType;
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

    protected abstract float getLevelCapForSkill(final SkillType skillType, final int level);
    protected abstract void setLevelCapForSkill();
    protected abstract void doOnLevelUpForTheRestOfTheSkill();
    protected abstract boolean isLevelOutOfBounds();
    protected abstract boolean isMaxLevel();
    protected abstract void resetTheRestOfTheSkill();


    public void increaseExperience(final float exp) {
        if (isLevelOutOfBounds()) {
            if (!isMaxLevel())
                resetSkillAsLevelIsOutOfBounds();
            return;
        }

        this.experience += exp;
        if (canLevelUp())
            doOnLevelUp();
    }

    private void resetSkillAsLevelIsOutOfBounds() {
        this.level = 1;
        this.experience = 0;
        setLevelCapForSkill();
        resetTheRestOfTheSkill();
    }

    private void doOnLevelUp() {
        this.level += 1;
        setExperienceAfterLevelUp();
        setLevelCapForSkill();
        doOnLevelUpForTheRestOfTheSkill();
    }

    private boolean canLevelUp() {
        return this.experience >= levelCap;
    }

    private void setExperienceAfterLevelUp() {
        this.experience -= levelCap;
    }

}

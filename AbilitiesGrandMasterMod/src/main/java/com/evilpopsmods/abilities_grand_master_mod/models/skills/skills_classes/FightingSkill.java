package com.evilpopsmods.abilities_grand_master_mod.models.skills.skills_classes;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillType;
import com.evilpopsmods.abilities_grand_master_mod.models.skills.levels_consts.SkillsLevelsCapsManager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
public class FightingSkill extends SkillBase {
    private final static SkillType thisSkillType = SkillType.FIGHTING;

    @Getter
    @Setter
    protected float damageMultiplier;

    public FightingSkill(int level, float experience, float damageMultiplier) {
        super(level, experience, -1);
        setLevelCapForSkill();
        this.damageMultiplier = damageMultiplier;
    }

    public static FightingSkill getInitializedInstance() {
        return new FightingSkill(1, 0, 0.03f);
    }

    @Override
    protected float getLevelCapForSkill(final SkillType skillType, final int level) {
        if (isLevelOutOfBounds())
            return 0;
        return SkillsLevelsCapsManager.getLevelCapBySkillType(SkillType.FIGHTING, level);
    }
    @Override
    protected void setLevelCapForSkill() {
        this.levelCap = getLevelCapForSkill(thisSkillType, this.level);
    }

    @Override
    protected void doOnLevelUpForTheRestOfTheSkill() {
        this.damageMultiplier += 0.03f;
    }

    @Override
    protected boolean isLevelOutOfBounds() {
        return SkillsLevelsCapsManager.isLevelOutOfBounds(SkillType.FIGHTING, level);
    }

    @Override
    protected boolean isMaxLevel() {
        return SkillsLevelsCapsManager.isMaxLevel(SkillType.FIGHTING, level);
    }

    @Override
    protected void resetTheRestOfTheSkill() {
        this.damageMultiplier = 0.03f;
    }



}

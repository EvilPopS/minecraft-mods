package com.evilpopsmods.abilities_grand_master_mod.models.skills.skills_classes;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillType;
import com.evilpopsmods.abilities_grand_master_mod.models.skills.levels_consts.SkillsLevelsCapsManager;

public class FarmingSkill extends SkillBase {
    public FarmingSkill(int level, float experience) {
        super(level, experience, getCurrFightingSkillLevelCap(level));
    }

    public static FarmingSkill getInitializedInstance() {
        return new FarmingSkill(1, 0);
    }

    @Override
    protected void setLevelCapForSkill() {
        this.levelCap = getCurrFightingSkillLevelCap(this.level);
    }

    @Override
    protected float getLevelCapForSkill(SkillType skillType, int level) {
        //TODO yet to be implemented
        return 0;
    }

    @Override
    protected void doOnLevelUpForTheRestOfTheSkill() {
        //TODO yet to be implemented
    }

    @Override
    protected boolean isLevelOutOfBounds() {
        //TODO yet to be implemented
        return false;
    }

    @Override
    protected boolean isMaxLevel() {
        //TODO yet to be implemented
        return false;
    }

    @Override
    protected void resetTheRestOfTheSkill() {
        //TODO yet to be implemented
    }

    private static float getCurrFightingSkillLevelCap(final int level) {
        return SkillsLevelsCapsManager.getLevelCapBySkillType(SkillType.FARMING, level);
    }
}

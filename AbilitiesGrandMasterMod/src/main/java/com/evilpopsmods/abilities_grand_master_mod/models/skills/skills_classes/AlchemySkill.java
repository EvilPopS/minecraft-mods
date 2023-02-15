package com.evilpopsmods.abilities_grand_master_mod.models.skills.skills_classes;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillType;
import com.evilpopsmods.abilities_grand_master_mod.models.skills.levels_consts.SkillsLevelsCapsManager;

public class AlchemySkill extends SkillBase {
    public AlchemySkill(int level, float experience) {
        super(level, experience, getCurrFightingSkillLevelCap(level));
    }

    public static AlchemySkill getInitializedInstance() {
        return new AlchemySkill(1, 0);
    }

    @Override
    protected float getLevelCapForSkill(SkillType skillType, int level) {
        //TODO yet to be implemented
        return 0;
    }

    @Override
    protected void setLevelCapForSkill() {
        this.levelCap = getCurrFightingSkillLevelCap(this.level);
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
        return SkillsLevelsCapsManager.getLevelCapBySkillType(SkillType.ALCHEMY, level);
    }
}

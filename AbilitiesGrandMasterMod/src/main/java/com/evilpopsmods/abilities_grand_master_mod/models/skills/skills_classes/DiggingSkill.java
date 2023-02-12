package com.evilpopsmods.abilities_grand_master_mod.models.skills.skills_classes;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillType;
import com.evilpopsmods.abilities_grand_master_mod.models.skills.levels_consts.SkillsLevelsManager;

public class DiggingSkill extends SkillBase {
    public DiggingSkill(int level, float experience) {
        super(level, experience, getCurrFightingSkillLevelCap(level));
    }

    public static DiggingSkill getInitializedInstance() {
        return new DiggingSkill(1, 0);
    }

    @Override
    protected void setLevelForSkill() {
        this.levelCap = getCurrFightingSkillLevelCap(this.level);
    }

    private static float getCurrFightingSkillLevelCap(final int level) {
        return SkillsLevelsManager.getLevelCapBySkillType(SkillType.DIGGING, level);
    }
}

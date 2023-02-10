package com.evilpopsmods.abilitiesgrandmastermod.models.skills.skills_classes;

import com.evilpopsmods.abilitiesgrandmastermod.models.skills.SkillType;
import com.evilpopsmods.abilitiesgrandmastermod.models.skills.levels_consts.SkillsLevelsManager;

public class AlchemySkill extends SkillBase {
    public AlchemySkill(int level, float experience) {
        super(level, experience, getCurrFightingSkillLevelCap(level));
    }

    @Override
    protected void setNextLevelCap() {
        this.levelCap = getCurrFightingSkillLevelCap(this.level);
    }

    private static float getCurrFightingSkillLevelCap(final int level) {
        return SkillsLevelsManager.getLevelCapBySkillType(SkillType.ALCHEMY, level);
    }
}

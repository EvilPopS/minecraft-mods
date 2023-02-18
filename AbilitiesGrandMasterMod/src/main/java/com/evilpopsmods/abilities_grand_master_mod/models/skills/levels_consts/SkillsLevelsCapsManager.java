package com.evilpopsmods.abilities_grand_master_mod.models.skills.levels_consts;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillType;
import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillTypeHandler;

public class SkillsLevelsCapsManager {
    public static boolean isLevelOutOfBounds(final SkillType skillType, final int level) {
        return level < 1 || level > SkillTypeHandler.getSkillsLevelsCap(skillType).length;
    }

    public static boolean isMaxLevel(final SkillType skillType, final int level) {
        return level == SkillTypeHandler.getSkillsLevelsCap(skillType).length + 1;
    }

    public static float getLevelCapBySkillType(final SkillType skillType, final int level) {
        return getLevelCapFromArray(SkillTypeHandler.getSkillsLevelsCap(skillType), level);
    }

    private static float getLevelCapFromArray(final float[] skillLevelCaps, int level) {
        return skillLevelCaps[level - 1];
    }
}

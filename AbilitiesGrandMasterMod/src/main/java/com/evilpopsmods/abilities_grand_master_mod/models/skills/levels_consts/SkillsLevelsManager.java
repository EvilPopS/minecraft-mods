package com.evilpopsmods.abilities_grand_master_mod.models.skills.levels_consts;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.SkillType;

public class SkillsLevelsManager {
    public static float getLevelCapBySkillType(final SkillType skillType, final int level) {
        return switch (skillType) {
            case FIGHTING -> getLevelCapFromArray(SkillsLevelsCaps.FIGHTING_LVL_CAPS, level);
            case ARCHERY -> getLevelCapFromArray(SkillsLevelsCaps.ARCHERY_LVL_CAPS, level);
            case FALLING -> getLevelCapFromArray(SkillsLevelsCaps.FALLING_LVL_CAPS, level);
            case MINING -> getLevelCapFromArray(SkillsLevelsCaps.MINING_LVL_CAPS, level);
            case DIGGING -> getLevelCapFromArray(SkillsLevelsCaps.DIGGING_LVL_CAPS, level);
            case CUTTING -> getLevelCapFromArray(SkillsLevelsCaps.CUTTING_LVL_CAPS, level);
            case FARMING -> getLevelCapFromArray(SkillsLevelsCaps.FARMING_LVL_CAPS, level);
            case FISHING -> getLevelCapFromArray(SkillsLevelsCaps.FISHING_LVL_CAPS, level);
            case ENCHANTING -> getLevelCapFromArray(SkillsLevelsCaps.ENCHANTING_LVL_CAPS, level);
            case ALCHEMY -> getLevelCapFromArray(SkillsLevelsCaps.ALCHEMY_LVL_CAPS, level);
        };
    }

    private static float getLevelCapFromArray(final float[] skillLevelCaps, int level) {
        return skillLevelCaps[level - 1];
    }
}

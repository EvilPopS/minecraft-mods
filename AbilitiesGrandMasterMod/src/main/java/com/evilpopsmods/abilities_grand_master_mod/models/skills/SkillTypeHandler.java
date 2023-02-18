package com.evilpopsmods.abilities_grand_master_mod.models.skills;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.levels_consts.SkillsLevelsCaps;

public class SkillTypeHandler {
    public static float[] getSkillsLevelsCap(final SkillType skillType) {
        return switch (skillType) {
            case FIGHTING -> SkillsLevelsCaps.FIGHTING_LVL_CAPS;
            case ARCHERY -> SkillsLevelsCaps.ARCHERY_LVL_CAPS;
            case FALLING -> SkillsLevelsCaps.FALLING_LVL_CAPS;
            case MINING -> SkillsLevelsCaps.MINING_LVL_CAPS;
            case DIGGING -> SkillsLevelsCaps.DIGGING_LVL_CAPS;
            case CUTTING -> SkillsLevelsCaps.CUTTING_LVL_CAPS;
            case FARMING -> SkillsLevelsCaps.FARMING_LVL_CAPS;
            case FISHING -> SkillsLevelsCaps.FISHING_LVL_CAPS;
            case ENCHANTING -> SkillsLevelsCaps.ENCHANTING_LVL_CAPS;
            case ALCHEMY -> SkillsLevelsCaps.ALCHEMY_LVL_CAPS;
        };
    }
}

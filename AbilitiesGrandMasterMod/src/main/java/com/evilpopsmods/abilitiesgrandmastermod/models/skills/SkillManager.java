package com.evilpopsmods.abilitiesgrandmastermod.models.skills;

import com.evilpopsmods.abilitiesgrandmastermod.models.skills.skills_classes.*;

public class SkillManager {
    private FightingSkill fightingSkill;
    private ArcherySkill archerySkill;
    private FallingSkill fallingSkill;
    private MiningSkill miningSkill;
    private DiggingSkill diggingSkill;
    private CuttingSkill cuttingSkill;
    private FarmingSkill farmingSkill;
    private FishingSkill fishingSkill;
    private EnchantingSkill enchantingSkill;
    private AlchemySkill alchemySkill;


    public void increaseExperience(final SkillType skillType, final float experience) {
        getSkillByType(skillType).increaseExperience(experience);
    }

    private SkillBase getSkillByType(final SkillType skillType) {
        return switch (skillType) {
            case FIGHTING -> this.fightingSkill;
            case ARCHERY -> this.archerySkill;
            case FALLING -> this.fallingSkill;
            case MINING -> this.miningSkill;
            case DIGGING -> this.diggingSkill;
            case CUTTING -> this.cuttingSkill;
            case FARMING -> this.farmingSkill;
            case FISHING -> this.fishingSkill;
            case ENCHANTING -> this.enchantingSkill;
            case ALCHEMY -> this.alchemySkill;
        };
    }
}

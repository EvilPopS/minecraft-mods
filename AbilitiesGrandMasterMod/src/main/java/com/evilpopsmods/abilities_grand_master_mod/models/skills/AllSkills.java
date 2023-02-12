package com.evilpopsmods.abilities_grand_master_mod.models.skills;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.skills_classes.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllSkills {
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


    public static AllSkills getInitializedInstance() {
        return new AllSkills(
                FightingSkill.getInitializedInstance(),
                ArcherySkill.getInitializedInstance(),
                FallingSkill.getInitializedInstance(),
                MiningSkill.getInitializedInstance(),
                DiggingSkill.getInitializedInstance(),
                CuttingSkill.getInitializedInstance(),
                FarmingSkill.getInitializedInstance(),
                FishingSkill.getInitializedInstance(),
                EnchantingSkill.getInitializedInstance(),
                AlchemySkill.getInitializedInstance()
        );
    }
}

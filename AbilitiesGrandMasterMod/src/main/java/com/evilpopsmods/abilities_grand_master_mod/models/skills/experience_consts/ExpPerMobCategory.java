package com.evilpopsmods.abilities_grand_master_mod.models.skills.experience_consts;

import net.minecraft.world.entity.MobCategory;

import java.util.HashMap;
import java.util.Map;

public class ExpPerMobCategory {
    private static final int EXP_P_HIT_IND = 0;
    private static final int EXP_P_KILL_IND = 1;
    private final static Map<MobCategory, float[]> expPerAction = new HashMap<>() {{
        put(MobCategory.CREATURE, new float[]{0.01f, 0.07f});
        put(MobCategory.AXOLOTLS, new float[]{0.01f, 0.07f});
        put(MobCategory.MONSTER, new float[]{0.1f, 0.7f});
        put(MobCategory.AMBIENT, new float[]{0.5f, 1f});
        put(MobCategory.UNDERGROUND_WATER_CREATURE, new float[]{0.5f, 1f});
        put(MobCategory.WATER_CREATURE, new float[]{0.02f, 0.14f});
        put(MobCategory.WATER_AMBIENT, new float[]{0.03f, 0.1f});
    }};

    public static float getExpPerHit(final MobCategory mobCategory) {
        return expPerAction.get(mobCategory)[EXP_P_HIT_IND];
    }

    public static float getExpPerKill(final MobCategory mobCategory) {
        return expPerAction.get(mobCategory)[EXP_P_KILL_IND];
    }

}

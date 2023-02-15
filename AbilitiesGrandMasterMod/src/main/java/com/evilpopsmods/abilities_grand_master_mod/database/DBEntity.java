package com.evilpopsmods.abilities_grand_master_mod.database;

import com.evilpopsmods.abilities_grand_master_mod.models.skills.AllSkills;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DBEntity {
    private String worldName;
    private String playerName;
    private AllSkills allSkills;

    private DBEntity(String worldName, String playerName) {
        this.worldName = worldName;
        this.playerName = playerName;
        this.allSkills = AllSkills.getInitializedInstance();
    }

    public static DBEntity getInitializedInstance(final String worldName, final String playerName) {
        return new DBEntity(worldName, playerName);
    }
}

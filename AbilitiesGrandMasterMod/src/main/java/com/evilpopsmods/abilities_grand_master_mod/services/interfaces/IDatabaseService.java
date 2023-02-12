package com.evilpopsmods.abilities_grand_master_mod.services.interfaces;

import com.evilpopsmods.abilities_grand_master_mod.custom_exceptions.DBManagerNotInitializedProperlyException;

public interface IDatabaseService {
    void saveSkillDataset() throws DBManagerNotInitializedProperlyException;
    void loadSkillDataset() throws DBManagerNotInitializedProperlyException;
    void setJoinedPlayerName(final String playerName);
    void setLoadedWorldName(final String worldName);
}

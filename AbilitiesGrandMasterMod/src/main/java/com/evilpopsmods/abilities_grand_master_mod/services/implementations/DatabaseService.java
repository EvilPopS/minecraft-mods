package com.evilpopsmods.abilities_grand_master_mod.services.implementations;

import com.evilpopsmods.abilities_grand_master_mod.custom_exceptions.DBManagerNotInitializedProperlyException;
import com.evilpopsmods.abilities_grand_master_mod.custom_exceptions.DataSavingUnsuccessfulException;
import com.evilpopsmods.abilities_grand_master_mod.database.DBManager;
import com.evilpopsmods.abilities_grand_master_mod.services.interfaces.IDatabaseService;

public class DatabaseService implements IDatabaseService {
    public static DatabaseService databaseService = null;
    private final DBManager dbManager;

    private DatabaseService() {
        this.dbManager = DBManager.getSingletonInstance();
    }

    public static DatabaseService getInstance() {
        if (databaseService == null)
            databaseService = new DatabaseService();
        return databaseService;
    }

    @Override
    public void saveSkillDataset() throws DBManagerNotInitializedProperlyException, DataSavingUnsuccessfulException {
        this.dbManager.savePlayerData();
    }

    @Override
    public void loadSkillDataset() throws DBManagerNotInitializedProperlyException {
        this.dbManager.loadPlayerData();
    }

    @Override
    public void setJoinedPlayerName(final String playerName) {
        this.dbManager.setCurrentPlayerName(playerName);
    }

    @Override
    public void setLoadedWorldName(final String worldName) {
        this.dbManager.setCurrentWorldName(worldName);
    }
}

package com.evilpopsmods.abilities_grand_master_mod.database;

import com.evilpopsmods.abilities_grand_master_mod.custom_exceptions.DBManagerNotInitializedProperlyException;
import com.evilpopsmods.abilities_grand_master_mod.custom_exceptions.DataSavingUnsuccessfulException;
import com.evilpopsmods.abilities_grand_master_mod.models.skills.AllSkills;

public interface IDBManager {
    void loadPlayerData() throws DBManagerNotInitializedProperlyException;
    void savePlayerData(final AllSkills updatedAllSkills) throws DBManagerNotInitializedProperlyException, DataSavingUnsuccessfulException;
    AllSkills getAllSkills();
}

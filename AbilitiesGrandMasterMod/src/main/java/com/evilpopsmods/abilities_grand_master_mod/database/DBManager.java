package com.evilpopsmods.abilities_grand_master_mod.database;


import com.evilpopsmods.abilities_grand_master_mod.configurations.Settings;
import com.evilpopsmods.abilities_grand_master_mod.custom_exceptions.DBManagerNotInitializedProperlyException;
import com.evilpopsmods.abilities_grand_master_mod.custom_exceptions.DataSavingUnsuccessfulException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Setter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static DBManager singletonInstance = null;
    private DBEntity dataEntity;
    @Setter
    private String currentWorldName;
    @Setter
    private String currentPlayerName;

    private DBManager() {}

    public static DBManager getSingletonInstance() {
        if (singletonInstance == null)
            singletonInstance = new DBManager();
        return singletonInstance;
    }

    public void loadPlayerData() throws DBManagerNotInitializedProperlyException {
        validateDBManagerInitialization();
        if (getDBEntityByPlayerAndWorldName() == null)
            this.dataEntity = DBEntity.getInitializedInstance(this.currentWorldName, this.currentPlayerName);
    }

    public void savePlayerData() throws DBManagerNotInitializedProperlyException, DataSavingUnsuccessfulException {
        validateDBManagerInitialization();
        saveDataToFile();
    }

    private void saveDataToFile() throws DataSavingUnsuccessfulException {
        try {
            List<DBEntity> entities = loadDBEntitiesFromFile();
            if (!updateEntityIfInDBEntityList(entities))
                addEntityToDBEntityList(entities);
            Files.write(
                    Settings.PLAYERS_SKILL_DATA_PATH_OBJ,
                    new GsonBuilder().setPrettyPrinting().create().toJson(entities).getBytes()
            );
        } catch (IOException e) {
            throw new DataSavingUnsuccessfulException();
        }
    }

    private boolean updateEntityIfInDBEntityList(List<DBEntity> entities) {
        for (int ind = 0; ind < entities.size(); ind++)
            if (entities.get(ind).getPlayerName().equals(this.currentPlayerName) &&
                    entities.get(ind).getWorldName().equals(this.currentWorldName)) {
                entities.set(ind, this.dataEntity);
                return true;
            }
        return false;
    }

    private void addEntityToDBEntityList(List<DBEntity> entities) {
        entities.add(this.dataEntity);
    }

    private DBEntity getDBEntityByPlayerAndWorldName() throws DBManagerNotInitializedProperlyException {
        try {
            for (DBEntity dbEntity : loadDBEntitiesFromFile())
                if (dbEntity.getPlayerName().equals(this.currentPlayerName) && dbEntity.getWorldName().equals(this.currentWorldName))
                    return dbEntity;
        } catch (IOException ignored) {
            throw new DBManagerNotInitializedProperlyException();
        }
        return null;
    }

    private List<DBEntity> loadDBEntitiesFromFile() throws IOException {
        createDirectoryAndFileIfDoesntExist();
        try {
            return new ArrayList<>(
                List.of(
                    new Gson().fromJson(
                            Files.newBufferedReader(Settings.PLAYERS_SKILL_DATA_PATH_OBJ),
                            DBEntity[].class
                    )
                )
            );
        } catch(Exception ignored) {
            resetFileContent();
            return new ArrayList<>();
        }
    }

    private void createDirectoryAndFileIfDoesntExist() throws IOException {
        Path path = Settings.PLAYERS_SKILL_DATA_PATH_OBJ;
        Files.createDirectories(path.getParent());
        if(!Files.exists(path)) {
            Files.createFile(path);
            resetFileContent();
        }
    }

    private void validateDBManagerInitialization() {
        if (this.currentPlayerName == null || this.currentWorldName == null)
            throw new DBManagerNotInitializedProperlyException();
    }

    private void resetFileContent() throws IOException {
        Files.write(Settings.PLAYERS_SKILL_DATA_PATH_OBJ, "[]".getBytes());
    }

}

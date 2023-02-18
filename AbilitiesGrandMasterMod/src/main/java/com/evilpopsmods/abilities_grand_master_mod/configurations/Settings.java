package com.evilpopsmods.abilities_grand_master_mod.configurations;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings {
    public static final Path PLAYERS_SKILL_DATA_PATH_OBJ = Paths.get(Settings.PLAYERS_SKILLS_DATA_FILE_PATH);
    public static final String PLAYERS_SKILLS_DATA_FILE_PATH = "./" + Settings.MOD_FOLDER_NAME + "/" + Settings.PLAYERS_SKILLS_DATA_FILE_NAME;
    private static final String MOD_FOLDER_NAME = "AbilitiesGrandMasterModData";
    private static final String PLAYERS_SKILLS_DATA_FILE_NAME = "players_skills_data.txt";

}

package dev.caua.endersurvival.files;

import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class votePartyFile {

    private File file;
    private FileConfiguration fileConfiguration;

    public votePartyFile() {
        file = new File(EnderSurvival.getInstance().getDataFolder(), "voteparty.yml");
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                file.createNewFile();
                loadConfig();
                Bukkit.getConsoleSender().sendMessage("§aArquivo " + file.getName() + " criado com sucesso.");
            } catch (Exception e) {
                e.printStackTrace();
                Bukkit.getConsoleSender().sendMessage("§cOcorreu um erro ao criar o arquivo:" + file.getName());
            }
        }
    }

    public FileConfiguration getConfig() {
        return fileConfiguration;
    }

    public void saveConfig() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage("§cOcorreu um erro ao salvar o arquivo:" + file.getName());
        }
    }

    private void loadConfig() {
        getConfig().set("Votos", 0);
        saveConfig();
    }


}

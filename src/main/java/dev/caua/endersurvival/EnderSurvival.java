package dev.caua.endersurvival;

import dev.caua.endersurvival.automessage.AutoMessage;
import dev.caua.endersurvival.commands.BroadCastCommand;
import dev.caua.endersurvival.commands.ExecuteExtraVIP;
import dev.caua.endersurvival.commands.ResetTheEnd;
import dev.caua.endersurvival.commands.VoteCommand;
import dev.caua.endersurvival.events.PlayerDeath;
import dev.caua.endersurvival.events.PlayerLoginEvent;
import dev.caua.endersurvival.events.onPortalEvent;
import dev.caua.endersurvival.files.votePartyFile;
import dev.caua.endersurvival.utils.VersionDetector;
import dev.caua.endersurvival.votifier.voteParty;
import dev.caua.endersurvival.votifier.voteReceived;
import dev.caua.endersurvival.votifier.voteReward;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderSurvival extends JavaPlugin {

    public static EnderSurvival instance;
    public static AutoMessage autoMessage;
    public static VersionDetector versionDetector;

    private static dev.caua.endersurvival.votifier.voteReward voteReward;
    private static dev.caua.endersurvival.votifier.voteParty voteParty;
    private static votePartyFile votePartyFile;

    public void onEnable() {
        instance = this;
        if (getConfig().getBoolean("AutoBroadcast.ativar")) {
            autoMessage = new AutoMessage();
            autoMessage.start();
        }
        if (Bukkit.getPluginManager().isPluginEnabled("ViaVersion")) {
            versionDetector = new VersionDetector();
        }
        if (Bukkit.getPluginManager().isPluginEnabled("Votifier")) {
            votePartyFile = new votePartyFile();
            voteReward = new voteReward();
            voteParty = new voteParty();
            voteParty.setupVotes();
        }
        loadConfig();
        registrarComandos();
        registrarEventos();
        Bukkit.getConsoleSender().sendMessage("§a[EnderSurvival] §fPlugin iniciado com sucesso.");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§a[EnderSurvival] §fPlugin desligado com sucesso.");
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public void registrarComandos() {
        getCommand("resettheend").setExecutor(new ResetTheEnd());
        getCommand("vote").setExecutor(new VoteCommand());
        getCommand("broadcast").setExecutor(new BroadCastCommand());
        getCommand("bcgold").setExecutor(new BroadCastCommand());
        getCommand("executarvipextra").setExecutor(new ExecuteExtraVIP());
    }
    public void registrarEventos() {
        if (Bukkit.getPluginManager().isPluginEnabled("ViaVersion")) {
            Bukkit.getPluginManager().registerEvents(versionDetector, this);
        }
        if (Bukkit.getPluginManager().isPluginEnabled("Votifier")) {
            Bukkit.getPluginManager().registerEvents(new voteReceived(), this);
        }
        if (getConfig().getBoolean("DeathCordinates")) {
            Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
        }
        Bukkit.getPluginManager().registerEvents(new PlayerLoginEvent(), this);
        Bukkit.getPluginManager().registerEvents(new onPortalEvent(), this);
    }

    public static EnderSurvival getInstance() {return instance;}
    public static votePartyFile getVotePartyFile() { return votePartyFile; }
    public static voteReward getVoteReward() {return voteReward;}
    public static voteParty getVoteParty() {return voteParty;}

}

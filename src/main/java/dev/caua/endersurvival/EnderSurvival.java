package dev.caua.endersurvival;

import dev.caua.endersurvival.automessage.AutoMessage;
import dev.caua.endersurvival.commands.BroadCastCommand;
import dev.caua.endersurvival.commands.ExecuteExtraVIP;
import dev.caua.endersurvival.commands.ResetTheEnd;
import dev.caua.endersurvival.commands.VoteCommand;
import dev.caua.endersurvival.events.PlayerDeath;
import dev.caua.endersurvival.events.PlayerInteract;
import dev.caua.endersurvival.events.PlayerLoginEvent;
import dev.caua.endersurvival.events.PortalEvent;
import dev.caua.endersurvival.files.VotePartyFile;
import dev.caua.endersurvival.utils.VersionDetector;
import dev.caua.endersurvival.votifier.VoteParty;
import dev.caua.endersurvival.votifier.VoteReceived;
import dev.caua.endersurvival.votifier.VoteReward;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderSurvival extends JavaPlugin {

    public static EnderSurvival instance;
    public static AutoMessage autoMessage;
    public static VersionDetector versionDetector;

    private static VoteReward voteReward;
    private static VoteParty voteParty;
    private static VotePartyFile votePartyFile;

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
            votePartyFile = new VotePartyFile();
            voteReward = new VoteReward();
            voteParty = new VoteParty();
            voteParty.setupVotes();
        }
        loadConfig();
        registrarComandos();
        registrarEventos();
        Bukkit.getConsoleSender().sendMessage("§a[EnderSurvival] §fPlugin iniciado com sucesso.");
    }

    public void onDisable() {
        voteParty.saveVotes();
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
            Bukkit.getPluginManager().registerEvents(new VoteReceived(), this);
        }
        if (getConfig().getBoolean("DeathCordinates")) {
            Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
        }
        Bukkit.getPluginManager().registerEvents(new PlayerLoginEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PortalEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
    }

    public static EnderSurvival getInstance() {return instance;}
    public static VotePartyFile getVotePartyFile() { return votePartyFile; }
    public static VoteReward getVoteReward() {return voteReward;}
    public static VoteParty getVoteParty() {return voteParty;}

}

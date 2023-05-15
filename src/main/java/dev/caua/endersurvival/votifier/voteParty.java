package dev.caua.endersurvival.votifier;

import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class voteParty {

    int sec = 30;
    int votes;
    private BukkitTask announce;
    private BukkitTask start;

    public void setupVotes() {
        votes = EnderSurvival.getVotePartyFile().getConfig().getInt("Votos");
        Bukkit.getConsoleSender().sendMessage("§b§l[Votos] §fVotos carregados: " + votes);
        announce();
    }

    public void addVote() {
        ++votes;
        Bukkit.getConsoleSender().sendMessage("§b§l[Votos] §fVote party atual: " + votes);
        String cmd = "tm abroadcast &d&lVote Party: &a" +votes+ "/50";
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmd);
        if (votes == 50) {
            startDrop();
            votes = 0;
        }
    }

    public void saveVotes() {
        EnderSurvival.getVotePartyFile().getConfig().set("Votos", votes);
        EnderSurvival.getVotePartyFile().saveConfig();
        Bukkit.getConsoleSender().sendMessage("§b§l[Votos] §fVotos salvados: " + votes);
    }

    public void announce() {
        announce = new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage(" §e§lVOTOS §7(/vote)");
                Bukkit.broadcastMessage(" §fVote no servidor e ganhe recompensas!");
                Bukkit.broadcastMessage(" §fComplete a Vote Party para iniciar uma Caixa All!");
                Bukkit.broadcastMessage(" §fVote Party atual: §b" +votes+"/50");
                Bukkit.broadcastMessage("");
            }
        }.runTaskTimerAsynchronously(EnderSurvival.getInstance(), 21620, 21620);
    }

    public int getVotes() {return votes;}


    // DROP SYSTEM

    public void startDrop(){
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tm bc &d&lVote Party<nl>&aConcluída!");
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "crate key give * basica 1");
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(" §d§lVOTE PARTY CONCLUIDA!");
        Bukkit.broadcastMessage(" §fTodos os jogadores online receberam uma caixa §eBásica§f!");
        Bukkit.broadcastMessage("");
    }

}

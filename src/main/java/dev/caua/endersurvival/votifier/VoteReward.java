package dev.caua.endersurvival.votifier;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class VoteReward {

    public void giveReward(String username, String service){
        if(Bukkit.getPlayer(username) == null) {
            Bukkit.getConsoleSender().sendMessage("§b§l[Votos] §fErro ao encontrar o jogador: " + username);
            return;
        }
        Player p = Bukkit.getPlayer(username);
        Bukkit.broadcastMessage("§7[§e!§7] §6" + username + " §evotou em §6" +service+ " §ee ganhou §6500 coins§e e uma §6CHAVE BASICA§e. §7(/vote)");
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "money add " + username + " 500");
        if (p.getWorld() != Bukkit.getWorld("Eventos")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "crate key give " + username + " basica 1");
        } else {
            p.sendMessage("§cVocê não recebeu a chave basica do voto, pois está em um lugar não permitido.");
        }
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
    }

}

package dev.caua.endersurvival.utils;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;
import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public class VersionDetector implements Listener {

    private BukkitTask exec;
    private ArrayList<Player> cooldown = new ArrayList<>();
    ViaAPI api = Via.getAPI(); // Get the API

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        exec(p);
    }

    public void exec(Player p) {
        exec = new BukkitRunnable() {
            @Override
            public void run() {
                if (p == null) return;
                int version = api.getPlayerVersion(p);
                if (version != 762) {
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 0, 0);
                    p.sendMessage("");
                    p.sendMessage(" §c§lATENÇÃO");
                    p.sendMessage(" §fVocê está jogando em uma versão não suportada. §8(" +version+ ")");
                    p.sendMessage("");
                    p.sendMessage(" §cVocê pode enfrentar bugs e não ter acesso a algumas funções com esta versão.");
                    p.sendMessage(" §aUtilize a versão 1.19.4 para uma experiência melhorada.");
                    p.sendMessage("");
                }
                this.cancel();
            }
        }.runTaskTimer(EnderSurvival.getInstance(), 60, 60);
    }

}

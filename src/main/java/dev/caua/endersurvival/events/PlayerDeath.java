package dev.caua.endersurvival.events;

import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class PlayerDeath implements Listener {

    private BukkitTask sendMsg;
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Location deathloc = e.getEntity().getLocation();
        if (deathloc.getWorld().getName().equalsIgnoreCase(EnderSurvival.getInstance().getConfig().getString("MundoSpawn")) || deathloc.getWorld().getName().equalsIgnoreCase(EnderSurvival.getInstance().getConfig().getString("Eventos"))) return;
        sendMsg(e.getEntity(), deathloc);
    }


    public void sendMsg(Player p, Location deathloc) {
        sendMsg = new BukkitRunnable() {
            @Override
            public void run() {
                p.sendMessage("§6Suas coordenadas de morte: §fX: §e" + Math.round(deathloc.getX()) + " §fY: §e" + Math.round(deathloc.getY()) + " §fZ: §e" +Math.round(deathloc.getZ()));
                p.sendMessage("§7VIPs podem voltar ao local de morte usando /back.");
                p.sendMessage("§8Caso a chunk esteja carregada, seus itens sumirão em 5 minutos.");
                this.cancel();
            }
        }.runTaskTimer(EnderSurvival.getInstance(), 60, 100000);
    }
}

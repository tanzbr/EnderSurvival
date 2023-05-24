package dev.caua.endersurvival.events;

import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PortalEvent implements Listener {

    private HashMap<Player, Long> cooldown = new HashMap<>();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPortal(PlayerPortalEvent e) {
        Player p = e.getPlayer();
        if (!p.getWorld().getName().equalsIgnoreCase(Objects.requireNonNull(EnderSurvival.getInstance().getConfig().getString("MundoSpawn")))) return;
        e.setCancelled(true);

        if (cooldown.containsKey(p) && !(System.currentTimeMillis() >= cooldown.get(p))) {
            return;
        } else cooldown.remove(p);
        cooldown.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20));
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "betterrtp player " +p.getName()+ " MundoSurvival");
    }


    private Long converter(Player p) {
        long tempo = System.currentTimeMillis() - cooldown.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }
}

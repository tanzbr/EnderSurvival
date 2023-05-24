package dev.caua.endersurvival.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class PlayerInteract implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent e) {
        if (Objects.requireNonNull(e.getClickedBlock()).getBlockData().getMaterial() != Material.SPAWNER) return;
        if (!Objects.requireNonNull(Objects.requireNonNull(e.getItem()).getItemMeta()).getDisplayName().contains("Ball")) return;
        e.setCancelled(true);
        e.getPlayer().sendMessage("§cVocê não pode alterar o tipo do spawner usando pokébolas.");
    }

}

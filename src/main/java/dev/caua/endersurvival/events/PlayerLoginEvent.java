package dev.caua.endersurvival.events;

import dev.caua.endersurvival.EnderSurvival;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerLoginEvent implements Listener {

    @EventHandler
    public void joinMessage(org.bukkit.event.player.PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        for (String message : EnderSurvival.getInstance().getConfig().getStringList("JoinMessages")) {
            if (message.contains("<center>")) {
                p.sendMessage(centerText(message.replaceAll("&", "§").replace("<center>", "").replaceAll("<players>", String.valueOf(Bukkit.getOnlinePlayers().size()))));
            } else {
                p.sendMessage(message.replaceAll("&", "§").replaceAll("<players>", String.valueOf(Bukkit.getOnlinePlayers().size())));
            }
        }
    }

    @EventHandler
    public void quit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }

    private String centerText(String text) {
        int maxWidth = 80,
                spaces = (int) Math.round((maxWidth-1.4* ChatColor.stripColor(text).length())/2);
        return StringUtils.repeat(" ", spaces)+text;
    }

}

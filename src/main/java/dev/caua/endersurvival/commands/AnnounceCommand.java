package dev.caua.endersurvival.commands;

import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class AnnounceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            if (!(sender.hasPermission("endersurvival.broadcast"))) return false;
            if (cmd.getName().equalsIgnoreCase("announce")) {
                String message = "&6";
                for (int i = 0; i != args.length; i++) message += args[i] + " ";
                Bukkit.broadcastMessage(me.caua.endercraft.enderutils.utils.ColorTranslate.chatColors(message));
                return true;
            }
        } else if (sender instanceof ConsoleCommandSender || sender instanceof RemoteConsoleCommandSender) {
            if (cmd.getName().equalsIgnoreCase("announce")) {
                String message = "&6";
                for (int i = 0; i != args.length; i++) message += args[i] + " ";
                Bukkit.broadcastMessage(me.caua.endercraft.enderutils.utils.ColorTranslate.chatColors(message));
                return true;
            }
        }
        return false;
    }

}

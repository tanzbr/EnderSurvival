package dev.caua.endersurvival.commands;

import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!cmd.getName().equalsIgnoreCase("vote")) return false;
        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;

        if (args.length != 1) {
            p.sendMessage("");
            p.sendMessage(" §e§lVotos");
            p.sendMessage("");
            p.sendMessage(" §a/vote links §7- §fLinks para votar no servidor.");
            p.sendMessage(" §a/vote party §7- §fVeja a Vote Party atual.");
            p.sendMessage("");
            return false;
        } else {
            if (args[0].equalsIgnoreCase("links")) {
                p.sendMessage("");
                p.sendMessage(" §e§lLinks para votar");
                p.sendMessage("");
                for(String message : EnderSurvival.getInstance().getConfig().getStringList("VotesLinks")) {
                    p.sendMessage(" §a"+message);
                }
                p.sendMessage("");
                return false;
            }

            if (args[0].equalsIgnoreCase("party")) {
                p.sendMessage("");
                p.sendMessage(" §d§lVote Party");
                p.sendMessage(" §fAo atingir 50 votos no servidor,");
                p.sendMessage(" §fa vote party será iniciada,");
                p.sendMessage(" §fdando uma caixa básica a todos online.");
                p.sendMessage("");
                p.sendMessage("§fVote Party atual: §a" + EnderSurvival.getVoteParty().getVotes() + "/50");
                p.sendMessage("");
                return false;
            }
        }

        return false;
    }
}

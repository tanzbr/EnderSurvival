package dev.caua.endersurvival.commands;

import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class ExecuteExtraVIP implements CommandExecutor {

    private BukkitTask execvip;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (cmd.getName().equalsIgnoreCase("executarvipextra")) {
            if (sender instanceof ConsoleCommandSender || sender instanceof RemoteConsoleCommandSender) {

                if (args.length < 2) {
                    sender.sendMessage("§fUso correto: /executarvipextra <jogador> <vip>");
                    return false;
                }
                Player p = Bukkit.getPlayer(args[0]);
                if (p == null) {
                    sender.sendMessage("§fJogador não encontrado.");
                    return false;
                }

                String comando = EnderSurvival.getInstance().getConfig().getString("comando").replace("{player}", p.getName()).replace("{vip}", args[1]);
                double d = Math.random() * 100;
                if (d < EnderSurvival.getInstance().getConfig().getInt("chance")) {
                    p.sendMessage("");
                    p.sendMessage("§e§lVIPS ➜ §fVocê foi o sortudo da vez! Preparando entrega do seu VIP Extra.");
                    p.sendMessage("");
                    Bukkit.getConsoleSender().sendMessage("§a[EnderSurvival] §fO jogador "+ p.getName() + " ganhou o VIP Extra!");
                    execvip(p, comando);
                } else {
                    p.sendMessage("§e[VIP Extra] §fInfelizmente você não ganhou o VIP Extra desta vez :(");
                    Bukkit.getConsoleSender().sendMessage("§a[EnderSurvival] §fO jogador "+ p.getName() + " não ganhou o VIP Extra desta vez :(");
                }

            }
        }
        return false;
    }

    public static Boolean percentChance(double chance) {
        return Math.random() <= chance;
    }

    public void execvip(Player p, String comando) {
        execvip = new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage(" §e§lVIPS");
                Bukkit.broadcastMessage(" §fO jogador §e" + p.getName() + " §fcom §e1% §fde chance ganhou um §eVIP Extra§f!");
                Bukkit.broadcastMessage("");
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tm bc &e" + p.getName()+ "<nl>&fganhou um &eVIP Extra&f!");
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), comando);
                this.cancel();
            }
        }.runTaskTimer(EnderSurvival.getInstance(), 100, 100000);
    }

}

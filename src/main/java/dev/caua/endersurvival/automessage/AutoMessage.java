package dev.caua.endersurvival.automessage;

import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.Random;

public class AutoMessage {

    ArrayList mensagens = new ArrayList();
    int delay;
    private BukkitTask exec;
    Random rand = new Random();
    Boolean random;
    int contagem = 0;

    public void start() {
        load();
        exec();
    }

    public void exec() {
        exec = new BukkitRunnable() {
            @Override
            public void run() {
                if (random) {
                    Bukkit.broadcastMessage(mensagens.get(rand.nextInt(mensagens.size())).toString().replaceAll("&", "§"));
                } else {
                    Bukkit.broadcastMessage(mensagens.get(contagem).toString().replaceAll("&", "§"));
                    contagem = contagem+1;
                    if (contagem > mensagens.size()) {
                        contagem = 0;
                    }
                }
            }
        }.runTaskTimer(EnderSurvival.getInstance(), 400, delay);
    }

    public void load() {
        mensagens = (ArrayList) EnderSurvival.getInstance().getConfig().getStringList("AutoBroadcast.mensagens");
        delay = EnderSurvival.getInstance().getConfig().getInt("AutoBroadcast.delay")*60*20;
        random = EnderSurvival.getInstance().getConfig().getBoolean("AutoBroadcast.random");
    }

}

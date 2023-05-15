package dev.caua.endersurvival.commands;

import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.Objects;

public class ResetTheEnd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!cmd.getName().equalsIgnoreCase("resettheend")) return false;
        if (sender instanceof Player) {
            if (!sender.isOp()) return false;
            regenWorld(EnderSurvival.getInstance().getConfig().getString("MundoEnd"), World.Environment.THE_END);
        } else if (sender instanceof ConsoleCommandSender) {
            regenWorld(EnderSurvival.getInstance().getConfig().getString("MundoEnd"), World.Environment.THE_END);
        }
        return false;
    }


    public void regenWorld(String w, World.Environment en) {

        World world = Bukkit.getWorld(w);
        Location spawn = Bukkit.getWorld(Objects.requireNonNull(EnderSurvival.getInstance().getConfig().getString("MundoSpawn"))).getSpawnLocation();

        if (world != null) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getLocation().getWorld().getName().equalsIgnoreCase(w)) player.teleport(spawn);
            }
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage(" §3§lTHE END");
            Bukkit.broadcastMessage(" §fO mundo do The End está sendo resetado!");
            Bukkit.broadcastMessage(" §7Isto pode causar lag.");
            Bukkit.broadcastMessage("");
            for (Chunk c : world.getLoadedChunks()) {
                c.unload();
            }
            Bukkit.unloadWorld(world, false);
            File folder = new File(Bukkit.getWorldContainer()+"/"+w);
            for (File file : Objects.requireNonNull(folder.getAbsoluteFile().listFiles())) {
                file.delete();
            }
            folder.delete();
        }

        WorldCreator worldc = new WorldCreator(w);
        worldc.environment(en);
        worldc.generateStructures(true);
        Bukkit.createWorld(worldc);
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage(" §3§lTHE END");
        Bukkit.broadcastMessage(" §fMundo resetado com sucesso!");
        Bukkit.broadcastMessage("");
    }

}

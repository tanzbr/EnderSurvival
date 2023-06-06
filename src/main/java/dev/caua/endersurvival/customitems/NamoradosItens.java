package dev.caua.endersurvival.customitems;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NamoradosItens implements CommandExecutor {

    List<ItemStack> itens = new ArrayList<>();

    // CAPACETE NATAL
    ItemStack capacetenatal = new ItemStack(Material.NETHERITE_HELMET, 1);
    ItemMeta capacetemeta = capacetenatal.getItemMeta();
    // PEITORAL NATAL
    ItemStack peitoralnatal = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
    ItemMeta peitoralmeta = peitoralnatal.getItemMeta();
    // CALÇA NATAL
    ItemStack calcanatal = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
    ItemMeta calcameta = calcanatal.getItemMeta();
    // BOTAS NATAL
    ItemStack botasnatal = new ItemStack(Material.NETHERITE_BOOTS, 1);
    ItemMeta botasmeta = botasnatal.getItemMeta();
    // ESPADA NATAL
    ItemStack espadanatal = new ItemStack(Material.NETHERITE_SWORD, 1);
    ItemMeta espadameta = espadanatal.getItemMeta();
    // picareta NATAL
    ItemStack picaretanatal = new ItemStack(Material.NETHERITE_PICKAXE, 1);
    ItemMeta picaretameta = picaretanatal.getItemMeta();
    // machado NATAL
    ItemStack machadonatal = new ItemStack(Material.NETHERITE_AXE, 1);
    ItemMeta machadometa = machadonatal.getItemMeta();
    // machadosharp NATAL
    ItemStack machadosharpnatal = new ItemStack(Material.NETHERITE_AXE, 1);
    ItemMeta machadosharpmeta = machadosharpnatal.getItemMeta();
    // pa NATAL
    ItemStack panatal = new ItemStack(Material.NETHERITE_SHOVEL, 1);
    ItemMeta pameta = panatal.getItemMeta();
    // enxada NATAL
    ItemStack enxadanatal = new ItemStack(Material.NETHERITE_HOE, 1);
    ItemMeta enxadameta = enxadanatal.getItemMeta();
    // arco NATAL
    ItemStack arconatal = new ItemStack(Material.BOW, 1);
    ItemMeta arcometa = arconatal.getItemMeta();
    // vara NATAL
    ItemStack varanatal = new ItemStack(Material.FISHING_ROD, 1);
    ItemMeta varameta = varanatal.getItemMeta();
    private final Random random = new Random();

    public String addLore(String nick) {
        if (random.nextBoolean()) {
            return "§4➜ §f§n"+nick+"§c está apaixonado!";
        } else {
            return "§4➜ §f§n"+nick+"§c está solteirão!";
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!cmd.getName().equalsIgnoreCase("giveitemnamorados")) return false;
        if (!(sender instanceof ConsoleCommandSender || sender instanceof RemoteConsoleCommandSender)) return false;
        if (args.length != 2) {
            sender.sendMessage("§cUse: /giveitemnamorados <player> <item>");
            return false;
        }
        Player p = Bukkit.getPlayer(args[0]);
        if (p == null) {
            sender.sendMessage("§cJogador offline ou não encontrado.");
            return false;
        }
        
        if (args[1].equalsIgnoreCase("capacete")) {
            List<String> lores = new ArrayList<>();
            lores.add("§fEDIÇÃO ESPECIAL: §#fb0000§l❤ §#fb0404§lD§#fb0808§lI§#fb0b0b§lA §#fc0f0f§lD§#fc1313§lO§#fc1717§lS §#fc1a1a§lN§#fc1e1e§lA§#fc2222§lM§#fc2626§lO§#fc2929§lR§#fd2d2d§lA§#fd3131§lD§#fd3535§lO§#fd3838§lS §#fd3c3c§l❤");
            lores.add(addLore(p.getName()));
            capacetemeta.setLore(lores);
            capacetemeta.setDisplayName("§#fb0000§l❤ §#fb0404§lC§#fb0808§la§#fb0c0c§lp§#fc1010§la§#fc1414§lc§#fc1818§le§#fc1c1c§lt§#fc2020§le §#fc2424§ld§#fc2828§lo §#fc2c2c§lA§#fd3030§lm§#fd3434§lo§#fd3838§lr §#fd3c3c§l❤");

            capacetemeta.addEnchant(Enchantment.DURABILITY, 5, true);
            capacetemeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            capacetemeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
            capacetemeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
            capacetemeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
            capacetemeta.addEnchant(Enchantment.OXYGEN, 3, true);
            capacetemeta.addEnchant(Enchantment.WATER_WORKER, 1, true);

            capacetenatal.setItemMeta(capacetemeta);
            p.getInventory().addItem(capacetenatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("peitoral")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            peitoralmeta.setLore(lores);

            peitoralmeta.addEnchant(Enchantment.DURABILITY, 5, true);
            peitoralmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            peitoralmeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
            peitoralmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
            peitoralmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);

            peitoralmeta.setDisplayName("§a➜ Peitoral da Sabedoria");
            peitoralnatal.setItemMeta(peitoralmeta);
            p.getInventory().addItem(peitoralnatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("calca")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            calcameta.setLore(lores);

            calcameta.addEnchant(Enchantment.DURABILITY, 5, true);
            calcameta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            calcameta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
            calcameta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
            calcameta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);

            calcameta.setDisplayName("§a➜ Calça da Sabedoria");
            calcanatal.setItemMeta(calcameta);
            p.getInventory().addItem(calcanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("botas")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            botasmeta.setLore(lores);

            botasmeta.addEnchant(Enchantment.DURABILITY, 5, true);
            botasmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            botasmeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
            botasmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
            botasmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
            botasmeta.addEnchant(Enchantment.PROTECTION_FALL, 5, true);
            botasmeta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);

            botasmeta.setDisplayName("§a➜ Botas da Sabedoria");
            botasnatal.setItemMeta(botasmeta);
            p.getInventory().addItem(botasnatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("espada")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            espadameta.setLore(lores);

            espadameta.addEnchant(Enchantment.DURABILITY, 5, true);
            espadameta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
            espadameta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);

            espadameta.setDisplayName("§a➜ Espada da Sabedoria");
            espadanatal.setItemMeta(espadameta);
            p.getInventory().addItem(espadanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("picareta")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            picaretameta.setLore(lores);

            picaretameta.addEnchant(Enchantment.DURABILITY, 5, true);
            picaretameta.addEnchant(Enchantment.DIG_SPEED, 7, true);
            picaretameta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);

            picaretameta.setDisplayName("§a➜ Picareta da Sabedoria");
            picaretanatal.setItemMeta(picaretameta);
            p.getInventory().addItem(picaretanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("machado")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            machadometa.setLore(lores);

            machadometa.addEnchant(Enchantment.DURABILITY, 5, true);
            machadometa.addEnchant(Enchantment.DIG_SPEED, 6, true);
            machadometa.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
            machadometa.addEnchant(Enchantment.LOOT_BONUS_MOBS, 4, true);

            machadometa.setDisplayName("§a➜ Machado da Sabedoria");
            machadonatal.setItemMeta(machadometa);
            p.getInventory().addItem(machadonatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("machadosharp")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            machadosharpmeta.setLore(lores);

            machadosharpmeta.addEnchant(Enchantment.DURABILITY, 5, true);
            machadosharpmeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
            machadosharpmeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);

            machadosharpmeta.setDisplayName("§a➜ Ragnarok ⚡");
            machadosharpnatal.setItemMeta(machadosharpmeta);
            p.getInventory().addItem(machadosharpnatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("pa")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            pameta.setLore(lores);

            pameta.addEnchant(Enchantment.DURABILITY, 5, true);
            pameta.addEnchant(Enchantment.DIG_SPEED, 6, true);

            pameta.setDisplayName("§a➜ Pá da Sabedoria");
            panatal.setItemMeta(pameta);
            p.getInventory().addItem(panatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("enxada")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            enxadameta.setLore(lores);

            enxadameta.addEnchant(Enchantment.DURABILITY, 5, true);
            enxadameta.addEnchant(Enchantment.DIG_SPEED, 6, true);
            enxadameta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);

            enxadameta.setDisplayName("§a➜ Enxada da Sabedoria");
            enxadanatal.setItemMeta(enxadameta);
            p.getInventory().addItem(enxadanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("arco")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            arcometa.setLore(lores);

            arcometa.addEnchant(Enchantment.ARROW_DAMAGE, 6, true);
            arcometa.addEnchant(Enchantment.DURABILITY, 5, true);
            arcometa.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            arcometa.addEnchant(Enchantment.ARROW_FIRE, 1, true);
            arcometa.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);

            arcometa.setDisplayName("§a➜ Arco da Sabedoria");
            arconatal.setItemMeta(arcometa);
            p.getInventory().addItem(arconatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("vara")) {
            List<String> lores = new ArrayList<>();
            lores.add("§a§lV§f§lO§a§lL§f§lT§a§lA §f§lA§a§lS §f§lA§a§lU§f§lL§a§lA§f§lS");
            lores.add(addLore(p.getName()));
            varameta.setLore(lores);

            varameta.addEnchant(Enchantment.DURABILITY, 5, true);
            varameta.addEnchant(Enchantment.LUCK, 4, true);
            varameta.addEnchant(Enchantment.LURE, 4, true);

            varameta.setDisplayName("§a➜ Vara da Sabedoria");
            varanatal.setItemMeta(varameta);
            p.getInventory().addItem(varanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        sender.sendMessage("§c[Namorados] §fItem não encontrado");
        return false;
    }
}

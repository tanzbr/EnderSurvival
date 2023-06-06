package dev.caua.endersurvival.customitems;

import dev.caua.endersurvival.utils.ColorTranslate;
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
    ItemStack turtlenatal = new ItemStack(Material.TURTLE_HELMET, 1);
    ItemMeta turtlemeta = turtlenatal.getItemMeta();
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
    ItemStack espadalootnatal = new ItemStack(Material.NETHERITE_SWORD, 1);
    ItemMeta espadalootmeta = espadalootnatal.getItemMeta();
    // picareta NATAL
    ItemStack picaretanatal = new ItemStack(Material.NETHERITE_PICKAXE, 1);
    ItemMeta picaretameta = picaretanatal.getItemMeta();
    ItemStack picaretasilknatal = new ItemStack(Material.NETHERITE_PICKAXE, 1);
    ItemMeta picaretasilkmeta = picaretasilknatal.getItemMeta();
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
    ItemStack bestanatal = new ItemStack(Material.CROSSBOW, 1);
    ItemMeta bestameta = bestanatal.getItemMeta();
    ItemStack tridentenatal = new ItemStack(Material.TRIDENT, 1);
    ItemMeta tridentemeta = tridentenatal.getItemMeta();
    ItemStack elytranatal = new ItemStack(Material.ELYTRA, 1);
    ItemMeta elytrameta = elytranatal.getItemMeta();
    // vara NATAL
    ItemStack varanatal = new ItemStack(Material.FISHING_ROD, 1);
    ItemMeta varameta = varanatal.getItemMeta();
    private final Random random = new Random();

    public String addLore(String nick) {
        if (random.nextBoolean()) {
            return ColorTranslate.chatColors(" &#fb00df&l➜ §f§n"+nick+"§c &#fb00dfe&#fb02d1s&#fb03c2t&#fb05b4á &#fc06a6a&#fc0897p&#fc0989a&#fc0b7bi&#fc0d6cx&#fc0e5eo&#fc104fn&#fd1141a&#fd1333d&#fd1424o&#fd1616!");
        } else {
            return ColorTranslate.chatColors(" &#02fb00➜ §f§n"+nick+"§c &#02fb00e&#14fb00s&#26fb00t&#38fc00á &#4afc00n&#5cfc00a &#6dfc00p&#7ffc00i&#91fc00s&#a3fd00t&#b5fd00a&#c7fd00!");
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

        if (args[1].equalsIgnoreCase("turtle")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            turtlemeta.setLore(lores);
            turtlemeta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb01d5&lC&#fb02cc&lA&#fb03c2&lS&#fb04b9&lC&#fb05af&lO &#fc06a6&lC&#fc079c&lO&#fc0892&lN&#fc0989&lT&#fc0a7f&lR&#fc0c76&lA &#fc0d6c&lD&#fc0e63&lE&#fc0f59&lC&#fc104f&lE&#fd1146&lP&#fd123c&lÇ&#fd1333&lÕ&#fd1429&lE&#fd1520&lS &#fd1616&l❤"));

            turtlemeta.addEnchant(Enchantment.DURABILITY, 5, true);
            turtlemeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            turtlemeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
            turtlemeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
            turtlemeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
            turtlemeta.addEnchant(Enchantment.OXYGEN, 3, true);
            turtlemeta.addEnchant(Enchantment.WATER_WORKER, 1, true);
            turtlemeta.addEnchant(Enchantment.MENDING, 1, true);

            turtlenatal.setItemMeta(turtlemeta);
            p.getInventory().addItem(turtlenatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("capacete")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            capacetemeta.setLore(lores);
            capacetemeta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb01d2&lC&#fb03c4&lA&#fb04b7&lP&#fc06a9&lA&#fc079c&lC&#fc098f&lE&#fc0a81&lT&#fc0c74&lE &#fc0d66&lD&#fc0f59&lO &#fc104c&lA&#fd123e&lM&#fd1331&lO&#fd1523&lR &#fd1616&l❤"));

            capacetemeta.addEnchant(Enchantment.DURABILITY, 5, true);
            capacetemeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            capacetemeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
            capacetemeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
            capacetemeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
            capacetemeta.addEnchant(Enchantment.OXYGEN, 3, true);
            capacetemeta.addEnchant(Enchantment.WATER_WORKER, 1, true);
            capacetemeta.addEnchant(Enchantment.MENDING, 1, true);

            capacetenatal.setItemMeta(capacetemeta);
            p.getInventory().addItem(capacetenatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("peitoral")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            peitoralmeta.setLore(lores);

            peitoralmeta.addEnchant(Enchantment.DURABILITY, 5, true);
            peitoralmeta.addEnchant(Enchantment.MENDING, 1, true);
            peitoralmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            peitoralmeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
            peitoralmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
            peitoralmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);

            peitoralmeta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb01d2&lP&#fb03c4&lE&#fb04b7&lI&#fc06a9&lT&#fc079c&lO&#fc098f&lR&#fc0a81&lA&#fc0c74&lL &#fc0d66&lD&#fc0f59&lO &#fc104c&lA&#fd123e&lM&#fd1331&lO&#fd1523&lR &#fd1616&l❤"));
            peitoralnatal.setItemMeta(peitoralmeta);
            p.getInventory().addItem(peitoralnatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("calca")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            calcameta.setLore(lores);

            calcameta.addEnchant(Enchantment.DURABILITY, 5, true);
            calcameta.addEnchant(Enchantment.MENDING, 1, true);
            calcameta.addEnchant(Enchantment.SWIFT_SNEAK, 3, true);
            calcameta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            calcameta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
            calcameta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
            calcameta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);

            calcameta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02ce&lC&#fb04be&lA&#fc06ad&lL&#fc079c&lÇ&#fc098b&lA &#fc0b7b&lD&#fc0d6a&lO &#fc0f59&lA&#fd1148&lM&#fd1238&lO&#fd1427&lR &#fd1616&l❤"));
            calcanatal.setItemMeta(calcameta);
            p.getInventory().addItem(calcanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("botas")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            botasmeta.setLore(lores);

            botasmeta.addEnchant(Enchantment.DURABILITY, 5, true);
            botasmeta.addEnchant(Enchantment.MENDING, 1, true);
            botasmeta.addEnchant(Enchantment.SOUL_SPEED, 3, true);
            botasmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            botasmeta.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
            botasmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 4, true);
            botasmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
            botasmeta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
            botasmeta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);

            botasmeta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02ce&lB&#fb04be&lO&#fc06ad&lT&#fc079c&lA&#fc098b&lS &#fc0b7b&lD&#fc0d6a&lO &#fc0f59&lA&#fd1148&lM&#fd1238&lO&#fd1427&lR &#fd1616&l❤"));
            botasnatal.setItemMeta(botasmeta);
            p.getInventory().addItem(botasnatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("espada")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            espadameta.setLore(lores);

            espadameta.addEnchant(Enchantment.DURABILITY, 5, true);
            espadameta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
            espadameta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
            espadameta.addEnchant(Enchantment.MENDING, 1, true);

            espadameta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02d0&lE&#fb03c0&lS&#fb05b1&lP&#fc07a1&lA&#fc0892&lD&#fc0a82&lA &#fc0c73&lD&#fc0e63&lO &#fc0f54&lA&#fd1144&lM&#fd1335&lO&#fd1425&lR &#fd1616&l❤"));
            espadanatal.setItemMeta(espadameta);
            p.getInventory().addItem(espadanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("espadaloot")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            espadalootmeta.setLore(lores);

            espadalootmeta.addEnchant(Enchantment.DURABILITY, 5, true);
            espadalootmeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
            espadalootmeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 5, true);
            espadalootmeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 5, true);
            espadalootmeta.addEnchant(Enchantment.DAMAGE_UNDEAD, 5, true);
            espadalootmeta.addEnchant(Enchantment.MENDING, 1, true);

            espadalootmeta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02ce&lA&#fb04be&lM&#fc06ad&lO&#fc079c&lR &#fc098b&lP&#fc0b7b&lO&#fc0d6a&lR &#fc0f59&lM&#fd1148&lO&#fd1238&lB&#fd1427&lS &#fd1616&l❤"));
            espadalootnatal.setItemMeta(espadalootmeta);
            p.getInventory().addItem(espadalootnatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("picareta")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            picaretameta.setLore(lores);

            picaretameta.addEnchant(Enchantment.DURABILITY, 5, true);
            picaretameta.addEnchant(Enchantment.DIG_SPEED, 7, true);
            picaretameta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
            picaretameta.addEnchant(Enchantment.MENDING, 1, true);

            picaretameta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb01d2&lP&#fb03c4&lI&#fb04b7&lC&#fc06a9&lA&#fc079c&lR&#fc098f&lE&#fc0a81&lT&#fc0c74&lA &#fc0d66&lD&#fc0f59&lO &#fc104c&lA&#fd123e&lM&#fd1331&lO&#fd1523&lR &#fd1616&l❤"));
            picaretanatal.setItemMeta(picaretameta);
            p.getInventory().addItem(picaretanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("picaretasilk")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            picaretasilkmeta.setLore(lores);

            picaretasilkmeta.addEnchant(Enchantment.DURABILITY, 5, true);
            picaretasilkmeta.addEnchant(Enchantment.DIG_SPEED, 7, true);
            picaretasilkmeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            picaretasilkmeta.addEnchant(Enchantment.MENDING, 1, true);

            picaretasilkmeta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb01d2&lP&#fb03c4&lI&#fb04b7&lC&#fc06a9&lA&#fc079c&lR&#fc098f&lE&#fc0a81&lT&#fc0c74&lA &#fc0d66&lD&#fc0f59&lO &#fc104c&lA&#fd123e&lM&#fd1331&lO&#fd1523&lR &#fd1616&l❤"));
            picaretasilknatal.setItemMeta(picaretasilkmeta);
            p.getInventory().addItem(picaretasilknatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("machado")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            machadometa.setLore(lores);

            machadometa.addEnchant(Enchantment.DURABILITY, 5, true);
            machadometa.addEnchant(Enchantment.DIG_SPEED, 6, true);
            machadometa.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
            machadometa.addEnchant(Enchantment.LOOT_BONUS_MOBS, 4, true);
            machadometa.addEnchant(Enchantment.MENDING, 1, true);

            machadometa.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02d1&lM&#fb03c2&lA&#fb05b4&lC&#fc06a6&lH&#fc0897&lA&#fc0989&lD&#fc0b7b&lO &#fc0d6c&lD&#fc0e5e&lO &#fc104f&lA&#fd1141&lM&#fd1333&lO&#fd1424&lR &#fd1616&l❤"));
            machadonatal.setItemMeta(machadometa);
            p.getInventory().addItem(machadonatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("machadosharp")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            machadosharpmeta.setLore(lores);

            machadosharpmeta.addEnchant(Enchantment.DURABILITY, 5, true);
            machadosharpmeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
            machadosharpmeta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
            machadosharpmeta.addEnchant(Enchantment.MENDING, 1, true);

            machadosharpmeta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02c9&lA&#fb05b2&lF&#fc079c&lR&#fc0a86&lO&#fc0c6f&lD&#fc0f59&lI&#fd1143&lT&#fd142c&lE &#fd1616&l❤"));
            machadosharpnatal.setItemMeta(machadosharpmeta);
            p.getInventory().addItem(machadosharpnatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("pa")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            pameta.setLore(lores);

            pameta.addEnchant(Enchantment.DURABILITY, 5, true);
            pameta.addEnchant(Enchantment.DIG_SPEED, 6, true);
            pameta.addEnchant(Enchantment.MENDING, 1, true);

            pameta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02c9&lP&#fb05b2&lÁ &#fc079c&lD&#fc0a86&lO &#fc0c6f&lA&#fc0f59&lM&#fd1143&lO&#fd142c&lR &#fd1616&l❤"));
            panatal.setItemMeta(pameta);
            p.getInventory().addItem(panatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("enxada")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            enxadameta.setLore(lores);

            enxadameta.addEnchant(Enchantment.DURABILITY, 5, true);
            enxadameta.addEnchant(Enchantment.DIG_SPEED, 6, true);
            enxadameta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
            enxadameta.addEnchant(Enchantment.MENDING, 1, true);

            enxadameta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02d0&lE&#fb03c0&lN&#fb05b1&lX&#fc07a1&lA&#fc0892&lD&#fc0a82&lA &#fc0c73&lD&#fc0e63&lO &#fc0f54&lA&#fd1144&lM&#fd1335&lO&#fd1425&lR &#fd1616&l❤"));
            enxadanatal.setItemMeta(enxadameta);
            p.getInventory().addItem(enxadanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("arco")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            arcometa.setLore(lores);

            arcometa.addEnchant(Enchantment.ARROW_DAMAGE, 6, true);
            arcometa.addEnchant(Enchantment.DURABILITY, 5, true);
            arcometa.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            arcometa.addEnchant(Enchantment.ARROW_FIRE, 1, true);
            arcometa.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
            arcometa.addEnchant(Enchantment.MENDING, 1, true);

            arcometa.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02cd&lA&#fb04ba&lR&#fc06a8&lC&#fc0896&lO &#fc0a84&lD&#fc0c71&lO &#fc0e5f&lA&#fc104d&lM&#fd123b&lO&#fd1428&lR &#fd1616&l❤"));
            arconatal.setItemMeta(arcometa);
            p.getInventory().addItem(arconatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("vara")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            varameta.setLore(lores);

            varameta.addEnchant(Enchantment.DURABILITY, 5, true);
            varameta.addEnchant(Enchantment.LUCK, 4, true);
            varameta.addEnchant(Enchantment.LURE, 4, true);
            varameta.addEnchant(Enchantment.MENDING, 1, true);

            varameta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02cd&lV&#fb04ba&lA&#fc06a8&lR&#fc0896&lA &#fc0a84&lD&#fc0c71&lO &#fc0e5f&lA&#fc104d&lM&#fd123b&lO&#fd1428&lR &#fd1616&l❤"));
            varanatal.setItemMeta(varameta);
            p.getInventory().addItem(varanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("besta")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            bestameta.setLore(lores);

            bestameta.addEnchant(Enchantment.DURABILITY, 5, true);
            bestameta.addEnchant(Enchantment.PIERCING, 4, true);
            bestameta.addEnchant(Enchantment.QUICK_CHARGE, 4, true);
            bestameta.addEnchant(Enchantment.MULTISHOT, 1, true);
            bestameta.addEnchant(Enchantment.MENDING, 1, true);

            bestameta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02ce&lB&#fb04be&lE&#fc06ad&lS&#fc079c&lT&#fc098b&lA &#fc0b7b&lD&#fc0d6a&lE &#fc0f59&lA&#fd1148&lM&#fd1238&lO&#fd1427&lR &#fd1616&l❤"));
            bestanatal.setItemMeta(bestameta);
            p.getInventory().addItem(bestanatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("tridente")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            tridentemeta.setLore(lores);

            tridentemeta.addEnchant(Enchantment.DURABILITY, 5, true);
            tridentemeta.addEnchant(Enchantment.CHANNELING, 1, true);
            tridentemeta.addEnchant(Enchantment.IMPALING, 5, true);
            tridentemeta.addEnchant(Enchantment.LOYALTY, 4, true);
            tridentemeta.addEnchant(Enchantment.MENDING, 1, true);

            tridentemeta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb01d2&lT&#fb03c4&lR&#fb04b7&lI&#fc06a9&lD&#fc079c&lE&#fc098f&lN&#fc0a81&lT&#fc0c74&lE &#fc0d66&lD&#fc0f59&lO &#fc104c&lA&#fd123e&lM&#fd1331&lO&#fd1523&lR &#fd1616&l❤"));
            tridentenatal.setItemMeta(tridentemeta);
            p.getInventory().addItem(tridentenatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        if (args[1].equalsIgnoreCase("elytra")) {
            List<String> lores = new ArrayList<>();
            lores.add("");
            lores.add(ColorTranslate.chatColors(" &eEDIÇÃO ESPECIAL:"));
            lores.add(ColorTranslate.chatColors(" &#fb00df&l❤ &#fb01d2&lD&#fb03c6&lI&#fb04b9&lA &#fc06ad&lD&#fc07a0&lO&#fc0894&lS &#fc0a87&lN&#fc0b7b&lA&#fc0c6e&lM&#fc0e61&lO&#fc0f55&lR&#fd1148&lA&#fd123c&lD&#fd132f&lO&#fd1523&lS &#fd1616&l❤"));
            lores.add(addLore(p.getName()));
            elytrameta.setLore(lores);

            elytrameta.addEnchant(Enchantment.DURABILITY, 6, true);
            elytrameta.addEnchant(Enchantment.MENDING, 1, true);

            elytrameta.setDisplayName(ColorTranslate.chatColors("&#fb00df&l❤ &#fb02d0&lA&#fb03c0&lS&#fb05b1&lA&#fc07a1&lS &#fc0892&lD&#fc0a82&lE &#fc0c73&lC&#fc0e63&lU&#fc0f54&lP&#fd1144&lI&#fd1335&lD&#fd1425&lO &#fd1616&l❤"));
            elytranatal.setItemMeta(elytrameta);
            p.getInventory().addItem(elytranatal);
            sender.sendMessage("§c[Namorados] §fItem dado com sucesso para o jogador " + p.getName());
            return false;
        }
        sender.sendMessage("§c[Namorados] §fItem não encontrado");
        return false;
    }
}

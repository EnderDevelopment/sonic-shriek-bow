package com.enderdevelopment.plugin;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("SonicShriekBow plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SonicShriekBow plugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("sonicshriekbow")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                giveSonicShriekBow(player);
                return true;
            } else {
                sender.sendMessage("This command can only be used by players.");
                return false;
            }
        }
        return false;
    }

    private void giveSonicShriekBow(Player player) {
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta meta = bow.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("Sonic Shriek Bow");
            bow.setItemMeta(meta);
        }
        bow.addUnsafeEnchantment(Enchantment.POWER, 8); // Power 8
        bow.addUnsafeEnchantment(Enchantment.UNBREAKING, 25); // Unbreaking 25
        bow.addUnsafeEnchantment(Enchantment.INFINITY, 1); // Infinity
        bow.addUnsafeEnchantment(Enchantment.FLAME, 1); // Flame
        player.getInventory().addItem(bow);
        player.sendMessage("You have been given a Sonic Shriek Bow!");
    }
}
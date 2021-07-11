package me.cosmic.superpickaxe;

import me.cosmic.superpickaxe.files.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("giveSuperPickaxe")) {
                if (sender.hasPermission("SuperPickaxe.give")) {
                    player.getInventory().addItem(ItemManager.SuperBreaker);
                }else{
                    player.sendMessage(Utils.chat("&cInvalid Permission"));
                }
            }
            if (command.getName().equalsIgnoreCase("giveShredder")) {
                if (sender.hasPermission("SuperPickaxe.Shredder.give")) {
                    player.getInventory().addItem(ItemManager.Shredder);
                }else{
                    player.sendMessage(Utils.chat("&cInvalid Permission"));
                }
            }
            if (command.getName().equalsIgnoreCase("giveShredderv2")) {
                if (sender.hasPermission("SuperPickaxe.Shredderv2.give")) {
                    player.getInventory().addItem(ItemManager.Shredderv2);
                }else{
                    player.sendMessage(Utils.chat("&cInvalid Permission"));
                }
            }
            if (command.getName().equalsIgnoreCase("SPReload")) {
                if (sender.hasPermission("SuperPickaxe.reload")) {
                    CustomConfig.reload();

                    sender.sendMessage(ChatColor.RED + "Plugin Reloading!");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sender.sendMessage(ChatColor.GREEN + "Reloading Complete, if you find an issue check console for a message!");
                }
            }
        }
        else{
            sender.sendMessage("no.");
        }
        return true;
    }

}

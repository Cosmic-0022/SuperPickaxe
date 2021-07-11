package me.cosmic.superpickaxe;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemManager {

    public static ItemStack SuperBreaker;
    public static ItemStack Shredder;
    public static ItemStack Shredderv2;


    public static void init() {

        createSuperBreakerPicakxe();
        createShredderPicakxe();
        createShredderv2Picakxe();
    }

    private static final void createSuperBreakerPicakxe() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat("&6Super Breaker"));
        List<String> lore = new ArrayList<>();
        lore.add(Utils.chat(""));
        lore.add(Utils.chat("&7Mine a radius of blocks!"));
        lore.add(Utils.chat(""));
        lore.add(Utils.chat("&7Radius: &a3x3 &6[1]"));
        lore.add(Utils.chat(""));
        lore.add(Utils.chat("&6&lLEGENDARY"));
        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        SuperBreaker = item;

    }
    private static final void createShredderPicakxe() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat("&6Shredder"));
        List<String> lore = new ArrayList<>();
        lore.add(Utils.chat(""));
        lore.add(Utils.chat("&7Mine a radius of blocks!"));
        lore.add(Utils.chat(""));
        lore.add(Utils.chat("&7Radius: &a5x5 &6[2]"));
        lore.add(Utils.chat(""));
        lore.add(Utils.chat("&6&lLEGENDARY"));
        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        Shredder = item;

    }
    private static final void createShredderv2Picakxe() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat("&dShredder v2"));
        List<String> lore = new ArrayList<>();
        lore.add(Utils.chat(""));
        lore.add(Utils.chat("&7Mine a radius of blocks!"));
        lore.add(Utils.chat(""));
        lore.add(Utils.chat("&7Radius: &a7x7 &6[3]"));
        lore.add(Utils.chat(""));
        lore.add(Utils.chat("&6&lMYTHIC"));
        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        Shredderv2 = item;

    }
}

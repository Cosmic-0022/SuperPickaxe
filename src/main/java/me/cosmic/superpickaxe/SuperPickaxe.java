package me.cosmic.superpickaxe;

import me.cosmic.superpickaxe.files.CustomConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class SuperPickaxe extends JavaPlugin {
    public static SuperPickaxe plugin;

    @Override
    public void onEnable() {
        plugin = this;
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new events(), this);
        Commands commands = new Commands();
        getCommand("giveSuperPickaxe").setExecutor(commands);
        getCommand("giveShredder").setExecutor(commands);
        getCommand("giveShredderv2").setExecutor(commands);
        getCommand("SPReload").setExecutor(commands);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        CustomConfig.setup();
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.get().addDefault("Particle", "default");
        CustomConfig.get().addDefault("ParticleCount", "5");
        CustomConfig.save();

    }

    @Override
    public void onDisable() {
        plugin = null;
        // Plugin shutdown logic
    }
}

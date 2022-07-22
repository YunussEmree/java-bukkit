package provanasservices;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Firstjoinmessager extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().log(Level.WARNING, ChatColor.GREEN + "Plugin Enabled!");
        this.getServer().getPluginManager().registerEvents(new Events(this), this);

        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().log(Level.WARNING, ChatColor.GOLD + "Plugin Disabled!");
    }
}

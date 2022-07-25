package provanasservices.grapplinghook;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Main extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().log(Level.WARNING, "Plugin enabled");

        this.getCommand("getgrapplinghook").setExecutor(new Commands());
        this.getCommand("grapplinghookreload").setExecutor(new Commands());

        this.getServer().getPluginManager().registerEvents(new Events(this), this);

        this.saveDefaultConfig();

        ItemManager.init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().log(Level.WARNING, "Plugin disabled");
    }
}

package ProvanasServices.fcommand;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().log(Level.WARNING, "Plugin enabled!");

        this.getServer().getPluginManager().registerEvents(new Events(this), this);


        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        this.getLogger().log(Level.WARNING, "Plugin disabled!");
        // Plugin shutdown logic
    }
}

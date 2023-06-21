package blestit.provanasplayerrespawn;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class ProvanasPlayerRespawn extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().log(Level.INFO, "Eklenti Aktif!");

        this.getServer().getPluginManager().registerEvents(new Eventhandler(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, "Eklenti İnaktif!");
    }
}

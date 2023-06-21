package blestit.giveaway;

import org.bukkit.plugin.java.JavaPlugin;

public final class Giveaway extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Eklenti aktif!");
        this.getCommand("startgiveaway").setExecutor(new commandhandler());
        this.getServer().getPluginManager().registerEvents(new eventhandler(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

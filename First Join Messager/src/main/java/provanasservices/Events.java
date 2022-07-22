package provanasservices;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class Events implements Listener {

    Firstjoinmessager plugin;

    public Events(Firstjoinmessager plugin) {
        this.plugin = plugin;
    }

    public void selectjoinmessage(String playernick, PlayerJoinEvent event) {
        Boolean enabled = this.plugin.getConfig().getBoolean("custommessager.joinmessages.enabled");
        if (enabled == true) {
            Boolean onlyfirstjoinsettings = this.plugin.getConfig().getBoolean("custommessager.joinmessages.onlyfirstjoin");
            if (onlyfirstjoinsettings == true) {
                if (!event.getPlayer().hasPlayedBefore()) {
                    List<String> messages = this.plugin.getConfig().getStringList("custommessager.joinmessages.messages");

                    int randomnumber = (int) Math.floor(Math.random() * messages.size());
                    String msg = messages.get(randomnumber);
                    msg.replace("%player%", playernick);
                    Bukkit.broadcastMessage(msg);
                }
            }
            if (onlyfirstjoinsettings == false) {
                List<String> messages = this.plugin.getConfig().getStringList("custommessager.joinmessages.messages");

                int randomnumber = (int) Math.floor(Math.random() * messages.size());
                String msg = messages.get(randomnumber);
                msg.replace("%player%", playernick);
                msg.replace("&", "§");
                //Bukkit.broadcastMessage(msg);
                event.setJoinMessage(msg);
            }
        }
    }

    public void selectquitmessage(String playernick, PlayerQuitEvent event){
        Boolean enabled = this.plugin.getConfig().getBoolean("custommessager.quitmessages.enabled");
        if(enabled == true) {
            List<String> messages = this.plugin.getConfig().getStringList("custommessager.quitmessages.messages");

            int randomnumber = (int) Math.floor(Math.random() * messages.size());
            String msg = messages.get(randomnumber);
            msg.replace("%player%", playernick);
            msg.replace("&", "§");
            event.setQuitMessage(msg);
            //Bukkit.broadcastMessage(msg);
        }
    }


    @EventHandler
    public void onjoin(PlayerJoinEvent event){
        String playernick = event.getPlayer().getName();

        new BukkitRunnable() {

            public void run() {

                selectjoinmessage(playernick, event);

                cancel();
            }
        }.runTaskTimer(plugin, 40, 1L);

    }

    @EventHandler
    public void onleft(PlayerQuitEvent event){
        String playernick = event.getPlayer().getName();

        selectquitmessage(playernick, event);
    }

}

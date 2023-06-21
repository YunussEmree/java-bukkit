package blestit.provanasplayerrespawn;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Eventhandler implements Listener {
    ProvanasPlayerRespawn plugin;

    public Eventhandler(ProvanasPlayerRespawn plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void onPlayerDeath(EntityDamageByEntityEvent event) {

        Player damagedplayer = null;

        if(event.getEntity() instanceof Player) {
            damagedplayer = (Player) event.getEntity();
        }

        if(damagedplayer != null && (damagedplayer.getHealth() - event.getFinalDamage() <= 0)){
            event.setCancelled(true);
            damagedplayer.setHealth(damagedplayer.getMaxHealth());

            World world = damagedplayer.getWorld();
            Location loc = new Location(world, -15.5, 76.0, 61.5);


            damagedplayer.teleport(loc);
        }
    }
}

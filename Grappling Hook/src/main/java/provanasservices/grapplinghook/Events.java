package provanasservices.grapplinghook;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.HashMap;

public class Events implements Listener {


        Main plugin;

        public Events(Main plugin) {
            this.plugin = plugin;
        }


        public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

        @EventHandler
        public void onFish(PlayerFishEvent event) {


            String prefix = plugin.getConfig().getString("grapplinghook.prefix");
            String prefixyeni = prefix.replace("&", "§");
            String cooldowntext = plugin.getConfig().getString("grapplinghook.cooldowntext");
            String cooldowntextyeni = cooldowntext.replace("&", "§");
            String nopermtext = plugin.getConfig().getString("grapplinghook.nopermtext");
            String nopermtextyeni = nopermtext.replace("&", "§");
            int airvelocity = plugin.getConfig().getInt("grapplinghook.velocity.air.onairvelocity");
            int airyvelocity = plugin.getConfig().getInt("grapplinghook.velocity.air.onairsety");
            int cooldownTime = plugin.getConfig().getInt("grapplinghook.CooldownTime");
            double landvelocity = plugin.getConfig().getDouble("grapplinghook.velocity.land.onlandvelocity");
            int landvelocityx = plugin.getConfig().getInt("grapplinghook.velocity.land.onlandchangeadd.x");
            double landvelocityy = plugin.getConfig().getDouble("grapplinghook.velocity.land.onlandchangeadd.y");
            int landvelocityz = plugin.getConfig().getInt("grapplinghook.velocity.land.onlandchangeadd.z");


            Player player = event.getPlayer();

            if (player.hasPermission("use.hook")) {

            if (player.getInventory().getItemInMainHand().getItemMeta().getLore() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§7Right click and fly!")) {

                if (event.getState().equals(PlayerFishEvent.State.REEL_IN)) {

                    if (cooldowns.containsKey(player.getName())) {
                        long secondsLeft = ((cooldowns.get(player.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
                        if (secondsLeft > 0) {
                            // Still cooling down
                            String cooldowntextyeniyeni = cooldowntextyeni.replace("%timer%", String.valueOf(secondsLeft));
                            player.sendMessage(prefixyeni + cooldowntextyeniyeni);
                            return;
                        }
                    }
                                cooldowns.put(player.getName(), System.currentTimeMillis());
                                Location playerLocation = player.getLocation();
                                player.setVelocity(playerLocation.getDirection().multiply(airvelocity).setY(airyvelocity));
                        }


                if (event.getState().equals(PlayerFishEvent.State.IN_GROUND)) {

                    if (cooldowns.containsKey(player.getName())) {
                        long secondsLeft = ((cooldowns.get(player.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
                        if (secondsLeft > 0) {
                            // Still cooling down
                            String cooldowntextyeniyeni = cooldowntextyeni.replace("%timer%", String.valueOf(secondsLeft));
                            player.sendMessage(prefixyeni + cooldowntextyeniyeni);
                            return;
                        }
                    }


                    cooldowns.put(player.getName(), System.currentTimeMillis());

                    Location playerLocation = player.getLocation();
                    Location hookLocation = event.getHook().getLocation();
                    Location change = hookLocation.subtract(playerLocation);
                    Location newlocation = change.add(landvelocityx, landvelocityy, landvelocityz);
                    player.setVelocity(newlocation.toVector().multiply(landvelocity));
                }
            }
                } else {
                player.sendMessage(prefixyeni + nopermtextyeni);
            }
        }
}

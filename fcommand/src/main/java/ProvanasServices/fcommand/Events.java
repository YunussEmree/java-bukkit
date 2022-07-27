package ProvanasServices.fcommand;

import org.bukkit.*;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class Events implements Listener {


    public static HashMap<String, Long> cooldowns = new HashMap<String, Long>();
    Main plugin;

    public Events(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onitemswap(PlayerSwapHandItemsEvent event) {

        int cooldown = plugin.getConfig().getInt("fcommand.cooldown");
        List<Material> banitem = (List<Material>) plugin.getConfig().getList("fcommand.banitem");

        int cooldownTime = cooldown;
        Player player = event.getPlayer();
        for(int i = 0; i<banitem.size(); i++) {
            if ((player.getInventory().getItemInMainHand().getType() == banitem.get(i) || player.getInventory().getItemInOffHand().getType() == banitem.get(i))) {

                return;
            }
        }
        if (!player.hasPermission("fcommand.use")) {
                return;
        }

                if (cooldowns.containsKey(player.getName())) {
                    int secondsLeft = (int) (((cooldowns.get(player.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000));
                    if (secondsLeft > 0) {

                        String cooldownmessage = plugin.getConfig().getString("fcommand.cooldownmessage");
                        String cooldownmessageyeni = cooldownmessage.replace("%timer%", String.valueOf(secondsLeft));
                        String cooldownmessageyeniyeni = cooldownmessageyeni.replace("&", "§");
                        // Still cooling down
                        player.sendMessage(cooldownmessageyeniyeni);

                        return;
                    }
                }

                String command = plugin.getConfig().getString("fcommand.command");
                String commandyeni = command.replace("%player%", player.getName());

                event.setCancelled(true);
                ConsoleCommandSender cs = Bukkit.getConsoleSender();
                Bukkit.dispatchCommand(cs, commandyeni);
                cooldowns.put(player.getName(), System.currentTimeMillis());
    }

}

package civciv.xraycheck;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;
import java.util.List;

public class Events implements Listener {

    XrayCheck plugin;

    public Events(XrayCheck plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        List<String> blockad = plugin.getConfig().getStringList(("xraycheck.blocks"));

        for(int i = 0; i<blockad.size(); i++) {
            if (event.getBlock().getType().toString(). equalsIgnoreCase(String.valueOf(blockad.get(i)))) {
                String playername = event.getPlayer().getName();
                String blockadi = String.valueOf(event.getBlock().getType());
                Bukkit.broadcast("§c" + playername + "§e, break a§c " + blockadi + "§e.", "xray.check");
            }
        }
    }
}
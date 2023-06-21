package blestit.giveaway;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class eventhandler implements Listener {
    Giveaway plugin;

    public eventhandler(Giveaway plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public static void StartGiveaway() {

        //ArrayList<Player> list = new ArrayList<Player>(Bukkit.getOnlinePlayers());
        ArrayList<String> list = new ArrayList<String>();
        for(Player p : Bukkit.getOnlinePlayers()){
            if(p.hasPermission("avalon.giveaway")){
                list.add(p.getDisplayName());
            }
        }

        int r = (int) Math.floor(list.size()*Math.random());

        String sonucplayer = list.get(r);
        Bukkit.broadcast("Cekilise Katilanlar" + ChatColor.GOLD + "(sadece adminler gorebilir)" + ChatColor.RESET + ": "+ list, "avalon.op");
        Bukkit.broadcastMessage(ChatColor.RED + "--------------------------------" + "\n\n" + ChatColor.DARK_RED + "Cekilis Kazanani: "+ sonucplayer + ChatColor.RED + "\n\n" + "--------------------------------");

        //Bukkit.broadcastMessage(ChatColor.RED + "--------------------------------" + "\n\n" + ChatColor.DARK_RED + "Cekilis Kazanani: "+ sonucplayername + ChatColor.RED + "\n\n" + "--------------------------------");
        list.clear();
    }
}

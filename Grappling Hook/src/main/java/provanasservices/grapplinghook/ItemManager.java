package provanasservices.grapplinghook;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack GrapplingHook;
    public static void init() {
        createGrapplingHook();
    }


    private static void createGrapplingHook(){
        ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Grappling Hook");
        List<String> lore = new ArrayList<>();
        lore.add("§7Right click and fly!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        GrapplingHook = item;
    }
}

package civciv.xraycheck;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class XrayCheck extends JavaPlugin {


    @Override
    public void onEnable() {
        System.out.println("§aEklenti Aktif!");
        this.getServer().getPluginManager().registerEvents(new Events(this), this);

        this.saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}

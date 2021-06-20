package me.tim.minecrafttopi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftToPi extends JavaPlugin {

    private static MinecraftToPi instance;

    @Override
    public void onEnable() {

        instance = this;
        Bukkit.getPluginManager().registerEvents(new ButtonListener(), this);

        saveDefaultConfig();
        Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&bStarted successfully"));
    }

    public static MinecraftToPi getInstance()  {
        return instance;
    }
}

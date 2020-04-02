package me.noodles.norain;

import org.bukkit.plugin.java.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.*;

public class MainNoRain extends JavaPlugin implements Listener
{
    public static MainNoRain plugin;
    private UpdateChecker checker;
    
    public void onEnable() {
        MainNoRain.plugin = this;
        final PluginDescriptionFile VarUtilType = this.getDescription();
        this.getLogger().info("NoWeather V" + VarUtilType.getVersion() + " starting...");
        this.saveDefaultConfig();
        this.reloadConfig();
        registerEvents((Plugin)this, new Events());
        registerEvents(this, this);
        this.getLogger().info("NoWeather V" + VarUtilType.getVersion() + " started!");
        this.setEnabled(true);
        this.getLogger().info("NoWeather V" + VarUtilType.getVersion() + " checking for updates...");
        this.checker = new UpdateChecker(this);
        if (this.checker.isConnected()) {
            if (this.checker.hasUpdate()) {
                getServer().getConsoleSender().sendMessage("------------------------");
                getServer().getConsoleSender().sendMessage("No Weather is outdated!");
                getServer().getConsoleSender().sendMessage("Newest version: " + this.checker.getLatestVersion());
                getServer().getConsoleSender().sendMessage("Your version: " + MainNoRain.plugin.getDescription().getVersion());
                getServer().getConsoleSender().sendMessage("Please Update Here: https://www.spigotmc.org/resources/46407");
                getServer().getConsoleSender().sendMessage("------------------------");
            }
            else {
                getServer().getConsoleSender().sendMessage("------------------------");
                getServer().getConsoleSender().sendMessage("NoWeather is up to date!");
                getServer().getConsoleSender().sendMessage("------------------------");            }
        }
    }
    
    public static void registerEvents(final Plugin plugin, final Listener... listeners) {
        for (final Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes"})
	public static MainNoRain getPlugin() {
        return (MainNoRain)getPlugin((Class)MainNoRain.class);
    }
    
}

package me.pulseneon.bettervanillaplugin.modules.levellimit;

import me.pulseneon.bettervanillaplugin.modules.levellimit.listeners.OnPlayerExpChange;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {
    public static void registerListeners(Plugin plugin){
        OnPlayerExpChange onPlayerExpChange = new OnPlayerExpChange();

        PluginManager pluginManager = plugin.getServer().getPluginManager();
        pluginManager.registerEvents(onPlayerExpChange, plugin);
    }
}

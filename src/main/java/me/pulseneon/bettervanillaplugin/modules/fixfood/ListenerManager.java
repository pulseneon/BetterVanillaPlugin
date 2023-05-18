package me.pulseneon.bettervanillaplugin.modules.fixfood;

import me.pulseneon.bettervanillaplugin.modules.fixfood.listeners.OnPlayerEatListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {
    public static void registerListeners(Plugin plugin){
        OnPlayerEatListener playerEatListener = new OnPlayerEatListener();

        PluginManager pluginManager = plugin.getServer().getPluginManager();
        pluginManager.registerEvents(playerEatListener, plugin);
    }
}

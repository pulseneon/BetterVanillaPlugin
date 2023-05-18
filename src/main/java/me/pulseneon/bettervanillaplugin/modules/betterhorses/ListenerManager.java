package me.pulseneon.bettervanillaplugin.modules.betterhorses;

import me.pulseneon.bettervanillaplugin.modules.betterhorses.listeners.OnEntityBreedEvent;
import me.pulseneon.bettervanillaplugin.modules.betterhorses.listeners.OnPlayerInteractEntity;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {
    public static void registerListeners(Plugin plugin){
        OnEntityBreedEvent entityBreedEvent = new OnEntityBreedEvent();
        OnPlayerInteractEntity playerInteractEntity = new OnPlayerInteractEntity();

        PluginManager pluginManager = plugin.getServer().getPluginManager();

        pluginManager.registerEvents(entityBreedEvent, plugin);
        pluginManager.registerEvents(playerInteractEntity, plugin);
    }
}

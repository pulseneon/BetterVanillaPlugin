package me.pulseneon.bettervanillaplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class BetterVanillaPlugin extends JavaPlugin {
    public static BetterVanillaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        me.pulseneon.bettervanillaplugin.modules.fixfood.ListenerManager.registerListeners(this);
        me.pulseneon.bettervanillaplugin.modules.betterhorses.ListenerManager.registerListeners(this);
        me.pulseneon.bettervanillaplugin.modules.levellimit.ListenerManager.registerListeners(this);

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

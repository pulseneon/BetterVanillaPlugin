package me.pulseneon.bettervanillaplugin.modules.levellimit.listeners;

import me.pulseneon.bettervanillaplugin.BetterVanillaPlugin;
import me.pulseneon.bettervanillaplugin.modules.levellimit.utils.Utils;
import me.pulseneon.bettervanillaplugin.utils.NotificationUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

/**
 * Класс-листенер, который при достижение определенного уровня, прекращает его увеличивать
 */
public class OnPlayerExpChange implements Listener {
    @EventHandler
    public void onPlayerExpChange(PlayerExpChangeEvent event) {
        boolean onEnable = BetterVanillaPlugin.instance.getConfig().getBoolean("levellimit.enable");
        if (!onEnable)
            return;

        Player player = event.getPlayer();
        int maxLevel = BetterVanillaPlugin.instance.getConfig().getInt("levellimit.max_level");
        int currentLevel = player.getLevel();
        int newLevel = currentLevel + event.getAmount();

        if (player.getLevel() >= maxLevel || newLevel > maxLevel) {
            event.setAmount(0);
            player.setLevel(maxLevel);

            // вывод акшен бара раз в n-раз
            if(Utils.isChanceSuccessful())
                NotificationUtils.sendActionBar(player, "Вы достигли максимального уровня опыта.");
        }
    }
}

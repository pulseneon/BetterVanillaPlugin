package me.pulseneon.bettervanillaplugin.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class NotificationUtils {
    public static void sendActionBar(Player player, String text){
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(text));
        player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_HIT, 10, 1);
    }
}

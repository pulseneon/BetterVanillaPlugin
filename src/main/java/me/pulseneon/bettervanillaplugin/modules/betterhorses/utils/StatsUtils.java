package me.pulseneon.bettervanillaplugin.modules.betterhorses.utils;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Objects;

public class StatsUtils {
    /**
     * Метод, который записывает основные параметры лошади в BookMeta
     *
     * @param bookMeta Изначальные параметры BookMeta
     * @param horse Лошадь, чьи параметры записываем
     * @return BookMeta записанной книги
     */
    public static BookMeta writeHorseStatsToBook(BookMeta bookMeta, Horse horse){

        StringBuilder horseStats = new StringBuilder();
        double speed = Objects.requireNonNull(horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).getValue();

        horseStats.append(String.format("Кличка лошади: %s\n", horse.getName()));
        horseStats.append(String.format("Скорость: %.2f\n", speed));
        horseStats.append(String.format("Прыжок: %.2f\n", horse.getJumpStrength()));
        horseStats.append(String.format("Здоровье: %d\n", (int)horse.getHealth()));

        bookMeta.addPage(horseStats.toString());
        return bookMeta;
    }

    /**
     * Метод, который подписывает (завершает) книгу с параметрами лошади
     *
     * @param bookMeta Изначальные параметры BookMeta
     * @param horse Лошадь
     * @param player Владелец лошади (подписывающий)
     * @return BookMeta подписанной книги
     */
    public static BookMeta signHorseStatsBook(BookMeta bookMeta, Horse horse, Player player){
        bookMeta.setGeneration(BookMeta.Generation.TATTERED);
        bookMeta.setAuthor(player.getDisplayName());

        if (!horse.getName().equals(""))
            bookMeta.setTitle(horse.getName());
        else
            bookMeta.setTitle("Horse book");

        return bookMeta;
    }
}

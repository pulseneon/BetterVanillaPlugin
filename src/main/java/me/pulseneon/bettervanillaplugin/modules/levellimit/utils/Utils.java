package me.pulseneon.bettervanillaplugin.modules.levellimit.utils;

public class Utils {
    /**
     * Метод, расчета шанса 1 к 5 на показ уведомления игроку
     * @return true/false
     */
    public static boolean isChanceSuccessful(){
        int chance = 5;

        return (int) (Math.random() * chance) + 1 == 1;
    }
}

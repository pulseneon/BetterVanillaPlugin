package me.pulseneon.bettervanillaplugin.modules.betterhorses.utils;

import me.pulseneon.bettervanillaplugin.modules.betterhorses.enums.DominantGenes;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Horse;

import java.util.Objects;

public class GeneUtils {
    static final int maxHealth = 30;
    static final double maxJump = 1;
    static final double maxSpeed = 0.3375;

    /**
     * Метод, который находит параметр лошади, который максимально приближен к идеальному
     *
     * @param horse Лошадь, у которой нужно выделить параметр
     * @return Enum DominantGenes параметра
     */
    public static DominantGenes findDominantGene(Horse horse) {
        double healthDiff = Math.abs(maxHealth - horse.getHealth()) / maxHealth;
        double speedDiff = Math.abs(maxSpeed - Objects.requireNonNull(horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).getValue()) / maxSpeed;
        double jumpDiff = Math.abs(maxJump - horse.getJumpStrength()) / maxJump;

        if (healthDiff <= speedDiff && healthDiff <= jumpDiff) {
            return DominantGenes.hp;
        } else if (speedDiff <= healthDiff && speedDiff <= jumpDiff) {
            return DominantGenes.speed;
        } else {
            return DominantGenes.jump;
        }
    }

    /**
     * Метод, который передает наилучший параметр одной лошади - другой
     *
     * @param son Лошадь, который передаем параметр
     * @param parent Лошадь, чей параметр мы передаем
     * @param gen Enum параметра, который изменяем
     */
    public static void injectDominantGene(Horse son, Horse parent, DominantGenes gen){
        switch (gen){
            case hp:
                son.setMaxHealth(parent.getHealth());
                break;
            case jump:
                son.setJumpStrength(parent.getJumpStrength());
                break;
            case speed:
                double parentSpeed = parent.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue();
                Objects.requireNonNull(son.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(parentSpeed);
                break;
        }
    }
}

package me.pulseneon.bettervanillaplugin.modules.fixfood.models;

import org.bukkit.Material;

public class Food {
    private final Material material;
    private int protein;
    private int carbohydrates;
    private int fat;

    public Food(Material material, int protein, int carbohydrates, int fat) {
        this.material = material;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
    }

    public Material getMaterial() {
        return material;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

}

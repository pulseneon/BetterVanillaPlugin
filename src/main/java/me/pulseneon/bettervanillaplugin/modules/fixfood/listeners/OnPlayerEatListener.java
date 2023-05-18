package me.pulseneon.bettervanillaplugin.modules.fixfood.listeners;

import me.pulseneon.bettervanillaplugin.modules.fixfood.models.Food;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import java.util.Collections;
import java.util.List;

public class OnPlayerEatListener implements Listener {
    List<Food> foodList = Collections.singletonList(
            new Food(Material.APPLE, 1, 1, 1)
    );

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        //Database db = new Database();
        player.sendMessage("onPlayerEat eat from fixfood event");
    }

     /*
        for (Food food in foodList:
             ) {

        }


        if (event.getItem().getType() == Material.APPLE) {
            //если вещь, которую съел игрок — яблоко,
            //то добавляем к сытости какое-то значение
            // и сообщаем игроку новый уровень сытости
            int newHunger = player.getFoodLevel() + 4;
            player.setFoodLevel(newHunger);
            player.sendMessage("Ваш уровень сытости теперь равен " + newHunger);
        } else if (event.getItem().getType() == Material.GOLDEN_CARROT) {
            //аналогичные действия при съедении золотой морковки
            int newHunger = player.getFoodLevel() + 6;
            player.setFoodLevel(newHunger);
            player.sendMessage("Ваш уровень сытости теперь равен " + newHunger);
        }*/
}

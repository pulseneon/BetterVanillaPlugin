package me.pulseneon.bettervanillaplugin.modules.betterhorses.listeners;

import me.pulseneon.bettervanillaplugin.BetterVanillaPlugin;
import me.pulseneon.bettervanillaplugin.modules.betterhorses.utils.StatsUtils;
import me.pulseneon.bettervanillaplugin.utils.NotificationUtils;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

/**
 * Класс-листенер нажатия шифт + ПКМ по лошади с книгой и пером в руке,
 * для записи её параметров в эту книгу
 */
public class OnPlayerInteractEntity implements Listener {
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Horse)) {
            return;
        }

        boolean onEnable = BetterVanillaPlugin.instance.getConfig().getBoolean("betterhorses.enable");
        if (!onEnable)
            return;

        Player player = event.getPlayer();

        /* проверка на событие записи книги игроком по наличию книги в руке*/
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.getType() == Material.WRITABLE_BOOK){
            onPlayerWriteHorseBook(event);
            return;
        }

        /* проверка на событие второго пассажира на лошади по клику */
        Horse horse = (Horse) event.getRightClicked();
        if (horse.getPassengers().size() == 1){
            onPlayerSecondPassenger(event);
            return;
        }
    }

    private void onPlayerWriteHorseBook(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();

        if (player.isSneaking()) {
            Horse horse = (Horse) event.getRightClicked();
            if (horse.isTamed() && horse.getOwner().equals(player)) {
                ItemStack item = player.getInventory().getItemInMainHand();
                if (item.getType() == Material.WRITABLE_BOOK) {
                    ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                    BookMeta bookMeta = (BookMeta) book.getItemMeta();

                    bookMeta = StatsUtils.writeHorseStatsToBook(bookMeta, horse);
                    book.setItemMeta(StatsUtils.signHorseStatsBook(bookMeta, horse, player));

                    if (player.getItemInHand().getType() == Material.WRITABLE_BOOK) {
                        player.setItemInHand(book);
                        NotificationUtils.sendActionBar(player, "Информация о лошади записана");
                    }
                }
            }
        }
    }

    private void onPlayerSecondPassenger(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Лошадь занята");
    }
}

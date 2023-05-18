package me.pulseneon.bettervanillaplugin.modules.betterhorses.listeners;

import me.pulseneon.bettervanillaplugin.modules.betterhorses.utils.GeneUtils;
import me.pulseneon.bettervanillaplugin.modules.betterhorses.enums.DominantGenes;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

/**
 * Класс-листенер, который при размножении двух лошадей наследует гены родителей ребенку
 */
public class OnEntityBreedEvent implements Listener {
    static final int loveModeTicksTime = 6000;

    @EventHandler
    public void onEntityBreedEvent(EntityBreedEvent event) {
        if (!(event.getFather() instanceof Horse) || !(event.getMother() instanceof Horse))
            return;

        Horse father = (Horse) event.getFather();
        Horse mother = (Horse) event.getMother();

        DominantGenes fatherGen = GeneUtils.findDominantGene(father);
        DominantGenes motherGen = GeneUtils.findDominantGene(mother);

        /* запрещаем родителям иметь ребенка в течении 5 минут и отключаем желание размножаться */

        father.setBreed(false);
        mother.setBreed(false);
        father.setLoveModeTicks(loveModeTicksTime);
        mother.setLoveModeTicks(loveModeTicksTime);

        /* создаем нового ребенка */
        Horse child = (Horse) father.getWorld().spawnEntity(father.getLocation(), EntityType.HORSE);

        GeneUtils.injectDominantGene(child, mother, motherGen);
        GeneUtils.injectDominantGene(child, father, fatherGen);

        child.setBaby();

        event.setCancelled(true);
    }
}

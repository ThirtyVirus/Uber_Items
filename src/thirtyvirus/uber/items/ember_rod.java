package thirtyvirus.uber.items;

import java.util.List;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import org.bukkit.util.Vector;
import thirtyvirus.uber.UberItem;
import thirtyvirus.uber.UberItems;
import thirtyvirus.uber.helpers.UberAbility;
import thirtyvirus.uber.helpers.UberRarity;
import thirtyvirus.uber.helpers.Utilities;

// a template class that can be copy - pasted and renamed when making new Uber Items
public class ember_rod extends UberItem{

    public ember_rod(int id, UberRarity rarity, String name, Material material, boolean stackable, boolean oneTimeUse, boolean hasActiveEffect, List<UberAbility> abilities) {
        super(id, rarity, name, material, stackable, oneTimeUse, hasActiveEffect, abilities);
    }
    public void onItemStackCreate(ItemStack item) { }
    public void getSpecificLorePrefix(List<String> lore, ItemStack item) { }
    public void getSpecificLoreSuffix(List<String> lore, ItemStack item) { }

    public void leftClickAirAction(Player player, ItemStack item) { }
    public void leftClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { }
    public void rightClickAirAction(Player player, ItemStack item) {

        // enforce the 30 second cooldown of the fireball ability
        if (!Utilities.enforceCooldown(player, "fireball", 30, item, true)) return;

        // shoot 3 fireballs
        int amount = 3; // minimum 1
        shootFireBall(player);
        for (int counter = 1; counter < amount; counter++) {
            Utilities.scheduleTask(new Runnable() { public void run() { shootFireBall(player); } }, 10 * counter);
        }

        onItemUse(player, item); // confirm that the item's ability has been successfully used

    }
    public void rightClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) {
        rightClickAirAction(player, item);
    }
    public void shiftLeftClickAirAction(Player player, ItemStack item) { }
    public void shiftLeftClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { }
    public void shiftRightClickAirAction(Player player, ItemStack item) { }
    public void shiftRightClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { }
    public void middleClickAction(Player player, ItemStack item) { }
    public void hitEntityAction(Player player, EntityDamageByEntityEvent event, Entity target, ItemStack item) { }
    public void breakBlockAction(Player player, BlockBreakEvent event, Block block, ItemStack item) { }
    public void clickedInInventoryAction(Player player, InventoryClickEvent event) { }
    public void activeEffect(Player player, ItemStack item) { }

    public void shootFireBall(Player player) {
        Fireball thrown = player.launchProjectile(Fireball.class);
        Vector v = player.getEyeLocation().getDirection().multiply(2.0);
        thrown.setVelocity(v);
        thrown.setYield(5);

        thrown.setCustomName("UberFireBall");
    }
}
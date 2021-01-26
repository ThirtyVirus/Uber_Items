package thirtyvirus.uber.items;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import thirtyvirus.uber.UberItems;
import thirtyvirus.uber.UberItem;
import thirtyvirus.uber.helpers.UberAbility;
import thirtyvirus.uber.helpers.UberRarity;
import thirtyvirus.uber.helpers.Utilities;

public class lunch_box extends UberItem {

	public lunch_box(int id, UberRarity rarity, String name, Material material, boolean stackable, boolean oneTimeUse, boolean hasActiveEffect, List<UberAbility> abilities) {
		super(id, rarity, name, material, stackable, oneTimeUse, hasActiveEffect, abilities);
	}
	public void onItemStackCreate(ItemStack item) { }
	public void getSpecificLorePrefix(List<String> lore, ItemStack item) {
		lore.add(ChatColor.GREEN + "Food: " + ChatColor.GRAY + Utilities.getIntFromItem(item, "food"));
		lore.add(ChatColor.GREEN + "Saturation: " + ChatColor.GRAY + Utilities.getIntFromItem(item, "saturation"));
	}
	public void getSpecificLoreSuffix(List<String> lore, ItemStack item) { }

	public void leftClickAirAction(Player player, ItemStack item) { }
	public void leftClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { }
	public void rightClickAirAction(Player player, ItemStack item) { }
	public void rightClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { }
	public void shiftLeftClickAirAction(Player player, ItemStack item) { }
	public void shiftLeftClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { }
	public void shiftRightClickAirAction(Player player, ItemStack item) { }
	public void shiftRightClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) { }
	public void middleClickAction(Player player, ItemStack item) { }
	public void hitEntityAction(Player player, EntityDamageByEntityEvent event, Entity target, ItemStack item) { }
	public void breakBlockAction(Player player, BlockBreakEvent event, Block block, ItemStack item) { }

	// click food items onto the lunch box in your inventory to insert food
	public void clickedInInventoryAction(Player player, InventoryClickEvent event) {

		// verify that the item is compatible with the lunchbox
		ItemStack item = event.getWhoClicked().getItemOnCursor();
		ItemStack uber = event.getCurrentItem();
		if (!(item.getType().isEdible() || item.getType() == Material.MELON)) return;

		// get the current saturation from the lunch box
		int saturation = Utilities.getIntFromItem(uber, "saturation");
		int food = Utilities.getIntFromItem(uber, "food");

		// add the appropriate amount of saturation and food to the total
		food += getFood(item.getType(), false) * item.getAmount();
		saturation += getFood(item.getType(), true) * item.getAmount();

		// save the new saturation and food amounts in the item, update lore
		player.playSound(player.getLocation(), Sound.ENTITY_SHULKER_CLOSE, 1, 1);
		Utilities.storeIntInItem(uber, saturation, "saturation");
		Utilities.storeIntInItem(uber, food, "food");
		updateLore(uber);

		// delete the item being clicked onto the Uber Item
		event.getWhoClicked().setItemOnCursor(null);
		event.setCancelled(true);
	}

	// get the food and saturation value of a food item
	public int getFood(Material material, boolean saturation) {
		switch (material) {
			case APPLE:
			case CHORUS_FRUIT: if (saturation) return 2; else return 4;
			case BAKED_POTATO:
			case BREAD:
			case COOKED_COD:
			case COOKED_RABBIT: if (saturation) return 6; else return 5;
			case BEETROOT:
			case DRIED_KELP:
			case POTATO:
			case TROPICAL_FISH: return 1;
			case BEETROOT_SOUP:
			case COOKED_CHICKEN:
			case MUSHROOM_STEW:
			case SUSPICIOUS_STEW: if (saturation) return 7; else return 6;
			case CAKE: if (saturation) return 3; else return 14;
			case CARROT: if (saturation) return 4; else return 3;
			case COOKED_MUTTON:
			case COOKED_SALMON: if (saturation) return 10; else return 6;
			case COOKED_PORKCHOP:
			case COOKED_BEEF: if (saturation) return 13; else return 8;
			case COOKIE:
			case MELON_SLICE:
			case POISONOUS_POTATO:
			case MUTTON:
			case COD:
			case CHICKEN:
			case SALMON:
			case SWEET_BERRIES: if (saturation) return 1; else return 2;
			case ENCHANTED_GOLDEN_APPLE:
			case GOLDEN_APPLE: if (saturation) return 10; else return 4;
			case GOLDEN_CARROT: if (saturation) return 15; else return 6;
			case HONEY_BOTTLE: if (saturation) return 2; else return 6;
			case PUFFERFISH: if (saturation) return 0; else return 1;
			case PUMPKIN_PIE: if (saturation) return 5; else return 8;
			case RABBIT_STEW: if (saturation) return 12; else return 10;
			case BEEF:
			case PORKCHOP:
			case RABBIT: if (saturation) return 2; else return 3;
			case ROTTEN_FLESH: if (saturation) return 1; else return 4;
			case SPIDER_EYE: if (saturation) return 3; else return 2;
			default: return 0;
		}
	}

	public void activeEffect(Player player, ItemStack item) { }
}

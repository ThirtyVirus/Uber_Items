package thirtyvirus.uber.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import thirtyvirus.uber.UberItem;

public class smart_pack extends UberItem{

	//Constructor
	public smart_pack(int id, String name, List<String> lore, String description, Material material, Boolean canBreakBlocks, boolean stackable, boolean hasActiveEffect) {
		super(id, name, lore, description, material, canBreakBlocks, stackable, hasActiveEffect);
	}

	@Override
	public void leftClickAirAction(Player player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rightClickAirAction(Player player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rightClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shiftLeftClickAirAction(Player player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shiftLeftClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shiftRightClickAirAction(Player player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shiftRightClickBlockAction(Player player, PlayerInteractEvent event, Block block, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void middleClickAction(Player player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activeEffect(Player player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}
}

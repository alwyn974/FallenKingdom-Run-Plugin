package re.alwyn974.fallenkingdomrun.events;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftsEvent implements Listener {

	ArrayList<Material> material = new ArrayList<Material>();
	Material[] basic = { Material.WOOD_PICKAXE, Material.WOOD_AXE, Material.WOOD_SPADE, Material.STONE_PICKAXE,
			Material.STONE_AXE, Material.STONE_SPADE };
	Material[] upgrade = { Material.IRON_PICKAXE, Material.IRON_AXE, Material.IRON_SPADE, Material.GOLD_PICKAXE,
			Material.GOLD_AXE, Material.GOLD_SPADE, Material.DIAMOND_PICKAXE, Material.DIAMOND_AXE,
			Material.DIAMOND_SPADE };

	@EventHandler
	public void onPrepareItemCraft(PrepareItemCraftEvent e) {
		ItemStack stack = e.getInventory().getResult();
		CraftingInventory inv = e.getInventory();

		material.addAll(Arrays.asList(basic));
		material.forEach(type -> {
			if (stack.getType() == type) {
				ItemMeta meta = stack.getItemMeta();
				meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
				stack.setItemMeta(meta);
				inv.setResult(stack);
			}
		});
		material.clear();

		material.addAll(Arrays.asList(upgrade));
		material.forEach(type -> {
			if (stack.getType() == type) {
				ItemMeta meta = stack.getItemMeta();
				meta.addEnchant(Enchantment.DIG_SPEED, 2, true);
				stack.setItemMeta(meta);
				inv.setResult(stack);
			}
		});
		material.clear();
	}
}

package re.alwyn974.fallenkingdomrun.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlocksBreakEvent implements Listener {

	ItemStack[] dropCook = { new ItemStack(Material.COAL, 2), new ItemStack(Material.TORCH, 4),
			new ItemStack(Material.IRON_INGOT), new ItemStack(Material.GOLD_INGOT) };
	
	Random rand = new Random();
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		switch (e.getBlock().getType()) {
		case COAL_ORE:
			e.setCancelled(true);
			e.getBlock().setType(Material.AIR);
			e.getPlayer().getWorld().dropItem(e.getBlock().getLocation(), dropCook[0]);
			e.getPlayer().getWorld().dropItem(e.getBlock().getLocation(), dropCook[1]);
			e.getPlayer().setTotalExperience((int) (e.getPlayer().getTotalExperience() + 0.7));
			e.getPlayer().giveExp(1);
			break;
		case IRON_ORE:
			e.setCancelled(true);
			e.getBlock().setType(Material.AIR);
			e.getPlayer().getWorld().dropItem(e.getBlock().getLocation(), dropCook[2]);
			e.getPlayer().giveExp(1);
			break;
		case GOLD_ORE:
			e.setCancelled(true);
			e.getBlock().setType(Material.AIR);
			e.getPlayer().getWorld().dropItem(e.getBlock().getLocation(), dropCook[3]);
			e.getPlayer().giveExp(1);
			break;
		case GRAVEL:
			if (rand.nextInt(100) <= 50) {
				e.setCancelled(true);
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.FLINT));
			}
		case LEAVES:
			if (rand.nextInt(100) <= 1) {
				e.setCancelled(true);
				e.getBlock().setType(Material.AIR);
				e.getPlayer().getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
			}
		default:
			break;
		}
	}

}

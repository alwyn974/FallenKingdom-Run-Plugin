package re.alwyn974.fallenkingdomrun.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDeathDropsEvent implements Listener {

	String[] entity_name = { "Pig", "Cow", "Chicken", "Rabbit", "Sheep" };
	int[] drops = { 319, 363, 365, 411, 423 };

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		if (e.getEntity().getName().equals(entity_name[0])) {
			int size = e.getDrops().size();
			for (int i = 0; i < size; i++) {
				ItemStack item = e.getDrops().get(i);
				if (item.getTypeId() == drops[0])
					item = new ItemStack(drops[0] + 1, item.getAmount());
				e.getEntity().getKiller().getInventory().addItem(item);
			}
			e.getDrops().clear();
		}

		if (e.getEntity().getName().equals(entity_name[1])) {
			int size = e.getDrops().size();
			for (int i = 0; i < size; i++) {
				ItemStack item = e.getDrops().get(i);
				if (item.getTypeId() == drops[1])
					item = new ItemStack(drops[1] + 1, item.getAmount());
				e.getEntity().getKiller().getInventory().addItem(item);
			}
			e.getDrops().clear();
		}

		if (e.getEntity().getName().equals(entity_name[2])) {
			int size = e.getDrops().size();
			for (int i = 0; i < size; i++) {
				ItemStack item = e.getDrops().get(i);
				if (item.getTypeId() == drops[2])
					item = new ItemStack(drops[2] + 1, item.getAmount());
				e.getEntity().getKiller().getInventory().addItem(item);
			}
			e.getDrops().clear();
		}

		if (e.getEntity().getName().equals(entity_name[3])) {
			int size = e.getDrops().size();
			for (int i = 0; i < size; i++) {
				ItemStack item = e.getDrops().get(i);
				if (item.getTypeId() == drops[3])
					item = new ItemStack(drops[3] + 1, item.getAmount());
				e.getEntity().getKiller().getInventory().addItem(item);
			}
			e.getDrops().clear();
		}

		if (e.getEntity().getName().equals(entity_name[4])) {
			int size = e.getDrops().size();
			for (int i = 0; i < size; i++) {
				ItemStack item = e.getDrops().get(i);
				if (item.getTypeId() == drops[4])
					item = new ItemStack(drops[4] + 1, item.getAmount());
				e.getEntity().getKiller().getInventory().addItem(item);
			}
			e.getDrops().clear();
		}

	}

	/*public void onEntityDeath(EntityDeathEvent e) {
		FkRun.getInstance().info(e.getEntity().getName());

		for (int i = 0; i < entity_name.length; i++) {
			if (e.getEntity().getName().equals(entity_name[i])) {
				int size = e.getDrops().size();
				FkRun.getInstance().info(e.getDrops() + " " + size);
				for (int j = 0; j < size; j++) {
					ItemStack item = e.getDrops().get(j);
					for (int k = 0; k < drops.length; k++) {
						if (item.getTypeId() == drops[k]) {
							item = new ItemStack(drops[k] + 1, item.getAmount());
							e.getEntity().getKiller().getInventory().addItem(item);
							e.getDrops().remove(item);
						}
					}
					e.getEntity().getKiller().getInventory().addItem(item);
				}
				e.getDrops().clear();
			}
		}
	}*/

}

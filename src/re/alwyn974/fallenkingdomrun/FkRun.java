package re.alwyn974.fallenkingdomrun;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import re.alwyn974.fallenkingdomrun.events.BlocksBreakEvent;
import re.alwyn974.fallenkingdomrun.events.CraftsEvent;
import re.alwyn974.fallenkingdomrun.events.EntityDeathDropsEvent;

public class FkRun extends JavaPlugin {
	
	private final String name = "§6[§bFallenKingdom-Run§6] ";
	private ConsoleCommandSender console;
	private static FkRun instance;
	
	@Override
	public void onEnable() {
		if (instance == null)
			instance = this;
		this.console = this.getServer().getConsoleSender();
		info("Enable");
		
		this.getServer().getPluginManager().registerEvents(new CraftsEvent(), this);
		this.getServer().getPluginManager().registerEvents(new BlocksBreakEvent(), this);
		this.getServer().getPluginManager().registerEvents(new EntityDeathDropsEvent(), this);
	}

	@Override
	public void onDisable() {
		info("Disable");
	}

	public ConsoleCommandSender getConsole() {
		return console;
	}
	
	public void info(Object msg) {
		console.sendMessage(name + "§3[INFO] " +  msg);
	}
	
	public void error(Object msg) {
		console.sendMessage(name + "§c[ERROR] " +  msg);
	}
	
	public void warn(Object msg) {
		console.sendMessage(name + "§e[WARN] " +  msg);
	}
	
	public void debug(Object msg) {
		console.sendMessage(name + "§7[DEBUG] " +  msg);
	}
	
	public void success(Object msg) {
		console.sendMessage(name + "§a[SUCCESS] " +  msg);
	}
	
	public static FkRun getInstance() {
		return instance;
	}
	
	public String getPluginName() {
		return name;
	}
}

package de.redstoneraudi.mctools;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.redstoneraudi.mctools.cmd.CommandTools;
import de.redstoneraudi.mctools.listeners.InventoryClickListener;

public class McTools extends JavaPlugin {
	
	private final String prefix = "�7[�6McTools�7] �r";
	private final String noPerm = prefix + "�4You don't have Permission to do that!";
	private final String failCommand = prefix + "�4Wrong Arguments: /mctools";
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(prefix + "�9Plugin �4" + getDescription().getName() + " �9by �4" 
		+ getDescription().getAuthors() + " �9enabled!");
		registerEvents();
		registerCommands();
	}

	public String getNoPermMessage() {
		return noPerm;
	}

	public String getPrefix() {
		return prefix;
	}
	
	public String getFailCommandMessage() {
		return failCommand;
	}
	
	public void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
	}
	
	public void registerCommands() {
		getCommand("mctools").setExecutor(new CommandTools(this));
	}
}

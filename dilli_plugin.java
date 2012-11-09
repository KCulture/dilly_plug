package com.github.smoking_peanut.dilli_plugin;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.HandlerList;
import org.bukkit.generator.ChunkGenerator;



import com.github.smoking_peanut.dilli_plugin.Event_me;
//import com.github.smoking_peanut.dilli_plugin.World_Gen;

public class dilli_plugin extends JavaPlugin {
	private Commander ComExe;
	Logger Log = Logger.getAnonymousLogger();
	
	
	@Override
	public void onEnable() {
		Event_me event = new Event_me();
		getServer().getPluginManager().registerEvents(event,this);
		getLogger().info("pluggin is enabled");
		ComExe = new Commander(this);
		getCommand("red").setExecutor(ComExe);
		getCommand("blue").setExecutor(ComExe);
		
				
	}
	
	// Id are the params from bukkit.yml
	// Look in the docu, how to set params
	// In this case, id is the height of the generated world
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id)
	{
	 return new World_Gen(this);
	} 
	
	
	public void onDisabed() {
		getLogger().info("time to go boys and girls");
		HandlerList.unregisterAll();
	}
	
	
}

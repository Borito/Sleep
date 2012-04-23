package de.mineterra.schlafen;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class schlafen extends JavaPlugin{
	
	//Laden und Entladen
	
	
	@Override
	public void onDisable(){
		
		
		System.out.println("[Schlafen] wurde Deaktiviert!");
	}
	
	
	@Override
	public void onEnable(){
		
		PluginDescriptionFile descFile = this.getDescription();
		
		registerEvent();
		System.out.println("[Schlaf Nachricht] Plugin by " + descFile.getAuthors() + (" Version ") + descFile.getVersion() + " wurde Aktiviert!");
	}
	
		
	
	//Event
	private void registerEvent(){
		spsl = new SchlafenPlayerSleepListener(this);

	}
	
	@SuppressWarnings("unused")
	private SchlafenPlayerSleepListener spsl;
	
	
	
	
	
	
	
	
	

}

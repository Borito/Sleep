package de.mineterra.schlafen;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class SchlafenPlayerSleepListener implements Listener{
	
	

	public SchlafenPlayerSleepListener(schlafen plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	@EventHandler
	public void onPlayerBedEnter(PlayerBedEnterEvent event) throws InterruptedException{
		Player eP = event.getPlayer();
		plugin.getServer().broadcastMessage(ChatColor.GREEN + eP.getDisplayName() + ChatColor.YELLOW + " Ist jetzt ins Bett Gegangen!");
		eP.sendMessage("Wir wuenschen dir eine gute Nacht :)!");
		eP.setFoodLevel(eP.getFoodLevel() - 6);
		

}
		
		//eP.setHealth(eP.getFoodLevel() 0);
		
		
	
	@EventHandler
	public void onPlayerBedLeave(PlayerBedLeaveEvent event2){
		Player eP = event2.getPlayer();
		PlayerInventory inv = eP.getInventory();
		ItemStack keks = new ItemStack(Material.COOKIE, 1);
		
		eP.sendMessage(ChatColor.GREEN + "Guten Morgen!");
		eP.setHealth(20);
		inv.addItem(keks);
		//Sorgt dafür das Rauch austritt
		eP.getWorld().playEffect(eP.getLocation(), Effect.SMOKE, 20);
		//Vielleicht das ganze mit einem Item verbinden?
		//eP.getWorld().dropItem(eP.getLocation(), new ItemStack(3, 1));
	    //Und den Spieler Töten, wenn der Hunger 0 ist.
		if (eP.getFoodLevel() <=0){
			eP.setHealth(0);
		}
		
	
	}




	
	private schlafen plugin;
}

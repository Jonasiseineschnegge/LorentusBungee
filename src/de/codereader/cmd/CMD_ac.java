package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class CMD_ac implements Listener{

	@EventHandler
	public void onChat(ChatEvent e) {
		
		ProxiedPlayer p = (ProxiedPlayer) e.getSender();
		
		if(Vars.permission.get(p.getName()) == 1) {
		
		String raw = e.getMessage();
		
		if(raw.startsWith("@ac")) {
			
			String msg = raw.replace("@ac ", "");
			
			if(!msg.equals("")) {
			
			for(ProxiedPlayer player : BungeeCord.getInstance().getPlayers()) {
				
				if(Vars.permission.get(player.getName()) == 1) {
					
					API.sendMessage(player, "§cAdminchat §8✖ §b" + p.getName() + " §7» " +  msg);
					e.setCancelled(true);
					
				}
				
			}
			
			}else {
				API.sendMessage(p, Vars.prefix + "Keine §eNachricht §7angegeben");
			}
			
		}
		
		}
		
	}
	

}

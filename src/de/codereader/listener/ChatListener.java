package de.codereader.listener;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChatListener implements Listener {

	
	@EventHandler
	public void onChat(ChatEvent e) {
		
		String msg = e.getMessage();
		
		Vars.words.forEach(word -> {

			if(msg.contains(word)) {
				
				e.setCancelled(true);
				
				ProxiedPlayer p = (ProxiedPlayer) e.getSender();
				
				API.sendMessage(p, Vars.prefix + "Deine §eNachricht §7beinhaltet §7ein §cunangebrachtes Wort§7.");
				API.sendMessage(p, Vars.prefix + "Deine Nachticht wurde deshalb §4blockiert§7.");
				
				
			}
			
		});
		
	}
	
}

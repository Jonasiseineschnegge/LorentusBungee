package de.codereader.listener;

import de.codereader.utils.TeamSystem;
import de.codereader.utils.Vars;
import de.codereader.utils.Wartung;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinListener implements Listener {

	@EventHandler
	public static void onLogin(ServerConnectEvent e) {



		ProxiedPlayer pp = e.getPlayer();

		if(!TeamSystem.hasRank(pp)) {
			TeamSystem.setRank("Spieler", pp);
		}
		
		Vars.permission.put(pp.getName(), TeamSystem.getPermission(pp));
		
		if(Wartung.getWartungState()) {
		
			
		if(!(TeamSystem.getPermission(pp) <= 9)) {
			
			pp.disconnect(new TextComponent("§7§m----------------------------------------\n§f \n§7Wir befinden uns im\n§7➥ §cWartungsmodus\n"
				+ "§c \n§7Teamspeak » §bLorentus.de\n§7Website » §bLorentus.de\n§1 \n§7§m----------------------------------------"));
			e.setCancelled(true);
	
			for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
				if(TeamSystem.getPermission(all) <= 1) {
					all.sendMessage(new TextComponent(Vars.prefix + "Der Spieler §b" + pp.getName() + " §7wollte den §bServer §7betreten."));
				}
			}
			
		}else {
			
			e.setCancelled(false);
			
		}
			
		}else {
			
			e.setCancelled(false);
			
		}
		
		
	}


}

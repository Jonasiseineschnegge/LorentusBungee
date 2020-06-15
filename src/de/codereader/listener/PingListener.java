package de.codereader.listener;

import de.codereader.utils.Wartung;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.ServerPing.Protocol;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PingListener implements Listener {

	@EventHandler
	public void onPing(ProxyPingEvent e) {
		
		ServerPing ping = e.getResponse();
		
		if(Wartung.getWartungState()) {
			
			ping.setDescriptionComponent(new TextComponent("§7» §bLorentus.de §7Servernetzwerk « \n §7➥ Wir befinden uns im §cWartungsmodus."));
			ping.setVersion(new Protocol("§7» §4Wartung", 2));
			
			
		}else if(!Wartung.getWartungState()) {
			
			ping.setDescriptionComponent(new TextComponent("§7» §bLorentus.de §7Servernetzwerk « \n §7➥ Team §bgesucht §7| §b§nOpen Beta"));
			ping.setPlayers(new Players(65, ProxyServer.getInstance().getOnlineCount(), null));
		
		}
		
		e.setResponse(ping);
		
	}
	
}

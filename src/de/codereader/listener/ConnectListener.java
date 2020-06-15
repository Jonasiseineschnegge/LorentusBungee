package de.codereader.listener;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ConnectListener implements Listener {


	@EventHandler
	public void onServerChange(ServerSwitchEvent e) {
		
		ProxiedPlayer pp = e.getPlayer();
		
		pp.setTabHeader(new TextComponent("§f \n§7» §bLorentus.de §7Server Netzwerk «\nDu spielst auf §8× §b" + pp.getServer().getInfo().getName()
		+ "\n§bSpieler §7online §8×  §b" + ProxyServer.getInstance().getOnlineCount() + "§7/§b80\n§c "),
		new TextComponent("§a \n§7Webseite §8× §bLorentus.de\n§7Teamspeak §8× §bSanityMC.de\n§1 "));
		
		for(ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
			all.setTabHeader(new TextComponent("§f \n§7» §bLorentus.de §7Server Netzwerk «\nDu spielst auf §8× §b" + all.getServer().getInfo().getName()
					+ "\n§bSpieler §7online §8×  §b" + ProxyServer.getInstance().getOnlineCount() + "§7/§b80\n§c "),
					new TextComponent("§a \n§7Webseite §8× §bLorentus.de\n§7Teamspeak §8× §bLorentus.de\n§1 "));
		}
		
	}
	
}

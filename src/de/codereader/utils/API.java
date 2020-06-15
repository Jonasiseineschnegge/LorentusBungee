package de.codereader.utils;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class API {

	public static void sendMessage(ProxiedPlayer p, String msg) {
		p.sendMessage(new TextComponent(msg));
	}
	
}

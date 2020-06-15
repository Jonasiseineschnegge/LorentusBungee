package de.codereader.cmd;

import java.util.Random;

import de.codereader.utils.Vars;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_Hub extends Command {

	public CMD_Hub(String name) {
		super(name);
	}


	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer pp = (ProxiedPlayer)sender;
		
		if(args.length != 0) {
			
			pp.sendMessage(Vars.prefix + "Bitte verwende: §c/hub");
			
		}else {
			
		if(!pp.getServer().getInfo().getName().equalsIgnoreCase("lobby")) {

			ServerInfo info = ProxyServer.getInstance().getServerInfo("lobby");

			pp.connect(info);
			pp.sendMessage(Vars.prefix + "§7Du wirst auf einen §bLobby Server §7verbunden.");
			pp.sendMessage(Vars.prefix + "Aktueller Server: §bLobby-1");

			
		}else {
			
			pp.sendMessage(Vars.prefix + "§7Du bist bereits auf einem §bLobby Server§7.");
			
		}
			
		}
		
	}

}

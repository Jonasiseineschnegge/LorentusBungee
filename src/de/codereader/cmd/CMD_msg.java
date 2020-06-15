package de.codereader.cmd;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_msg extends Command {

	public CMD_msg(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		@SuppressWarnings("unused")
		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		StringBuilder bc = new StringBuilder();
		for(String port : args) {
			bc.append(port + " ");
		}
		
		
		
	}

}

package de.codereader.cmd;

import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_bc extends Command {

	public CMD_bc(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(Vars.permission.get(p.getName()) == 1) {
			
				
				StringBuilder bc = new StringBuilder();
				for(String port : args) {
					bc.append(port + " ");
				}
				
				BungeeCord.getInstance().broadcast(new TextComponent("§eBroadcast §7| " + bc.toString()));
				
		}
		
	}

}

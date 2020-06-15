package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_cc extends Command {

	public CMD_cc(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(Vars.permission.get(p.getName()) <= 7) {
			
			if(args.length == 0) {
				
				for(ProxiedPlayer players : BungeeCord.getInstance().getPlayers()) {
					
					if(players.getServer().equals(p.getServer())) {
						
						for(int i = 0; i <= 100; i++) {
							API.sendMessage(players, " ");
						}
						API.sendMessage(players, Vars.prefix + "Der §eChat §7wurde auf diesem §eServer §7geleert.");
						
					}
					
				}
				
			}else {
				
				API.sendMessage(p, Vars.prefix + "Verwende: §e/cc §7<Nachricht>");
				
			}
		
	}

	}
	
}

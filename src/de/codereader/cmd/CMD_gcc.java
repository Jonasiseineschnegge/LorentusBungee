package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_gcc extends Command {

	public CMD_gcc(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(Vars.permission.get(p.getName()) <= 7) {
			
			if(args.length == 0) {
				
				for(ProxiedPlayer players : BungeeCord.getInstance().getPlayers()) {
					
						for(int i = 0; i <= 50; i++) {
							API.sendMessage(players, " ");
						}
						API.sendMessage(players, Vars.prefix + "Der §eChat §7wurde auf allen §eServern §7geleert.");
					
				}
				
			}else {
				
				API.sendMessage(p, Vars.prefix + "Verwende: §e/gcc §7<Nachricht>");
				
			}
		
	}

	}
	
}

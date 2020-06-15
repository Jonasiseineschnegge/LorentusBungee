package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.TeamSystem;
import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_rank extends Command {

	public CMD_rank(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(Vars.permission.get(p.getName()) == 1) {
		
			if(args.length == 2) {
			
				try {
					
					ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
					
					String rank = args[1];
					
					TeamSystem.updateRank(rank, t);
					
					API.sendMessage(p, Vars.prefix + "Der Spieler §e" + t.getName() + " §7hat nun §7den §7Rang §e" + rank);
					
				} catch (Exception e) {
				}
		
			}else {
				
				API.sendMessage(p, Vars.prefix + "Verwende: §e/rank §7<Spieler> §7<Rang>");
				
			}
				
		}
		
	}

}

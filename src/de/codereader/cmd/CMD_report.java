package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_report extends Command {

	public CMD_report(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer) sender;
		
		if(args.length == 2) {
			
			try {
			
				ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
				String reason = args[1];
				
				if(!t.getName().equalsIgnoreCase(p.getName())) {
				
					API.sendMessage(p, Vars.prefix + "Du hast dein §cReport §7erfolgreich abgesendet");
					API.sendMessage(p, Vars.prefix + "Spieler: §e" + t.getName());
					API.sendMessage(p, Vars.prefix + "Server: §e" + t.getServer().getInfo().getName());
					API.sendMessage(p, Vars.prefix + "Grund: §e" + reason);
					
					Vars.reports.put(t.getName(), reason);
					
					for(ProxiedPlayer players : BungeeCord.getInstance().getPlayers()) {
						
						if(Vars.permission.get(players.getName()) <= 7) {
						
							API.sendMessage(players, Vars.prefix + "Der Spieler §e" + p.getName() + " §7hat einen §eReport §7abgesendet.");
							API.sendMessage(players, Vars.prefix + "Spieler: §e" + t.getName());
							API.sendMessage(players, Vars.prefix + "Server: §e" + t.getServer().getInfo().getName());
							API.sendMessage(players, Vars.prefix + "Grund: §e" + reason);
							API.sendMessage(players, Vars.prefix + "Benutze \"§c/reports " + t.getName() + "§7\", zum §eannehmen§7.");
						
						}
						
					}
					
				}
				
			} catch (Exception e) {

			}
			
		}else {
			
			API.sendMessage(p, Vars.prefix + "Verwende: §e/report §7<Spieler> §7<Grund>");
			
		}
		
	}

}

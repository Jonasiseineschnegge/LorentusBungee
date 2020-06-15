package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_reports extends Command {

	public CMD_reports(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(Vars.permission.get(p.getName()) <= 7) {
			
			if(args.length == 1) {
				
				ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
				
				if(Vars.reports.containsKey(t.getName())) {
					
					API.sendMessage(p, Vars.prefix + "Du hast den §eReport §7übernommen.");
					
					Vars.reports.remove(t.getName());
					
					if(!p.getServer().getInfo().getName().equalsIgnoreCase(t.getServer().getInfo().getName())) {
						
						ServerInfo info = BungeeCord.getInstance().getServerInfo(t.getServer().getInfo().getName());
						API.sendMessage(p, Vars.prefix + "Verbinde zum §eServer§7.");
						p.connect(info);
						
						
					}
					
					
				}else {
					
					API.sendMessage(p, Vars.prefix + "§7➥ Dieser §eSpieler §7wurde nicht §ereportet.");
					
				}
				
			}else if(args.length == 0){
				
				API.sendMessage(p, Vars.prefix + "Alle §eoffenen Reports§7:");
				
				if(Vars.reports.keySet().size() >= 1) {
				
					for(String report : Vars.reports.keySet()) {
						
						API.sendMessage(p, Vars.prefix + "§7➥ §7Spieler: §e" + report + " §7 | Grund: §e" + Vars.reports.get(report));
						
					}
				
				}else {
					
					API.sendMessage(p, Vars.prefix + "§7➥ Keine offenen §eReports");
					
				}
				
			}else {
				
				API.sendMessage(p, "Verwende: §e/reports §7<Spieler>");
				
			}
			
		}
		
	}

}

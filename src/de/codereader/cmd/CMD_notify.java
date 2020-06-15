package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_notify extends Command {

	public CMD_notify(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer) sender;
		
		if(Vars.permission.get(p.getName()) <= 7) {
			
			if(args.length == 0) {
				
				if(!Vars.notify.contains(p.getName())) {
					
					Vars.notify.add(p.getName());
					API.sendMessage(p, Vars.prefix + "Du wirst nun §cnicht mehr §7vom §cTeamchat §7benachrichtigt.");
					
					
				}else {
					
					Vars.notify.remove(p.getName());
					API.sendMessage(p, Vars.prefix + "Du wirst nun §awieder §7vom §cTeamchat §7benachrichtigt.");
					
				}
				
			}else {
				
				API.sendMessage(p, Vars.prefix + "Verwende: §e/notify");
				
			}
			
		}
		
	}

}

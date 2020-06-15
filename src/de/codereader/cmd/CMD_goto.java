package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_goto extends Command {

	public CMD_goto(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(Vars.permission.get(p.getName()) <= 7) {
			
			if(args.length == 1) {
				
				try {

					ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
					
					ServerInfo info = BungeeCord.getInstance().getServerInfo(t.getServer().getInfo().getName());
					
					if(!p.getServer().getInfo().equals(info)) {
						
						API.sendMessage(p, Vars.prefix + "Du wirst auf den §eServer §7von §e" + t.getName() + " §7verbunden...");
						p.connect(info);
						
					}else {
						
						API.sendMessage(p, Vars.prefix + "Du bist bereits auf dem §eServer §7von §e" + t.getName());
						
					}
					
				} catch (Exception e) {
				}
				
			}else {
				
				API.sendMessage(p, Vars.prefix + "Verwende: §e/goto §7<Spieler>");
				
			}
			
		}
		
	}

}

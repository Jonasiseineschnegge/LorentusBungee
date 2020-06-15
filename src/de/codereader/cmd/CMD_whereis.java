package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_whereis extends Command {

	public CMD_whereis(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(Vars.permission.get(p.getName()) <= 7) {
		
			if(args.length == 1) {
			
				try {
		
					ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
					
					String server = t.getServer().getInfo().getName();
					
					API.sendMessage(p, Vars.prefix + "Der Spieler §e" + t.getName() + " §7befindet §7sich §7auf §7dem §7Server: §e" + server);
					
				} catch (Exception e) {
				}
		
			}else {
				
				API.sendMessage(p, Vars.prefix + "Verwende: §e/whereis §7<Spieler>");
				
			}
				
		}
		
	}

}

package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_kick extends Command {

	public CMD_kick(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(Vars.permission.get(p.getName()) <= 7) {
			
			if(args.length == 1) {
				
				try {

					ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
					
					t.disconnect(new TextComponent("§7§m----------------------------------------\n§a \n§7Du wurdest vom Server §4GEKICKT§7!\n§f "
							+ "\n§7Grund: §cUnangemessen Verhalten\n§1 "
							+ "\n§7Keine §cRechtvertigung §7des §cTeams §7notwendig.\n§a "
							+ "\n§7§m----------------------------------------"));

					p.sendMessage(new TextComponent(Vars.prefix + "Du hast den Spieler §b" + t.getName() + " §7gekickt!"));

				} catch (Exception e) {
				}
				
				
				
			}else {
				
				API.sendMessage(p, Vars.prefix + "Verwende: §e/kick §7<Spieler>");
				
			}
			
		}
		
	}

}

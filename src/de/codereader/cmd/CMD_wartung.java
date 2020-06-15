package de.codereader.cmd;

import de.codereader.utils.Vars;
import de.codereader.utils.Wartung;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_wartung extends Command {

	public CMD_wartung(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(Vars.permission.get(p.getName()) == 1) {
		
		if(Wartung.getWartungState()) {
			
			Wartung.setWartungState(false);
			sender.sendMessage(new TextComponent(Vars.prefix + "Du hast den Wartungsmodus §cdeaktiviert§7."));
			
		}else {
			
			Wartung.setWartungState(true);
			sender.sendMessage(new TextComponent(Vars.prefix + "Du hast den Wartungsmodus §aaktiviert§7."));
			
			
		}
		
		}
	}

}

package de.codereader.cmd;

import de.codereader.utils.API;
import de.codereader.utils.Vars;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_system extends Command {

	public CMD_system(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer) sender;
		
		if(args.length == 0) {
		
		if(Vars.permission.get(p.getName()) <= 7) {
			
			API.sendMessage(p, "§7§m----------------------------");
			API.sendMessage(p, "§7➥ §eBungeeSystem §7- §eHilfe §7<Team>");
			API.sendMessage(p, Vars.prefix + "» §e@ac <Nachricht> §7| Schreibe in §7den §7Adminchat");
			API.sendMessage(p, Vars.prefix + "» §e@tc <Nachricht> §7| Schreibe in §7den §7Teamchat");
			API.sendMessage(p, Vars.prefix + "» §e/p §7| Zeige die BanSystem §7Hilfe §7an");
			API.sendMessage(p, Vars.prefix + "» §e/check §7| Checke den Ban State §7eines §7Spieler");
			API.sendMessage(p, Vars.prefix + "» §e/bauserver §7| Verbinde dich zu §7deinem §7BauServer");
			API.sendMessage(p, Vars.prefix + "» §e/bc §7| Schreibe eine Nachricht über das §7ganze §7Netzwerk");
			API.sendMessage(p, Vars.prefix + "» §e/cc §7| Leere den Chat von deinem §7aktuellen §7Server");
			API.sendMessage(p, Vars.prefix + "» §e/chatfilter §7| Manage den Chatfilter");
			API.sendMessage(p, Vars.prefix + "» §e/chatmute §7| Schalte den Chat an oder §7aus");
			API.sendMessage(p, Vars.prefix + "» §e/gcc §7| Leere den Chat vom §7gesamten §7Netzwerk");
			API.sendMessage(p, Vars.prefix + "» §e/getip §7| Lasse dir die IP eines §7Spielers §7anzeigen");
			API.sendMessage(p, Vars.prefix + "» §e/goto §7| Joine einem Spieler §7nach");
			API.sendMessage(p, Vars.prefix + "» §e/kick §7| Kicke einen §7Spieler");
			API.sendMessage(p, Vars.prefix + "» §e/notify §7| Schalte Teambenachrichtigungen §7n §7oder §7aus");
			API.sendMessage(p, Vars.prefix + "» §e/support accept §7| Nehme eine §7Support-Anfrage §7an");
			API.sendMessage(p, Vars.prefix + "» §e/teamac §7| Zeige die Aktivität eines §7Teammitglieds §7an");
			API.sendMessage(p, Vars.prefix + "» §e/teamonline §7| Zeige alle Teammitglieder, §7die §7online §7sind §7an");
			API.sendMessage(p, Vars.prefix + "» §e/wartung §7| De/aktiviere den §7Wartungsmodus");
			API.sendMessage(p, Vars.prefix + "» §e/whereis §7| Zeige den aktuellen Server §7eines §7Spielers §7an");
			
			API.sendMessage(p, "§7§m----------------------------");
			API.sendMessage(p, "§7➥ §eBungeeSystem §7- §eHilfe");
			API.sendMessage(p, Vars.prefix + "» §e/bewerben §7| Zeige §7an, §7wo §7sich §7Spieler §7bewerben §7können");
			API.sendMessage(p, Vars.prefix + "» §e/coins §7| §7Zeige §7deine §7Coins §7an");
			API.sendMessage(p, Vars.prefix + "» §e/friend §7| Zeige deine FreundeSystem §7Hilfe §7an");
			API.sendMessage(p, Vars.prefix + "» §e/l §7| Teleportiert dich in §7die §7Lobby");
			API.sendMessage(p, Vars.prefix + "» §e/hub §7| Teleportiert dich in §7die §7Lobby");
			API.sendMessage(p, Vars.prefix + "» §e/msg §7| Schreibe eine §7private §7Nachricht");
			API.sendMessage(p, Vars.prefix + "» §e/online §7| Zeige die derzeitige§7 §7Online §7Spieleranzahl §7an");
			API.sendMessage(p, Vars.prefix + "» §e/party §7| Zeige die §7PartySystem §7Hilfe §7an");
			API.sendMessage(p, Vars.prefix + "» §e/ping §7| Zeige deinen §7aktuellen §7Ping §7an");
			API.sendMessage(p, Vars.prefix + "» §e/r §7| Antworte auf eine §7private §7Nachricht");
			API.sendMessage(p, Vars.prefix + "» §e/report §7| Reporte §7einen §7Spieler");
			API.sendMessage(p, Vars.prefix + "» §e/shop §7| Zeige an, wo sich §7der §7Shop §7befindet");
			API.sendMessage(p, Vars.prefix + "» §e/support §7| Erstellt eine §7Support §7Anfrage");
			API.sendMessage(p, Vars.prefix + "» §e/ts §7| Zeige die §7TS-IP §7an");
			API.sendMessage(p, Vars.prefix + "» §e/whereami §7| Zeige deinen aktuellen §7Server §7an");
			API.sendMessage(p, Vars.prefix + "» §e/youtuber §7| Zeige die YouTuber §7Anforderungen §7an");
			API.sendMessage(p, "§7§m----------------------------");
			
		}else {
			
			API.sendMessage(p, "§7§m----------------------------");
			API.sendMessage(p, "§7➥ §eBungeeSystem §7- §eHilfe");
			API.sendMessage(p, Vars.prefix + "» §e/bewerben §7| Zeige an, wo sich Spieler bewerben können");
			API.sendMessage(p, Vars.prefix + "» §e/coins §7| Zeige deine Coins an");
			API.sendMessage(p, Vars.prefix + "» §e/friend §7| Zeige deine FreundeSystem Hilfe an");
			API.sendMessage(p, Vars.prefix + "» §e/l §7| Teleportiert dich in die Lobby");
			API.sendMessage(p, Vars.prefix + "» §e/hub §7| Teleportiert dich in die Lobby");
			API.sendMessage(p, Vars.prefix + "» §e/msg §7| Schreibe eine private Nachricht");
			API.sendMessage(p, Vars.prefix + "» §e/online §7| Zeige die derzeitige Online Spieleranzahl an");
			API.sendMessage(p, Vars.prefix + "» §e/party §7| Zeige die PartySystem Hilfe an");
			API.sendMessage(p, Vars.prefix + "» §e/ping §7| Zeige deinen aktuellen Ping an");
			API.sendMessage(p, Vars.prefix + "» §e/r §7| Antworte auf eine private Nachricht");
			API.sendMessage(p, Vars.prefix + "» §e/report §7| Reporte einen Spieler");
			API.sendMessage(p, Vars.prefix + "» §e/shop §7| Zeige an, wo sich der Shop befindet");
			API.sendMessage(p, Vars.prefix + "» §e/support §7| Erstellt eine Support Anfrage");
			API.sendMessage(p, Vars.prefix + "» §e/ts §7| Zeige die TS-IP an");
			API.sendMessage(p, Vars.prefix + "» §e/whereami §7| Zeige deinen aktuellen Server an");
			API.sendMessage(p, Vars.prefix + "» §e/youtuber §7| Zeige die YouTuber Anforderungen an");
			API.sendMessage(p, "§7§m----------------------------");
			
		}
	
		}
		
	}

}

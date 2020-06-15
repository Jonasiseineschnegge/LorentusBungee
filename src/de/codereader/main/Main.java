package de.codereader.main;

import de.codereader.cmd.CMD_Hub;
import de.codereader.cmd.CMD_ac;
import de.codereader.cmd.CMD_bc;
import de.codereader.cmd.CMD_bewerben;
import de.codereader.cmd.CMD_cc;
import de.codereader.cmd.CMD_chatfilter;
import de.codereader.cmd.CMD_gcc;
import de.codereader.cmd.CMD_getip;
import de.codereader.cmd.CMD_goto;
import de.codereader.cmd.CMD_joinme;
import de.codereader.cmd.CMD_kick;
import de.codereader.cmd.CMD_msg;
import de.codereader.cmd.CMD_notify;
import de.codereader.cmd.CMD_online;
import de.codereader.cmd.CMD_ping;
import de.codereader.cmd.CMD_rank;
import de.codereader.cmd.CMD_report;
import de.codereader.cmd.CMD_reports;
import de.codereader.cmd.CMD_server;
import de.codereader.cmd.CMD_shop;
import de.codereader.cmd.CMD_support;
import de.codereader.cmd.CMD_system;
import de.codereader.cmd.CMD_tc;
import de.codereader.cmd.CMD_teamonline;
import de.codereader.cmd.CMD_ts;
import de.codereader.cmd.CMD_wartung;
import de.codereader.cmd.CMD_whereami;
import de.codereader.cmd.CMD_whereis;
import de.codereader.cmd.CMD_youtube;
import de.codereader.listener.ChatListener;
import de.codereader.listener.ConnectListener;
import de.codereader.listener.JoinListener;
import de.codereader.listener.PingListener;
import de.codereader.utils.MySQL;
import de.codereader.utils.TeamSystem;
import de.codereader.utils.Vars;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin{

	public static Main instance;
	
	@Override
	public void onEnable() {

		instance = this;	
		
		registerCommands();
		registerListener();
		
				
		connectMySQL();
		
		loadData();
		
	}
	
	private void registerCommands() {

		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_bc("bc"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_cc("cc"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_gcc("gcc"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_whereis("whereis"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_chatfilter("chatfilter"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_notify("notify"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_kick("kick"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_goto("goto"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_getip("getip"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_report("report"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_reports("reports"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_Hub("hub"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_Hub("l"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_Hub("lobby"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_Hub("h"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_wartung("wartung"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_msg("msg"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_bewerben("bewerben"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_getip("getip"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_ping("ping"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_online("online"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_server("server"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_shop("shop"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_teamonline("teamonline"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_ts("ts"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_whereami("whereami"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new CMD_rank("rank"));
	}
	
	private void registerListener() {

		BungeeCord.getInstance().getPluginManager().registerListener(this, new CMD_ac());
		BungeeCord.getInstance().getPluginManager().registerListener(this, new CMD_tc());
		BungeeCord.getInstance().getPluginManager().registerListener(this, new ChatListener());
		BungeeCord.getInstance().getPluginManager().registerListener(this, new JoinListener());
		BungeeCord.getInstance().getPluginManager().registerListener(this, new ConnectListener());
		BungeeCord.getInstance().getPluginManager().registerListener(this, new PingListener());
		
	}
	
	private void connectMySQL() {

		Vars.mysql = new MySQL("localhost", "minecraft", "luis", "luis123");
		Vars.mysql.connect();
		Vars.mysql.update("CREATE TABLE IF NOT EXISTS Team(Player VARCHAR(50), UUID VARCHAR(50), Rank VARCHAR(50), Permission int)");
		Vars.mysql.update("CREATE TABLE IF NOT EXISTS BanedPlayers(Spielername VARCHAR(100), UUID VARCHAR(100), Ende VARCHAR(100), Grund VARCHAR(100));");
		Vars.mysql.update("CREATE TABLE IF NOT EXISTS Stats(UUID varchar(64), KILLS int, DEATHS int);");	
		Vars.mysql.update("CREATE TABLE IF NOT EXISTS MutedPlayers(Spielername VARCHAR(100), UUID VARCHAR(100), Ende VARCHAR(100), Grund VARCHAR(100));");
		Vars.mysql.update("CREATE TABLE IF NOT EXISTS Chatfilter(Words VARCHAR(1000))");
		Vars.mysql.update("CREATE TABLE IF NOT EXISTS Wartung(WARTUNG VARCHAR(50))");
		
	}
	
	private void loadData() {
		
		BungeeCord.getInstance().getPlayers().forEach(player -> {
			Vars.permission.put(player.getName(), TeamSystem.getPermission(player));
		});
		
		
		CMD_chatfilter.getWords().forEach(word -> {
			Vars.words.add(word);
		});
		
	}
	
}

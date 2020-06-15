package de.codereader.cmd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.codereader.utils.Vars;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CMD_chatfilter extends Command {

	public CMD_chatfilter(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		ProxiedPlayer p = (ProxiedPlayer) sender;
		
		if(Vars.permission.get(p.getName()) <= 2) {
			
			if(args.length == 1) {
				
				String word = args[0];
				
				if(Vars.words.contains(word)) {
					
					addWord(word);
					Vars.words.add(word);
					p.sendMessage(new TextComponent(Vars.prefix + "Das Wort §e" + word + " §7wurde hinzugef§gt!"));
					
				}
				
			}else {
				
				
			}
			
		}
		
		
	}

	public void addWord(String word) {
		Vars.mysql.update("INSERT INTO Chatfilter (Words) VALUES ('" + word + "')");
	}
	
	public static ArrayList<String> getWords() {
		
		ArrayList<String> words = new ArrayList<>();
		
		ResultSet rs = Vars.mysql.getResults("SELECT * FROM Chatfilter");
				
		try {
			while(rs.next()) {
				words.add(rs.getString("Words"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return words;
		
	}
	
}

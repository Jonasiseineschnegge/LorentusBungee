package de.codereader.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.md_5.bungee.api.connection.ProxiedPlayer;


public class TeamSystem {

	public static void setRank(String rank, ProxiedPlayer p) {
		
		if(rank.equalsIgnoreCase("Admin")) {
		
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
				+ "'" + p.getUniqueId().toString() + "', "
						+ "'" + rank + "', '" + 1 + "')");
		
		}else if(rank.equalsIgnoreCase("Leitung")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 2 + "')");
			
		}else if(rank.equalsIgnoreCase("Developer")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 3 + "')");
			
		}else if(rank.equalsIgnoreCase("Moderator")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 4 + "')");
			
		}else if(rank.equalsIgnoreCase("Supporter")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 5 + "')");
			
		}else if(rank.equalsIgnoreCase("Builder")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 6 + "')");
			
		}else if(rank.equalsIgnoreCase("Helper")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 7 + "')");
			
		}else if(rank.equalsIgnoreCase("YouTuber")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 8 + "')");
			
		}else if(rank.equalsIgnoreCase("PremiumPlus")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 9 + "')");
			
		}else if(rank.equalsIgnoreCase("Premium")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 10 + "')");
			
		}else if(rank.equalsIgnoreCase("Freund")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 11 + "')");
			
		}else if(rank.equalsIgnoreCase("Spieler")) {
			
			Vars.mysql.update("INSERT INTO Team(Player, UUID, Rank, Permission) VALUES ('" + p.getName() + "',"
					+ "'" + p.getUniqueId().toString() + "', "
							+ "'" + rank + "', '" + 12 + "')");
			
		}
		
	}

	/*
	 * Admin
	 * SrDeveloper
	 * SrModerator
	 * Developer
	 * SrBuilder
	 * Moderator
	 * Supporter
	 * Builder
	 * Helper
	 * YouTuber
	 * PremiumPlus
	 * Premium
	 * Freund
	 * Spieler
	 * 
	 */
	
	public static void updateRank(String rank, ProxiedPlayer p) {
		if(hasRank(p) == true) {
			if(rank.equalsIgnoreCase("Admin")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 1 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("Leitung")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 2 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("Developer")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 3 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("Moderator")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 4 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("Supporter")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 5 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("Builder")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 6 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("Helper")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 7 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("YouTuber")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 8 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("PremiumPlus")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 9 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("Premium")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 10 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("Freund")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 11 + "' WHERE Player= '" + p.getName() + "'");
			}else if(rank.equalsIgnoreCase("Spieler")) {
				Vars.mysql.update("UPDATE Team SET Rank = '" + rank + "', Permission = '" + 12 + "' WHERE Player= '" + p.getName() + "'");
			}else {
				return;
			}
		}
	}
	
	public static boolean hasRank(ProxiedPlayer p) {
		ResultSet rs = Vars.mysql.getResults("SELECT Player FROM Team WHERE UUID= '" + p.getUniqueId().toString() + "'");
		try {
			return rs.next();
		} catch (SQLException e) {
			System.out.println("Ein Fehler ist aufgetreten. [MySQL]");
		}
		return false;
	}
	
	public static int getPermission(ProxiedPlayer p) {
		ResultSet rs = Vars.mysql.getResults("SELECT * FROM Team WHERE Player= '" + p.getName() + "'");
		try {
			while(rs.next()) {
				return rs.getInt("Permission");
			}
		} catch (SQLException e) {
			System.out.println("Ein Fehler ist aufgetreten. [MySQL]");
		}
		return 0;
	}
	
	public static String getRank(ProxiedPlayer p) {
		ResultSet rs = Vars.mysql.getResults("SELECT * FROM Team WHERE Player= '" + p.getName() + "'");
		try {
			while(rs.next()) {
				return rs.getString("Rank");
			}
		} catch (SQLException e) {
			System.out.println("Ein Fehler ist aufgetreten. [MySQL]");
		}
		return "Kein Rang";
		
		
	}
	
}

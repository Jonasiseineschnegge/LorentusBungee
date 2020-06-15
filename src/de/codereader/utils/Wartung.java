package de.codereader.utils;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Wartung {

	public static void setWartungState(boolean mode) {
		if(mode == true) {
			if(!getWartungState()) {
				Vars.mysql.update("INSERT INTO Wartung (WARTUNG) VALUES ('Wartung enabled');");
			}
		}else {
			if(getWartungState()) {
				Vars.mysql.update("DELETE FROM Wartung WHERE WARTUNG= 'Wartung enabled'");
			}
			
		}
		
	}
	
	public static boolean getWartungState() {
		
		ResultSet rs = Vars.mysql.getResults("SELECT WARTUNG FROM Wartung WHERE WARTUNG= 'Wartung enabled'");
		try {
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}

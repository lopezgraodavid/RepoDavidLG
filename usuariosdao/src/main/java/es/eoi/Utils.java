package es.eoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {

	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/persona?serverTimezone=UTC","root", "1234");
	}
	
}

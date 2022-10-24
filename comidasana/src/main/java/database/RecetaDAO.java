package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RecetaDAO {
	
	private static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/comidasana?serverTimezone=UTC","root", "1234");
	}
	

	public static void encuentraReceta() throws SQLException {
		
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,nombre FROM RECETAS");
		
		System.out.println("Estas son nuestras recetas: ");
		while (rs.next()) {
			System.out.println(rs.getString("id")+"- "+rs.getString("nombre"));
		}
		System.out.println();
			
	}
	
	
	public static void crearReceta(String nombre) throws SQLException {
		
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("INSERT INTO comidasana.recetas (nombre) VALUES (?)");
		pst.setString(1, nombre);
		pst.executeUpdate();
		
		con.close();

	}
	
	
}

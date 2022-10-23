package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RestauranteDAO {
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/comidasana?serverTimezone=UTC","root", "1234");
	}

	public static void encuentraRestaurante() throws SQLException {
		
		Connection con = getConnection();
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT nombre,direccion,codigopostal,telefono FROM RESTAURANTES");
		
		while (rs.next()) {
			System.out.println("Nombre: "+rs.getString("nombre")+", Direccion: "+rs.getString("direccion")+"Telefono: "+rs.getString("telefono"));
			System.out.println("Direccion: "+rs.getString("direccion")+"Cod.Postal: "+rs.getString("codigopostal")+"\n");
		}
		
			
	}
}

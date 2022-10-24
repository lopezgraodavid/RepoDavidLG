package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Ingrediente;
import service.IngredienteService;
import service.RecetaService;

public class IngredientesDAO {
	
	private static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/comidasana?serverTimezone=UTC","root", "1234");
	}
	
	public static void muestraIngredientes() throws SQLException {
		
		Connection con = getConnection();
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("Select * from comidasana.ingredientes");
		
		while (rs.next()) {
			System.out.println(" Cod."+rs.getString("id")+" "+rs.getString("nombre"));
		}
		
		con.close();
	}

	
	public static void introducirIngredientesReceta() throws SQLException {
		
		System.out.println("Seleccione Receta: (Numero)");
		RecetaService.verReceta();
		
		System.out.println("Seleccione ingrediente: (Numero)");
		IngredienteService.verIngredientes();
		
		
	}
}



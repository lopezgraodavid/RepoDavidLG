package service;

import java.sql.SQLException;
import java.util.Scanner;
import database.RecetaDAO;

public class RecetaService {

	public static void verReceta() throws SQLException {
		//llamamos al a base de datos para que muestre las recetas
		RecetaDAO.encuentraReceta();
	}
	
	public static void crearReceta() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre de su receta: ");
		String receta = sc.nextLine();
		RecetaDAO.crearReceta(receta);
		
	}
	
}

package service;

import java.sql.SQLException;

import database.IngredientesDAO;

public class IngredienteService {
	
	public static void verIngredientes() throws SQLException {
		IngredientesDAO.muestraIngredientes();
	}

}

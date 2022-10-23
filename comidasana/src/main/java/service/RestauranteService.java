package service;

import java.sql.SQLException;

import database.RestauranteDAO;

public class RestauranteService {

	public static void verRestaurante() throws SQLException {
		RestauranteDAO.encuentraRestaurante();
	}
	
}

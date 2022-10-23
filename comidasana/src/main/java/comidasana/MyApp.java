package comidasana;

import java.sql.SQLException;

import view.MenuPrincipal;

public class MyApp {

	public static void main(String[] args) {
		try {
			MenuPrincipal.printMenuPrincipal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import service.RecetaService;
import service.RestauranteService;

public class MenuPrincipal {

	public static void printMenuPrincipal() throws SQLException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido a mi App, elige una opcion\n"
				+ "1-Ver recetas\n"
				+ "2-Crear receta\n"
				+ "3-Buscar restaurant\n"
				+ "4-Salir");
		int option = 0;
		try {
		option=sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Solo se permiten numeros");
		}
		
		
		
		switch (option) {
		case 1: RecetaService.verReceta(); printMenuPrincipal();break;
		case 2: RecetaService.crearReceta(); printMenuPrincipal();break;
		case 3: RestauranteService.verRestaurante();; printMenuPrincipal(); ;break;
		case 4: break;
		}
	}
	
}

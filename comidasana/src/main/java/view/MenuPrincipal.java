package view;

import java.util.Scanner;

import service.RecetaService;

public class MenuPrincipal {
	
	static RecetaService service = new RecetaService();

	@SuppressWarnings("static-access")
	public static void printMenuPrincipal() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenido a mi App, elige una opcion"
				+ "1-Ver recetas"
				+ "2-Crear receta"
				+ "3-Buscar restaurant");
		int option=sc.nextInt();
		
		sc.close();
		
		switch (option) {
		case 1: service.verReceta(); break;
		case 2: break;
		case 3: break;
		}
		
		printMenuPrincipal();
	}
	
}

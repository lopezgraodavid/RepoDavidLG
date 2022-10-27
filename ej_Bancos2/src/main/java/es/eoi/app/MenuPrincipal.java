package es.eoi.app;


import java.util.Scanner;
import es.eoi.service.ClienteService;

public class MenuPrincipal {
	
	public static void Menu() throws Exception {
		System.out.print("Introduzca su DNI: ");
		Scanner sc = new Scanner(System.in);
		String dni=sc.nextLine();
		
		System.out.println("Dinero total: " + ClienteService.getSaldoTotal(ClienteService.readCliente(dni)));

	}

}

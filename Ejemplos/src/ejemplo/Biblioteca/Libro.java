package ejemplo.Biblioteca;

import java.time.LocalDate;
import java.util.Scanner;

public class Libro extends Lectura implements Prestable{


	public Libro(int codigo, String titulo, LocalDate año) {
		super(codigo, titulo, año);
		this.prestado = false;
	}

	private boolean prestado;

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	@Override
	public void prestar(Lectura libro) {
		if (prestado == true) {
			System.out.println("No se puede prestar en este momento");
		}else {
			System.out.println("Libo prestado correctament.");
			prestado = true;
		}
		
	}

	@Override
	public void devolver(Lectura libro) {
		if (prestado == false) {
			System.out.println("Este libro no fue prestado aun");
		}else {
			System.out.println("Libo devuelto correctamente.");
			prestado = false;
		}
		
	}	
	
	public static void interfaz(Lectura libro) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Desea prestar o devolver este libro? ("+libro.getTitulo()+")\n1.-Prestar \n2.-Devolver");
		int select = sc.nextInt();
		switch (select) {
			case 1:
	//			prestar(libro);
				break;
			case 2:
		//		devolver(libro);
				break;
			default: 
				interfaz(libro);
				break;
		}

		sc.close();
	}
	

}
package ejemplo.Biblioteca;

import java.time.LocalDate;
import java.util.Scanner;

public class Libreria {
	
	
	public static void menu(Lectura lecturas[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Estos son las existencias que tenemos:");
		for(int exist = 0; exist < lecturas.length; exist++) {
			System.out.println("Cod. "+lecturas[exist].getCodigo()+"\tnombre:"+lecturas[exist].getTitulo());
		}
		System.out.println("¿Que libro desea alquilar? (introduzca codigo)");
		int eleccion = sc.nextInt();
		
		if(lecturas[eleccion] instanceof Revista) {
			System.out.println("Este producto no se puede prestar");
			menu(lecturas);
		} else {
			lecturas[eleccion].getCodigo();
			Libro.interfaz(lecturas[eleccion]);
		}
		
		if (eleccion != 0) {
		menu(lecturas);
		}
		
		sc.close();
	}
	

	public static void main(String[] args) {
		Lectura lecturas[] = inserts();

		menu(lecturas);
		
		
		
	}

	private static Lectura[] inserts() {
		
		Lectura lecturas[] = new Lectura[10];
		
		Revista[] revistas = 	{new Revista(1,"Maripili",LocalDate.now(),87),
								new Revista(2,"Salvame",LocalDate.now(),45),
								new Revista(3,"MotorSport",LocalDate.now(),12),
								new Revista(4,"Salud",LocalDate.now(),6),
								new Revista(5,"Musicales",LocalDate.now(),23)
								};
		
		lecturas[0] = revistas[0];
		lecturas[1] = revistas[1];
		lecturas[2] = revistas[2];
		lecturas[3] = revistas[3];
		lecturas[4] = revistas[4];

		
		Libro[] libros = 	{new Libro(6,"Una habitacion en babel",LocalDate.now()),
							new Libro(7,"Expediente X",LocalDate.now()),
							new Libro(8,"Los juegos del hambre",LocalDate.now()),
							new Libro(9,"Harry potter",LocalDate.now()),
							new Libro(10,"Bajando al moro",LocalDate.now())
							};
		lecturas[5] = libros[0];
		lecturas[6] = libros[1];
		lecturas[7] = libros[2];
		lecturas[8] = libros[3];
		lecturas[9] = libros[4];
		
		return lecturas;
	}


}

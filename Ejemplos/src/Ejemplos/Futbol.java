package Ejemplos;

public class Futbol {

	public static void main(String[] args) {
		SeleccionFutbol seleccion = new SeleccionFutbol();
		Futbolista futbolista1 = new Futbolista();
		Entrenador entrenador1 = new Entrenador();
		Masajista masajista1 = new Masajista();
		
		System.out.println(seleccion.nombre);
		System.out.println(futbolista1.nombre);
		System.out.println(entrenador1.nombre);
		System.out.println(masajista1.nombre);
		futbolista1.concentrarse();

	}

}

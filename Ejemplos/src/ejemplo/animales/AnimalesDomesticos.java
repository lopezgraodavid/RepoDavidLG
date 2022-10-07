package ejemplo.animales;

import java.util.Iterator;

public class AnimalesDomesticos {

	public static void main(String[] args) {
		Animal[] animales = new Animal[15];
		
		
		for (int cont = 0; cont < 5; cont++) {
			Perro perro= new Perro("perro"+cont,10+cont,100+3*cont);
			animales[cont] = perro;
		}
		
		for (int cont = 0; cont < 5; cont++) {
			Gato gato= new Gato("gato"+cont,10+cont,100+3*cont);
			animales[cont] = gato;
		}
		
		for (int cont = 0; cont < 5; cont++) {
			Raton raton= new Raton("raton"+cont,10+cont,100+3*cont);
			animales[cont] = raton;
		}

	}

}

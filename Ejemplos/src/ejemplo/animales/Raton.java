package ejemplo.animales;

public class Raton extends Animal {

	public Raton(String nombre, double peso, double altura) {
		super(nombre, peso, altura);
		// TODO Auto-generated constructor stub
	}
	
	public String tipoAnimal = "Raton";
	
	@Override
	public void Olfatear() {
		System.out.println(animales[RATON]+" esta olfateando");
	};


}

package ejemplo.animales;

public class Perro extends Animal {

	public Perro(String nombre, double peso, double altura) {
		super(nombre, peso, altura);
		// TODO Auto-generated constructor stub
	}

	public String tipoAnimal = "Perro";
	
	@Override
	public void Olfatear() {
		System.out.println(animales[PERRO]+" esta olfateando");
	};

	
}

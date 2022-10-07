package ejemplo.animales;

public class Gato extends Animal {

	public Gato(String nombre, double peso, double altura) {
		super( nombre, peso, altura);
		// TODO Auto-generated constructor stub
	}
	
	public String tipoAnimal = "Gato";
	
	@Override
	public void Olfatear() {
		System.out.println(animales[GATO]+" esta olfateando");
	};

}

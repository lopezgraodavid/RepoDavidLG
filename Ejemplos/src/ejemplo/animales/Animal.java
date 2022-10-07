package ejemplo.animales;

public abstract class Animal {
	
	public String[] animales = {"gato","perro","raton"};
	int GATO = 0;
	int PERRO = 1;
	int RATON = 2;
	
	String[] Gatos = {};
	String[] Perros = {};
	String[] Ratones = {};
	
	public String nombre;
	public double peso;
	public double altura;
	
	public Animal( String nombre, double peso, double altura) {
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
	}
	
	public void Olfatear () {
		System.out.print(animales+" esta olfateando.");
	}
	
	public void allAnimales() {
		
	}
	

}

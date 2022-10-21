package ejemplo.pokemon;

public class Bulbasaur extends Pokemon{
	
	
	
	public Bulbasaur(int code, int hp, int attack, int defense, String type) {
		super(code, hp, attack, defense, type);
	}

	public String avatar = "C://Imagen/bulbasour.jpg";
	
	@Override
	public void Attack() {
		System.out.println("Soy bulbasaur y hago "+attack*2+" puntos de daño");
	};
	
}

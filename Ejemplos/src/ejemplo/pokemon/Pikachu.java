package ejemplo.pokemon;

public class Pikachu extends Pokemon {

	public Pikachu(int code, int hp, int attack, int defense, String type) {
		super(code, hp, attack, defense, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Attack() {
		System.out.println("Soy pikachu y hago "+attack*1.5+" puntos de daño");
	};
	
	
}

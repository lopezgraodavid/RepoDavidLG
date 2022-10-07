package ejemplo.pokemon;
//al poner abstract, no podemos usarla para insertar datos, solo se usara para eredar a las clases hijas
public abstract class Pokemon {
	public int code;
	public int hp;
	public int attack;
	public int defense;
	public String type;
	
	public void Attack () {
		System.out.println("Hago: " +attack+ " puntos de daño");
	}
	
	public Pokemon(int code,int hp, int attack, int defense, String type) {
		super();
		this.code = code;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.type = type;
	}

		
		
}

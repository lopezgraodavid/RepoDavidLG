package ejemplo.pokemon;

public class Pokedex {

	public static void main(String[] args) {
		//polimosfirmo, esta variabl puede ser referenciada en bulbasaur, pokemon y objeto.
		Pokemon pokemon1 = new Bulbasaur(12, 35, 20, 23, "agua");
		Bulbasaur pokemon2= new Bulbasaur(10, 23, 20, 49, "agua");
		Object pokemon3 = new Pikachu(22, 45, 15, 19, "thunder");
		
		//Dependee de como lo definas, tendra otras configuraciones al poner el .
		pokemon1.Attack();
		pokemon2.Attack();
//		pokemon3.Attack(); //por eso no podemos acceder a Attack() debido a desde objtec no se vera ese metodo
//		Al estar en tipo object necesitamos especificarle que esa variable es un bulbasaur o pokemon
		((Pokemon)(pokemon3)).Attack();
		((Pikachu)(pokemon3)).Attack();
		

	}

}

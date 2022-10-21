package profesoresAlumnos;

public class Campus {
	
	public static Persona[] personas = new Persona[10];

	public static void main(String[] args) {
		
	initData();
	
		int i=0;
		int j=0;
		
		for (Persona persona : personas) {
			
			if(persona instanceof Estudiante) {
				i=i+1;
			}
			else if(persona instanceof Profesor) {				
				j=j+1;
			}
			
		}
		
		System.out.println("Tengo " + i + " estudiantes");
		System.out.println("Tengo " + j + " profesores");
		
	}

	private static void initData() {
		Direccion direccion1= new Direccion();
		direccion1.setCalle("C/Pepito");
		direccion1.setCiudad("Alicante");
		direccion1.setCodigoPostal("03565");
		direccion1.setPais("España");
		
		Direccion direccion2= new Direccion();
		direccion2.setCalle("C/pakito");
		direccion2.setCiudad("Murcia");
		direccion2.setCodigoPostal("03565");
		direccion2.setPais("España");
		
		double[] notas1=new double[5];
		notas1[0]=4.0;
		notas1[1]=6.0;
		notas1[2]=8.0;
		notas1[3]=2.0;
		notas1[4]=1.0;
		
		double[] notas2=new double[5];
		notas2[0]=7.0;
		notas2[1]=6.0;
		notas2[2]=8.0;
		notas2[3]=6.0;
		notas2[4]=9.0;
		
		Estudiante estudiante1= new Estudiante(
				"Jose",
				"Jimenez",
				676786876,
				"mail@gmail",
				direccion1,
				1,
				notas1
				);
		
		Estudiante estudiante2= new Estudiante(
				"Juanma",
				"Alcaraz",
				676786876,
				"mail@gmail",
				direccion2,
				1,
				notas2
				);
		
		Profesor profesor= new Profesor(
				"Pepe",
				"Perez",
				764374677,
				"mail@gmail",
				direccion1,
				25000,
				"Matematicas"
				);
		
		
		personas[0]=estudiante1;
		personas[1]=estudiante2;
//		personas[2]=estudiante;
//		personas[3]=estudiante;
//		personas[4]=estudiante;
		
		personas[2]=profesor;
	}

}

package profesoresAlumnos;

public class Estudiante extends Persona{





	public Estudiante(String nombre, String apellidos, int numTelefono, String email,
			Direccion direccion, int nºEstudiante, double[] notas) {
		super(nombre, apellidos, numTelefono, email, direccion);
		NºEstudiante = nºEstudiante;
		this.notas = notas;
	}





	int MATRICULA = 1;

	private int NºEstudiante;
	private double[] notas;
	
	
	
	public int getMATRICULA() {
		return MATRICULA;
	}

	public void setMATRICULA(int mATRICULA) {
		MATRICULA = mATRICULA;
	}

	public int getNºEstudiante() {
		return NºEstudiante;
	}

	public void setNºEstudiante(int nºEstudiante) {
		NºEstudiante = nºEstudiante;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public double calcularMedia() {
		double media = 0;
		int elementos=0;
		for (int notas = 0; notas < this.notas.length; notas++) {
			media = media + this.notas[notas];
			elementos = elementos+1;
		}
		if (elementos == 0) {
			return 0;
		}
		
		media = media / this.notas.length;
		return media;
	}
	
	public double  calcularMatrícula() {
		int precio = 0;
		for (int notas = 0; notas < this.notas.length; notas++) {
			if (this.notas[notas] < 5.0) {
				precio = precio + MATRICULA*200;
			} else {
				precio = precio + MATRICULA*100;
			}
		}
		return precio;
	}
	
	
}

package ejemplo.Biblioteca;

import java.time.LocalDate;

public class Revista extends Lectura{

	public Revista(int codigo, String titulo, LocalDate año, int numeroRevista) {
		super(codigo, titulo, año);
		this.numeroRevista = numeroRevista;
	}

	private int numeroRevista;

	public int getNumeroRevista() {
		return numeroRevista;
	}

	public void setNumeroRevista(int numeroRevista) {
		this.numeroRevista = numeroRevista;
	}
	

}
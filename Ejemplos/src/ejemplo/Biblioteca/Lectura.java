package ejemplo.Biblioteca;

import java.time.LocalDate;

public class Lectura {
	private int codigo;
	private String titulo;
	private LocalDate año;
	
	public Lectura(int codigo, String titulo, LocalDate año) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.año = año;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getAño() {
		return año;
	}

	public void setAño(LocalDate año) {
		this.año = año;
	}
	
	
	
}
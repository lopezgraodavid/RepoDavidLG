package model;

public class Ingrediente {
	private String nombre;
	
	private String calorias;
	
	private String descripcion;
	
	
	public Ingrediente(String nombre, String calorias, String descripcion) {
		super();
		this.nombre = nombre;
		this.calorias = calorias;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalorias() {
		return calorias;
	}

	public void setCalorias(String calorias) {
		this.calorias = calorias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}

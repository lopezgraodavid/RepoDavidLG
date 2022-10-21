package model;

import java.util.ArrayList;
import java.util.List;

public class Receta {
	private String nombre;
	
	private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	private String descripcion;


	public Receta(String nombre, List<Ingrediente> ingredientes, String descripcion) {
		super();
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}

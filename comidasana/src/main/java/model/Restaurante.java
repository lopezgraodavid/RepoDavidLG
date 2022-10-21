package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {

	private String nombre;
	
	private String direccion;
	
	private String teleefono;
	
	private String codigoPostal;
	
	private List<Receta> carta = new ArrayList();
	

	public Restaurante(String nombre, String direccion, String teleefono, String codigoPostal, List<Receta> carta) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.teleefono = teleefono;
		this.codigoPostal = codigoPostal;
		this.carta = carta;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTeleefono() {
		return teleefono;
	}

	public void setTeleefono(String teleefono) {
		this.teleefono = teleefono;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public List<Receta> getCarta() {
		return carta;
	}

	public void setCarta(List<Receta> carta) {
		this.carta = carta;
	}
	
	
	
	
}

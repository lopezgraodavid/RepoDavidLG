package es.eoi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "ej_bancos",name = "clientes")
public class Clientes {
	
	@Id
	@Column(name = "dni",unique=true,length = 9)
	private String dni;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@OneToMany
	private List<Cuentas> cuentas;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public List<Cuentas> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuentas> cuentas) {
		this.cuentas = cuentas;
	}

	


}

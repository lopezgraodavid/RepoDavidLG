package es.eoi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(schema = "ej_bancos",name = "bancos")
public class Bancos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@OneToMany(mappedBy = "banco",cascade = CascadeType.ALL)
	private List<Cuentas> cuentas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Cuentas> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuentas> cuentas) {
		this.cuentas = cuentas;
	}
	
	
	
	
}

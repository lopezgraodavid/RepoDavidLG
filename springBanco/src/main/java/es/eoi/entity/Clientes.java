package es.eoi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "ej_bancos",name = "clientes")
@Getter
@Setter
public class Clientes {
	
	@Id
	@Column(name = "dni",unique=true,length = 9)
	private String dni;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@OneToMany(mappedBy = "cliente")
	private List<Cuentas> cuentas;

}

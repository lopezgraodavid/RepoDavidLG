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

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(schema = "ej_bancos",name = "bancos")
@Getter
@Setter
public class Bancos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@OneToMany(mappedBy = "banco",cascade = CascadeType.ALL)
	private List<Cuentas> cuentas;

	
	
}

package edu.es.eoi.marketplace.entity;

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
@Table(name = "articulo")
@Getter
@Setter
public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private Double precio;
	
	@Column
	private Integer stock;
	
	@OneToMany(mappedBy = "articulo",cascade = CascadeType.ALL)
	private List<PedidoArticulo> transacciones;

}

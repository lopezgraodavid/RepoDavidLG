package edu.es.eoi.marketplace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedido_articulo")
@Getter
@Setter
public class PedidoArticulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idartiuclo",referencedColumnName = "id")
	private Articulo articulo;
	
	@Column 
	private Integer cantidad;
	
	@ManyToOne
	@JoinColumn(name = "idpedido",referencedColumnName = "id")
	private Pedido pedido;
	
	
}

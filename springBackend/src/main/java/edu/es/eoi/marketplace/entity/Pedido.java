package edu.es.eoi.marketplace.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "idusuario",referencedColumnName = "id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
	private List<PedidoArticulo> transacciones;


}

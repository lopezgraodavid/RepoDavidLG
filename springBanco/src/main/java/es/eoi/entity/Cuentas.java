package es.eoi.entity;

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
@Table(schema = "ej_bancos",name = "cuentas")
@Getter
@Setter
public class Cuentas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "saldo")
	private Double saldo;

	@ManyToOne
	@JoinColumn(name = "dnicliente",referencedColumnName = "dni")
	private Clientes cliente;
	
	@ManyToOne
	@JoinColumn(name = "idbanco",referencedColumnName = "id")
	private Bancos banco;
	
}

package es.eoi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "ej_bancos",name = "cuentas")
public class Cuentas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "saldo")
	private Double saldo;

	@ManyToOne
	@JoinColumn(name = "dnicliente",referencedColumnName = "dni")
	private Clientes cliente;
	
	@ManyToOne
	@JoinColumn(name = "idbanco",referencedColumnName = "id")
	private Bancos banco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Bancos getBanco() {
		return banco;
	}

	public void setBanco(Bancos banco) {
		this.banco = banco;
	}
	
	
	
}

package es.eoi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentasDto {
	
	private int id;
	
	private Double saldo;
	
	private String nombreBanco;
	
	private String nombreCliente;
	
}

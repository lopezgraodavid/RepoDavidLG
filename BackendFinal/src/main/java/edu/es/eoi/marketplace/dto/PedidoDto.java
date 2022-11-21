package edu.es.eoi.marketplace.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDto {

	private Integer id;
	
	private Date fecha;
	
	private String nombre;
	
	private List<PedidoArticuloDto> transacciones;
}

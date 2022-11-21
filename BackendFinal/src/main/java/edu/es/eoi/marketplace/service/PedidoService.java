package edu.es.eoi.marketplace.service;

import java.util.Date;
import java.util.List;

import edu.es.eoi.marketplace.dto.PedidoDto;

public interface PedidoService {

	List<PedidoDto> findAll();
	
	List<PedidoDto> findByName(String nombre);
	
	PedidoDto findById(Integer id);
	
	PedidoDto createPedido(String nombre, Integer iduser);
	
	PedidoDto deletePedido(Integer id);
	
	PedidoDto updatePedido(Date date,String nombre, Integer iduser);
}

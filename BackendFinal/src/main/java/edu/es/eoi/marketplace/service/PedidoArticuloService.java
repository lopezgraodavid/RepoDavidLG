package edu.es.eoi.marketplace.service;

import java.util.List;

import edu.es.eoi.marketplace.dto.PedidoArticuloDto;


public interface PedidoArticuloService {
	
	List<PedidoArticuloDto> findAll();
	
	PedidoArticuloDto findById(Integer id);

	PedidoArticuloDto createPedidoArticulo(Integer idPedido,Integer idArticulo, Integer numero);
	
	PedidoArticuloDto updatePedidoArticulo(Integer idPedido,Integer idArticulo, Integer numero);
	
	PedidoArticuloDto deleteById(Integer id);
	
}

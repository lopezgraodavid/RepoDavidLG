package edu.es.eoi.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.marketplace.dto.PedidoArticuloDto;
import edu.es.eoi.marketplace.service.PedidoArticuloService;

@RestController
@RequestMapping("/pedart")
public class PedidoArticuloController {

	@Autowired
	PedidoArticuloService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PedidoArticuloDto>> findAll() {
		List<PedidoArticuloDto> pedidodto = service.findAll();
		
		if (pedidodto!=null) {
			return new ResponseEntity<List<PedidoArticuloDto>>(pedidodto, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<PedidoArticuloDto>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	public ResponseEntity<PedidoArticuloDto> findById(Integer id) {

		if (id!=null) {
			PedidoArticuloDto pedidodto = service.findById(id);
			return new ResponseEntity<PedidoArticuloDto>(pedidodto, HttpStatus.OK);
		} else {
			return new ResponseEntity<PedidoArticuloDto>(HttpStatus.NO_CONTENT);
		}
	}
	
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PedidoArticuloDto> deleteById(@PathVariable Integer id) {
		PedidoArticuloDto dto = service.findById(id);
		
		if (dto!=null) {
			service.deleteById(id);
			return new ResponseEntity<PedidoArticuloDto>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<PedidoArticuloDto>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PedidoArticuloDto> create(@RequestParam Integer idPedido,@RequestParam Integer idArticulo,@RequestParam Integer numero) {
		
		if (idPedido != null && idArticulo != null) {
			PedidoArticuloDto dto = service.createPedidoArticulo(idPedido, idArticulo, numero);
			return new ResponseEntity<PedidoArticuloDto>(dto,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<PedidoArticuloDto>(HttpStatus.NOT_ACCEPTABLE);
		}

	}


	@RequestMapping(value ="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<PedidoArticuloDto> update(@RequestParam Integer id,@RequestParam Integer idPedido,@RequestParam Integer idArticulo,
													@RequestParam Integer numero,@PathVariable(name = "id") Integer idC) {
		if (idC == id) {
			PedidoArticuloDto dto = service.createPedidoArticulo(idPedido, idArticulo, numero);
			return new ResponseEntity<PedidoArticuloDto>(dto,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<PedidoArticuloDto>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}

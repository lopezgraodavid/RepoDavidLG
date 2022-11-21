package edu.es.eoi.marketplace.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.marketplace.dto.PedidoDto;
import edu.es.eoi.marketplace.service.PedidoArticuloService;
import edu.es.eoi.marketplace.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoService pedService;
	
	@Autowired
	PedidoArticuloService pedArtService;
	
//	GET marketplace /pedidos/{id}
//	Devolverá el pedido solicitado
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDto>> findAll() {
		List<PedidoDto> pedidodto = pedService.findAll();
		
		if (pedidodto!=null) {
			return new ResponseEntity<List<PedidoDto>>(pedidodto, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<PedidoDto>>(HttpStatus.NO_CONTENT);
		}
	}
	
	

	
//	GET marketplace /pedidos /{nombreparcial}/nombre
//	Devolverá la lista de pedidos que tengan el {nombreparcial}
	
	@RequestMapping(value = "/{nombre}", method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDto>> findByName(@PathVariable String nombre) {
		List<PedidoDto> pedidodto = pedService.findAll();
		
		if (pedidodto!=null) {
			return new ResponseEntity<List<PedidoDto>>(pedidodto, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<PedidoDto>>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	
//	DELETE marketplace /pedidos/{id}
//	Borra un pedido por id
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PedidoDto> deleteById(@PathVariable Integer id) {
		PedidoDto pedidodto = pedService.findById(id);
		
		if (pedidodto!=null) {
			pedService.deletePedido(id);
			return new ResponseEntity<PedidoDto>(pedidodto, HttpStatus.OK);
		} else {
			return new ResponseEntity<PedidoDto>(HttpStatus.NO_CONTENT);
		}
	}
	
//	POST marketplace /pedidos
//	Crea un nuevo pedido
	// IMPORTANTE, GESTIONAR PARA PODER INTRODUCIR EN UN MISMO POST TANTO EL PEDIDO COMO SUS ARTICULOS CONTENIDOS
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PedidoDto> createPedido(@RequestParam String nombre,@RequestParam Integer iduser) {
		if (nombre != null && iduser != null) {
			PedidoDto dto1 = pedService.createPedido(nombre,iduser);
			//PedidoArticuloDto dto2 = pedArtService.createPedidoArticulo(idproducto, cantidad, dto1.getId());
			return new ResponseEntity<PedidoDto>(dto1,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<PedidoDto>(HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	
//	PUT marketplace /pedidos({id}
//	Actualiza un pedido
	
	@RequestMapping(value ="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<PedidoDto> updatePedido(@RequestParam Integer id,@RequestParam Date date,@RequestParam String nombre,@RequestParam Integer iduser,@PathVariable(name = "id") Integer idC) {
		if (idC == id) {
			PedidoDto dto = pedService.updatePedido(date,nombre,iduser);
			return new ResponseEntity<PedidoDto>(dto,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<PedidoDto>(HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	
}

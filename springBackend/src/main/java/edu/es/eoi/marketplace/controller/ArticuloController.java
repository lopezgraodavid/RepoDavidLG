package edu.es.eoi.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.marketplace.dto.ArticuloDto;
import edu.es.eoi.marketplace.entity.Articulo;
import edu.es.eoi.marketplace.service.ArticuloService;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/articulo")
@Getter
@Setter
public class ArticuloController {
	
	@Autowired
	ArticuloService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ArticuloDto>> findAll() {
		List<ArticuloDto> articulodto = service.findAll();
		
		if (articulodto!=null) {
			return new ResponseEntity<List<ArticuloDto>>(articulodto, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<ArticuloDto>>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@RequestMapping(value = "/{nombre}", method = RequestMethod.GET)
	public ResponseEntity<List<ArticuloDto>> findByName(@PathVariable String nombre) {
		List<ArticuloDto> articulodto = service.findByName(nombre);
		
		if (articulodto!=null) {
			return new ResponseEntity<List<ArticuloDto>>(articulodto, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<ArticuloDto>>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ArticuloDto> createArticulo(@RequestBody Articulo articulo) {
		
		if (articulo != null) {
			ArticuloDto newarticulo = service.createArticulo(articulo);
			return new ResponseEntity<ArticuloDto>(newarticulo,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<ArticuloDto>(HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	
	@RequestMapping(value ="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<ArticuloDto> updateArticulo(@RequestBody Articulo articulo,@PathVariable(name ="id") Integer  id) {
		
		if (id==articulo.getId()) {
			ArticuloDto newarticulo = service.updateArticulo(articulo);
			return new ResponseEntity<ArticuloDto>(newarticulo,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<ArticuloDto>(HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	

}

package edu.es.eoi.marketplace.service;

import java.util.List;

import edu.es.eoi.marketplace.dto.ArticuloDto;
import edu.es.eoi.marketplace.entity.Articulo;

public interface ArticuloService {

	List<ArticuloDto> findAll();

	List<ArticuloDto> findByName(String nombre);
	
	ArticuloDto createArticulo(Articulo articulo);
	
	ArticuloDto updateArticulo(Articulo articulo);
}

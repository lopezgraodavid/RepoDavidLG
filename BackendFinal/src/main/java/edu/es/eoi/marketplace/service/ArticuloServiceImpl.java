package edu.es.eoi.marketplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplace.dto.ArticuloDto;
import edu.es.eoi.marketplace.entity.Articulo;
import edu.es.eoi.marketplace.repository.ArticuloRepository;
import lombok.Getter;
import lombok.Setter;


@Service
@Getter
@Setter
public class ArticuloServiceImpl implements ArticuloService{

	@Autowired
	private ArticuloRepository repository;
	
	@Override
	public List<ArticuloDto> findAll() {
		List<ArticuloDto> dtoList = null;
		ArticuloDto dto = null;
		
		if(!repository.findAll().isEmpty()) {
			dtoList = new ArrayList<ArticuloDto>();
			
			for (Articulo articulo : repository.findAll()) {
				dto = new ArticuloDto();
				BeanUtils.copyProperties(articulo, dto);
				dtoList.add(dto);
			}
		}
	
		return dtoList;
	}

	@Override
	public List<ArticuloDto> findByName(String nombre) {
		List<ArticuloDto> dtoList = null;
		ArticuloDto dto = null;
		
		if(!repository.findByNombre(nombre).isEmpty()) {
			dtoList = new ArrayList<ArticuloDto>();
			
			
			for (Articulo articulo : repository.findByNombre(nombre)) {
				dto = new ArticuloDto();
				BeanUtils.copyProperties(articulo, dto);
				dtoList.add(dto);
			}
		}
	
		return dtoList;
	}

	@Override
	public ArticuloDto createArticulo(Articulo articulo) {
		ArticuloDto dto = null;
		
		if (articulo != null) {
			dto = new ArticuloDto();
			repository.save(articulo);
			BeanUtils.copyProperties(articulo, dto);
		}
		
		return dto;
	}

	@Override
	public ArticuloDto updateArticulo(Articulo articulo) {
		ArticuloDto dto = null;
		
		if (articulo != null) {
			dto = new ArticuloDto();
			repository.save(articulo);
			BeanUtils.copyProperties(articulo, dto);
		}
		
		return dto;
	}

}

package edu.es.eoi.marketplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplace.dto.PedidoArticuloDto;
import edu.es.eoi.marketplace.entity.PedidoArticulo;
import edu.es.eoi.marketplace.repository.ArticuloRepository;
import edu.es.eoi.marketplace.repository.PedidoArticuloRepository;
import edu.es.eoi.marketplace.repository.PedidoRepository;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class PedidoArticuloServiceImpl implements PedidoArticuloService{

	@Autowired
	ArticuloRepository artRepo;
	
	@Autowired
	PedidoRepository pedRepo;
	
	@Autowired
	PedidoArticuloRepository pedArtRepo;
	
	
	@Override
	public List<PedidoArticuloDto> findAll() {
		List<PedidoArticuloDto> dtoList = null;
		PedidoArticuloDto dto = null;
		
		if(!pedArtRepo.findAll().isEmpty()) {
			dtoList = new ArrayList<PedidoArticuloDto>();
			
			for (PedidoArticulo articulo : pedArtRepo.findAll()) {
				dto = new PedidoArticuloDto();
				BeanUtils.copyProperties(articulo, dto);
				dtoList.add(dto);
			}
		}
	
		return dtoList;
	}
	
	
	@Override
	public List<PedidoArticuloDto> findByPedido(Integer id) {
		List<PedidoArticuloDto> dto = null;
		
		if(!pedArtRepo.findByPedido(pedRepo.findById(id).get()).isEmpty()) {
			
			for (PedidoArticulo pedArt : pedArtRepo.findByPedido(pedRepo.findById(id).get())) {
				
				dto = new ArrayList<PedidoArticuloDto>();
				BeanUtils.copyProperties(pedArt, dto);
			}

		}

		return dto;
	}
	
	
	
	@Override
	public PedidoArticuloDto findById(Integer id) {
		PedidoArticuloDto dto = null;
		
		if(pedArtRepo.findById(id).isPresent()) {
				PedidoArticulo pd = pedArtRepo.findById(id).get();
				dto = new PedidoArticuloDto();
				BeanUtils.copyProperties(pd, dto);
		}

		return dto;
	}
	
	
	@Override
	public PedidoArticuloDto createPedidoArticulo(Integer idPedido, Integer idArticulo, Integer numero) {
		PedidoArticulo pd = new PedidoArticulo();
		pd.setPedido(pedRepo.findById(idPedido).get());
		pd.setArticulo(artRepo.findById(idArticulo).get());
		pd.setCantidad(numero);
		PedidoArticuloDto dto = null;
		
		if (pd != null) {
			dto = new PedidoArticuloDto();
			pedArtRepo.save(pd);
			BeanUtils.copyProperties(pd, dto);
		}
		
		return dto;
	}

	@Override
	public PedidoArticuloDto updatePedidoArticulo(Integer idPedido, Integer idArticulo, Integer numero) {
		PedidoArticulo pd = new PedidoArticulo();
		pd.setPedido(pedRepo.findById(idPedido).get());
		pd.setArticulo(artRepo.findById(idArticulo).get());
		pd.setCantidad(numero);
		PedidoArticuloDto dto = null;
		
		if (pd != null) {
			dto = new PedidoArticuloDto();
			pedArtRepo.save(pd);
			BeanUtils.copyProperties(pd, dto);
		}
		
		return dto;
	}

	@Override
	public PedidoArticuloDto deleteById(Integer id) {
			PedidoArticuloDto dto = null;
			PedidoArticulo pd = pedArtRepo.findById(id).get();
			
			if(pd != null) {
				pedArtRepo.delete(pd);
				dto = new PedidoArticuloDto();
				BeanUtils.copyProperties(pd, dto);
			}

			return dto;
	}
	






	
	
}

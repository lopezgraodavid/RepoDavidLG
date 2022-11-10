package edu.es.eoi.marketplace.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplace.dto.PedidoArticuloDto;
import edu.es.eoi.marketplace.dto.PedidoDto;
import edu.es.eoi.marketplace.entity.Pedido;
import edu.es.eoi.marketplace.entity.PedidoArticulo;
import edu.es.eoi.marketplace.repository.PedidoArticuloRepository;
import edu.es.eoi.marketplace.repository.PedidoRepository;
import edu.es.eoi.marketplace.repository.UsuarioRepository;
@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	UsuarioRepository repositoryUser;
	
	@Autowired
	PedidoArticuloRepository pedArtRepository;

	
	@Override
	public List<PedidoDto> findAll() {
		List<PedidoDto> dtoList = null;

		PedidoDto dto = null;
		
		if(!pedidoRepository.findAll().isEmpty()) {
			dtoList = new ArrayList<PedidoDto>();
			
			for (Pedido pedido : pedidoRepository.findAll()) {
				dto = new PedidoDto();
				BeanUtils.copyProperties(pedido, dto);
				
				List<PedidoArticuloDto> pedArtDtoList = null;
				PedidoArticuloDto pedArtDto = null;
				if (!pedArtRepository.findByPedido(pedido).isEmpty()){
					pedArtDtoList = new ArrayList<PedidoArticuloDto>();
					
					for (PedidoArticulo pedArt : pedArtRepository.findByPedido(pedido)) {
						pedArtDto = new PedidoArticuloDto();
						BeanUtils.copyProperties(pedArt, pedArtDto);
						pedArtDtoList.add(pedArtDto);
					}

					dto.setTransacciones(pedArtDtoList);
				}
				dtoList.add(dto);
			}
		}
		return dtoList;
	}

	@Override
	public List<PedidoDto> findByName(String nombre) {
		List<PedidoDto> dtoList = null;
		PedidoDto dto = null;
		
		if(!pedidoRepository.findByNombre(nombre).isEmpty()) {
			dtoList = new ArrayList<PedidoDto>();
			
			for (Pedido pedido : pedidoRepository.findByNombre(nombre)) {
				dto = new PedidoDto();
				BeanUtils.copyProperties(pedido, dto);
				
				
				List<PedidoArticuloDto> pedArtDtoList = null;
				PedidoArticuloDto pedArtDto = null;
				if (!pedArtRepository.findByPedido(pedido).isEmpty()){
					pedArtDtoList = new ArrayList<PedidoArticuloDto>();
					
					for (PedidoArticulo pedArt : pedArtRepository.findByPedido(pedido)) {
						pedArtDto = new PedidoArticuloDto();
						BeanUtils.copyProperties(pedArt, pedArtDto);
						pedArtDtoList.add(pedArtDto);
					}

					dto.setTransacciones(pedArtDtoList);
				}
				
				dtoList.add(dto);
			}
		}
		return dtoList;
	}

	@Override
	public PedidoDto findById(Integer id) {

		PedidoDto dto = null;
		
		if(pedidoRepository.findById(id).isPresent()) {
			Pedido pedido = pedidoRepository.findById(id).get();
			dto = new PedidoDto();
			BeanUtils.copyProperties(pedido, dto);
			
			
			List<PedidoArticuloDto> pedArtDtoList = null;
			PedidoArticuloDto pedArtDto = null;
			if (!pedArtRepository.findByPedido(pedido).isEmpty()){
				pedArtDtoList = new ArrayList<PedidoArticuloDto>();
				
				for (PedidoArticulo pedArt : pedArtRepository.findByPedido(pedido)) {
					pedArtDto = new PedidoArticuloDto();
					BeanUtils.copyProperties(pedArt, pedArtDto);
					pedArtDtoList.add(pedArtDto);
				}

				dto.setTransacciones(pedArtDtoList);
			}

			dto.setTransacciones(pedArtDtoList);
			
		}
		
		return dto;
	}

	@Override
	public PedidoDto createPedido(String nombre, Integer iduser) {
		Pedido pedido = new Pedido();
		PedidoDto dto = null;
		
		if(nombre != null && iduser != null) {
			
			LocalDate localDate = LocalDate.now();
			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			
			
			pedido.setUsuario(repositoryUser.findById(iduser).get());
			pedido.setNombre(nombre);
			pedido.setFecha(date);

			pedidoRepository.save(pedido);
			dto = new PedidoDto();
			BeanUtils.copyProperties(pedido, dto);
			
		}
		
		return dto;
	}

	@Override
	public PedidoDto deletePedido(Integer id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		
		PedidoDto dto = null;
		
		if(pedido != null) {
			pedidoRepository.delete(pedido);
			dto = new PedidoDto();
			BeanUtils.copyProperties(pedido, dto);
		}
		
		return dto;

	}

	@Override
	public PedidoDto updatePedido(Date date,String nombre, Integer iduser) {
		Pedido pedido = null;
		PedidoDto dto = null;
		
		if(nombre != null && iduser != null) {
			pedido = new Pedido();
			
			pedido.setUsuario(repositoryUser.findById(iduser).get());
			pedido.setNombre(nombre+pedido.getUsuario().getNombre());
			
			if(date != null) {
				pedido.setFecha(date);
			}

			pedidoRepository.save(pedido);
			dto = new PedidoDto();
			BeanUtils.copyProperties(pedido, dto);
		}
		
		return dto;
	}


}

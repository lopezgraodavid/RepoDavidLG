package es.eoi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.dto.ClientesDto;
import es.eoi.entity.Clientes;
import es.eoi.repository.ClientesRepository;

@Service
public class ClientesService {
	
	@Autowired
	ClientesRepository repository;
	

	public ClientesDto findByDni(String pk) {

		ClientesDto dto= null;
		
		Optional<Clientes> entity = repository.findById(pk);
		
		if(entity.isPresent()) {			
			dto=new ClientesDto();
			BeanUtils.copyProperties(entity.get(), dto);
		}
		
		return dto;
	}

	public List<ClientesDto> findAll() {
		List<ClientesDto> dtolist = new ArrayList<ClientesDto>();
		
		List<Clientes> clientList = repository.findAll();

		for(Clientes cliente : clientList) {
			ClientesDto dto= new ClientesDto();
			BeanUtils.copyProperties(cliente, dto);
			dtolist.add(dto);
		}
		
		return dtolist;
	}

	public ClientesDto createClient(String dni,String name, String address) {
	
		Clientes newclient = new Clientes();
		newclient.setDni(dni);
		newclient.setNombre(name);
		newclient.setDireccion(address);
		
		ClientesDto dto= null;
		
		if (newclient != null) {
			repository.save(newclient);		
			dto=new ClientesDto();
			BeanUtils.copyProperties(newclient, dto);			
		}
		return dto;
	}
	
	public ClientesDto updateClient(String dni,String name, String address) {
		
		
		Clientes newclient = new Clientes();
		newclient.setDni(dni);
		newclient.setNombre(name);
		newclient.setDireccion(address);
		
		ClientesDto dto= null;
		if (newclient != null) {
			repository.save(newclient);		
			dto=new ClientesDto();
			BeanUtils.copyProperties(newclient, dto);			
		}
		return dto;
	}
	
	public ClientesDto deleteClientByDni(String dni) {
		
		ClientesDto dto= null;
		Clientes delclient = repository.findById(dni).get();
		if(delclient != null) {
			dto= new ClientesDto();
			BeanUtils.copyProperties(delclient, dto);
			repository.delete(delclient);
		} 

		return dto;
	}


}

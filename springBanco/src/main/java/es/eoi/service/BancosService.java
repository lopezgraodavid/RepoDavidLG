package es.eoi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.dto.BancosDto;
import es.eoi.entity.Bancos;
import es.eoi.repository.BancosRepository;

@Service
public class BancosService {

	@Autowired
	BancosRepository repository;
	
	public BancosDto findById(Integer pk) {

		BancosDto dto= null;
		
		Optional<Bancos> entity = repository.findById(pk);
		
		if(entity.isPresent()) {			
			dto=new BancosDto();
			BeanUtils.copyProperties(entity.get(), dto);
		}
		
		return dto;
	}

	public List<BancosDto> findAll() {
		List<BancosDto> dtolist = new ArrayList<BancosDto>();
		
		List<Bancos> bankList = repository.findAll();

		for(Bancos banke : bankList) {
			BancosDto dto= new BancosDto();
			BeanUtils.copyProperties(banke, dto);
			dtolist.add(dto);
		}
		
		return dtolist;
	}

	public BancosDto createBank(String name, String address) {
	
		Bancos newbank = new Bancos();
		newbank.setNombre(name);
		newbank.setCiudad(address);

		
		BancosDto dto = null;
		
		if (newbank != null) {
			repository.save(newbank);
			dto=new BancosDto();
			BeanUtils.copyProperties(newbank, dto);			
		}
		return dto;
	}

	public BancosDto updateBank(Integer id,String name, String address) {
		
		Bancos newbank = new Bancos();
		newbank.setId(id);
		newbank.setNombre(name);
		newbank.setCiudad(address);
		
		BancosDto dto= null;
		if (newbank != null) {
			repository.save(newbank);		
			dto=new BancosDto();
			BeanUtils.copyProperties(newbank, dto);			
		}
		return dto;
	}
	
	public BancosDto deleteBankById(Integer id) {
		
		BancosDto dto= null;
		Bancos delbank = repository.findById(id).get();
		if(delbank != null) {
			dto= new BancosDto();
			BeanUtils.copyProperties(delbank, dto);
			repository.delete(delbank);
		} 

		return dto;
	}
		
}

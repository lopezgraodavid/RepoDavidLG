package edu.es.eoi.marketplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplace.dto.UsuarioDto;
import edu.es.eoi.marketplace.entity.Usuario;
import edu.es.eoi.marketplace.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public List<UsuarioDto> findAll() {
		List<UsuarioDto> dtoList = null;
		List<Usuario> userlist = repository.findAll();
		
		if (userlist != null) {
			dtoList = new ArrayList<UsuarioDto>();
			
			for (Usuario usuario : userlist) {
				UsuarioDto userdto = new UsuarioDto();
				BeanUtils.copyProperties(usuario, userdto);
				dtoList.add(userdto);
			}

		}

		return dtoList;
	}
	
	@Override
	public UsuarioDto findById(Integer id) {
		UsuarioDto dto = null;
		Usuario user = repository.findById(id).get();
		
		if (user != null) {
			dto = new UsuarioDto();
			BeanUtils.copyProperties(user, dto);
		}

		return dto;
	}

	@Override
	public UsuarioDto createUsuario(Usuario user) {
		UsuarioDto dto = null;
		
		if (user != null) {
			dto = new UsuarioDto();
			repository.save(user);
			BeanUtils.copyProperties(user, dto);

		}

		return dto;
	}

	@Override
	public UsuarioDto updateUsuario(Usuario user) {
		UsuarioDto dto = null;
		
		if (user != null) {
			dto = new UsuarioDto();
			repository.save(user);
			BeanUtils.copyProperties(user, dto);
		}

		return dto;
	}

	@Override
	public UsuarioDto login(String username, String password) {
		UsuarioDto dto = null;
		Usuario user = null;
		try {
			user = repository.findByNombre(username).get();
		} catch (java.util.NoSuchElementException e) {
			user = null;
		}

		
		
		
		if (user != null) {
			if(user.getPassword().equals(password)) {
				dto = new UsuarioDto();
				BeanUtils.copyProperties(user, dto);
			}
		}
		return dto;
	}

	
	
	
	
}

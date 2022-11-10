package edu.es.eoi.marketplace.service;

import java.util.List;

import edu.es.eoi.marketplace.dto.UsuarioDto;
import edu.es.eoi.marketplace.entity.Usuario;

public interface UsuarioService {
	
	List<UsuarioDto> findAll();

	UsuarioDto findById(Integer id);
	
	UsuarioDto createUsuario(Usuario user);
	
	UsuarioDto updateUsuario(Usuario user);
	
	UsuarioDto login(String username, String password);
	
}

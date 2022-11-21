package edu.es.eoi.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.marketplace.dto.UsuarioDto;
import edu.es.eoi.marketplace.entity.Usuario;
import edu.es.eoi.marketplace.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	

//	@Autowired
//	ClientRepository repository;
	
	@Autowired
	UsuarioService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDto> findById(@PathVariable Integer id) {
		UsuarioDto userdto = service.findById(id);
		
		if (userdto!=null) {
			return new ResponseEntity<UsuarioDto>(userdto, HttpStatus.OK);
		} else {
			return new ResponseEntity<UsuarioDto>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDto>> findAll() {
		
		List<UsuarioDto> users = service.findAll();
		
		if(users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<UsuarioDto>>(users, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UsuarioDto> addClient(@RequestBody Usuario user) {

		if(user==null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			UsuarioDto userdto = service.createUsuario(user);
			return new ResponseEntity<UsuarioDto>(userdto,HttpStatus.ACCEPTED);
		}
		
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<UsuarioDto> updateClient(@RequestBody Usuario user,@PathVariable(name = "id")Integer id) {

		if(id==user.getId()) {
			UsuarioDto userdto = service.updateUsuario(user);
			return new ResponseEntity<UsuarioDto>(userdto,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<UsuarioDto> deleteClientt(@RequestParam String username,@RequestParam String password) {
		
		if (username != null) {
			UsuarioDto userdto = service.login(username, password);
			if (userdto !=null) {
				return new ResponseEntity<UsuarioDto>(userdto,HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<UsuarioDto>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
		}
	}
	

}

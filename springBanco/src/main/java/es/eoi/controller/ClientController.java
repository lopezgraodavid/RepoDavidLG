package es.eoi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.dto.ClientesDto;
import es.eoi.entity.Clientes;
import es.eoi.service.ClientesService;

@RestController
@RequestMapping("/clientes")
public class ClientController {
	
//	@Autowired
//	ClientRepository repository;
	
	@Autowired
	ClientesService service;
	
	@RequestMapping(value = "/{dni}", method = RequestMethod.GET)
	public ResponseEntity<ClientesDto> findByDni(@PathVariable String dni) {

		ClientesDto client = service.findByDni(dni);
		
		if (client!=null) {
			return new ResponseEntity<ClientesDto>(client, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientesDto>> findAll() {
		
		List<ClientesDto> clients = service.findAll();
		
		if(clients.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ClientesDto>>(clients, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ClientesDto> addClient(@RequestParam String dni, @RequestParam String name, @RequestParam String address) {

		if(dni==null || name==null || address==null || dni=="" || name=="" || address=="") {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			ClientesDto client = service.createClient(dni, name, address);
			return new ResponseEntity<ClientesDto>(client,HttpStatus.ACCEPTED);
		}
		
	}

	@RequestMapping(value = "/{dni}",method = RequestMethod.PUT)
	public ResponseEntity<ClientesDto> updateClient(@RequestParam String dni, @RequestParam String name, @RequestParam String address,@PathVariable(name = "dni")String nif) {

		if(nif.equals(dni)) {
			ClientesDto clientDto = service.updateClient(dni,name,address);
			return new ResponseEntity<ClientesDto>(clientDto,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
	
	@RequestMapping(value = "/{dni}",method = RequestMethod.DELETE)
	public ResponseEntity<Clientes> deleteClientt(@PathVariable(name = "dni") String dni) {
		
		ClientesDto client = service.findByDni(dni);
		
		if (client != null) {
			service.deleteClientByDni(dni);
			return new ResponseEntity<Clientes>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Clientes>(HttpStatus.NOT_FOUND);
		}
	}

}

package es.eoi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.eoi.dto.CuentasDto;
import es.eoi.service.CuentasService;

@Controller
@RequestMapping("/cuentas")
public class CuentasController {

	@Autowired
	CuentasService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CuentasDto> findByDni(@PathVariable Integer id) {

		CuentasDto account = service.findById(id);
		
		if (account!=null) {
			return new ResponseEntity<CuentasDto>(account, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CuentasDto>> findAll() {
		
		List<CuentasDto> accounts = service.findAll();
		
		if(accounts.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<CuentasDto>>(accounts, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CuentasDto> addAccount(@RequestParam Double saldo, @RequestParam  Integer idBank , @RequestParam String dniClient) {
		if( idBank==null || dniClient==null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			CuentasDto account = service.createAccount(saldo,dniClient,idBank);
			return new ResponseEntity<CuentasDto>(account,HttpStatus.ACCEPTED);
		}
		
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<CuentasDto> updateAccount(@RequestParam Integer id, @RequestParam Double saldo, 
													@RequestParam  Integer idBank , @RequestParam String dniClient,
													@PathVariable(name = "id") Integer idC) {

		if(idC == id) {
			CuentasDto accountDto = service.updateAccount(id,saldo,dniClient,idBank);
			return new ResponseEntity<CuentasDto>(accountDto,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}


	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<CuentasDto> deleteAccountt(@PathVariable(name = "id") Integer id) {
		
		CuentasDto account = service.findById(id);
		
		if (account != null) {
			service.deleteAccountById(id);
			return new ResponseEntity<CuentasDto>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<CuentasDto>(HttpStatus.NOT_FOUND);
		}
	}
	
}

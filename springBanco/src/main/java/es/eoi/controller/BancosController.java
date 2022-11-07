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

import es.eoi.dto.BancosDto;
import es.eoi.service.BancosService;
@RestController
@RequestMapping("/bancos")
public class BancosController {
	
	@Autowired
	BancosService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BancosDto> findByDni(@PathVariable Integer id) {

		BancosDto bank = service.findById(id);
		
		if (bank!=null) {
			return new ResponseEntity<BancosDto>(bank, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BancosDto>> findAll() {
		
		List<BancosDto> banks = service.findAll();
		
		if(banks.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<BancosDto>>(banks, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BancosDto> addBank(@RequestParam String name, @RequestParam String address) {
		if( name==null || address==null || name.equals("") || address.equals("")) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			BancosDto bank = service.createBank(name, address);
			return new ResponseEntity<BancosDto>(bank,HttpStatus.ACCEPTED);
		}
		
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<BancosDto> updateBank(@RequestParam Integer id, @RequestParam String name, @RequestParam String address,@PathVariable(name = "id") Integer idC) {

		if(idC == id) {
			BancosDto bankDto = service.updateBank(id,name,address);
			return new ResponseEntity<BancosDto>(bankDto,HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}


	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<BancosDto> deleteBankt(@PathVariable(name = "id") Integer id) {
		
		BancosDto bank = service.findById(id);
		
		if (bank != null) {
			service.deleteBankById(id);
			return new ResponseEntity<BancosDto>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<BancosDto>(HttpStatus.NOT_FOUND);
		}
	}
	
}

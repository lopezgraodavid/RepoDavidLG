package es.eoi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.dto.CuentasDto;
import es.eoi.entity.Bancos;
import es.eoi.entity.Clientes;
import es.eoi.entity.Cuentas;
import es.eoi.repository.BancosRepository;
import es.eoi.repository.ClientesRepository;
import es.eoi.repository.CuentasRepository;

@Service
public class CuentasService {

	@Autowired
	CuentasRepository accountRepository;
	
	@Autowired
	BancosRepository bankRepository;
	
	@Autowired
	ClientesRepository clientRepository;

	
	public CuentasDto findById(Integer pk) {

		CuentasDto dto= null;
		
		Optional<Cuentas> entity = accountRepository.findById(pk);
		
		if(entity.isPresent()) {			
			dto=new CuentasDto();
			BeanUtils.copyProperties(entity.get(), dto);
			dto.setNombreBanco(entity.get().getCliente().getNombre());
			dto.setNombreCliente(entity.get().getBanco().getNombre());
		}
		
		return dto;
	}

	public List<CuentasDto> findAll() {
		List<CuentasDto> dtolist = new ArrayList<CuentasDto>();
		
		List<Cuentas> accountList = accountRepository.findAll();

		for(Cuentas account : accountList) {
			CuentasDto dto= new CuentasDto();
			BeanUtils.copyProperties(account, dto);
			dto.setNombreBanco(account.getBanco().getNombre());
			dto.setNombreCliente(account.getCliente().getNombre());
			dtolist.add(dto);
		}
		
		return dtolist;
	}

	public CuentasDto createAccount(Double saldo, String dniClient, Integer Bank) {
	
		
		Clientes client = clientRepository.findById(dniClient).get();
		Bancos bank = bankRepository.findById(Bank).get();

		Cuentas newaccount = new Cuentas();
		newaccount.setSaldo(saldo);
		newaccount.setCliente(client);
		newaccount.setBanco(bank);
			
		CuentasDto dto = null;
			
		if (newaccount != null || client != null || bank != null) {
			accountRepository.save(newaccount);
			dto=new CuentasDto();
			BeanUtils.copyProperties(newaccount, dto);
			dto.setNombreBanco(newaccount.getBanco().getNombre());
			dto.setNombreCliente(newaccount.getCliente().getNombre());
		}
		return dto;	
		
	}

	public CuentasDto updateAccount(Integer id,Double saldo, String dniClient, Integer Bank) {
		
		Clientes client = clientRepository.findById(dniClient).get();
		Bancos bank = bankRepository.findById(Bank).get();
		
		Cuentas newaccount = new Cuentas();
		newaccount.setId(id);
		newaccount.setSaldo(saldo);
		newaccount.setCliente(client);
		newaccount.setBanco(bank);

		
		CuentasDto dto= null;
		if (newaccount != null || client != null || bank != null) {
			accountRepository.save(newaccount);		
			dto=new CuentasDto();
			BeanUtils.copyProperties(newaccount, dto);
			dto.setNombreBanco(newaccount.getBanco().getNombre());
			dto.setNombreCliente(newaccount.getCliente().getNombre());
		}
		return dto;
	}
	
	public CuentasDto deleteAccountById(Integer id) {
		
		CuentasDto dto= null;
		Cuentas delaccount = accountRepository.findById(id).get();
		if(delaccount != null) {
			dto= new CuentasDto();
			BeanUtils.copyProperties(delaccount, dto);
			accountRepository.delete(delaccount);
		} 

		return dto;
	}
	
	
}

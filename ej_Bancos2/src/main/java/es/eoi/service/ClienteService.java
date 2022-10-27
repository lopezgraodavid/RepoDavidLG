package es.eoi.service;

import es.eoi.dao.ClientesDAO;
import es.eoi.entity.Clientes;
import es.eoi.entity.Cuentas;

public class ClienteService {
	
	static ClientesDAO clientedao = new ClientesDAO();

	public static double getSaldoTotal(Clientes cliente) {
		
		double total=0;
		
		System.out.println(cliente);
		
		for (Cuentas cuenta : cliente.getCuentas()) {
			total=total+cuenta.getSaldo();
		}
		
		return total;
		
	}
	
	public static Clientes readCliente(String dni) throws Exception {
		return clientedao.read(dni);
		
	}
	
}

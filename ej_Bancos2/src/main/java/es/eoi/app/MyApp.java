package es.eoi.app;

import java.util.List;

import es.eoi.dao.BancosDAO;
import es.eoi.dao.ClientesDAO;
import es.eoi.dao.CuentasDAO;
import es.eoi.entity.Bancos;
import es.eoi.entity.Clientes;
import es.eoi.entity.Cuentas;

public class MyApp {
	
	public static ClientesDAO clientedao = new ClientesDAO();
	public static BancosDAO bancodao = new BancosDAO();
	public static CuentasDAO cuentadao = new CuentasDAO();

	public static void main(String[] args) throws Exception {

		MenuPrincipal.Menu();
		
//		Clientes cliente1 = new Clientes();
//		cliente1.setDni("1122");
//		cliente1.setNombre("pedro");
//		cliente1.setDireccion("Casa pedro");
//	
//		Clientes cliente2 = new Clientes();
//		cliente2.setDni("1111");
//		cliente2.setNombre("Paco");
//		cliente2.setDireccion("Casa paco");
//		
//		Clientes cliente3 = new Clientes();
//		cliente3.setDni("2222");
//		cliente3.setNombre("Alicia");
//		cliente3.setDireccion("Casa Alicia");
//
//		Clientes cliente4 = new Clientes();
//		cliente4.setDni("2211");
//		cliente4.setNombre("Marta");
//		cliente4.setDireccion("Casa Marta");
//		
//		Clientes cliente5 = new Clientes();
//		cliente5.setDni("1112");
//		cliente5.setNombre("Mario");
//		cliente5.setDireccion("Casa Mario");
//		
//		
//		
//		Bancos banco1 = new Bancos();
//		banco1.setNombre("Sabadell");
//		banco1.setCiudad("Orihuela");
//
//		Bancos banco2 = new Bancos();
//		banco2.setNombre("Cam");
//		banco2.setCiudad("Orihuela");
//
//		Bancos banco3 = new Bancos();
//		banco3.setNombre("ToMoney");
//		banco3.setCiudad("Alicante");
//		
//		Bancos banco4 = new Bancos();
//		banco4.setNombre("Bankia");
//		banco4.setCiudad("Elche");
//		
//		Bancos banco5 = new Bancos();
//		banco5.setNombre("BBVA");
//		banco5.setCiudad("Orihuela");
//
//		Cuentas cuenta1 = new Cuentas();
//		cuenta1.setCliente(cliente1);
//		cuenta1.setBanco(banco1);
//		cuenta1.setSaldo(4350.50);
//
//		Cuentas cuenta2 = new Cuentas();
//		cuenta2.setCliente(cliente1);
//		cuenta2.setBanco(banco2);
//		cuenta2.setSaldo(67.50);
//		
//		Cuentas cuenta3 = new Cuentas();
//		cuenta3.setCliente(cliente3);
//		cuenta3.setBanco(banco4);
//		cuenta3.setSaldo(1789.26);
//
//		Cuentas cuenta4 = new Cuentas();
//		cuenta4.setCliente(cliente5);
//		cuenta4.setBanco(banco1);
//		cuenta4.setSaldo(960.75);
//		
//		Cuentas cuenta5 = new Cuentas();
//		cuenta5.setCliente(cliente2);
//		cuenta5.setBanco(banco3);
//		cuenta5.setSaldo(1350.50);
//
//		/////////////////PARTE CLIENTES/////////////////////
//		
//		//INSERTAR CLIENTES:
//		
//		clientedao.create(cliente1);
//		clientedao.create(cliente2);
//		clientedao.create(cliente3);
//		clientedao.create(cliente4);
//		clientedao.create(cliente5);
//		//VISUZALIAR CLIENTES:
//		
//		System.out.println(clientedao.read(cliente2.getDni()));
//		
//		//MOSTRAR TODOS LOS CLIENTES
//		
//		System.out.println(clientedao.findAll());
//		
//		//MODIFICAR CLIENTES:
//		
//		Clientes modCliente = clientedao.read("1112");
//		modCliente.setNombre("Mod");
//		
//		clientedao.update(modCliente);
//		
//		//ELIMINAR CLIENTES:
//		
////		clientedao.delete("1122");
////		clientedao.delete("1112");
////		clientedao.delete("1111");
////		clientedao.delete("2222");
////		clientedao.delete("2211");
//		
//		
//		/////////////////PARTE BANCOS/////////////////////
//		
//		
//		//INSERTAR BANCOS:
//		
//		bancodao.create(banco1);
//		bancodao.create(banco2);
//		bancodao.create(banco3);
//		bancodao.create(banco4);
//		bancodao.create(banco5);
//		
//		//VISUALIZAR BANCO:
//		
//		System.out.println(bancodao.read(banco2.getId()));
//		
//		//VISUALIZAR TODOS LOS BANCOS:
//		
//		System.out.println(bancodao.findAll());
//		
//		//MODIFICAR BANCO:
//		
//		Bancos modBanco = bancodao.read(banco1.getId());
//		modBanco.setNombre("mod");
//		
//		bancodao.update(modBanco);
//
////		modBanco = bancodao.read(banco1.getId());
////		modBanco.setNombre("caja rural");
////		
////		bancodao.update(modBanco);
//		
//		//ELIMINAR BANCO:
//		
////		bancodao.delete(banco1.getId());
////		bancodao.delete(banco2.getId());
////		bancodao.delete(banco3.getId());
////		bancodao.delete(banco4.getId());
////		bancodao.delete(banco5.getId());
//		
//		
//		/////////////////PARTE CUENTAS/////////////////////
//		
//		//INSERTAR CUENTAS:
//		
//		cuentadao.create(cuenta1);
//		cuentadao.create(cuenta2);
//		cuentadao.create(cuenta3);
//		cuentadao.create(cuenta4);
//		cuentadao.create(cuenta5);
//		
//		//VER CUENTA:
//		
//		System.out.println(cuentadao.read(cuenta1.getId()));
//		
//		//VER TODAS LAS CUENTAS:
//		
//		System.out.println(cuentadao.findAll());
//		
//		//MODIFICAR CUENTAS:
//		Cuentas modCuenta = cuentadao.read(cuenta1.getId());
//		modCuenta.setCliente(cliente3);
//		cuentadao.update(modCuenta);
//		
//		//ELIMINAR CUENTAS:
//		
////		cuentadao.delete(cuenta1.getId());
////		cuentadao.delete(cuenta2.getId());
////		cuentadao.delete(cuenta3.getId());
////		cuentadao.delete(cuenta4.getId());
////		cuentadao.delete(cuenta5.getId());
//
//		
//		//VER CUENTAS DE UN BANCO:
//		
//		List<Cuentas> cuentasbanco1 = cuentadao.cuentasBanco(banco1.getId());
//		System.out.println(cuentasbanco1);
//		System.out.println(cuentasbanco1.get(0).getBanco().getNombre());
//		
//		//VER CUENTAS DE UN USUARIO:
//		List<Cuentas> cuentascliente1 = cuentadao.cuentasCliente(cliente3.getDni());
//		System.out.println(cuentascliente1);
//		System.out.println(cuentasbanco1.get(0).getCliente().getNombre());
//		
//		//CLIENTES Y SUS CUENTAS:
//		System.out.println(cuentadao.clientesYcuentas());
//		
//		
//		//BORRAR TODO:
//		
//		cuentadao.delete(cuenta1.getId());
//		cuentadao.delete(cuenta2.getId());
//		cuentadao.delete(cuenta3.getId());
//		cuentadao.delete(cuenta4.getId());
//		cuentadao.delete(cuenta5.getId());
//		
//		bancodao.delete(banco1.getId());
//		bancodao.delete(banco2.getId());
//		bancodao.delete(banco3.getId());
//		bancodao.delete(banco4.getId());
//		bancodao.delete(banco5.getId());
//		
//		clientedao.delete(cliente1.getDni());
//		clientedao.delete(cliente2.getDni());
//		clientedao.delete(cliente3.getDni());
//		clientedao.delete(cliente4.getDni());
//		clientedao.delete(cliente5.getDni());
		


		
	}

}

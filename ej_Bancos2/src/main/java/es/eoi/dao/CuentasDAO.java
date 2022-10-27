package es.eoi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.eoi.entity.Cuentas;

public class CuentasDAO {
	
	private EntityManager manager = Persistence.createEntityManagerFactory("Ej_Bancos").createEntityManager();
	
	
	@SuppressWarnings("unchecked")
	public List<Cuentas> cuentasBanco(int id) {
		Query query = manager.createQuery("FROM Cuentas c WHERE c.banco.id = :parameter");
		query.setParameter("parameter",id);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuentas> cuentasCliente(String dni) {
		Query query = manager.createQuery("FROM Cuentas c WHERE c.cliente.id = :parameter");
		query.setParameter("parameter",dni);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> clientesYcuentas() {
		
		Query q = manager.createNativeQuery("SELECT CLIENTES.nombre, CUENTAS.id, CUENTAS.saldo "
										  + "FROM EJ_BANCOS.CLIENTES,EJ_BANCOS.CUENTAS "
										  + "WHERE CUENTAS.dnicliente = CLIENTES.dni");
		List<Object[]> authors = q.getResultList();
		for (Object[] a : authors) {
			System.out.println("Cliente: "
			+ a[0]
			+ " id.Cuenta: "
			+ a[1]
			+ " saldo de cuenta: "
			+ a[2]
			);
		}
		
		return authors;
	}
	
	public void create(Cuentas cuentas) throws Exception {
		
		manager.getTransaction().begin(); 
		manager.persist(cuentas);
		manager.getTransaction().commit();
		
	}

	
	public Cuentas read(int id) throws Exception {
		return manager.find(Cuentas.class, id);
	}

	
	public void update(Cuentas cuentas) throws Exception {
		
		manager.getTransaction().begin(); 
		manager.merge(cuentas);
		manager.getTransaction().commit();
		
		
	}


	public void delete(int id) throws Exception {
		
		Cuentas delCuentas = read(id);
		manager.getTransaction().begin(); 
		manager.remove(delCuentas);
		manager.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuentas> findAll() {
		
		Query query = manager.createQuery("FROM Cuentas");
		return query.getResultList();
		
	}
	

}

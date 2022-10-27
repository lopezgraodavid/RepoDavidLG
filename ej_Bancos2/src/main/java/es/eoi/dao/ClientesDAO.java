package es.eoi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.eoi.entity.Clientes;
import es.eoi.entity.Cuentas;


public class ClientesDAO {
	private EntityManager manager = Persistence.createEntityManagerFactory("Ej_Bancos").createEntityManager();
	
	

	
	public void create(Clientes clientes) throws Exception {
		
		manager.getTransaction().begin(); 
		manager.persist(clientes);
		manager.getTransaction().commit();
		
	}

	
	public Clientes read(String i) throws Exception {
		return manager.find(Clientes.class, i);
	}

	
	public void update(Clientes clientes) throws Exception {
		
		manager.getTransaction().begin(); 
		manager.merge(clientes);
		manager.getTransaction().commit();
		
		
	}


	public void delete(String id) throws Exception {
		
		Clientes delClientes = read(id);
		manager.getTransaction().begin(); 
		manager.remove(delClientes);
		manager.getTransaction().commit();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Clientes> findAll() {
		
		Query query = manager.createQuery("FROM Clientes");
		return query.getResultList();
		
	}
	
	
	
	
	
}

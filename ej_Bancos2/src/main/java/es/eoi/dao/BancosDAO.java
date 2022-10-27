package es.eoi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.eoi.entity.Bancos;


public class BancosDAO {

	private EntityManager manager = Persistence.createEntityManagerFactory("Ej_Bancos").createEntityManager();
	
	
	public void create(Bancos bancos) throws Exception {
		
		manager.getTransaction().begin(); 
		manager.persist(bancos);
		manager.getTransaction().commit();
		
	}

	
	public Bancos read(int id) throws Exception {
		return manager.find(Bancos.class, id);
	}

	
	public void update(Bancos bancos) throws Exception {
		
		manager.getTransaction().begin(); 
		manager.merge(bancos);
		manager.getTransaction().commit();
		
		
	}


	public void delete(int id) throws Exception {
		
		Bancos delBancos = read(id);
		manager.getTransaction().begin(); 
		manager.remove(delBancos);
		manager.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Bancos> findAll() {
		
		Query query = manager.createQuery("FROM Bancos");
		return query.getResultList();
		
	}
	
	
}

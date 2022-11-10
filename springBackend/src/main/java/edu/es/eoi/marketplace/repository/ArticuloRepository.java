package edu.es.eoi.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.es.eoi.marketplace.entity.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{

	@Query(value = "SELECT * FROM ARTICULO WHERE ARTICULO.nombre LIKE %?%", nativeQuery = true)
	List<Articulo> findByNombre(String nombre);
	
}

package edu.es.eoi.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.es.eoi.marketplace.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer>{
	
	@Query(value = "SELECT * FROM PEDIDO WHERE PEDIDO.nombre LIKE %?1%", nativeQuery = true)
	List<Pedido> findByNombre(String nombre);

}

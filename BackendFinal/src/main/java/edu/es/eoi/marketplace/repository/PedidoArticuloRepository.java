package edu.es.eoi.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.eoi.marketplace.entity.Pedido;
import edu.es.eoi.marketplace.entity.PedidoArticulo;

@Repository
public interface PedidoArticuloRepository extends JpaRepository<PedidoArticulo,Integer>{

	List<PedidoArticulo> findByPedido(Pedido pedido);
}

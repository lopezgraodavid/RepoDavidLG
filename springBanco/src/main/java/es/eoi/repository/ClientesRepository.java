package es.eoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.eoi.entity.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, String>{

}

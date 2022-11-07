package es.eoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.eoi.entity.Bancos;

@Repository
public interface BancosRepository extends JpaRepository<Bancos, Integer>{

}

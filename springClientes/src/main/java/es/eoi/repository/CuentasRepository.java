package es.eoi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.eoi.entity.Cuentas;

@Repository
public interface CuentasRepository extends JpaRepository<Cuentas, Integer>{

}

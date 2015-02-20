package es.sanitas.hos.mayhem.persistence.repositories.comunes;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sanitas.hos.mayhem.persistence.entities.comunes.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

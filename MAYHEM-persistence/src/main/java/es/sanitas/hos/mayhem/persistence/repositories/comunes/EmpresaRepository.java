package es.sanitas.hos.mayhem.persistence.repositories.comunes;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sanitas.hos.mayhem.persistence.entities.comunes.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}

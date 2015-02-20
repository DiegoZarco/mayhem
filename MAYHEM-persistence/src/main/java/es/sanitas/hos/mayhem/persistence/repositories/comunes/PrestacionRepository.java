package es.sanitas.hos.mayhem.persistence.repositories.comunes;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sanitas.hos.mayhem.persistence.entities.comunes.Prestacion;

public interface PrestacionRepository extends JpaRepository<Prestacion, Long>{

}

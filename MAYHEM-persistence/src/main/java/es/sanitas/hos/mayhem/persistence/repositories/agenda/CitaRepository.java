package es.sanitas.hos.mayhem.persistence.repositories.agenda;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sanitas.hos.mayhem.persistence.entities.agenda.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long>{

}

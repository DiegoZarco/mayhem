package es.sanitas.hos.mayhem.persistence.repositories.agenda;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.sanitas.hos.mayhem.persistence.entities.agenda.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{
	
	@Query("SELECT a FROM Agenda a where a.proveedor.id = :proveedor and a.fecha = :fecha")
	Agenda recuperarAgenda(@Param("proveedor") Long proveedor, @Param("fecha") Date fecha);
	
	
	@Query("SELECT a FROM Agenda a where a.proveedor.id = :proveedor")
	List<Agenda> recuperarAgendasProveedor(@Param("proveedor") Long proveedor);

}

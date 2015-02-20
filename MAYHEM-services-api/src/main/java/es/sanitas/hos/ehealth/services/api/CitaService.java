package es.sanitas.hos.ehealth.services.api;

import java.util.List;

import es.sanitas.hos.ehealth.services.api.vo.agenda.CitaVO;

/**
 * Interface que proporciona funcionalidad para realizar con la cita
 * @author DIEGO
 *
 */
public interface CitaService {
	
	/**
	 * Guarda una cita dada
	 * @param cita
	 */
	void guardarCita(final CitaVO cita);
	
	/**
	 * Recupera todas las citas asociadas a un cliente
	 * @param idCliente
	 * @return
	 */
	List<CitaVO> recuperarCitasPorCliente(final Long idCliente);

}

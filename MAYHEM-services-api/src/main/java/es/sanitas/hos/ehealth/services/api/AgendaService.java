package es.sanitas.hos.ehealth.services.api;

import java.util.Date;
import java.util.List;

import es.sanitas.hos.ehealth.services.api.vo.CrearAgendaVO;
import es.sanitas.hos.ehealth.services.api.vo.agenda.AgendaVO;

/**
 * Servicio para la entidad Agenda que proporciona la funcionalidad sobre dicho
 * recurso
 * 
 * @author DIEGO
 * 
 */
public interface AgendaService {

	/**
	 * Metodo que genera agendas para una serie de criterios pasados en el objeto CrearAgendaVO
	 * @param vo
	 */
	void generarAgendas(final CrearAgendaVO vo);
	
	/**
	 * Recupera las agendas de una persona para una fecha dada
	 * @param proveedor
	 * @param fecha
	 * @return Agenda
	 */
	AgendaVO recuperarAgenda(final Long proveedor, final Date fecha);
	
	/**
	 * Recupera las agendas de un proveedor 
	 * @param proveedor
	 * @return
	 */
	List<AgendaVO> recuperarAgendasProveedor(final Long proveedor);
}

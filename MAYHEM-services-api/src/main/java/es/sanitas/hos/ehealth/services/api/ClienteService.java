package es.sanitas.hos.ehealth.services.api;

import java.util.List;

import es.sanitas.hos.ehealth.services.api.vo.comunes.ClienteVO;

public interface ClienteService {
	
	void guardarCliente(final ClienteVO cliente);
	
	void actualizarCliente(final ClienteVO cliente);
	
	ClienteVO findById(final Long idCliente);
	
	List<ClienteVO> findAll();

}

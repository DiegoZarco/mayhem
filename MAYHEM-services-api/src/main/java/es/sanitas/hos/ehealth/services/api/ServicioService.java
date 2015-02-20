package es.sanitas.hos.ehealth.services.api;

import java.util.List;

import es.sanitas.hos.ehealth.services.api.vo.comunes.ServicioVO;

public interface ServicioService {

	ServicioVO findById(final Long id);
	
	List<ServicioVO> findAll();
}

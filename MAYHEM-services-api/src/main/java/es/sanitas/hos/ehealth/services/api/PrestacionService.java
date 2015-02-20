package es.sanitas.hos.ehealth.services.api;

import es.sanitas.hos.ehealth.services.api.vo.comunes.PrestacionVO;

public interface PrestacionService {

	PrestacionVO findById(final Long id);
	
	void save(final PrestacionVO vo);
}

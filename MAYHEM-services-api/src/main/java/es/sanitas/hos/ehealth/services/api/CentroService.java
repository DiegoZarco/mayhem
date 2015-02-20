package es.sanitas.hos.ehealth.services.api;

import es.sanitas.hos.ehealth.services.api.vo.comunes.CentroVO;

public interface CentroService {

	void guardarCentro(final CentroVO centro);
	
	CentroVO findById(final Long idCentro);
}

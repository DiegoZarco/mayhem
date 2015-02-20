package es.sanitas.hos.ehealth.services.api;

import es.sanitas.hos.ehealth.services.api.vo.comunes.ProveedorVO;

public interface ProveedorService {

	ProveedorVO findById(final Long id);
	
	void save(final ProveedorVO proveedor);
}

package es.sanitas.hos.ehealth.services.api;

import es.sanitas.hos.ehealth.services.api.vo.comunes.EmpresaVO;

public interface EmpresaService {
	
	void guardarEmpresa(final EmpresaVO empresa);
	
	EmpresaVO findById(final Long idEmpresa);
	
}
